<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" scope="application" />
<%
	pageContext.setAttribute("cr", "\r");
	pageContext.setAttribute("lf", "\n");
	pageContext.setAttribute("crlf", "\r\n");
%>
<!DOCTYPE html>
<html lang="ko">

<script src="/assets/js/lib/jquery-1.11.0.min.js"></script>
<script src="/assets/js/lib/jquery.nice-select.min.js"></script>
<script src="/assets/js/common_anchordata.js"></script>
<script src="/assets/js/paging.js"></script>

<!-- include common vendor scripts used in demo pages -->
<script src="/assets/js/bootstrap.js"></script>    
<script src="/assets/js/ace.js"></script>
<script src="/assets/js/selectbox_select.js"></script>
<script src="/assets/js/script.js"></script>

<tiles:insertAttribute name="header" />
<body>
	
	<div class="body-container">
		<tiles:insertAttribute name="headerSide" /> 
		<tiles:insertAttribute name="body" />
		<tiles:insertAttribute name="footer" />
	</div>
	
</body>

</html>
