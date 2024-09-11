<%@include file="WEB-INF/Shared/top.jsp"%>

    <title>Java 3 Web Applications - Beck</title>
    <link href="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.css" rel="stylesheet"/>
    <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
<script
        src="https://code.jquery.com/color/jquery.color.plus-names-3.0.0.min.js"
        integrity="sha256-S0cCtaFqwYvsLA/DpisMpMgMjUUGLzLEzL3D2iKzRPw="
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/nprogress@0.2.0/nprogress.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="css/loading.css">
    <script src="js/loading.js"></script>
    <script src="js/home.js"></script>
<link rel="stylesheet" href="css/index.css">
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
        </div>
        <div class="col-md-3"> </div>
    </div>
    <div class="row justify-content-center" style="text-align: center;">
        <div class="col-xs-12 col-sm-6 col-lg-5 mb-4">
            <h3>Noteworthy Projects</h3>
            <div class="list-group">
                <!-- start capstone -->
                <div class ="container row" id="capstone">
                    <div class="col-md-11">
                        <a href="https://github.com/Beck-Jonathan/Capstone" class="border">CapStone Project (.Net, ASP, MVC,WPF,C#, T-SQL)</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                       A year long class project to explore the entire software development lifecycle.
                    </div>
                </div>
                <!-- end capstone -->
                <!-- start java personal project-->
                <div class="container row" id="java">
                    <div class="col-md-11">
                        <a href="home" class="border">Java Personal Project (Jakarta EE, Servlets, JSP, MySQL)</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        Web application to manage custom sports leagues.
                    </div>
                </div>
                    <!-- end java personal project -->
                <!-- start .net project-->
                <div class="container row" id="net">
                <div class="col-md-11">
                <a href="https://github.com/Beck-Jonathan/RollerDerbyNetII" class="border">.Net II/III Final Project (.Net, Razr, cshtml, C#, T-Sql)</a>
                </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        Desktop Multi-User/Multi-Role Application

                    </div>
                </div>
                    <!-- end .Net -->
                <!-- client side start -->
                <div class="container row" id="client">
                    <div class="col-md-11">
                        <a href="apply" class="border">Client Side Scripting Final Project (JavaScript, html, css)</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                      Uses frameworks to develop a use-friendly form.
                    </div>
                </div>
                <!-- client side end-->
                <!--honors start -->
                <div class="container row" id="honors">
                    <div class="col-md-8 border">
                        <a href="https://github.com/Beck-Jonathan/Object_oriented_sql_tables/tree/TSQL_Branch">Honors Project (C#)</a>
                    </div>
                    <div class="col-md-3 border">
                        <a href="${pageContext.request.contextPath}/sample_inputs/Table_Gen.rar" download="sample_data.rar" >Download Sample</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        Takes a data dictionary and creates various code snippets to ease development.
                    </div>
                </div>
                <!-- honors end -->
                <!-- 2d game start -->
                <div class="container row" id="game">
                    <div class="col-md-11">
                <a href="https://play.unity.com/mg/other/build1-sg" class="border">2d Game Dev Final Project (unity, c#)</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                       ?

                    </div>
                    <div class="explanationContainer">
                        Full realized 2d platforming game,
                    </div>
                </div>
                <!-- 2d game end -->
                <!-- budget demo start -->
                <div class="container row" id="budget">
                    <div class="col-md-6 border">
                        <a href="budget_bome">Budgeting Demo</a>
                    </div>
                    <div class="col-md-5 border">
                        <a href="${pageContext.request.contextPath}/sample_inputs/truncated.txt" download="sample_data.txt" >Download Sample</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        A budget analysis tool.
                    </div>
                </div>
                <!-- buget end-->
                <!-- courseowrk start -->
                <div class="container row" id="coursework">
                    <div class="col-md-11">
                <a href="${appURL}/learnx" class="border">Java III coursework Demo</a>
                    </div>
                        <div class="col-md-1 border questionMark" >
                            ?
                        </div>
                        <div class="explanationContainer">
                           example Java Coursework
                        </div>
                    </div>
                <!-- coursework end -->
                <!-- micro header start -->
                <div class="container row">
                    <div class="col-md-12">
                        <h3>Micro Projects</h3>
                    </div>
                </div>
                <!-- micro header end -->
                <!-- ST start -->
                <div class="container row" id="pearson">
                    <div class="col-md-11">
                        <a href="./Resume/May_Smartutor_Econ.pdf" class="list-group-item list-group-item-action">Smartutor Example (Pearson)</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                       SmarTutor
                    </div>
                </div>
                <!-- st end -->
                <!-- email sender start -->
                <div class="container row" id="email">
                    <div class="col-md-11">
                        <a href="email" class="list-group-item list-group-item-action">Email Sender</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        Basic email sending interface.
                    </div>
                </div>
                <!-- email sender end -->

                <!--postfix start -->

                <div class="container row" id="postfix">
                    <div class="col-md-11">
                        <a href="postFix" class="list-group-item list-group-item-action">PostFixCalculator</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                         a post fix calculator
                    </div>
                </div>
                <!-- postfix  end -->
                <!-- api reader start -->
                <div class="container row" id="apidemo">
                    <div class="col-md-11">
                        <a href="api_home" class="list-group-item list-group-item-action">Api Reader</a>
                    </div>
                    <div class="col-md-1 border questionMark" >
                        ?
                    </div>
                    <div class="explanationContainer">
                        Reads MLB player data.
                    </div>
                </div>
                <!-- api end -->




            </div>
            <!-- projects end -->

        </div>
        <div class="col-xs-12 col-sm-6 col-lg-5">
            <h3>Associated Skills</h3>
            <div class="list-group">
                <ul>
                    <li class="skill" id="cSharp">C#</li>
                    <li class="skill" id="Servlets">Java Servlets</li>
                    <li class="skill" id="JSP">Java JSP</li>
                    <li class="skill" id="Framework">JavaScript Frameworks</li>
                    <li class="skill" id="Html">HTML</li>
                    <li class="skill" id="CSS">CSS</li>
                    <li class="skill" id="JavaScript">JavaScript</li>
                    <li class="skill" id="Api">API</li>
                    <li class="skill" id="Multi">MultiUser / Multi Role</li>
                    <li class="skill" id="MySql">MySQL</li>
                    <li class="skill" id="T-SQL">T-SQL</li>
                    <li class="skill" id="Unity">Unity</li>
                    <li class="skill" id="Git">Github and source control#</li>
                    <li class="skill" id="UnitTests">Unit Test</li>
                    <li class="skill" id="Tech">Technical Documentation</li>
                    <li class="skill" id="Agile">Agile</li>
                    <li class="skill" id="Solid">Solid</li>
                    <li class="skill" id="Interfaces">Interfaces</li>
                    <li class="skill" id="DataStruct">Data Structures</li>
                </ul>






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