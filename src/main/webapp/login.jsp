<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<title>login</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<link rel="stylesheet" type="text/css"
			href="css/style.css" />
        <link href="${pageContext.request.contextPath }/js/themes/default/easyui.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath }/js/themes/icon.css" rel="stylesheet">
        <script src="${pageContext.request.contextPath }/js/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath }/js/jquery.easyui.min.js"></script>
        <script src="${pageContext.request.contextPath }/js/easyui-lang-zh_CN.js"></script>
	</head>

	<body>
		<div id="wrap">
			<div id="top_content">
					<div id="header">
						<div id="rightheader">
							<p>
								2009/11/20
								<br />
							</p>
						</div>
						<div id="topheader">
							<h1 id="title">
								<a href="#">main</a>
							</h1>
						</div>
						<div id="navigation">
						</div>
					</div>
				<div id="content">
					<p id="whereami">
					</p>
					<h1>
						login
					</h1>
					<form id="loginForm" method="post">
						<table cellpadding="0" cellspacing="0" border="0"
							class="form_table">
							<tr>
								<td valign="middle" align="right">
									username:
								</td>
								<td valign="middle" align="left">
									<input type="text" class="inputgri" name="username" />
								</td>
							</tr>
							<tr>
								<td valign="middle" align="right">
									password:
								</td>
								<td valign="middle" align="left">
									<input type="password" class="inputgri" name="password" />
								</td>
							</tr>
						</table>
						<p>
							<input type="button" class="button" value="Submit &raquo;" onclick="sub()" />
							&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/regist.jsp">注册</a>
						</p>
					</form>
				</div>
			</div>
			<div id="footer">
				<div id="footer_bg">
					ABC@126.com
				</div>
			</div>
		</div>
	</body>
	<script>
        var sub = function(){
            $("#loginForm").form("submit",{
                url:"${pageContext.request.contextPath}/admin/login",
                success:function(r){
                    var res = JSON.parse(r);
                    $.messager.show({
                        title:"提示消息",
                        msg:res.msg,
                        timeout:2,
                        onClose:function () {
                            if(res.code == "200"){
                                location.href = "${pageContext.request.contextPath}/emplist.html"
                            }else{
                                location.href = "${pageContext.request.contextPath}/login.jsp"
                            }
                        }
                    })

                }
            })
        }
	</script>
</html>
