<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>


<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Enter Data</title>
        <link rel="stylesheet" type="text/css" href="css/Main.css"/>
         <link rel="shortcut icon" href="images/icon.PNG"/>
         
         
         <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    if (session.getAttribute("level")==null) {
        response.sendRedirect("index.jsp");
    } 
%>
         
         
    
         <!--clerk menu css-->
         <link rel="stylesheet" href="menu/clerkmenu_files/css3menu1/style.css" type="text/css" media="all"/>

<!--    WIZARD CSS-->
<script type="text/javascript" src="js/jquery-1.9.1.js"></script>
<script type="text/javascript" src="js/noty/jquery.noty.js"></script>
<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script> 
<script type="text/javascript" src="js/noty/themes/default.js"></script>


<link href="style/demo_style.css" rel="stylesheet" type="text/css"/>
<link href="style/smart_wizard_vertical.css" rel="stylesheet" type="text/css">
<script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
<script type="text/javascript" src="js/jquery.smartWizard.js"></script>
<script type="text/javascript">
    
    
//      $(document).ready(function(){
//    	// Smart Wizard	
//  		
//    
//		});
    
</script>

<!--===========================GET VALIDATor==========================--->
<script type="text/javascript" src="js/validateVerticalSteps.js"></script>
<script type="text/javascript" src="js/maternalprofilevalidations-em.js"></script>







<!--+++++++++++++++++++++++++++MY CUSTOM CALENDER+++++++++++++++++++++++++++++++++++++++--->
    <link rel="stylesheet" type="text/css" href="js/codebase/dhtmlxcalendar.css"/>
    <link rel="stylesheet" type="text/css" href="js/codebase/skins/dhtmlxcalendar_dhx_skyblue.css">
    <script src="js/codebase/dhtmlxcalendar.js"></script>
<!--==================================================================-->





<script type="text/javascript">

var myCalendar;
function doOnLoad() {
    myCalendar = new dhtmlXCalendarObject(["edd","lmp","dpr11","dpr12","dpr13","dpr14","dpr15","dpr16","dpr21","dpr22","dpr23","dpr24","dpr25","dp1","dp2","dp3","dp4","dp5","del_dp","del_dp1","_dpr11","_dpr12","_dpr13","_dpr14","_dpr15","_dpr21","_dpr22","_dpr23","_dpr24","_dpr25","dw_dp0","dw_dp1","dw_dp2","dw_dp3","dw_dp4","dw_dp5","dw_dp6","dw_dp7","dw_dp8","_dw_dp0","_dw_dp1","_dw_dp2","_dw_dp3","_dw_dp4","_dw_dp5","_dw_dp6","_dw_dp7","_dw_dp8","dnadp1","dnadp2","dnadp3","dna_dp1","dna_dp2","dna_dp3","vit_dp1","vit_dp2","vit_dp3","vit_dp4","vit_dp5","vit_dp6","vit_dp7","vit_dp8","vit_dp9","vit_dp10","vit_dp11"
    ,"_vit_dp1","_vit_dp2","_vit_dp3","_vit_dp4","_vit_dp5","_vit_dp6","_vit_dp7","_vit_dp8","_vit_dp9","_vit_dp10",             "NextVisit","NextVisit1","date1","date2","date3","date4","new_NextVisit1","new_NextVisit2","new_NextVisit3","new_NextVisit4","new_date1","new_date2","new_date3","new_date4","new_date5","new_date6","new_date7","new_date8","Referral_Pap","Referral1",
        "Referral2","Referral3","DateGiven1","DateGiven2","DateGiven3","DateGiven4","New_DateGiven0","New_DateGiven1","New_DateGiven2","New_DateGiven3","New_DateGiven4",
        "VisitBaby1","New_VisitBaby2","VisitMum1","VisitMum2","VisitMum3","New_VisitMum1","New_VisitMum2","New_VisitMum3",
        "CervixDate1","CervixDate2","CervixDate3","New_CervixDate1","New_CervixDate2","New_CervixDate3"]);
   
}

</script>



<!--tooltip and calender-->
 <link href="js/css/south-street/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>
<script src="js/js/jquery-ui-1.10.3.custom.js"></script>
<link rel="stylesheet" href="js/demos.css" />

         



