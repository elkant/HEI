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
public class loadmonths extends HttpServlet {
    
String allmonths="";
String months="",year="",facilityid,cohort_type;
 HttpSession session;  
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
         PrintWriter out = response.getWriter();
        try {
           dbConn conn = new dbConn();
           session = request.getSession();
         Calendar cal = Calendar.getInstance();
         
         String curyear=""+cal.get(Calendar.YEAR);
         int curmonth=(cal.get(Calendar.MONTH)+1);
         
         System.out.println("Current month_"+curmonth);
         
         if(request.getParameter("yr")!=null) { 
         year=request.getParameter("yr");
         }
         else{
          if(session.getAttribute("year")!=null){
              year =session.getAttribute("year").toString();
          }   
         }
         if(request.getParameter("facil")!=null){
           facilityid=request.getParameter("facil");
         }
         else{
         if(session.getAttribute("facility")!=null){
           facilityid = session.getAttribute("facility").toString();
         }    
         }
         
         cohort_type = request.getParameter("cohort_type");
         if(cohort_type==null){
             cohort_type="";
         }
            System.out.println("cohort type : "+cohort_type);
          months="<option value=\"\">Select Month</option>"; 
           
           conn.rs=conn.st.executeQuery("select * from months");
            
            while(conn.rs.next()){
                String query = "";
                if(cohort_type.equals("1")){
                query = "select * from results where birth_year='"+year+"'and month='"+conn.rs.getString("month") +"' and facility_id='"+facilityid+"'  AND indicator_id<16";      
                }
                else if(cohort_type.equals("2")){
                 query = "select * from results where birth_year='"+year+"'and month='"+conn.rs.getString("month") +"' and facility_id='"+facilityid+"'  AND indicator_id>=16";     
                }
                else{
                query = "select * from results where birth_year='0'and month='0' and facility_id='0' ";    
                }
                
                System.out.println("months query : "+query);
                conn.rs1=conn.st1.executeQuery(query);
        
                if(conn.rs1.next()){
                 
               if(session.getAttribute("month")!=null){
                   if(session.getAttribute("month").toString().equals(conn.rs.getString(2))){
                  
                months+="<option value=\""+conn.rs.getString(2) +"\" selected> **"+conn.rs.getString(2)+"</option>"; 
                   }
               
                   else{
                   months+="<option value=\""+conn.rs.getString(2) +"\"> **"+conn.rs.getString(2)+"</option>";      
                   }
               }
               else{
                months+="<option value=\""+conn.rs.getString(2) +"\"> **"+conn.rs.getString(2)+"</option>";     
               }
                }
                else{
                     
                    if(curyear.equals(year)){
                        
                        if(conn.rs.getInt("monthid")>curmonth){
                             if(session.getAttribute("month")!=null){
                   if(session.getAttribute("month").toString().equals(conn.rs.getString(2))){
                         months+="<option disabled value=\""+conn.rs.getString(2) +"\" selected> "+conn.rs.getString(2)+"</option>";
                   }
                             
                   else{
                     months+="<option disabled value=\""+conn.rs.getString(2) +"\"> "+conn.rs.getString(2)+"</option>";   
                   }
                    }
                             else{
                      months+="<option disabled value=\""+conn.rs.getString(2) +"\"> "+conn.rs.getString(2)+"</option>";            
                             }
                        }
                        else{
                             if(session.getAttribute("month")!=null){
                   if(session.getAttribute("month").toString().equals(conn.rs.getString(2))){
                         months+="<option value=\""+conn.rs.getString(2) +"\" selected> "+conn.rs.getString(2)+"</option>";
                   }
                   else{
                    months+="<option value=\""+conn.rs.getString(2) +"\"> "+conn.rs.getString(2)+"</option>";   
                       
                   }
                             }
                             else{
                         months+="<option value=\""+conn.rs.getString(2) +"\"> "+conn.rs.getString(2)+"</option>";     
                        }
                        }
                      
                        
                    }
                  
                    else{
                         if(session.getAttribute("month")!=null){
                   if(session.getAttribute("month").toString().equals(conn.rs.getString(2))){
                months+="<option value=\""+conn.rs.getString(2) +"\" selected>"+conn.rs.getString(2)+"</option>";   
                   }
                   else{
                  months+="<option value=\""+conn.rs.getString(2) +"\">"+conn.rs.getString(2)+"</option>";        
                   }      
                         }
                         else{
                        months+="<option value=\""+conn.rs.getString(2) +"\">"+conn.rs.getString(2)+"</option>";        
                         }
                       }
            
            }
            
            
           
            
        }
            System.out.println("Months_"+months);
          out.println(months);  
            
            conn.st.close();
            conn.st1.close();
        }            
catch (SQLException ex) {
            Logger.getLogger(loadmonths.class.getName()).log(Level.SEVERE, null, ex);
            
            
        } finally { 
            
           
            out.close();
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
