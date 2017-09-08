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

/**
 *
 * @author SIXTYFOURBIT
 */
public class editfacil extends HttpServlet {

  HttpSession session;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
                session = request.getSession();

        //this gets the id og the row that is being edited
        String id = request.getParameter("id");// values passed from the ajax
        String value = request.getParameter("value").toUpperCase();// values passed from the ajax

        String columnName = request.getParameter("columnName");// values passed from the ajax
        String columnId = request.getParameter("columnId");// values passed from the ajax

        String columnPosition = request.getParameter("columnPosition");// values passed from the ajax

        String rowId = request.getParameter("rowId"); // values passed from the ajax 


        System.out.println("value" + value);
        System.out.println("columnName" + columnName);
        System.out.println(columnId);
        int CID = (Integer.parseInt(columnId));
        System.out.println("col " + columnPosition);
        System.out.println(rowId);
        response.getWriter().print(value);


//  String unique=(String)session.getAttribute("countyid");
        dbConn conn = new dbConn();
        String query1 = "";
        String query2 = "";


        // update the fname
        if (columnName.equals("Facility Name")) {
            try {
                query1 = "update facilities set facility_name='" + value + "' where facility_id='" + id + "'";



                conn.st.executeUpdate(query1);
                //           out.println("Saved, Refresh page");
            } catch (SQLException ex) {
                Logger.getLogger(editfacil.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

        // update the mname
        if (columnName.equals("Site Mfl Code")) {
            try {
                query1 = "update facilities set facility_mfl_code='" + value + "' where facility_id='" + id + "'";



                conn.st.executeUpdate(query1);
                //           out.println("Saved, Refresh page");
            } catch (SQLException ex) {
                Logger.getLogger(editfacil.class.getName()).log(Level.SEVERE, null, ex);
            }
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
