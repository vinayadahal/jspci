<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/tlds/customMethods" prefix="myTag" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>${myTag:capitalize(title)} - Website name</title>
        <link href="${pageContext.request.contextPath}/css/baseStyle.css" type="text/css" rel="stylesheet" />
        <link href="${pageContext.request.contextPath}/css/adminStyle.css" type="text/css" rel="stylesheet" />
        <script src="${pageContext.request.contextPath}/js/styler.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/scriptCommon.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/navBar.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/pages.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/slider.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/images.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/jquery.Jcrop.min.js" type="text/javascript"></script>
        <script src="${pageContext.request.contextPath}/js/ajaxCommon.js?<?php echo date('H:i:s') ?>" type="text/javascript"></script>
        <link rel="icon" type="image/png" href="${pageContext.request.contextPath}/images/favicon.png">
    </head>
    <body>
        <!--<?php-->
        <!--        if ($pageTitle == 'NavBar') {
                $url = baseUrl . 'apanel/navBarData';
                } elseif ($pageTitle == 'Pages') {
                $url = baseUrl . 'apanel/loadPages';
                } elseif ($pageTitle == 'Slider') {
                $url = baseUrl . 'apanel/loadSlider';
                }
                ?>>
                <?php if ($pageTitle != 'Login') { ?>-->
        <c:if test="${title!='login'}">
            <nav class="navbar navbar-default" id="navigation" role="navigation">
                <div class="container-fluid">
                    <div class="navbar-header">
                        <a class="navbar-brand" href="<?php echo baseUrl; ?>apanel/home">
                            <?php echo websiteName; ?> - A Panel 1.0
                        </a>
                    </div>
                    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                        <ul class="nav navbar-nav" id="ulMenu">
                            <li><a href="<?php echo baseUrl; ?>apanel/home">Home</a></li>
                            <li><a href="<?php echo baseUrl; ?>apanel/menu">Menu</a></li>
                            <li><a href="<?php echo baseUrl; ?>apanel/pages">Pages</a></li>
                            <li><a href="<?php echo baseUrl; ?>apanel/images">Images</a></li>
                        </ul>
                        <span class="nav_user_info">Hello,
                            <?php
                            if ($gender == 'male' || $gender == 'Male') {
                            echo 'Mr. ';
                            } else {
                            echo 'Ms. ';
                            }
                            ?>
                            <a href="javascript:void(0);" id="name_link">
                                <?php echo ucfirst($name); ?>
                            </a>
                        </span>
                    </div>
                </div>
            </nav>
            <div class="logout_box" id="logout_box">
                <div class="arrow-up"></div>
                <div class="logout_text">
                    <div class="logout_btns">
                        <i class="glyphicon glyphicon-cog back_btn"></i>
                        <a href="<?php echo baseUrl; ?>apanel/settings" style="outline: 0px;">
                            Settings
                        </a>
                    </div>
                    <div class="logout_btns">
                        <i class="glyphicon glyphicon-off back_btn"></i>
                        <a href="<?php echo baseUrl; ?>apanel/logout">
                            Logout
                        </a>
                    </div>
                </div>
            </div>  
            <?php if (!empty($url)) { ?>
            <div id="flashBox"></div>
            <div id="bodyMain" url="<?php echo $url; ?>"></div>
            <script>
                        $(document).ready(function () {
                    $(window).load(function () {
                        loadData();
                    });
                });
            </script>
        </c:if>
        <script>
            $(document).ready(function () {
                $('#name_link').click(function () {
                    show_logout();
                });
                $('#name_link').focusout(function () {
                    hide_logout();
                });
            });
        </script>
