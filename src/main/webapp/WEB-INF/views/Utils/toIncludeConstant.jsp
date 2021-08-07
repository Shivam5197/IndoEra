<%@page import="com.Indoera.ecomProject.Utils.Constants"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html>
<head>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<meta charset="ISO-8859-1">
</head>
<body>
<%@page  import="com.Indoera.ecomProject.Utils.Constants.storeStatus" %>
<%@page  import="com.Indoera.ecomProject.Utils.Constants.userStatus" %>
<%@page  import="com.Indoera.ecomProject.Utils.Constants.userRole" %>
<%@page  import="com.Indoera.ecomProject.Utils.Constants.Gender" %>


<c:set var="openStore" value="<%= storeStatus.OPEN%>" scope="page" />
<c:set var="closedStore" value="<%= storeStatus.CLOSED%>" scope="page" />
<c:set var="onHoldStore" value="<%= storeStatus.ONHOLD%>" scope="page" />
<c:set var="reopenSoonStore" value="<%= storeStatus.REOPENINGSOON%>" scope="page" />

<c:set var="activeUser" value="<%= userStatus.ACTIVE%>" scope="page" />
<c:set var="inActiveUser" value="<%= userStatus.INACTIVE%>" scope="page" />
<c:set var="licenseExpired" value="<%= userStatus.LICENCE_EXPIRED%>" scope="page" />
<c:set var="susPended" value="<%= userStatus.SUSPENDED%>" scope="page" />

<%-- <c:set var="ADMIN" value="<%= userRole.ADMIN%>" scope="page" />
<c:set var="STOREOWNER" value="<%= userRole.STOREOWNER%>" scope="page" />
<c:set var="CUSTOMER" value="<%= userRole.CUSTOMER%>" scope="page" />
 --%>
<c:set var="maleUser" value="<%= Gender.MALE%>" scope="page" />
<c:set var="feMaleUser" value="<%= Gender.FEMALE%>" scope="page" />
<c:set var="otherUser" value="<%= Gender.OTHER%>" scope="page" />

<script>
var _const_userRoles = {
		slt_admin : "<%=Constants.userRole.ADMIN%>",
		store_owner : "<%=Constants.userRole.STOREOWNER%>",
		customer : "<%=Constants.userRole.CUSTOMER%>",
}
</script>

</body>
</html>