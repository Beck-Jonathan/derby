/******************
Create the JSP  For Viewing All of The  League table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Leagues</h1>
            <p>There ${Leagues.size() eq 1 ? "is" : "are"}&nbsp;${Leagues.size()} Leagues{Leagues.size() ne 1 ? "s" : ""}</p>
            <c:if test="${Leagues.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">League_ID</th>
                        <th scope="col">League_Name</th>
                        <th scope="col">League_Level</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Leagues}" var="league">
                        <tr>
                            <td>${league.league_ID}</td>
                            <td>${league.league_Name}</td>
                            <td>${league.league_Level}</td>
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

