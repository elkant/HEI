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

/**
 *
 * @author Geofrey Nyabuto
 */
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */


public class districtchooser extends HttpServlet {

    String county_id,current_districts;
   HttpSession session; 
    ArrayList dist=new ArrayList();
   
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            response.setContentType("text/html;charset=UTF-8");
            session=request.getSession();
           if(request.getParameter("county_id")!=null){
           county_id=request.getParameter("county_id");
           }
           else{
               county_id="";
           if(session.getAttribute("county")!=null){
           county_id = session.getAttribute("county").toString();
           }    
           }
           System.out.println(county_id);
        //   System.out.println(" County:"+ county_name); 
           current_districts="";
           String districts="";
           if(!county_id.equals("")){
           districts="Select * from district where county_id='"+county_id+"' order by district_name";
           }
           else{
           districts="Select * from district order by district_name";    
           }
           dbConn conn=new dbConn();
           
           conn.rs=conn.st.executeQuery(districts);
           
           //add all the districts to the 
          
           current_districts="<option value=\"\">Choose District</option>";
           
           while(conn.rs.next()){
               if(session.getAttribute("district")!=null){
                   if(session.getAttribute("district").toString().equals(conn.rs.getString("district_id"))){
                   current_districts=current_districts+"<option value=\""+conn.rs.getString("district_id")+"\" selected>"+conn.rs.getString("district_name")+"</option>";    
                   }
                   else{
                       current_districts=current_districts+"<option value=\""+conn.rs.getString("district_id")+"\">"+conn.rs.getString("district_name")+"</option>";
                   }
               }
               else{
          current_districts=current_districts+"<option value=\""+conn.rs.getString("district_id")+"\">"+conn.rs.getString("district_name")+"</option>";
               }
           }
           PrintWriter out = response.getWriter();
            
            
            out.println(current_districts);
          
             
            System.out.println("Loading-----------------------------");
  
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

