package com.shu.sil.eo.buildont.pojo;

import java.util.ArrayList;
import java.util.List;

public class EventCls {
	private String eid;
	private String ecn;
	private String ets;
	List<Obj> objList = new ArrayList<Obj>();
	List<Action> actionList = new ArrayList<Action>();
	List<Assert> assertList = new ArrayList<Assert>();
	List<Lang> langList = new ArrayList<Lang>();
	private Time time;
	private Environ environ;
	public String getEid() {
		return eid;
	}
	public void setEid(String eid) {
		this.eid = eid;
	}
	public String getEcn() {
		return ecn;
	}
	public void setEcn(String ecn) {
		this.ecn = ecn;
	}
	public String getEts() {
		return ets;
	}
	public void setEts(String ets) {
		this.ets = ets;
	}
	public List<Obj> getObjList() {
		return objList;
	}
	public void setObjList(List<Obj> objList) {
		this.objList = objList;
	}
	public List<Action> getActionList() {
		return actionList;
	}
	public void setActionList(List<Action> actionList) {
		this.actionList = actionList;
	}
	public List<Assert> getAssertList() {
		return assertList;
	}
	public void setAssertList(List<Assert> assertList) {
		this.assertList = assertList;
	}
	public List<Lang> getLangList() {
		return langList;
	}
	public void setLangList(List<Lang> langList) {
		this.langList = langList;
	}
	public Time getTime() {
		return time;
	}
	public void setTime(Time time) {
		this.time = time;
	}
	public Environ getEnviron() {
		return environ;
	}
	public void setEnviron(Environ environ) {
		this.environ = environ;
	}

}
