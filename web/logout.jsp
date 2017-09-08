<%-- 
    Document   : logout
    Created on : Dec 29, 2013, 8:06:15 PM
    Author     : SIXTYFOURBIT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
         session.invalidate();
            response.sendRedirect("index.jsp");%>
    </body>
</html>
