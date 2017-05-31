<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查询商品列表</title>
</head>
<script type="text/javascript">
	function deteleItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/deteleItems.do"
		document.itemsForm.submit();
	}
	function queryItem(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/queryItem.do"
		document.itemsForm.submit();
	}
	function editListItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/editListItems.do"
		document.itemsForm.submit();
	}
	function editMapItems(){
		document.itemsForm.action="${pageContext.request.contextPath }/items/editMapItems.do"
		document.itemsForm.submit();
	}
</script>
<body> 
<form name="itemsForm" action="${pageContext.request.contextPath }/items/queryItems.do" method="post">
查询条件：
<table width="100%" border=1>
<tr>
<td><input type="button" value="查询" onclick="queryItem()"/></td>
<td><input type="button" value="删除" onclick="deteleItems()"/></td>
<td><input type="button" value="list修改" onclick="editListItems()"/></td>
<td><input type="button" value="map修改" onclick="editMapItems()"/></td>
</tr>
</table>
商品列表：
<table width="100%" border=1>
<tr>
	<td>选择</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>生产日期</td>
	<td>商品描述</td>
</tr>
<c:forEach items="${itemsList }" var="item">
<tr>
	<td><input type="checkbox" name="items_id" value="${item.id }"></td>
	<td>${item.name }</td>
	<td>${item.price }</td>
	<td><fmt:formatDate value="${item.createtime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
	<td>${item.detail }</td>
	
</tr>
</c:forEach>

</table>
</form>
</body>

</html>