<%--************
Create the JSP  For Viewing All of The  League table
 Created By Jonathan Beck3/18/2024
 Modified 4/6/2024
**********--%>
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Leagues</h1>
            <p>There ${Leagues.size() eq 1 ? "is" : "are"}&nbsp;${Leagues.size()} League${Leagues.size() ne 1 ? "s" : ""}</p>
            Add League   <a href="addLeague">Add</a>
            <c:if test="${Leagues.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">League_ID</th>
                        <th scope="col">League_Name</th>
                        <th scope="col">League_Level</th>
                        <th scope="col">Monthly_Due</th>
                        <th scope="col">Active_Days</th>
                        <th scope="col">Description</th>
                        <th scope="col">is_active</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Leagues}" var="league">
                        <tr>
                            <td><a href = "editleague?leagueid=${league.league_ID}&mode=view">${fn:escapeXml(league.league_ID)}</a></td><td>${fn:escapeXml(league.league_Name)}</td>
                            <td>${fn:escapeXml(league.league_Level)}</td>
                            <td>${fn:escapeXml(league.monthly_Due)}</td>
                            <td>${fn:escapeXml(league.active_Days)}</td>
                            <td>${fn:escapeXml(league.description)}</td>
                            <td><input type="checkbox" disabled <c:if test="${league.is_active}">checked</c:if>></td>
                            <td><a href = "editleague?leagueid=${league.league_ID}&mode=edit" > Edit </a></td>
                            <td><a href = "deleteleague?leagueid=${league.league_ID}&mode=<c:choose><c:when test="${league.is_active}">0</c:when>
						<c:otherwise>1</c:otherwise>
						</c:choose>">
                                <c:if test="${!league.is_active}">un</c:if>Delete </a></td>
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
