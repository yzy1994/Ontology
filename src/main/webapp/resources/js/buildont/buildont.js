var fileStatusPub;
var fileNamePub;
var saveResult;
var documentVOList;
var modelState = 0;
var startIndexPub = "";
var endIndexPub = "";
var selectStrPub = "";
var findNextPub;
var findStrPub;
var findResultPub;
var basePath2="http://localhost:8080/zeus-clientweb-web/upload!fileList.action";

var state;

$(document)
		.ready(
				function() {
					// nav-li hover e
					var num;
					$('.nav-main li[id]').hover(
							function() {
								/* 图标向上旋转 */
								$(this).children().removeClass().addClass(
										'hover-up');
								/* 下拉框出现 */
								var Obj = $(this).attr('id');
								num = Obj.substring(3, Obj.length);
								$('#box-' + num).slideDown(300);
							},
							function() {
								/* 图标向下旋转 */
								$(this).children().removeClass().addClass(
										'hover-down');
								/* 下拉框消失 */
								$('#box-' + num).hide();
							});
					// hidden-box hover e
					$('.hidden-box').hover(
							function() {
								/* 保持图标向上 */
								$('#li-' + num).children().removeClass()
										.addClass('hover-up');
								$(this).show();
							},
							function() {
								$(this).slideUp(200);
								$('#li-' + num).children().removeClass()
										.addClass('hover-down');
							});

					function insertElement(index) {
						var tempEle = elementList.get(index);
						$('#textShow')
								.insertContent(elementBridge.get(tempEle));
						insertedEle = elementBridge.get(tempEle);
						insertedFlag = 0;
						displayElementDiv();

					}
					function insertType(typeStr) {

						$('#textShow').insertContent(
								" type=" + "\"" + typeStr + "\"");
						displayTypeDiv();
					}
					function insertCommonId(commonIdStr, elementStr, mouseIndex) {
						var regStr = new RegExp("<" + elementStr + ".*?>");
						var tagNum = getTagId($('#textShow').val(), regStr,
								mouseIndex) + 1;
						var idStr = " " + commonIdStr + "id=\"" + commonIdStr
								+ "\"";
						var tempIdStr = idStr.substr(0, idStr.length - 1)
								+ tagNum + "\"";
						$('#textShow').insertContent(tempIdStr);
						// $('#textShow')
						// .insertContent("
						// "+commonIdStr+"id=\""+commonIdStr+"\"");
						displayCommonIdDiv();
					}

					var insertedEle;
					var insertedFlag = 1;
					// 定义
					var elementMap = new hashmap();
					elementMap.put("<Denoter>", "</Denoter>");
					elementMap.put("<Means>", "</Means>");
					elementMap.put("<Time>", "</Time>");
					elementMap.put("<Location>", "</Location>");
					elementMap.put("<Participant>", "</Participant>");
					elementMap.put("<Object>", "</Object>");
					elementMap.put("<Event>", "</Event>");
					elementMap.put("<Sentence>", "</Sentence>");
					elementMap.put("<Paragraph>", "</Paragraph>");
					elementMap.put("<Content>", "</Content>");
					elementMap.put("<ReportTime>", "</ReportTime>");
					elementMap.put("<Title>", "</Title>");
					elementMap.put("<Body>", "</Body>");
					var elementList = new ArrayList();
					elementList.add("Denoter");
					elementList.add("Means");
					elementList.add("Time");
					elementList.add("Location");
					elementList.add("Participant");
					elementList.add("Object");
					elementList.add("Event");
					elementList.add("Sentence");
					elementList.add("Paragraph");
					elementList.add("Content");
					elementList.add("ReportTime");
					elementList.add("Title");
					elementList.add("Body");

					var elementBridge = new hashmap();
					elementBridge.put("Denoter", "<Denoter>");
					elementBridge.put("Means", "<Means>");
					elementBridge.put("Time", "<Time>");
					elementBridge.put("Location", "<Location>");
					elementBridge.put("Participant", "<Participant>");
					elementBridge.put("Object", "<Object>");
					elementBridge.put("Event", "<Event>");
					elementBridge.put("Sentence", "<Sentence>");
					elementBridge.put("Paragraph", "<Paragraph>");
					elementBridge.put("Content", "<Content>");
					elementBridge.put("ReportTime", "<ReportTime>");
					elementBridge.put("Title", "<Title>");
					elementBridge.put("Body", "<Body>");

					// 动态DIV
					var elementDiv = $('<div></div>'); // 创建一个父div
					elementDiv.attr('id', 'elementDivId'); // 给父div设置id
					// elementDiv.css({
					// "display":"none",
					// "z-index": "99999",
					// "background-color": "red"
					// }); //添加css样式

					var elementUl = $('<ul></ul>');
					for (i = 0; i < elementList.size(); i++) {
						var denoterLi = $('<li onclick="insertElement(' + i
								+ ');">' + elementList.get(i) + '</li>');
						// var denoterLi=$('<li
						// onclick="Page.RegisterStartupScript("insertElementllkk","<script>insertElementllkk()l;</script>");">'+elementList.get(i)+'</li>');
						denoterLi.attr('id', elementList.get(i) + "Id");
						// denoterLi.css({
						// "z-index": "99999",
						// "background-color": "green"
						// });
						denoterLi.appendTo(elementUl);
					}

					elementUl.appendTo(elementDiv);
					elementDiv.appendTo('body');
					// 动态DIV

					// 动态typeDIV
					var typeDiv = $('<div></div>'); // 创建一个父div
					typeDiv.attr('id', 'typeDivId'); // 给父div设置id
					typeDiv.appendTo('body');
					// 动态typeDIV
					var typeUl = $('<ul id="typeUlId"></ul>');
					typeUl.appendTo(typeDiv);

					// 动态commonDiv
					var commonDiv = $('<div></div>'); // 创建一个父div
					commonDiv.attr('id', 'commonDivId'); // 给父div设置id
					commonDiv.appendTo('body');
					// 动态commonDiv
					var commonUl = $('<ul id="commonUlId"></ul>');
					commonUl.appendTo(commonDiv);

					// $('#textShow').click(function(e) {
					// if (insertedFlag == 1) {
					// var x = getX(e);
					// var y = getY(e);
					// elementDiv.css({
					// "left" : x,
					// "top" : y + 10,
					// "display" : "inline"
					// });
					// } else {
					// $('#textShow').insertContent(elementMap.get(insertedEle));
					// insertedFlag = 1;
					// insertedEle = "";
					// }
					// });
					// 取消弹出框
					$(document).keyup(function(event) {
						switch (event.keyCode) {
						case 27:
							displayElementDiv();
							displayTypeDiv();
						}
					});
					// 取消弹出框
					function displayElementDiv() {
						elementDiv.css({
							"display" : "none"
						});
					}
					function showElementDiv() {
						elementDiv.css({
							"display" : "none"
						});
					}
					function displayTypeDiv() {
						typeDiv.css({
							"display" : "none"
						});
					}
					function displayCommonIdDiv() {
						commonDiv.css({
							"display" : "none"
						});
					}
					// $('#textShow').dblclick(function(e) {
					//
					// elementDiv.css({
					// "display":"none"
					// });
					// });
					function getX(e) {
						e = e || window.event;
						return e.pageX || e.clientX + document.body.scroolLeft;
					}

					function getY(e) {
						e = e || window.event;
						return e.pageY || e.clientY + document.boyd.scrollTop;
					}
					var enterAlt = "\n";
					var oneSpace = "  ";
					var twoSpace = "      ";
					var threeSpace = "        ";
					var fourSpace = "          ";
					var fiveSpace = "            ";
					// 格式化
					$('#showImgId')
							.click(
									function(e) {
										var oldStr = $('#textShow').val();
										var replaceDenoter = oldStr.replace(
												/<Denoter/g, enterAlt
														+ fiveSpace
														+ '<Denoter');
										var replaceMeans = replaceDenoter
												.replace(/<Means/g, enterAlt
														+ fiveSpace + '<Means');
										var replaceTime = replaceMeans.replace(
												/<Time/g, enterAlt + fiveSpace
														+ '<Time');
										var replaceLocation = replaceTime
												.replace(/<Location/g, enterAlt
														+ fiveSpace
														+ '<Location');
										var replaceParticipant = replaceLocation
												.replace(
														/<Participant/g,
														enterAlt
																+ fiveSpace
																+ '<Participant');
										var replaceObject = replaceParticipant
												.replace(/<Object/g, enterAlt
														+ fiveSpace + '<Object');
										var replaceEvent1 = replaceObject
												.replace(/<Event/g, enterAlt
														+ fourSpace + '<Event');
										var replaceEvent2 = replaceEvent1
												.replace(/<\/Event>/g, enterAlt
														+ fourSpace
														+ '</Event>');
										var replaceSentence1 = replaceEvent2
												.replace(/<Sentence>/g,
														enterAlt + threeSpace
																+ '<Sentence>');
										var replaceSentence2 = replaceSentence1
												.replace(/<\/Sentence>/g,
														enterAlt + threeSpace
																+ '</Sentence>');
										var replaceParagraph1 = replaceSentence2
												.replace(/<Paragraph>/g,
														enterAlt + twoSpace
																+ '<Paragraph>');
										var replaceParagraph2 = replaceParagraph1
												.replace(
														/<\/Paragraph>/g,
														enterAlt
																+ twoSpace
																+ '</Paragraph>');
										var replaceContent1 = replaceParagraph2
												.replace(/<Content>/g, enterAlt
														+ oneSpace
														+ '<Content>');
										var replaceContent2 = replaceContent1
												.replace(/<\/Content>/g,
														enterAlt + oneSpace
																+ '</Content>');
										var replaceReportTime = replaceContent2
												.replace(
														/<ReportTime>/g,
														enterAlt
																+ '<ReportTime>');
										var replaceTitle = replaceReportTime
												.replace(/<Title>/g, enterAlt
														+ '<Title>');
										var replaceBody1 = replaceTitle
												.replace(/<Body>/g, enterAlt
														+ '<Body>');
										var replaceBody2 = replaceBody1
												.replace(/<\/Body>/g, enterAlt
														+ '</Body>');
										var replaceeRelation = replaceBody2
												.replace(/<eRelation/g,
														enterAlt + twoSpace
																+ '<eRelation');
										// elementMap.put("<Denoter>",
										// "</Denoter>");
										// elementMap.put("<Means>",
										// "</Means>");
										// elementMap.put("<Time>", "</Time>");
										// elementMap.put("<Location>",
										// "</Location>");
										// elementMap.put("<Participant>",
										// "</Participant>");
										// elementMap.put("<Object>",
										// "</Object>");
										// elementMap.put("<Event>",
										// "</Event>");
										// elementMap.put("<Sentence>",
										// "</Sentence>");
										// elementMap.put("<Paragraph>",
										// "</Paragraph>");
										// elementMap.put("<Content>",
										// "</Content>");
										// elementMap.put("<ReportTime>",
										// "</ReportTime>");
										// elementMap.put("<Title>",
										// "</Title>");
										// elementMap.put("<Body>", "</Body>");

										var strArray = replaceeRelation
												.split(enterAlt);
										// 此处如果不定义，那么会出现undefined
										var showStr = "";
										for (var i = 0; i < strArray.length; i++) {
											var showStrTemp = strArray[i]
													.replace(/^\s*$/, "");
											if (showStrTemp != ""
													&& showStrTemp != null) {
												showStr += showStrTemp
														+ enterAlt;
											}
										}
										$('#textShow').val(showStr);
									});
					// auto insert id
					var iDBridge = new hashmap();
					iDBridge.put("Denoter", " did=\"d\"");
					iDBridge.put("Means", " mid=\"m\"");
					iDBridge.put("Time", " tid=\"t\"");
					iDBridge.put("Location", " lid=\"l\"");
					iDBridge.put("Participant", " sid=\"s\"");
					iDBridge.put("Object", " oid=\"o\"");
					iDBridge.put("Event", " eid=\"e\"");
					var commonIdList = new ArrayList();
					commonIdList.add(" sid=\"s\"");
					commonIdList.add(" oid=\"o\"");
					var needIdList = new ArrayList();
					needIdList.add("Denoter");
					needIdList.add("Means");
					needIdList.add("Time");
					needIdList.add("Location");
					needIdList.add("Participant");
					needIdList.add("Object");
					needIdList.add("Event");

					var timeTypeList = new ArrayList();
					timeTypeList.add(" type=\"absTime\"");
					timeTypeList.add(" type=\"relTime\"");
					timeTypeList.add(" type=\"timeInterval\"");

					var eventTypeList = new ArrayList();
					eventTypeList.add(" type=\"emergency\"");
					eventTypeList.add(" type=\"thoughtevent\"");

					var denoterTypeList = new ArrayList();
					denoterTypeList.add(" type=\"movement\"");
					denoterTypeList.add(" type=\"statement\"");
					denoterTypeList.add(" type=\"action\"");
					denoterTypeList.add(" type=\"operation\"");
					denoterTypeList.add(" type=\"stateChange\"");
					denoterTypeList.add(" type=\"perception\"");

					var typeBridge = new hashmap();
					typeBridge.put("Time", timeTypeList);
					typeBridge.put("Event", eventTypeList);
					typeBridge.put("Denoter", denoterTypeList);
					// auto insert id
					// auto insert

					$("#textShow").select(function() {
						startIndexPub = $("#textShow").selection().start;
						endIndexPub = $("#textShow").selection().end;
						selectStrPub = $("#textShow").selection().text;
						$("#start").val(startIndex);
						$("#end").val(endIndex);
						$("#text").val(selectStr);
					})

					$("#textShow")
							.click(
									function(e) {
										if (modelState == 1) {
											// $("#start").val($("#textShow").selection().start);
											var mouseIndex = $("#textShow")
													.selection().start;
											var resultCheck = judgeTag($(
													'#textShow').val(),
													mouseIndex, '<', '>', '/');
											if (resultCheck.result == 1) {
												var startTagIndex = resultCheck.start;
												var endTagIndex = resultCheck.end;
												var selectStr = $('#textShow')
														.val()
														.substr(
																startTagIndex + 1,
																endTagIndex
																		- startTagIndex
																		- 1);
												var locationCheck = judgeLocation(
														$('#textShow').val(),
														mouseIndex);
												// alert("resultCheck"+resultCheck+"
												// "+"locationCheck"+locationCheck);
												if (locationCheck == true) {
													var resJudgeElement = judgeElement(
															selectStr,
															needIdList);
													// alert("startTagIndex"+startTagIndex+"
													// "+"endTagIndex"+endTagIndex+"
													// "+"selectStr
													// "+selectStr);
													// alert (res);

													if (resJudgeElement.result != "unMutch") {
														if (resJudgeElement.state == 1) {
															if (iDBridge
																	.get(resJudgeElement.result) != null) {
																if (resJudgeElement.result == "Participant"
																		|| resJudgeElement.result == "Object") {
																	var list = document
																			.getElementById("commonUlId");
																	var len = list.children.length;
																	if (len != null) {
																		var elem = list
																				.getElementsByTagName("li");
																		while (len) {
																			len--;
																			list
																					.removeChild(elem[len]);
																		}
																	}
																	for (i = 0; i < commonIdList
																			.size(); i++) {
																		var reg = /".*?"/;
																		var commonIdTemp = reg
																				.exec(commonIdList
																						.get(i))
																		var elementStr = resJudgeElement.result;
																		var parem1 = "insertCommonId"
																				+ "("
																				+ commonIdTemp[0]
																				+ ",'"
																				+ elementStr
																				+ "',"
																				+ mouseIndex
																				+ ")";
																		var parem2 = parem1
																				.replace(
																						/"/g,
																						"'");
																		// 传递参数应该为单引号：<input
																		// type
																		// ="button"
																		// value
																		// ="button"
																		// onclick
																		// ="test(’note.xml‘);"
																		// />
																		var commonIdLi = $('<li onclick="'
																				+ parem2
																				+ '";>'
																				+ commonIdList
																						.get(i)
																				+ '</li>');
																		commonIdLi
																				.attr(
																						'id',
																						i
																								+ "Id");
																		commonIdLi
																				.appendTo(commonUl);
																	}
																	changeDivLoc(
																			commonDiv,
																			e,
																			2);
																} else {
																	var regStr = new RegExp(
																			"<"
																					+ resJudgeElement.result
																					+ ".*?>");
																	var tagNum = getTagId(
																			$(
																					'#textShow')
																					.val(),
																			regStr,
																			mouseIndex) + 1;
																	var idStr = iDBridge
																			.get(resJudgeElement.result);
																	var tempIdStr = idStr
																			.substr(
																					0,
																					idStr.length - 1)
																			+ tagNum
																			+ "\"";
																	$(
																			'#textShow')
																			.insertContent(
																					tempIdStr);
																}
															}
															//												
														} else if (resJudgeElement.state == 2) {
															if (typeBridge
																	.get(resJudgeElement.result) != null) {
																var typeList = typeBridge
																		.get(resJudgeElement.result);
																var list = document
																		.getElementById("typeUlId");
																var len = list.children.length;
																if (len != null) {
																	var elem = list
																			.getElementsByTagName("li");
																	while (len) {
																		len--;
																		list
																				.removeChild(elem[len]);
																	}
																}
																for (i = 0; i < typeList
																		.size(); i++) {
																	var reg = /".*?"/;
																	var typeTemp = reg
																			.exec(typeList
																					.get(i))
																	var parem1 = "insertType"
																			+ "("
																			+ typeTemp[0]
																			+ ")";
																	var parem2 = parem1
																			.replace(
																					/"/g,
																					"'");
																	// 传递参数应该为单引号：<input
																	// type
																	// ="button"
																	// value
																	// ="button"
																	// onclick
																	// ="test(’note.xml‘);"
																	// />
																	var typeLi = $('<li onclick="'
																			+ parem2
																			+ '";>'
																			+ typeList
																					.get(i)
																			+ '</li>');
																	typeLi
																			.attr(
																					'id',
																					i
																							+ "Id");
																	typeLi
																			.appendTo(typeUl);
																}
																changeDivLoc(
																		typeDiv,
																		e,
																		typeList
																				.size());
															}
														} else if (resJudgeElement.state == 3) {
															if (iDBridge
																	.get(resJudgeElement.result) != null) {
																var regStr = new RegExp(
																		"<"
																				+ resJudgeElement.result
																				+ ".*?>");
																getTagId(
																		$(
																				'#textShow')
																				.val(),
																		regStr,
																		mouseIndex);
																$('#textShow')
																		.insertContent(
																				iDBridge
																						.get(resJudgeElement.result));

															}

														}

													}

												}
											} else if (resultCheck.result == 2) {
												if (insertedFlag == 1) {
													changeDivLoc(elementDiv, e,
															13);
												} else {
													$('#textShow')
															.insertContent(
																	elementMap
																			.get(insertedEle));
													insertedFlag = 1;
													insertedEle = "";
												}
											}

										}
									})
					$("#textShow").click(function() {
						startIndex = $("#textShow").selection().start;
						endIndex = $("#textShow").selection().end;
						selectStr = $("#textShow").selection().text;
						$("#start").val(startIndex);
						$("#end").val(endIndex);
						$("#text").val(selectStr);
					})

					// copy operater
					$("#copyImgId").click(function() {

					})

					// end auto insert

					// 格式化

					// $("#changeModel").click(function() {
					// var modelStr = $("#changeModel").val();
					// if (modelStr == "手动模式") {
					// modelState = 1;
					// $("#changeModel").val("半自动模式");
					// } else if (modelStr == "半自动模式") {
					// modelState = 0;
					// $("#changeModel").val("手动模式");
					// }
					// })
					// function judgeModel() {
					// var modelStr = $("#changeModel").val();
					// if (modelStr == "手动模式") {
					// modelState = 0;
					// } else if (modelStr == "半自动模式") {
					// modelState = 1;
					// }
					// return modelState;
					// }
					function changeDivLoc(targetDiv, e, offsetNum) {
						var offset = 18;
						var x = getX(e);
						var y = getY(e);
						var top;
						var textShowHeight = $('#textShow').height();
						var typeUlHeight = offset * offsetNum;
						var tempY = y
						if ((tempY + typeUlHeight) > textShowHeight) {
							top = tempY - typeUlHeight - 5
									- $(document).scrollTop();
						} else {
							top = tempY + 10 - $(document).scrollTop();
						}
						targetDiv.css({
							"left" : x,
							"top" : top,
							"display" : "inline"
						});
					}

					// download
					$("#downloadImgId")
							.click(
									function() {

										$
												.ajax({
													type : "post",
													url : basePath2,
													data : "",
													datatype : "json",
													success : function(data) {
														var result = eval("("
																+ data + ")");
														documentVOList = result.path;
														$("#corpusListId")
																.empty();
														if (documentVOList.length > 0) {
															var table = $("<table  border=\"1\">");
															table.attr('id',
																	"tableId");

															table
																	.appendTo($("#corpusListId"));
															// 头表格
															var header = $("<tr style='background-color: rgb(212, 227, 229);'></tr>");
															header
																	.appendTo(table);
															var seqtd = $("<td>序号</td>");
															seqtd
																	.appendTo(header);
															var seqtd = $("<td>文件名</td>");
															seqtd
																	.appendTo(header);
															var seqtd = $("<td>创建时间</td>");
															seqtd
																	.appendTo(header);
															var seqtd = $("<td>修改时间</td>");
															seqtd
																	.appendTo(header);
															var seqtd = $("<td>操作</td>");
															seqtd
																	.appendTo(header);
															for (i = 0; i < documentVOList.length; i++) {
																documentVOList[i].fileName
																var parem1 = "download"
																		+ "("
																		+ i
																		+ ")";
																var tr = $("<tr style='background-color: rgb(212, 227, 229);'></tr>");
																tr
																		.appendTo(table);
																for (var j = 0; j < 5; j++) {
																	if (j == 0) {
																		var td = $("<td>"
																				+ i
																				+ "</td>");
																		td
																				.appendTo(tr);
																	} else if (j == 1) {
																		var td = $("<td>"
																				+ documentVOList[i].fileName
																				+ "</td>");
																		td
																				.appendTo(tr);
																		// var
																		// documentLi
																		// =
																		// $('<li
																		// onclick="'+parem1+'";>'
																		// +
																		// documentVOList[i].fileName
																		// +
																		// '</li>');
																		// documentLi.attr('id',i+
																		// "Id");
																		// documentLi.appendTo(td);
																	} else if (j == 2) {
																		var td = $("<td>"
																				+ documentVOList[i].createTime
																				+ "</td>");
																		td
																				.appendTo(tr);
																	} else if (j == 3) {
																		var td = $("<td>"
																				+ documentVOList[i].updateTime
																				+ "</td>");
																		td
																				.appendTo(tr);
																	} else if (j == 4) {
																		var td = $('<td onclick="'
																				+ parem1
																				+ '";>下载</td>');
																		td
																				.appendTo(tr);
																	}
																}
															}
															$("#corpusListId")
																	.append(
																			"</table>");
															table
																	.attr(
																			'class',
																			"altrowstable");
															$("tr:gt(0)")
																	.find(
																			"td:eq(4)")
																	.on(
																			'mouseover',
																			function() {
																				this.style.backgroundColor = '#ffff66';
																			});
															$("tr:gt(0)")
																	.find(
																			"td:eq(4)")
																	.on(
																			'mouseout',
																			function() {
																				this.style.backgroundColor = '#d4e3e5';
																				// this.style.backgroundColor='#none';
																			});
														} else {
															var message = $("<p>没有语料文件</p>");
															message
																	.appendTo($("#corpusListId"));
														}
													}

												})
										$('#downloadDivHide').fadeIn(100);
										$('#downloadDiv').slideDown(200);
									})

					// $('.theme-login').click(function(){
					// $('.theme-popover-mask').fadeIn(100);
					// $('.theme-popover').slideDown(200);
					// })
					$('.theme-poptit .close').click(function() {
						$('.theme-popover').fadeOut(100);
						$('.theme-popover-mask').slideUp(200);

					})
					$('.theme-poptit .close2').click(function() {
						$('#infoDivHide').fadeOut(100);
						$('#infoDiv').slideUp(200);
					})

					// $('.theme-poptit .close4').click(function(){
					// $('#saveRTDivHide').fadeOut(100);
					// $('#saveRTDiv').slideUp(200);
					// })
					$('.theme-poptit .close5').click(function() {
						$('#yesOrNoDivHide').fadeOut(100);
						$('#yesOrNoDiv').slideUp(200);
					})
					$('.theme-poptit2 .close6').click(function() {
						$('#modelTipDivHide').fadeOut(100);
						$('#modelTipDiv').slideUp(200);
					})
					$('.theme-poptit2 .close7').click(function() {
						$('#findDiv').slideUp(200);
					})
					$('.theme-poptit2 .close8').click(function() {
						$('#replaceDiv').slideUp(200);
					})
					function download(i) {
						$("#fra").attr(
								"src",
								"download!download?filePath="
										+ documentVOList[i].fileName + "");
						// location.href="download!download?filePath="+documentVOList[i].fileName;
					}
					function changeTrColor() {
						this.style.backgroundColor = '#ffff66';
					}
					// 文件操作模块开始
					$("#newId").click(function() {
						fileStatusPub = 0;
						if ($('#textShow').val() != "") {
							$('#yesOrNoDivHide').fadeIn(100);
							$('#yesOrNoDiv').slideDown(200);
						} else {
							clearFileName();
							$('#saveDivHide').fadeIn(100);
							$('#saveDiv').slideDown(200);
						}
						$('#textShow').removeAttr("readonly");
						// $("#textShow").focus();
						displayFileDiv();
					});

					function clearFileName() {
						$('#saveTextId').val("");
						fileNamePub = "";
					}
					// 根据文件以及状态判断是否需要保存
					$('#yesButtonId').click(function() {
						var checkResult = validateXML('textShow');

						if (checkResult == "right") {
							saveNoAjax($('#textShow').val(), fileNamePub);
							if (saveResult) {
								$('#textShow').val("");
								saveResult = false;
								closeSaveDiv();
								if (fileStatusPub == 0) {
									clearFileName();
									$('#saveDivHide').fadeIn(100);
									$('#saveDiv').slideDown(200);
								}
								if (fileStatusPub == 1) {
									$("#file_upload").trigger("click");
								} else if (fileStatusPub == 2) {
									getFileList();
								}
							}
						} else {
							alert(checkResult);
							closeSaveDiv()
						}
					});
					$('#noButtonId').click(function() {
						$('#textShow').val("");
						closeSaveDiv();
						if (fileStatusPub == 0) {
							clearFileName();
							$('#saveDivHide').fadeIn(100);
							$('#saveDiv').slideDown(200);
						} else if (fileStatusPub == 1) {
							$("#file_upload").trigger("click");
						} else if (fileStatusPub == 2) {
							getFileList();
						}

					});
					$("#saveButtonId").click(function() {
						fileNamePub = $("#saveTextId").val() + ".xml";
						$('#saveDivHide').fadeOut(100);
						$('#saveDiv').slideUp(200);
					})

					$("#openId").click(function() {
						$("#openImgId").trigger("click");
						displayFileDiv();
						$('#textShow').removeAttr("readonly");

					});
					$("#saveId").click(function() {
						displayFileDiv();
						$("#saveImgId").trigger("click");
					});

					$("#remoteId").click(function() {
						fileStatusPub = 2;
						if ($('#textShow').val() != "") {
							$('#yesOrNoDivHide').fadeIn(100);
							$('#yesOrNoDiv').slideDown(200);
						} else {
							getFileList();
						}
						$('#textShow').removeAttr("readonly");
						$("#textShow").focus();
						displayFileDiv();
					});
					function openRT(i) {
						// alert(documentVOList[i].filePath);
						$.ajax({
							// type: 'GET',
							// dataType: 'xml',
							// timeout: 2000,
							// error: function(xml){
							// alert('Error loading XML
							// document'+xml.responseText);
							// },

							url : documentVOList[i].filePath,
							dataType : 'text',
							success : function(data) {
								// alert(data.trim());
								// alert(data.responseText);
								fileNamePub = documentVOList[i].fileName;
								$("#textShow").val(data);

								$('#openRTDivHide').fadeOut(100);
								$('#openRTDiv').slideUp(200);
							}
						});
						// $('#textShow').removeAttr("readonly");
						// $('#textShow').focus();
						// var
						// dddd=$("#textShow").val().substr(0,$("#textShow").val().length-4);
						$("#textShow").val($("#textShow").val());
					}

					// $("#saveRTId").click(function(){
					// $('#saveRTDivHide').fadeIn(100);
					// $('#saveRTDiv').slideDown(200);
					// displayFileDiv();
					// });
					//					
					// $("#saveRTButtonId").click(function(){
					// $.ajax({
					// type:"post",
					// url:"mjolnir_saveTextshow",
					// data:{textshowStr:$("#textShow").val(),docFilename:$("#saveRTTextId").val()+".xml"},
					// datatype:"json",
					// success:function(data){
					// alert("chenggon");
					// }
					// })
					//							
					// $('#saveRTDivHide').fadeOut(100);
					// $('#saveRTDiv').slideUp(200);
					// })
					$("#downloadId").click(function() {
						$("#downloadImgId").trigger("click");
						displayFileDiv();
					});
				

					$("#printId").click(function() {
						// $("#aaaa").val($("#textShow").val());
						$("#printImgId").trigger("click");
						displayFileDiv();
					});
					// 取消弹出框
					function displayFileDiv() {
						var flieDiv = $("#box-1");
						flieDiv.css({
							"display" : "none"
						});
					}

					$("#exitId").click(function() {
						// alert("sddd");
						// window.close();
						open(' ', '_self').close();
					});
					function CloseWebPage() {
						if (navigator.userAgent.indexOf("MSIE") > 0) {
							if (navigator.userAgent.indexOf("MSIE 6.0") > 0) {
								window.opener = null;
								window.close();
							} else {
								window.open('', '_top');
								window.top.close();
							}
						} else if (navigator.userAgent.indexOf("Firefox") > 0) {
							window.location.href = 'about:blank ';
						} else {
							window.opener = null;
							window.open('', '_self', '');
							window.close();
						}
					}
					// $("#readOnlyId").click(function(){
					// if($('#textShow').attr("readonly")){
					// $('#textShow').removeAttr("readonly");
					// $('#readOnlyCBId').removeAttr("checked");
					// }
					// else{
					// $('#textShow').attr("readonly","readonly");
					// $('#readOnlyCBId').attr("checked","checked");
					// }
					// })
					$("#readOnlyCBId").click(function() {
						if ($('#textShow').attr("readonly")) {
							$('#textShow').removeAttr("readonly");
							$('#readOnlyCBId').removeAttr("checked");
						} else {
							$('#textShow').attr("readonly", "readonly");
							$('#readOnlyCBId').attr("checked", "checked");
						}
					})

					$("#findId").click(function() {
						$('#findDiv').slideDown(200);
					});
					$("#findButtonId").click(function() {
						var parentStr = $("#textShow").val();
						var sonStr = $("#findTextId").val();
						if (parentStr != "" && sonStr != "") {
							if (sonStr != findStrPub) {
								findResultPub = getStrIndex(parentStr, sonStr);
								findNextPub = 0;
								findStrPub = sonStr;
								// alert(findResultPub);
								var par = findResultPub.get(findNextPub);
								// alert(par);
								$("#textShow").selectRange(par[0], par[1]);
								findNextPub++;
							} else {
								if (findNextPub < findResultPub.size()) {
									var par = findResultPub.get(findNextPub);
									$("#textShow").selectRange(par[0], par[1]);
									findNextPub++;
								} else {
									findNextPub = 0;
								}
							}
						}
					});
					$("#replaceId").click(function() {
						$('#replaceDiv').slideDown(200);
					});
					$("#replaceButtonId").click(function() {
						var oldStr = $("#oldTextId").val();
						var newStr = $("#replaceTextId").val();
						if (oldStr != "" && newStr != "") {
							var allStr = $('#textShow').val();
							var reg = new RegExp(oldStr, "g");
							var result = allStr.replace(reg, newStr);
							$('#textShow').val(result);
						}
					});
					$("#checkId").click(function() {
						$("#checkImgId").trigger("click");
					});
					$("#deleteId").click(function() {
						$("#deleteImgId").trigger("click");
					});
					$("#showId").click(function() {
						$("#showImgId").trigger("click");
					});
					// 文件操作模块结束
					// 工具栏
					$("#deleteImgId").click(function() {
						removeLabel('textShow');
					})
					$("#saveImgId").click(function() {
						if ($('#textShow').val() != "") {
							var checkResult = validateXML('textShow');
							if (checkResult == "right") {
								saveNoAjax($('#textShow').val(), fileNamePub);
							} else {
								alert(checkResult);
							}
						}
					})
					$("#modelImgId").click(
							function() {

								var modelImg = $("#modelImgId");
								if (modelState == 0) {
									modelImg.attr('src',
											"resources/images/semiAuto.jpg");
									modelState = 1;
								} else {
									modelImg.attr('src',
											"resources/images/manual.jpg");
									modelState = 0;
								}
							})
					$("#checkImgId").click(function() {
						var checkResult = validateXML('textShow');
						alert(checkResult);
					});

					// 工具栏
					// http://zhidao.baidu.com/link?url=S9P_W7Tg0d3JC-ClbLbjCllL0l73woDiUeZZ_0I3H_b5p_nayfnh4d0OGwSRyX5PU902mIalYbIr7i8rU3BbtM2Xr02HnWiIPtMNIQsKnjW
					// jQuery的ready函数中自定义的函数怎么用onclick事件调用？
					// 1种是把那个函数放到ready函数外面。
					// 第2种是在ready函数里面加上window.deleteStu = deleteStu;
					// 即:$(function(){function deleteStu(id){
					// alert(id); }window.deleteStu = deleteStu;}
					window.insertElement = insertElement;
					window.insertType = insertType;
					window.judgeTag = judgeTag;
					window.judgeLocation = judgeLocation;
					window.judgeElement = judgeElement;
					window.elementBridge = elementBridge;
					window.elementMap = elementMap;
					window.elementList = elementList;
					window.getTagId = getTagId;
					window.insertCommonId = insertCommonId;
					window.download = download;
					window.changeTrColor = changeTrColor;
					window.openRT = openRT;
					window.clearFileName = clearFileName;
//					window.getFileList=getFileList;
					
					
				});

