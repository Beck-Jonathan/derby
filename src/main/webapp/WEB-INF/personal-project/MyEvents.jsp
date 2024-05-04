<%--************
Create the JSP  For Viewing All of The  Event table
 Created By Jonathan Beck 5/4/2024
**********--%>
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Events for ${User.user_Name}</h1>
            <p>There ${Events.size() eq 1 ? "is" : "are"}&nbsp;${Events.size()} Event${Events.size() ne 1 ? "s" : ""}</p>

            <c:if test="${Events.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Event_ID</th>
                        <th scope="col">Facility_ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Type_ID</th>
                        <th scope="col">is_active</th>


                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Events}" var="event">
                        <tr>
                            <td><a href = "editevent?eventid=${event.event_ID}&mode=view">${fn:escapeXml(event.event_ID)}</a></td><td>${fn:escapeXml(event.facility_ID)}</td>
                            <td>${fn:escapeXml(event.date)}</td>
                            <td>${fn:escapeXml(event.type_ID)}</td>
                            <td><input type="checkbox" disabled <c:if test="${event.is_active}">checked</c:if>></td>


                    </c:forEach>
                    </tbody>
                </table>
                </div>
            </c:if>
        </div>
    </div>
</div>
</main>
<%@include file="/WEB-INF/personal-project/personal_bottom.jsp"%>

