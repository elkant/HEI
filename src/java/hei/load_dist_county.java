/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
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
import org.json.JSONObject;

/**
 *
 * @author GNyabuto
 */
public class load_dist_county extends HttpServlet {
HttpSession session;
String hf_id,district_id,county_id;
String county,district;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            session = request.getSession();
            dbConn conn = new dbConn();
            /* TODO output your page here. You may use following sample code. */
            JSONObject jobj = new JSONObject();
            
            hf_id=district_id=county_id="";
                    district = "<option value=\"\">Choose District</option>";
                    county = "<option value=\"\">Choose County</option>";
            
            hf_id=request.getParameter("hf_id");
//            hf_id="1";
            String getdistrict_id = "SELECT district.district_id,district.county_id FROM facilities JOIN district ON facilities.district_id=district.district_id WHERE facility_id=?";
            conn.pst=conn.connect.prepareStatement(getdistrict_id);
            conn.pst.setString(1, hf_id);
            
            conn.rs=conn.pst.executeQuery();
            while(conn.rs.next()){
            district_id = conn.rs.getString(1);
            county_id = conn.rs.getString(2);
            }
            
            String getCounties="SELECT county_id,county_name FROM county";
            conn.rs=conn.st.executeQuery(getCounties);
            while(conn.rs.next()){
                if(county_id.equals(conn.rs.getString(1))){
                    county+="<option value=\""+conn.rs.getString(1)+"\" selected>"+conn.rs.getString(2)+"</option>";    
                }
                else{
                    county+="<option value=\""+conn.rs.getString(1)+"\">"+conn.rs.getString(2)+"</option>";  
                }
            }
            
            String getDistrict="SELECT district_id,district_name FROM district WHERE county_id='"+county_id+"'";
            conn.rs=conn.st.executeQuery(getDistrict);
            while(conn.rs.next()){
                if(district_id.equals(conn.rs.getString(1))){
                    district+="<option value=\""+conn.rs.getString(1)+"\" selected>"+conn.rs.getString(2)+"</option>";    
                }
                else{
                    district+="<option value=\""+conn.rs.getString(1)+"\">"+conn.rs.getString(2)+"</option>";  
                }
            }
           
            jobj.put("district", district);
            jobj.put("county", county);
            System.out.println(jobj); 
            out.println(jobj);
        } finally {
            out.close();
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
        Logger.getLogger(load_dist_county.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(load_dist_county.class.getName()).log(Level.SEVERE, null, ex);
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

}