<script type="text/javascript" src="js/motherbabyhelp.js"></script>
 
 
 
<!------dynamic rows javascript------>
<script type="text/javascript" src="js/dynamic_rows.js"></script>

<!---=====================GET PREV PREGNACY DBASE---->

<script type="text/javascript" src="js/getpreviouspregnancies.js"></script>

<!---==============PRESENT SERVICES==============================-->
<script type="text/javascript" src="js/presentPregnancy.js"></script>



<!--==========GET PREVENTIVE SERVICES=====================-->

<script type="text/javascript" src="js/getPreventiveServices.js"></script>

<!--------------GET Delivery Details>-->

<script type="text/javascript" src="js/getDeliveryDetails.js"></script>


<!----moageDeliveryOthers---->


<script type="text/javascript" src="js/manageDeliveryOthers.js"></script>



<!--=====================GETVITAMINDETAILS==========================-->
<script type="text/javascript" src="js/getvitaminADetails.js"></script>

<!--===========================TOGLE GIVEN STATUS====================-->

<script type="text/javascript" src="js/toggleGivenStatus.js"></script>



<!--=====================GETDEWORMINGDETAILS==========================-->
<script type="text/javascript" src="js/getDewormingDetails.js"></script>




<!--===========================GET PCR DNA DETAILS====================-->

<script type="text/javascript" src="js/getPCRDNADetails.js"></script>

<!--===========================MAUREENS JS====================-->

<script type="text/javascript" src="js/Maureensjs.js"></script>





<script type="text/javascript">
   
   
   function getMatDetails(){

        var ancno=document.getElementById("ancno").value;    

// window.open("districtchooser?county="+dist.value);     
var xmlhttp;    
if (ancno=="")
{
//filter the districts    



document.getElementById("allfields").innerHTML="";
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
document.getElementById("allfields").innerHTML=xmlhttp.responseText;

}
}
xmlhttp.open("POST","getMatDetails?ancno="+ancno,true);
xmlhttp.send();

 document.getElementById("allfields").innerHTML="loading..<img src=\"images/loading.gif\" alt=\"please wait\">"
 
 

//call the previous pregnancies method which fills the alredy existing values to the form
getPreviousPregData();
getCurrPregDets();
getPreventiveServices();
getIronFolate();
getDeliveryDetails();
getPostNatalMum();
getPostNatalBaby();
getCervicalTests();
getDewormingDetails();
getvitaminADetails();
getPCRDNADetails();
reseta();
resetPresentPreg();
//doOnLoad();
}//


</script>



<!-----------------------JNOTY MESSAGE---------------------------->    
   <%
                          //  if (session.getAttribute("message")!= null)  { %>
                                <script type="text/javascript"> 
                    
//                    var n = noty({text:'saved',
//                        layout: 'center',
//                        type: 'Success',
//                        timeout: 1800});
                    
                </script> <%
                
                //session.removeAttribute("message");
                           // }

                        %>  
    
 </head>    
    
    
    
    
    
    
    
    <!-- Body page -->
    
       
       
    <body >
        <embed src="sound/error.mp3" autostart="false" width="0" height="0" id="sound1"
               enablejavascript="true"/>
        <div id="container" style="height:670px ;width:1300px;">
            <br/>
          
            
            <div id="header" style="width:1250px; margin-left: 25px;">
                <!--=========================================menu=========================================-->     
            
                     <%
if(session.getAttribute("level")!=null){            

if (session.getAttribute("level").equals("0")) {%>
            <%@include file="menu/adminmenu.html" %>
            <%}
else{%>

 <%@include file="menu/clerkmenu.html" %>

<%}

}

else{ %>
        
             <%@include file="menu/clerkmenu.html" %>
            
           <%}%>
            
            
        <!--=====================================================================================--> 
            </div>

           
<br/>
            <div id="content" style="width:1250px;border-top-color:greenyellow ; margin-left: 25px;border-top-style: dotted;">
                <br/>
<!------------------------------------------------CONTENT DIV------------------------------------------------------------->                

<form action="saveMotherBaby" name="myform" method="POST" style="width:1220px ;padding-left:1px;">

<table align="center" border="0" cellpadding="0" cellspacing="0">
<tr><td> 
      
