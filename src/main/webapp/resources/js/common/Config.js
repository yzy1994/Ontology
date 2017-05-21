//Total config

//objOnt config
var objOntUrl = "tool/bont.html";
var latLigColor = "190,228,251";
var latDeeColor = "160,217,251";
var latStroke = "58,179,251";
var latSelStroke = "red";
var fontsize = 12;
var widSup = fontsize * 2;
var recHei = Math.round(fontsize * 2.3);
var reg = new RegExp(",");
var fadeTime = 100;
var slideTime = 200;

// node
var topCir = "top";
var botCir = "bot";
var radius = 1;
// node

// svg arg start
var xmlns = "http://www.w3.org/2000/svg";
var xmlns2 = "http://www.w3.org/1999/xhtml";
var svgWidth = 1200;
var svgHeight = 520;
var totalXGrap = 100;
var totalYGrap = 100;
// svg arg end

// rext arg start
var startY = 50;
var blockWidth = 80;
var blockHeight = 36;
var xGrap = 20;
var yGrap = 50;
var rx = 10;
var ry = 10;
var micY = 8;
var stroke = "none";
var fill = "orange";
var rgBrush;
// rect arg end

// zoom arg start
var zoomMulList = [ 0.1, 0.2, 0.3, 0.4, 0.5, 0.6, 0.7, 0.8, 0.9, 1, 1.1, 1.2,
		1.3, 1.4, 1.5, 1.6, 1.7, 1.8, 1.9, 2.0 ];
var orgZoomIndex = 9;
var curZoomIndex = 9;
var maxZoomIndex = 11;
var minZoomIndex = 7;
var orgZoomMul = zoomMulList[orgZoomIndex];
// zoom arg end
// toplinkNode arg start
var yTopOffset = 2;
var xTopOffset = 40;
var topRadius = 2;
// toplinkNode arg end
// toplinkNode arg start
var yBotOffset = 34;
var xBotOffset = 40;
var botRadius = 2;
// toplinkNode arg end

// flod arg start
var pointsArray = [ 10, 15, 17, 15, 17, 8, 23, 8, 23, 15, 30, 15, 30, 21, 23,
		21, 23, 28, 17, 28, 17, 21, 10, 21 ];
// flod arg end
// text arg start
var yTextOffset = 23;
// text arg end

