
package dao.inventory;
import java.util.List;
import model.inventory.*;
 public interface  DaoBikesPriceUpdates {
 public String save(BikePriceUpdates obj);
 public String update(BikePriceUpdates obj);
 public String delete(BikePriceUpdates obj);
public String delete(String sql);
public List<BikePriceUpdates> getAll(String hql);
public List getRecord(String sql);
}
