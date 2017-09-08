<%-- 
    Document   : index
    Created on : Aug 5, 2013, 9:03:18 PM
    Author     : SIXTYFOURBIT
--%>




<%@page import="db.dbConn"%>
<%@page import="java.util.Calendar"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>



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
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add/Edit Target</title>
        <link rel="stylesheet" type="text/css" href="css/Main.css"/>
        <link rel="shortcut icon" href="images/icon.png" style="height: 20px;padding: 0px; margin: 0px;"/>
        <script type="text/javascript" src="js/jquery-1.9.1.js"></script>


        <!--clerk menu css-->
        <link rel="stylesheet" href="menu/clerkmenu_files/css3menu1/style.css" type="text/css" media="all"/>


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
                
                
                 $("#ui-accordion-accordion-header-0").css("background","orange");
                 $("#ui-accordion-accordion-header-1").css("background","orange");
                 $("#ui-accordion-accordion-header-2").css("background","orange");
                 $("#ui-accordion-accordion-header-3").css("background","orange");
                 $("#ui-accordion-accordion-header-4").css("background","orange");
                 $("#ui-accordion-accordion-panel-0").css("height","300px");
                 $("#ui-accordion-accordion-panel-1").css("height","300px");
                 $("#ui-accordion-accordion-panel-2").css("height","300px");
                 $("#ui-accordion-accordion-panel-3").css("height","300px");

            }); 
        </script>
    </head>

    <!-- Body page -->



    <body>
        <div id="container" style="height:96vh;  border-top-width: thick ;">

            <div id="header">
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

            </div>



            <div id="content" style="margin-left: 17%;width:70%;height:84vh;" >



                <%

                    dbConn conn = new dbConn();
                    int col = 0;

                %>

                <form action="savetarget" method="post" style="width:97%;background-color: white;">
                    <table class="viewpdt" width="920px"> <tr><td colspan="3"><input type="submit" value="Save" style="width: 120px;height: 35px; background-color: #ffcc00;"/></td></tr></table>

                    <div id="accordion">
                        
                        
                        <h3>SECTION 1 TARGETS</h3>
                        <div> 
                            <table class="viewpdt" width="920px">

                                <tr><th>S/N</th><th>Indicator</th><th>Target</th></tr>


                                <%





                                    conn.rs = conn.st.executeQuery("select * from indicators where section='1'");

                                    while (conn.rs.next()) {
                                        col++;

                                        conn.rs1 = conn.st1.executeQuery("select * from target where indicator_id='" + conn.rs.getString("indicator_id") + "'");

                                        if (conn.rs1.next()) {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"" + conn.rs1.getString("target_value") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");


                                        } else {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");

                                        }

                                    }
                                %>
                            </table> 
                        </div>
                        <h3>SECTION 2 TARGETS</h3>
                        <div>



                            <table class="viewpdt" width="920px">

                                <tr><th>S/N</th><th>Indicator</th><th>Target</th></tr>


                                <%





                                    conn.rs = conn.st.executeQuery("select * from indicators where section='2'");

                                    while (conn.rs.next()) {
                                        col++;

                                        conn.rs1 = conn.st1.executeQuery("select * from target where indicator_id='" + conn.rs.getString("indicator_id") + "'");

                                        if (conn.rs1.next()) {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"" + conn.rs1.getString("target_value") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");


                                        } else {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");

                                        }

                                    }
                                %>
                            </table> 



                        </div>
                        <h3>SECTION 3 TARGETS</h3>
                        <div>



                            <table class="viewpdt" width="920px">

                                <tr><th>S/N</th><th>Indicator</th><th>Target</th></tr>


                                <%





                                    conn.rs = conn.st.executeQuery("select * from indicators where section='3'");

                                    while (conn.rs.next()) {
                                        col++;

                                        conn.rs1 = conn.st1.executeQuery("select * from target where indicator_id='" + conn.rs.getString("indicator_id") + "'");

                                        if (conn.rs1.next()) {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"" + conn.rs1.getString("target_value") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");


                                        } else {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");

                                        }

                                    }
                                %>
                            </table> 


                        </div>
                        <h3>SECTION 4 TARGETS</h3>
                        <div> 


                            <table class="viewpdt" width="920px">

                                <tr><th>S/N</th><th>Indicator</th><th>Target</th></tr>


                                <%





                                    conn.rs = conn.st.executeQuery("select * from indicators where section='4'");

                                    while (conn.rs.next()) {
                                        col++;

                                        conn.rs1 = conn.st1.executeQuery("select * from target where indicator_id='" + conn.rs.getString("indicator_id") + "'");

                                        if (conn.rs1.next()) {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"" + conn.rs1.getString("target_value") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");


                                        } else {


                                            out.println("<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                                                    + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                                                    + "<td ><input  type=\"text\" value=\"\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>");

                                        }

                                    }
                                %>
                            </table> 




                        </div>
                    </div>


                    <br/>

                    <table class="viewpdt" width="920px">




                        <%



                            conn.st.close();

                            conn.st1.close();


                        %>

                        <tr><td colspan="3"><input type="submit" value="Save" style="width: 120px;height: 35px; background-color: #ffcc00;"/></td></tr>

                    </table>                      

                </form>



            </div>



            <div id="footer">

            </div>
        </div>
    </body>


</html>
