<%-- 
    Document   : RawData
    Created on : Oct 29, 2018, 8:50:47 AM
    Author     : GNyabuto
--%>


<%@page import="db.dbConn"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Raw Data Report</title>
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

            <div id="content" style="width:98%;border-top-color:#ffcc00; margin-left: 25px;border-top-style: dotted;height:60vh;">
                <br/>
                <!------------------------------------------------CONTENT DIV------------------------------------------------------------->                

                <form action="raw_data" name="myform" method="POST" style="width:70%; margin-left: 14% ;padding-left:1px;height:55vh;">

                                    <div id="step-1" style="width:99%;">	
                                        <h2 class="StepTitle" style="text-align: center;"> <p>Raw Data Report  </p> <span id="msg" style="color:red;"> </span>  
                                        </h2>
                                     <table align="center" cellpadding="4px" cellspacing="6px">
<!--                                            <tr>
                                                <td class="align_button_right">County<font color="red"></font></td>
                                                <td>
                                                    <select id="county" multiple="" class="textbox6" style="min-width: 400px; width:100%"   name="county" >
                                                     </select></td>

                                             </tr>   

                                            <tr>  
                                                <td class="align_button_right">District<font color="red"></font></td>
                                                <td><select id="district" multiple="" class="textbox6" style="min-width: 400px; width:100%"  onchange="filter_facil(this);" name="district" >

                                                        <option value="">Choose District</option>  
                                                    </select></td>
                                            </tr>

                                            <tr>  
                                                <td class="align_button_right">Facility Name<font color="red"></font></td>
                                                <td><select id="facility" class="textbox6" multiple="" style="min-width: 400px; width:100%"   onchange="facilitymilf(this);" name="facility" >

                                                        <option value="">Choose Facility</option>  
                                                    </select></td>
                                              
                                            </tr>-->

                                            <tr><td class="align_button_right">Start of Reporting Period<font color="red">*</font></td>
                                                <td><select name="start_date" id="start_date" required="true" class="" style="min-width: 400px; width:100%" ></select></td></tr>
                                            
                                            <tr><td class="align_button_right">End of Reporting Period<font color="red">*</font></td>
                                                <td><select name="end_date" id="end_date" required="true" class="" style="min-width: 400px; width:100%" ></select></td></tr>
                                            
                                            <tr><td class="align_button_right"></td><td>
                                                    <input type="submit" value="Generate Report" class="" style="min-width: 400px; width:100%; height: 40px; background: plum;" ></td></tr>
                                                
                                        </table>
                                 </div>

                    <!------------------------------------------------------------------------------------------------------------------------>               

                </form>  <!--last form-->
            </div>



            <div id="footer">

            </div>
                                                        
         
        </div>
        <script>
        $(document).ready(function(){
             $("#district").select2();
             $("#county").select2();
             loadstartym();
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
            
        $("#county").change(function(){
            loadDistrict();
            
        }) ;
       //capture facility change 
        $("#facility").change(function(){
            loadBasicData();
            loadMonths();
        });
        
        $("#district").change(function(){
            loadFacilities();
        });
        
        $("#start_date").change(function(){
            loadendym();
        });
        
        
        }); 
        
       function loadstartym(){
        $.ajax({
        url:'startym',
        type:"post",
        dataType:"html",
        success:function(data){
         $("#start_date").html(data);
         $("#start_date").select2();
          }
    });   
   } 
        
        function loadendym(){
            var start_date = $("#start_date").val();
        $.ajax({
        url:'endym?startym='+start_date,
        type:"post",
        dataType:"html",
        success:function(data){
         $("#end_date").html(data);
         $("#end_date").select2();
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
   
   function loadDistrict(){
     var county= $("#county").val();
     county = (""+county).split(",").join("_");
 
          $.ajax({
        url:'load_district?counties='+county,
        type:"post",
        dataType:"html",
        success:function(data){
          $("#district").html(data);
         $("#district").select2();
         }
    });  
   }
   
   
      function loadFacilities(){
     var district= $("#district").val();
     district = (""+district).split(",").join("_");
 
          $.ajax({
        url:'load_facilities?districts='+district,
        type:"post",
        dataType:"html",
        success:function(data){
          $("#facility").html(data);
         $("#distrfacilityict").select2();
         }
    });  
   }
   
   
        </script>  
    </body>


</html>