function saveNoAjax(value, fileName) {
	$.ajax({
		type : "post",
		async : false,
		url : "mjolnir_saveTextshow",
		data : {
			textshowStr : value,
			docFilename : fileName
		},
		datatype : "json",
		success : function(data) {
			saveResult = true;
		}
	})
}
function closeSaveDiv() {
	$('#yesOrNoDivHide').fadeOut(100);
	$('#yesOrNoDiv').slideUp(200);
}
function getFileList() {

	$
			.ajax({
				type : "post",
				url : "http://localhost:8080/zeus-clientweb-web/upload!fileList.action",
				data : "",
				datatype : "json",
				success : function(data) {
					var result = eval("(" + data + ")");
					documentVOList = result.path;
					$("#fileTableId").empty();
					if (documentVOList.length > 0) {
						var table = $("<table  border=\"1\">");
						table.attr('id', "tableId");

						table.appendTo($("#fileTableId"));
						// 头表格
						var header = $("<tr style='background-color: rgb(212, 227, 229);'></tr>");
						header.appendTo(table);
						var seqtd = $("<td>序号</td>");
						seqtd.appendTo(header);
						var seqtd = $("<td>文件名</td>");
						seqtd.appendTo(header);
						var seqtd = $("<td>创建时间</td>");
						seqtd.appendTo(header);
						var seqtd = $("<td>修改时间</td>");
						seqtd.appendTo(header);
						var seqtd = $("<td>操作</td>");
						seqtd.appendTo(header);
						for (i = 0; i < documentVOList.length; i++) {
							documentVOList[i].fileName
							var parem1 = "openRT" + "(" + i + ")";
							var tr = $("<tr style='background-color: rgb(212, 227, 229);'></tr>");
							tr.appendTo(table);
							for (var j = 0; j < 5; j++) {
								if (j == 0) {
									var td = $("<td>" + i + "</td>");
									td.appendTo(tr);
								} else if (j == 1) {
									var td = $("<td>"
											+ documentVOList[i].fileName
											+ "</td>");
									td.appendTo(tr);
									// var documentLi = $('<li
									// onclick="'+parem1+'";>' +
									// documentVOList[i].fileName + '</li>');
									// documentLi.attr('id',i+ "Id");
									// documentLi.appendTo(td);
								} else if (j == 2) {
									var td = $("<td>"
											+ documentVOList[i].createTime
											+ "</td>");
									td.appendTo(tr);
								} else if (j == 3) {
									var td = $("<td>"
											+ documentVOList[i].updateTime
											+ "</td>");
									td.appendTo(tr);
								} else if (j == 4) {
									var td = $('<td onclick="' + parem1
											+ '";>打开</td>');
									td.appendTo(tr);
								}
							}
						}
						$("#corpusListId").append("</table>");
						table.attr('class', "altrowstable");
						$("tr:gt(0)").find("td:eq(4)").on('mouseover',
								function() {
									this.style.backgroundColor = '#ffff66';
								});
						$("tr:gt(0)").find("td:eq(4)").on('mouseout',
								function() {
									this.style.backgroundColor = '#d4e3e5';
									// this.style.backgroundColor='#none';
								});
					} else {
						var message = $("<p>没有语料文件</p>");
						message.appendTo($("#fileTableId"));
					}
				}

			})
	$('#openRTDivHide').fadeIn(100);
	$('#openRTDiv').slideDown(200);
}