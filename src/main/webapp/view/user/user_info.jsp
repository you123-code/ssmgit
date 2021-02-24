<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include/header.jsp" %>
       <script type="text/javascript">
         $(function(){
		  $("#btn_save").click(function(){
			  $.ajax({
				  url : '${pageContext.request.contextPath}/admin/updateInfo.do',
				  data: $(".main_form").serialize(),
				  success: function(result){
                      $("#save_result_info").text(result);
                      $("#save_result_info").css("display","block");
                      setTimeout("$('#save_result_info').css('display','none')",2500);
				  }
			  });
		  });
	  })
	  </script>

 <!-- <script>
        	$(function(){
        		$(".user_info_off").attr("class","user_info_on");
        	})
        </script>   -->
        <!--主要区域开始-->
        <div id="main">            
            <!--保存操作后的提示信息：成功或者失败-->
            <div id="save_result_info" class="save_success">保存成功11！</div><!--保存失败，数据并发错误！-->
            <form   method="get" class="main_form">
                <div class="text_info clearfix"><span>管理员账号：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="${admin.acname }" /></div>
                <div class="text_info clearfix"><span>角色：</span></div>
                <div class="input_info">
                    <input type="text" readonly="readonly" class="readonly width400" value="${admin.roleList }" />
                </div>
                <div class="text_info clearfix"><span>姓名：</span></div>
                <div class="input_info">
                    <input type="text" name = "aname" value="${admin.aname }" />
                    <span class="required">*</span>
                    <div class="validate_msg_long error_msg">20长度以内的汉字、字母的组合</div>
                </div>
                <div class="text_info clearfix"><span>电话：</span></div>
                <div class="input_info">
                    <input type="text" class="width200"  name = "atel" value="${admin.atel }" />
                    <div class="validate_msg_medium">电话号码格式：手机或固话</div>
                </div>
                <div class="text_info clearfix"><span>Email：</span></div>
                <div class="input_info">
                    <input type="text" class="width200" name = "aemail" value="${admin.aemail }" />
                    <div class="validate_msg_medium">50长度以内，符合 email 格式</div>
                </div>
                <div class="text_info clearfix"><span>创建时间：</span></div>
                <div class="input_info"><input type="text" readonly="readonly" class="readonly" value="2021.1.5 14:19"/></div>
                <div class="button_info clearfix">
                    <input type="button" value="保存" class="btn_save" id = "btn_save"/>
                    <input type="button" value="取消" class="btn_save" />
                    <input type = "hidden" name = "id" value="${admin.id }"/>
                </div>
            </form>  
        </div>
        <!--主要区域结束-->
        <div id="footer">
          
        </div>
    </body>
</html>
