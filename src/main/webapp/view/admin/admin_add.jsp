﻿<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include/header.jsp" %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <script language="javascript" type="text/javascript">
            //保存成功的提示消息
            function showResult() {
                showResultDiv(true);
                window.setTimeout("showResultDiv(false);", 3000);
            }
            function showResultDiv(flag) {
                var divResult = document.getElementById("save_result_info");
                if (flag)
                    divResult.style.display = "block";
                else
                    divResult.style.display = "none";
            }
        </script>
    </head>
    <body>
        <!--主要区域开始-->
        <div id="main">            
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="" method="" class="main_form">
                    <div class="text_info clearfix"><span>姓名：</span></div>
                    <div class="input_info">
                        <input type="text" />
                        <span class="required">*</span>
                        <div class="validate_msg_long">20长度以内的汉字、字母、数字的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>管理员账号：</span></div>
                    <div class="input_info">
                        <input type="text"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long">30长度以内的字母、数字和下划线的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>密码：</span></div>
                    <div class="input_info">
                        <input type="password"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">30长度以内的字母、数字和下划线的组合</div>
                    </div>
                    <div class="text_info clearfix"><span>重复密码：</span></div>
                    <div class="input_info">
                        <input type="password"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">两次密码必须相同</div>
                    </div>      
					<div class="text_info clearfix"><span>上传头像</span></div>
                    <div class="input_info">
                        <input type="file" name="userimg"  />
                        <span class="required">*</span>
                        <div class="validate_msg_long error_msg">图片大小400*400px</div>
                    </div>  
                    <div class="text_info clearfix"><span>电话：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">正确的电话号码格式：手机或固话</div>
                    </div>
                    <div class="text_info clearfix"><span>Email：</span></div>
                    <div class="input_info">
                        <input type="text" class="width200"/>
                        <span class="required">*</span>
                        <div class="validate_msg_medium error_msg">50长度以内，正确的 email 格式</div>
                    </div>
                    <div class="text_info clearfix"><span>角色：</span></div>
                    <div class="input_info_high">
                        <div class="input_info_scroll">
                            <ul>
                                <li><input type="checkbox"  />超级管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                                <li><input type="checkbox" />账务账号管理员</li>
                                <li><input type="checkbox" />业务账号管理员</li>
                            </ul>
                        </div>
                        <span class="required">*</span>
                        <div class="validate_msg_tiny error_msg">至少选择一个</div>
                    </div>
                    <div class="button_info clearfix">
                        <input type="button" value="保存" class="btn_save" onclick="showResult();" />
                        <input type="button" value="取消" class="btn_save" />
                    </div>
                </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
</html>
