<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link href="${pageContext.request.contextPath}/css/admin/Style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-2.1.4.min.js"></script>
</head>
<script language="JavaScript">
    $(function(){
        $("#loginButton").click(function(){
            var index = parent.layer.getFrameIndex('login'); //先得到当前iframe层的索引
//             parent.layer.close(index); //再执行关闭
        });
        $("#loginClose").click(function(){
            var index = parent.layer.getFrameIndex('login'); //先得到当前iframe层的索引
            parent.layer.close(index); //再执行关闭
        });
        var info =  '${info}';
        if(info!=null && info!=''){
            alert("${info}");
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
    function changeImg(str){
    	alert(str);
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
                        <td height="72" align="center"><h3>登陆系统</h3></td>
                    </tr>
                    <tr>
                        <td align="center" valign="top">
                            <form name="form1" id="loginForm" action="${pageContext.request.contextPath}/adminLogin?method=2" method="post"  onSubmit="return mycheck()">
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
                                        <td height="30" align="right" class="STYLE2">验证码：</td>
                                        <td align="left">
                                            <input type="text" name="validateCode"   class="text1" />
                                            <img alt="验证码看不清，换一张" src="${pageContext.request.contextPath}/code" id="validateCodeImg" onclick="changeImg()">
                                            <a href="javascript:void(0)" onclick="changeImg()">看不清，换一张</a>
                                        </td>
                                    </tr>
                                    <tr>
                                        <td height="30" colspan="2" align="center">
                                            <label>
                                                <input type="submit" name="button" id="loginButton" value="登录">
                                                <input type="button" name="button" id="loginClose" value="关闭">
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
