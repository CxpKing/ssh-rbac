<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<title>添加用户</title>
<style type="text/css">
.error {
	color:red;
}
.success {
	color:green;
}
</style>
<script type="text/javascript" src="${pageContext.request.contextPath}/admin/js/jquery-3.3.1.min.js"></script>
<script type="text/javascript">
$(function(){
	// blur()表示对象失去焦点后会触发的事件
	$("#account").blur(function(){
		//$("#accountTip").addClass("error");
		//$("#accountTip").removeClass("error");
		var val = $(this).val();
		var reg = /\w{6,16}/;
		if (val != "" && reg.test(val)) {
			/*
			* 异步请求服务器，判断账号是否可用
			* type: 是异步请求提交方式，有两个值：post | get
			* url：异步请求地址，与form表单中的action作用相同
			* data：异步请求的参数列表，格式为：参数名称=值&参数名称=值......
			* cache: 异步请求是否缓存，有两个值：true | false
			* timeout：异步请求超时时间，单位为毫秒
			* async：设置请求方式是否为异步方式，有两个值：true | false，值为true表示异步，false表示同步
			* success：执行成功（是状态码为200）后需要处理的函数。
			* error：执行出错后返回需要处理的函数
			* beforeSend：在执行请求之前会先被执行的函数
			* complete：异步请求执行完后会被执行的函数（不管理是成功还是失败都会被执行到）
			*/
			$.ajax({
			   type: "POST",
			   url: "${pageContext.request.contextPath}/admin/checkAccount",
			   data: "account="+val,
			   timeout: 5000,
			   async: true,
			   success: function(msg){
					if (msg == "true") {
						//$("[type='submit']").attr("disabled","disabled");
						$("#accountTip").removeClass().addClass("error").html("账号已存在，请重新输入。");
					} else {
						$("#accountTip").removeClass().addClass("success").html("账号可用^_^。");
					}
			   },
			   error: function(err){
				   //alert(err);
			   },
			   beforeSend: function() {
				   //alert("准备。。。。。");
			   },
			   complete: function(){
				   //alert("执行完了。。。。");
			   }
			});
		}
	});
	
	
	$("[type='submit']").click(function(){
		if ($("span").hasClass("error")) {
			return false;
		}
		
		$("#nameTip").html("");
		$("#accountTip").html("");
		$("#passwordTip").html("");
		$("#emailTip").html("");
		$("#phoneTip").html("");
		
		// 获取姓名
		var name = $("#name").val();
		var nameReg = /[\u4e00-\u9fa5]{2,8}/;
		// 获取账号
		var account = $("#account").val();
		var accountReg = /\w{6,16}/;
		// 获取密码
		var password = $("#password").val();
		var passwordReg = /\w{6,16}/;
		// 获取邮箱
		var email = $("#email").val();
		var emailReg = /\w+@\w+(\.[a-zA-Z]{2,3}){1,2}/;
		// 获取电话
		var phone = $("#phone").val();
		var phoneReg = /1\d{10}/;
		
		// 开始验证
		if (name == "" || !nameReg.test(name)) {
			$("#nameTip").html("姓名必是汉字，且字数为2~8个。");
			return false;
		}
		if (account == "" || !accountReg.test(account)) {
			$("#accountTip").html("账号不对，必须是6~16个字母、数字或下划线组成。");
			return false;
		}
		if (password == "" || !passwordReg.test(password)) {
			$("#passwordTip").html("密码不对，必须是6~16个字母、数字或下划线组成。");
			return false;
		}
		if (email == "" || !emailReg.test(email)) {
			$("#emailTip").html("邮箱格式不对，如：abc@163.com。");
			return false;
		}
		if (phone == "" || !phoneReg.test(phone)) {
			$("#phoneTip").html("电话格式不对，如：13343567893。");
			return false;
		}
		
		return true;
	});
});
</script>
</head>
<body>
<form action="${pageContext.request.contextPath}/admin/registerHandler" method="post" enctype="multipart/form-data">
<table width="80%" align="center" border="1" cellspacing="0" cellpadding="5" bordercolor="black">
  <tr>
    <th colspan="2">添加用户</th>
  </tr>
  <tr>
    <td width="30%" align="right">姓名</td>
    <td width="70%" align="left"><input type="text" name="name" id="name" value="${user.name}" /> <span id="nameTip">${nameMsg}</span></td>
  </tr>
  <tr>
    <td align="right">账号</td>
    <td align="left"><input type="text" name="account" id="account" value="${user.account}" /> <span id="accountTip">${accounMsg}</span></td>
  </tr>
  <tr>
    <td align="right">密码</td>
    <td align="left"><input type="text" name="password" id="password" /> <span id="passwordTip">${passwordMsg}</span></td>
  </tr>
  <tr>
    <td align="right">邮箱</td>
    <td align="left"><input type="text" name="email" id="email" value="${user.email}" /> <span id="emailTip">${emailMsg}</span></td>
  </tr>
  <tr>
    <td align="right">电话</td>
    <td align="left"><input type="text" name="phone" id="phone" value="${user.phone}" /> <span id="phoneTip">${phoneMsg}</span></td>
  </tr>
  <tr>
    <td align="right">头像</td>
    <td align="left"><input type="file" name="avator1" /></td>
  </tr>
  <tr align="center">
    <td colspan="2"><input type="submit" value="添加"/> <input type="reset" value="取消"/></td>
  </tr>
</table>
</form>
</body>
</html>