/******************
Create the JSP  For Viewing All of The  Event table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Events</h1>
            <p>There ${Events.size() eq 1 ? "is" : "are"}&nbsp;${Events.size()} Events{Events.size() ne 1 ? "s" : ""}</p>
            <c:if test="${Events.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Event_ID</th>
                        <th scope="col">Facility_ID</th>
                        <th scope="col">Date</th>
                        <th scope="col">Type_ID</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Events}" var="event">
                        <tr>
                            <td>${event.event_id}</td>
                            <td>${event.facility_id}</td>
                            <td>${event.date}</td>
                            <td>${event.type_id}</td>
                        </tr>
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

