package dao.assign;
import model.inventory.AdBsCalender;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.Query;
public class DaoImpAdBsCalender implements DaoAdBsCalender{


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
  @Override
public List<AdBsCalender> getAll(String hql) {
Session session=model.HibernateUtil.getSessionFactory().openSession();
   return session.createQuery(hql).list();
}

@Override
public String save(AdBsCalender obj) {
String msg="Save";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
try{
session.save(obj);
tr.commit();   
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;
}

 @Override
public String update(AdBsCalender  obj) {
   String msg="Update";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
try{
session.update(obj);
tr.commit();   
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;
}

@Override
public String delete(AdBsCalender obj) 
{
   String msg="Delete";
Session session=model.HibernateUtil.getSessionFactory().openSession();
Transaction tr=session.beginTransaction();
try{
session.delete(obj);
tr.commit();   
}catch(Exception e){tr.rollback();msg=model.ExMsg.get(e);}
return msg;

}
}