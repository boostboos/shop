
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登录</title>

<link rel="stylesheet" href="/front/css/style1.css">

<link href="/front/css/style2.css" rel="stylesheet">
<link rel='stylesheet prefetch' href='/front/css/style3.css'>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">

</head>
<body>

	<div class="cotn_principal">
		<div class="cont_centrar">
			<div class="cont_login">


				<div class="cont_info_log_sign_up">
					<div class="col_md_login">
						<div class="cont_ba_opcitiy">
							<h2>登录</h2>
							<p>超神书城欢迎您</p>
							<button class="btn_login" onClick="cambiar_login()">LOGIN</button>
						</div>
					</div>
					<div class="col_md_sign_up">
						<div class="cont_ba_opcitiy">
							<h2>注册</h2>
							<p>LEGENDARY</p>
							<button class="btn_sign_up" onClick="cambiar_sign_up()">还没账号？点这里</button>
						</div>
					</div>
				</div>



				<div class="cont_back_info">
					<div class="cont_img_back_grey">
						<img src="../images/po.jpg" alt="" />
					</div>
				</div>
				<div class="cont_forms">
					<div class="cont_img_back_">
						<img src="../images/po.jpg" alt="" />
					</div>
					<div class="cont_form_login">
						<a href="#" onClick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>进入书城</h2>
						<input type="text" id="username" onchange=checkuser(this.value)
							placeholder="username" /> <input type="password" id="password"
							onchange=checkpass(this.value) placeholder="Password" />
						<p id="call1"></p>
						<button class="btn_login" id="login" onClick="cambiar_login()">登录</button>
					</div>
					<div class="cont_form_sign_up">
						<a href="#" onClick="ocultar_login_sign_up()"><i
							class="material-icons">&#xE5C4;</i></a>
						<h2>注册账号</h2>
						<input type="text" id="email" onchange=checkemail(this.value)
							placeholder="Email" /> <input type="text" id="reusername"
							onchange=checkreuser(this.value) placeholder="User" /> <input
							type="password" id="password1" onchange=checkrepass(this.value)
							placeholder="设置密码" /> <input type="password" id="password2"
							placeholder="确认密码" />
						<p id="call2"></p>
						<button class="btn_sign_up" id="register"
							onClick="cambiar_sign_up()">注册</button>
					</div>
				</div>
			</div>
		</div>
	</div>

	<script src="/front/AmazeUI-2.4.2/assets/js/index.js"></script>


	<script type="text/javascript">
	
		function checkreuser(val) {
			if (val == "" || val == null) {
				document.getElementById("call2").innerHTML = "用户名不能为空";
			} else {
				var xmlhttp;
				xmlhttp = new XMLHttpRequest();
				xmlhttp.open("post", "/MemberServlet?method=find", true);
				xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlhttp.send("username=" + val);
				xmlhttp.onreadystatechange = function() {
				if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
				if (xmlhttp.responseText == "no") {
					document.getElementById("call2").innerHTML = "该用户名已被注册";
					document.getElementById("reusername").value="";
				} else {
					document.getElementById("call2").innerHTML = "该用户名未被使用可以注册";		
				}
				}
			}
			}
		}

	</script>
	<script type="text/javascript">
		var xmlhttp;
		xmlhttp = new XMLHttpRequest();
		function checkemail(val) {
			var reg = new RegExp("^[a-z0-9]+([._\\-]*[a-z0-9])*@([a-z0-9]+[-a-z0-9]*[a-z0-9]+.){1,63}[a-z0-9]+$");
			if (val == "" || val == null) {
				document.getElementById("call2").innerHTML = "邮箱不能为空";
			} else if (!reg.test(val)) {
				document.getElementById("call2").innerHTML = "邮箱格式不正确";
			} else {
				document.getElementById("call2").innerHTML = "";
			}
		}
		function checkrepass(val) {
			if (val == "" || val == null) {
				document.getElementById("call2").innerHTML = "密码不能为空";
			} else {
				document.getElementById("call2").innerHTML = "";
			}
		}	
		document.querySelector("#register").onclick = function() {
			var username = document.getElementById("reusername").value;
			var password = document.getElementById("password1").value;
			var passwordrp = document.getElementById("password2").value;
			var email = document.getElementById("email").value;
			if (username == "" || email == "" || password == "" || passwordrp == "") {
				document.getElementById("call2").innerHTML = "必填项未输入";
			} else if (password != passwordrp) {
				document.getElementById("call2").innerHTML = "两次密码不一致";
			} else {
				xmlhttp.open("post", "/MemberServlet?method=add", true);
				xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlhttp.send("username=" + username + "&passwd=" + password + "&email=" + email);
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						if (xmlhttp.responseText == "success") {
						
						
							document.getElementById("call2").innerHTML = "注册成功";				
						} else if (xmlhttp.responseText == "fail") {
							document.getElementById("call2").innerHTML = "添加未成功";
						}
					}
				}
			}
	
		}
	</script>
	<script type="text/javascript">
		var xmlhttp;
		xmlhttp = new XMLHttpRequest();
	
		function checkuser(val) {
			if (val == "" || val == null) {
				document.getElementById("call1").innerHTML = "用户名不能为空";
			/* document.getElementById("#login").onclick=null; */
			} else {
				document.getElementById("call1").innerHTML = "";
			}
	
		}
		function checkpass(val) {
			if (val == "" || val == null) {
				document.getElementById("call1").innerHTML = "密码不能为空";
			} else {
				document.getElementById("call1").innerHTML = "";
			}
		}
		document.querySelector("#login").onclick = function() {
			var user = document.getElementById("username").value;
			var pass = document.getElementById("password").value;
			if (user == "" || user == null || pass == "" || pass == null) {
				document.getElementById("call1").innerHTML = "用户名或密码不能为空";
			} else {
				xmlhttp.open("post", "/MemberServlet?method=login&login=login", true);
				xmlhttp.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
				xmlhttp.send("username=" + user + "&passwd=" + pass);
	
				xmlhttp.onreadystatechange = function() {
					if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
						if (xmlhttp.responseText == "success") {
							document.getElementById("call1").innerHTML = "";
	
							window.location.href = "/front/user/index.jsp"
						} else {
							document.getElementById("call1").innerHTML = "用户名或密码不正确";
						}
					}
				}
			}
	
	
		}
	</script>
</body>
</html>


