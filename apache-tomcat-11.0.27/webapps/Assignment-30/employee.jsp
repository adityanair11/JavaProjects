
<%@ page import="java.sql.*" %>
<%@ include file="db.jsp" %>

<%
    String action=request.getParameter("action");
    String id=request.getParameter("id");
    String name=request.getParameter("name");
    String dept=request.getParameter("department");
    String salary=request.getParameter("salary");
    String message="";

    if("add".equals(action)){
        if(name!=null && !name.trim().isEmpty() &&
           dept!=null && !dept.trim().isEmpty() &&
           salary!=null && !salary.trim().isEmpty()){

            PreparedStatement ps=con.prepareStatement(
                "INSERT INTO employee(name,department,salary) VALUES(?,?,?)");

            ps.setString(1,name);
            ps.setString(2,dept);
            ps.setDouble(3,Double.parseDouble(salary));

            int rows=ps.executeUpdate();

            if(rows>0){
                message="Employee added successfully!";
            }

            ps.close();
        }
        else{
            message="Please enter name, department and salary.";
        }
    }

    if("update".equals(action)){
        if(id!=null && !id.trim().isEmpty() &&
           name!=null && !name.trim().isEmpty() &&
           dept!=null && !dept.trim().isEmpty() &&
           salary!=null && !salary.trim().isEmpty()){

            PreparedStatement ps=con.prepareStatement(
                "UPDATE employee SET name=?,department=?,salary=? WHERE id=?");

            ps.setString(1,name);
            ps.setString(2,dept);
            ps.setDouble(3,Double.parseDouble(salary));
            ps.setInt(4,Integer.parseInt(id));

            int rows=ps.executeUpdate();

            if(rows>0){
                message="Employee updated successfully!";
            }
            else{
                message="No employee found with ID "+id+".";
            }

            ps.close();
        }
        else{
            message="Enter the employee ID, name, department and salary.";
        }
    }

    if("delete".equals(action)){
        if(id!=null && !id.trim().isEmpty()){

            PreparedStatement ps=con.prepareStatement(
                "DELETE FROM employee WHERE id=?");

            ps.setInt(1,Integer.parseInt(id));

            int rows=ps.executeUpdate();

            if(rows>0){
                message="Employee deleted successfully!";
            }
            else{
                message="No employee found with ID "+id+".";
            }

            ps.close();
        }
        else{
            message="Enter the employee ID to delete.";
        }
    }
%>

<html>
<head>
    <title>Employee Management</title>
</head>
<body>

<h2>Employee Management System</h2>

<p><b><%=message%></b></p>

<form method="post">
    Employee ID (for update/delete):
    <input type="number" name="id"><br><br>

    Name:
    <input type="text" name="name"><br><br>

    Department:
    <input type="text" name="department"><br><br>

    Salary:
    <input type="number" step="0.01" name="salary"><br><br>

    <button type="submit" name="action" value="add">Add</button>
    <button type="submit" name="action" value="update">Update</button>
    <button type="submit" name="action" value="delete">Delete</button>
</form>

<h3>Employee Details</h3>

<table border="1" cellpadding="8">
<tr>
    <th>ID</th>
    <th>Name</th>
    <th>Department</th>
    <th>Salary</th>
</tr>

<%
    Statement st=con.createStatement();
    ResultSet rs=st.executeQuery("SELECT * FROM employee");

    while(rs.next()){
%>
<tr>
    <td><%=rs.getInt("id")%></td>
    <td><%=rs.getString("name")%></td>
    <td><%=rs.getString("department")%></td>
    <td><%=rs.getDouble("salary")%></td>
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
