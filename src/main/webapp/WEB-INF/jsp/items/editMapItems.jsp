<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改商品信息</title>

</head>
<body> 

<form id="itemForm" action="${pageContext.request.contextPath }/items/editMapItemsSubmit.do" method="post" >
修改商品信息：
<table width="100%" border=1>
<tr>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
</tr>
<c:forEach items="${itemsList }" var="item" varStatus="status">
<tr>
	<td><input type="text" name="itemsMap['name']" value="${item.name }"/></td>
	<td><input type="text" name="itemsMap['price']" value="${item.price }"/></td>
	<td><input type="text" name="itemsMap['createtime']" value="<fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/>"/></td>
	<td><input type="text" name="itemsMap['detail']" value="${item.detail }"/></td>
	
</tr>
</c:forEach>
<tr>
<td colspan="2" align="center"><input type="submit" value="提交"/>
</td>
</tr>
</table>

</form>
</body>

</html>