package com.shu.sil.eo.buildont.action;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.dom4j.DocumentException;

import com.shu.sil.eo.buildont.pojo.Action;
import com.shu.sil.eo.buildont.pojo.Assert;
import com.shu.sil.eo.buildont.pojo.Environ;
import com.shu.sil.eo.buildont.pojo.EventCls;
import com.shu.sil.eo.buildont.pojo.Lang;
import com.shu.sil.eo.buildont.pojo.Obj;
import com.shu.sil.eo.buildont.pojo.OntInfo;
import com.shu.sil.eo.buildont.pojo.Time;
import com.shu.sil.eo.buildont.util.JdomUtil;
import com.shu.sil.eo.util.XmlUtil;

public class testXml {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		// EventCls ecls=new EventCls();
		// ecls.setEid("1sw");
		// ecls.setEcn("zhongguo");
		// ecls.setEts("sdfasf,dsaf,ssfsaf");
		// Obj obj1=new Obj();
		// obj1.setEon("o1");
		// obj1.setEtds("人类,动物");
		// obj1.setFnv("asfsf");
		// obj1.setGramRoleType("subject");
		// obj1.setObjType("part");
		// obj1.setNote("zhongguo");
		// obj1.setId(Long.valueOf("1000"));
		//
		// Obj obj2=new Obj();
		// obj2.setEon("o2");
		// obj2.setEtds("人类,动物");
		// obj2.setFnv("asfsf");
		// obj2.setGramRoleType("subject");
		// obj2.setObjType("part");
		// obj2.setNote("zhongguo");
		// obj2.setId(Long.valueOf("1000"));
		// List<Obj> objList = new ArrayList<Obj>();
		// objList.add(obj1);
		// objList.add(obj2);
		// ecls.setObjList(objList);
		//
		// Action ac1=new Action();
		// ac1.setAecfn(Long.valueOf("100"));
		// ac1.setAecrn(Long.valueOf("30"));
		// ac1.setAecrnType("sfsaf");
		// ac1.setEcn("地震");
		// ac1.setId(Long.valueOf("130"));
		// ac1.setNote("note");
		// Action ac2=new Action();
		// ac2.setAecfn(Long.valueOf("1000"));
		// ac2.setAecrn(Long.valueOf("306"));
		// ac2.setAecrnType("sfsaf");
		// ac2.setEcn("地震");
		// ac2.setId(Long.valueOf("190"));
		// ac2.setNote("note");
		// List<Action> actionList = new ArrayList<Action>();
		// actionList.add(ac1);
		// actionList.add(ac2);
		// ecls.setActionList(actionList);
		//
		// Assert assert1=new Assert();
		// assert1.setId(Long.valueOf("233"));
		// assert1.setAtype("sfasf");
		// assert1.setEcn("sdfsdafsa");
		// assert1.setEon("safs");
		// assert1.setState("fasf");
		// assert1.setNote("sdfasf");
		// Assert assert2=new Assert();
		// assert2.setId(Long.valueOf("283"));
		// assert2.setAtype("sfasf");
		// assert2.setEcn("sdfsdafsa");
		// assert2.setEon("safs");
		// assert2.setState("fasf");
		// assert2.setNote("sdfasf");
		// List<Assert> assertList = new ArrayList<Assert>();
		// assertList.add(assert1);
		// assertList.add(assert2);
		// ecls.setAssertList(assertList);
		//
		// Lang lang1=new Lang();
		// lang1.setId(Long.valueOf("888"));
		// lang1.setArg1("dfasf");
		// lang1.setArg1value("sdafsadf");
		// lang1.setArg2("sdafsadf");
		// lang1.setArg2value("dfasf");
		// lang1.setLangtype("sdfsf");
		// lang1.setNote("sdfasf");
		// Lang lang2=new Lang();
		// lang2.setId(Long.valueOf("988"));
		// lang2.setArg1("dfasf");
		// lang2.setArg1value("sdafsadf");
		// lang2.setArg2("sdafsadf");
		// lang2.setArg2value("dfasf");
		// lang2.setLangtype("sdfsf");
		// lang2.setNote("sdfasf");
		//
		// List<Lang> langList = new ArrayList<Lang>();
		// langList.add(lang1);
		// langList.add(lang2);
		// ecls.setLangList(langList);
		//
		//
		// Time time=new Time();
		// time.setTimeType("afasf");
		//
		// Environ environ=new Environ();
		// environ.setEnvType("sdfasf");
		// environ.setEts("sdfafff");
		//
		// ecls.setTime(time);
		// ecls.setEnviron(environ);
		//
		// List eclsList=new ArrayList<EventCls>();
		// eclsList.add(ecls);
		// String filePath= "buildont/ssssEventCls.xml";
		// try {
		// XmlUtil.multiWrite(eclsList, filePath);
		// } catch (Exception e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }
		// String filePath= "buildont/OntInfo.xml";
		// String nodeName="eventCls";
		// String className="com.di.zeus.buildont.pojo.OntInfo";
		// List ontInfoList=XmlUtil.analyzeXml(filePath, nodeName, className);
		// System.out.println(ontInfoList.size());
		// JdomUtil.queryElementByXPath();

		// String filePath= "buildont/交通事故.xml";
		String nodeName = "eventCls";
		String className = "com.di.zeus.buildont.pojo.EventCls";
		// List ontInfoList=XmlUtil.analyzeXml(filePath, nodeName, className);
		// System.out.println(ontInfoList);
		String preFilePath = "buildont/";
		String postFilePath = ".xml";
		String ontInfoPath = "OntInfo";
		String ecn = "交通事故";
		XmlUtil.removeXML(preFilePath + ecn + postFilePath);
		XmlUtil.removeXMLNode(preFilePath + ontInfoPath + postFilePath, "ecn",
				ecn);

//		XmlUtil.analyzeXml(preFilePath + ontInfoPath + postFilePath, nodeName,
//				className, "emergency", "event");
		OntInfo ontInfo=new OntInfo();
		ontInfo.setEid("sdfsa");
		ontInfo.setEcn("dsfaff");
		ontInfo.setCreatTime("fsafdf");
		ontInfo.setAuthor("zhangyajun");
		XmlUtil.insertXMLNode(preFilePath + ontInfoPath + postFilePath, ontInfo, "emergency", "event");
		
	}

}
