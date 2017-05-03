package com.shu.sil.eo.buildont.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.dom4j.DocumentException;
import org.springframework.stereotype.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionSupport;
import com.shu.sil.eo.buildont.pojo.EventCls;
import com.shu.sil.eo.buildont.pojo.OntInfo;
import com.shu.sil.eo.buildont.pojo.Time;
import com.shu.sil.eo.buildont.util.JsonUtil;
import com.shu.sil.eo.util.XmlUtil;

@Controller("eveOntAction")
public class EveOntAction extends ActionSupport {
	private String preFilePath = "buildont/";
	private String postFilePath = ".xml";
	String ontInfoPath = "OntInfo";
	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	public String eventClsJson;
	private String ontInfoListStr;
	private String ecn;
	private String fieldType;
	private String ontType;
	private String state;

	public String getEventClsJson() {
		return eventClsJson;
	}

	public void setEventClsJson(String eventClsJson) {
		this.eventClsJson = eventClsJson;
	}

	public String getOntInfoListStr() {
		return ontInfoListStr;
	}

	public void setOntInfoListStr(String ontInfoListStr) {
		this.ontInfoListStr = ontInfoListStr;
	}

	public String getEcn() {
		return ecn;
	}

	public void setEcn(String ecn) {
		this.ecn = ecn;
	}

	public String getFieldType() {
		return fieldType;
	}

	public void setFieldType(String fieldType) {
		this.fieldType = fieldType;
	}

	public String getOntType() {
		return ontType;
	}

	public void setOntType(String ontType) {
		this.ontType = ontType;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String saveCls() throws Exception {

		EventCls eventCls = gsonTemp.fromJson(this.eventClsJson,
				new TypeToken<EventCls>() {
				}.getType());
		List eclsList = new ArrayList<EventCls>();
		eclsList.add(eventCls);
		String midFilePath = eventCls.getEcn();
		String filePath =  preFilePath + midFilePath + postFilePath;
		try {
			XmlUtil.multiWrite(eclsList, filePath);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(state.equals("add")){
		String filePath2 = "buildont/OntInfo.xml";
		String nodeName = "eventCls";
		OntInfo ontInfo = new OntInfo();
		ontInfo.setEid(eventCls.getEid());
		ontInfo.setEcn(eventCls.getEcn());
		Date date = new Date();
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String time = format.format(date);
		ontInfo.setCreatTime(time);
		ontInfo.setAuthor("zhangyajun");
		XmlUtil.insertXMLNode(filePath2, nodeName, ontInfo, fieldType, ontType);}
		return SUCCESS;
	}

	// action里面的get和set方法都是自动执行的。。。你改下方法名字就行了。。。
	public String searchOntInfo() {
		System.out.println("save" + eventClsJson + "fieldType" + fieldType
				+ "ontType" + ontType);
		String filePath = "buildont/OntInfo.xml";
		String nodeName = "eventCls";
		String className = "com.shu.sil.eo.buildont.pojo.OntInfo";
		List ontInfoList = null;
		try {
			ontInfoList = XmlUtil.analyzeXml(filePath, nodeName, className,
					fieldType, ontType);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ontInfoListStr = gsonTemp.toJson(ontInfoList);
		System.out.println(ontInfoListStr);
		return SUCCESS;
	}

	public String searchClsByEcn() throws ClassNotFoundException,
			InstantiationException, IllegalAccessException,
			NoSuchMethodException, InvocationTargetException,
			DocumentException, ParseException {
		System.out.println("searchClsByEcn" + ecn);
		String nodeName = "EventCls";
		String className = "com.shu.sil.eo.buildont.pojo.EventCls";
		List eventClsList = XmlUtil.analyzeXml(
				 preFilePath + ecn + postFilePath, nodeName, className);
		this.eventClsJson = gsonTemp.toJson(eventClsList.get(0));
		return SUCCESS;
	}

	public String removeClsByEcn() throws IOException {
		System.out.println("删除的是" + ecn);
		XmlUtil.removeXML( preFilePath + ecn + postFilePath);
		XmlUtil.removeXMLNode(preFilePath + ontInfoPath + postFilePath, "ecn",
				ecn);
		this.searchOntInfo();
		return SUCCESS;
	}

}
