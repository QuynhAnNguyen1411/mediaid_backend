package com.mediaid.mediaid.util;

import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CommonUtil {
    public static boolean isNullOrEmpty(Object object){
        if (object == null){
            return true;
        }
        if(object instanceof String){
            return ((String) object).isEmpty();
        }
        if (object instanceof List<?>){
            return ((List<?>) object).isEmpty();
        }
        if (object instanceof Map<?,?>){
            return ((Map<?, ?>) object).isEmpty();
        }
        return false;
    }
    public static HashMap<String,String> returnMessage(String key, String value){
        HashMap<String,String> stringStringHashMap = new HashMap<>();
        stringStringHashMap.put(key, value);
        return stringStringHashMap;
    }

    public static Date parseStringToLocalDate(String date) throws ParseException {
        // Define the formatter that matches the date format
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.parse(date);
    }
}
