/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uploads;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import pwp.IdGenerator;
import pwp.dbConn;

/**
 *
 * @author Geofrey Nyabuto
 */
public class uploadAllFacilities extends HttpServlet {
   String county_name,county_id, district_name,district_id,hf_name,hf_id;

   int checker_dist,checker_hf,mflcode;
   File file_source;
HttpSession session;
String checker_county,checker_district;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        session=request.getSession();
    dbConn conn=new dbConn();
    
         checker_county=checker_district="";
        county_name=county_id=district_name=district_id=hf_name=hf_id="";
       checker_dist=checker_hf= mflcode=0;
        file_source= new File("C:\\Users\\Geofrey Nyabuto\\Desktop\\hf\\supported_hf.xls");
                       System.out.println(" The file path is: "+file_source); 
                       
                        FileInputStream fileInputStream = new FileInputStream(file_source);
			HSSFWorkbook workbook = new HSSFWorkbook(fileInputStream);
			HSSFSheet worksheet = workbook.getSheet("Sheet2");
			Iterator rowIterator = worksheet.iterator();
                        
                        int i=0,y=0;
			while(rowIterator.hasNext()) {
                            county_name=county_id=district_name=district_id=hf_name=hf_id="";
                            mflcode=0;
			HSSFRow rowi = worksheet.getRow(i);
                        
                         HSSFCell cell1 = rowi.getCell((short) 2);
			county_name = cell1.getStringCellValue();
			HSSFCell cell2 = rowi.getCell((short) 3);
			district_name = cell2.getStringCellValue();
                        HSSFCell cell3 = rowi.getCell((short) 1);
			hf_name = cell3.getStringCellValue();
                        HSSFCell cell4 = rowi.getCell((short) 0);
			mflcode = (int) cell4.getNumericCellValue();

                   district_name = district_name.toUpperCase();
                   county_name=county_name.toUpperCase();
                  IdGenerator IG = new IdGenerator();
//                 hf_id=IG.sec+""+IG.micro;
                 String county_che="SELECT * FROM county WHERE county_name=?";
                 conn.pst=conn.conn.prepareStatement(county_che);
                 conn.pst.setString(1, county_name);
                 conn.rs=conn.pst.executeQuery();
                 if(conn.rs.next()==true){
                     county_id=conn.rs.getString(1);
                 }
                 System.out.println("county    :    "+county_id);
                 if(county_id.length()==0){
                     county_id=IG.current_id();
                     String county_inserter="INSERT INTO county (county_name) VALUES (?)";
                     conn.pst=conn.conn.prepareStatement(county_inserter);
                    conn.pst.setString(1, county_name);
                     conn.pst.executeUpdate();
                     String getdistid="SELECT max(county_id)FROM county";
                conn.rs=conn.st.executeQuery(getdistid);
                if(conn.rs.next()==true){
                    county_id=conn.rs.getString(1);
                }
                 }
                 
                 String check_dist="SELECT * FROM district WHERE district_name=? && county_id=?";
                 conn.pst=conn.conn.prepareStatement(check_dist);
                 conn.pst.setString(1, district_name);
                 conn.pst.setString(2, county_id);
                 
                 conn.rs=conn.pst.executeQuery();
                 if(conn.rs.next()==true){
                     district_id=conn.rs.getString(1);
                 }
                  System.out.println("district    :    "+district_id);
                 if(district_id.length()==0){
                     district_id=IG.current_id();
                     String dist_inserter="INSERT INTO district (county_id,district_name) VALUES (?,?)";
                conn.pst=conn.conn.prepareStatement(dist_inserter);
                conn.pst.setString(1, county_id);
                conn.pst.setString(2, district_name);
                
                conn.pst.executeUpdate();
                
                String getdistid="SELECT max(district_id)FROM district";
                conn.rs=conn.st.executeQuery(getdistid);
                if(conn.rs.next()==true){
                    district_id=conn.rs.getString(1);
                }
                 }
                  
//                    if(checker_dist>0) {
//                        DISTRICT FOUND ADD THE HF TO THE SYSTEM.........................
                        
                        String check_hf="SELECT COUNT(hf_id) FROM health_facility WHERE hf_name=? && district_id=?";
                         conn.prest=conn.conn.prepareStatement(check_hf);
                   conn.prest.setString(1,hf_name);
                   conn.prest.setString(2,district_id);
                 conn.rs=conn.prest.executeQuery();
                        if(conn.rs.next()==true){
                           checker_hf=conn.rs.getInt(1); 
                        }
                      if(checker_hf==0){
//                       ADD THE NEW HEALTH FACILITY TO THE SYSTEM.........................
                          hf_id=IG.current_id();
                          String inserter="INSERT INTO health_facility (hf_id,hf_name,mflcode,district_id) "
                                  + " VALUES(?,?,?,?)";
                           conn.prest=conn.conn.prepareStatement(inserter);
                   conn.prest.setString(1,hf_id);
                   conn.prest.setString(2,hf_name);
                   conn.prest.setInt(3,mflcode);
                   conn.prest.setString(4,district_id);
                   conn.prest.executeUpdate();
                          System.out.println(""+i+"    added  :   "+hf_name);
                      }  
                    else{
                        System.out.println("HEALTH FACILITY AT POSITION :  "+i+" AL READY ADDED  :   "+hf_name);
                    }    
//                    } 
//                    else{
//                        System.out.println("MISSING DISTRICT AT POSITION  :  "+i+"  for the district   "+district_name);
//                    }
                        
                        i++;
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
           Logger.getLogger(uploadAllFacilities.class.getName()).log(Level.SEVERE, null, ex);
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
           Logger.getLogger(uploadAllFacilities.class.getName()).log(Level.SEVERE, null, ex);
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
