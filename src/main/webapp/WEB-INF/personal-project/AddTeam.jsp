<%--************
Create the JSP  For adding to The  Team table
 Created By Jonathan Beck3/18/2024
**********--%>
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <form method="post" action="${appURL}/addTeam" id = "addTeam" >"
        <!-- League_ID -->
        <div class ="row" id = "row0">
            <label for="inputteamLeague_ID" class="form-label">League_ID</label>
            <div class="input-group input-group-lg">
                <select  class="<c:if test="${not empty results.teamLeague_IDerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="League_ID" id="inputteamLeague_ID" name="inputteamLeague_ID" value="${results.League_ID}">
                    <c:forEach items="${Leagues}" var="League">
                        <option value="${League.league_ID}">${League.name}   </option>
                    </c:forEach>
                </select>
                <c:if test="${not empty results.teamLeague_IDerror}">
                    <div class="invalid-feedback">${results.teamLeague_IDerror}</div>
                </c:if>
            </div>
        </div>
        <!-- Team_Name -->
        <div class ="row" id = "row1">
            <label for="inputteamTeam_Name" class="form-label">Team_Name</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.teamTeam_Nameerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Team_Name" id="inputteamTeam_Name" name="inputteamTeam_Name" value="${results.Team_Name}">
                <c:if test="${not empty results.teamTeam_Nameerror}">
                    <div class="invalid-feedback">${results.teamTeam_Nameerror}</div>
                </c:if>
            </div>
        </div>
        <!-- Team_Primary_Color -->
        <div class ="row" id = "row2">
            <label for="inputteamTeam_Primary_Color" class="form-label">Team_Primary_Color</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.teamTeam_Primary_Colorerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Team_Primary_Color" id="inputteamTeam_Primary_Color" name="inputteamTeam_Primary_Color" value="${results.Team_Primary_Color}">
                <c:if test="${not empty results.teamTeam_Primary_Colorerror}">
                    <div class="invalid-feedback">${results.teamTeam_Primary_Colorerror}</div>
                </c:if>
            </div>
        </div>
        <!-- Team_City -->
        <div class ="row" id = "row3">
            <label for="inputteamTeam_City" class="form-label">Team_City</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.teamTeam_Cityerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Team_City" id="inputteamTeam_City" name="inputteamTeam_City" value="${results.Team_City}">
                <c:if test="${not empty results.teamTeam_Cityerror}">
                    <div class="invalid-feedback">${results.teamTeam_Cityerror}</div>
                </c:if>
            </div>
        </div>
        <!-- Team_State -->
        <div class ="row" id = "row4">
            <label for="inputteamTeam_State" class="form-label">Team_State</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.teamTeam_Stateerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Team_State" id="inputteamTeam_State" name="inputteamTeam_State" value="${results.Team_State}">
                <c:if test="${not empty results.teamTeam_Stateerror}">
                    <div class="invalid-feedback">${results.teamTeam_Stateerror}</div>
                </c:if>
            </div>
        </div>
        <!-- Logo -->
        <div class ="row" id = "row5">
            <label for="inputteamLogo" class="form-label">Logo</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.teamLogoerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="Logo" id="inputteamLogo" name="inputteamLogo" value="${results.Logo}">
                <c:if test="${not empty results.teamLogoerror}">
                    <div class="invalid-feedback">${results.teamLogoerror}</div>
                </c:if>
            </div>
        </div>
        <div class="align-items-center mt-0">
            <div class="d-grid"><button class="btn btn-orange mb-0" type="submit">Sign Up</button></div>
            <c:if test="${not empty results.dbStatus}"
            ><p>${results.dbStatus}</p>
            </c:if>
        </div>
    </form>
</div>
<%@include file="/WEB-INF/personal-project/personal_bottom.jsp"%>

