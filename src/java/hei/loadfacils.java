/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import db.dbConn;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
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
 * @author Geofrey Nyabuto
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class loadfacils extends HttpServlet {

    String district_id,current_facils;
   HttpSession session; 
  
   String districts,districts2;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            
            
           current_facils=districts=districts2="";
           dbConn conn=new dbConn();
           
            if(request.getParameter("dist")!=null){
           district_id=request.getParameter("dist");
           districts="Select * from facilities where district_id='"+district_id+"' order by facility_name";  
           districts2="Select * from facilities where district_id!='"+district_id+"' order by facility_name";  
            }
            else{
            districts="Select * from facilities order by facility_name";      
            }
           
           
           
           conn.rs=conn.st.executeQuery(districts);
           
           //add all the districts to the 
          
//           current_facils="<option value=\"\">Choose facilty</option>";
           current_facils="";
           
           while(conn.rs.next()){

          current_facils=current_facils+"<option value=\""+conn.rs.getString(1)+"\">"+conn.rs.getString(2)+"</option>";

           }
           
           if(request.getParameter("dist")!=null){
             current_facils+="<option value=\"\" disabled>Facilities from other districts</option>";  
                conn.rs1=conn.st1.executeQuery(districts2);   
                while(conn.rs1.next()){

               current_facils=current_facils+"<option value=\""+conn.rs1.getString(1)+"\">"+conn.rs1.getString(2)+"</option>";

                }
           }
           
           
           if(current_facils.equals("<option value=\"\">Choose facilty</option>")){
           
           current_facils="<option value=\"\">No facility added yet</option>";
               
           }
           
             // jsonobj.put("data", partnerscores);
           
           System.out.println(current_facils);
           PrintWriter out = response.getWriter();
            
            
            out.println("<h1>" +current_facils+"</h1>");
          
             
           
  
        } catch (SQLException ex) {
            Logger.getLogger(districtchooser.class.getName()).log(Level.SEVERE, null, ex);
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

