package editor.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import editor.message.messages.JoinMessage;

/**
 * convert between json string to object
 * here the code get from internet
 */
public class JsonUtil {

    /**
     * convert object to json string
     * @param obj
     * @return
     */
    public static String convertObjectToJSON(Object obj) {
        try {
            String text = JSON.toJSONString(obj);
            return text;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * convert string to object
     */

    public static <T> T convertStringToObject(String data, Class<T> clzss) {
        try {
            T t = JSON.parseObject(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * convert JSONObject to Object
     * @param data
     * @param clzss
     * @param <T>
     * @return
     */
    public static <T> T convertJSONToObject(JSONObject data, Class<T> clzss) {
        try {
            T t = JSONObject.toJavaObject(data, clzss);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * convert string to jsonobject
     * @param text
     * @return
     */
    public static JSONObject convertStringToJSONObject(String text){
        try {
            JSONObject jsonObject=JSONObject.parseObject(text);
            return jsonObject;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> T convertJSONToObject(JSONObject data, TypeReference<T> type) {
        try {
            T t = JSONObject.parseObject(data.toJSONString(), type);
            return t;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }






}
