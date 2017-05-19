$(document).ready(function() {
	
	$('#username').val("admin2");
	$('#password').val("123");
	
	$('#loginBT').click(function() {
		var userInfo = new UserInfo();
		userInfo.username = $('#username').val();
		userInfo.password = $('#password').val();
		var result = checkNull(userInfo.username, userInfo.password);
		if (result) {
			document.getElementById("submitBt").click();
		}else{
			alert("用户名密码不可为空");
		}
	})

})
function checkNull(username, password) {
	if (null != username && "" != username && null != password
			&& "" != password) {
		return true;
	} else {
		return false;
	}
}