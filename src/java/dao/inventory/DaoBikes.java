
package dao.inventory;
import java.util.List;
import model.inventory.Bikes;
 public interface  DaoBikes {
 public String save(Bikes obj);
 public String update(Bikes obj);
 public String delete(Bikes obj);
public String delete(String sql);
public List<Bikes> getAll(String hql);
public List getRecord(String sql);
}
