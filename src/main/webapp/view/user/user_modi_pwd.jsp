<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include/header.jsp" %>
        
        <div id="main"> 
        ${errorMsg }     
            <!--保存操作后的提示信息：成功或者失败-->      
            <div id="save_result_info" class="save_success"><!-- 保存成功！ -->${errorMsg }</div><!--保存失败，旧密码错误！-->
            <form action="${pageContext.request.contextPath}/admin/updatePwd.do" method="post" class="main_form">
            
                <div class="text_info clearfix"><span>旧密码：</span></div>
                
                <div class="input_info">
                    <input type="password" class="width200" name = "old_pwd" /><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                
                <div class="text_info clearfix"><span>新密码：</span></div>
                
                <div class="input_info">
                    <input type="password"  class="width200" name = "apwd"/><span class="required">*</span>
                    <div class="validate_msg_medium">30长度以内的字母、数字和下划线的组合</div>
                </div>
                
                <div class="text_info clearfix"><span>重复新密码：</span></div>
                
                <div class="input_info">
                    <input type="password" class="width200" name = "apwd2" /><span class="required">*</span>
                    <div class="validate_msg_medium">两次新密码必须相同</div>
                </div>
                
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id = "smb"  />
                    <input type="button" value="取消" class="btn_save" />
                </div>
            </form>  
        </div>
        <script>
            $(function(){
                $("#smb").click(function(){
                    $(".main_form").submit();
                })
                $(".password_off").attr("class","password_on");
            })
        </script>
<!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
