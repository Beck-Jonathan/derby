<%--************
Create the JSP  For Viewing All of The  Category table
 Created By Jonathan Beck 7/30/2024
**********--%>
<%@include file="/WEB-INF/Budget_App/budget_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Categorys</h1>
            <p>There ${categories.size() eq 1 ? "is" : "are"}&nbsp;${categories.size()} Category${categories.size() ne 1 ? "s" : ""}</p>
            Add Category   <a href="addCategory">Add</a>
            <c:if test="${categories.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Category_ID</th>
                        <th scope="col">Total</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${categories}" var="category">
                        <tr>
                            <td>    ${category.amount}                        </td>
                            <td>      ${category.category_ID}                      </td>
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
<%@include file="/WEB-INF/Budget_App/budget_bottom.jsp"%>

