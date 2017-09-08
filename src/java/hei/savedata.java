/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import db.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SIXTYFOURBIT
 */
public class savedata extends HttpServlet {

    String target = "", num = "", den = "", perc = "", targetmet = "", month = "", year = "", indicatorid = "", facility = "", district = "";
    String msg = "";
    HttpSession session;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        session = request.getSession();


        target = "";
        num = "0";
        den = "1";
        perc = "0";
        targetmet = "";
        year = "";
        month = "";
        indicatorid = "";
        facility = "";
        msg = "";



        //========year======

        if (request.getParameter("year") != null) {
            year = request.getParameter("year");

        }

        //=========month======  
        if (request.getParameter("month") != null) {
            month = request.getParameter("month");

        }
        //======facility ====

        if (request.getParameter("facility") != null) {
            facility = request.getParameter("facility");
        }

        //=====district=====
        if (request.getParameter("district") != null) {
            district = request.getParameter("district");
        }

        //=====we are assumming that one can save 22 fields at once..

        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%VARIABLES RECEIVED IN A LOOP%%%%%%%%%%%%%%%%%%%%%%%%%
        dbConn conn = new dbConn();


        for (int a = 1; a <= 22; a++) {

            //=====target========    
            if (request.getParameter("target_" + a) != null) {
                target = request.getParameter("target_" + a);
            }

            //===numerator=======
            if (request.getParameter("num_" + a) != null) {
                num = request.getParameter("num_" + a);

            }

            //===denominator=======

            if (request.getParameter("den_" + a) != null) {
                den = request.getParameter("den_" + a);

            }
            //===percent============
            if (request.getParameter("percent_" + a) != null) {
                perc = request.getParameter("percent_" + a);

            }

            //===target met======== 
            if (request.getParameter("targetmet_" + a) != null) {
                try {
                    targetmet = request.getParameter("targetmet_" + a);

                    //====district=========
                    if (request.getParameter("indicid_" + a) != null) {
                        indicatorid = request.getParameter("indicid_" + a);

                        System.out.println("indicator id::"+indicatorid);
                        
                    }

                    //first check if some data exists fro that facility, month and year

                    String checkexistance = "select * from results where facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' and indicator_id='" + indicatorid + "'";
                    conn.rs = conn.st.executeQuery(checkexistance);
                    if (conn.rs.next()) {
                        //=============continue from here tommorow===============
                        String update = "update results set  target='" + target + "' , numerator='" + num + "', denominator='" + den + "' ,percentage='" + perc + "', is_target_met='" + targetmet + "' where indicator_id='" + indicatorid + "' and  facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' ";

                        System.out.println(update);

                        conn.st1.executeUpdate(update);

                        msg = "<font color=\"green\"> Data updated succesfully </font>";



                    } //===data does not exist. insert it afresh
                    else {



                        String insert = "insert into results (result_id,birth_year,facility_id,indicator_id,numerator,denominator,percentage,is_target_met,district_id,month,target)"
                                + "                  values('"+uniqueid().trim()+"','" + year + "','" + facility + "','" + indicatorid + "','" + num + "','" + den + "','" + perc + "','" + targetmet + "','" + district + "','" + month + "','" + target + "')";
                        System.out.println(insert);

                        conn.st1.executeUpdate(insert);

                        msg = "<font color=\"green\"> Data Saved succesfully </font>";

                    }

              
                    
                  


                } catch (SQLException ex) {
                    Logger.getLogger(savedata.class.getName()).log(Level.SEVERE, null, ex);
                }


            }

        }//end of forloop
      //======set session response=====    
                    //session.setAttribute("msg", msg);
          response.sendRedirect("enterdata.jsp");
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


//====================random id functions================================ 

 public String uniqueid() {

        Calendar cal = Calendar.getInstance();

        int year1 = cal.get(Calendar.YEAR);
        int month1 = cal.get(Calendar.MONTH) + 1;
        int date = cal.get(Calendar.DAY_OF_MONTH);
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int min = cal.get(Calendar.MINUTE);
        int sec = cal.get(Calendar.SECOND);
        int milsec=cal.get(Calendar.MILLISECOND);
        
        
        return year1+""+month1+""+date+hour+min+sec+milsec+generateRandomNumber(800, 9000);
    }

 
 
   public int generateRandomNumber(int start, int end ){
        Random random = new Random();
        long fraction = (long) ((end - start + 1 ) * random.nextDouble());
        return ((int)(fraction + start));
    }
 
//==========================================================================
    
    
}
