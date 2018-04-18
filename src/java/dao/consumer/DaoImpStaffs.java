package dao.consumer;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
import java.util.LinkedList;
import model.consumer.*;
public class DaoImpStaffs implements DaoStaffs{
@Override
public List<Staffs> getAll(String hql) {
Session session=model.HibernateUtil.getSessionFactory().openSession();
return session.createQuery(hql).list();
}
@Override
public String save(Staffs obj) {
String msg="Saved";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
try{
session.save(obj);
tr.commit(); 
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;
}
@Override
public String update(Staffs  obj) {
String msg="Updated";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
 try{
session.update(obj);
tr.commit(); 
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;
}
@Override
public String delete(Staffs obj) 
{
String msg="Delete";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();try{
  session.delete(obj);
tr.commit(); 
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;
}
@Override
public String delete(String sql) {
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

@Override
public List getRecord(String sql)
{
List list=new LinkedList();
Session session=model.HibernateUtil.getSessionFactory().openSession();
try{ 
 list=session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
}catch(Exception e){ list.add(0, model.ExMsg.get(e));}
return list;
}
}