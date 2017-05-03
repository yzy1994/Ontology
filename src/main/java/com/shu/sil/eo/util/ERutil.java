package com.shu.sil.eo.util;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;

public class ERutil {
	// List<String> filePathList=new ArrayList<String> ();
	public static void getFilePathList(String dirPath, List<String> filePathList) {
		File root = new File(dirPath);
		File[] files = root.listFiles();
		for (File file : files) {
			if (file.isDirectory()) {
				getFilePathList(file.getAbsolutePath(), filePathList);
			} else
				filePathList.add(file.getAbsolutePath());
		}
		// return filePathList;
	}

	public static List<Element> readXml(String filePath, String nodeName) {// �ҵ�ָ��xml�ļ���ָ���ڵ�
		Document doc = null;
		doc = getDocument(filePath);
		// @SuppressWarnings("unchecked")
		List<Element> nodeList = doc.selectNodes(nodeName);
		return nodeList;
	}

	public static List<Element> readXml(String filePath, String nodeName,
			String fieldType, String ontType) {// �ҵ�ָ��xml�ļ���ָ���ڵ�
		Document doc = null;
		doc = getDocument(filePath);
		// @SuppressWarnings("unchecked")
		Element root = doc.getRootElement();
		Element node = parse(root, "type", fieldType);
		Element node2 = parse(node, "type", ontType);
		List<Element> nodeList = node2.selectNodes(nodeName);

		return nodeList;
	}

	public static Element readXml(String filePath, String fieldType,
			String ontType) {// �ҵ�ָ��xml�ļ���ָ���ڵ�
		Document doc = null;
		doc = getDocument(filePath);
		// @SuppressWarnings("unchecked")
		Element root = doc.getRootElement();
		Element node = parse(root, "type", fieldType);
		Element node2 = parse(node, "type", ontType);

		return node2;
	}
	public static Element readXml(Document doc, String fieldType,
			String ontType) {// �ҵ�ָ��xml�ļ���ָ���ڵ�
//		Document doc = null;
//		doc = getDocument(filePath);
		// @SuppressWarnings("unchecked")
		Element root = doc.getRootElement();
		Element node = parse(root, "type", fieldType);
		Element node2 = parse(node, "type", ontType);

	return node2;
	}
	public static Element parse(Element node, String type, String val) {
		for (Iterator iter = node.elementIterator(); iter.hasNext();) {
			Element element = (Element) iter.next();
			Attribute name = element.attribute(type);
			if (name != null) {
				String value = name.getValue();
				if (value != null && val.equals(value))
					return element;
				else
					parse(element, type, val);
			}
		}
		return null;
	}

	public static Document getDocument(String filePath) {// ��ȡxml�ļ�
		Document doc = null;
		File xml = new File(filePath);
		SAXReader xmlreader = new SAXReader();
		try {
			doc = xmlreader.read(xml);
		} catch (DocumentException e) {
			System.out.println("getDocument erro");
			e.printStackTrace();
		}
		return doc;
	}

	public static void removeXMLNode(String filePath, String nodeName,
			String nodeValue,String fieldType,
			String ontType) throws IOException {

		String prefix = "//";
		Document doc = null;
		doc = getDocument(filePath);

		Element ele=readXml(doc,fieldType,ontType);
		List<Element> nodeList = ele.elements(nodeName);
		for (int i = 0; i < nodeList.size(); i++) {
			Element element = nodeList.get(i);
			if (element.getText().equals(nodeValue)) {
				Element temp = element.getParent();
				temp.detach();
				break;
			}
		}
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter out = new XMLWriter(new FileOutputStream(filePath),
					format);
			out.write(doc);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

	public static void removeXMLNode(String filePath, String nodeName,
			String nodeValue) throws IOException {

		String prefix = "//";
		Document doc = null;
		doc = getDocument(filePath);
		@SuppressWarnings("unchecked")
		List<Element> nodeList = doc.selectNodes(prefix + nodeName);
		for (int i = 0; i < nodeList.size(); i++) {
			Element element = nodeList.get(i);
			if (element.getText().equals(nodeValue)) {
				Element temp = element.getParent();
				temp.detach();
				break;
			}
		}
		try {
			OutputFormat format = OutputFormat.createPrettyPrint();
			format.setEncoding("utf-8");
			XMLWriter out = new XMLWriter(new FileOutputStream(filePath),
					format);
			out.write(doc);
			out.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
