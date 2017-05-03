function copyToList(from,to) //from表示:包含可选择项目的select对象名字 to表示:列出可选择项目的select对象名字 //你可以根据你的具体情况修改 
{ 
  fromList = eval('document.forms[0].' + from); 
  toList = eval('document.forms[0].' + to); 
  if (toList.options.length > 0  &&  toList.options[0].value == 'temp') 
  { 
    toList.options.length = 0; 
  } 
  var sel = false; 
  for (i=0;i<fromList.options.length;i++) 
  { 
    var current = fromList.options[i]; 
    if (current.selected) 
    { 
      sel = true; 
      if (current.value == 'temp') 
      { 
        alert ('你不能选择这个项目!'); 
        return; 
      } 
      txt = current.text; 
      val = current.value; 
      toList.options[toList.length] = new Option(txt,val); 
      fromList.options[i] = null; 
      i--; 
    } 
  } 
  if (!sel) alert ('你还没有选择任何项目'); 
} 
function allSelect() //这是当用户按下提交按钮时，对列出选择的select对象执行全选工作，让递交至的后台程序能取得相关数据 
{ 
  List = document.forms[0].chosen; 
  if (List.length  &&  List.options[0].value == 'temp') return; 
  for (i=0;i<List.length;i++) 
  { 
     List.options[i].selected = true; 
  } 
} 