<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="<%=request.getContextPath()%>/css/css.css" rel="stylesheet">
<script type="text/javascript" src="<%=request.getContextPath()%>/js/jquery-1.8.2.min.js"></script>
<script type="text/javascript">
	function buy(id){
		
		$.post("updateIsHave",{"id":id},function(data){
			if(data){
				alert("购买成功,赶快去操作一番吧!");
				location.reload();
			}else{
				alert("购买失败!");
			}
		})
	}
</script>
</head>
<body>

	
	<form action="queryAll" method="post">
		英雄阵营:<select name="cid">
					<option value="">请选择</option>
					<c:forEach items="${campList }" var="camp">
						<option value="${camp.cid }" <c:if test="${map.cid==camp.cid }">selected="selected"</c:if>>${camp.cname }</option>
					</c:forEach>
			   </select>
		英雄价格:<input type="text" name="startPrice" value="${map.startPrice }">~<input type="text" name="endPrice" value="${map.endPrice }">
		英雄是否拥有:<select name="isHave">
					<option value="">请选择</option>
					<option value="0" <c:if test="${map.isHave==0 }">selected="selected"</c:if>>未拥有</option>
					<option value="1" <c:if test="${map.isHave==1 }">selected="selected"</c:if>>已拥有</option>
				  </select>
		<input type="submit" value="搜索">
	</form>
	
	<table>
		<tr>
			<td colspan="10">
				<a href="add.jsp"><input type="button" value="添加"></a>
			</td>
		</tr>
		<tr>
			<td>编号</td>
			<td>英雄名称</td>
			<td>价格</td>
			<td>是否拥有</td>
			<td>图片</td>
			<td>所属阵营</td>
			<td>操作</td>
		</tr>
		
	<c:forEach items="${page.list }" var="h">
		<tr>
			<td>${h.id }</td>
			<td>${h.hname }</td>
			<td>${h.price }</td>
			<td>${h.isHave==0?"未拥有":"已拥有" }</td>
			<td>
				<img alt="xxx" height="70px" width="90px" src="lookImg?path=${h.picurl }">
			</td>
			<td>${h.cname }</td>
			<td>
				<a href="queryHeroById?id=${h.id }"><input type="button" value="详情"></a>
				<input type="button" value="购买" onclick="buy('${h.id }')">
			</td>
		</tr>
	</c:forEach>
		
		<tr>
			<td colspan="10">
				<a href="?pageNum=1">首页</a>
				<a href="?pageNum=${page.pageNum-1<1?page.pageNum:page.pageNum-1 }">上一页</a>
				<a href="?pageNum=${page.pageNum+1>page.pages?page.pageNum:page.pageNum+1 }">下一页</a>
				<a href="?pageNum=${page.pages }">尾页</a>
			</td>
		</tr>
	</table>

</body>
</html>