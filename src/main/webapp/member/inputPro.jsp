<%@page import="member.MemberDBBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<script src="${project}member.js"></script>

<h2>회원가입</h2>

<c:if test="${result eq 0}">
	<script type="text/javascript">
		//<!--
		erroralert(inputerror);
		-->
	</script>
</c:if>
<c:if test="${result eq 1}">
	<c:redirect url="memberloginform.do"/>
</c:if>