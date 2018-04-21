package jsp;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

public class Test {

    public static void mainss(String[] args) {
        String jcson = "{\"message\":\"Success\",\"data\":[{\"sn\":20,\"studentName\":\"Astha Sharma\"},{\"sn\":21,\"studentName\":\"Sarmila\"},{\"sn\":22,\"studentName\":\"Ramesh Dai\"}]}";
        Map<String, Object> map = new HashMap<String, Object>();
        ObjectMapper mapper = new ObjectMapper();
        try {
            map = mapper.readValue(jcson.substring(0, jcson.indexOf(",\"data\":")) + "}", new TypeReference<Map<String, String>>() {
            });
            System.out.println(map.get("message"));
        } catch (Exception e) {
        }
        com.fasterxml.jackson.databind.ObjectMapper objectMapper = new com.fasterxml.jackson.databind.ObjectMapper();
        List list = null;
        try {
            list = objectMapper.readValue(jcson.substring(jcson.indexOf("["), jcson.indexOf("]") + 1), new com.fasterxml.jackson.core.type.TypeReference<List>() {
            });
            for (int i = 0; i < list.size(); i++) {
                for (Object object : list) {
                    Map row = (Map) object;
                    System.out.println(row.get("sn") + " " + row.get("studentName"));
                }
            }
        } catch (Exception e) {
            System.out.println("list " + e.getMessage());
        }

    }

    public static void main(String[] args) throws UnsupportedEncodingException {
        final String receivedText = "à¤?à¤?à¤ªà¥?à¤¯à¥?à¤?à¤°";

        final Charset fromCharset = Charset.forName("x-ISCII91");
        final CharBuffer decoded = fromCharset.decode(ByteBuffer.wrap(receivedText.getBytes("windows-1252")));

        final Charset toCharset = Charset.forName("UTF-8");
        final byte[] encoded = toCharset.encode(decoded).array();
        String s = new String(encoded, toCharset.displayName());
        System.out.println(s);
    }
}
