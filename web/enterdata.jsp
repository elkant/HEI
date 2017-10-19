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
        <title>Data Entry</title>
        <link rel="stylesheet" type="text/css" href="css/Main.css"/>
        <link rel="shortcut icon" href="images/icon.png"/>


        <%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
            response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
            response.setHeader("Pragma", "no-cache"); //HTTP 1.0
            response.setDateHeader("Expires", 0); //prevents caching at the proxy server

            if (session.getAttribute("level") == null) {
                response.sendRedirect("index.jsp");
            }
        %>

<link rel="stylesheet" href="css/select2.min.css">

        <!--clerk menu css-->
        <link rel="stylesheet" href="menu/clerkmenu_files/css3menu1/style.css" type="text/css" media="all"/>

        <!--    WIZARD CSS-->
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>
        <script type="text/javascript" src="js/noty/jquery.noty.js"></script>
        <script type="text/javascript" src="js/noty/layouts/top.js"></script>
        <script type="text/javascript" src="js/noty/layouts/center.js"></script> 
        <script type="text/javascript" src="js/noty/themes/default.js"></script>
        <link href="styles/demo_style.css" rel="stylesheet" type="text/css"/>
        <link href="style/smart_wizard_vertical.css" rel="stylesheet" type="text/css">
        <script type="text/javascript" src="js/jquery-2.0.0.min.js"></script>
        <script type="text/javascript" src="js/jquery.smartWizard.js"></script>        
              <script src="js/select2.min.js"></script>
        <script type="text/javascript">
    
    
            //      $(document).ready(function(){
            //    	// Smart Wizard	
            //  		
            //    
            //		});
    
        </script>

        
                       
    <!-- ANIMATE HELP    -->
   <link rel="stylesheet" href="themes/base/jquery.ui.all.css">
