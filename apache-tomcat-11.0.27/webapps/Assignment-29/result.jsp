<html>
<body>
    <h2>Student Information</h2>

    <%
        String id=request.getParameter("id");
        String name=request.getParameter("name");
        String dept=request.getParameter("dept");
        String email=request.getParameter("email");
    %>

    Student ID: <%= id %><br><br>
    Name: <%= name %><br><br>
    Department: <%= dept %><br><br>
    Email: <%= email %><br><br>
</body>
</html>