
package dao.consumer;
import java.util.List;
import model.consumer.*;
 public interface  DaoStaffs {
 public String save(Staffs obj);
 public String update(Staffs obj);
 public String delete(Staffs obj);
public String delete(String sql);
public List<Staffs> getAll(String hql);
public List getRecord(String sql);
}
