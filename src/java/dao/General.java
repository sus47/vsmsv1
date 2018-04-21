/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class General {
public List getRecord(String sql)
{
List list=new LinkedList();
Session session=model.HibernateUtil.getSessionFactory().openSession();
try{ 
 list=session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
}catch(Exception e){ list.add(0, model.ExMsg.get(e));}
return list;
}
    
 public static String update(String sql) {
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
String msg="";
try{ 
int count= session.createSQLQuery(sql).executeUpdate();
tr.commit();
return msg=count+" Record Updated";
}catch(Exception e){ tr.rollback();msg=model.ExMsg.get(e); }
return msg;
    }
 public int save(String sql) 
 {
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
try{ 
int count= session.createSQLQuery(sql).executeUpdate();
tr.commit();
return count;
}catch(Exception e){ tr.rollback(); }
return 0;
}
    
public static String delete(String sql) {
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
String msg="";
try{ 
int count= session.createSQLQuery(sql).executeUpdate();
tr.commit();
return msg=count+" Record Deleted";
}catch(Exception e){ tr.rollback();msg=model.ExMsg.get(e); }
return msg;
    }
}
