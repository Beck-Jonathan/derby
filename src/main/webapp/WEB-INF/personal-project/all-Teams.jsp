<%--************
Create the JSP  For Viewing All of The  Team table
 Created By Jonathan Beck3/18/2024
**********--%>
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Teams</h1>
            <p>There ${Teams.size() eq 1 ? "is" : "are"}&nbsp;${Teams.size()} Team${Teams.size() ne 1 ? "s" : ""}</p>
            Add Team   <a href="addTeam">Add</a>
            <c:if test="${Teams.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Team_ID</th>
                        <th scope="col">League_ID</th>
                        <th scope="col">Team_Name</th>
                        <th scope="col">Team_Primary_Color</th>
                        <th scope="col">Team_City</th>
                        <th scope="col">Team_State</th>
                        <th scope="col">Logo</th>
                        <th scope="col">is_active</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Teams}" var="team">
                        <tr>
                            <td>${team.team_ID}</td>
                            <td>${team.league_ID}</td>
                            <td>${team.team_Name}</td>
                            <td>${team.team_Primary_Color}</td>
                            <td>${team.team_City}</td>
                            <td>${team.team_State}</td>
                            <td>${team.logo}</td>
                            <td><input type="checkbox" disabled <c:if test="${team.is_active}">checked</c:if>></td>
                            <td><a href = "editteam?teamid=${team.team_ID}" > Edit </a></td>
                            <td><a href = "deleteteam?teamid=${team.team_ID}&mode=<c:choose><c:when test="${team.is_active}">0</c:when>
						<c:otherwise>1</c:otherwise>
						</c:choose>">
                                <c:if test="${!team.is_active}">un</c:if>Delete </a></td>
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

