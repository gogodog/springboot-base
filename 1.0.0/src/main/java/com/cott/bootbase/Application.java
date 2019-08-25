package com.cott.bootbase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 启动类
 * @author jiadong.wen
 *
 */
@SpringBootApplication
@Controller
public class Application {
	
	private static final Logger logs = LoggerFactory.getLogger(Application.class);

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		logs.info("启动成功");
	}
	
	@GetMapping("/")
	public String index(){
		return "indexs";
	}

}
