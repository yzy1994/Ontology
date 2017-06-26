package edu.shu.yzy.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesUtil {

	public static String getValue(String filepath , String key) {
		Properties prop = new Properties();
		InputStream in = new PropertiesUtil().getClass().getResourceAsStream(filepath);
		try {
			prop.load(in);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}
	
	public static String getNextAndPrevious(int page,int pageSize,int totalPage,String url,String ontname){
		StringBuffer result = new StringBuffer();
		result.append("<ul class='pager'>");
		if(page==1){
			result.append("<li class='disabled'><a href='#'>Previous</a></li>");
		}else{
			result.append("<li><a href="+ url + "?ontname=" + ontname + "&page=" + (page-1) + ">Previous</a></li>");			
		}
		result.append("&nbsp;&nbsp;");
		if(page == totalPage){
			result.append("<li class='disabled'><a href='#'>Next</a></li>");
		}else{
			result.append("<li><a href="+ url + "?ontname=" + ontname + "&page=" + (page+1) + ">Next</a></li>");			
		}
		result.append("</ul>");
		
		return result.toString();
	}
}
