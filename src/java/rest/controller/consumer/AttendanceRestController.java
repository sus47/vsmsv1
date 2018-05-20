/*
return "\n{\"sn\": \""+sn+"\",\"staffId\": \""+staffId+"\",\"status\": \""+status+"\",\"attendanceDate\": \""+attendanceDate+"\",\"createdDate\": \""+createdDate+"\",\"attendanceTime\": \""+attendanceTime+"\"}";
 */
package rest.controller.consumer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.General;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.DB;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import rest.controller.ApiBaseController;

@RestController
public class AttendanceRestController {

    GsonBuilder gsonBuilder = new GsonBuilder();
    Gson gson = gsonBuilder.create();
    Map<String, Object> map = new HashMap<String, Object>();
    ObjectMapper mapper = new ObjectMapper();
    dao.consumer.DaoAttendance da = new dao.consumer.DaoImpAttendance();
    ApiBaseController json = new ApiBaseController();
    String msg = "";
    DB db = new DB();

    @RequestMapping(value = "api/consumer/attendance", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String index() {
        return json.respondWithMessage("Success", da.getAll("from Attendance"));
    }

    @RequestMapping(value = "api/consumer/attendance", method = RequestMethod.POST, produces = "application/json")
    @ResponseBody
    public String doSave(@RequestBody String jcson) throws IOException {

        map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
        });

        String attendanceTime = "", status = "", attendanceDate = "";
        model.consumer.Attendance obj = new model.consumer.Attendance();
        List data = da.getRecord("SELECT * FROM Attendance WHERE STAFF_ID='" + map.get("staffId").toString() + "' AND CREATED_DATE = (SELECT MAX(CREATED_DATE) FROM Attendance)");
        System.out.println(data);
        if (data.size() != 0) {
            Map row = (Map) data.get(0);
            try {

                System.out.println("inside try");
                String timestamp = row.get("ATTENDANCE_DATE").toString();
                System.out.println("att: " + timestamp);
                attendanceDate = timestamp.substring(0, 10);
                System.out.println(attendanceDate);
            } catch (Exception e) {
                return json.respondWithError(e.getMessage());
            }
            try {
                status = row.get("STATUS").toString();
                System.out.println(status);
            } catch (Exception e) {
            }
            Date date = new Date();
            SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
            String today = df.format(date);
            if (attendanceDate.equals(today) && status.equals("1")) {
                System.out.println("inside if ");
                return json.respondWithError("Attendance Already Done");
            }
            obj.setStaffId(map.get("staffId").toString());
            obj.setStatus(map.get("status").toString());
            obj.setAttendanceDate(map.get("attendanceDate").toString());
            obj.setCreatedDate(new Date());
            msg = da.save(obj);
            if (msg.equalsIgnoreCase("Saved")) {
                String update = "UPDATE staffs SET ATTENDANCE = IFNULL(ATTENDANCE,0)+1 WHERE STAFF_ID='" + map.get("staffId").toString() + "'";
                msg = General.update(update);
                String sql = "SELECT S.NAME name, S.PHONE phoneNo, A.STAFF_ID staffId, A.STATUS status, A.ATTENDANCE_DATE attendanceDate, A.CREATED_DATE createdDate FROM attendance A, staffs S WHERE A.STAFF_ID = S.STAFF_ID";
                List list = db.getRecord(sql);
                return json.respondWithMessage("Success", gson.toJson(list));
            }
            return json.respondWithError(msg);
        } else {
            obj.setStaffId(map.get("staffId").toString());
            obj.setStatus(map.get("status").toString());
            obj.setAttendanceDate(map.get("attendanceDate").toString());
            obj.setCreatedDate(new Date());
            msg = da.save(obj);
            if (msg.equalsIgnoreCase("Saved")) {
                String update = "UPDATE staffs SET ATTENDANCE = IFNULL(ATTENDANCE,0)+1 WHERE STAFF_ID='" + map.get("staffId").toString() + "'";
                msg = General.update(update);
                String sql = "SELECT S.NAME name, S.PHONE phoneNo, A.STAFF_ID staffId, A.STATUS status, A.ATTENDANCE_DATE attendanceDate, A.CREATED_DATE createdDate FROM attendance A, staffs S WHERE A.STAFF_ID = S.STAFF_ID";
                List list = db.getRecord(sql);
                return json.respondWithMessage("Success", gson.toJson(list));
            }
            return json.respondWithError(msg);
        }
    }

    @RequestMapping(value = "api/staff/attendance", method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String preview(@RequestBody String jcson,@RequestParam(value = "date", required = true) String attendanceDate) throws IOException {
       try{
        String sql="SELECT STAFF_ID staffId, NAME name, PHONE phone, ATTENDANCE presentDays, (-DATEDIFF('"+attendanceDate+"',LAST_DAY('"+attendanceDate+"'))-ATTENDANCE) absentDays FROM staffs";
        List list = db.getRecord(sql);
        return json.respondWithMessage("Success", gson.toJson(list));
       }catch(Exception ex){
           msg = ex.getMessage();
           return json.respondWithMessage(msg);
       }
    }

    @RequestMapping(value = "api/consumer/attendance/{sn}", method = RequestMethod.PUT, produces = "application/json")
    @ResponseBody
    public String doUpdate(@RequestBody String jcson, @PathVariable String sn) throws IOException {
        try {
            map = mapper.readValue(jcson, new TypeReference<Map<String, String>>() {
            });

            model.consumer.Attendance obj = new model.consumer.Attendance();
            /*obj.setSn(map.get("sn").toString());
obj.setStaffId(map.get("staffId").toString());
obj.setStatus(map.get("status").toString());
obj.setAttendanceDate(map.get("attendanceDate").toString());
obj.setCreatedDate(map.get("createdDate").toString());
obj.setAttendanceTime(map.get("attendanceTime").toString());
             */
            msg = da.update(obj);
            if (msg.equalsIgnoreCase("Updated")) {
                return json.respondWithMessage("Updated successfully", gson.toJson(da.getAll(" from Attendance")));
            }
        } catch (Exception e) {
            msg = e.getMessage() + " " + jcson;
        }
        return json.respondWithError(msg);
    }

    @RequestMapping(value = "api/consumer/attendance/{sn}", method = RequestMethod.DELETE, produces = "application/json")
    @ResponseBody
    public String doDelete(@PathVariable String sn) {
        sn = sn.replaceAll("\"", "'");
        String sql = "DELETE FROM AttendanceWHERE sn IN " + sn + " ";
        msg = da.delete(sql);
        if (msg.indexOf("Record Deleted") >= 0) {
            return json.respondWithMessage("Record Deleted successfully", gson.toJson(da.getAll(" from Attendance")));
        } else {
            return json.respondWithError(msg);
        }
    }
}
