<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<link rel="stylesheet" type="text/css" href="css/boardDetail.css?ver=1.5">
<script>
	function ask() {
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href='boardDelete.bo?bid=' + ${vo.getBid() } + '&btype=' + ${param.btype };
		} else {
			return;
		}
	}

</script>
<div class="container">
	<div class="titles"> 
		<div class="title">${vo.getBtitle() }</div>
		<div class="date">${vo.getBregdate() }</div>
	</div>
	<div class="article">
		<pre>${vo.getBcontent() }</pre>
	</div>		
	<div class="buttons">	
		<button onclick="location.href='boardList.bo?btype=${param.btype }'">목록으로</button>		
		<button onclick="ask()">삭제</button>
		<button onclick="location.href='boardReg.bo?bid=${vo.getBid() }&btype=${param.btype }&reg=0'">수정</button>
	</div>
	<div class="comments">
<c:forEach var="i" items="${data }">
		<div class="commentTitle">  
			${i.getCregdate() }
		</div>
		<div class="commentContent">
			<pre>${i.getT_comment() }</pre>
		</div>
</c:forEach>
	</div>
	<div class="comment">
		<form action="boardComment.bo?bid=${vo.getBid() }&btype=${param.btype }" method="post">
			<textarea class="content" name="t_comment"></textarea><br>
			<input class="confirm" type="submit" value="등록">
		</form>
	</div>
</div>