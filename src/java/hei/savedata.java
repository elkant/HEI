/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import dashboards.PushDataSet2;
import db.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
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

    String target = "", num = "", den = "", perc = "", targetmet = "", month = "", year = "", county="", indicatorid = "", facility = "", district = "";
    String msg = "",cohort_type,yearmonth;
    HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        session = request.getSession();
        dbConn conn = new dbConn();

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
        cohort_type="";
        yearmonth = "";

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
        if (request.getParameter("cohort_type") != null) {
            cohort_type = request.getParameter("cohort_type");
        }
        
        if (request.getParameter("district") != null) {
            district = request.getParameter("district");
        }
        
        session.setAttribute("cohort_type", cohort_type);
        
        System.out.println("year-- : "+year+"**"+month);
            county = request.getParameter("county");
            
            session.setAttribute("month", month);
            session.setAttribute("year", year);
            session.setAttribute("facility", facility);
            session.setAttribute("district", district);
            session.setAttribute("county", county);
            
            //get month id
            String mn="";
            String mn_id = "SELECT monthid,month FROM months WHERE month ='"+month+"' ";
            conn.rs = conn.st.executeQuery(mn_id);
            if(conn.rs.next()){
                mn = conn.rs.getString(1);
            }
            
            
            
            
          
           if(Integer.parseInt(mn)<10) {
               mn = "0"+mn;
           }
            
            if(cohort_type.equals("1")){
                yearmonth = (Integer.parseInt(year)+1)+""+mn;
            }
            else if(cohort_type.equals("2")){
               yearmonth = (Integer.parseInt(year)+2)+""+mn; 
            }
            else{
              yearmonth = year+""+mn;    
            }
            
            System.out.println("year month "+yearmonth+" initia year :"+year+" initial month "+mn+" month name "+month);
            
        //=====we are assumming that one can save 22 fields at once..

        //%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%VARIABLES RECEIVED IN A LOOP%%%%%%%%%%%%%%%%%%%%%%%%%

        System.out.println("called to save data");
        
        for (int a = 1; a <= 26; a++) {
            System.out.println("looping through : "+a);
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
            System.out.println("output: target met"+request.getParameter("targetmet_" + a));
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
                        String update = "update results set  target='" + target + "' , numerator='" + num + "', denominator='" + den + "' ,percentage='" + perc + "', is_target_met='" + targetmet + "', reportingyearmonth='"+yearmonth+"' where indicator_id='" + indicatorid + "' and  facility_id='" + facility + "' and month='" + month + "' and birth_year='" + year + "' ";

                        System.out.println("update:"+update);

                        conn.st1.executeUpdate(update);

                        msg = "<font color=\"green\"> Data updated succesfully </font>";



                    } //===data does not exist. insert it afresh
                    else {

                        String insert = "insert into results (birth_year,facility_id,indicator_id,numerator,denominator,percentage,is_target_met,district_id,month,target,reportingyearmonth)"
                                + "                  values('" + year + "','" + facility + "','" + indicatorid + "','" + num + "','" + den + "','" + perc + "','" + targetmet + "','" + district + "','" + month + "','" + target + "', '"+yearmonth+"')";
                        System.out.println("insert"+insert);

                        conn.st1.executeUpdate(insert);

                        msg = "<font color=\"green\"> Data Saved succesfully </font>";

                    }

              
                    
                  


                } catch (SQLException ex) {
                    Logger.getLogger(savedata.class.getName()).log(Level.SEVERE, null, ex);
                }


            }

        }//end of forloop
      
        if(cohort_type.equals("2")){
    //dashboard system
    String mfl_code="";
    String getmfl = "SELECT facility_mfl_code AS mfl_code FROM facilities WHERE facility_id='"+facility+"'";
    conn.rs = conn.st.executeQuery(getmfl);
    if(conn.rs.next()){
      mfl_code = conn.rs.getString(1);
    }
    
     PushDataSet2 ds2 = new PushDataSet2();
           
      Map m1 = new HashMap(); 
      m1.put("startyearmonth", yearmonth);
      m1.put("endyearmonth", yearmonth);
      m1.put("mfl_code", mfl_code);
      
       ds2.pmtct_fo(m1);//IPT Module
       
    //dashboards 
            System.out.println("Added dashoards data ----------------------------------------");
        }
        System.out.println("message is:"+msg);
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(savedata.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(savedata.class.getName()).log(Level.SEVERE, null, ex);
        }
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
