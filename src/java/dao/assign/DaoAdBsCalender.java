
package dao.assign;
import model.inventory.AdBsCalender;
import java.util.List;
 public interface  DaoAdBsCalender {
 public String save(AdBsCalender obj);
 public String update(AdBsCalender obj);
 public String delete(AdBsCalender obj);
public List<AdBsCalender> getAll(String hql);
public List getRecord(String sql);
}
