<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>JBlog</title>
</head>
<body>
<center>

<!-- 검색 화면 시작 -->
<form action="/find" method="post">
	<table width="720" height=200 border="0" cellpadding="0" cellspacing="0">
		<tr>
			<td width="100%" colspan="10" align="center">
				<img src="/images/logo.jpg" border="0">
			</td>
		</tr>				
		<tr>
			<td align="center">
				<input type="radio" name="searchCondition" value="TITLE" checked="checked">블로그 제목&nbsp;&nbsp;
				<input type="radio"	name="searchCondition" value="TAG">태그
			</td>
		</tr>				
		<tr>
			<td width="70%" colspan="2" align="center">
			<c:set var="contains" value="false" />
				<c:forEach var="blog" items="${blogList }">
					<c:if test="${loginUser.userId == blog.blogId }">
						<c:set var="contains" value="true" />
					</c:if>
				</c:forEach>
				<c:choose>
					<c:when test="${loginUser == null }">
						<a href="/login"><b>로그인</b></a>&nbsp;&nbsp;
					</c:when>
					<c:when test="${loginUser != null }">
						<a href="/logout"><b>로그아웃</b></a>&nbsp;&nbsp;
					</c:when>
				</c:choose>
				<c:choose>
					<c:when test="${loginUser != null && contains == false }">
						<a href="/blog/insert"><b>블로그등록</b></a>&nbsp;&nbsp;
					</c:when>
					<c:when test="${loginUser != null && contains == true }">
						<a href="/blog/shortcuts/${loginUser.userId }"><b>블로그바로가기</b></a>&nbsp;&nbsp;
					</c:when>
				</c:choose>
				<input type="text" name="searchKeyword"	size="50">
				<input type="submit" value="검색">
			</td>
		</tr>

	</table>
</form>
<!-- 검색 화면 종료 -->

<!-- 블로그 목록 시작 -->
<br><br>
<c:if test="${!empty blogList}">
<table width="550" border="0" cellpadding="1" cellspacing="1">
	<tr bgcolor="#9DCFFF">
		<th height="30"><font color="white">블로그 제목</font></th>
		<th width="100"><font color="white">상태</font></th>
		<c:if test="${loginUser.role == 'ADMIN' }"><th width="100"><font color="white">삭제</font></th></c:if>
	</tr>
	<c:forEach var="blog" items="${blogList }">
		<tr>
			<td align="left"><a href="/blog/shortcuts/${blog.blogId }">${blog.title }</a></td>
			<td align="center">${blog.status }</td>
			<c:choose>
				<c:when test="${loginUser.role == 'ADMIN' && blog.status == '운영' }"><td align="center">-</td></c:when>
				<c:when test="${loginUser.role == 'ADMIN' && blog.status == '삭제요청' }"><td align="center"><a href="#"><img height="9" src="/images/delete.jpg" border="0"></a></td></c:when>
			</c:choose>
		</tr>
	</c:forEach>
</table>
</c:if>
<!-- 블로그 목록 종료 -->

</center>
</body>
</html>