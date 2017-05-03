$(document)
		.ready(
				function() {
					// nav-li hover e
					var num;
					$('.nav-main>li[id]').hover(
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
					function insertType(typeStr){
						
						$('#textShow')
						.insertContent(" type="+"\""+typeStr+"\"");
						displayTypeDiv();
					}
					function insertCommonId(commonIdStr,elementStr,mouseIndex){
						var regStr=new RegExp("<"+elementStr+".*?>");
						var tagNum=getTagId($('#textShow').val(),regStr,mouseIndex)+1;
						var idStr=" "+commonIdStr+"id=\""+commonIdStr+"\"";
						var tempIdStr=idStr.substr(0,idStr.length-1)+tagNum+"\"";
						$('#textShow').insertContent(tempIdStr);
//						$('#textShow')
//						.insertContent(" "+commonIdStr+"id=\""+commonIdStr+"\"");
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
					$('#showImgId').click(function(e) {
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
						//此处如果不定义，那么会出现undefined
						var showStr="";
						for ( var i = 0; i < strArray.length; i++) {
							var showStrTemp = strArray[i].replace(/^\s*$/,""); 
							if (showStrTemp != ""  && showStrTemp!=null) {
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
					var commonIdList=new ArrayList();
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
					var startIndex = "";
					var endIndex = "";
					var selectStr = "";
					$("#textShow").select(function() {
						startIndex = $("#textShow").selection().start;
						endIndex = $("#textShow").selection().end;
						selectStr = $("#textShow").selection().text;
						$("#start").val(startIndex);
						$("#end").val(endIndex);
						$("#text").val(selectStr);
					})
				
				$("#textShow").click(function(e) {
					if (judgeModel() == 1) {
						// $("#start").val($("#textShow").selection().start);
						var mouseIndex = $("#textShow")
								.selection().start;
						var resultCheck = judgeTag($(
								'#textShow').val(),
								mouseIndex, '<', '>', '/');
						if(resultCheck.result==1){
								var startTagIndex = resultCheck.start;
								var endTagIndex = resultCheck.end;
								var selectStr = $('#textShow').val().substr(startTagIndex + 1,endTagIndex- startTagIndex- 1);
								var locationCheck=judgeLocation($('#textShow').val(),mouseIndex);
								// alert("resultCheck"+resultCheck+"
								// "+"locationCheck"+locationCheck);
								 if(locationCheck==true){
										var resJudgeElement = judgeElement(
												selectStr, needIdList);
										// alert("startTagIndex"+startTagIndex+"
										// "+"endTagIndex"+endTagIndex+"
										// "+"selectStr
										// "+selectStr);
										// alert (res);
										
										if (resJudgeElement.result != "unMutch") {
											if (resJudgeElement.state == 1) {
												if(iDBridge.get(resJudgeElement.result)!=null){
													if(resJudgeElement.result=="Participant"||resJudgeElement.result=="Object"){														
													    var list = document.getElementById("commonUlId");								    
													    var len  = list.children.length;	
													    if(len!=null){
													    var elem = list.getElementsByTagName("li"); 			
													      while( len ){	
													    	 len--;	
													         list.removeChild( elem[len] );												     													         												     
													        }
													    }
														for (i = 0; i < commonIdList.size(); i++) {
														    var reg=/".*?"/;
														    var commonIdTemp=reg.exec(commonIdList.get(i))
														    var elementStr=resJudgeElement.result;
															var parem1="insertCommonId"+"("+commonIdTemp[0]+",'"+elementStr+"',"+mouseIndex+")";
															var parem2=parem1.replace(/"/g,"'");
//															传递参数应该为单引号：<input type ="button" value ="button" onclick ="test(’note.xml‘);" />
															var commonIdLi = $('<li onclick="'+parem2+'";>' + commonIdList.get(i) + '</li>');						
															commonIdLi.attr('id',i+ "Id");
															commonIdLi.appendTo(commonUl);
														}															 
														 var x = getX(e);
														 var y = getY(e);
														 commonDiv.css({
														 "left" : x,
														 "top" : y + 10,
														 "display" : "inline"
														 });
													}else{
														var regStr=new RegExp("<"+resJudgeElement.result+".*?>");
														var tagNum=getTagId($('#textShow').val(),regStr,mouseIndex)+1;
														var idStr=iDBridge.get(resJudgeElement.result);
														var tempIdStr=idStr.substr(0,idStr.length-1)+tagNum+"\"";
														$('#textShow').insertContent(tempIdStr);
													}
												}
//												
											} else if (resJudgeElement.state == 2) {
												if(typeBridge.get(resJudgeElement.result)!=null)
													{
													    var typeList=typeBridge.get(resJudgeElement.result);														
													    var list = document.getElementById("typeUlId");								    
													    var len  = list.children.length;	
													    if(len!=null){
													    var elem = list.getElementsByTagName("li"); 			
													      while( len ){	
													    	 len--;	
													         list.removeChild( elem[len] );												     													         												     
													        }
													    }
														for (i = 0; i < typeList.size(); i++) {
														    var reg=/".*?"/;
														    var typeTemp=reg.exec(typeList.get(i))
															var parem1="insertType"+"("+typeTemp[0]+")";
															var parem2=parem1.replace(/"/g,"'");
//															传递参数应该为单引号：<input type ="button" value ="button" onclick ="test(’note.xml‘);" />
															var typeLi = $('<li onclick="'+parem2+'";>' + typeList.get(i) + '</li>');						
															typeLi.attr('id',i+ "Id");
															typeLi.appendTo(typeUl);
														}															 
														 var x = getX(e);
														 var y = getY(e);
														 typeDiv.css({
														 "left" : x,
														 "top" : y + 10,
														 "display" : "inline"
														 });
//														$('#textShow').insertContent(typeBridge.get(resJudgeElement.result));
													}									
											} else if (resJudgeElement.state == 3) {
												if(iDBridge.get(resJudgeElement.result)!=null){
													var regStr=new RegExp("<"+resJudgeElement.result+".*?>");
													getTagId($('#textShow').val(),regStr,mouseIndex);
													$('#textShow').insertContent(iDBridge.get(resJudgeElement.result));
													
												}

											}
					
										   }
								
								     }
						} else if(resultCheck.result==2){									     
								 if (insertedFlag == 1) {
									 changeDivLoc(elementDiv,e);
//									 var x = getX(e);
//									 var y = getY(e);
//								     var top;
//								     var textShowHeight=$('#textShow').height();
//								     var typeUlHeight=234;
//								     var tempY=y
//								     if((tempY+typeUlHeight)>textShowHeight){
//								    	 top=tempY-typeUlHeight-5-$(document).scrollTop();
//								     }
//								     else{
//								    	 top=tempY + 10-$(document).scrollTop();
//								     }	
//									 elementDiv.css({
//									 "left" : x,
//									 "top" : top,
//									 "display" : "inline"
//									 });
									 } else {
									 $('#textShow').insertContent(elementMap.get(insertedEle));
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
					var modelState;
					$("#changeModel").click(function() {
						var modelStr = $("#changeModel").val();
						if (modelStr == "手动模式") {
							modelState = 1;
							$("#changeModel").val("半自动模式");
						} else if (modelStr == "半自动模式") {
							modelState = 0;
							$("#changeModel").val("手动模式");
						}
					})
					function judgeModel() {
						var modelStr = $("#changeModel").val();
						if (modelStr == "手动模式") {
							modelState = 0;
						} else if (modelStr == "半自动模式") {
							modelState = 1;
						}
						return modelState;
					}
					function changeDivLoc( targetDiv,e){
						 var x = getX(e);
						 var y = getY(e);
					     var top;
					     var textShowHeight=$('#textShow').height();
					     var typeUlHeight=234;
					     var tempY=y
					     if((tempY+typeUlHeight)>textShowHeight){
					    	 top=tempY-typeUlHeight-5-$(document).scrollTop();
					     }
					     else{
					    	 top=tempY + 10-$(document).scrollTop();
					     }	
					     targetDiv.css({
						 "left" : x,
						 "top" : top,
						 "display" : "inline"
						 });
					}
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
				});
