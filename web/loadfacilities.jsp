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
        <title>Adding Facilities</title>
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


//validation class


    function validat(){
      
      //alert(document.getElementById("no_of_groups").value);
        var rows=parseInt(document.getElementById("rows").value);
        
        var retvalue=true;
        //  alert("rows"+rows);
        for(var a=1;a<=rows;a++ ){
            
        
             if(avoidblanks(a)==0){
              
                retvalue =false; 
                break; 
             }   
            else{
                
               retvalue = true;
                
            }
            
            
            
        }
        
       return retvalue; 
    }
    
    
    
    function avoidblanks(id){
        
        var facilityname= document.getElementById("facilityname_"+id).value;
        var mflcode=document.getElementById("mflcode_"+id).value;
        var total=0;
        if(facilityname.trim()!=""||mflcode.trim()!=""){
            
        if(facilityname==""){
            
            
            
            alert("enter facility Name");
            document.getElementById("facilityname_"+id).focus();
            return 0; 
        }    
        else if(mflcode==""){
           alert("enter mflcode");   
            document.getElementById("mflcode_"+id).focus();
            return 0;
        }    
        else{
            
            return 1;
        }
        
   
      
        
                  }

    }



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
                xmlhttp.open("POST","districtchooser?county_id="+dist,true);
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
        
          <%if (session.getAttribute("msg") != null) { %>
  
                                <script type="text/javascript"> 
                    
                    var m = noty({text: '<%=session.getAttribute("msg")%>',
                        layout: 'center',
                        type: 'Success'
 
                         });
                    
                </script> <%
                session.removeAttribute("msg");
                            }

                        %>
        
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

            <form action="saveFacility" onsubmit="return validat();" method="POST" style="margin-left: 300px;width:700px;" >
               
               
                                    <table  style="margin-left: 200px;" cellpadding="4px" cellspacing="4px">
                                             <tr>
                                                 <td style="background-color: #cccccc;" colspan="2">District:</td><td colspan="2" style="background-color:#cccccc;"><%=session.getAttribute("districtname")%></td>
                                                     </tr>   

                                                     <%=session.getAttribute("createdfaciltable")%>
                                                     
                                                     <tr><td></td><td><input type="submit" onmouseover="" style="width:120px;height:35px;background-color:;" value="submit"  /></td></tr>        
                   
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
