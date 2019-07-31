<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>注册</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/admin/Style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
</head>
<script language="JavaScript">
    $(function(){
        $("#daoHangButton").click(function(){
            var index = parent.layer.getFrameIndex('news'); //先得到当前iframe层的索引
//             parent.layer.close(index); //再执行关闭
        });
         var info =  '${info}';
         if(info!=null && info!=''){
             alert(info);
         }
    })
    //验证
    function mycheck(){
    debugger;
        var username = $("#daohang_title").val();
        if(isNull(username)){
            alert("标题不可为空！");
            return false;
        }
        var password = $("#daohang_url").val();
        if(isNull(password)){
            alert("路径不可为空！");
            return false;
        }
        
        var index = parent.layer.getFrameIndex(window.name);
        parent.layer.close(index);
		window.parent.location.reload();
        
//         var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
// 			$.ajax({
// 				type: "GET",
// 				url: "${pageContext.request.contextPath}/news?add=add",
// 		    	data: $("#Form").serializeArray(),
// 				dataType:'json',
// 				success: function(data){
// 						 	parent.layer.close(index);
// 							window.parent.location.reload();
// 			}
// 			});
    }

    function isNull(str){
        if ( str == "" ) return true;
        var regu = "^[ ]+$";
        var re = new RegExp(regu);
        return re.test(str);
    }

</script>
<body>
<center>
    <br><br>
    <table width="500" border="0" cellspacing="0" cellpadding="0">
        <tr>
                <table width="350" height="100" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" valign="top">
                            <form name="form1" id="newsForm" action="${pageContext.request.contextPath}/daoHang" method="post" accept-charset="UTF-8" onSubmit="return mycheck()">
                                <input type="hidden" name="update" value="update" id="update" />
                                <input type="hidden" name="id" value="${daohang.id}" id="id" />
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="37%" height="30" align="right" class="STYLE2">标题：</td>
                                        <td width="300" align="left"><input type="text" value="${daohang.daoHangTitle}" name="daoHangTitle" id="daoHangTitle" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">网址路径：</td>
                                        <td align="left"><input type="text" name="daoHangUrl" value="${daohang.daoHangUrl}" id="daoHangUrl" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" colspan="2" align="center">
                                            <label>
                                                <input type="submit" name="button" id="newsButton" value="保存">
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table>
        </tr>
    </table>
</center>
</body>
</html>