<!--	<script src="js/jquery-1.9.1.js"></script>-->
	<script src="ui/jquery.ui.core.js"></script>
	<script src="ui/jquery.ui.widget.js"></script>
	<script src="ui/jquery.ui.mouse.js"></script>
	<script src="ui/jquery.ui.draggable.js"></script>
	<script src="ui/jquery.ui.position.js"></script>
	<script src="ui/jquery.ui.resizable.js"></script>
	<script src="ui/jquery.ui.button.js"></script>
	<script src="ui/jquery.ui.dialog.js"></script>
	<script src="ui/jquery.ui.effect.js"></script>
	<script src="ui/jquery.ui.effect-blind.js"></script>
	<script src="ui/jquery.ui.effect-explode.js"></script>
	<link rel="stylesheet" href="ui-essentials/demos.css">
                <script>
	$(function() {
		$( "#dialog" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#opener" ).click(function() {
			$( "#dialog" ).dialog( "open" );
                        
       
                        
		});
                
                
                  //=======DIALOG2=============================
     $( "#dialog2" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#page2" ).click(function() {
			$( "#dialog2" ).dialog( "open" );
		});                   
                    
                
                
                //=====================DIALOG 3======
                
                  //=======DIALOG3=============================
     $( "#dialog3" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#page3" ).click(function() {
			$( "#dialog3" ).dialog( "open" );
		});                   
                
                
                
                
                  //=======DIALOG4=============================
     $( "#dialog4" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#page4" ).click(function() {
			$( "#dialog4" ).dialog( "open" );
		});                   
                    
              
              
                //=======DIALOG5=============================
     $( "#dialog5" ).dialog({
			autoOpen: false,
			show: {
				effect: "blind",
				duration: 500
			},
			hide: {
				effect: "explode",
				duration: 700
			}
		});

		$( "#page5" ).click(function() {
			$( "#dialog5" ).dialog( "open" );
		});                   
                    
              
                
	});
	</script>                
                  
        
        
        
        <!--===========================GET VALIDATOR==========================--->
        <script type="text/javascript" src="js/validateVerticalSteps.js"></script>
        <!--calculate totals-->
        <script type="text/javascript" src="js/AutoFill.js"></script>








        <!--+++++++++++++++++++++++++++MY CUSTOM CALENDER+++++++++++++++++++++++++++++++++++++++--->
        <link rel="stylesheet" type="text/css" href="js/codebase/dhtmlxcalendar.css"/>
        <link rel="stylesheet" type="text/css" href="js/codebase/skins/dhtmlxcalendar_dhx_skyblue.css">
        <script src="js/codebase/dhtmlxcalendar.js"></script>
        <!--==================================================================-->






        <!--tooltip and calender-->
        <link href="js/css/south-street/jquery-ui-1.10.3.custom.css" rel="stylesheet"/>
        <script src="js/js/jquery-ui-1.10.3.custom.js"></script>
        <link rel="stylesheet" href="js/demos.css" />





        <script type="text/javascript">
   
   
   
            
   
   
            //========================LOAD COUNTIES====================

            function getcounties(){

    

                // window.open("districtchooser?county="+dist.value);     
                var xmlhttp;    
                if (dist=="")
                {
                    //filter the districts    



                    document.getElementById("county").innerHTML="<option value=\"\">loading counties..</option>";
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
                        document.getElementById("county").innerHTML=xmlhttp.responseText;
                    }
                }
                xmlhttp.open("POST","getcounty",true);
                xmlhttp.send();
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




            function filter_facil(district){

                var dist=district.value;    

                // window.open("districtchooser?county="+dist.value);     
                var xmlhttp;    
                if (dist=="")
                {
                    //filter the districts    



                    document.getElementById("facility").innerHTML="<option value=\"\">choose district first</option>";
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
                        document.getElementById("facility").innerHTML=xmlhttp.responseText;
                        $('#facility').select2(); 
                    }
                }
                xmlhttp.open("POST","loadfacils?dist="+dist,true);
                xmlhttp.send();

                document.getElementById("facility").innerHTML="<option value=\"\" style=\"color:green;\">loading facilities..</option>";

            }//end of filter districts


            //=========================================================LOAD MONTHS===================================

            function getmonths(yr){

            var year=yr.value;
            var facil=document.getElementById("facility").value;
            
                // window.open("districtchooser?county="+dist.value);     
                var xmlhttp;    
            
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
                        document.getElementById("month").innerHTML=xmlhttp.responseText;
                       
                    }
                }
                xmlhttp.open("POST","loadmonths?yr="+year+"&facil="+facil,true);
                xmlhttp.send();
                 document.getElementById("month").innerHTML="loading months..";
            }
            
            function facilitymilf(facil){
                var dist=facil.value;
                
                $.ajax({  
                    url:"loadmflcodes?facil="+dist,  
                    type:'post',  
                    dataType: 'html',  
                    success: function(data) {
                        
                        document.getElementById("site").value=data;
                        
                        
                    }}); 
                
                
            }
            
            
            
            
            function display_chosen_values(){
    
   
                document.getElementById("mnth").innerHTML="Birth:"+document.getElementById("month").value+"/_"+document.getElementById("year").value;
                document.getElementById("rev1").innerHTML="1st Review "+document.getElementById("month").value+"/_"+document.getElementById("year").value;
                document.getElementById("rev2").innerHTML="2nd Review "+document.getElementById("month").value+"/_"+document.getElementById("year").value;
    
            }


            //=============================================CALCULATE PERCENTAGES==================================

            function calculatepercent(suffix){
                if(document.getElementById("num_"+suffix).value!="" && document.getElementById("den_"+suffix).value!=""){ 
                    var num=parseInt(document.getElementById("num_"+suffix).value);
 
                    var den=parseInt(document.getElementById("den_"+suffix).value);
                    var perc=0;
                     if(den>0 && num>0){
                        var perc=((num/den)*100);
                    }
 
                    //perc=Math.p
 
                    document.getElementById("percent_"+suffix).value=Math.round(parseInt(perc));   
                    //compare entry and target
 
                    var target=document.getElementById("target_"+suffix).value;
 
 
                    if(parseInt(perc)>=parseInt(target)&&target!=""){
     
                        document.getElementById("targetmet_"+suffix).value="Y"; 
     
                    }
                    else if(parseInt(perc)<parseInt(target)&&target!=""){
     
                        document.getElementById("targetmet_"+suffix).value="N";
     
                    }
                        
                    if((suffix>=11 && suffix<=15) || suffix==1){
                        if(suffix==1){
                             fillA();
                        }
                        var d_11=0,d_12=0,d_13=0,d_14=0,d_15=0;
                        var A=parseInt(document.getElementById("den_1").value);
                        if(document.getElementById("num_11").value!=""){d_11=document.getElementById("num_11").value; }   
                        if(document.getElementById("num_12").value!=""){d_12=document.getElementById("num_12").value; }   
                        if(document.getElementById("num_13").value!=""){d_13=document.getElementById("num_13").value; }   
                        if(document.getElementById("num_14").value!=""){d_14=document.getElementById("num_14").value;}    
                        if(document.getElementById("num_15").value!=""){d_15=document.getElementById("num_15").value;}    

                        var sum=parseInt(d_11)+parseInt(d_12)+parseInt(d_13)+parseInt(d_14)+parseInt(d_15);
                        var message="";
                        if(sum!=A){
                         message="0" ;  
                        }
                        else{
                          message="1" ;     
                        }
                        document.getElementById("qc1").value=message;
                    }
                    
                    if(suffix==1 || suffix==20 || (suffix>=21 && suffix<=26)){
                        if(suffix==1){
                             fillA();
                        }
                        if(suffix==20){
                             fillE();
                        }
                        var d_21=0,d_22=0,d_23=0,d_24=0,d_25=0,d_26=0;
                        var F=parseInt(document.getElementById("den_21").value);
                    if(document.getElementById("num_21").value!=""){d_21=document.getElementById("num_21").value; }   
                    if(document.getElementById("num_22").value!=""){d_22=document.getElementById("num_22").value; }   
                    if(document.getElementById("num_23").value!=""){d_23=document.getElementById("num_23").value; }   
                    if(document.getElementById("num_24").value!=""){d_24=document.getElementById("num_24").value;}    
                    if(document.getElementById("num_25").value!=""){d_25=document.getElementById("num_25").value;}    
                    if(document.getElementById("num_26").value!=""){d_26=document.getElementById("num_26").value;}    
                    
                    var sum=parseInt(d_21)+parseInt(d_22)+parseInt(d_23)+parseInt(d_24)+parseInt(d_25)+parseInt(d_26);
                    var message="";
                    
                    if(sum!=F){
                     message="0" ;  
                    }
                    else{
                      message="1" ;     
                    }
                    document.getElementById("qc2").value=message;
                    }
                    
                    if(suffix==21 || suffix==20){
                    autost(23);
                }
                }
    
    
            }


            function autost(suffix){
                if(document.getElementById("num_"+suffix).value!=""&&document.getElementById("den_"+suffix).value!=""){ 
                    var num=parseInt(document.getElementById("num_"+suffix).value);
 
                    var den=parseInt(document.getElementById("den_"+suffix).value);
                    var perc=0;
                    if(den>0 && num>0){
                        var perc=((num/den)*100);
                    }
 
 
                    //perc=Math.p
 
                    document.getElementById("percent_"+suffix).value=Math.round(parseInt(perc));   
                    //compare entry and target
 
                    var target=document.getElementById("target_"+suffix).value;
 
 
                    if(parseInt(perc)>=parseInt(target)&&target!=""){
     
                        document.getElementById("targetmet_"+suffix).value="Y"; 
     
                    }
                    else if(parseInt(perc)<parseInt(target)&&target!=""){
     
                        document.getElementById("targetmet_"+suffix).value="N";
     
                    }
 
 
 
                    //alert(perc);
                }
    
    
            }


            function numbers(evt){
                var charCode=(evt.which) ? evt.which : event.keyCode
                if(charCode > 31 && (charCode < 48 || charCode>57)){
                    return false;
                }

                else{
 


 
                    return true;
                }
            }
            
            
            
            //=================load existing data============
            
            
            function load_saved_data(){
                
                
                var facil=document.getElementById("facility").value;
                  
                var yr=document.getElementById("year").value;
                  
                var month=document.getElementById("month").value;
//                 
//                alert("year : "+yr+" month : "+month+" facil : "+facil);
                if(facil !="" && yr!="" && month !=""){  
                
                    $.ajax({  
                        url:"load_saved_data?facil="+facil+"&year="+yr+"&month="+month,  
                        type:'post',  
                        dataType: 'json',  
                        success: function(data) {
                    
                            document.getElementById("step2").innerHTML=data.step2;
                            document.getElementById("step3").innerHTML=data.step3;
                            document.getElementById("step4").innerHTML=data.step4;
                            document.getElementById("step5").innerHTML=data.step5;
                            display_chosen_values();   
                        
                        }}); 
                
                }//end of if
                
               
                
            }
            
            

        </script>



        <!-----------------------JNOTY MESSAGE---------------------------->    
        <%
              if (session.getAttribute("saved_data")!= null)  { %>
        <script type="text/javascript"> 
                    
                                var n = noty({text:session.getAttribute("saved_data").toString(),
                                    layout: 'center',
                                    type: 'Success',
                                    timeout: 1800});
                    
        </script> <%

session.removeAttribute("saved_data");
 }

        %>  

        <script type="text/javascript"> 
                    
                                var n = noty({text:'saved data successfully.',
                                    layout: 'center',
                                    type: 'Success',
                                    timeout: 1800});
                    
        </script>
        
        <style>
         .button {
    background-color: #f44336; /* Green */
    border: none;
    color: white;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    display: inline-block;
    font-size: 16px;
    border-radius: 8px;
}  
.button:hover {
    background-color: #4CAF50; /* Green */
    color: white;
}
            </style>
    </head>    







    <!-- Body page -->



    <body >

        <div id="container" style="height:95vh ;width:100%;">



            <div id="header" style="width:98%; margin-left: 25px;">
                <!--=========================================menu=========================================-->     
                <h2 style="text-align: center;">
                    <%
                        if (session.getAttribute("level") != null) {

                            if (session.getAttribute("level").equals("1")) {%>
                    <%@include file="menu/adminmenu.jsp" %>
                    <%} else {%>

                    <%@include file="menu/clerkmenu.jsp" %>

                    <%}

                    } else {%>

                    <%@include file="menu/clerkmenu.jsp" %>

                    <%}%>

                </h2>
                <!--=====================================================================================--> 
        
      <h4 style="text-align: center;background-color:#ffcc00 ;">Enter/Edit Data</h4>
            </div>



            <div id="content" style="width:98%;border-top-color:#ffcc00; margin-left: 25px;border-top-style: dotted;height:80vh;">
                <br/>
                <!------------------------------------------------CONTENT DIV------------------------------------------------------------->                

                <form action="savedata" name="myform" method="POST" style="width:98% ;padding-left:1px;height:77vh;">

                    <table align="center" border="0" cellpadding="0" cellspacing="0" style="width:98%;height:76.5vh;">
                        <tr><td style="width:98%;"> 

                                <!-- Tabs -->
                                <div id="wizard" class="swMain" style="width:98%;height:74.5vh">
                                    <ul>
                                        <!------------------------------------------------Filter Page------------------------------------------------------------->                

                                        <li><a href="#step-1" >
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
                                    <div id="step-1" style="width:99%;">	
                                        <h2 class="StepTitle"> <p>Tool Cover page   <img src="images/blguide.png" id="opener" title="Click Here to view Help For this section." alt=" Help Image " style=" width: 20px; ">   </p> <span id="msg" style="color:red;"> </span>  
                                          <div id="dialog" title="Form wizard Help." style=" font-size: 17px;">
