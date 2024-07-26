<%--************
Create the JSP  For Viewing All of The  Transaction table
 Created By Jonathan Beck 7/22/2024
**********--%>
<%@include file="/WEB-INF/Budget_App/budget_top.jsp"%>
<div class = "container">
    <div class="row">
        <div class="col-12">
            <h1>All Roller Transactions</h1>
            <p>There ${Transactions.size() eq 1 ? "is" : "are"}&nbsp;${Transactions.size()} Transaction${Transactions.size() ne 1 ? "s" : ""}</p>
            Add Transaction   <a href="addTransaction">Add</a>
            <c:if test="${Transactions.size() > 0}">
                <div class="table-responsive"><table class="table table-bordered">
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
                        <th scope="col">Edit</th>
                        <th scope="col">Delete</th>
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
                            <td><a href = "edittransaction?transactionid=${transaction.transaction_ID}&mode=edit" > Edit </a></td>
                        <%--************  <td><a href = "deletetransaction?transactionid=${transaction.transaction_ID}&mode=<c:choose><c:when test="${transaction.is_active}">0</c:when>
                      <c:otherwise>1</c:otherwise>
                      </c:choose>">
                              <c:if test="${!transaction.is_active}">un</c:if>Delete </a></td>
                      </tr>
                      **********--%>
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

