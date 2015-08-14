<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/tlds/customMethods" prefix="myTag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${myTag:capitalize(title)} - Trekking Platform</title>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/favicon.png">
        <link href="${pageContext.request.contextPath}/css/style.css" type="text/css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/js/styler.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/scripts.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/slideShow.js" type="text/javascript"></script>
    </head>
    <body>
        <div class="headerWrap">
            <div class="header">
                <div class="logoArea">
                    <img src="${pageContext.request.contextPath}/images/logo.png" class="logoImg" />
                </div>
                <ul>
                    <li><a href="${pageContext.request.contextPath}/home">Home</a></li>
                    <li><a href="${pageContext.request.contextPath}/about">About us</a></li>
                    <li><a href="${pageContext.request.contextPath}/team">Our Team</a></li>
                    <li><a href="${pageContext.request.contextPath}/gallery">Gallery</a></li>
                    <li><a id="dropDown">Categories</a>
                        <div class="menu_list" id="dropDownItem">
                            <c:forEach items="${category}" var="catItems">
                                <div><a href="${pageContext.request.contextPath}/${catItems.category}"><c:out value="${myTag:capitalize(catItems.category)}"/></a></div>
                                </c:forEach>
                        </div>
                    </li>
                    <li><a href="${pageContext.request.contextPath}/recommended">Recommended</a></li>
                </ul>
                <div class="searchArea">
                    <form method="POST" action="${pageContext.request.contextPath}/searchSite/">
                        <input type="text" placeholder="Search ..." name="searchSite" class="headSearch"/>
                        <button type="submit" class="searchIcon"><img src="${pageContext.request.contextPath}/images/toolbar_find.png" height="20" width="20" alt="searchIcon"></button>
                    </form>
                </div>
            </div>
        </div>
        <!--header end-->

