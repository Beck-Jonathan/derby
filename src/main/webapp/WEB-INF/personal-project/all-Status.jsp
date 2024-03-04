/******************
Create the JSP  For Viewing All of The  Status table
Created By Jonathan Beck3/3/2024

***************/
<%@include file="/WEB-INF/personal-project/personal_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Statuss</h1>
            <p>There ${Statuss.size() eq 1 ? "is" : "are"}&nbsp;${Statuss.size()} Statuss${Statuss.size() ne 1 ? "s" : ""}</p>
            <c:if test="${Statuss.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Status_ID</th>
                        <th scope="col">Name</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Statuss}" var="status">
                        <tr>
                            <td>${status.status_ID}</td>
                            <td>${status.name}</td>
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

