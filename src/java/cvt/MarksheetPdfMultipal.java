
package cvt;
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
import java.text.SimpleDateFormat;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import org.zefer.pd4ml.PD4ML;


import org.zefer.pd4ml.PD4Constants;
import org.zefer.pd4ml.PD4ML;
import org.zefer.pd4ml.PD4PageMark;


public class MarksheetPdfMultipal {
    

 String generatePDF(String fileName,int port){
   
        String msg=fileName;
        String inputHTMLFileName=Location.getDrivePath(port)+fileName+".html";
        File outputPDFFile=new File(Location.getDrivePath(port)+fileName+".pdf"); 
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
        
        }catch(Exception e){msg=e.getMessage();}
         File file = new File(inputHTMLFileName);
         try{
             file.delete();
         }catch(Exception ex){}
        return msg;
    }
 
    public String urlToHtml(String schoolId, String examId,String studentId,int port)
    {
       String msg="";
     java.util.Date d=new java.util.Date();
        SimpleDateFormat df=new SimpleDateFormat("yyyyMMdd");
       
        
           try{
        String URL=Location.getUrl(port)+"MarksheetController?studentId="+studentId+"&schoolId="+schoolId+"&examId="+examId;    
        String fileName ="MS"+schoolId+examId+df.format(d);
            
        File file = new File(Location.getDrivePath(port)+fileName+".html");
        try{      
        URL url = new URL(URL);
        URLConnection conn = url.openConnection();
        // open the stream and put it into BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
      try{ 
         file.createNewFile();
          }catch(Exception e){}
        //use FileWriter to write file
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);
        while ((inputLine = br.readLine()) != null) {
         bw.write(inputLine);
//         System.out.println(inputLine);
        }
        
        bw.close();
        br.close();
        msg=generatePDF(fileName,port);            
      
        }catch(Exception e){msg=e.getMessage();}
        }catch(Exception e){}
        return msg;
    }
//    public static void main(String[] args) {
//        System.out.println(new MarksheetPdfMultipal().urlToHtml("9", "3", "31,32,33",8084));
//    }
}

