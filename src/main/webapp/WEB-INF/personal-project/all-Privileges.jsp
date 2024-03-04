/******************
Create the JSP  For Viewing All of The  Privilege table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Privileges</h1>
            <p>There ${Privileges.size() eq 1 ? "is" : "are"}&nbsp;${Privileges.size()} Privileges{Privileges.size() ne 1 ? "s" : ""}</p>
            <c:if test="${Privileges.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Privilege_ID</th>
                        <th scope="col">Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Privileges}" var="privilege">
                        <tr>
                            <td>${privilege.privilege_ID}</td>
                            <td>${privilege.name}</td>
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

