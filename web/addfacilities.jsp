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
        <title>add facilities</title>
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


     function filter_districts(district){

                var dist=district.value;    

                // window.open("districtchooser?county="+dist.value);     
                var xmlhttp;    
                if (dist=="")
                {
                    //filter the districts    



                    document.getElementById("district").innerHTML="<option value=\"\">choose district</option>";
                    return;
                }
                if (window.XMLHttpRequest)
                {// code for IE7+, Firefox, Chrome, Opera, Safari
                    xmlhttp=new XMLHttpRequest();
                }
                else
                {// code for IE6, IE5
                    xmlhttp=new ActiveXObject("Microsoft.XMLHTTP");
                }
                xmlhttp.onreadystatechange=function()
                {
                    if (xmlhttp.readyState==4 && xmlhttp.status==200)
                    {
                        document.getElementById("district").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("POST","load_district_idname?county_id="+dist,true);
                xmlhttp.send();
                
                    document.getElementById("district").innerHTML="<option value=\"\">loading districts...</option>";
                
            }//end of filter districts




            function numbers(evt){
                var charCode=(evt.which) ? evt.which : event.keyCode
                if(charCode > 31 && (charCode < 48 || charCode>57)){
                    return false;
                }

                else{
 


 
                    return true;
                }
            }
            



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
           
           
           <h3 style="background-color: #ffcc00; text-align: center;">Adding Facility</h3>
           

           <form action="createfacils" method="POST" style="margin-left: 300px;width:700px;" cellpadding="4px" cellspacing="4px">
               
               
                                     <table  style="margin-left: 200px;">
                                             <tr>
                                                <td class="align_button_right">County<font color="red">*</font></td>
                                                <td>
                                                    <Select id="county" class="textbox6" onchange="filter_districts(this);"   name="county" >

                                                        <option value="">Choose County</option>  
                                                        <option value="4">Baringo</option>
                                                        <option value="5">Kajiado</option>      
                                                        <option value="2">Laikipia</option>
                                                        <option value="1">Nakuru</option>
                                                        <option value="3">Narok</option>

                                                    </select></td>


                                                     </tr>   

                                            <tr>  
                                                <td class="align_button_right">District<font color="red">*</font></td>
                                                <td><Select id="district" class="textbox6"   onchange="filter_facil(this);" name="district" >

                                                        <option value="">Choose District</option>  
                                                    </select></td>
                                            </tr>       
<!--           <tr><td>Facility Name</td><td><input type="text" name="facilityname" id="facilityname" /></td></tr>        
           <tr><td>MFL Code:</td><td><input type="text" name="mflcode" id="facilityname" /></td></tr>        -->

<tr><td>Number of facilities:</td><td><input type="text" required name="number" onkeypress="return numbers(event);" id="number" /></td></tr>    

           <tr><td></td><td><input type="submit" style="width:120px;height:35px;" value="Next"  /></td></tr>        
                   
               </table></form>
               
           

            

            <div id="footer">
                           <%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);  


%>
 
 
            </div>
        </div>
    </body>
    
    
</html>
