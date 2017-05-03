var tabpanel2;  
var jcTabs2 = [
'<div class="zTreeDemoBackground left">	<ul id="labelTreeUl" class="ztree"></ul></div>',
'<div class="zTreeDemoBackground left">	<ul id="insertTreeUl" class="ztree"></ul></div>',
'You can close me by click fork button'
];
$(document).ready(function(){  
    tabpanel2 = new TabPanel({  
        renderTo:'rightTab',  
//        height:600,  
        //border:'none',  
        active : 0,
        //maxLength : 10,  
        items : [
            {id:'labelTab',title:'label select',html:jcTabs2[0],closable: false},  
            {id:'insertTab',title:'insert at cursor',html:jcTabs2[1],closable: false},  
            {id:'toolsTab',title:'tools',html:jcTabs2[2],closable: false},  

        ]
    });  
}); 