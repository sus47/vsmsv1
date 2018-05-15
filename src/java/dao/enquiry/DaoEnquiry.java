
package dao.enquiry;
import java.util.List;
import model.enquiry.*;
 public interface  DaoEnquiry {
 public String save(Enquiry obj);
 public String update(Enquiry obj);
 public String delete(Enquiry obj);
public String delete(String sql);
public List<Enquiry> getAll(String hql);
public List getRecord(String sql);
}