Select the following:<br/> <b>(1)County</b><br/> <b>(2)District</b><br/><b>(3)Health Facility</b><i>(which auto fills the site MFL Code</i>),<br/><b>(4)Cohort Birth Year</b> and <br/><b>(5) Birth Month</b>.<br/> 

NB:If the month you wish to enter data for is shown with two astericks i.e. **, it means some data for that month and year has been entered already.<br/><img src="images/asterick.png">
                                              
                                          </div>
                                        </h2>
                                        <ul type="disk">

                                        </ul>








                                        <table align="center" cellpadding="4px" cellspacing="6px">


                                            <!--                       <tr>
                                            <td class="align_button_right">province<font color="red">*</font></td>
                                            <td>
                                                <Select id="prov" class="textbox6"   required ="true" name="province" >
                                            
                                            
                                            <option value="1">Rift Valley</option>
                                            
                                            
                                            </select></td>
                                            
                                            
                                            </tr>  -->


                                            <tr>
                                                <td class="align_button_right">County<font color="red">*</font></td>
                                                <td>
                                                    <Select id="county" class="textbox6" style="min-width: 400px; width:100%" onchange="filter_districts(this);"   name="county" >

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
                                                <td><Select id="district" class="textbox6" style="min-width: 400px; width:100%"  onchange="filter_facil(this);" name="district" >

                                                        <option value="">Choose District</option>  
                                                    </select></td>
                                            </tr>

                                            <tr>  
                                                <td class="align_button_right">Facility Name<font color="red">*</font></td>
                                                <td><Select id="facility" class="textbox6" style="min-width: 400px; width:100%"   onchange="facilitymilf(this);" name="facility" >

                                                        <option value="">Choose Facility</option>  
                                                    </select></td>
                                                <td>Site MFL Code</td><td><input type="text" id="site" name="site" style="background: #cccccc;" readonly /></td>


                                            </tr>

                                            <tr> 

                                                <td class="align_button_right">Cohort Birth Year<font color="red">*</font></td>
                                                <td><Select id="year" class="textbox6" style="min-width: 400px; width:100%" onchange="getmonths(this);load_saved_data();"   name="year" >

                                                        <option value="">Choose  Year</option>  

                                                    </select></td></tr>



                                            <tr>  
                                                <td class="align_button_right">Birth Month<font color="red">*</font></td>
                                                <td>
                                                    <Select id="month" style="min-width: 400px; width:100%" class="textbox6" name="month" >

                                                        <option value="">Choose  Month</option>  
                                                    </select></td></tr>
                                            <tr>  
                                                <td colspan="2">
                                                      
                                                </td>
                                            </tr>
                                        </table>




                                    </div>










                                    <!-------------------------------1st review ----------------------------------------->        


                                    <div id="step-2" style="width:99%;">
                                        <h2 class="StepTitle"><p>1st Review : Cohort birth month + 12 Months  <img src="images/blguide.png" id="page2" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 20px; "> <b style="margin-left:50px; font-size: 20px;" id="cohort_12"></b>
                                         <b style="margin-left: 50px;">
                                            <button onclick="return fillZeros();" class="button" style="text-align: center;">Fill with Zeros</button>     
                                       </b></p> </h2>
                                   <div id="dialog2" title="Form wizard Help." style=" font-size: 17px;">  
                                       In this section, enter data for columns <b>Num</b> and <b>Den</b> only.The <b>%</b> and <b>Target Met </b> Columns will be auto filled based on the set Target and achieved percentage. NB:The percentage value is rounded off to the nearest whole number.  
                                       
                                          </div>
