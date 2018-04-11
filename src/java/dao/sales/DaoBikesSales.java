
package dao.sales;
import java.util.List;
import model.sales.*;
 public interface  DaoBikesSales {
 public String save(BikesSales obj);
 public String update(BikesSales obj);
 public String delete(BikesSales obj);
public String delete(String sql);
public List<BikesSales> getAll(String hql);
public List getRecord(String sql);
}
