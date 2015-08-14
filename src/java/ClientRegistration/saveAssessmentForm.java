/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ClientRegistration;

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
import pwp.IdGenerator;
import pwp.dbConn;

/**
 *
 * @author Geofrey Nyabuto
 */
public class saveAssessmentForm extends HttpServlet {
HttpSession session;
String date_of_assessment,id,client_id;
String knowledge_of_hiv,partner_hiv_testing,any_child_tested,any_child_not_tested,discordance,hiv_disclosure;
String abstinence,faithful_to_one_partner,safer_sex_methods,multiple_sex_partner,condom_use,alcohol_substance_abuse;
String adherence_to_arv,adherence_to_others,asking_stis_questions,family_planning;
String planning_to_have_children,screened_for_TB; 

String prevention_message_id,hiv_disclosure2,safer_sex_methods2,alcohol_use,adherence_to_arvs;
String adherence_other_medications,couples_counseling;

String partner_tested,children_tested,referral_for_sti,risk_reduction_info,treatment_adherence,condoms_provided;

String pregnancy_status,hormonal_contraceptive,condoms,pregnancy_counseling,transmission_risks;
String tb_screening,referred_tb_diagnosis,referred_pmtct_services,other_referrals,referral_point;
String timestamp;
int found;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
      session=request.getSession();
      dbConn conn = new dbConn();
  
      
 date_of_assessment="";
 knowledge_of_hiv=partner_hiv_testing=any_child_tested=any_child_not_tested=discordance=hiv_disclosure="";
 abstinence=faithful_to_one_partner=safer_sex_methods=multiple_sex_partner=condom_use=alcohol_substance_abuse="";
 adherence_to_arv=adherence_to_others=asking_stis_questions=family_planning="";
 planning_to_have_children=screened_for_TB="";

 prevention_message_id=hiv_disclosure2=safer_sex_methods2=alcohol_use=adherence_to_arvs="";
 adherence_other_medications=couples_counseling="";

 partner_tested=children_tested=referral_for_sti=risk_reduction_info=treatment_adherence=condoms_provided="";

 pregnancy_status=hormonal_contraceptive=condoms=pregnancy_counseling=transmission_risks="";
 tb_screening=referred_tb_diagnosis=referred_pmtct_services=other_referrals="";
 IdGenerator IG = new IdGenerator();
id=IG.current_id();
timestamp=IG.toDay();

prevention_message_id=id;
client_id=request.getParameter("client_id").trim();
  date_of_assessment=request.getParameter("date_of_assessment");
 knowledge_of_hiv=request.getParameter("knowledge_of_hiv");
 partner_hiv_testing=request.getParameter("partner_hiv_testing");
 any_child_tested=request.getParameter("any_child_tested");
 any_child_not_tested=request.getParameter("any_child_not_tested");
 discordance=request.getParameter("discordance");
 hiv_disclosure=request.getParameter("hiv_disclosure");
 abstinence=request.getParameter("abstinence");
 faithful_to_one_partner=request.getParameter("faithful_to_one_partner");
 safer_sex_methods=request.getParameter("safer_sex_methods");
 multiple_sex_partner=request.getParameter("multiple_sex_partner");
 condom_use=request.getParameter("condom_use");
 alcohol_substance_abuse=request.getParameter("alcohol_substance_abuse");
 adherence_to_arv=request.getParameter("adherence_to_arv");
 adherence_to_others=request.getParameter("adherence_to_others");
 asking_stis_questions=request.getParameter("asking_stis_questions");
 family_planning=request.getParameter("family_planning");
 planning_to_have_children=request.getParameter("planning_to_have_children");
 screened_for_TB=request.getParameter("screened_for_TB");
found=0;
 
System.out.println("client : "+client_id);
 String checkExistence="SELECT id from prevention_messages WHERE client_id=? && date_of_assessment=?";
 conn.pst1=conn.conn.prepareStatement(checkExistence);
 conn.pst1.setString(1, client_id);
 conn.pst1.setString(2, date_of_assessment);
 
