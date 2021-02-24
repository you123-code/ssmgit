<%@ page contentType="text/html; charset=utf-8"%>
<%@ include file="../include/header.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
 <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.js"></script>
<html xmlns="http://www.w3.org/1999/xhtml">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <title></title>
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global.css" />
        <link type="text/css" rel="stylesheet" media="all" href="${pageContext.request.contextPath}/css/global_color.css" /> 
      
    </head>
    <body>
        <!--Logo区域开始-->
       
      
        <div id="main">
            <form action="" method="post">
                <!--查询-->
                <div class="search_add">
                    <input type="button" value="增加" class="btn_add" onclick="location.href='${pageContext.request.contextPath}/role/showAddRole.do';" />
                </div>  
                <!--删除的操作提示-->
                <div id="operate_result_info" class="operate_success">
                    <img src="../../images/close.png" onclick="this.parentNode.style.display='none';" />
                </div> <!--删除错误！该角色被使用，不能删除。-->
                <!--数据区域：用表格展示数据-->     
                <div id="data">                      
                    <table id="datalist">
                        <tr class = "role" width = 30px height = 60px>                            
                            <th class = "id" >角色 ID</th>
                            <th class = "ming" >角色名称</th>
                            <th class = "tubiao">角色图标</th>
                            <th class="width600">拥有的权限</th>
                            <th class="td_modi"></th>
                        </tr>
                        <c:forEach items = "${pageInfo.list}" var = "role">
                        <tr>
                            <td>${role.id}</td>
                            <td>${role.rname}</td>
                            <td ><img src = "${pageContext.request.contextPath}${role.by001}"width = "40" height = "40"/></td>
                            <td >${role.privs}</td> 
<%--                             <td>${role.by001}</td> --%>
                            <td>
                                <input type="button" value="修改" class="btn_modify" onclick="location.href='${pageContext.request.contextPath}/role/showUpdateRole.do?rid='+${role.id };"/>
                                <input type="button" value="删除" class="btn_delete" onclick="deleteRole('${role.id}');" />
                            </td>
                        </tr>
                    </c:forEach>      
                    </table>
                </div> 
                <!--分页-->
                <div id="pages">
                    当前页码:<a href="#" class="current_page">${pageInfo.pageNum}</a>/总页数:${pageInfo.pages}
                    <c:if test="${!pageInfo.isFirstPage}">
        	        <a href="${pageContext.request.contextPath}/role/roleListAction.do?pageNum=1">首页</a>
                    <a href="${pageContext.request.contextPath}/role/roleListAction.do?pageNum=${pageInfo.prePage}">上一页</a>
                    </c:if>
                    <c:if test="${!pageInfo.isLastPage}">
                    <a href="${pageContext.request.contextPath}/role/roleListAction.do?pageNum=${pageInfo.nextPage}">下一页</a>
                    <a href="${pageContext.request.contextPath}/role/roleListAction.do?pageNum=${pageInfo.pages}">尾页</a>
                    </c:if>
                    总记录数：${pageInfo.total}
                </div>
            </form>
        </div>
        <!--主要区域结束-->
        <div id="footer">
           
        </div>
    </body>
      <script language="javascript" type="text/javascript">
            function deleteRole(rid) {
                var r = window.confirm("确定要删除此角色吗？");
                if(r){
                	location.href= "${pageContext.request.contextPath}/role/roleDel.do?rid="+rid;
                }
            }
            $(function(){
            	var msg = '${state}';
            	if(msg === '1'){
            		$("operate_result_info").text("删除成功");
            		$("operate_result_info").attr("class","save_success")
            		$("operate_result_info").css("display","block");
            	}else if(msg === '0'){
            		$("operate_result_info").text("删除失败");
            		$("operate_result_info").attr("class","save_fail")
            		$("operate_result_info").css("display","block");
            	}
            	setTimeout('$("#operate_result_info").css("display","none");',3000);
            })
        	
        </script>
</html>
