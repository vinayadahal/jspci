<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@taglib uri="/WEB-INF/tlds/customMethods" prefix="myTag" %>
<jsp:include page="WEB-INF/_template/header.jsp"/>
<div class="contentWrap">
    <div class="content"> 
        <div class="sideCont" style="margin-top: 115px;">
            <c:if test="${not empty popTrip}">
                <div class="heading">Popular Trips</div>
                <div class="featuredTrip">
                    <c:forEach items="${popTrip}" var="trip">
                        <div class="featureContent">
                            <h3><a href="${pageContext.request.contextPath}/details/${trip.id}"><c:out value="${trip.title}"/></a></h3>
                            <div class="tripDetails">
                                <span class="sideBarIcon">
                                    <a href="${pageContext.request.contextPath}/details/${trip.id}">
                                        <img src="${pageContext.request.contextPath}/${trip.imgPath}" alt="trekIcon" />
                                    </a>
                                </span>
                                <c:out value="${fn:substring(trip.desc,0,170)}" escapeXml="false"/>
                                ... <a href="${pageContext.request.contextPath}/details/${trip.id}">Read More</a> &raquo;
                            </div> 
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <c:if test="${not empty featuredTrip}">
                <div class="heading">Featured Trips</div>
                <div class="featuredTrip">
                    <c:forEach items="${featuredTrip}" var="fTrip">
                        <div class="featureContent">
                            <h3><a href="${pageContext.request.contextPath}/details/${fTrip.id}"><c:out value="${fTrip.title}" /></a></h3>
                            <div class="tripDetails">
                                <span class="sideBarIcon">
                                    <a href="${pageContext.request.contextPath}/details/${fTrip.id}">
                                        <img src="${pageContext.request.contextPath}/${fTrip.imgPath}" alt="trekIcon" />
                                    </a>
                                </span>
                                <c:out value="${fn:substring(fTrip.desc,0,170)}" escapeXml="false"/>
                                ... <a href="${pageContext.request.contextPath}/details/${fTrip.id}">Read More</a> &raquo;
                            </div> 
                        </div>
                    </c:forEach>
                </div>
            </c:if>
        </div>
        <div class="middleCont">
            <c:forEach items="${about}" var="aboutData">
                <h2 style="padding: 10px 0px;border-bottom: 1px solid #ccc;">
                    <c:out value="${aboutData.title}" escapeXml="false"/>
                </h2>
                <div class="detail">
                    <c:out value="${aboutData.content}" escapeXml="false"/>
                </div>
            </c:forEach>
            <div class="searchTrip">
                <form method="POST" action="<?php echo baseUrl . 'search/' ?>" id="selectForm">
                    <span>Search Trip</span>
                    <select class="searchTripSelect" name='activity'>
                        <option value="" disabled selected>Activity</option>
                        <c:forEach items="${activity}" var="activity">
                            <option><c:out value="${activity.category}"/></option>
                        </c:forEach>
                    </select>
                    <select class="searchTripSelect" name='area'>
                        <option value="" disabled selected>Area</option>
                        <c:forEach items="${area}" var="area">
                            <option><c:out value="${area.area}"/></option>
                        </c:forEach>
                    </select>
                    <select class="searchTripSelect" name='duration'>
                        <option value="" disabled selected>Duration</option>
                        <c:forEach items="${duration}" var="duration">
                            <option><c:out value="${duration.duration}"/></option>
                        </c:forEach>
                    </select>
                    <select class="searchTripSelect" name='departure'>
                        <option value="" disabled selected>Departure</option>
                        <c:forEach items="${departure}" var="departure">
                            <option><c:out value="${departure.departure}"/></option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Search" />
                </form>
            </div>
            <div class="allTrek">
                <h2>Available Treks</h2><br>
                <c:if test="${not empty allTrip}">
                    <c:forEach items="${allTrip}" var="allTrips">
                        <div class="trekDetails">
                            <span class="trekIcon">
                                <a href="${pageContext.request.contextPath}/details/${allTrips.id}">
                                    <img src="${pageContext.request.contextPath}/${allTrips.imgPath}" alt="trekIcon" />
                                </a>
                            </span>
                            <div class="trekText">
                                <h3><a href="${pageContext.request.contextPath}/details/${allTrips.id}">
                                        <c:out value="${myTag:capitalize(allTrips.title)}" />
                                    </a>
                                </h3>
                                <br />
                                <c:out value="${fn:substring(allTrips.desc,0,300)}" escapeXml="false"/>...
                            </div>
                            <div class="otherDetails">
                                <div class="otherText">
                                    <b>Area:</b>
                                    <span style="color:#fff;"><c:out value="${myTag:capitalize(allTrips.area)}"/></span>
                                </div>
                                <div class="otherText">
                                    <b>Duration:</b> 
                                    <span style="color:#fff"><c:out value="${allTrips.duration}"/></span>
                                </div>
                                <div class="otherText">
                                    <b>Departure:</b> 
                                    <span style="color:#fff"><c:out value="${allTrips.departure}"/></span>
                                </div>
                                <div class="otherText">
                                    <a href="javascript:void(0);" onclick="loadPopUp();">Book Trip</a> | <a href="${baseUrl}details/${allTrips.id}">Read More</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>
                </c:if>
                <a href="${pageContext.request.contextPath}/home/?page=1"><button class="pages">&laquo; First</button></a>
                <c:forEach begin="1" end="${numPages}" var="val">
                    <a href="${pageContext.request.contextPath}/home/?page=${val}"><button class="pagesNum"><c:out value="${val}"/></button></a>
                    </c:forEach>
                <a href="${pageContext.request.contextPath}/home/?page=${numPages}"><button class="pages">Last &raquo;</button></a>
            </div>
        </div>
        <div class="sideCont">
            <c:if test="${not empty latestTrip}">
                <div class="heading">Latest Trips</div>
                <div class="featuredTrip">
                    <c:forEach items="${latestTrip}" var="lTrip">
                        <div class="featureContent">
                            <h3><a href="${pageContext.request.contextPath}/details/${lTrip.id}"><c:out value="${lTrip.title}" /></a></h3>
                            <div class="tripDetails">
                                <span class="sideBarIcon">
                                    <a href="${pageContext.request.contextPath}/details/${lTrip.id}">
                                        <img src="${pageContext.request.contextPath}/${lTrip.imgPath}" alt="trekIcon" />
                                    </a>
                                </span>
                                <c:out value="${fn:substring(lTrip.desc,0,170)}" escapeXml="false"/>
                                ... <a href="${pageContext.request.contextPath}/details/${lTrip.id}">Read More</a> &raquo;
                            </div> 
                        </div>
                    </c:forEach>
                </div>
            </c:if>
            <!--<div class="heading">Find us in facebook</div>-->
            <!--<div class="fb-like-box" data-href="https://www.facebook.com/pages/DBS-Trade-Centre/1526654370937336" width="245" data-colorscheme="dark" data-show-faces="true" data-header="false" data-stream="false" data-show-border="false"></div>-->
        </div>
        <script>
            $(function () {
                $("#carousel").carouFredSel({responsive: false, items: {visible: 1, width: 700, height: 350}, scroll: {duration: 250, timeoutDuration: 3000, fx: "uncover-fade"}, pagination: "#pager"});
            });
            (function (e, t, n) {
                var r, i = e.getElementsByTagName(t)[0];
                if (e.getElementById(n))
                    return;
                r = e.createElement(t);
                r.id = n;
                r.src = "//connect.facebook.net/en_US/sdk.js#xfbml=1&version=v2.0";
                i.parentNode.insertBefore(r, i);
            })(document, "script", "facebook-jssdk");
        </script>
    </div>

    <jsp:include page="WEB-INF/_template/footer.jsp"/>