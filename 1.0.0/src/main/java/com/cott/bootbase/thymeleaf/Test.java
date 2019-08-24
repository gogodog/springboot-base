package com.cott.bootbase.thymeleaf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.util.StringUtils;

import com.cott.bootbase.tools.pingyin.PinYinUtils;

/**
 * 测试thymeleaf组件
 * @author jiadong.wen
 *
 */
@Controller
public class Test {
	
	private static final Logger logs = LoggerFactory.getLogger(Test.class);
	
	@Value("${bootbase.welcom}")
	public String s;
	
	@GetMapping("/index")
	public String visitIndex(Model model, String name){
		logs.info("hello {} , welcome to boot-base !", name);
		name = PinYinUtils.getHanziPinYin(name);
		model.addAttribute("greet", StringUtils.isEmptyOrWhitespace(name) ? s : String.format("hello %s , welcome to boot-base !", name) );
		return "thymeleaf";
	}

}
