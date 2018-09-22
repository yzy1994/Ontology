package com.shu.sil.eo.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.ParameterizedType;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.Number;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

import com.shu.sil.eo.buildont.pojo.OntInfo;
import com.shu.sil.eo.buildont.util.JdomUtil;
import com.shu.sil.eo.util.ERutil;

public class XmlUtil {
	public static void multiWrite(List list, String filePath) throws Exception {
		XMLWriter writer = null;// 声明写XML的对象
		SAXReader reader = new SAXReader();

		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");// 设置XML文件的编码格式
		File file = new File(filePath);

		Object obj = list.get(0);
		String className = obj.getClass().getName();

		Document document = DocumentHelper.createDocument();
		Element root = document.addElement("root");
		root.addAttribute("className", className);
		createXMl(list, root);

		writer = new XMLWriter(new FileWriter(file), format);
		writer.write(document);
		writer.close();
	}

	public static void createXMl(List list, Element root) throws Exception {
		if (list.size() > 0) {
			Object obj = list.get(0);
			Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(obj.getClass());
			for (int i = 0; i < list.size(); i++) {
				Object objTemp = list.get(i);
				Element element = root.addElement(obj.getClass().getSimpleName());
				for (int j = 0; j < fieldAllArray.length; j++) {
					Field tempField = fieldAllArray[j];
					Object value = BaseReflectUtils.invokeGetMethod(objTemp, tempField, null);
					if (value != null && !value.toString().equals("")) {
						String type = tempField.getType().getName();
						String prefixType = type.substring(0, 3);
						// System.out.println(prefixType);
						if (type.equals("java.util.List")) {
							List tempList = (List) value;
							XmlUtil.createXMl(tempList, element);
						} else if (prefixType.equals("com")) {

							Element element2 = element.addElement(value.getClass().getSimpleName());

							Field fieldAllArray2[] = BaseReflectUtils.getAllFieldFromClass(value.getClass());
							for (int k = 0; k < fieldAllArray2.length; k++) {
								Field tempField2 = fieldAllArray2[k];
								Object value2 = BaseReflectUtils.invokeGetMethod(value, tempField2, null);
								if (value2 != null && !value2.toString().equals("")) {
									String type2 = tempField2.getType().getName();
									Element tempElement2 = element2.addElement(tempField2.getName());
									tempElement2.setText(value2.toString());
								}
							}
						} else {
							Element tempElement = element.addElement(tempField.getName());
							tempElement.setText(value.toString());
						}
					}
				}
			}
		}
	}

