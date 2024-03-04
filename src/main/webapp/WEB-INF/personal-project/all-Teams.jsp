/******************
Create the JSP  For Viewing All of The  Team table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Teams</h1>
            <p>There ${Teams.size() eq 1 ? "is" : "are"}&nbsp;${Teams.size()} Teams{Teams.size() ne 1 ? "s" : ""}</p>
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

