/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package hei;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author SIXTYFOURBIT
 */
public class createfacils extends HttpServlet {
String number, districtdata,districtid,districtname;
int rows=0;   
    
 HttpSession session;   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        session= request.getSession();
        number="";
        rows=0;
        districtdata=request.getParameter("district");
        number=request.getParameter("number");
       if(districtdata.contains(",")){
        String districtinfor[]=districtdata.split(",");
        
        
        session.setAttribute("districtid", districtinfor[0]);
        session.setAttribute("districtname", districtinfor[1]);
       }
        
        if(!number.equals("")){
       
       rows=Integer.parseInt(number);
       
        }
        
        String createdtable="";
        
        for(int a=1;a<=rows;a++){
        
        
        createdtable+="<tr><td>Facility Name</td><td><input type=\"text\" name=\"facilityname_"+a+"\" id=\"facilityname_"+a+"\" /></td>"        
           +"<td>MFL Code:</td><td><input type=\"text\" name=\"mflcode_"+a+"\" id=\"mflcode_"+a+"\" /></td></tr>";
        
        }
        
        createdtable+="<tr><td><input type=\"hidden\" value=\""+rows+"\" id=\"rows\" name=\"rows\"></td></tr>";
     session.setAttribute("createdfaciltable",createdtable);

       
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
