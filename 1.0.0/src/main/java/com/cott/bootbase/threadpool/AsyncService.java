package com.cott.bootbase.threadpool;

import java.util.List;

/**
 * 执行异步任务
 * @author jiadong.wen
 *
 */
public interface AsyncService {

	/**
	 * 执行异步方法，讲消息进行组装放入内存队列
	 * @param text
	 * @param time
	 */
	void executeAsync(String msg, Long time);

	/**
	 * 获取内存队列中的消息
	 * @return
	 */
	List<String> getMesages();

}
