function EventCls(eid, ecn, ets) {
	this.eid = eid;
	this.ecn = ecn;
	this.ets = ets;
	var objList = new ArrayList();
	var actionList = new ArrayList();
	var assertList = new ArrayList();
	var langList = new ArrayList();
	var time = new Time();
	var environ = new Environ();
	var topLinkNodeX;
	var topLinkNodeY;
	var botLinkNodeX;
	var botLinkNodeY;
	var grand;
	var showOrder;
	if (typeof toString == "function") {
		EventCls.prototype.toString = function() {
			alert(this.eid + " " + this.ecn + " " + this.ets);
		};
	}
	;
	this.setLinkNode = function(topLinkNodeX, topLinkNodeY, botLinkNodeX,
			botLinkNodeY) {
		this.topLinkNodeX = topLinkNodeX;
		this.topLinkNodeY = topLinkNodeY;
		this.botLinkNodeX = botLinkNodeX;
		this.botLinkNodeY = botLinkNodeY;
	}
	this.setGrand = function(grand) {
		this.grand = grand;
	}
	this.setShowOrder = function(showOrder) {
		this.showOrder = showOrder;
	}
}