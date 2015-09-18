<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/tlds/customMethods" prefix="myTag" %>
<jsp:include page="/WEB-INF/_template/header.jsp"/>
<div class="panel panel-primary panel_login">
    <div class="panel-heading headings">
        <h4 class="panel-title">Login - ${subtitle}</h4>
    </div>
    <div class="panel-body input_wrap">
        <form action="${pageContext.request.contextPath}/apanel/loginCheck" method="POST">
            <div class="inner-addon left-addon">
                <input type="text" class="form-control form_override" name="username" placeholder="Username"/>
                <i class="glyphicon glyphicon-user"></i>
            </div>
            <div class="inner-addon left-addon">
                <input type="password" class="form-control form_override" name="password" placeholder="Password"/>
                <i class="glyphicon glyphicon-lock"></i>
            </div>
            <div style="margin-top:15px;">
                <a href="javascript:void(0)">Forgot Password?</a>
            </div>
            <button type="submit" class="btn btn-default btn_login_override">Login</button>
        </form>
    </div>
</div>
