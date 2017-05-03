function ShowLayer(layer) {
	this.layer = layer;
	var ontLatList = new ArrayList();
	this.add = function(ontLat) {
		ontLatList.add(ontLat);
	}
	this.get = function(i) {
		return ontLatList.get(i);
	}
	this.size = function() {
		return ontLatList.size();
	}
}