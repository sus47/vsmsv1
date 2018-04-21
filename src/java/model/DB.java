/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

/**
 *
 * @author MS
 */
public class DB {

    SessionFactory sessionFactory;

    Session session = null;

    Transaction tr;
    SQLQuery sql;
    String msg;

    public DB() {
        try {
            sessionFactory = new Configuration().configure().buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Exception ex) {
            // Log the exception. 
            System.err.println("Initial SessionFactory creation failed." + ex);
            throw new ExceptionInInitializerError(ex);
        }

    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public SQLQuery getSQL(String sql) {
        return this.sql = session.createSQLQuery(sql);
    }

    public int save(SQLQuery sql, String val[]) {
        tr.begin();
        int a = 0;
        try {
            for (int i = 0; i < val.length; i++) {
                sql.setParameter(i, val[i]);
            }
            a = sql.executeUpdate();
            setMsg("Success");
            tr.commit();
        } catch (Exception e) {
            setMsg(ExMsg.get(e));
            tr.rollback();
        }
        session.close();
        return a;
    }

    public static int save(String sql) {
        int a = 0;
        DB db = new DB();
        try {
            a = db.session.createSQLQuery(sql).executeUpdate();
            db.tr.commit();
            db.setMsg("Success");
        } catch (Exception e) {
            db.setMsg(ExMsg.get(e));
            db.tr.rollback();
        }
        db.session.close();
        return a;
    }

    public int save(SQLQuery sql) {
        int a = 0;
        try {
            a = sql.executeUpdate();
            tr.commit();
            setMsg("Success");
        } catch (Exception e) {
            setMsg(ExMsg.get(e));
            tr.rollback();
        }
        
        return a;
    }

    public List getRecord(String sql) {
        DB db = new DB();
        List list = new LinkedList();
        try {
            list = db.session.createSQLQuery(sql).setResultTransformer(org.hibernate.Criteria.ALIAS_TO_ENTITY_MAP).list();
        } catch (Exception e) {
            list.add(0, model.ExMsg.get(e));
        }
                db.session.close();

        return list;
    }

    public static void main(String[] args) {
        DB db = new DB();
        try {
            List list = db.getRecord("SELECT SYSDATE() AS DATES FROM DUAL");
            Object object = list.get(0);
            Map row = (Map) object;
            System.out.println(row.get("DATES").toString());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.exit(0);
    }

}
