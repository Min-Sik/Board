<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<link rel="stylesheet" type="text/css" href="css/boardDetail.css?ver=1">
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
	<div class="title"> 
		<h2>${vo.getBtitle() }</h2>
	</div>
	<div class="article">
		<pre>${vo.getBcontent() }</pre>
	</div>		
	<div class="buttons">		
		<button onclick="location.href='boardReg.bo?bid=${vo.getBid() }&btype=${param.btype }&reg=0'">수정</button>
		<button onclick="ask()">삭제</button>
		<button onclick="location.href='boardList.bo?btype=${param.btype }'">목록으로</button>
	</div>
</div>