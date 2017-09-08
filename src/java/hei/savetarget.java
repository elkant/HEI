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

/**
 *
 * @author SIXTYFOURBIT
 */
public class savetarget extends HttpServlet {

   String target_value,indicatorid;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        target_value="";
        indicatorid="";
        String msg="";
        
        dbConn conn= new dbConn();
        for(int a=1;a<=22;a++){
            try {
                if(request.getParameter("target_"+a)!=null){
                target_value=request.getParameter("target_"+a);
                }
            
                if(request.getParameter("indicid_"+a)!=null){
                indicatorid=request.getParameter("indicid_"+a);
                }
                
           conn.rs= conn.st.executeQuery("select * from target where indicator_id='"+indicatorid+"'");
           
           if(conn.rs.next()){
               
               String upd="update target set target_value='"+target_value+"' where indicator_id='"+indicatorid+"'";
               
           conn.st1.executeUpdate(upd);
           msg="data updated";
               
           }
           else{
               
               
               String ins="insert into target(target_id,target_value,indicator_id)values('"+uniqueid().trim()+"','"+target_value+"','"+indicatorid+"')";
            conn.st1.executeUpdate(ins);
          
          System.out.println(ins); 
          
          msg="data updated";
           
           }
           
           
            } catch (SQLException ex) {
                Logger.getLogger(savetarget.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            
            
        
        }
        
       response.sendRedirect("add_edit_target.jsp");
        
        
        
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
