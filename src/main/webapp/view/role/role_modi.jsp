<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include/header.jsp" %>
        <!--主要区域开始-->
        <div id="main">           
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功！</div>
            <form action="${pageContext.request.contextPath}/role/updateRole.do" method="post" class="main_form">
                <div class="text_info clearfix"><span>角色名称：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name = "rname" value="${role.rname }" />
                    <span class="required">*</span>
                    <div class="validate_msg_medium error_msg">不能为空，且为20长度的字母、数字和汉字的组合</div>
                </div>                    
                <div class="text_info clearfix"><span>设置权限：</span></div>
                <div class="input_info_high">
                    <div class="input_info_scroll">
                        <ul>
                          <c:forEach items = "${lp}" var = "priv">
                            <li><input type="checkbox" name = "privs"value = "${priv.pid}"
                            <c:forEach items = "${role.lp}" var = "p">
                              <c:if test = "${priv.pid == p.pid}">
                                checked = "checked"
                                </c:if>
                              </c:forEach>
                             />${priv.name}</li>
                          </c:forEach>
                        </ul>
                    </div>
                    <span class="required">*</span>
                    <div class="validate_msg_tiny">至少选择一个权限</div>
                </div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id = "btn_save" />
                    <input type="button" value="取消" class="btn_save" />
                </div>
                <input type = "hidden" name = "rid" value = "${role.id }"/>
            </form> 
        </div>
        <!--主要区域结束-->
        <div id="footer">
            
        </div>
    </body>
       <script type = "text/javascript">
        $(function(){
        	$("#btn_save").click(function(){
        		$(".main_form").submit();
        	})
        	
        	var msg = '${state}';
        	if(msg === '1'){
        		$("save_result_info").text("添加成功");
        		$("save_result_info").attr("class","save_success")
        		$("save_result_info").css("display","block");
        		setTimeout('$("#save_result_info").css("display","none");',3000);
        	}else if(msg === '0'){
        		$("save_result_info").text("添加失败");
        		$("save_result_info").attr("class","save_fail")
        		$("save_result_info").css("display","block");
        		setTimeout('$("#save_result_info").css("display","none");',3000);
        	}
        		
        })
        </script>
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
</html>
