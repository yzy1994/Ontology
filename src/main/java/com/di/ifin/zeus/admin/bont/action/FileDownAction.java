package com.di.ifin.zeus.admin.bont.action;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
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

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;
import com.di.ifin.zeus.admin.bont.pojo.ObjLat;
import com.di.ifin.zeus.admin.bont.pojo.OntInfo;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.service.ActionElementService;
import com.di.ifin.zeus.admin.bont.service.AssertionElementService;
import com.di.ifin.zeus.admin.bont.service.ECRelationService;
import com.di.ifin.zeus.admin.bont.service.EnvElementService;
import com.di.ifin.zeus.admin.bont.service.GlobalMongoService;
import com.di.ifin.zeus.admin.bont.service.LanguageElementService;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.di.ifin.zeus.admin.bont.service.ObjElementService;
import com.di.ifin.zeus.admin.bont.service.OntService;
import com.di.ifin.zeus.admin.bont.service.TimeElementService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opensymphony.xwork2.ActionSupport;
import com.shu.global.Global;

import net.sf.json.JSONObject;

@Controller("filedownload")
public class FileDownAction extends ActionSupport {
	@Inject
	@Named("OntService")
	OntService ontservice;

	@Inject
	@Named("LatService")
	private LatService latservice;
	
	@Inject
	@Named("TimeElementService")
	private TimeElementService timeelementservice;

	@Inject
	@Named("ObjElementService")
	private ObjElementService objelementservice;

	@Inject
	@Named("ActionElementService")
	private ActionElementService actionelementservice;

	@Inject
	@Named("GlobalMongoService")
	private GlobalMongoService globalMongoService;

	@Inject
	@Named("EnvElementService")
	private EnvElementService envElementService;

	@Inject
	@Named("AssertionElementService")
	private AssertionElementService assertionElementService;

	@Inject
	@Named("LanguageElementService")
	private LanguageElementService languageElementService;
	
	@Inject
	@Named("ECRelationService")
	private ECRelationService ecrelationService;

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
		System.err.println(ontname);
		OntInfo ontinfo = ontservice.findInfoByName(ontname);
		String jsonstring = gsonTemp.toJson(ontinfo);
		JSONObject json1 = JSONObject.fromObject(jsonstring);
		Map<String, String> map = json1;
		String selement = map.get("element");
		for (Entry<String, String> entry : map.entrySet())
			info.addContent(new Element(entry.getKey()).setText(entry.getValue()));

		root.addContent(info);

		Element eve_lats = new Element("Eve_Lats");
		List<OntLat> evelatlist = latservice.queryall(Global.eventclass, ontname);
		for (OntLat lat : evelatlist) {
			Element eve_lat = new Element("Eve_Lat");
			OntLatUtil.injectElementFromObject(eve_lat,lat);
			/*Map<String,String> map1= OntLatUtil.getnoaddmap("eve_ont_lat", ontname, lat.getLatname());
			for (Entry<String, String> entry : map1.entrySet())
				eve_lat.addContent(new Element(entry.getKey()).setText(entry.getValue()));*/
			Element action = new Element("Action_Element");
			OntLatUtil.injectElementFromObject(action, actionelementservice.query(lat.getLatname(), ontname));
			eve_lat.addContent(action);
			
			Element objects = new Element("Objects_Element");
			List<ObjLat> list = objelementservice.queryObjElement(ontname, lat.getLatname());
			if(list.size()!=0){
				for(ObjLat ol:list){
					Element object =  new Element("Object_Element");
					OntLatUtil.injectElementFromObject(object, ol);
					objects.addContent(object);
				}
			}
			eve_lat.addContent(objects);
			
			Element time = new Element("Time_Element");
			OntLatUtil.injectElementFromObject(time, timeelementservice.queryTimeElement(ontname, lat.getLatname()));
			eve_lat.addContent(time);
			
			Element env = new Element("Environment_Element");
			OntLatUtil.injectElementFromObject(env, envElementService.queryEnvLat(ontname, lat.getLatname()));
			eve_lat.addContent(env);
			
			Element assertion = new Element("Assertion_Element");
			OntLatUtil.injectElementFromObject(assertion, assertionElementService.query(ontname, lat.getLatname()));
			eve_lat.addContent(assertion);
			
			Element language = new Element("Language_Element");
			OntLatUtil.injectElementFromObject(language, languageElementService.query(ontname, lat.getLatname()));
			eve_lat.addContent(language);
			
			eve_lats.addContent(eve_lat);
		}
		root.addContent(eve_lats);
		
		Element ec_rs = new Element("ec_relationships");
		List<ECRelation> ecrlist = ecrelationService.queryECRelation(ontname);
		for(ECRelation ecr:ecrlist){
			Element eecr = new Element("ec_relationship");
			OntLatUtil.injectElementFromObject(eecr, ecr);
			ec_rs.addContent(eecr);
		}
		root.addContent(ec_rs);

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
