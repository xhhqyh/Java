/**
 * @function 标签页程序
 * 2017/4/5
 * Qiyanhui
 * 后台管理员注册信息验证
 */

function check(){
	//在控制台打印
	//console.log(checkUserName()+"***"+ checkPassword()+"***"+ checkRepassword() +"***"+ checkUserTrueName() +"***"+ checkUserBirthday() +"***"+ checkUserAddress() +"***"+ checkUserTel() +"***"+ checkUserEmail())
	if(checkUserName() && checkPassword() && checkRepassword() && CheckContent()){
		return true;
	}else{
		return false;
	}
}
/*验证前台注册用户的表单*/
 //验证用户名（为3~16个字符，且不能包含@和#号）
 function checkUserName(){
 	var name=document.getElementById("user-name").value.trim();
 	var nameRegex=/^[^@#]{1,10}$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("nameInfo").innerHTML="<span style='color:red;'>* 用户名为1~10个字符,不能包含@和#</span>";
 		return false;
 	}else{
 		document.getElementById("nameInfo").innerHTML="";
 		return true;
 	}
 }

 //验证密码（长度在4个字符到16个字符）
 function checkPassword(){
 	var password=document.getElementById("password").value.trim();
 	var passwordRegex=/^[0-9A-Za-z_]\w{3,15}$/;
 	if(!passwordRegex.test(password)){
 		document.getElementById("passwordInfo").innerHTML="<span style='color:red;'>*密码长度必须在4个字符到16个字符</span>";
 		return false;
 	}else{
 		document.getElementById("passwordInfo").innerHTML="";
 		return true;
 	}
 }


 //校验密码
 function checkRepassword(){
 	var repassword=document.getElementById("repassword").value.trim();
 	var password=document.getElementById("password").value.trim();
 	if(repassword!==password){
 		document.getElementById("repasswordInfo").innerHTML="<span style='color:red'>*两次输入的密码不一致</span>";
 		return false;
 	}else if(repassword==password){
 		document.getElementById("repasswordInfo").innerHTML="";
 		return true;
 	}
 }
 
   //验证备注信息（为5到50个汉字）
 function CheckContent(){
 	var name=document.getElementById("user-Address").value.trim();
 	var nameRegex=/^[\u4e00-\u9fa5]{1,25}$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("AddressInfo").innerHTML="<span style='color:red;'>*1~25个汉字</span>";
 		return false;
 	}else{
 		document.getElementById("AddressInfo").innerHTML="";
 		return true;
 	}
 }


