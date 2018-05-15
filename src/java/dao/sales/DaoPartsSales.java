
package dao.sales;
import java.util.List;
import model.sales.*;
 public interface  DaoPartsSales {
 public String save(PartsSales obj);
 public String update(PartsSales obj);
 public String delete(PartsSales obj);
public String delete(String sql);
public List<PartsSales> getAll(String hql);
public List getRecord(String sql);
}
