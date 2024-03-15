<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Privileges</h1>
            <p>There ${Privileges.size() eq 1 ? "is" : "are"}&nbsp;${Privileges.size()} Privilege${Privileges.size() ne 1 ? "s" : ""}</p>
            Add Privilege   <a href="addPrivilege">Add</a>
            <c:if test="${Privileges.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Privilege_ID</th>
                        <th scope="col">Name</th>
                        <th scope="col">is_active</th>
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Privileges}" var="privilege">
                        <tr>
                            <td>${privilege.privilege_ID}</td>
                            <td>${privilege.name}</td>
                            <td><input type="checkbox" disabled <c:if test="${privilege.is_active}">checked</c:if>></td>

                            <td><a href = "editprivilege?privilegeid=${privilege.privilege_ID}" > Edit </a></td>
                            <td><a href = "deleteprivilege?privilegeid=${privilege.privilege_ID}" > Delete </a></td>
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