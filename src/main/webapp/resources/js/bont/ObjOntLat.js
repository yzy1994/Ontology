function ObjOntLat() {
	var latsid
	var latname;
	var parentlatname;
	var latnote;
/*	var peoElement;
	var objElement;
	var envElement;*/
	
	var grand;
	var showOrder;
	
	if (typeof toString == "function") {
		ObjOntLat.prototype.toString = function() {
			alert(this.eid + " " + this.ecn + " " + this.ets);
		};
	}
	;
	this.setGrand = function(grand) {
		this.grand = grand;
	}
	this.setShowOrder = function(showOrder) {
		this.showOrder = showOrder;
	}
}