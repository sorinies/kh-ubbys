<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<c:set var="contextPath" scope="application"
	value="${pageContext.servletContext.contextPath}" />
<jsp:include page="header.jsp" />
<div class="container py-5">
	<h2>회원관리</h2>
		<div class="input-group mb-3 w-50">
          <form action="${contextPath }/adminUser/list" method="GET">
            <div class="input-group mb-3" class="qna-search-area">
    			<select class="form-select" id="searchUserCond" name="sk">
    				<option selected>검색 조건</option>
    				<option value="userEmail">이메일</option>
    				<option value="userNickname">닉네임</option>
    			</select> 
              <input type="text" class="form-control" placeholder="닉네임 혹은 이메일로 검색하세요" name="sv">
  			<button class="btn btn-outline-secondary" type="submit" id="searchUser">검색</button>
            </div>
          </form>
		</div>
		<table class="table table-striped table-hover w-100">
			<thead>
				<tr>
					<th scope="col"><input type="checkbox"></th>
					<th scope="col">회원번호</th>
					<th scope="col">이메일</th>
					<th scope="col">닉네임</th>
					<th scope="col">가입일시</th>
					<th scope="col">관리</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="u" items="${userList}">
				<tr>
					<td><input type="checkbox"></td>
					<td>1</td>
					<td><a href="#">${u.userEmail}</a></td>
					<td>${u.userNickname}</td>
					<td><fmt:formatDate var="createDate"
							value="${u.userRegdate}" pattern="yyyy-MM-dd" /> <fmt:formatDate
							var="today" value="<%=new java.util.Date()%>"
							pattern="yyyy-MM-dd" /> <c:choose>
							<%-- 글 작성일이 오늘이 아닐 경우 --%>
							<c:when test="${createDate != today}">
		                                       ${createDate}
		                                    </c:when>


							<%-- 글 작성일이 오늘일 경우 --%>
							<c:otherwise>
								<fmt:formatDate value="${u.userRegdate}" pattern="yyyy-MM" />
							</c:otherwise>
						</c:choose></td>
					<td><a href="/ubbys/user/update" class="btn btn-primary btn-sm">수정</a> <a
						href="#" class="btn btn-danger btn-sm">삭제</a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>




	<c:choose>
		<%-- 검색시 사용될 부분 : 파라미터명 꼭 확인할 것 --%>
		<c:when test="${ !empty param.sk && !empty param.sv }">
			<c:set var="pageURL"
				value="admin/adminUser/list?sc=${param.sk }&sv=${param.sv }" />
		</c:when>
		<c:otherwise>
			<c:set var="pageURL" value="admin/adminUser/list?" />
		</c:otherwise>
	</c:choose>

	<c:set var="prev" value="${ pageURL }&cp=${ pagination.prevPage }" />
	<c:set var="next" value="${ pageURL }&cp=${ pagination.nextPage }" />
	<nav aria-label="Page navigation">
		<ul class="pagination justify-content-center">
			<c:if test="${ pagination.currentPage <= pagination.pageSize }">
				<li class="page-item disabled"><a class="page-link" href="#"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>

			<c:if test="${ pagination.currentPage > pagination.pageSize }">
				<li class="page-item"><a class="page-link" href="${ prev }"
					aria-label="Previous"><span aria-hidden="true">&laquo;</span></a></li>
			</c:if>

			<%-- 페이지 목록 --%>
			<c:forEach var="p" begin="${ pagination.startPage }"
				end="${ pagination.endPage }">
				<c:choose>
					<c:when test="${ p==pagination.currentPage }">
						<li class="page-item active"><a class="page-link">${ p }</a></li>
					</c:when>
					<c:otherwise>
						<li class="page-item"><a class="page-link"
							href="${ pageURL }&cp=${ p }">${ p }</a></li>
					</c:otherwise>
				</c:choose>
			</c:forEach>

			<c:if test="${ pagination.endPage < pagination.maxPage }">
				<li class="page-item"><a class="page-link" href="${ next }"
					aria-label="Next"><span aria-hidden="true">&raquo;</span></a></li>
			</c:if>
		</ul>
	</nav>


</div>
<jsp:include page="footer.jsp" />