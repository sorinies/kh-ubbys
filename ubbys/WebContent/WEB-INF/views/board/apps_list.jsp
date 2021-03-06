<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="../common/header.jsp" />
    <div class="container">
      <a href="write" class="btn btn-primary float-end">작성하기</a>
      <h1 class="h3 my-5">apps</h1>
      <form action="list" method="GET">
        <div class="row">
          <div class="col-xs-12 col-sm-4">
            <select class="form-select" name="sort">
              <option selected value="newest">최근 작성순</option>
              <option value="mostLiked">좋아요 많은 순</option>
            </select>
          </div>
          <div class="col-xs-12 col-sm-4">
            <select class="form-select" name="category">
              <option selected value="">카테고리 전체</option>
              <c:if test="${!empty category}">
              <c:forEach items="${category}" var="c">
              <option value="${c.categoryId}">${c.categoryName}</option>
              </c:forEach>
              </c:if>
            </select>
          </div>
          <div class="col-xs-12 col-sm-4">
            <div class="input-group mb-3">
              <select class="form-select" name="searchType">
                <option selected value="tag">해시태그</option>
                <option value="title">이름(제목)</option>
              </select>
              <input type="text" class="form-control" name="q" placeholder="이름 혹은 해시태그로 검색">
              <button class="btn btn-outline-secondary" type="submit" id="searchApps"><i class="bi bi-search"></i> 검색</button>
            </div>
          </div>
        </div>
      </form>
      <div class="row">
       <c:choose>
        <c:when test="${empty appsList}">
          <p>등록된 게시물이 없습니다.</p>
        </c:when>
        <c:otherwise>       
         <c:forEach items="${appsList}" var="apps">
          <div class="col-lg-4 col-md-6 mb-3">
           <div class="card">
            <div class="card-body">
              <img src="${apps.appsIconUrl}" width="45" height="45" class="rounded-3 float-start me-2" alt="">
              <span class="btn btn-outline-secondary btn-like float-end"><i class="bi bi-heart"></i> ${apps.postLike}</span>
              
              <h5 class="card-title"><a href="view?no=${apps.postId}&cp=${pagination.currentPage}" class="apps-link stretched-link">${apps.postTitle}</a></h5>
              <h6 class="card-subtitle mb-2 text-muted">${apps.categoryName}</h6>
        
              <p class="card-text">${apps.appsSummary}</p>
            </div>
            <div class="card-footer">
              <c:forEach items="${apps.tagList}" var="tag">
                <a href="list?searchType=tag&q=${tag.tagName}" class="card-hashtag">#${tag.tagName}</a>
              </c:forEach> 
            </div>
           </div>
          </div>
         </c:forEach>
        </c:otherwise> 
       </c:choose>
      </div>
      <c:set var="prev" value="list&cp=${pagination.prevPage}"/>
      <c:set var="next" value="list&cp=${pagination.nextPage}"/>
      <nav aria-label="Page navigation">
        <ul class="pagination justify-content-center">
         <c:if test="${pagination.currentPage > pagination.pageSize}">
          <li class="page-item disabled">
            <a class="page-link" href="#" aria-label="Previous">
              <span aria-hidden="true">&laquo;</span>
            </a>
          </li>
         </c:if>
         <c:forEach var="p" begin="${pagination.startPage}" end="${pagination.endPage}">
          <c:choose>
           <c:when test="${p == pagination.currentPage}">
            <li class="page-item active"><a class="page-link" href="#">${p}</a></li>
           </c:when>
           <c:otherwise>
            <li class="page-item"><a class="page-link" href="list?cp=${p}">${p}</a></li>
           </c:otherwise>
           </c:choose>
          </c:forEach>
          <c:if test="${pagination.currentPage - pagination.maxPage + pagination.pageSize < 1}">
          <li class="page-item">
            <a class="page-link" href="${next}" aria-label="Next">
              <span aria-hidden="true">&raquo;</span>
            </a>
          </li>
          </c:if>
        </ul>
      </nav>
    </div>
<jsp:include page="../common/footer.jsp" />