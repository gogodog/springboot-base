package com.cott.bootbase.tools.pingyin;

import org.thymeleaf.util.StringUtils;

import net.sourceforge.pinyin4j.PinyinHelper;

/**
 * 拼音工具类
 * 
 * @author ZENG.XIAO.YAN
 * @date 2018年5月9日
 * 
 */
public class PinYinUtils {
	/**
	 * 获取汉字首字母的方法。如： 张三 --> ZS 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
	 * 
	 * @param hanzi汉子字符串
	 * @return 大写汉子首字母; 如果都转换失败,那么返回null
	 */
	public static String getHanziInitials(String hanzi) {
		return getHanziPinYin(hanzi, true);
	}

	/**
	 * 获取汉字拼音的方法。如： 张三 --> zhangsan 说明：暂时解决不了多音字的问题，只能使用取多音字的第一个音的方案
	 * 
	 * @param hanzi汉子字符串
	 * @return 汉字拼音; 如果都转换失败,那么返回null
	 */
	public static String getHanziPinYin(String hanzi) {
		return getHanziPinYin(hanzi, false);
	}

	private static String getHanziPinYin(String hanzi, boolean isInitials) {
		if (StringUtils.isEmptyOrWhitespace(hanzi))
			return null;
		StringBuffer sb = new StringBuffer();
		for (char ch : hanzi.toCharArray()) {
			sb.append(getWord(ch, isInitials));
		}
		String name = sb.toString();
		return StringUtils.isEmptyOrWhitespace(name) ? hanzi : name;
	}

	private static String getWord(char ch, boolean isInitials) {
		String[] stringArray = PinyinHelper.toHanyuPinyinStringArray(ch);
		if(stringArray == null || stringArray.length == 0)
			return "";
		return isInitials ? stringArray[0].charAt(0) + "" : stringArray[0].replaceAll("\\d", "");
	}
	
	public static void main(String[] args) {
		System.out.println(getHanziPinYin("prescott"));
	}

}