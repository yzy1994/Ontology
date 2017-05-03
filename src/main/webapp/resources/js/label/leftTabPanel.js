var tabpanel;  
var jcTabs = [
'<textarea cols="150"  rows="35" id="textShow" name="contactus"></textarea>',
'<textarea cols="150"  rows="35" id="browserShow" name="contactus"></textarea>'
];
$(document).ready(function(){  
    tabpanel = new TabPanel({  
        renderTo:'leftTab',  
//        height:570,  
        //border:'none',  
        active : 0,
        //maxLength : 10,  
        items : [
            {id:'textTab',title:'Text',html:jcTabs[0],closable: false},  
            {id:'browserTab',title:'Browser',html:jcTabs[1],closable: false},  
        ]
    });  
}); 