	public static void createXMl(List list, Element root, String nodeName) throws Exception {
		if (list.size() > 0) {
			Object obj = list.get(0);
			Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(obj.getClass());
			for (int i = 0; i < list.size(); i++) {
				Object objTemp = list.get(i);
				Element element = root.addElement(nodeName);
				for (int j = 0; j < fieldAllArray.length; j++) {
					Field tempField = fieldAllArray[j];
					Object value = BaseReflectUtils.invokeGetMethod(objTemp, tempField, null);
					if (value != null && !value.toString().equals("")) {
						String type = tempField.getType().getName();
						String prefixType = type.substring(0, 3);
						// System.out.println(prefixType);
						if (type.equals("java.util.List")) {
							List tempList = (List) value;
							XmlUtil.createXMl(tempList, element);
						} else if (prefixType.equals("com")) {

							Element element2 = element.addElement(value.getClass().getSimpleName());

							Field fieldAllArray2[] = BaseReflectUtils.getAllFieldFromClass(value.getClass());
							for (int k = 0; k < fieldAllArray2.length; k++) {
								Field tempField2 = fieldAllArray2[k];
								Object value2 = BaseReflectUtils.invokeGetMethod(value, tempField2, null);
								if (value2 != null && !value2.toString().equals("")) {
									String type2 = tempField2.getType().getName();
									Element tempElement2 = element2.addElement(tempField2.getName());
									tempElement2.setText(value2.toString());
								}
							}
						} else {
							Element tempElement = element.addElement(tempField.getName());
							tempElement.setText(value.toString());
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws Exception {
		String filePath = "E:\\EventEntity.xls";
		// PartiEntity p1 = new PartiEntity();
		// p1.setPartiEntityName("p1");
		// p1.setNumber(1);
		//
		// PartiEntity p2 = new PartiEntity();
		// p2.setPartiEntityName("p2");
		// p2.setNumber(2);
		//
		// PartiEntity p3 = new PartiEntity();
		// p3.setPartiEntityName("p3");
		// p3.setNumber(3);
		//
		// PartiEntity p4 = new PartiEntity();
		// p4.setPartiEntityName("p4");
		// p4.setNumber(4);
		//
		List partiClassList = new ArrayList();
		//
		// PartiClass partiModle = new PartiClass();
		// partiModle.setPartiClassName("sfsfasf");
		// partiModle.getPartiEntityList().add(p1);
		// partiModle.getPartiEntityList().add(p2);
		// PartiClass partiModle2 = new PartiClass();
		// partiModle2.setPartiClassName("kkkk");
		//
		// partiModle2.getPartiEntityList().add(p3);
		// partiModle2.getPartiEntityList().add(p4);
		//
		// partiModleList.add(partiModle);
		// partiModleList.add(partiModle2);
		partiClassList = XmlUtil.xls2String(filePath, "com.eo.eventclass.ethqk2.EventClass");

		String filePath2 = "D:\\EventClass.xml";
		XmlUtil.multiWrite(partiClassList, filePath2);

		// XmlUtil.analyzeXml(filePath);

		// System.out.print("ddddddddddddddd");

		// try {
		// XMLWriter writer = null;// 声明写XML的对象
		// SAXReader reader = new SAXReader();
		//
		// OutputFormat format = OutputFormat.createPrettyPrint();
		// format.setEncoding("utf-8");// 设置XML文件的编码格式
		//
		// String filePath = "d:\\student.xml";
		// File file = new File(filePath);
		// if (file.exists()) {
		// Document document = reader.read(file);// 读取XML文件
		// Element root = document.getRootElement();// 得到根节点
		// boolean bl = false;
		// for (Iterator i = root.elementIterator("学生"); i.hasNext();) {
		// Element student = (Element) i.next();
		// if (student.attributeValue("sid").equals("001")) {
		// // 修改学生sid=001的学生信息
		// student.selectSingleNode("姓名").setText("王五");
		// student.selectSingleNode("年龄").setText("25");
		//
		// writer = new XMLWriter(new FileWriter(filePath), format);
		// writer.write(document);
		// writer.close();
		// bl = true;
		// break;
		// }
		// }
		// if (bl) {
		// // 添加一个学生信息
		// Element student = root.addElement("学生");
		// student.addAttribute("sid", "100");
		// Element sid = student.addElement("编号");
		// sid.setText("100");
		// Element name = student.addElement("姓名");
		// name.setText("嘎嘎");
		// Element sex = student.addElement("性别");
		// sex.setText("男");
		// Element age = student.addElement("年龄");
		// age.setText("21");
		// Element entityList = student.addElement("实例数");
		// entityList.addAttribute("num", "20");
		// Element entityList1 = entityList.addElement("实例1");
		// entityList1.setText("我是实例一");
		// writer = new XMLWriter(new FileWriter(filePath), format);
		// writer.write(document);
		// writer.close();
		// }
		// } else {
		// // 新建student.xml文件并新增内容
		// Document _document = DocumentHelper.createDocument();
		// Element _root = _document.addElement("学生信息");
		// Element _student = _root.addElement("学生");
		// _student.addAttribute("sid", "001");
		// Element _id = _student.addElement("编号");
		// _id.setText("001");
		// Element _name = _student.addElement("姓名");
		// _name.setText("灰机");
		// Element _age = _student.addElement("年龄");
		// _age.setText("18");
		//
		// writer = new XMLWriter(new FileWriter(file), format);
		// writer.write(_document);
		// writer.close();
		// }
		// System.out.println("操作结束! ");
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
	}

	public static List analyzeXml(String filePath, String nodeName, String className, String fieldType, String ontType)
			throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, ParseException, InvocationTargetException {
		List resultList = new ArrayList();
		String prefix = "//";
		List<Element> tempNodeList = ERutil.readXml(filePath, nodeName, fieldType, ontType);
		// List tempNodeList=JdomUtil.queryElementByXPath();
		System.out.println(tempNodeList.size());
		getObjectList(tempNodeList, resultList, className);
		return resultList;
	}

	public static List analyzeXml(String filePath, String nodeName, String className)
			throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, ParseException, InvocationTargetException {
		List resultList = new ArrayList();
		String prefix = "//";
		List<Element> tempNodeList = ERutil.readXml(filePath, prefix + nodeName);
		// List tempNodeList=JdomUtil.queryElementByXPath();
		System.out.println(tempNodeList.size());
		getObjectList(tempNodeList, resultList, className);
		return resultList;
	}

	public static List analyzeXml(String filePath)
			throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, ParseException, InvocationTargetException {
		String prefix = "//";
		String nodeName = "root";

		List<Element> nodeList = ERutil.readXml(filePath, prefix + nodeName);

		List resultList = new ArrayList();

		if (nodeList.size() > 0) {
			Element root = nodeList.get(0);
			String className = root.attributeValue("className");
			String simpleName = BaseReflectUtils.getSimpleName(className);
			List<Element> tempNodeList = ERutil.readXml(filePath, prefix + simpleName);

			getObjectList(tempNodeList, resultList, className);
		}
		return resultList;
	}

	public static void getObjectList(List<Element> tempNodeList, List resultList, String className)
			throws DocumentException, ClassNotFoundException, InstantiationException, IllegalAccessException,
			NoSuchMethodException, ParseException, InvocationTargetException {
		// String simpleName = BaseReflectUtils.getSimpleName(className);

		for (int i = 0; i < tempNodeList.size(); i++) {
			Element element = tempNodeList.get(i);

			Class tempClass = Class.forName(className);
			Object obj = tempClass.newInstance();
			Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(tempClass);

			for (int j = 0; j < fieldAllArray.length; j++) {

				Field tempField = fieldAllArray[j];
				String type = tempField.getType().getName();
				String prefixType = type.substring(0, 3);
				if (type.equals("java.util.List")) {
					ParameterizedType pType = (ParameterizedType) tempField.getGenericType();
					String entityType = pType.getActualTypeArguments()[0].getTypeName();
					String simpleName = BaseReflectUtils.getSimpleName(entityType);
					List<Element> nodeList1 = element.elements(simpleName);
					List resultList1 = new ArrayList();

					XmlUtil.getObjectList(nodeList1, resultList1, entityType);

					BaseReflectUtils.ivokeSetMethod(obj, tempField, resultList1);
				} else if (prefixType.equals("com")) {

					Class tempClass2 = Class.forName(type);

					String simpleName2 = BaseReflectUtils.getSimpleName(type);
					Element element2 = element.element(simpleName2);
					Object obj2 = tempClass2.newInstance();

					Field fieldAllArray2[] = BaseReflectUtils.getAllFieldFromClass(tempClass2);
					for (int k = 0; k < fieldAllArray2.length; k++) {
						Field tempField2 = fieldAllArray2[k];
						String value = element2.elementText(tempField2.getName());
						BaseReflectUtils.ivokeSetMethod(obj2, tempField2, value);
					}
					BaseReflectUtils.ivokeSetMethod(obj, tempField, obj2);
				} else {
					String value = element.elementText(tempField.getName());
					BaseReflectUtils.ivokeSetMethod(obj, tempField, value);
					// System.out.println(value);
				}
			}
			resultList.add(obj);
		}
	}

	public static List xls2String(String filePath, String className1) {
		File file = new File(filePath);
		List resultList = new ArrayList();
		try {
			FileInputStream fis = new FileInputStream(file);
			StringBuilder sb = new StringBuilder();
			jxl.Workbook rwb = Workbook.getWorkbook(fis);
			Sheet[] sheet = rwb.getSheets();
			for (int i = 0; i < sheet.length; i++) {
				Sheet rs = rwb.getSheet(i);
				for (int j = 1; j < rs.getRows(); j++) {
					System.out.println("Run" + j);
					Cell[] cells = rs.getRow(j);
					if (cells.length >= 2) {
						String className = cells[1].getContents();
						String entityName = cells[0].getContents();
						boolean flag = false;
						for (int m = 0; m < resultList.size(); m++) {
							Object temp = resultList.get(m);

							String contract = "";
							Field fieldAllArray2[] = BaseReflectUtils.getAllFieldFromClass(temp.getClass());
							for (int k = 0; k < fieldAllArray2.length; k++) {
								Field field = fieldAllArray2[k];
								if (field.getName().contains("Name")) {
									contract = (String) BaseReflectUtils.invokeGetMethod(temp, field, null);
								}
							}
							List list = new ArrayList();
							if (contract.equals(className)) {
								String entityType = "";
								for (int x = 0; x < fieldAllArray2.length; x++) {

									Field tempField = fieldAllArray2[x];
									String type = tempField.getType().getName();

									if (type.equals("java.util.List")) {
										list = (List) BaseReflectUtils.invokeGetMethod(temp, tempField, null);
										ParameterizedType pType = (ParameterizedType) tempField.getGenericType();
										entityType = pType.getActualTypeArguments()[0].getTypeName();
										break;
									}
								}

								if (list.size() > 0) {
									boolean flag2 = false;
									for (int n = 0; n < list.size(); n++) {

										// Class
										// classEntity=Class.forName(entityType);
										Object tempEntity = list.get(n);
										String contract2 = "";
										Field fieldAllArray3[] = BaseReflectUtils
												.getAllFieldFromClass(tempEntity.getClass());
										for (int k = 0; k < fieldAllArray3.length; k++) {
											Field field = fieldAllArray3[k];
											if (field.getName().contains("Name")) {
												contract2 = (String) BaseReflectUtils.invokeGetMethod(tempEntity, field,
														null);
											}
										}

										if (contract2.equals(entityName)) {
											// tempEntity.setNumber(tempEntity
											// .getNumber() + 1);
											for (int k = 0; k < fieldAllArray3.length; k++) {
												Field field = fieldAllArray3[k];
												if (field.getName().contains("number")) {
													Integer value = (Integer) BaseReflectUtils
															.invokeGetMethod(tempEntity, field, null) + 1;

													// field.set(object, value);
													BaseReflectUtils.ivokeSetMethod(tempEntity, field,
															value.toString());
												}
											}
											flag2 = true;
											break;
										}

									}
									if (flag2 == false) {
										addEntity(entityName, temp);
									}

								} else {
									addEntity(entityName, temp);

								}

								flag = true;
								break;
							}
						}
						if (flag == false) {
							Class classTemp = Class.forName(className1);
							Object object = classTemp.newInstance();
							Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(classTemp);
							for (int k = 0; k < fieldAllArray.length; k++) {
								Field field = fieldAllArray[k];
								if (field.getName().contains("Name")) {
									BaseReflectUtils.ivokeSetMethod(object, field, className);
									break;
								}
							}
							System.out.println("lllllllllll");
							// PartiClass temp = new PartiClass();
							// temp.setPartiClassName(className);
							addEntity(entityName, object);
							resultList.add(object);
						}
					}
				}
			}
			fis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return resultList;
	}

	private static void addEntity(String entityName, Object temp) throws Exception {

		Field fieldAllArray[] = BaseReflectUtils.getAllFieldFromClass(temp.getClass());
		String entityType = "";
		for (int j = 0; j < fieldAllArray.length; j++) {

			Field tempField = fieldAllArray[j];
			String type = tempField.getType().getName();

			if (type.equals("java.util.List")) {
				ParameterizedType pType = (ParameterizedType) tempField.getGenericType();
				entityType = pType.getActualTypeArguments()[0].getTypeName();
				break;
			}
		}

		Class classTemp = Class.forName(entityType);
		Object object = classTemp.newInstance();
		Field fieldAllArray2[] = BaseReflectUtils.getAllFieldFromClass(classTemp);
		for (int k = 0; k < fieldAllArray2.length; k++) {
			Field field = fieldAllArray2[k];
			if (field.getName().contains("Name")) {
				BaseReflectUtils.ivokeSetMethod(object, field, entityName);
			}
			if (field.getName().contains("number")) {
				Integer value = (Integer) BaseReflectUtils.invokeGetMethod(object, field, null) + 1;

				// field.set(object, value);
				BaseReflectUtils.ivokeSetMethod(object, field, value.toString());
			}
		}

		for (int j = 0; j < fieldAllArray.length; j++) {

			Field tempField = fieldAllArray[j];
			String type = tempField.getType().getName();

			if (type.equals("java.util.List")) {
				List list = (List) BaseReflectUtils.invokeGetMethod(temp, tempField, null);
				list.add(object);
				break;
			}
		}
		System.out.print("sssssssssss");
		// PartiEntity partiEntity = new PartiEntity();
		// partiEntity.setPartiEntityName(entityName);
		// partiEntity.setNumber(partiEntity.getNumber() + 1);
		// temp.getPartiEntityList().add(partiEntity);
	}

	public static void removeXML(String filePath) {
		File file = new File(filePath);
		if (file.exists())
			file.delete();
	}

	public static void removeXMLNode(String filePath, String nodeName, String nodeValue) throws IOException {
		ERutil.removeXMLNode(filePath, nodeName, nodeValue);

	}

	public static void insertXMLNode(String filePath, String nodeName, OntInfo ontInfo, String fieldType,
			String ontType) throws Exception {
		List<OntInfo> ontInfoList = new ArrayList<OntInfo>();
		ontInfoList.add(ontInfo);
		XMLWriter writer = null;// 声明写XML的对象
		SAXReader reader = new SAXReader();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");// 设置XML文件的编码格式
		File file = new File(filePath);
		Document doc = null;
		doc = ERutil.getDocument(filePath);
		Element element = ERutil.readXml(doc, fieldType, ontType);
		// @SuppressWarnings("unchecked")
		createXMl(ontInfoList, element, "eventCls");
		writer = new XMLWriter(new FileWriter(file), format);
		writer.write(doc);
		writer.close();
	}

	public static void insertXMLNode(String filePath, OntInfo ontInfo, String fieldType, String ontType)
			throws Exception {
		List<OntInfo> ontInfoList = new ArrayList<OntInfo>();
		ontInfoList.add(ontInfo);
		XMLWriter writer = null;// 声明写XML的对象
		SAXReader reader = new SAXReader();
		OutputFormat format = OutputFormat.createPrettyPrint();
		format.setEncoding("utf-8");// 设置XML文件的编码格式
		File file = new File(filePath);
		Document doc = null;
		doc = ERutil.getDocument(filePath);
		Element element = ERutil.readXml(doc, fieldType, ontType);
		// @SuppressWarnings("unchecked")
		createXMl(ontInfoList, element, "eventCls");
		writer = new XMLWriter(new FileWriter(file), format);
		writer.write(doc);
		writer.close();
	}
}
