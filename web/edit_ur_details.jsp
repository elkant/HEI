<%-- 
    Document   : edit_ur_details
    Created on : Jan 23, 2014, 8:54:54 AM
    Author     : Geofrey Nyabuto
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dbConn"%>
<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/xhtml" xml:lang="en">
<head>
    <title>Edit Your Details</title>
            <link rel="stylesheet" type="text/css" href="css/Main.css"/>
         
        <link rel="stylesheet"  type="text/css" href="menu/adminmenu_files/css3menu1/style.css" />
        <link rel="shortcut icon" href="images/icon.png"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>   
   

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->

<script type="text/javascript" src="js/noty/themes/default.js"></script>

<!--clerk menu-->

<link rel="stylesheet" type="text/css" href="menu/css/clerkmenucss.css"/>
<script type="text/javascript">
           
         
           
           
            function checkPasswords() {
                var password = document.getElementById('password');
                var conf_password = document.getElementById('conf_password');

                if (password.value != conf_password.value) {
                    conf_password.setCustomValidity('Passwords do not match');
                } else {
                    conf_password.setCustomValidity('');
                }}
$(function() {
$( "#datepicker" ).datepicker();
});

            
        </script> 
</head>
<body>
    <div id="container">
  
   <div id="header" align="center" style="" >
                  <br/>
                 
             <%
     if(session.getAttribute("level")!=null){

                        

if(session.getAttribute("level").equals("1")){%> 
            <%@include file="menu/adminmenu.jsp" %> 
                  <%}
else{%>

<%@include file="menu/clerkmenu.jsp" %> 

<%} 
     }
       else{%>
   
       <%@include file="menu/clerkmenu.jsp" %> 
       
       <%
       
       response.sendRedirect("index.jsp");
       }
         
%>
           
                    
                     <br/>
                    
                    
                    
         
    
     <%
     String fname="",mname="",lname="",phone="",usern="";
//     String userid=session.getAttribute("userid").toString();
       String userid="";
     
     if(session.getAttribute("userid")!=null){
       userid=session.getAttribute("userid").toString();
       }
     dbConn conn = new dbConn();
//out.println("useri id  "+userid);
     String select_user_details="SELECT * FROM users WHERE userid='"+userid+"'";
     conn.rs=conn.st.executeQuery(select_user_details);
    if(conn.rs.next()==true){
        fname=conn.rs.getString("fname"); 
//        mname=conn.rs.getString("mname");
        lname=conn.rs.getString("mname");        
         usern=conn.rs.getString("username");
         phone=conn.rs.getString("phonenumber");
//         out.println(fname);
     }
             
conn.st.close();
%>

</div> 
   <%if (session.getAttribute("msg") != null) { %>
  
                                <script type="text/javascript"> 
                    
                    var m = noty({text: '<%=session.getAttribute("msg")%>',
                        layout: 'center',
                        type: 'Success',
                        timeout:'2000'
 
                         });
                    
                </script> <%
                session.removeAttribute("msg");
                            }

                        %>     

            <div id="content" style="width:1200px; margin-left: 10px; ">
<div id="midcontent" style="margin-left:10px ;">

<div style=" position: absolute; left: 450px; width: 600px; background: #ffffff; padding-top:70px;">
<!--    <h3><p align="center">Enter All your details Approriately.</p></h3> -->
    <!--<h5><p align="center">The Fields marked with <font color="red">*</font> are editable fields.</p></h5>-->
    <br><br>
    <form action="save_ur_details" method="POST">
        <input type="hidden" name="userid" value="<%=userid%>">
<table style="margin-left: 30px; font-size: 18px; width: 400px;">
    <tr><td>First Name</td><td><input type="text" name="fname" id="fname" value="<%=fname%>" required></td></tr>
<tr><td> </td><td></td></tr>
<!--<tr><td>Middle Name</td><td><input type="text" name="mname" id="mname" value="<%=mname%>" ></td></tr>
<tr><td> </td><td></td></tr>-->
<tr><td>Last Name</td><td><input type="text" name="lname" id="lname" value="<%=lname%>" required></td></tr>
<tr><td> </td><td></td></tr>
<tr><td>Phone No.</td><td><input type="text" name="phone" id="phone" value="<%=phone%>"></td></tr>
<tr><td> </td><td></td></tr>
<tr><td>Username</td><td><input type="text" name="username" id="username" value="<%=usern%>" required></td></tr>
<tr><td> </td><td></td></tr>
<tr><td>New Password</td><td><input type="password" name="pass" id="password" value="" oninput="checkPasswords()" required></td></tr>
<tr><td></td><td></td></tr>
<tr><td>Confirm Password</td><td><input type="password" name="pass2" id="conf_password" oninput="checkPasswords()" value="" required></td></tr>
<tr><td></td><td></td></tr>
<tr><td></td><td></td></tr>
<tr><td colspan="2"><input type="submit" value="Save" style="margin-left: 130px;height:35px;"></td></tr>
</table>
       
    </form>
</div>        
        
                        
        
        
</div>
</div>
</body>
</html>

