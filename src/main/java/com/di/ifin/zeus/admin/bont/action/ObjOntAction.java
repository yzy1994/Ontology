package com.di.ifin.zeus.admin.bont.action;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.stereotype.Controller;

import com.di.ifin.zeus.admin.bont.pojo.ActionLat;
import com.di.ifin.zeus.admin.bont.pojo.AssertionLat;
import com.di.ifin.zeus.admin.bont.pojo.ConceptLat;
import com.di.ifin.zeus.admin.bont.pojo.EnvLat;
import com.di.ifin.zeus.admin.bont.pojo.EnvOntLat;
import com.di.ifin.zeus.admin.bont.pojo.EveOntLat;
import com.di.ifin.zeus.admin.bont.pojo.LanguageLat;
import com.di.ifin.zeus.admin.bont.pojo.ObjLat;
import com.di.ifin.zeus.admin.bont.pojo.OntLat;
import com.di.ifin.zeus.admin.bont.pojo.OntLatWithOntName;
import com.di.ifin.zeus.admin.bont.pojo.Paper;
import com.di.ifin.zeus.admin.bont.pojo.PeoOntLat;
import com.di.ifin.zeus.admin.bont.pojo.Researcher;
import com.di.ifin.zeus.admin.bont.pojo.TimeLat;
import com.di.ifin.zeus.admin.bont.service.ActionElementService;
import com.di.ifin.zeus.admin.bont.service.AssertionElementService;
import com.di.ifin.zeus.admin.bont.service.ConceptLatService;
import com.di.ifin.zeus.admin.bont.service.EnvElementService;
import com.di.ifin.zeus.admin.bont.service.EnvOntLatService;
import com.di.ifin.zeus.admin.bont.service.EveOntLatService;
import com.di.ifin.zeus.admin.bont.service.GlobalMongoService;
import com.di.ifin.zeus.admin.bont.service.LanguageElementService;
import com.di.ifin.zeus.admin.bont.service.LatService;
import com.di.ifin.zeus.admin.bont.service.ObjElementService;
import com.di.ifin.zeus.admin.bont.service.PaperService;
import com.di.ifin.zeus.admin.bont.service.PeoOntLatService;
import com.di.ifin.zeus.admin.bont.service.ResearcherService;
import com.di.ifin.zeus.admin.bont.service.TimeElementService;
import com.di.ifin.zeus.admin.bont.util.OperateMsg;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.opensymphony.xwork2.ActionSupport;
import com.shu.global.Global;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@Controller("objOntAction")
public class ObjOntAction extends ActionSupport {

	/*
	 * @Inject
	 * 
	 * @Named("objOntLatService") private ObjOntLatService objOntLatService;
	 */

	@Inject
	@Named("eveOntLatService")
	private EveOntLatService eveOntLatService;

	@Inject
	@Named("envOntLatService")
	private EnvOntLatService envOntLatService;

	@Inject
	@Named("peoOntLatService")
	private PeoOntLatService peoOntLatService;

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
	@Named("ConceptLatService")
	private ConceptLatService conceptlatservice;

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
	@Named("PaperService")
	private PaperService paperService;

	@Inject
	@Named("ResearcherService")
	private ResearcherService researcherService;

	Gson gsonTemp = new GsonBuilder().disableHtmlEscaping().create();
	private String objOntLatStr;

	public String getObjOntLatStr() {
		return objOntLatStr;
	}

	public void setObjOntLatStr(String objOntLatStr) {
		this.objOntLatStr = objOntLatStr;
	}

	private String operateMsg;

	public String getOperateMsg() {
		return operateMsg;
	}

	public void setOperateMsg(String operateMsg) {
		this.operateMsg = operateMsg;
	}

	private String objOntOidStr;

	public String getObjOntOidStr() {
		return objOntOidStr;
	}

	public void setObjOntOidStr(String objOntOidStr) {
		this.objOntOidStr = objOntOidStr;
	}

	private String objOntLatListStr;

	public String getObjOntLatListStr() {
		return objOntLatListStr;
	}

	public void setObjOntLatListStr(String objOntLatListStr) {
		this.objOntLatListStr = objOntLatListStr;
	}

	private String additionStr;

	public String getAdditionStr() {
		return additionStr;
	}

	public void setAdditionStr(String additionStr) {
		this.additionStr = additionStr;
	}

	private String inputStr;

	public String getInputStr() {
		return this.inputStr;
	}

	public void setInputStr(String inputStr) {
		this.inputStr = inputStr;
	}

	private String resultStr;

	public String getResultStr() {
		return this.resultStr;
	}

