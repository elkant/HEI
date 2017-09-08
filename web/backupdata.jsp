<%-- 
    Document   : UploadFie
    Created on : Nov 6, 2013, 4:35:53 PM
    Author     : Maureen
--%>


<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>

   <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server
      session = request.getSession();
   
    
    if (session.getAttribute("userid")==null) {
        response.sendRedirect("index.jsp");
    } 
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Data Backup</title>
         <link rel="stylesheet" type="text/css" href="css/Main.css"/>
          <link rel="stylesheet" type="text/css" href="menu/clerkmenu_files/css3menu1/style.css"/>
     
         <link rel="shortcut icon" href="images/cohort_image.png"/>
          <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
          

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>


<!--tooltip-->
  <link href="js/css/start/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>
	
	<script src="js/js/jquery-ui-1.10.3.custom.js"></script>
<link rel="stylesheet" href="js/demos.css" />


<script type="text/javascript">
      $(function() {

$( document ).tooltip();
$( "#accordion" ).accordion();

}); 
</script>
    </head>
    
    <body>
        <div id="container" style="width:1300px;" >
 <br/>
              <div id="header" style="width:1250px; margin-left: 25px;">

                    
                   <!--=========================================menu=========================================-->     
            <%
                if (session.getAttribute("level") != null) {

                    if (session.getAttribute("level").equals("0")) {%>
            <%@include file="menu/adminmenu.jsp" %>
            <%} else {%>

            <%@include file="menu/clerkmenu.jsp" %>

            <%}

            } else {%>

            <%@include file="menu/clerkmenu.jsp" %>

            <%}%>

            <!--=====================================================================================--> 
                    
                    
              </div>
            
             
                         <%if (session.getAttribute("datasend") != null) {
                         
    
    
    %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("datasend")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 4800});
                    
                </script> <%
                session.removeAttribute("datasend");
                            }

                        %>
            
            
            <br/>
            <div id="content" style="width:1020px;">
       
                 
                    <form action="back_up_tables" method="post" style="height:90px;margin-left: 400px;margin-top: 200px;width:400px;">
                        <br/>
                       <input type="submit" value="Create Backup" style="height:60px;" >
                    </form>
              
              
            </div>

            

             <div id="footer">
              <!--  <h2 align="left"> <img src="images/Coat of arms.JPG" alt="logo" height="76px" /></h2>-->
              
               <%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);              

%>
               <p align="center">HEI Cohort Analysis Tool &copy Aphia Plus | USAID <%=year%></p>
            </div>
        </div>    
    </body>
</html>

