<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
    <a href="../../marksheet/MS131.pdf"></a>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>
llll
    <body>
        <p>Hello! This is the default welcome page for a Spring Web MVC project.</p>
        <p><i>To display a different welcome page for this project, modify</i>
            <tt>index.jsp</tt> <i>, or create your own welcome page then change
                the redirection in</i> <tt>redirect.jsp</tt> <i>to point to the new
                welcome page and also update the welcome-file setting in</i>
            <tt>web.xml</tt>.</p>
    </body>
</html>
<%--
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Utility;

import com.project.pdf.api.HtmlToPdf;
import java.awt.Dimension;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.URL;
import java.net.URLConnection;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;

@WebServlet(name = "SendEmail", urlPatterns = {"/SendEmail"})
public class SendEmail extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String Customer,email,billNo,brokerNo;
       
            Customer = request.getParameter("Customer");
            email = request.getParameter("email");
            billNo = request.getParameter("billNo");
            brokerNo = request.getParameter("brokerNo");
         String msg=urlToHtml(billNo,email,brokerNo); 
      out.print(msg);
        if(msg.equalsIgnoreCase("Sent")){
            model.DB db = new model.DB();
            try {
                String sql = "INSERT INTO BILL_EMAIL_SENT (EMAIL_ID, MAILING_DATE, CUSTOMER_CODE, BILL) VALUES ('"+email+"', SYSDATE, '"+Customer+"', '"+billNo+"')";
                db.getCon(sql);
                db.ps.executeUpdate();
            } catch (Exception e) {
            }
            db.close();
        File f;
        try{
        f=new File("C:/Payout/"+billNo+".html");
        f.delete();
        }catch(Exception e){}
         try{
        f=new File("C:/Payout/"+billNo+".pdf");
        f.delete();
        }catch(Exception e){}
        }
        
        }
    }
    
     
     

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    
    @Override
    public String getServletInfo() {
        return "Short description";
    }
public static String send(String toEmail,String fileName,String sub,String body)
{
    String file = "C:/Payout/"+fileName;
    final String username = "mspl.broker@gmail.com";
    final String password = "JavaWebMandalaBvar";
    String msg="Sent";
    Properties props = new Properties();
    props.put("mail.smtp.auth", true);
    props.put("mail.smtp.starttls.enable", true);
    props.put("mail.smtp.host", "smtp.gmail.com");
    props.put("mail.smtp.port", "587");
//    int totalEmail=0;
//    
//   
//    String receiverEmail[]=new String[1];
//    receiverEmail[0]=toEmail;
//    try{
//if(toEmail.indexOf(",")>0)
//{
// 
//    String temp="";
//for(int i=0;i<toEmail.length();i++)
//{
//if(toEmail.charAt(i)==','){receiverEmail[totalEmail]=temp;temp="";totalEmail++;}
//else
//{
//    temp+=String.valueOf(toEmail.charAt(i));
//}
//}
//
//}
//    }catch(Exception e){return e.getMessage();}
//for(int i=0;i<=totalEmail;i++){
    Session session = Session.getInstance(props,
            new javax.mail.Authenticator() {
                protected PasswordAuthentication getPasswordAuthentication() {
                    return new PasswordAuthentication(username, password);
                }
            });

    try {

        Message message = new MimeMessage(session);
        message.setFrom(new InternetAddress(username));
        message.setRecipients(Message.RecipientType.TO,
        InternetAddress.parse(toEmail));
        message.setSubject(sub+" from Broker No "+body);
       MimeBodyPart messageBodyPart = new MimeBodyPart();
        Multipart multipart = new MimeMultipart();
        messageBodyPart = new MimeBodyPart();
    
        DataSource source = new FileDataSource(file);
        messageBodyPart.setDataHandler(new DataHandler(source));
        messageBodyPart.setFileName(fileName);
        multipart.addBodyPart(messageBodyPart);
         
        message.setContent(multipart);
//              message.setText(body);
       Transport.send(message);
} catch (MessagingException e) {
       msg="Mail "+e.getMessage();
    }
//}
//  msg="";
  return msg;
//    return msg;
  }

 String generatePDF(String to,String brokerNo,String billNo){
     String msg="";
         String inputHTMLFileName="C:/Payout/"+billNo+".html";
        File outputPDFFile=new File("C:/Payout/"+billNo+".pdf"); 
        try{    
        String fontsDir=null; 
        String headerBody=null;
        java.io.FileOutputStream fos = new java.io.FileOutputStream(outputPDFFile);
        PD4ML pd4ml = new PD4ML();

        pd4ml.setHtmlWidth(850);
        
       if (fontsDir != null && fontsDir.length() > 0) {
            pd4ml.useTTF(fontsDir, true);
        }
        if (headerBody != null && headerBody.length() > 0) {
            PD4PageMark header = new PD4PageMark();
            header.setAreaHeight(-1); // autocompute
            header.setHtmlTemplate(headerBody); // autocompute
            pd4ml.setPageHeader(header);
        }
        pd4ml.enableDebugInfo();
        pd4ml.render("file:" + inputHTMLFileName, fos);
         msg= send(to,billNo+".pdf","bill","Broker No "+brokerNo);
        }catch(Exception e){msg=e.getMessage();}
         
        return msg;
    }
 
    String urlToHtml(String billNo, String to, String brokerNo)
    {
        String billUrl="http://localhost:8084/Broker/ReportsPrint/Bill.mspl?BillNoFrom="+billNo; 
        String msg="";
          //save to this filename
        String fileName = "C:/Payout/"+billNo+".html";
        File file = new File(fileName);
        try{      
        URL url = new URL(billUrl);
        URLConnection conn = url.openConnection();
        // open the stream and put it into BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;

      
      
       try{ 
         file.createNewFile();
                 }catch(Exception e){}
        //use FileWriter to write file
        FileWriter fw = new FileWriter(file.getAbsoluteFile());
        BufferedWriter bw = new BufferedWriter(fw);
        while ((inputLine = br.readLine()) != null) {
         bw.write(inputLine);
//         System.out.println(inputLine);
        }
        
        bw.close();
        br.close();
        msg=generatePDF(to,brokerNo,billNo);            
      
        }catch(Exception e){msg=e.getMessage();}
       
       return msg;
    }
}

--%>