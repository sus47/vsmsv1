
package dao.inventory;
import java.util.List;
import model.inventory.*;
 public interface  DaoLedger {
 public String save(Ledger obj);
 public String update(Ledger obj);
 public String delete(Ledger obj);
public String delete(String sql);
public List<Ledger> getAll(String hql);
public List getRecord(String sql);
}