<!--                                        <div>
                                            <button onclick="submitZeroReport();" class="textbox" style="text-align: right; background-color: #a03a38; width: 180px; color: white;"> Submit Zero Report </button>     
                                       </div>-->

                                        <table  border="1" cellpadding="1px" style="width: 99%;"  id="step2">



                                        </table>
                                    </div>


                                    <!---------------------------------------END OF PREVIOUS PREGNANCY------------------------------------------------->


                                    <div id="step-3" style="width:99%;">
                                        <h2 class="StepTitle"><p>Outcomes for Birth Cohort at 9 Months   <img src="images/blguide.png" id="page3" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 20px; "> <b style="margin-left: 100px;">
                                            <button onclick="return fillZeros();" class="button" style="text-align: center;">Fill with Zeros</button>     
                                       </b></p> </h2>
  <div id="dialog3" title="Form wizard Help." style=" font-size: 17px;">  
                                       In this section, enter data for columns <b>Num</b> and <b>Den</b> only.The <b>%</b> and <b>Target Met </b> Columns will be auto filled based on the set Target and achieved percentage. NB:The percentage value is rounded off to the nearest whole number.  
                                       
                                          </div>


                                        <table  border="1" style="width: 99%;" id="step3">

                                        </table>
                                        <div>
                                            <b style="">  <input type="hidden" id="qc1" value="0"/> </b>
                                        </div>
                                    </div>



                                    <!--------------------------------------------end of previous pregnancy--------------------------------------------------------> 


                                    <!--+++++++++++++++++++++++++++++++++++++++PREVENT  SERVICES--------------------------------------------------->       
                                    <div id="step-4" style="width:99%;">
                                        <h2 class="StepTitle"><p>2nd Review :Cohort Birth Month + 24 Months   <img src="images/blguide.png" id="page4" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 20px; "> <b style="margin-left:50px; font-size: 20px;" id="cohort_24"></b>
                                                <b style="margin-left: 50px;">
                                            <button onclick="return fillZeros();" class="button" style="text-align: center;">Fill with Zeros</button>     
                                       </b></p>  </h2>	
                                        <!-- ui-dialog -->
                         
                                          <div id="dialog4" title="Form wizard Help." style=" font-size: 17px;">  
                                       In this section, enter data for columns <b>Num</b> and <b>Den</b> only.The <b>%</b> and <b>Target Met </b> Columns will be auto filled based on the set Target and achieved percentage. NB:The percentage value is rounded off to the nearest whole number.  
                                       
                                          </div>
                                        
                                        <table  border="1" style="width: 99%;" id="step4">

                                        </table>
                                    </div>
                                    <!-----------------------------------------end of prevent services------------------->

                                    <div id="step-5" style="width:99%;">
                                        <h2 class="StepTitle"><p>Outcomes for birth Cohort at 18 Months   <img src="images/blguide.png" id="page5" title="Click Here to view Help For this Page." alt=" Help Image " style=" width: 20px; "> 
                                                <b style="margin-left: 100px;">
                                            <button onclick="return fillZeros();" class="button" style="text-align: center;">Fill with Zeros</button>     
                                       </b></p> </h2>

                                <div id="dialog5" title="Form wizard Help." style=" font-size: 17px;">  
                                       In this section, enter data for columns <b>Num</b> and <b>Den</b> only.The <b>%</b> and <b>Target Met </b> Columns will be auto filled based on the set Target and achieved percentage. NB:The percentage value is rounded off to the nearest whole number.  
                                       
                                          </div>

                                        <table  border="1" style="width: 99%;" id="step5">

                                        </table> 

                                        <div>
                                            <b style=""><input type="hidden" id="qc2" value="0" ></b> </b>
                                        </div>
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
        <script>
        $(document).ready(function(){
            //load all facilities
            $.ajax({
        url:'loadfacils',
        type:"post",
        dataType:"html",
        success:function(data){
         $("#facility").html(data);
         $("#facility").select2();
        loadBasicData(); 
         }
    });
     loadYears();          
            
        $("#year").change(function(){
            loadYearSession();
//            load_saved_data();
            
        }) ; 
        $("#month").change(function(){
            var month = $("#month").val();
            var year = $("#year").val();
            if(year!="" && month!=""){
                $("#cohort_12").html(month+", "+(parseInt(year)+1));
                $("#cohort_24").html(month+", "+(parseInt(year)+2));
            }
//            load_saved_data();
        }) ;
       //capture facility change 
        $("#facility").change(function(){
            loadBasicData();
//            load_saved_data();
        });
        
        
        }); 
        
