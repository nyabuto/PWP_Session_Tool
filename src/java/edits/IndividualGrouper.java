/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package edits;

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
import pwp.dbConn;

/**
 *
 * @author Geofrey Nyabuto
 */
public class IndividualGrouper extends HttpServlet {
HttpSession session;
String provider_id,groupingId,maxLessons;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        session=request.getSession();
        dbConn conn = new dbConn();
        
        
        String getAllProviders="SELECT provider_id FROM service_provider";
        conn.rs2=conn.st2.executeQuery(getAllProviders);
        while(conn.rs2.next()){
        provider_id=conn.rs2.getString(1);
        groupingId=maxLessons="";
        String clientGrouper="select groupings,lessons_attended from clients WHERE provider_id='"+provider_id+"' && group_id='0' "
                + "ORDER BY lessons_attended DESC LIMIT 1";
        conn.rs=conn.st.executeQuery(clientGrouper);
        if(conn.rs.next()==true){
//            while(conn.rs.next()){
            groupingId=conn.rs.getString(1);
            maxLessons=conn.rs.getString(2);
            System.out.println("group id : "+groupingId+"       max lessons : "+maxLessons);
        }
         String updateUser="UPDATE clients SET groupings='"+groupingId+"' WHERE provider_id='"+provider_id+"'";
         conn.st.executeUpdate(updateUser);
            
        }
        
        if(conn.rs!=null){conn.rs.close();}
if(conn.st!=null){conn.st.close();}
if(conn.rs1!=null){conn.rs1.close();}
if(conn.st1!=null){conn.st1.close();}
if(conn.rs2!=null){conn.rs2.close();}
if(conn.st2!=null){conn.st2.close();}
if(conn.st3!=null){conn.st3.close();}
if(conn.pst!=null){conn.pst.close();}
if(conn.pst!=null){conn.pst.close();}
if(conn.pst1!=null){conn.pst1.close();}
if(conn.pst1!=null){conn.pst1.close();}
if(conn.conn!=null){conn.conn.close();}

        System.out.println("END OF FILE REACHED HERE=======================");
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
        Logger.getLogger(IndividualGrouper.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(IndividualGrouper.class.getName()).log(Level.SEVERE, null, ex);
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
