<%--************
Create the JSP  For Viewing All of The  Category table
 Created By Jonathan Beck 7/31/2024
**********--%>
<%@include file="/WEB-INF/Budget_App/budget_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Budget Categories</h1>
            <p>There ${Categorys.size() eq 1 ? "is" : "are"}&nbsp;${Categories.size()} Category${Categories.size() ne 1 ? "s" : ""}</p>
            Add Category   <a href="addTransactionCategory">Add</a>
            <c:if test="${Categories.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Category_ID</th>

                        <th scope="col">Edit</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Categories}" var="category">
                        <tr>
                            <td><a href = "editCategory?categoryid=${category.category_ID}&mode=view">${fn:escapeXml(category.category_ID)}</a></td>

                            <td><a href = "editCategory?categoryid=${category.category_ID}&mode=edit" > Edit </a></td>


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

