package com.shu.sil.eo.buildont.util;

import java.io.File;
import java.util.List;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.input.SAXBuilder;
import org.jdom.xpath.XPath;

public class JdomUtil {
	@SuppressWarnings("unchecked")
	public static List queryElementByXPath() {
		SAXBuilder builder = new SAXBuilder();
		List<Element> list = null;
		try {
			Document doc = builder.build(new File("buildont/OntInfo.xml"));
			list = XPath.selectNodes(doc, "//eventCls");
			for (Element el : list) {

				System.out.println("-----------------------------------");
			}
		} catch (Exception e) {

		}
		return list;
	}
}
