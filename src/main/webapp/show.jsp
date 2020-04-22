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
	$(function(){
		$.post("queryCamp",function(data){
			
			var str = "";
			for(var i in data){
				str+="<option value='"+data[i].cid+"'>"+data[i].cname+"</option>";
			}
			
			$("#cid").append(str);
			
			$("#cid").val("${hero.cid}");
		})
	})
</script>
</head>
<body>

		英雄名称:<input type="text" name="hname" value="${hero.hname }"><br><br>
		价格:<input type="text" name="price" value="${hero.price }"><br><br>
		图片:<img alt="xxx" height="70px" width="90px" src="lookImg?path=${hero.picurl }"><br><br>
		所属阵营:<select name="cid" id="cid">
					<option value="">请选择</option>
			  </select><br><br>
			<a href="queryAll"><input type="button" value="返回"></a>
</body>
</html>