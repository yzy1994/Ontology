package com.di.ifin.zeus.admin.bont.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.inject.Inject;
import javax.inject.Named;

import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.XMLOutputter;
import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.OntInfo;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.service.EveOntLatServicem;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;

import net.sf.json.JSONObject;

@Controller("filedownload")
public class FileDownAction extends ActionSupport {
	@Inject
	@Named("OntService")
	OntService ontservice;

	@Inject
	@Named("LatService")
	private LatService latservice;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	InputStream fileInputStream;

	public InputStream getFileInputStream() {
		return this.fileInputStream;
	}

	public void setFileInputStream(InputStream fileInputStream) {
		this.fileInputStream = fileInputStream;
	}

	String fileName;

	public String getFileName() {
		return this.fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	String ontname;

	public String getOntname() {
		return this.ontname;
	}

	public void setOntname(String ontname) {
		this.ontname = ontname;
	}

	public String execute() {
		Element root = new Element("Ontology");
		Document Doc = new Document(root);
		Element info = new Element("OntInfo");
		
		ontname = URLDecoder.decode(ontname);
		OntInfo ontinfo = ontservice.findInfoByName(ontname);
		String jsonstring = gsonTemp.toJson(ontinfo);
		JSONObject json1 = JSONObject.fromObject(jsonstring);
		Map<String, String> map = json1;
		String selement = map.get("element");
		for (Entry<String, String> entry : map.entrySet())
			info.addContent(new Element(entry.getKey()).setText(entry.getValue()));

		root.addContent(info);

		Element eve_lats = new Element("Eve_Lats");
		List<OntLat> evelatlist = latservice.queryall("eve_ont_lat", ontname);
		for (OntLat lat : evelatlist) {
			Element eve_lat = new Element("Eve_Lat");
			Map<String,String> map1= OntLatUtil.getnoaddmap("eve_ont_lat", ontname, lat.getLatsid());
			for (Entry<String, String> entry : map1.entrySet())
				eve_lat.addContent(new Element(entry.getKey()).setText(entry.getValue()));
			eve_lats.addContent(eve_lat);
		}
		root.addContent(eve_lats);

		Element elements = new Element("Elements");
		String[] aelement = selement.split(",");
		for (String s : aelement) {
			String collectionname = "";
			String elementname = "";
			switch (s) {

			case "参与者":
				collectionname = "peo_ont_lat";
				elementname = "Peo_Lat";
				break; // 可选
			case "对象":
				collectionname = "obj_ont_lat";
				elementname = "Obj_Lat";
				break;
			case "环境":
				collectionname = "env_ont_lat";
				elementname = "Env_Lat";
				break;
			}
			Element element = new Element(elementname + "s");
			List<OntLat> latlist = latservice.queryall(collectionname, ontname);
			for (OntLat lat : latlist) {
				Element eve_lat = new Element(elementname);
				Map<String,String> map1= OntLatUtil.getnoaddmap(collectionname, ontname, lat.getLatsid());
				for (Entry<String, String> entry : map1.entrySet())
					eve_lat.addContent(new Element(entry.getKey()).setText(entry.getValue()));
				element.addContent(eve_lat);
			}
			elements.addContent(element);
		}
		root.addContent(elements);

		XMLOutputter XMLOut = new XMLOutputter();

		try {
			XMLOut.output(Doc, new FileOutputStream("ontology.xml"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		File file = new File("ontology.xml");
		fileName = file.getName();
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return SUCCESS;
	}
}
