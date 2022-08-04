package com.unique.app.setting;

import java.util.List;
import java.util.Map;

public class NullUtils {
    public NullUtils() {}

    public static boolean isNull(Object var0) {
        return var0 == null;
    }

    public static boolean isNone(String var0) {
        return var0 == null || var0.length() == 0;
    }

    public static boolean notNone(String var0) {
        return var0 != null && var0.length() > 0;
    }

    public static boolean isNone(List var0) {
        return var0 == null || var0.size() == 0;
    }

    public static boolean isNone(Object[] var0) {
        return var0 == null || var0.length == 0;
    }

    public static boolean isNone(Map var0) {
        return var0 == null || var0.size() == 0;
    }

    public static String nvl(String var0, String var1) {
        return var0 != null && var0.length() >= 1 ? var0 : var1;
    }

    public static String nvl(Object var0, String var1) {
        return var0 == null ? var1 : nvl(var0.toString(), var1);
    }

    public static String print(Object var0) {
        return var0 == null ? "" : var0.toString();
    }
}
