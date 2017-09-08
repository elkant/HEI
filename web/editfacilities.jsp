<%-- 
    Document   : edit_clerk
    Created on : Aug 15, 2013, 11:18:53 AM
    Author     : Nyabuto Geofrey
--%>


<%@page import="db.dbConn"%>
<%@page import="java.util.Calendar"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
//this is code to make sure the browser does not cache the pages
//and once logged out, session invalidated, send to login page
    response.setHeader("Cache-Control", "no-store"); //HTTP 1.1
    response.setHeader("Pragma", "no-cache"); //HTTP 1.0
    response.setDateHeader("Expires", 0); //prevents caching at the proxy server

    if (session.getAttribute("level")!=null) {}
          else {
        response.sendRedirect("index.jsp");
    } 
%>
<!DOCTYPE html>
<html>
    <head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
<link rel="stylesheet" type="text/css" href="css/Main.css"/>
<link rel="shortcut icon" href="images/icon.png"/>

  <script type="text/javascript" src="js/jquery-1.9.1.js"></script>


<!--<script type="text/javascript" src="js/jquery-1.8.3.min.js"></script> -->

<script type="text/javascript" src="js/noty/jquery.noty.js"></script>

<script type="text/javascript" src="js/noty/layouts/top.js"></script>
<script type="text/javascript" src="js/noty/layouts/center.js"></script>
<!-- You can add more layouts if you want -->
<script type="text/javascript" src="js/noty/themes/default.js"></script>

<!--Admin menu-->

<link rel="stylesheet"  type="text/css" href="menu/clerkmenu_files/css3menu1/style.css" />	

  
  <!----datatable--Maureens---->
  
<!--
        <script src="scripts/jquery-1.4.4.min.js" type="text/javascript"></script>-->
        <script src="scripts/jquery.dataTables.min.js" type="text/javascript"></script>
        <script src="scripts/jquery.jeditable.js" type="text/javascript"></script>
        <!--<script src="media/js/jquery-ui.js" type="text/javascript"></script>-->
        <!--   <script src="media/js/jquery.validate.js" type="text/javascript"></script>-->
        <script src="scripts/jquery-ui.js" type="text/javascript"></script>
        <script src="scripts/jquery.dataTables.editable.js" type="text/javascript"></script>
        <script src="scripts/jquery.validate.js" type="text/javascript"></script>
        <link href="media/dataTables/demo_page.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table.css" rel="stylesheet" type="text/css" />
        <link href="media/dataTables/demo_table_jui.css" rel="stylesheet" type="text/css" />
        <link href="media/themes/base/jquery-ui.css" rel="stylesheet" type="text/css" media="all" />
        <link href="media/themes/smoothness/jquery-ui-1.7.2.custom.css" rel="stylesheet" type="text/css" media="all" />
  
  
 <script type="text/javascript">
    
            $(document).ready( function () {
                $('#example').dataTable().makeEditable({
                                  
									
                    sUpdateURL: "editfacil",
                    //                                                                        sAddURL: "AddCounty",
                    sDeleteURL: "deletefacil",
                    "aoColumns": [ null,   

//============
                    									
                        {
                            event: 'mouseover',
                            indicator: 'Saving...',
                            //                                                            					tooltip: 'Click to edit ',
                            type: 'textarea',
                            submit:'Save changes',
                            callback : function(value, settings)
                            { 
                                alert(value);
                                window.location.reload();
                                // settings involing plugin parameters
                                //                                                                                                                        alert('Element Changed : '+value);											
                                //alert(settings.cssclass);
                            },
                            fnOnCellUpdated: function(sStatus, sValue,value, row, column, settings){
                                document.getElementById("msg").innerHTML="(Cell Callback): is updated with value " + sValue;
                            }
                                                                                              
                        },
                        
                        
                        //================
                        
  {
                            event: 'mouseover',
                            indicator: 'Saving...',
                            //                                                            					tooltip: 'Click to edit ',
                            type: 'textarea',
                            submit:'Save changes',
                            callback : function(value, settings)
                            { 
                                alert(value);
                                window.location.reload();
                                // settings involing plugin parameters
                                //                                                                                                                        alert('Element Changed : '+value);											
                                //alert(settings.cssclass);
                            },
                            fnOnCellUpdated: function(sStatus, sValue,value, row, column, settings){
                                document.getElementById("msg").innerHTML="(Cell Callback): is updated with value " + sValue;
                            }
                                                                                              
                        }                    									
                    ]									

                });
				
            } );
            
           
            
        </script>
        <script type="text/javascript">

            var _gaq = _gaq || [];
            _gaq.push(['_setAccount', 'UA-17838786-2']);
            _gaq.push(['_trackPageview']);

