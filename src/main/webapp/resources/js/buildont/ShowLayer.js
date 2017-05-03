function ShowLayer(layer) {
	this.layer = layer;
	var eclsList = new ArrayList();
	this.add = function(ecls) {
		eclsList.add(ecls);
	}
	this.get = function(i) {
		return eclsList.get(i);
	}
	this.size = function() {
		return eclsList.size();
	}
}