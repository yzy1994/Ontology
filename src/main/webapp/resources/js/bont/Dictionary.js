function Dictionary() {
	this.data = new Array();

	this.put = function(key, value) {
		this.data[key] = value;
	};

	this.get = function(key) {
		return this.data[key];
	};

	this.remove = function(key) {
		this.data[key] = null;
	};

	this.isEmpty = function() {
		return this.data.length == 0;
	};

	this.size = function() {
		return this.data.length;
	};
}