	public void setResultStr(String resultStr) {
		this.resultStr = resultStr;
	}

	private String lanInfo;

	private String assertInfo;

	private String actInfo;

	private String objInfo;

	private String timeInfo;

	private String envInfo;

	public String getLanInfo() {
		return lanInfo;
	}

	public void setLanInfo(String lanInfo) {
		this.lanInfo = lanInfo;
	}

	public String getAssertInfo() {
		return assertInfo;
	}

	public void setAssertInfo(String assertInfo) {
		this.assertInfo = assertInfo;
	}

	public String getActInfo() {
		return actInfo;
	}

	public void setActInfo(String actInfo) {
		this.actInfo = actInfo;
	}

	public String getObjInfo() {
		return objInfo;
	}

	public void setObjInfo(String objInfo) {
		this.objInfo = objInfo;
	}

	public String getTimeInfo() {
		return timeInfo;
	}

	public void setTimeInfo(String timeInfo) {
		this.timeInfo = timeInfo;
	}

	public String getEnvInfo() {
		return envInfo;
	}

	public void setEnvInfo(String envInfo) {
		this.envInfo = envInfo;
	}

	/*
	 * public String delObjOntLat() { System.out.println("objOntOidStr" +
	 * objOntOidStr); // String[] objOntOidStrList = objOntOidStr.split(","); //
	 * List objOntOidList = new ArrayList<Long>(); // for (int i = 0; i <
	 * objOntOidStrList.length; i++) { //
	 * objOntOidList.add(Long.valueOf(objOntOidStrList[i])); // }
	 * objOntLatService.removeParAndSonByLatSid(objOntOidStr); operateMsg =
	 * OperateMsg.create.CRESUC.toString(); return SUCCESS; }
	 * 
	 * public String updateObjOntLat() { System.out.println("objOntLatStr" +
	 * objOntLatStr); ObjOntLat objOntLat = gsonTemp.fromJson(objOntLatStr, new
	 * TypeToken<ObjOntLat>() { }.getType());
	 * objOntLatService.updateObjOntLat(objOntLat); operateMsg =
	 * OperateMsg.create.CRESUC.toString(); return SUCCESS; }
	 * 
	 * public String queryObjOntLatByOid() {
	 * 
	 * ObjOntLat objOntLat = new ObjOntLat(); objOntLat =
	 * objOntLatService.queryObjOntLatByOid(Long.valueOf(objOntOidStr));
	 * this.objOntLatStr = gsonTemp.toJson(objOntLat); return SUCCESS; }
	 */

	public String createEveOntLat() {
		System.out.println("objOntLatStr" + objOntLatStr);
		EveOntLat eveOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<EveOntLat>() {
		}.getType());

