
package dao.inventory;
import java.util.List;
import model.inventory.Parts;
 public interface  DaoParts {
 public String save(Parts obj);
 public String update(Parts obj);
 public String delete(Parts obj);
public String delete(String sql);
public List<Parts> getAll(String hql);
public List getRecord(String sql);
}
