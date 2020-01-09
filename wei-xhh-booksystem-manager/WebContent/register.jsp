<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>新用户注册</title>

<!-- 引入外部文件 -->
<link rel="stylesheet"  type="text/css"  href="css/bootstrap.min.css"/>
<link rel="stylesheet" type="text/css"  href="css/style.css"/>
<script type="text/javascript" src="js/jquery-1.11.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.min.js"></script>
<!-- 表单校验插件 -->
<script type="text/javascript" src="js/jquery.validate.js"></script>
<!-- 中文提示插件 -->
<script type="text/javascript" src="js/messages_zh.js"></script>
<script type="text/javascript">

$(function(){
	$("#signupForm").validate({
		//校验规则
		rules:{
			username:{
				required:true,//必填
				remote:{
					type : "POST", //请求方式
					url : "checkNameServlet", //请求地址
					data : {"username":function(){return $("#username").val()}} //请求数据
				}
			},
			password:{
				required:true,
				minlength :6 //最小长度为6
			},
			confirmPwd:{
				equalTo:"#password" //与id为password的输入框的值一样
			},
			email:{
				required:true,
				email:true //校验邮箱格式
			},
			
		},
		//错误提示信息（messages也可以不写，使用默认的提示信息）
		messages:{
			username:{
				required:"请输入用户名",
				remote:"用户名重复了,请重新输入"
			},
			password:{
				required:"请输入密码",
				minlength :"密码长度不能小于6位" //最小长度为6
			},
			confirmPwd:{
				equalTo:"两次输入密码不一致" //与id为password的输入框的值一样
			},
			email:{
				required:"请输入邮箱地址",
				email:"邮箱格式不正确" //校验邮箱格式
			}
		}
	
	})
})
</script>
<style>
body {
	margin-top: 20px;
	margin: 0 auto;
}

.carousel-inner .item img {
	width: 100%;
	height: 300px;
}

font {
	color: #3164af;
	font-size: 18px;
	font-weight: normal;
	padding: 0 10px;
}
</style>
</head>
<body>
	<div><img src="images/logo.png" width="195" height="50" style="margin-left:175px" /></div>
	<div class="container"
		style="width: 100%; background: url('image/regist_bg.jpg');">
		<div class="row">
			<div class="col-md-2"></div>
			<div class="col-md-8"
				style="background: #fff; padding: 40px 80px; margin: 30px; border: 7px solid #ccc;">
				<font>新用户注册</font>USER REGISTER
				
				<!-- 注册表单 -->
				<form action="registerServlet" method="POST" id="signupForm" class="form-horizontal" style="margin-top: 5px;">
					<div class="form-group">
						<label for="username" class="col-sm-2 control-label">用户名</label>
						<div class="col-sm-6">
							<input type="text" class="form-control" id="username"
								placeholder="请输入用户名" name="username">
						</div>
					</div>
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="password"
								placeholder="请输入密码" name="password">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputPassword3" class="col-sm-2 control-label">确认密码</label>
						<div class="col-sm-6">
							<input type="password" class="form-control" id="confirmPwd"
								placeholder="请确认密码" name="confirmPwd">
						</div>
					</div>
					
					<div class="form-group">
						<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
						<div class="col-sm-6">
							<input type="email" class="form-control" id="email"
								placeholder="请输入有效的邮箱地址" name="email">
						</div>
					</div>
					
					<div class="form-group opt">
						<label for="inlineRadio1" class="col-sm-2 control-label">性别</label>
						<div class="col-sm-6">
							<label class="radio-inline"> <input type="radio"
								name="gender" id="sex" value="男" checked="checked"> 男
							</label> <label class="radio-inline"> <input type="radio"
								name="gender" id="sex" value="女"> 女
							</label>
						</div>
					</div>
					

					<div class="form-group">
						<div class="col-sm-offset-2 col-sm-10">
							<input type="submit" width="100" value="注册" name="submit"
								style="background: url('images/register.gif') no-repeat scroll 0 0 rgba(0, 0, 0, 0); height: 35px; width: 100px; color: white;">
						</div>
						
					</div>
				</form>
			</div>

			<div class="col-md-2"></div>

		</div>
	</div>

	<jsp:include page="footer.jsp" />
</body>
</html>




