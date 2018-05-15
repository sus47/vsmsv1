/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author MS
 */
@WebServlet(name = "CreateFunction", urlPatterns = {"/CreateFunction"})
public class CreateFunction extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            DB db = new DB();

            String sql;

            try {

                Statement st = db.con.createStatement();

                try {
                    sql = "DROP FUNCTION EXAM_SN_TO_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION EXAM_SN_TO_NAME"
                            + "\n(SsN VARCHAR(20)) "
                            + " \n RETURNS varchar(100) CHARSET latin1 \n"
                            + "BEGIN    DECLARE P_NAME VARCHAR(100);  SELECT `EXAM_NAME` into P_NAME FROM exam_details WHERE `SN`=SsN; RETURN P_NAME; END";
                    st.execute(sql);
                    out.println("<br>EXAM_SN_TO_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_AD_DATE";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_AD_DATE"
                            + "\n(bsDate VARCHAR(10)) "
                            + " \n RETURNS date \n"
                            + "BEGIN     DECLARE adDate DATE;   SELECT `AD_DATE` INTO adDate FROM ad_bs_calender WHERE `BS_DATE`=bsDate; RETURN adDate;  END";
                    st.execute(sql);
                    out.println("<br>GET_AD_DATE  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_BS_DATE";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_BS_DATE"
                            + "\n(adDate DATE) "
                            + " \n RETURNS varchar(10) CHARSET utf8 \n"
                            + "BEGIN     DECLARE bsDate VARCHAR(10);   SELECT `BS_DATE` INTO bsDate FROM ad_bs_calender WHERE `AD_DATE`=adDate; RETURN bsDate;  END";
                    st.execute(sql);
                    out.println("<br>GET_BS_DATE  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_CLASS_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_CLASS_NAME"
                            + "\n(SsN INT) "
                            + " \n RETURNS varchar(300) CHARSET latin1 \n"
                            + "BEGIN    DECLARE VAL VARCHAR(300);  SELECT `NAME` INTO VAL FROM class_name_para WHERE `ID`=SsN; RETURN ifnull(VAL,''); END";
                    st.execute(sql);
                    out.println("<br>GET_CLASS_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_DATE";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_DATE"
                            + "\n(bsDate VARCHAR(10)) "
                            + " \n RETURNS date \n"
                            + "BEGIN     DECLARE adDate DATE;   SELECT `AD_DATE` INTO adDate FROM ad_bs_calender WHERE `BS_DATE`=bsDate OR `AD_DATE`=bsDate; RETURN adDate;  END";
                    st.execute(sql);
                    out.println("<br>GET_DATE  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_EXAM_SUB_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_EXAM_SUB_NAME"
                            + "\n(SsN INT) "
                            + " \n RETURNS varchar(30) CHARSET latin1 \n"
                            + "BEGIN     DECLARE SUB VARCHAR(30);  SELECT `EXAM_NAME` INTO SUB FROM exam_details WHERE `SN`=SsN; RETURN ifnull(SUB,''); END";
                    st.execute(sql);
                    out.println("<br>GET_EXAM_SUB_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_EXAM_SUB_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_SUBJECT_GROUP_NAME"
                            + "\n(SUBID varchar(100)) "
                            + " \n RETURNS varchar(30) CHARSET latin1 \n"
                            + "BEGIN     DECLARE SUBGRP VARCHAR(255); SELECT `NAME` INTO SUBGRP FROM subject_group WHERE `CODE`=SUBID; RETURN ifnull(SUBGRP,''); END";
                    st.execute(sql);
                    out.println("<br>GET_SUBJECT_GROUP_NAME FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_SUBJECT_GROUP_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_PERCENT_GRAADE"
                            + "\n(P FLOAT) "
                            + " \n RETURNS varchar(10) CHARSET utf8 \n"
                            + "BEGIN    DECLARE GRADE VARCHAR(10); SELECT `GRADE_NAME` INTO GRADE FROM result_grade_para WHERE P between `PRECENT_FROM` AND `PRECENT_TO`; RETURN GRADE;  END";
                    st.execute(sql);
                    out.println("<br>GET_PERCENT_GRAADE  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_PH_FULL_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_PH_FULL_MARK"
                            + "\n(SG INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE FULL_MARK FLOAT(6,2); SELECT SUM(`PH_FM`) INTO FULL_MARK FROM exam_subject_group WHERE CONCAT(`SUB_CODE`,SN)=SG; RETURN IFNULL(FULL_MARK,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_PH_FULL_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_PH_OBTAIN_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_PH_OBTAIN_MARK"
                            + "\n(SUBJECT_SN INT,RESULT_SN INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE OM FLOAT(6,2); SELECT `PH_OM` INTO OM FROM exam_result_details WHERE `EXAM_SUBJECT_SN`=SUBJECT_SN AND `EXAM_RESULT_SN`=RESULT_SN; RETURN IFNULL(OM,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_PH_OBTAIN_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_PH_PASS_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_PH_PASS_MARK"
                            + "\n(SG INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE FULL_MARK FLOAT(6,2); SELECT SUM(PH_PM) INTO FULL_MARK FROM exam_subject_group WHERE CONCAT(`SUB_CODE`,SN)=SG; RETURN IFNULL(FULL_MARK,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_PH_PASS_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_PROGRAM_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_PROGRAM_NAME"
                            + "\n(SsN VARCHAR(20)) "
                            + " \n RETURNS varchar(100) CHARSET latin1 \n"
                            + "BEGIN    DECLARE P_NAME VARCHAR(100);  SELECT `PROGRAM_NAME` into P_NAME FROM exam_program WHERE `PROGRAM_CODE`=SsN; RETURN P_NAME; END";
                    st.execute(sql);
                    out.println("<br>GET_PROGRAM_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_SCHOOL_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_SCHOOL_NAME"
                            + "\n(SsN INT) "
                            + " \n RETURNS varchar(300) CHARSET latin1 \n"
                            + "BEGIN    DECLARE VAL VARCHAR(300);  SELECT `NAME` INTO VAL FROM school_info WHERE `ID`=SsN; RETURN ifnull(VAL,''); END";
                    st.execute(sql);
                    out.println("<br>GET_SCHOOL_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_STUDENT_FATHER_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_STUDENT_FATHER_NAME"
                            + "\n(studentId INT) "
                            + " \n RETURNS varchar(60) CHARSET latin1 \n"
                            + "BEGIN      DECLARE fatherName VARCHAR(300);   SELECT `FATHER_NAME` INTO fatherName FROM students_guardian_information WHERE  `STUDENT_SN`= studentId; RETURN ifnull(fatherName,'');  END";
                    st.execute(sql);
                    out.println("<br>GET_STUDENT_FATHER_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_STUDENT_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_STUDENT_NAME"
                            + "\n(SsN INT) "
                            + " \n RETURNS varchar(300) CHARSET latin1 \n"
                            + "BEGIN     DECLARE VAL VARCHAR(300);  SELECT `STUDENT_NAME` INTO VAL FROM students WHERE `SN`=SsN;  RETURN ifnull(VAL,''); END";
                    st.execute(sql);
                    out.println("<br>GET_STUDENT_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_STUDENT_REG_NAME";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_STUDENT_REG_NAME"
                            + "\n(SsN INT) "
                            + " \n RETURNS int(11) \n"
                            + "BEGIN  DECLARE VAL INT;  SELECT `STUDENT_SN` INTO VAL FROM exam_student_reg WHERE `SN`=SsN; RETURN VAL; END";
                    st.execute(sql);
                    out.println("<br>GET_STUDENT_REG_NAME  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_TH_FULL_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_TH_FULL_MARK"
                            + "\n(SG INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE FULL_MARK FLOAT(6,2); SELECT SUM(TH_FM) INTO FULL_MARK FROM exam_subject_group WHERE CONCAT(SUB_CODE,SN)=SG; RETURN IFNULL(FULL_MARK,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_TH_FULL_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_TH_OBTAIN_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_TH_OBTAIN_MARK"
                            + "\n(SUBJECT_SN INT,RESULT_SN INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE OM FLOAT(6,2); SELECT `TH_OM` INTO OM FROM exam_result_details WHERE `EXAM_SUBJECT_SN`=SUBJECT_SN AND `EXAM_RESULT_SN`=RESULT_SN; RETURN IFNULL(OM,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_TH_OBTAIN_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_TH_PASS_MARK";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_TH_PASS_MARK"
                            + "\n(SG INT) "
                            + " \n RETURNS float(6,2) \n"
                            + "BEGIN    DECLARE FULL_MARK FLOAT(6,2); SELECT SUM(TH_PM) INTO FULL_MARK FROM exam_subject_group WHERE CONCAT(SUB_CODE,SN)=SG; RETURN IFNULL(FULL_MARK,0);  END";
                    st.execute(sql);
                    out.println("<br>GET_TH_PASS_MARK  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }
                try {
                    sql = "DROP FUNCTION GET_TIME_OF_ATTEMPT";
                    st.execute(sql);
                } catch (Exception e) {
                }

                try {
                    sql = "CREATE FUNCTION GET_TIME_OF_ATTEMPT"
                            + "\n(SsN INT) "
                            + " \n RETURNS int(11) \n"
                            + "BEGIN    DECLARE VAL INT;  SELECT COUNT(*) INTO VAL FROM exam_student_reg WHERE `STUDENT_SN`=SsN; RETURN ifnull(VAL,0)+1; END";
                    st.execute(sql);
                    out.println("<br>GET_TIME_OF_ATTEMPT  FUNCTION CREATED");
                } catch (Exception e) {
                    out.println("<br>" + e.getMessage());
                }

            } catch (Exception e) {
                out.println(e.getMessage());
            }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