<!-- Tabs -->
  		<div id="wizard" class="swMain" style="width:1180px;">
  			  			<ul>
<!------------------------------------------------Filter Page------------------------------------------------------------->                

  				<li><a href="#step-1">
                <label class="stepNumber">1</label>
                <span class="stepDesc">
                   Tool Cover:<br />
                   <small>PAGE 1 of 5</small>
                </span>
            </a></li>
 <!------------------------------------------------MEDICAL N SURGICAL HISTORY------------------------------------------------------------->  
  				<li><a href="#step-2">
                <label class="stepNumber">2</label>
                <span class="stepDesc">
                   1St Review: <br />
                   <small>PAGE <font color="blue"> <b>2</b></font> of 5</small>
                </span>
            </a></li>
<!------------------------------------------------PRESENT PREGNANCY------------------------------------------------------------->  
  				<li><a href="#step-3">
                <label class="stepNumber">3</label>
                <span class="stepDesc">
                      10.0 Outcomes at 9 Months<br />
                   <small>PAGE <font color="blue"> <b>3</b></font> of 5</small>
                </span>                   
             </a></li>
<!------------------------------------------------PREVENTIVE SERVICES-------------------------------------------------------------> 
  				<li><a href="#step-4">
                <label class="stepNumber">4</label>
                <span class="stepDesc">
                  2nd Review:<br />
                   <small>PAGE <font color="blue"> <b>4</b></font>  of 5</small>
                </span>                   
            </a></li>
<!------------------------------------------------IRON FOLATE-------------------------------------------------------------> 
  				<li><a href="#step-5">
                <label class="stepNumber">5</label>
                <span class="stepDesc">
                  13.0 Outcomes at 18 Months<br />
                   <small>PAGE <font color="blue"> <b>5</b></font>  of 5</small>
                </span>                   
            </a></li>


  
 
  			</ul>
  			<div id="step-1">	
                            <h2 class="StepTitle">Tool Cover page          </h2>
            <ul type="disk">
  				   
            </ul>
            
                                          
                       
                       
       
             

                            
                <table align="center" cellpadding="4px" cellspacing="6px">
                    
            </table>
            
            
            <table id="allfields" cellpadding="5px" cellspacing="10px" align="center"></table> 
                
            </div>
            
            
            
            
 
        
               
                    
             
                
        <!-------------------------------2 PREVIOUS PREGNANCY DIV----------------------------------------->        
               			
        
  	<div id="step-2">
            <h2 class="StepTitle">1st Review Cohort birth month + 12 Months  </h2>
            
            

            
            

              
                   
              
        
           
            <table  class="viewpdt" style="width: 600px;"></table>
        </div>
        
        
        <!---------------------------------------END OF PREVIOUS PREGNANCY------------------------------------------------->
  	
       
        <div id="step-3">
       <h2 class="StepTitle">Outcomes for Birth Cohort at 9 Months   </h2>
         
             

     
           <table id="currPreg" class="viewpdt" style="margin-left: 120px;margin-bottom: 0px;width:700px;"></table>
          
      
        </div>
       <!--------------------------------------------end of previous pregnancy--------------------------------------------------------> 
        
       
       <!--+++++++++++++++++++++++++++++++++++++++PREVENT  SERVICES--------------------------------------------------->       
         <div id="step-4">
         <h2 class="StepTitle">2nd Review :Cohort Birth Month + 24 Months   </h2>	
                     <!-- ui-dialog -->

         <table border="0px" align="center" class="viewpdt" id="table_prev_pregnancies" style="margin-left: 120px;width: 700px;">
             <!--      Number        -->  
             
               
              
               
               
                   </table>
            
            </div> 
         <!-----------------------------------------end of prevent services------------------->
           
               <div id="step-5">
           <h2 class="StepTitle">Outcomes for birth Cohort at 18 Months  </h2>

  


                    <table id="IronFolate" class="viewpdt" style="width:700px; margin-left: 120px;"></table>
                    
             
             </div>
      
      
      
  		</div>
  		
<!-- End SmartWizard Content -->  		
  		
</td></tr>
</table> 

<!------------------------------------------------------------------------------------------------------------------------>               
          
                </form>  <!--last form-->
            </div>

           

            <div id="footer">
             
            </div>
        </div>
    </body>
    
    
</html>
