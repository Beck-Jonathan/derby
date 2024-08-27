<%@include file="WEB-INF/Shared/top.jsp"%>

    <title>Java 3 Web Applications - Beck</title>
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/loading.css">
    <script src="js/loading.js"></script>
</head>
<body>
<div class="container py-4 text-center">
    <h1 class="my-4">Personal Portfolio Page - Beck </h1>

    <div class="row">
        <div class="col-md-4 h2"> Jonathan Beck</div>
        <div class="col-md-4"> </div>
        <div class="col-md-1"> <a href="https://github.com/Beck-Jonathan"> <img src="images/icons/github.svg"></a></div>
        <div class="col-md-1"> <a href="mailto:beckjonathanj@gmail.com" target="_blank"> <img src="images/icons/mailbox.svg"> </a></div>
        <div class="col-md-1"> <a href="./Resume/resume_beck.pdf"> <img src="images/icons/briefcase-fill.svg"></a></div>
        <div class="col-md-1"> <a href="https://www.linkedin.com/in/Beck-Jonathan/"> <img src="images/icons/linkedin.svg"></a></div>


    </div>
    <div class="row">
        <div class="col-md-4"> </div>
        <div class="col-md-4 h1"> Welcome.</div>
        <div class="col-md-4"> </div>
    </div>
    <div class="row mb-4">
        <div class="col-md-3"> </div>
        <div class="col-md-6"> Dedicated and passionate computer programmer with a knack for problem-solving
            and a drive for continuous learning. Proficient in multiple programming languages and experienced
            in developing innovative software solutions. Excels in collaborative environments and thrives on challenges
            that push the boundaries of my skills.</div>
        <div class="col-md-3"> </div>
    </div>
    <div class ="row mb4">
        <div class="col-md-3"> </div>
        <div class="col-md-6">
            <p> A pdf explaining the below applications is linked  <a href="${pageContext.request.contextPath}/sample_inputs/README.pdf" download="README.pdf" >here.</a>
        </div>
        <div class="col-md-3"> </div>
    </div>
    <div class="row justify-content-center" style="text-align: center;">
        <div class="col-xs-12 col-sm-6 col-lg-5 mb-4">
            <h3>Noteworthy Projects</h3>
            <div class="list-group">
                <a href="https://github.com/Beck-Jonathan/Capstone" class="border">CapStone Project (.Net, ASP, MVC,WPF,C#, T-SQL)</a>
                <a href="home" class="border">Java Personal Project (Jakarta EE, Servlets, JSP, MySQL)</a>
                <a href="https://github.com/Beck-Jonathan/RollerDerbyNetII" class="border">.Net II/III Final Project (.Net, Razr, cshtml, C#, T-Sql)</a>
                <a href="apply" class="border">Client Side Scripting Final Project (JavaScript, html, css)</a>
                <div class="container row"><div class="col-md-8 border"><a href="https://github.com/Beck-Jonathan/Object_oriented_sql_tables/tree/TSQL_Branch">Honors Project (C#)</a> </div><div class="col-md-4 border"><a href="${pageContext.request.contextPath}/sample_inputs/Table_Gen.rar" download="sample_data.rar" >Download Sample</a></div></div>
                <a href="https://play.unity.com/mg/other/build1-sg" class="border">2d Game Dev Final Project (unity, c#)</a>
                <div class="container row"><div class="col-md-8 border"> <a href="budget_bome">Budgeting Demo</a></div><div class="col-md-4 border"><a href="${pageContext.request.contextPath}/sample_inputs/truncated.txt" download="sample_data.txt" >Download Sample</a></div></div>
                <a href="${appURL}/learnx" class="border">Java III coursework Demo</a>

            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-lg-5">
            <h3>Micro Projects</h3>
            <div class="list-group">
                <a href="./Resume/May_Smartutor_Econ.pdf" class="list-group-item list-group-item-action">Smartutor Example (Pearson)</a>
                <a href="email" class="list-group-item list-group-item-action">Email Sender</a>
                <a href="postFix" class="list-group-item list-group-item-action">PostFixCalculator</a>
                <a href="api_home" class="list-group-item list-group-item-action">Api Reader</a>


            </div>
        </div>

    </div>
    <div class="row">
        <div class="col-md-4"> </div>
        <div class="col-md-4 "> .</div>
        <div class="col-md-4"> &copy; 2024 - Beck </div>
    </div>
</div>
<%@include file="WEB-INF/Shared/bottom.jsp"%>