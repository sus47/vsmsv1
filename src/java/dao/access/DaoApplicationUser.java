
package dao.access;
import java.util.List;
import model.access.*;
 public interface  DaoApplicationUser {
 public String save(ApplicationUser obj);
 public String update(ApplicationUser obj);
 public String delete(ApplicationUser obj);
public String delete(String sql);
public List<ApplicationUser> getAll(String hql);
public List getRecord(String sql);
}
