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
                        <c:forEach var="i" begin="0" end="${categories.size()-1}">

                        <th>${2024-i}</th>


                    </c:forEach>
                        <th scope="col">Category</th>

                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="k" begin="0" end="${categories[0].size()}">
                        <tr>
                    <c:forEach var="l" begin="0" end="${categories.size()-1}">

                            <td>
                                <a href="year_and_category?category=${categories[0][k].category_ID}&year=${2024-l}" >   $ ${categories[l][k].amount}  <br/> Count:${categories[l][k].count}</a>
                            </td>

                    </c:forEach>
                            <td>  ${categories[0][k].category_ID}</td>
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

