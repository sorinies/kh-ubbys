<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<jsp:include page="common/header.jsp" />
<div class="container d-flex justify-content-center">
	<form class="form-signup col-4 needs-validation" method="POST" name="signUpForm" action="${contextPath}/signup" novalidate >
		<h1 class="h3 mb-3 fw-normal">회원가입</h1>
		<div class="form-floating mb-3">
			<input type="email" class="form-control" id="inputEmail" name="inputEmail" placeholder="사용할 이메일 입력" required>
			<label for="inputEmail">이메일</label>
			<div class="invalid-feedback" id="checkEmail">
			</div>
		</div>
		<div class="form-floating mb-3">
			<input type="password" class="form-control" id="inputPw" name="inputPw" placeholder="비밀번호 입력" required>
			<label for="inputPw">비밀번호</label>
			<div id="pwHelp" class="form-text">영문/숫자를 혼합한 8자 이상</div>
			<div class="invalid-feedback" id="checkPw">
			</div>
		</div>
		<div class="form-floating mb-3">
			<input type="password" class="form-control" id="inputPwConfirm" name="inputPwConfirm"  placeholder="비밀번호 확인" required>
			<label for="inputPwConfirm">비밀번호 확인</label>
			<div class="invalid-feedback" id="checkPwConfirm">
			</div>
		</div>
		<div class="form-floating mb-3">
			<input type="text" class="form-control" id="inputName" name="inputName" placeholder="닉네임 입력"  required>
			<label for="inputName">닉네임</label>
			<div class="invalid-feedback">
				닉네임을 입력해주세요.
			</div>
		</div>
		<button class="w-100 btn btn-lg btn-primary" type="submit">회원가입</button>
	</form>
</div>
<!-- <script src="${contextPath}/resources/js/id_dup_check.js" defer></script> -->
<script src="${contextPath}/resources/js/signup_validation.js" defer></script>
<jsp:include page="common/footer.jsp" />

