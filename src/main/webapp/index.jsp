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
    <div class="row justify-content-center" style="text-align: center;">
        <div class="col-xs-12 col-sm-6 col-lg-5 mb-4">
            <h3>Class Final Projects</h3>
            <div class="list-group">
                <a href="home" class="list-group-item list-group-item-action">Java Final Project (Jakarta EE, Servlets, JSP, MySQL)</a>
                <a href="https://github.com/Beck-Jonathan/RollerDerbyNetII" class="list-group-item list-group-item-action">.Net II Final Project (.Net, C#, T-Sql)</a>
                <a href="apply" class="list-group-item list-group-item-action">Client Side Scripting Final Project (JavaScript, html, css)</a>
                <a href="https://github.com/Beck-Jonathan/Object_oriented_sql_tables/tree/TSQL_Branch" class="list-group-item list-group-item-action">Honors Project (C#)</a>
                <a href="https://play.unity.com/mg/other/build1-sg" class="list-group-item list-group-item-action">2d Game Dev Final Project (unity, c#)</a>
                <a href="${appURL}/learnx" class="list-group-item list-group-item-action">Java III coursework Demo</a>




            </div>
        </div>
        <div class="col-xs-12 col-sm-6 col-lg-5">
            <h3>Micro Projects</h3>
            <div class="list-group">
                <a href="./Resume/May_Smartutor_Econ.pdf" class="list-group-item list-group-item-action">Smartutor Example (Pearson)</a>
                <a href="email" class="list-group-item list-group-item-action">Email Sender</a>
                <a href="postFix" class="list-group-item list-group-item-action">PostFixCalculator</a>


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