<%@ page  contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global_color.css" /> 
        <script type="text/javascript" src = "${pageContext.request.contextPath}/js/jquery.js"></script>
        <%--  <script>
          //非登录用户不能访问，在所有的jsp页面中使用
            var admin = '${admin}';
            if(admin ===''){
            	alert("用户名或密码不能为空").close();
            	location.href = "${pageContext.request.contextPath}/view/login.jsp"
            }
        	$(function(){
        		$("#smb").click(function(){
        			$(".main_form").submit();
        		})
        	})
        </script>--%>
       <script>
        	$(function(){
        		$("#smb").click(function(){
        			$("#loginform").submit();
        		})
        		$("#vimg").click(function(){
        			var d = new Date();
        			$(this).attr("src","${pageContext.request.contextPath}/validCode.img?d="+d);
        		})
        	})
        </script>
    </head>
    <body class="index">
        <div class="login_box">
            <table>
              <form action = "${pageContext.request.contextPath}/admin/login.do" method = "post" id = "loginform">
                <tr>
                    <td class="login_info">账号：</td>
                    <td colspan="2"><input name="acname" type="text" class="width150" /></td>
                  <!--   <td class="login_error_info"><span class="required">30长度的字母、数字和下划线</span></td> -->
                </tr>
                <tr>
                    <td class="login_info">密码：</td>
                    <td colspan="2"><input name="apwd" type="password" class="width150" /></td>
                  <!--   <td><span class="required">30长度的字母、数字和下划线</span></td> -->
                </tr>
                <tr>
                    <td class="login_info">验证码：</td>
                    <td class="width70"><input name="vcode" type="text" class="width70" /></td>
                    <td><img id = "vimg" src="${pageContext.request.contextPath}/images/valicode.jpg" alt="验证码" title="点击更换" /></td>
                   <!--  <td><span class="required">验证码错误</span></td> -->              
                </tr>   
               </form>         
                <tr>
                    <td></td>
                    <td class="login_button" colspan="2">
                   <!--   <a href = "index.jsp"> --><img id = "smb" src="${pageContext.request.contextPath}/images/login_btn.png" /><!-- </a>  -->
                    </td>    
                     <td><span class="required">${errorMsg}</span></td>               
                </tr>
            </table>
        </div>
    </body>
</html>
