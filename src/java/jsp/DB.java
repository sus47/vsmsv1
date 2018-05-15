
        package jsp;

import java.util.Random;

        public class DB {
        private  String url="",uid="",password="",driver="",db="";
        public java.sql.Connection con;
        public java.sql.PreparedStatement ps;
        public java.sql.ResultSet rs;

        private void init()
        {
        db="rps";

        url="jdbc:mysql://localhost:3306/"+db;
        uid="rps_admin";
        password="managerRPS";

        driver="com.mysql.jdbc.Driver";
        }
        public String toDb() {return db;}
        public String toUser() {return uid;}
        public String toPass() {return password;}
        public DB()
        {
        try{  
        init();
        Class.forName(driver);          
        con=java.sql.DriverManager.getConnection(url, uid, password);            
        }catch(Exception e){}
        }
        public DB(int i)
        {
        try{             
        init();
        Class.forName(driver);
        con=java.sql.DriverManager.getConnection(url, uid, password);      
        ps=con.prepareStatement("SELECT SYSDATE() FROM DUAL");
       }catch(Exception e){}
        }
         public DB(String sql)
        {
        try{             
        init();
        Class.forName(driver);
        con=java.sql.DriverManager.getConnection(url, uid, password);      
        ps=con.prepareStatement(sql);
       }catch(Exception e){}
        }
         
        public String getCon(String sql)
        {
        String msg="SQL Success";
        try{       
        ps=con.prepareStatement(sql);  
        }catch(Exception e)
        {
        msg=e.getMessage()+"<br>"+sql;
        }
        return msg;
        }
        public void close()
        {
        try{
        con.close();    
        ps.close();
        rs.close();
        }catch(Exception e){}
        }
//            public static void main(String[] args) {
//                 Random rand = new Random();
//                 String rn=String.valueOf(rand.nextGaussian());
//                rn= rn.substring(rn.indexOf(".")+1);
//                System.out.println(rn);
//            }
        }

