<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>

<%@include file="../layout/header.jsp" %>
		
<table background="/images/kubrickbg.jpg" width="760" height="300" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10" colspan="10">&nbsp;</td></tr>
	<tr>
		<td height="10" width="20">&nbsp;</td>
		<td width="530" valign="top">
			<!-- 메뉴 시작 --> 
			<b>기본설정</b>&nbsp;&nbsp;
			<a href="/category/getCategoryList/${blog.blogId }/insert"><b>카테고리</b></a>&nbsp;&nbsp;
			<a href="/posts/insert/${blog.blogId }"><b>글작성</b></a>&nbsp;&nbsp;
			<c:choose>
				<c:when test="${blog.status == '운영' }"><a href="/blog/status/${blog.blogId }"><b>블로그삭제</b></a>&nbsp;&nbsp;</c:when>
				<c:when test="${blog.status == '삭제요청' }"><a href="/blog/status/${blog.blogId }"><b>블로그삭제취소</b></a>&nbsp;&nbsp;</c:when>
			</c:choose>
			
			<!-- 메뉴 끝 -->
		</td>
	</tr>
	<tr><td height="5">&nbsp;</td></tr>
	<tr><td height="10">&nbsp;</td>
		<td>
			<!-- 작업 화면  시작 -->
			<form action="/blog/update/${blog.blogId }" method="post">
			<table width="720" border="0" cellpadding="1" cellspacing="1">
				<tr>
					<td width="150">블로그 제목 :</td>
					<td><input type="text" size="40" name="title" value="${blog.title }"></td>
				</tr>
				<tr>
					<td width="150">블로그 태그 :</td>
					<td><input type="text" size="50" name="tag" value="${blog.tag }"></td>
				</tr>
				<tr>
					<td width="150">로고이미지 :</td>
					<td><img height="80" src="/images/logo.jpg" border="0"></td>
				</tr>
				<tr>
					<td height="40" colspan="10" align="center">
						<input type="submit" value="수정하기">
					</td>
				</tr>
			</table>
			</form> 
			<!-- 작업 화면  끝 -->
		</td>
	</tr>
	<tr><td height="10" colspan="10">&nbsp;</td></tr>
</table>


<%@include file="../layout/footer.jsp" %>