		boolean isName = eveOntLatService.checkLatName(eveOntLat.getLatname());
		boolean isSid = eveOntLatService.checkLatSid(eveOntLat.getLatsid());
		if (isName && isSid) {
			operateMsg = OperateMsg.create.CONNAMESID.toString();
		} else if (isName) {
			operateMsg = OperateMsg.create.CONNAME.toString();
		} else if (isSid) {
			operateMsg = OperateMsg.create.CONSID.toString();
		} else {
			eveOntLatService.createOntLat(eveOntLat);
			// System.out.println("Id" + eveOntLat.getOid());
			this.objOntLatStr = gsonTemp.toJson(eveOntLat);
			operateMsg = OperateMsg.create.CRESUC.toString();
		}
		return SUCCESS;
	}

	public String createEnvOntLat() {
		System.out.println("objOntLatStr" + objOntLatStr);
		EnvOntLat envOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<EnvOntLat>() {
		}.getType());

		boolean isName = envOntLatService.checkLatName(envOntLat.getLatname());
		boolean isSid = envOntLatService.checkLatSid(envOntLat.getLatsid());
		if (isName && isSid) {
			operateMsg = OperateMsg.create.CONNAMESID.toString();
		} else if (isName) {
			operateMsg = OperateMsg.create.CONNAME.toString();
		} else if (isSid) {
			operateMsg = OperateMsg.create.CONSID.toString();
		} else {
			envOntLatService.createOntLat(envOntLat);
			// System.out.println("Id" + eveOntLat.getOid());
			this.objOntLatStr = gsonTemp.toJson(envOntLat);
			operateMsg = OperateMsg.create.CRESUC.toString();
		}
		return SUCCESS;
	}

	public String updateEnvOntLat() {
		System.out.println("objOntLatStr" + objOntLatStr);
		EnvOntLat envOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<EnvOntLat>() {
		}.getType());
		envOntLatService.updateOntLat(envOntLat);
		operateMsg = OperateMsg.create.CRESUC.toString();
		return SUCCESS;
	}

	public String updateEveOntLat() {
		System.out.println("objOntLatStr" + objOntLatStr);
		EveOntLat eveOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<EveOntLat>() {
		}.getType());
		eveOntLatService.updateOntLat(eveOntLat);
		operateMsg = OperateMsg.create.CRESUC.toString();
		return SUCCESS;
	}

	public String createPeoOntLat() {
		System.err.println("createPeoOntLat");
		System.err.println("objOntLatStr" + objOntLatStr);
		PeoOntLat peoOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<PeoOntLat>() {
		}.getType());
		System.err.println("objOntLatStr" + objOntLatStr);
		peoOntLatService.createOntLat(peoOntLat);
		this.objOntLatStr = gsonTemp.toJson(peoOntLat);
		operateMsg = OperateMsg.create.CRESUC.toString();
		return SUCCESS;
	}

	public String updatePeoOntLat() {
		PeoOntLat peoOntLat = gsonTemp.fromJson(objOntLatStr, new TypeToken<PeoOntLat>() {
		}.getType());
		peoOntLatService.updateOntLat(peoOntLat);
		operateMsg = OperateMsg.create.CRESUC.toString();
		return SUCCESS;
	}

	// 概念和事件类的CRUD
	public String queryLatByMongo() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String collection = json.getString("collection");
		if (ontname != null || collection != null) {
			List<OntLat> latlist;
			if (collection.equals("concept")) {
				latlist = latservice.queryall(collection);
			} else {
				latlist = latservice.queryall(collection, ontname);
			}
			resultStr = gsonTemp.toJson(latlist);
		} else {
			resultStr = "ERROR";
		}
		return SUCCESS;
	}

	public String deleteLatByMongo() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String collection = json.getString("collection");
		String ontname = json.getString("ontname");
		String latsid = json.getString("latsid");
		if (ontname != null || collection != null || latsid != null) {
			latservice.removeBySid(collection, ontname, latsid);
			resultStr = "delsuc";
		} else {
			resultStr = "delerr";
		}
		return SUCCESS;
	}

	public String createLatByMongo() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String collection = json.getString("collection");
		String ontname = json.getString("ontname");
		objOntLatStr = objOntLatStr.toLowerCase();
		json = JSONObject.fromObject(objOntLatStr);
		json.put("ontname", ontname);
		OntLat object = gsonTemp.fromJson(objOntLatStr, new TypeToken<OntLatWithOntName>() {
		}.getType());
		if (ontname != null || collection != null) {
			resultStr = latservice.insert(collection, object);
			if (additionStr != null && additionStr != "{}") {
				additionStr = additionStr.toLowerCase();
				Map<String, String> mapadd = gsonTemp.fromJson(additionStr, new TypeToken<Map<String, String>>() {
				}.getType());
				Map<String, String> map = gsonTemp.fromJson(objOntLatStr, new TypeToken<Map<String, String>>() {
				}.getType());
				this.latservice.updateBySid(collection, ontname, object.getLatsid(), map, mapadd);
			}
		} else {
			resultStr = "creerr";
		}
		return SUCCESS;
	}

	public String updateLatByMongo() {
		Map<String, String> mapadd = new HashMap<String, String>();
		JSONObject json = JSONObject.fromObject(inputStr);
		String collection = json.getString("collection");
		String ontname = json.getString("ontname");
		objOntLatStr = objOntLatStr.toLowerCase();
		additionStr = additionStr.toLowerCase();
		Map<String, String> map = gsonTemp.fromJson(objOntLatStr, new TypeToken<Map<String, String>>() {
		}.getType());
		if (additionStr != null) {
			mapadd = gsonTemp.fromJson(additionStr, new TypeToken<Map<String, String>>() {
			}.getType());
		}
		String latsid = map.get("latsid");
		map.remove(latsid);

		if (ontname != null || collection != null) {
			this.latservice.updateBySid(collection, ontname, latsid, map, mapadd);
			resultStr = "upsuc";
		} else {
			resultStr = "uperr";
		}
		return SUCCESS;
	}

	//
	public String queryLatBySid() {
		this.additionStr = "";
		JSONObject json = JSONObject.fromObject(inputStr);
		String collection = json.getString("collection");
		String ontname = json.getString("ontname");
		String latname = json.getString("latname").replaceAll("\"", "");
		String result;
		MongoClient mc = new MongoClient("localhost", 27017);
		DB db = mc.getDB("ontology");
		DBCollection dbcollection = db.getCollection(collection);
		DBObject searchObj = new BasicDBObject();
		searchObj.put("latname", latname);
		/* searchObj.put("ontname", ontname); */
		this.resultStr = latname;
		DBCursor cursor = dbcollection.find(searchObj);
		if (cursor.hasNext()) {
			result = cursor.next().toString();
		} else {
			this.operateMsg = "error";
			return SUCCESS;
		}
		this.objOntLatStr = result;
		objOntLatStr = objOntLatStr.replaceAll("\".*?\".*?:.*?}.*?,", "");
		resultStr = objOntLatStr;
		System.out.println(objOntLatStr);
		Map<String, String> map = gsonTemp.fromJson(objOntLatStr, new TypeToken<Map<String, String>>() {
		}.getType());
		map.remove("_id");
		map.remove("_class");
		map.remove("latsid");
		map.remove("latname");
		map.remove("parentsid");
		map.remove("ontname");
		String addition = gsonTemp.toJson(map, new TypeToken<Map<String, String>>() {
		}.getType());
		this.additionStr = addition;
		return SUCCESS;
	}

	// inputStr 时间要素 CRUD
	public String editTimeLat() {
		// JSONObject json = JSONObject.fromObject(inputStr);
		TimeLat timelat = gsonTemp.fromJson(inputStr, new TypeToken<TimeLat>() {
		}.getType());
		timeelementservice.editTimeElement(timelat);
		this.setOperateMsg("suc");
		return SUCCESS;
	}

	// input:inputStr {ontname:xx evelatsid:xx} output:resultStr
	public String queryTimeLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		TimeLat tl = timeelementservice.queryTimeElement(ontname, evelatname);
		if (tl == null) {
			operateMsg = "cannot find";
			resultStr = "";
			return SUCCESS;
		} else {
			operateMsg = "suc";
			resultStr = gsonTemp.toJson(tl);
			return SUCCESS;
		}
	}

	// 对象要素CRUD
	public String editObjLat() {
		ObjLat objlat = gsonTemp.fromJson(inputStr, new TypeToken<ObjLat>() {
		}.getType());
		objelementservice.editObjElement(objlat);
		return SUCCESS;
	}

	public String queryObjLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		List<ObjLat> list = objelementservice.queryObjElement(ontname, evelatname);
		if (list.size() == 0) {
			operateMsg = "cannot find";
			resultStr = "";
		} else {
			operateMsg = "finded";
			resultStr = gsonTemp.toJson(list);
		}
		return SUCCESS;
	}

	public String delObjLatByEvesid() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		objelementservice.delObjElement(evelatname, ontname);
		return SUCCESS;
	}

	// 概念格的CRUD
	public String queryConceptLat() {
		List<ConceptLat> list = conceptlatservice.queryAll();
		if (list.size() == 0) {
			resultStr = "";
			operateMsg = "No Concept";
		} else {
			operateMsg = "finded";
			resultStr = gsonTemp.toJson(list);
		}
		return SUCCESS;
	}

	public String delConceptLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String latname = json.getString("latname");
		if (conceptlatservice.IsExistsChildNode(latname)) {
			this.operateMsg = "existcn";
			return SUCCESS;
		}

		conceptlatservice.delete(latname);
		this.operateMsg = "delsuc";
		return SUCCESS;
	}

	public String upsertConceptLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String latname = json.getString("latname");
		conceptlatservice.delete(latname);
		Map<String, String> map = gsonTemp.fromJson(inputStr, new TypeToken<Map<String, String>>() {
		}.getType());
		conceptlatservice.upsert(latname, map);
		return SUCCESS;
	}

	// 动作要素的CRUD
	public String queryActionLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		ActionLat result = actionelementservice.query(evelatname, ontname);
		if (result != null) {
			resultStr = gsonTemp.toJson(result);
			operateMsg = "Finded";
		} else {
			resultStr = "";
			operateMsg = "Not Finded";
		}
		return SUCCESS;
	}

	public String editActionLat() {
		ActionLat actionLat = gsonTemp.fromJson(inputStr, new TypeToken<ActionLat>() {
		}.getType());
		actionelementservice.upsert(actionLat);
		return SUCCESS;
	}

	// 环境要素编辑

	public String queryEnvLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		EnvLat envlat = envElementService.queryEnvLat(ontname, evelatname);
		if (envlat != null) {
			resultStr = gsonTemp.toJson(envlat);
			operateMsg = "Finded";
		} else {
			resultStr = "";
			operateMsg = "Not Finded";
		}
		return SUCCESS;
	}

	public String editEnvLat() {
		EnvLat envlat = gsonTemp.fromJson(inputStr, new TypeToken<EnvLat>() {
		}.getType());
		envElementService.editEnvLat(envlat);
		return SUCCESS;
	}

	// 断言要素CRUD
	public String queryAssertionLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		AssertionLat assertionlat = assertionElementService.query(ontname, evelatname);

		if (assertionlat != null) {
			resultStr = gsonTemp.toJson(assertionlat);
			operateMsg = "Finded";
		} else {
			resultStr = "";
			operateMsg = "Not Finded";
		}
		return SUCCESS;
	}

	public String editAssertionLat() {
		AssertionLat assertionlat = gsonTemp.fromJson(inputStr, new TypeToken<AssertionLat>() {
		}.getType());
		assertionElementService.upsert(assertionlat);
		return SUCCESS;
	}

	// 语言表现要素CRUD
	public String queryLanguageLat() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");
		LanguageLat lan = languageElementService.query(ontname, evelatname);
		if (lan != null) {
			resultStr = gsonTemp.toJson(lan);
			operateMsg = "Finded";
		} else {
			resultStr = "";
			operateMsg = "Not Finded";
		}
		return SUCCESS;
	}

	public String editLanguageLat() {
		LanguageLat lan = gsonTemp.fromJson(inputStr, new TypeToken<LanguageLat>() {
		}.getType());
		languageElementService.upsert(lan);
		return SUCCESS;
	}

	// 事件类CRUD
	public String IsExistsChildren() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String latname = json.getString("latname");
		if (latservice.IsExistChildren(Global.eventclass, ontname, latname)) {
			this.resultStr = "true";
		} else {
			this.resultStr = "false";
		}
		return SUCCESS;
	}

	public String removeEC() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String latname = json.getString("latname");
		if (latservice.IsExistChildren(Global.eventclass, ontname, latname)) {
			this.operateMsg = "existcn";
			return SUCCESS;
		}
		latservice.removeByLatname(Global.eventclass, ontname, latname);
		this.operateMsg = "delesuc";
		return SUCCESS;
	}
	
	public String removeECByOntname(){
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		latservice.removeByOntname(Global.eventclass, ontname);
		return SUCCESS;
	}

	public String upsertEC() {
		OntLat o = gsonTemp.fromJson(inputStr, new TypeToken<OntLat>() {
		}.getType());
		latservice.removeByLatname(Global.eventclass, o.getOntname(), o.getLatname());
		latservice.insert(Global.eventclass, o);
		this.operateMsg = "update";
		return SUCCESS;
	}

	public String insertEC() {
		OntLat o = gsonTemp.fromJson(inputStr, new TypeToken<OntLat>() {
		}.getType());
		o.setLatsid("e" + globalMongoService.getid(Global.evelatsid).toString());
		latservice.insert(Global.eventclass, o);
		return SUCCESS;
	}

	public String queryAllEC() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		List<OntLat> list = latservice.queryall(Global.eventclass, ontname);
		if (list.size() != 0) {
			this.resultStr = gsonTemp.toJson(list);
		} else {
			this.resultStr = "";
		}
		return SUCCESS;
	}

	public String queryECInfo() {
		JSONObject json = JSONObject.fromObject(inputStr);
		String ontname = json.getString("ontname");
		String evelatname = json.getString("evelatname");

		OntLat ol = latservice.queryByLatname(Global.eventclass, ontname, evelatname).get(0);
		this.setResultStr(gsonTemp.toJson(ol));

		ActionLat al = actionelementservice.query(evelatname, ontname);
		this.setActInfo(gsonTemp.toJson(al));

		TimeLat tl = timeelementservice.queryTimeElement(ontname, evelatname);
		this.setTimeInfo(gsonTemp.toJson(tl));

		EnvLat el = envElementService.queryEnvLat(ontname, evelatname);
		this.setEnvInfo(gsonTemp.toJson(el));

		AssertionLat asl = assertionElementService.query(ontname, evelatname);
		this.setAssertInfo(gsonTemp.toJson(asl));

		LanguageLat ll = languageElementService.query(ontname, evelatname);
		this.setLanInfo(gsonTemp.toJson(ll));

		return SUCCESS;
	}

	// 研究团队和文献内容
	public String queryAllResearcher() {
		List<Researcher> list = researcherService.queryAllResearcher();
		if (list.size() != 0) {
			this.resultStr = gsonTemp.toJson(list);
		} else {
			this.resultStr = "";
		}
		return SUCCESS;
	}

	public String queryAllPaper() {
		List<Paper> list = paperService.queryAllPaper();
		if (list.size() != 0) {
			this.resultStr = gsonTemp.toJson(list);
		} else {
			this.resultStr = "";
		}
		return SUCCESS;
	}
}