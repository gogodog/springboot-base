package com.cott.bootbase.threadpool;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 构建了一个消息队列
 * 
 * 这个消息队列声明为静态的不回收，
 * 所以可以做到多线程内存可用
 * @author jiadong.wen
 *
 */
public class MessageQueue {
	public static final Queue<String> mesages = new LinkedBlockingQueue<>();
}
