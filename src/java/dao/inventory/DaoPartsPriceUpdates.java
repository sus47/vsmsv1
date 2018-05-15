
package dao.inventory;
import java.util.List;
import model.inventory.*;
 public interface  DaoPartsPriceUpdates {
 public String save(PartsPriceUpdates obj);
 public String update(PartsPriceUpdates obj);
 public String delete(PartsPriceUpdates obj);
public String delete(String sql);
public List<PartsPriceUpdates> getAll(String hql);
public List getRecord(String sql);
}
