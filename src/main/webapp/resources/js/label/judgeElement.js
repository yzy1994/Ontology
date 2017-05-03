function judgeElement(judgeStr,needIdList){
	var result,state;
	for (i = 0; i < needIdList.size(); i++) {
		 var reg = new RegExp(needIdList.get(i));
		 var tagNum = judgeStr.split(reg).length-1;
		 if(tagNum>0){
			 result=needIdList.get(i);
			 break;			 
		 }else{
			 result="unMutch";
		 }
	}
	var idNum = judgeStr.split(/id/).length-1;
	var typeNum = judgeStr.split(/type/).length-1;
	if(idNum==0 && typeNum==0){
		state=1;
	}else if(idNum>0 && typeNum==0){
		state=2;
	}else if(idNum=0 && typeNum>0){
		state=3;
	}else if(idNum>0 && typeNum>0){
		state=4;
	}
	return {result:result,state:state};
}
//貌似结论是，没有变量的时候，正则表达式可以不写成字符串的形式两边分别要有反斜杠
//；如果使用变量就要用new RegExp()并且里面的字符串没有那两个反斜杠。
//http://zkeyword.com/post/javascript_replace/
//reg = new RegExp('(\\s|^)' + cls + '(\\s|$)');
//1  2 id 3 type 4 id type