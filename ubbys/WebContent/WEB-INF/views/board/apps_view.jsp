<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:include page="../common/header.jsp" />
    <div class="container apps-view">
      <h1 class="h3 my-5">apps</h1>
      <div class="row mb-4">
        <div class="col mb-sm-3">
          <img src="${apps.appsIconUrl}" class="app-image float-start me-3 rounded"/>
          <span class="badge rounded-pill bg-secondary">${apps.categoryName}</span>
          <h2 class="h4 my-1">${apps.postTitle}</h2>
          <p>${apps.userName}</p>
          <c:forEach items="${apps.tagList}" var="tag">
            <a href="#" class="card-hashtag">#${tag.tagName}</a>
          </c:forEach> 
        </div>
        <div class="col-md-2 d-grid gap-3 mb-sm-3">
          <a href="${apps.appsLink}" target="_blank" class="btn btn-primary btn-lg"><i class="bi bi-download"></i> 다운로드</a>
          <button type="button" class="btn btn-outline-secondary btn-lg"><i class="bi bi-heart"></i> ${apps.postLike}</button>
        </div>
      </div>
      <div class="app-content col-md-9">${apps.postContent}</div>
      <hr>
      <a href="#" class="btn btn-outline-primary">수정</a>
      <a href="#" class="btn btn-outline-danger">삭제</a>
      <fmt:formatDate var="postDate" value="${apps.postDate}" pattern="YYYY년 M월 d일 HH:mm:ss"/>  
      <small class="float-end">작성일시: ${postDate}</small>
    </div>
<jsp:include page="../common/footer.jsp" />