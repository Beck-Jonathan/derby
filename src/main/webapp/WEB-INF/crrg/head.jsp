<%@include file="/WEB-INF/Shared/top.jsp"%>
<title>${BusinessName}| ${pageTitle}</title>
<link rel="shortcut icon" href="${appURL}/images/learnx/learnx-icon.png">
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.2/font/bootstrap-icons.min.css">

<link href=" https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css " rel="stylesheet">

<c:if test="${pageTitle eq 'Image Gallery of CRRD. Photos: Mark Young'}">
    <link rel="stylesheet" href="${appURL}/css/crrg/crrg.css">
</c:if>

<c:if test="${pageTitle ne 'Image Gallery of CRRD. Photos: Mark Young'}">
    <link rel="stylesheet" href="${appURL}/css/crrg/crrg_admin.css">
</c:if>





</head>
<body>
