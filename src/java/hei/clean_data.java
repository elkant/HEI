/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import db.dbConn;
import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author GNyabuto
 */
public class clean_data extends HttpServlet {
HttpSession session;
int id,birth_year,indicator_id;
String month,reportingyearmonth;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        session = request.getSession();
        dbConn conn = new dbConn();
        
        String get_bad_data = "SELECT * FROM results WHERE reportingyearmonth>201809";
        conn.rs = conn.st.executeQuery(get_bad_data);
        while(conn.rs.next()){
         month = conn.rs.getString("month");
         id = conn.rs.getInt("result_id");
         birth_year = conn.rs.getInt("birth_year");
         indicator_id = conn.rs.getInt("indicator_id");
         reportingyearmonth = conn.rs.getString("reportingyearmonth");
         
         month = getmonths(month);
 
         
         if(indicator_id<16){
             if(getyear(""+reportingyearmonth)-birth_year>1){
            reportingyearmonth=(birth_year+1)+""+month;     
             }
             else{
           birth_year-=1;  
           reportingyearmonth=(birth_year+1)+""+month;
           }
         }
         
         else{
         birth_year-=2;  
        reportingyearmonth=(birth_year+2)+""+month;
         }
         
        
         String update_record = "UPDATE results SET birth_year='"+birth_year+"', reportingyearmonth='"+reportingyearmonth+"' WHERE result_id='"+id+"'";
         conn.st1.executeUpdate(update_record);
         
        }
        
        
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
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
        Logger.getLogger(clean_data.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
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
        Logger.getLogger(clean_data.class.getName()).log(Level.SEVERE, null, ex);
    }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    
    private String getmonths(String monthname){
        String month="";
        if(monthname.equalsIgnoreCase("January")){month="01";}
        else if(monthname.equalsIgnoreCase("February")){month="02";}
        else if(monthname.equalsIgnoreCase("March")){month="03";}
        else if(monthname.equalsIgnoreCase("April")){month="04";}
        else if(monthname.equalsIgnoreCase("May")){month="05";}
        else if(monthname.equalsIgnoreCase("June")){month="06";}
        else if(monthname.equalsIgnoreCase("July")){month="07";}
        else if(monthname.equalsIgnoreCase("August")){month="08";}
        else if(monthname.equalsIgnoreCase("September")){month="09";}
        else if(monthname.equalsIgnoreCase("October")){month="10";}
        else if(monthname.equalsIgnoreCase("November")){month="11";}
        else if(monthname.equalsIgnoreCase("December")){month="12";}
        else{month="00";}
        
        return month;
        
    }
    
    private int getyear(String yearmonth){
        return  Integer.parseInt(yearmonth.substring(0,4));
    }
}
