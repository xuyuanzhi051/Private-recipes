<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
 String menuId=request.getParameter("menuId");
 System.out.println(menuId);

%>
<h1 align='center'>菜谱修改界面</h1>
<form action='updateMenuByIdServlet' method='post'>
  <input type="hidden" name="menuId" value=<%=menuId %>></br>
   菜谱名称:<input type="text" name="menuName"></br>
   菜谱类型：<input type="text" name="menuType"></br>
   菜谱图片:<input type="file" name="menuImg"></br>
   菜谱原材料:<input type="text" name="menuMaterial"></br>
   制作步骤:<input type="text" name="menuSteps"></br>
   <input type="submit" value="保存修改">
</form>
</body>
</html>