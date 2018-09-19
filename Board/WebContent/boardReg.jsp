<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<link rel="stylesheet" type="text/css" href="css/boardReg.css">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<h1>게시판</h1>
</header>
<div>
<c:choose>
	<c:when test="${param.bid==0 }">
	<form action="boardReg.bo?bid=0&btype=${param.btype }" method="post">
		<h3>제목 : </h3> <input type="text" name="btitle" required><br>
	 	<h3>내용 : </h3> <textarea name="bcontent" required></textarea><br>
	 	<input class="button" type="submit" value="등록">
	 	<input type="hidden" name="reg" value="1">
	 	<input class="button" type="button" onclick='history.back()' value="취소">
	</form>
	</c:when>
	
	<c:otherwise>
	<form action="boardReg.bo?bid=${param.bid }&btype=${param.btype }" method="post">
		 <h3>제목 : </h3> <input type="text" name="btitle" value=${vo.getBtitle() } required><br>
		 <h3>내용 : </h3> <pre><textarea name="bcontent" required>${vo.getBcontent() }</textarea></pre><br>
		 <input class="button" type="submit" value="등록">
		 <input type="hidden" name="reg" value="1">
		 <input class="button" type="button" onclick='history.back()' value="취소">
	</form>
	</c:otherwise>
</c:choose>	
</div>
</body>
</html>