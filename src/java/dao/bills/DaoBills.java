
package dao.bills;
import java.util.List;
import model.bills.*;
 public interface  DaoBills {
 public String save(Bills obj);
 public String update(Bills obj);
 public String delete(Bills obj);
public String delete(String sql);
public List<Bills> getAll(String hql);
public List getRecord(String sql);
}
