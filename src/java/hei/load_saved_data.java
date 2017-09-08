/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import db.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author SIXTYFOURBIT
 */
public class load_saved_data extends HttpServlet {
    
    String month = "", year = "", indicatorid = "", facility = "", district = "";
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            dbConn conn = new dbConn();
            
            
            month = request.getParameter("month");
            year = request.getParameter("year");
            facility = request.getParameter("facil");
            
            
            JSONObject jsonobj = new JSONObject();
           
            
            
            
            PrintWriter out = response.getWriter();
            
            
            
            String checkexistance = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "'";
            
            
            conn.rs_5 = conn.st_5.executeQuery(checkexistance);
            
            
            String step2 = "", step3 = "", step4 = "", step5 = "";

            //add the basics of the table_____
            
            
            step2 = "<tr><th style=\"background-color: #ffffff;\"></th><th colspan=\"3\" style=\"background-color: #ffffff;\"><p></p></th>"
                    + " <th colspan=\"1\" style=\"background-color: #ffffff;\"><p id=\"mnth\">Birth:/__</p></th></tr>"
                    + "<tr><th style=\"background-color: #cccccc;\">S/N</th>"
                    + "<th style=\"background-color: #cccccc;\">Indicator</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Target</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Numerator (Source)</th>"
                    //+ "<th style=\"background-color: #cccccc ;\">Denominator (Source)</th>"
                    + "<th style=\"background-color: #cccccc;\">Num</th>"
                    + "<th style=\"background-color: #cccccc;\">Den</th>"
                    + "<th style=\"background-color: #cccccc;\">%</th>"
                   // + "<th style=\"background-color: #cccccc;\">Target Met?</th></tr>"
                    + "<tr><th colspan=\"3\" style=\"background-color: #cccccc;\"><p>1st Review: Cohort birth month + 12 months</p></th>"
                    + " <th colspan=\"1\" style=\"background-color: #cccccc;\"><p id=\"mnth\"></th>"
                    + "<th colspan=\"1\" style=\"background-color: #cccccc;\"><p id=\"rev1\">jan:/__</p></th></tr>";
            
            
            step3 = "<tr><th style=\"background-color:#cccccc;\">S/N</th>"
                    + "<th style=\"background-color: #cccccc;\">Indicator</th>"
                   // + "<th style=\"background-color: #cccccc;\">Target</th>"
                   // + "<th style=\"background-color: #cccccc;\">Numerator (Source)</th>"
                   // + "<th style=\"background-color: #cccccc ;\">Denominator (Source)</th>"
                    + "<th style=\"background-color: #cccccc;\">Num</th>"
                    + "<th style=\"background-color: #cccccc;\">Den</th>"
                    + "<th style=\"background-color: #cccccc;\">%</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Target Met?</th></tr>"
                    + "<tr><th style=\"background-color: #cccccc;\"><p>10.0</p></th><th colspan=\"2\" style=\"background-color: #cccccc;\"><p>Outcomes for birth cohort at 18 months</p></th>"
                    + " <th colspan=\"6\" style=\"background-color: #cccccc;\"><p id=\"mnth\"><p>NB: If a child who was identified positive has additional outcomes, such as tested positive and later died, always classify the child as \"identified positive.\" </p></th></tr>";
            
            
            
            step4 = "<tr><th style=\"background-color: #cccccc;\">S/N</th>"
                    + "<th style=\"background-color: #cccccc;\">Indicator</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Target</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Numerator (Source)</th>"
                    //+ "<th style=\"background-color: #cccccc ;\">Denominator (Source)</th>"
                    + "<th style=\"background-color: #cccccc;\">Num</th>"
                    + "<th style=\"background-color: #cccccc;\">Den</th>"
                    + "<th style=\"background-color: #cccccc;\">%</th>"
                   // + "<th style=\"background-color: #cccccc;\">Target Met?</th></tr>"
                    + "<tr><th colspan=\"3\" style=\"background-color: #cccccc;\"><p>2nd Review: Cohort birth month + 24 months</p></th>"
                  //  + " <th colspan=\"2\" style=\"background-color: #cccccc;\"><p id=\"mnth\"></p></th>"
                    + "<th colspan=\"4\" style=\"background-color: #cccccc;\"><p id=\"rev2\">jan:/__</p></th></tr>";
            
            
            step5 = "<tr><th style=\"background-color: #cccccc;\">S/N</th>"
                    + "<th style=\"background-color: #cccccc;\">Indicator</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Target</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Numerator (Source)</th>"
                    //+ "<th style=\"background-color: #cccccc ;\">Denominator (Source)</th>"
                    + "<th style=\"background-color: #cccccc;\">Num</th>"
                    + "<th style=\"background-color: #cccccc;\">Den</th>"
                    + "<th style=\"background-color: #cccccc;\">%</th>"
                    //+ "<th style=\"background-color: #cccccc;\">Target Met?</th></tr>"
                    + "<tr><th style=\"background-color: #cccccc;\"><p>13.0</p></th><th colspan=\"2\" style=\"background-color: #cccccc;\"><p>Outcomes for birth cohort at 18 months</p></th>"
                    + " <th colspan=\"6\" style=\"background-color: #cccccc;\"><p id=\"mnth\"><p>NB: If a child who was identified positive has additional outcomes, such as tested positive and later died, always classify the child as \"identified positive.\" </p></th></tr>";



//    int steponedataexists=0;
            
            
            
            if (conn.rs_5.next()) {
                //select data from the database...

//        steponedataexists++;
                //load step 2    
                
                int col = 0;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='1'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step2 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                           // + "<td ><input readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("percentage") + "\" style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //=====saved data column 2
                col = 9;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='2'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step3 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                 //           + "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                         //   + "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("percentage") + "\" style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }


                //===========step 4
                
                
                col = 14;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='3'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step4 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                           // + "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1' value=\"" + conn.rs1.getString("percentage") + "\" style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //==============step 5===============
                
                
                col = 16;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='4'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step5 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input readonly value=\"" + conn.rs1.getString("target") + "\" type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1' value=\"" + conn.rs1.getString("percentage") + "\" style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }
                
                
                
                
                
                
                
            }//end of checking if records for that month exists....
            
            
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   NEW DATA  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    
            
            else {

                //===============================this is  step 2========================
                int col = 0;
                
                conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='1'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    
                    
                    step2 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\"  style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\"  style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\"  style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }

                //==============================This is step 3============================
                
                
                
                col = 9;
                
                     conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='2'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    
                    
                    step3 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\"  style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\"  style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\"  style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //==============This is step 4========================
                
                col = 14;
                   conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='3'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    
                    
                    step4 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\"  style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\"  style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\"  style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }

                
                
                col = 16;
                
                    conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='4'");
                while (conn.rs.next()) {
                    
                    col++;
                    
                    
                    
                    step5 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            //+ "<td ><input value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\"></td>"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\"  style=\"width:80%; padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\"  style=\"width:80%;padding:1px;\" onkeypress=\"return numbers(event);\" onkeyup=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"width:80%;padding:1px;\" readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            //+ "<td><input type=\"text\"  style=\"width:40px;padding:1px;\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }

                
                
            }//end of else  
            
            
            conn.st.close();
            conn.st1.close();
            
            
            try {
                
                jsonobj.put("step2", step2);
                jsonobj.put("step3", step3);
                jsonobj.put("step4", step4);
                jsonobj.put("step5", step5);
                
                //System.out.println(jsonobj);
                
                out.println(jsonobj);
                
            } finally {                
                out.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(load_saved_data.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