$('body').on('keydown', 'input, select, textarea', function(e) {
    var self = $(this)
      , form = self.parents('form:eq(0)')
      , focusable
      , next
      ;
    if (e.keyCode == 13) {
        focusable = form.find('input').filter(':visible:not([readonly]):enabled');
        next = focusable.eq(focusable.index(this)+1);
        if (next.length) {
            next.focus();
        } else {
            form.submit();
        }
        return false;
    }
});

function loadYearSession(){
          //pass facility id
        var year= $("#year").val();
        $.ajax({
        url:'setYearSession?year='+year,
        type:"post",
        dataType:"html",
        success:function(){            
            loadMonths();
        }
    });   
   }

function loadBasicData(){
          //pass facility id
        var facility_id = $("#facility").val();
        $.ajax({
        url:'load_dist_county?hf_id='+facility_id,
        type:"post",
        dataType:"json",
        success:function(data){
//            alert("called");
         var district = data.district;
         var county = data.county;
         $("#district").html(district);
         $("#county").html(county);
         }
    });   
   }
function loadYears(){
          //pass facility id
        $.ajax({
        url:'loadYears',
        type:"post",
        dataType:"html",
        success:function(data){
          $("#year").html(data);
          $("#year").select2();
         loadMonths();
         }
    });   
   }
   
   function loadDistrict(){
          $.ajax({
        url:'districtchooser',
        type:"post",
        dataType:"html",
        success:function(data){
//          $("#district").html(data);
//         $("#district").select2();
         }
    });  
   }
   
   function loadMonths(){
          $.ajax({
        url:'loadmonths',
        type:"post",
        dataType:"html",
        success:function(data){
          $("#month").html(data);
          $("#month").select2();
         
        
            var month = $("#month").val();
            var year = $("#year").val();
            if(year!="" && month!=""){
            $("#cohort_12").html(month+", "+(parseInt(year)+1));
            $("#cohort_24").html(month+", "+(parseInt(year)+2));
            }
            
//             load_saved_data();
         }
    });  
   }
   
        </script>
        <script>
        function fillZeros(){
            var i=1;
            while(true){
                if($("#num_"+i).length>0){
                $("#num_"+i).val(0);
                $("#den_"+i).val(0);
                $("#percent_"+i).val(0);
                $("#targetmet_"+i).val("Y");
                i++;
            }
            else{
                break;
            }
            }
            $("#qc1").val("1");
            $("#qc2").val("1");
         return false;   
        }    
            
        </script>
            
    </body>


</html>
