/******************
Create the JSP  For adding to The  League table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <form method="post" action="${appURL}/addLeague" id = "addLeague" >"
        <!-- League_Name -->
        <div class ="row" id = "row0">
            <label for="inputleagueLeague_Name" class="form-label">League_Name</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.leagueLeague_Nameerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="League_Name" id="inputleagueLeague_Name" name="inputleagueLeague_Name" value="${results.League_Name}">
                <c:if test="${not empty results.leagueLeague_Nameerror}">
                    <div class="invalid-feedback">${results.leagueLeague_Nameerror}</div>
                </c:if>
            </div>
        </div>
        <!-- League_Level -->
        <div class ="row" id = "row1">
            <label for="inputleagueLeague_Level" class="form-label">League_Level</label>
            <div class="input-group input-group-lg">
                <input type="text" class="<c:if test="${not empty results.leagueLeague_Levelerror}">is-invalid</c:if> form-control border-0 bg-light rounded-end ps-1" placeholder="League_Level" id="inputleagueLeague_Level" name="inputleagueLeague_Level" value="${results.League_Level}">
                <c:if test="${not empty results.leagueLeague_Levelerror}">
                    <div class="invalid-feedback">${results.leagueLeague_Levelerror}</div>
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
</div>
<%@include file="/WEB-INF/personal-project/personal_bottom.jsp"%>

