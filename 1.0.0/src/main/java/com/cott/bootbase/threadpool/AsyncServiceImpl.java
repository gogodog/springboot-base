package com.cott.bootbase.threadpool;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * 任务执行类
 * @author jiadong.wen
 *
 */
@Service
public class AsyncServiceImpl implements AsyncService {

    private static final Logger logger = LoggerFactory.getLogger(AsyncServiceImpl.class);

    /**
     * 你每次会赋值两个入参，分别是消息和时间
     * 这个方法会在你配置的间隔时间前后放置两条消息
     * 分别是
     * 1：[你的时间入参]startTime[启动系统时间]msg[你的消息入参]
     * 
     * 等待时间（你的时间入参，系统做了限定，如果小于0秒或者大于30秒 默认为3秒）
     * 
     * 2：[你的时间入参]finihTime[结束系统时间]msg[你的消息入参]
     * 备注：不是写错单词了，是希望消息体一样长，好看也好找。哈哈
     * 
     * 
     * 
     */
    @Override
    @Async("asyncServiceExecutor")
    public void executeAsync(String msg, Long time) {
        logger.info("start executeAsync ： {}", msg);
        try{
        	time = checkTime(time);
        	MessageQueue.mesages.add("["+time+"s]startTime["+System.currentTimeMillis()+"]msg["+msg+"]");
            Thread.sleep(time*1000);
            MessageQueue.mesages.add("["+time+"s]finihTime["+System.currentTimeMillis()+"]msg["+msg+"]");
        }catch(Exception e){
            e.printStackTrace();
        }
        logger.info("end executeAsync ： {}", msg);
    }

	private long checkTime(Long time) {
		return time == null || time <= 0 ||time >= 30 ? 3 : time;
	}

	@Override
	public List<String> getMesages() {
		List<String> mesages = new ArrayList<>();
		int count = 0;
		while(10 > count++){
			String msg = MessageQueue.mesages.poll();
			if(msg != null){
				mesages.add(msg);
				System.out.println(msg);				
			}else
				break;
		}
		return mesages;
	}
}
