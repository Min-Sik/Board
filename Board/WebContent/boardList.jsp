<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" type="text/css" href="css/boardList.css?ver=1.7">
<script>
	function forward() {
		var page = ${page};
		if(page > 1) {
			location.href="boardList.bo?btype=" + ${param.btype } + "&page=" + ${page-1 };
		} else {
			return;
		}
	}
	
	function backward() {
		var page = ${page};
		var pageLimit = ${pageLimit};
		if(page < pageLimit) {
			location.href="boardList.bo?btype=" + ${param.btype } + "&page=" + ${page+1 };
		} else {
			return;
		}
	}
</script>
<div class="container">
		<table>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>등록일시</th>
			</tr>	
<c:forEach var="i" items="${data }" >
			<tr>
				<td id="bid">${i.getBid() }</td>
				<td id="btitle"><a href="boardDetail.bo?btype=${param.btype }&bid=${i.getBid() }">${i.getBtitle() }</a></td>
				<td>${i.getBregdate() }</td>
			</tr>
</c:forEach>
		</table>
<div class="pageContainer">
<button onclick="location.href='boardList.bo?btype=${param.btype }&page=1'">처음으로</button>
<button onclick="forward()">이전</button>
<c:forEach var="i" begin="1" end="${pageLimit }">
	<a class="page" href="boardList.bo?btype=${param.btype }&page=${i }">${i }</a>
</c:forEach>
<button onclick="backward()">다음</button>
<button onclick="location.href='boardList.bo?btype=${param.btype }&page=${pageLimit }'">끝으로</button>
</div>	
	<button class="write" onclick="location.href='boardReg.bo?bid=0&btype=${param.btype }&reg=0'">글쓰기</button>
</div>