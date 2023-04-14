

var name = GetQueryString("kickout");
if(name==1) {
	$("#falseCode").html("您被踢出登录!");
}


$('#submitbtn').on('click',function(){
	if(!validate()) return;
	
	var params = $("#loginForm").serializeArray();
	
	$.post("/admin/login",params,function(data){
		if(data.status==200){
			location.href ="logout";
		}else if(data.status==400){
			$("#falseCode").html(data.msg);
		}
	});
});


function keyLogin(){
	 if (event.keyCode==13)  //回车键的键值为13
	 {
		 $('#submitbtn').click(); //调用登录按钮的登录事件
	 }
	}

$("#changeImg2").click(function(){
	 
	var imgSrc = $("#imgObj2"); 
	
    var src = imgSrc.attr("src"); 
    imgSrc.attr("src",chgUrl(src));  
});


//验证
function validate(){

	var numReg = /^[0-9_-]+$/;
	var userName = $("#username").val();
	var userPassword = $("#password").val();

	var validateCode = $("#msn").val();
	var LoginURI = $("#LoginURI").val();

	if (userName == "" || userName == null) {
		$("#falseCode").html("请输入用户名!");
		return false;

	}
	if (userPassword == "" || userPassword == null) {
		$("#falseCode").html("请输入密码!");
		return false;

	}

	if (validateCode == "" || validateCode == null) {
		$("#falseCode").html("请输入验证码!");
		return false;
	}

	return true;
}


//时间戳     
//为了使每次生成图片不一致，即不让浏览器读缓存，所以需要加上时间戳     
function chgUrl(url){  
	
    var timestamp = (new Date()).valueOf();     
    urlurl = url.substring(0,17);     
    if((url.indexOf("&")>=0)){     
        urlurl = url + "×tamp=" + timestamp;     
    }else{     
        urlurl = url + "?timestamp=" + timestamp;     
    }     
    return urlurl;     
} 



