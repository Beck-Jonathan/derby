<%@include file="/WEB-INF/Budget_App/budget_top.jsp"%>



<div class="jumbotron jumbotron-fluid">
    <div class="container">
        <h2 class="display-4 text-center">Welcome to Biscuit's Budgeting</h2>
        <p class="lead text-center">Let's make some money</p>

        <div class="row">
            <div class="col col-md-4">
                <a href="add_transaction">   <button type="button" value="Add" id="Add" ></button></a>

            </div>
            <div class="col col-md-4">
                <a href="all-Transactions">   <button type="button" value="View" id="View" ></button></a>

            </div>
            <div class="col col-md-2">
                <a href="all-Categories">   <button type="button" value="Category" id="Category" ></button></a>
            </div>
            <div class="col col-md-2">
                <a href="MoneyBreakdown">   <button type="button" value="MoneyBreakdown" id="MoneyBreakdown" ></button></a>
            </div>
        </div>

        <div class="row">
            <div class="col col-md-4">

            </div>
            <div class="col col-md-4">

            </div>
            <div class="col col-md-4">

            </div>
        </div>
    </div>
</div>


<%@include file="/WEB-INF/Budget_App/budget_bottom.jsp"%>
