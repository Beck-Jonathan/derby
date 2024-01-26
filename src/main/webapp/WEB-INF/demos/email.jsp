<%--
  Created by IntelliJ IDEA.
  User: jjbec
  Date: 1/25/2024
  Time: 8:17 PM
  To change this template use File | Settings | File Templates.
--%>

<%@include file="../Shared/top.jsp"%>
</head>
<body>
<form action="email" method="post">
    <!-- Email Address -->
    <label for="email">Email Address:</label>
    <input type="email" id="email" name="email" required>
    <br>

    <!-- Subject -->
    <label for="subject">Subject:</label>
    <input type="text" id="subject" name="subject" required>
    <br>

    <!-- Message -->
    <label for="message">Message:</label>
    <textarea id="message" name="message" rows="4" required></textarea>
    <br>

    <!-- Submit Button -->
    <input type="submit" value="Submit">
</form>

<%@include file="../Shared/bottom.jsp"%>