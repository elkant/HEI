/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
public class updatedistrictid extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = response.getWriter();
           
            //select the ditrict name and replace with the correct district id
            
            
            dbConn conn= new dbConn();
            
            String insidefacilities="select * from facilities";
            
            
          
            conn.rs=conn.st.executeQuery(insidefacilities);
            
            while(conn.rs.next()){
            //get the correct facility name from the districts table
                String findid="select district_id from district where district_name LIKE '"+conn.rs.getString("district_id") +"'";
                conn.rs1=conn.st1.executeQuery(findid);
            if(conn.rs1.next()){
            String upd="update facilities set district_id='"+conn.rs1.getString(1) +"' where facility_id='"+conn.rs.getString(1) +"'";
           conn.st2.executeUpdate(upd);
            System.out.println(""+upd);
            }
            else{
            System.out.println("DINT WORK IN::::>>>"+findid);
                    
            
            }
            
            
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(updatedistrictid.class.getName()).log(Level.SEVERE, null, ex);
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
