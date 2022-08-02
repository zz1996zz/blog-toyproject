<%@page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@include file="../layout/header.jsp" %>

<table background="/images/kubrickbg.jpg" width="760" height="40" border="0" cellpadding="0" cellspacing="0">
	<tr><td height="10" colspan="10">&nbsp;</td></tr>
	<tr><td height="10" width="20">&nbsp;</td>
		<td width="530" valign="top">
			<!-- 메뉴 시작 --> 
			<a href="/blog/manage/${blog.blogId }"><b>기본설정</b></a>&nbsp;&nbsp;
			<b>카테고리</b>&nbsp;&nbsp;
			<a href="#"><b>글작성</b></a>&nbsp;&nbsp; 
			<c:choose>
				<c:when test="${blog.status == '운영' }"><a href="/blog/delete/${blog.blogId }"><b>블로그삭제</b></a>&nbsp;&nbsp;</c:when>
				<c:when test="${blog.status == '삭제요청' }"><a href="/blog/delete/${blog.blogId }"><b>블로그삭제취소</b></a>&nbsp;&nbsp;</c:when>
			</c:choose>
			<!-- 메뉴 끝 -->
		</td>
	</tr>	
	<tr><td height="5">&nbsp;</td></tr>
	<tr><td height="10">&nbsp;</td><td>
		<!-- 작업 화면  시작 -->
		<table width="720" border="0" cellpadding="1" cellspacing="1">
			<tr bgcolor="#9DCFFF">
				<th width="50"><font color="white">번호</font></th>
				<th width="120"><font color="white">카테고리명</font></th>
				<th width="100"><font color="white">보이기 유형</font></th>
				<th width="350"><font color="white">설명</font></th>
				<th width="100"><font color="white">삭제</font></th>
			</tr>
			<c:forEach var="cg" items="${categoryList }" varStatus="status">
				<tr>
					<td align="center">${status.count }</td>	
					<c:choose>
						<c:when test="${cg.categoryName == '미분류' }"><td>${cg.categoryName }</td></c:when>
						<c:when test="${cg.categoryName != '미분류' }"><td><a href="/category/getCategory/${blog.blogId }/update/${cg.categoryId }">${cg.categoryName }</a></td></c:when>
					</c:choose>
					
					<c:choose>
						<c:when test="${cg.displayType == 'TITLE' }"><td align="center">제목</td></c:when>
						<c:when test="${cg.displayType == 'MIXED' }"><td align="center">제목 + 내용</td></c:when>
					</c:choose>
					<td>${cg.description }</td>
					<c:choose>
						<c:when test="${cg.categoryName == '미분류' }"><td align="center">&nbsp;삭제불가</td></c:when>
						<c:when test="${cg.categoryName != '미분류' }">
							<td align="center">&nbsp;<a href="#"><img height="9" src="/images/delete.jpg" border="0"></a></td>
						</c:when>
					</c:choose>
				</tr>
			</c:forEach>
		</table> 
		
	<!-- 카테고리 등록화면 시작 -->
	<c:set var="path" value="${requestScope['javax.servlet.forward.servlet_path'] }"/>
	<c:choose>
		<c:when test="${fn:contains(path, 'insert') }">
			<form action="/category/insert/${blog.blogId }" method="post">
				<table width="720" border="0" cellpadding="1" cellspacing="1">
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td height="5"><b>카테고리 등록</b></td>	</tr>
					<tr><td height="5">&nbsp;</td></tr>
					<tr>
						<td width="150">카테고리명 :</td>
						<td><input type="text" size="40" name="categoryName"></td>
					</tr>
					<tr>
						<td width="150">보이기 유형 :</td>
						<td>
							<input type="radio"	name="displayType" value="TITLE" checked>제목&nbsp;&nbsp;
							<input type="radio" name="displayType" value="MIXED">제목 + 내용&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td width="150">설명 :</td>
						<td><input type="text" size="50" name="description"></td>
					</tr>
					<tr>
						<td colspan="10" align="center">&nbsp;<input type="submit" value="카테고리 추가"></td>
					</tr>
				</table>
			</form>
		</c:when>
		<c:when test="${fn:contains(path, 'update') }">
			<form action="/category/update/${blog.blogId }/${category.categoryId }" method="post">
				<table width="720" border="0" cellpadding="1" cellspacing="1">
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td height="5">&nbsp;</td></tr>
					<tr><td height="5"><b>카테고리 수정</b></td></tr>
					<tr><td height="5">&nbsp;</td></tr>
					<tr>
						<td width="150">카테고리명 :</td>
						<td><input type="text" size="40" name="categoryName" value="${category.categoryName }"></td>
					</tr>
					<tr>
						<td width="150">보이기 유형 :</td>
						<td>
							<input type="radio"	name="displayType" value="TITLE" <c:if test="${category.displayType == 'TITLE' }">checked</c:if>>제목&nbsp;&nbsp;
							<input type="radio" name="displayType" value="MIXED"<c:if test="${category.displayType == 'MIXED' }">checked</c:if>>제목 + 내용&nbsp;&nbsp;
						</td>
					</tr>
					<tr>
						<td width="150">설명 :</td>
						<td><input type="text" size="50" name="description" value="${category.description }"></td>
					</tr>
					<tr>
						<td colspan="10" align="center">&nbsp;<input type="submit" value="카테고리 수정"></td>
					</tr>
				</table>
			</form> 
		</c:when>
	</c:choose>
	</td>
	</tr>
	<tr><td height="10" colspan="10">&nbsp;</td></tr>
</table>
		
<%@include file="../layout/footer.jsp" %>