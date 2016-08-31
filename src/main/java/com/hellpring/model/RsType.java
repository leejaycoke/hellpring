package com.hellpring.model;

import java.lang.reflect.Method;
import java.sql.ResultSet;
import java.util.HashMap;
import java.util.Map;

public class RsType {

    public final static Map<String, Method> TYPES = new HashMap<>();

    static {
        try {
            TYPES.put(String.class.getTypeName(), ResultSet.class.getMethod("getString", String.class));
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

}