 conn.rs=conn.pst1.executeQuery();
 if(conn.rs.next()==true){
     found=conn.rs.getString(1).length();
 }
 if(found==0){
 String addPreventionMessages="INSERT INTO prevention_messages (id,client_id,date_of_assessment,knowledge_of_hiv,"
 + "partner_hiv_testing,any_child_tested,any_child_not_tested,discordance,hiv_disclosure,abstinence,"
+ "faithful_to_one_partner,safer_sex_methods,multiple_sex_partner,condom_use,alcohol_substance_abuse,"
+ "adherence_to_arv,adherence_to_others,asking_stis_questions,family_planning,"
+ "planning_to_have_children,screened_for_TB,timestamp) "
+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
 conn.pst=conn.conn.prepareStatement(addPreventionMessages);
  conn.pst.setString(1,id );
  conn.pst.setString(2,client_id );
  conn.pst.setString(3,date_of_assessment );
  conn.pst.setString(4,knowledge_of_hiv );
  conn.pst.setString(5,partner_hiv_testing );
  conn.pst.setString(6,any_child_tested );
  conn.pst.setString(7,any_child_not_tested );
  conn.pst.setString(8,discordance );
  conn.pst.setString(9,hiv_disclosure );
  conn.pst.setString(10,abstinence );
  conn.pst.setString(11,faithful_to_one_partner );
  conn.pst.setString(12,safer_sex_methods );
  conn.pst.setString(13,multiple_sex_partner );
  conn.pst.setString(14,condom_use );
  conn.pst.setString(15,alcohol_substance_abuse );
  conn.pst.setString(16,adherence_to_arv );
  conn.pst.setString(17,adherence_to_others );
  conn.pst.setString(18,asking_stis_questions );
  conn.pst.setString(19,family_planning );
  conn.pst.setString(20,planning_to_have_children );
  conn.pst.setString(21,screened_for_TB );
  conn.pst.setString(22,timestamp);
  
  conn.pst.executeUpdate();
  
  
  
  IdGenerator IG2 = new IdGenerator();
id=IG2.current_id(); 
  
// prevention_message_id=request.getParameter("prevention_message_id");
 hiv_disclosure2=request.getParameter("hiv_disclosure2");
 safer_sex_methods2=request.getParameter("safer_sex_methods2");
 alcohol_use=request.getParameter("alcohol_use");
 adherence_to_arvs=request.getParameter("adherence_to_arvs");
 adherence_other_medications=request.getParameter("adherence_other_medications");
 couples_counseling=request.getParameter("couples_counseling");

 String addPreventionCounseling="INSERT INTO prevention_counseling(id,prevention_message_id,hiv_disclosure,"
+ "safer_sex_methods,alcohol_use,adherence_to_arvs,adherence_other_medications,couples_counseling,timestamp)"
+ " VALUES(?,?,?,?,?,?,?,?,?)";
 conn.pst=conn.conn.prepareStatement(addPreventionCounseling);
 conn.pst.setString(1, id);
 conn.pst.setString(2, prevention_message_id);
 conn.pst.setString(3, hiv_disclosure2);
 conn.pst.setString(4, safer_sex_methods2);
 conn.pst.setString(5, alcohol_use);
 conn.pst.setString(6, adherence_to_arvs);
 conn.pst.setString(7, adherence_other_medications);
 conn.pst.setString(8, couples_counseling);
 conn.pst.setString(9, timestamp);
 
 conn.pst.executeUpdate();
 
  IdGenerator IG3 = new IdGenerator();
id=IG3.current_id();

 partner_tested=request.getParameter("partner_tested");
 children_tested=request.getParameter("children_tested");
 referral_for_sti=request.getParameter("referral_for_sti");
 risk_reduction_info=request.getParameter("risk_reduction_info");
 treatment_adherence=request.getParameter("treatment_adherence");
 condoms_provided=request.getParameter("condoms_provided");
 
 String addHIV="INSERT INTO hiv_testing_stis(id,prevention_message_id,partner_tested,children_tested,"
         + "referral_for_sti,risk_reduction_info,treatment_adherence,condoms_provided,timestamp)"
         + " VALUES(?,?,?,?,?,?,?,?,?)";
 
 conn.pst=conn.conn.prepareStatement(addHIV);
 conn.pst.setString(1, id);
 conn.pst.setString(2, prevention_message_id);
 conn.pst.setString(3, partner_tested);
 conn.pst.setString(4, children_tested);
 conn.pst.setString(5, referral_for_sti);
 conn.pst.setString(6, risk_reduction_info);
 conn.pst.setString(7, treatment_adherence);
 conn.pst.setString(8, condoms_provided);
 conn.pst.setString(9, timestamp);
 
 conn.pst.executeUpdate();
 

  IdGenerator IG4 = new IdGenerator();
id=IG4.current_id();

 pregnancy_status=request.getParameter("pregnancy_status");
 hormonal_contraceptive=request.getParameter("hormonal_contraceptive");
 condoms=request.getParameter("condoms");
 pregnancy_counseling=request.getParameter("pregnancy_counseling");
 transmission_risks=request.getParameter("transmission_risks");
 tb_screening=request.getParameter("tb_screening");
 referred_tb_diagnosis=request.getParameter("referred_tb_diagnosis");
 referred_pmtct_services=request.getParameter("referred_pmtct_services");
 other_referrals=request.getParameter("other_referrals");
 if(other_referrals.equals("1")){
referral_point=request.getParameter("referral_point");
 }
 else{
     referral_point="";
 }
 
 String addFamilyPlanning="INSERT INTO family_planning_tb_pmtct (id,prevention_message_id,pregnancy_status,"
         + "hormonal_contraceptive,condoms,pregnancy_counseling,transmission_risks,tb_screening,"
         + "referred_tb_diagnosis,referred_pmtct_services,other_referrals,referral_point,timestamp) "
         + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";

 conn.pst=conn.conn.prepareStatement(addFamilyPlanning);
 conn.pst.setString(1, id);
 conn.pst.setString(2, prevention_message_id);
 conn.pst.setString(3, pregnancy_status);
 conn.pst.setString(4, hormonal_contraceptive);
 conn.pst.setString(5, condoms);
 conn.pst.setString(6, pregnancy_counseling);
 conn.pst.setString(7, transmission_risks);
 conn.pst.setString(8, tb_screening);
 conn.pst.setString(9, referred_tb_diagnosis);
 conn.pst.setString(10, referred_pmtct_services);
 conn.pst.setString(11, other_referrals);
 conn.pst.setString(12, referral_point);
 conn.pst.setString(13, timestamp);
 
 conn.pst.executeUpdate();
  session.setAttribute("addedAssessment", "<font color=\"green\">Assessment form saved successfully.</font>");
    }
 else{
  session.setAttribute("addedAssessment", "<font color=\"red\">Assessment data already added.</font>");    
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
 response.sendRedirect("ChooseAssessment.jsp");
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
        Logger.getLogger(saveAssessmentForm.class.getName()).log(Level.SEVERE, null, ex);
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
        Logger.getLogger(saveAssessmentForm.class.getName()).log(Level.SEVERE, null, ex);
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