//            (function() {
//                var ga = document.createElement('script'); ga.type = 'text/javascript'; ga.async = true;
//                ga.src = ('https:' == document.location.protocol ? 'https://ssl' : 'http://www') + '.google-analytics.com/ga.js';
//                var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
//            })();

        </script>
<!--clerk menu-->



  <link href="js/css/ui-lightness/jquery-ui-1.10.3.custom.css" rel="stylesheet">
<script src="js/jquery-ui-1.10.3.custom.js"></script>
<!--        <script type="text/javascript">
            $(function() {

                

            }); 
        </script>-->

	
<title>Edit Facilities </title>
  
    </head>
<body>

<div id="container" >
    
    
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
       
       <%}
         
%>
           
                    
                     <br/>
                    
                    
                    
              </div>
 <div id="content" style=" margin-left: 120px; width:1100px;">



<h4 style="text-align: center;">Edit Facility</h4>


  <%
                     if (session.getAttribute("faciledited") != null)  { %>
                                <script type="text/javascript"> 
                    
                    var n = noty({text: '<%=session.getAttribute("faciledited")%>',
                        layout: 'center',
                        type: 'Success',
 
                         timeout: 1800});
                    
                </script> <%
                
                session.removeAttribute("faciledited");
                            }

                        %>


<h4> 
          <%
          
         dbConn conn=new dbConn();
  int counter=1;
  
  //===============choose the active chws only==================
  
  String cuid="";
  
 
  
  
  //String editor="select * from chws where active!='2' ";
  String editor="select * from facilities ";
  
  
  
  conn.rs=conn.st.executeQuery(editor);


%>
</h4>


       <div id="demo">
           
           <p id="msg"><p>
<!--                          <button  title="Add chw" value="Ok">Add new chw</button> -->
                        <button id="btnDeleteRow" value="cancel">Delete Facility</button>

                        <table cellpadding="4px" cellspacing="4px" style="padding-top: 100px;" border="0" class="display" id="example">
                            <thead>
                                <tr  >
    <th>No.</th>
  <th>Facility Name</th>   
   <th>Site Mfl Code</th> 
   <th>District</th>
   
     
</tr>
    </thead>
<%
 while(conn.rs.next()){  
%>

  <%String facilid=conn.rs.getString("facility_id");%>


<tr id="<%=facilid%>">
    <td  class="sorting_1"><%=counter++%></td>

  
    <td  class="sorting_1"><%=conn.rs.getString("facility_name")%></td>  
    <td  class="sorting_1"><%=conn.rs.getString("facility_mfl_code")%></td> 
   
    <td  class="sorting_1"><%
    
    conn.rs1=conn.st1.executeQuery("select * from district where district_id='"+conn.rs.getString("district_id")+"'");
    
    
    
    if(conn.rs1.next()){
    out.println(conn.rs1.getString("district_name"));
    
                          }
    
    
            
            %></td>  
    
    
</tr>
    <%}
  conn.st1.close();
conn.st.close();  

%>
</table>

       </div>


<div id="footer">
<%
Calendar cal = Calendar.getInstance();
int year= cal.get(Calendar.YEAR);              

%>
               <p align="center"> &copy HEI Cohort Analysis System Aphia Plus | USAID <%=year%></p>
            </div>
</div>  <!--end of content div-->  
</div> <!--end of container div-->   

</body>
</html>

