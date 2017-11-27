/**
 * @function 标签页程序
 * 2017/4/5
 * Qiyanhui
 */

function check(){
	//在控制台打印
	//console.log(checkUserName()+"***"+ checkPassword()+"***"+ checkRepassword() +"***"+ checkUserTrueName() +"***"+ checkUserBirthday() +"***"+ checkUserAddress() +"***"+ checkUserTel() +"***"+ checkUserEmail())
	if(checkUserName() && checkPassword() && checkRepassword() && checkUserTrueName() && checkUserBirthday() && checkUserAddress() && checkUserTel() && checkUserEmail()){
		return true;
	}else{
		return false;
	}
}
/*验证前台注册用户的表单*/
 //验证用户名（为3~16个字符，且不能包含@和#号）
 function checkUserName(){
 	var name=document.getElementById("user-name").value.trim();
 	var nameRegex=/^[^@#]{1,5}$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("nameInfo").innerHTML="<span style='color:red;'>* 用户名为1~5个字符，且不能包含”@”和“#“字符</span>";
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
 
  //验证真实姓名（为3~16个字符，且不能包含@和#号）
 function checkUserTrueName(){
 	var name=document.getElementById("user-TrueName").value.trim();
 	var nameRegex=/^[\u4e00-\u9fa5]{2,4}$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("TrueNameInfo").innerHTML="<span style='color:red;'>*真实姓名为2~4个汉字</span>";
 		return false;
 	}else{
 		document.getElementById("TrueNameInfo").innerHTML="";
 		return true;
 	}
 }

  //验证用户生日（只支持yyyy-mm-dd格式）
 function checkUserBirthday(){
 	var name=document.getElementById("user-birthday").value.trim();
 	var nameRegex=/^(19|20)\d{2}-(1[0-2]|0?[1-9])-(0?[1-9]|[1-2][0-9]|3[0-1])$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("birhdayInfo").innerHTML="<span style='color:red;'>*您输入的格式有误，生日格式为yyyy-mm-dd</span>";
 		return false;
 	}else{
 		document.getElementById("birhdayInfo").innerHTML="";
 		return true;
 	}
 }
 
   //验证家庭住址（为5到50个汉字）
 function checkUserAddress(){
 	var name=document.getElementById("user-Address").value.trim();
 	var nameRegex=/^[\u4e00-\u9fa5]{5,50}$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("AddressInfo").innerHTML="<span style='color:red;'>*您输入的家庭住址不规范</span>";
 		return false;
 	}else{
 		document.getElementById("AddressInfo").innerHTML="";
 		return true;
 	}
 }

//验证手机号
 function checkUserTel(){
 	var name=document.getElementById("user-Tel").value.trim();
 	var nameRegex=/^(((1[3456789][0-9]{1})|(15[0-9]{1}))+\d{8})$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("TelInfo").innerHTML="<span style='color:red;'>*您输入的手机号码不正确</span>";
 		return false;
 	}else{
 		document.getElementById("TelInfo").innerHTML="";
 		return true;
 	}
 }
 
 //邮箱验证
 function checkUserEmail(){
 	var name=document.getElementById("user-Email").value.trim();
 	var nameRegex=/^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
 	if(!nameRegex.test(name)){
 		document.getElementById("EmailInfo").innerHTML="<span style='color:red;'>*您输入的邮箱格式不正确</span>";
 		return false;
 	}else{
 		document.getElementById("EmailInfo").innerHTML="";
 		return true;
 	}
 }
 
  // 邮箱验证
 var btn = document.getElementById('submitBtn');
 btn.onclick = function(){
 	var nReg = /^[A-Za-z0-9\u4e00-\u9fa5]+@[a-zA-Z0-9_-]+(\.[a-zA-Z0-9_-]+)+$/;
 	if (!nReg.test($("#mailname").val())) {
 		alert("请填写正确邮箱！！！");
 		return false;
 	};
 }



 /*修改用户表单验证*/
 //验证密码（长度在4个字符到16个字符）
 function checkPassword1(){
 	var password1=document.getElementById("password1").value.trim();
 	var passwordRegex=/^[0-9A-Za-z_]\w{3,15}$/;
 	if(!passwordRegex.test(password1)){
 		document.getElementById("passwordInfo1").innerHTML="<span style='color:red;'>*密码长度必须在4个字符到16个字符</span>";
 	}else{
 		document.getElementById("passwordInfo1").innerHTML="";
 	}
 }

 //校验密码
 function checkRepassword1(){
 	var repassword1=document.getElementById("repassword1").value.trim();
 	var password=document.getElementById("password1").value.trim();
 	if(repassword!==password1){
 		document.getElementById("repasswordInfo1").innerHTML="<span style='color:red'>*两次输入的密码不一致</span>";
 	}else if(repassword==password){
 		document.getElementById("repasswordInfo1").innerHTML="";
 	}
 }

 //模态框
 function overlay(){
 	alert(1);
    var e1 = document.getElementById('modal-overlay');           
    e1.style.display =  (e1.style.display == "block"  ) ? "none" : "block";
}

