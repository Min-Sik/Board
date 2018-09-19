<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/boardList.css?ver=1.2">
<div class="container">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일시</th>
			</tr>	
<c:forEach var="i" items="${data }">
			<tr>
				<td id="bid">${i.getBid() }</td>
				<td id="btitle"><a href="boardDetail.bo?btype=${param.btype }&bid=${i.getBid() }">${i.getBtitle() }</a></td>
				<td>${i.getBregdate() }</td>
			</tr>
</c:forEach>
		</table>
	<button class="write" onclick="location.href='boardReg.bo?bid=0&btype=${param.btype }&reg=0'">글쓰기</button>
</div>