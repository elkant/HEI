<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>




<%@page import="db.dbConn"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home Page</title>
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
    
    <!-- Body page -->
    
       
       
    <body>
        <div id="container" style="height:690px;  ">

            
            <h3 style="text-align: center;"> 
            
           <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("level")!=null){            

if (session.getAttribute("level").equals("1")) {%>
            <%@include file="menu/adminmenu.jsp" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.jsp" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.jsp" %>
            
           <%}%>
            
            
        <!--=====================================================================================-->  
</h3>
           

          

            

            <div id="footer">
                           <%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);  


%>
 
 
            </div>
        </div>
    </body>
    
    
</html>
