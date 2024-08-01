<%--************
Create the JSP  For Viewing All of The  Transaction table
 Created By Jonathan Beck 7/22/2024
**********--%>
<%@include file="/WEB-INF/Budget_App/budget_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All ${User_B.email} Transactions</h1>
            <p>There ${Transactions.size() eq 1 ? "is" : "are"}&nbsp;${Transactions.size()} Transaction${Transactions.size() ne 1 ? "s" : ""}</p>
            Add Category   <a href="addTransactionCategory">Add</a>
            search transactions <a href="search_transaction">search</a>
            <c:if test="${Transactions.size() > 0}">

                <div class="table-responsive">
                    <table class="table table-bordered">
                    <thead>
                    <tr>
                        <th scope="col">Transaction_ID</th>
                        <th scope="col">Account_Num</th>
                        <th scope="col">Post_Date</th>
                        <th scope="col">Check_No</th>
                        <th scope="col">Description</th>
                        <th scope="col">Amount</th>
                        <th scope="col">Type</th>
                        <th scope="col">Status</th>
                        <th scope="col">Category</th>
                        <th scope="col">Save</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${Transactions}" var="transaction">
                        <tr>
                            <td><a href = "edittransaction?transactionid=${transaction.transaction_ID}&mode=view">${fn:escapeXml(transaction.transaction_ID)}</a></td><td>${fn:escapeXml(transaction.account_Num)}</td>
                            <td>${fn:escapeXml(transaction.post_Date)}</td>
                            <td>${fn:escapeXml(transaction.check_No)}</td>
                            <td>${fn:escapeXml(transaction.description)}</td>
                            <td>${fn:escapeXml(transaction.amount)}</td>
                            <td>${fn:escapeXml(transaction.type)}</td>
                            <td>${fn:escapeXml(transaction.status)}</td>

                            <td>
                                <div name ="change" >
                                <input type="hidden" name="t_id" value =${transaction.transaction_ID}>
                                <select  class="category" name="category">
                                    <c:forEach items="${Categories}" var="category">
                                        <option  value="${category.category_ID}"  ${category.category_ID == transaction.category_ID ? 'selected' : ''}>${category.category_ID}</option>
                                    </c:forEach>
                                </select>
                                </td>
                            <td><button  onclick="takevalues(${transaction.transaction_ID})">save</button></td>
                                </div>



                  </c:forEach>
                  </tbody>
              </table>
                </div>


          </c:if>
      </div>
  </div>
</div>
<%--For displaying Previous link except for the 1st page --%>
<c:if test="${currentPage != 1}">
    <td><a href="all-Transactions?page=${currentPage - 1}">Previous</a></td>
</c:if>

<%--For displaying Page numbers.
The when condition does not display a link for the current page--%>
<form action="all-Transactions" method="get">
    Select a page:&nbsp;
    <select name="page">
        <c:forEach var="i" begin="1" end="${noOfPages}">
            <option value=${i}>${i}</option>
        </c:forEach>

    </select>
    <br/><br/>
    <input type="submit" value="Submit" />
</form>

<%--For displaying Next link --%>
<c:if test="${currentPage lt noOfPages}">
    <td><a href="all-Transactions?page=${currentPage + 1}">Next</a></td>
</c:if>
</main>
<%@include file="/WEB-INF/Budget_App/budget_bottom.jsp"%>

