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
        $("#newsButton").click(function(){
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
        var title = $("#title").val();
        if(isNull(title)){
            alert("标题不可为空！");
            return false;
        }
        var content = $("#content").val();
        if(isNull(content)){
            alert("内容不可为空！");
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
                <table width="350" height="201" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td align="center" valign="top">
                            <form name="form1" id="newsForm" action="${pageContext.request.contextPath}/news" method="post" accept-charset="UTF-8" onSubmit="return mycheck()">
                                <input type="hidden" name="add" value="add" id="add" />
                                <input type="hidden" name="sortid" value="1" id="sortid" />
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="37%" height="30" align="right" class="STYLE2">标题：</td>
                                        <td width="300" align="left"><input type="text" name="title" id="title" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">内容：</td>
                                    </tr>
                                    <tr>    
                                        <td colspan=2><textarea  cols="50" name="content" id="content" rows="20"></textarea></td>
<!--                                         <td align="left"><input type="text" name="content" id="content" class="text1" /></td> -->
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
