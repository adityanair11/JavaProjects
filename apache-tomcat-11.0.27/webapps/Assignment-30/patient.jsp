
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>
<%
    String action=request.getParameter("action");
    String id=request.getParameter("id");
    String name=request.getParameter("name");
    String age=request.getParameter("age");
    String disease=request.getParameter("disease");
    String status=request.getParameter("status");

    if("add".equals(action)){
        PreparedStatement ps=con.prepareStatement(
            "INSERT INTO patient(name,age,disease,status) VALUES(?,?,?,?)");
        ps.setString(1,name);
        ps.setInt(2,Integer.parseInt(age));
        ps.setString(3,disease);
        ps.setString(4,status);
        ps.executeUpdate();
        ps.close();
    }

    if("update".equals(action)){
        PreparedStatement ps=con.prepareStatement(
            "UPDATE patient SET name=?,age=?,disease=?,status=? WHERE id=?");
        ps.setString(1,name);
        ps.setInt(2,Integer.parseInt(age));
        ps.setString(3,disease);
        ps.setString(4,status);
        ps.setInt(5,Integer.parseInt(id));
        ps.executeUpdate();
        ps.close();
    }

    if("delete".equals(action)){
        PreparedStatement ps=con.prepareStatement(
            "DELETE FROM patient WHERE id=?");
        ps.setInt(1,Integer.parseInt(id));
        ps.executeUpdate();
        ps.close();
    }
%>

<html>
<body>
<h2>Patient Record Management</h2>

<form method="post">
    Patient ID (for update/delete):
    <input type="number" name="id"><br><br>

    Name:
    <input type="text" name="name"><br><br>

    Age:
    <input type="number" name="age"><br><br>

    Disease:
    <input type="text" name="disease"><br><br>

    Treatment Status:
    <input type="text" name="status"><br><br>

    <button name="action" value="add">Add</button>
    <button name="action" value="update">Update</button>
    <button name="action" value="delete">Delete</button>
</form>

<h3>Patient Records</h3>
<table border="1" cellpadding="8">
<tr>
    <th>ID</th><th>Name</th><th>Age</th>
    <th>Disease</th><th>Treatment Status</th>
</tr>

<%
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM patient");

    while(rs.next()){
%>
<tr>
    <td><%=rs.getInt("id")%></td>
    <td><%=rs.getString("name")%></td>
    <td><%=rs.getInt("age")%></td>
    <td><%=rs.getString("disease")%></td>
    <td><%=rs.getString("status")%></td>
</tr>
<%
    }
    rs.close();
    st.close();
    con.close();
%>
</table>
</body>
</html>
