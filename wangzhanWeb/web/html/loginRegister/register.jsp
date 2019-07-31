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
        $("#registerClose").click(function(){
            var index = parent.layer.getFrameIndex('register'); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });
         var info =  '${info}';
         if(info!=null && info!=''){
             alert(info);
         }

        if(info=='注册成功，请登录'){
            var index = parent.layer.getFrameIndex('register'); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        }
    })
    //验证
    function mycheck(){
        //账号是否存在
        var status = true;
        //判断账号是否符合要求
        var username = $("#username").val();
        if(isNull(username)){
            alert("账号不可为空！");
            return false;
        }
        var password = $("#password").val();
        if(isNull(password)){
            alert("密码不可为空！");
            return false;
        }

        var age = $("#age").val();
        if(isNull(age)){
            alert("年龄不可为空！");
            return false;
        }
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
    <br><br><br><br><br>
    <table width="684" border="0" cellspacing="0" cellpadding="0">
        <tr>
            <td height="292" align="center" valign="top" background="${pageContext.request.contextPath}/images/admin/LoginBg.jpg">
                <table width="350" height="201" border="0" cellpadding="0" cellspacing="0">
                    <tr>
                        <td height="72" align="center"><h3>注册系统</h3></td>
                    </tr>
                    <tr>
                        <td align="center" valign="top">
                            <form name="form1" id="registerForm" action="${pageContext.request.contextPath}/register" method="post" enctype="multipart/form-data" onSubmit="return mycheck()">
                                <table width="100%" border="0" cellspacing="0" cellpadding="0">
                                    <tr>
                                        <td width="37%" height="30" align="right" class="STYLE2">用户名：</td>
                                        <td width="300" align="left"><input type="text" name="username" id="username" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">密码：</td>
                                        <td align="left"><input type="password" name="password" id="password" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">头像</td>
                                        <td align="left">
                                            <input type="file" name="image" id="image" accept=""  imgUrlId="fileImgId" class="text1 fileData" />
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="30" align="right" class="STYLE2">年龄</td>
                                        <td align="left"><input type="number" name="age" id="age" class="text1" /></td>
                                    </tr>
                                    <tr>
                                        <td height="30" colspan="2" align="center">
                                            <label>
                                                <input type="submit" name="button" id="registerButton" value="注册">
                                                <input type="button" name="button" id="registerClose" value="关闭">
                                            </label>
                                        </td>
                                    </tr>
                                </table>
                            </form>
                        </td>
                    </tr>
                </table></td>
        </tr>
    </table>
</center>
</body>
</html>
