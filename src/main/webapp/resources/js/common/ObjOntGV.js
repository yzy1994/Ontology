// list contains all objLat in svg
var objOntLatListGV = new ArrayList();

var conceptListGV = new ArrayList();

var conceptSubGraphList = new ArrayList();

// 0 is none,1 is add,2 is find,3 is edit ,4 is del
var objDelStatusGV = 0;

//actionURL
var ecFindUrl = "objOntAction!queryAllEC.action";

var ecEditUrl = "objOntAction!upsertEC.action";

var ecDelurl = "objOntAction!removeEC.action";

var ecInfoEditUrl = "objOntAction!queryECInfo.action";

var timeElementEditUrl = "objOntAction!editTimeLat.action";

var timeElementFindUrl = "objOntAction!queryTimeLat.action";

var conceptEditUrl = "objOntAction!editConceptLat.action";

var conceptDelUrl = "objOntAction!delConceptLat.action";

var conceptFindUrl = "objOntAction!queryConceptLat.action";

var conceptUpsertUrl = "objOntAction!upsertConceptLat.action"

var queryLatUrl = "objOntAction!queryLatBySid.action";

var objElementFindUrl = "objOntAction!queryObjLat.action";

var objElementEditUrl = "objOntAction!editObjLat.action";

var objElementDelUrl = "objOntAction!delObjLatByEvesid.action"
	
var envElementFindUrl = "objOntAction!queryEnvLat.action";

var envElementEditUrl = "objOntAction!editEnvLat.action";

var actionElementFindUrl = "objOntAction!queryActionLat.action";

var actionElementEditUrl = "objOntAction!editActionLat.action";

var assertElementFindUrl = "objOntAction!queryAssertionLat.action";
	
var assertElementEditUrl = "objOntAction!editAssertionLat.action";

var languageElementFindUrl = "objOntAction!queryLanguageLat.action";

var languageElementEditUrl = "objOntAction!editLanguageLat.action";

var researcherFindUrl = "objOntAction!queryAllResearcher.action";

var paperFindUrl = "objOntAction!queryAllPaper.action";

var conLineList = new ArrayList();

//表名
var CTN = "concept";
var ELTN = "eve_ont_lat";
var timeelement = "time_element";
