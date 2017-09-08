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
import org.apache.catalina.Session;
import org.apache.catalina.ant.SessionsTask;

/**
 *
 * @author SIXTYFOURBIT
 */
public class saveFacility extends HttpServlet {

   String district,facilityname,mfl,number;
   String msg="",notadded="",added="";
   
   HttpSession session;
   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
      
        try {
         
         session=request.getSession();
         
         msg="";
         notadded="";
         added="";
         
         if(session.getAttribute("districtid")!=null){
         district=session.getAttribute("districtid").toString();
         }
           number=request.getParameter("rows");
          dbConn conn= new dbConn();
           
           int rows=Integer.parseInt(number);
           
           for(int a=1;a<=rows;a++){
           
           facilityname="";
           mfl="";    
           
           
          
         
         if(!request.getParameter("facilityname_"+a).equals("")){
         facilityname=request.getParameter("facilityname_"+a);
         }
         
         if(!request.getParameter("mflcode_"+a).equals("")){
         mfl=request.getParameter("mflcode_"+a);
         }
         
          
         
         
        
         
         conn.rs=conn.st.executeQuery("select * from facilities where facility_name='"+facilityname+"' and district_id='"+district+"'");
         
         if(!conn.rs.next()){
         
         String insert="insert into facilities(facility_name,facility_mfl_code,district_id)values('"+facilityname+"','"+mfl+"','"+district+"') ";
        
         if(!facilityname.equals("")&&!mfl.equals("")){
         conn.st1.executeUpdate(insert);
           added+=facilityname+",";
         }
         
       
         
         }
         else 
         {
         notadded+=facilityname+",";
         
         
         }
         
         }//end of for
          
           
       if(!added.equals("")){msg= added+" <font color=\"green\"> added succesfully.</font></br>";}    
       if(!notadded.equals("")){msg+= notadded+"<font color=\"red\">  already added in the system .</font>";}    
        
       if(msg.equals("")){msg="No record Saved. Ensure you added both facility name and mfl code";}
       session.setAttribute("msg",msg);
       
      
            
        } catch (SQLException ex) {
            Logger.getLogger(saveFacility.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
         response.sendRedirect("loadfacilities.jsp");
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
