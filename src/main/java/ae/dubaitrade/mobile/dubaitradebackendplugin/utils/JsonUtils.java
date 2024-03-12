package ae.dubaitrade.mobile.dubaitradebackendplugin.utils;


import org.json.JSONObject;

public class JsonUtils {
    public static boolean isValidJson(String json) {
        try {
            new JSONObject(json);
            return true;
        } catch (Exception e) {
            System.err.println("Invalid JSON: " + e.getMessage());
            return false;
        }
    }
}
