package com.di.ifin.zeus.admin.bont.action;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.jdom.Element;

import com.di.ifin.zeus.admin.bont.pojo.ECRelation;
import com.di.ifin.zeus.admin.bont.pojo.ECRelationDef;
import com.di.ifin.zeus.admin.bont.pojo.Link;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;

import net.sf.json.JSONObject;

public class OntLatUtil {
	static Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();

	public static Map<String, String> getmap(String latsid, String collection) {
		String result;
		MongoClient mc = new MongoClient("localhost", 27017);
		DB db = mc.getDB("ontology");
		DBCollection dbcollection = db.getCollection(collection);
		DBObject searchObj = new BasicDBObject();
		searchObj.put("latsid", latsid);
		DBCursor cursor = dbcollection.find(searchObj);
		if (cursor.hasNext()) {
			result = cursor.next().toString();
		} else {
			result = "error";
		}
		String objOntLatStr = result;
		System.err.println(objOntLatStr);
		objOntLatStr = objOntLatStr.replaceAll("\".*?\".*?:.*?}.*?,", "");
		System.err.println(objOntLatStr);
		Map<String, String> map = gsonTemp.fromJson(objOntLatStr, new TypeToken<Map<String, String>>() {
		}.getType());
		map.remove("_id");
		map.remove("_class");
		map.remove("latsid");
		map.remove("latname");
		map.remove("parentsid");
		map.remove("latnote");
		return map;
	}

	public static Map<String, String> getnoaddmap(String collection, String ontname, String latname) {
		// TODO Auto-generated method stub
		MongoClient mc = new MongoClient("localhost", 27017);
		DB db = mc.getDB("ontology");
		DBCollection dbcollection = db.getCollection(collection);
		DBObject searchObj = new BasicDBObject();
		String result;
		searchObj.put("latname", latname);
		searchObj.put("ontname", ontname);
		DBCursor cursor = dbcollection.find(searchObj);
		if (cursor.hasNext()) {
			result = cursor.next().toString();
		} else {
			return null;
		}
		result = result.replaceAll("\".*?\".*?:.*?}.*?,", "");
		System.out.println(result);
		Map<String, String> map = gsonTemp.fromJson(result, new TypeToken<Map<String, String>>() {
		}.getType());
		map.remove("_id");
		map.remove("_class");
		return map;
	}

	
	//e xml元素 lat Object
	public static void injectElementFromObject(Element e, Object lat) {
		String jsonstring = gsonTemp.toJson(lat);
		JSONObject json1 = JSONObject.fromObject(jsonstring);
		Map<String, String> map = json1;
		for (Entry<String, String> entry : map.entrySet())
			e.addContent(new Element(entry.getKey()).setText(entry.getValue()));
	}

	public static void importLats(Element Lats, LatService latservice, String collection) {
		Map<String, String> mapadd = new HashMap<String, String>();
		List<Element> latslist = Lats.getChildren();
		OntLat ontlat = new OntLat();
		for (Element lat : latslist) {
			mapadd.clear();
			ontlat.setLatname(lat.getChild("latname").getText());
			ontlat.setParentlatname(lat.getChild("parentlatname").getText());
			ontlat.setLatsid(lat.getChild("latsid").getText());
			ontlat.setLatnote(lat.getChild("latnote").getText());
			lat.removeChild("latname");
			lat.removeChild("parentsid");
			lat.removeChild("latsid");
			lat.removeChild("latnote");
			List<Element> latlist = lat.getChildren();
			if (latlist.size() > 0) {
				for (Element e : latlist) {
					mapadd.put(e.getName(), e.getText());
				}
			}
			latservice.insert("eve_ont_lat", ontlat, mapadd);
		}
	}

	public static List<Link> toLinkList(List<ECRelation> list, List<ECRelationDef> deflist) {
		List<Link> resultlist = new ArrayList<Link>();
		for (ECRelation ecr : list) {
			Link link = new Link(ecr);
			String value = "";
			String[] a1 = { "pin", "pin" };
			Integer[] a2 = { 0, 0 };

			for (ECRelationDef def : deflist) {
				if (def.getRid().equals(link.getValue()))
				{
					value = def.getRdes();
					a1 = def.getSymbol();
					a2 = def.getSymbolSize();
					break;
				}
			}
			link.setValue(value);
			link.setSymbol(a1);
			link.setSymbolSize(a2);
			resultlist.add(link);
		}
		return resultlist;
	}
}
