
package dao.consumer;
import java.util.List;
import model.consumer.*;
 public interface  DaoAttendance {
 public String save(Attendance obj);
 public String update(Attendance obj);
 public String delete(Attendance obj);
public String delete(String sql);
public List<Attendance> getAll(String hql);
public List getRecord(String sql);
}
