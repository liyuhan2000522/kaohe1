<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<link href="../../css/admin/Style.css" rel="stylesheet" type="text/css" />
<table width="155" border="0" cellspacing="0" cellpadding="0">
            <tr>
              <td height="31" align="center" background="../../images/left1.jpg"><strong>系统选项</strong></td>
            </tr>
            <tr>
              <td height="50" align="center" valign="top"><table width="150" border="0" cellspacing="0" cellpadding="0">
                <tr>
                  <td height="5" align="center"><img src="../../images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/news?type=1">新闻管理</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/news?type=2">公告管理</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/daoHang?dh=1">首页栏目管理</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/sort?sy=1">新闻类别管理</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/admin?type=1">管理员审核</a></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a  href="javascript:void(0);"  onclick="javascript:alert('即将上线，敬请期待！');">修改密码</a></td>
                </tr>
                <tr>
                  <td height="5" align="center"><img src="../../images/ic.gif" width="1" height="1"></td>
                </tr>
                <tr>
                  <td height="30" align="center" background="../../images/left2.jpg" style="text-align:left; padding-left:40px;"><a href="${pageContext.request.contextPath}/adminLogin?method=3" onclick="return confirm('确定要退出系统吗？')">退出系统</a></td>
                </tr>
              </table>
              </td>
            </tr>
          </table>