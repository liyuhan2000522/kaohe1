<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>导航栏目管理</title>
    <base href="<%=basePath%>">
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
   	<link href="../../css/admin/Style.css" rel="stylesheet" type="text/css" />
<script src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
<script src="${pageContext.request.contextPath}/layer/layer.js"></script>
    
</head>
<body>
<center>
  <table width="900" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td height="60" bgcolor="#E6F5FF" style="color:#06F; font-size:19px; font-weight:bolder; padding-left:50px;">首页栏目导航</td>
    </tr>
    <tr>
      <td height="30" background="../../images/MenuBg.jpg">&nbsp;</td>
    </tr>
    <tr>
      <td height="500" align="center" valign="top"><table width="900" border="0" cellspacing="0" cellpadding="0">
        <tr>
          <td width="191" height="500" align="center" valign="top" background="../../images/leftbg.jpg">
          <%@ include file="Left.jsp"%>
          </td>
          <td width="709" align="center" valign="top" bgcolor="#F6F9FE"><table width="709" border="0" cellspacing="0" cellpadding="0">
<!--             <tr> -->
<!--               <td height="30" background="../../images/mainMenuBg.jpg" style="padding-left:25px;">楼宇管理员管理</td> -->
<!--             </tr> -->
            <tr>
              <td height="470" align="center" valign="top" bgcolor="#F6F9FE"><form name="form1" method="post" action="TeacherManager.action">
                <table width="100%%" border="0" cellspacing="0" cellpadding="0">
                  <tr>
<!--                     <td width="28%" height="30" style="padding-left:20px;"> 功能导航： <a href="TeacherAdd.jsp">添加楼宇管理员</a></td> -->
                    <td width="72%">查询：
                      <select name="SearchRow" id="SearchRow">
                        <option value="Teacher_Name">标题</option>
                      </select>
                      <input name="SearchKey" type="text" class="text1" id="SearchKey">
                      <input type="submit" name="button" id="button" value="点击查询"></td>
                  </tr>
                </table>
              </form>
                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                  <tr align="center"  class="t1">
                    <td height="25" bgcolor="#D5E4F4"><strong>标题</strong></td>
                    <td bgcolor="#D5E4F4"><strong>路径</strong></td>
                    <td bgcolor="#D5E4F4"><strong>操作</strong></td>
                  </tr>
                 <%--  <s:iterator id="aa" value="${list}" status="app"> --%>
<!--                   <s:iterator id="aa" value="list" status="app"> -->
                  <c:forEach items="${list}" var="app" varStatus="vs">
                    <tr align="center">
                      <td height="25" align="center">${app.daoHangTitle}</td>
                      <td align="center">${app.daoHangUrl}</td>
                      <td align="center">
                      		<input type="button" onclick="update(2,'${app.id}');" value="修改"> 
                  			<a href="${pageContext.request.contextPath}/daoHang?del=del&id=${app.id}"  ><input type="button"  value="删除"> </a>
                  	</td>
                    </tr>
<!--                     </s:iterator> -->
					</c:forEach>
					
				  <tr><td><br></td></tr>
                  <tr>
                  	<td align="center"><input type="button" onclick="update(1,'add');" value="新增"> </td>
                  </tr>
                </table></td>
            </tr>
          </table></td>
        </tr>
      </table></td>
    </tr>
    <tr>
<!--       <td height="35" background="../../images/bootBg.jpg">&nbsp;</td> -->
    </tr>
  </table>

</center>
</body>

<script language="JavaScript">
	function update(type,id){
	var url = "";
	if(type == 1){
	url = "${pageContext.request.contextPath}/html/admin/DaoHang/addDaoHang.jsp";
	}else if(type == 2){
// 	url = "${pageContext.request.contextPath}/html/admin/addNews.jsp";
	url = "${pageContext.request.contextPath}/daoHang?edit=edit&id="+id;
	}
	layer.open({
				type: 2,
				skin: 'layui-layer-demo', //样式类名
				title: '新增导航',
				closeBtn: 0, //不显示关闭按钮
				anim: 2,
				area: ['400px', '200px'],
				shadeClose: true, //开启遮罩关闭
				content:url
// 				content: "${pageContext.request.contextPath}/html/admin/addNews.jsp"
			});
	}
	function del(title){
		$.ajax({
         url:"${pageContext.request.contextPath}/news?add=add",
         dataType:'json',
         type:'post',
         async:false,
         contentType:'application/json',
         success:function(){
         alert('成功');
          },error:function(){
          alert('失败2');}
})
		
	}

</script>


</html>
