
package dao.consumer;
import java.util.List;
import model.consumer.*;
 public interface  DaoCustomers {
 public String save(Customers obj);
 public String update(Customers obj);
 public String delete(Customers obj);
public String delete(String sql);
public List<Customers> getAll(String hql);
public List getRecord(String sql);
}
