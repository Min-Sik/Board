<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<style>
.login, .join {
	float: right;
}

</style>
<ul>
	<li><a href="home.bo">Home</a></li>	
	<li class="drop"><a class="dropbtn">Board</a>
		<div class="dropmenu">
			<a href="boardList.bo?btype=1&page=1">Notice</a>
			<a href="boardList.bo?btype=2&page=1">Free</a>
			<a href="boardList.bo?btype=3&page=1">Humor</a>
		</div>
	</li>
	<li class="login"><a href="">login</a></li>
	<li class="join"><a>join</a></li>
</ul>