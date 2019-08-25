package com.cott.bootbase.threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/threadPool")
public class TestThreadPool {
	private static final Logger logger = LoggerFactory.getLogger(TestThreadPool.class);

    @Autowired
    private AsyncService asyncService;
    
    @GetMapping("/kit")
    public String visit(){
        return "/kit/threadpool";
    }

    /**
     * 启动一个线程
     * @param msg
     * @param time
     * @return
     */
    @GetMapping("/startThread")
    @ResponseBody
    public Object threadPool(String msg, Long time){
        logger.info("start submit {}" , msg);
        asyncService.executeAsync(msg, time);
        logger.info("end submit {}" , msg);
        return "success:" + msg;
    }
    
    /**
     * 获取数据队列里的数据
     * @return
     */
    @GetMapping("/getMesages")
    @ResponseBody
    public Object getMesages(){
        return asyncService.getMesages();
    }
}
