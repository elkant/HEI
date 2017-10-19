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
import javax.servlet.http.HttpSession;
import org.json.JSONObject;

/**
 *
 * @author SIXTYFOURBIT
 */
public class load_saved_data extends HttpServlet {
    
    String month = "", year = "", indicatorid = "", facility = "", district = "",county;
    String num,den,allnum,allden,readonly_num,readonly_den;
    HttpSession session;
    String toCallNum,toCallDen;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("called to run the load indicators script");
        try {
            response.setContentType("text/html;charset=UTF-8");
            session = request.getSession();
            dbConn conn = new dbConn();
            
            
            month = request.getParameter("month");
            year = request.getParameter("year");
            facility = request.getParameter("facil");
            district = request.getParameter("district");
            county = request.getParameter("county");
//            
//            session.setAttribute("month", month);
//            session.setAttribute("year", year);
//            session.setAttribute("facility", facility);
//            session.setAttribute("district", district);
//            session.setAttribute("county", county);
            num=den=readonly_num=readonly_den="";
            allnum=allden=",";
            JSONObject jsonobj = new JSONObject();
           
            
            PrintWriter out = response.getWriter();
            
            
            
            String checkexistance = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "'";
            System.out.println(checkexistance);
            
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
                    + "<tr><th style=\"background-color: #cccccc;\"><p>10.0</p></th><th colspan=\"2\" style=\"background-color: #cccccc;\"><p>Outcomes for birth cohort at 18 months </p> </th>"
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
            
            
            allnum=allden=",";
            if (conn.rs_5.next()) {
                //select data from the database...

//        steponedataexists++;
                //load step 2    
                
                int col = 0;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='1' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    col = conn.rs.getInt("indicator_id");
                    System.out.println("indicator id:"+col+" allnum:"+allnum+" all den : "+allden);
                    
                    System.out.println("num:"+allnum+"   den:"+allden);
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step2 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                           
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("percentage") + "\" style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1' readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //=====saved data column 2
                col = 9;


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='2' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                    col = conn.rs.getInt("indicator_id");
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step3 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                 //           + "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                         //   + "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("percentage") + "\" style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }


                //===========step 4
                


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='3' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                    col = conn.rs.getInt("indicator_id");
                    
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step4 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" readonly type=\"text\" value=\"" + conn.rs1.getString("target") + "\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                           // + "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1' value=\"" + conn.rs1.getString("percentage") + "\" style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //==============step 5===============
                


                //select existing data from the database
                
                conn.rs = conn.st.executeQuery("select * from indicators where section ='4'  order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                    col = conn.rs.getInt("indicator_id");
                    
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    String getdata = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + conn.rs.getString("indicator_id") + "'";

                    //=========assuming that we only deal with the data that is in the database and not the onne in the administrator 
                    conn.rs1 = conn.st1.executeQuery(getdata);
                    conn.rs1.next();
                    
                    
                    step5 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" readonly value=\"" + conn.rs1.getString("target") + "\" type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("numerator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" value=\"" + conn.rs1.getString("denominator") + "\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1' value=\"" + conn.rs1.getString("percentage") + "\" style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\" value=\"" + conn.rs1.getString("is_target_met") + "\" style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }
                
                
                
                
                
                
                
            }//end of checking if records for that month exists....
            
            
//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%   NEW DATA  %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%    
            
            else {
                allnum=allden=",";
                System.out.println("Running the else statement here");
                //===============================this is  step 2========================
                int col = 0;
                
                conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='1' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                    col = conn.rs.getInt("indicator_id");
                    System.out.println("indicator : "+col);
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
//                    System.out.println("allnum : "+allnum+" allden : "+allden);
                    
                    step2 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input type=\"hidden\" value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" name=\"num_" + col + "\"  "+toCallNum+" "+readonly_num+" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" name=\"den_" + col + "\" "+toCallDen+" "+readonly_den+" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\" tabindex='-1' style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    if(col==1){
                    System.out.println("allnum: "+allnum+" allden "+allden+" den "+den+" step2 : "+readonly_den);   
                    }
                }

                //==============================This is step 3============================
                
                
                
                     conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='2' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    
                   col = conn.rs.getInt("indicator_id");
                    
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    step3 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\"  style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }



                //==============This is step 4========================
                
                   conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='3' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    col = conn.rs.getInt("indicator_id");
                    
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                    
                    step4 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\"  style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }
                
                    conn.rs = conn.st.executeQuery("select * from indicators join target on indicators.indicator_id=target.indicator_id where section ='4' order by indicators.indicator_id");
                while (conn.rs.next()) {
                    col = conn.rs.getInt("indicator_id");
                    
                    num=den=readonly_num=readonly_den=toCallNum=toCallDen="";
                    if(conn.rs.getString("num")!=null){
                        num=conn.rs.getString("num");
                        
                        if(allnum.contains(","+conn.rs.getString("num")) || allden.contains(","+conn.rs.getString("num"))){
                        readonly_num=" tabindex='-1'readonly style=\"padding:1px; background-color:#FFE4C4\" ";    
                        }
                        else{
                        toCallNum =  calledMethodNum(num)+" required style=\"padding:1px;\"";    
                        }
                        
                        allnum+=","+num;
                    }
                    
                    if(conn.rs.getString("den")!=null){
                        den=conn.rs.getString("den");
                        
                        if((allnum.contains(","+conn.rs.getString("den")) || allden.contains(","+conn.rs.getString("den")))){
                          readonly_den=" tabindex='-1' readonly style=\"padding:1px; background-color:#FFE4C4\" ";  
                        }
                        else{
                            toCallDen =  calledMethodDen(den)+" required style=\"padding:1px;\"";    
                        }
                        
                        allden+=","+den;
                    }
                   
                    System.out.println("last step is here ");
                    step5 += "<tr><td><p>" + conn.rs.getString("serial_no") + "</p></td>"
                            + "<td style=\"width:200px;\"><p>" + conn.rs.getString("indicator_name") + "</p><input type=\"hidden\" value=\"" + conn.rs.getString("indicators.indicator_id") + "\" name=\"indicid_" + col + "\"></td>"
                            + "<input  type=\"hidden\" value=\""+conn.rs.getString("target_value") +"\" readonly type=\"text\" style=\"width:40px;padding:1px;\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" class=\"shortinput\" name=\"target_" + col + "\" id=\"target_" + col + "\">"
                            //+ "<td><p>" + conn.rs.getString("numerator_source") + "</p></td>"
                            //+ "<td><p>" + conn.rs.getString("denominator_source") + "</p></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_num+" "+toCallNum+" name=\"num_" + col + "\" id=\"num_" + col + "\"></td>"
                            + "<td><input type=\"text\" onkeypress=\"return numbers(event);\" onfocusout=\"calculatepercent(" + col + ");\" "+readonly_den+" "+toCallDen+" name=\"den_" + col + "\" id=\"den_" + col + "\"></td>"
                            + "<td><input type=\"text\" tabindex='-1'  style=\"padding:1px;background-color:#FFE4C4\"  tabindex='-1'  readonly name=\"percent_" + col + "\" id=\"percent_" + col + "\"></td>"
                            + "<td><input type=\"hidden\"  style=\"width:40px;padding:1px;background-color:#FFE4C4\" readonly name=\"targetmet_" + col + "\" id=\"targetmet_" + col + "\"></td>"
                            + "</tr>";
                    
                }

                
                System.out.println("entered else");   
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

public String calledMethodNum(String num){
    return "onblur='fill"+num+"();'";
}
public String calledMethodDen(String den){
    return "onblur='fill"+den+"();'";
}

}
