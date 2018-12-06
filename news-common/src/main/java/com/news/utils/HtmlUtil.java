package com.news.utils;

import java.util.regex.Matcher;

import java.util.regex.*;



public class HtmlUtil {
	
	 private static final String regEx_script = "<script[^>]*?>[\\s\\S]*?<\\/script>"; // 定义script的正则表达式
	    private static final String regEx_style = "<style[^>]*?>[\\s\\S]*?<\\/style>"; // 定义style的正则表达式
	    private static final String regEx_html = "<[^>]+>"; // 定义HTML标签的正则表达式
	    private static final String regEx_space = "\\s*|\t|\r|\n";//定义空格回车换行符
	       
	    /**
	     * @param htmlStr
	     * @return
	     *  删除Html标签
	     */
	    public static String delHTMLTag(String htmlStr) {
	        Pattern p_script = Pattern.compile(regEx_script, Pattern.CASE_INSENSITIVE);
	        Matcher m_script = p_script.matcher(htmlStr);
	        htmlStr = m_script.replaceAll(""); // 过滤script标签
	   
	        Pattern p_style = Pattern.compile(regEx_style, Pattern.CASE_INSENSITIVE);
	        Matcher m_style = p_style.matcher(htmlStr);
	        htmlStr = m_style.replaceAll(""); // 过滤style标签
	   
	        Pattern p_html = Pattern.compile(regEx_html, Pattern.CASE_INSENSITIVE);
	        Matcher m_html = p_html.matcher(htmlStr);
	        htmlStr = m_html.replaceAll(""); // 过滤html标签
	   
	        Pattern p_space = Pattern.compile(regEx_space, Pattern.CASE_INSENSITIVE);
	        Matcher m_space = p_space.matcher(htmlStr);
	        htmlStr = m_space.replaceAll(""); // 过滤空格回车标签
	        return htmlStr.trim(); // 返回文本字符串
	    }
	       
	    public static String getTextFromHtml(String htmlStr){
	        htmlStr = delHTMLTag(htmlStr);
	        htmlStr = htmlStr.replaceAll("&nbsp;", "");
//	        htmlStr = htmlStr.substring(0, htmlStr.indexOf("。")+1);
	        return htmlStr;
	    }

	public static String[] getImgs(String content) {
		String img = "";
		Pattern p_image;
		Matcher m_image;
		String str = "";
		String[] images = null;
		String regEx_img = "(<img.*src\\s*=\\s*(.*?)[^>]*?>)";
		p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
		m_image = p_image.matcher(content);
		while (m_image.find()) {
			img = m_image.group();
			Matcher m = Pattern.compile("src\\s*=\\s*\"?(.*?)(\"|>|\\s+)").matcher(img);
			while (m.find()) {
				String tempSelected = m.group(1);

				if ("".equals(str)) {
					str = tempSelected;
				} else {
					String temp = tempSelected;
					str = str + "," + temp;
				}
			}
		}
		if (!"".equals(str)) {
			images = str.split(",");
		}
		return images;
	}

}
