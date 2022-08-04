package com.unique.app.setting;

import org.apache.tomcat.util.codec.binary.Base64;

import java.io.*;
import java.nio.charset.Charset;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class StringUtil {
    private static final String EMPTY_STRING    = "";
    public static final Charset CHARSET_ISO_8859_1  = Charset.forName("ISO-8859-1");
    public static final Charset CHARSET_UTF_8       = Charset.forName("UTF-8");
    public static final Charset CHARSET_MS949       = Charset.forName("MS949");
    public static final Charset CHARSET_KSC5601     = Charset.forName("KSC5601");
    public static final String CR                   = "\r";
    private static final char[] CA                  = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/".toCharArray();

    public StringUtil() {}

    public static String convertYn(String var0) {
        if (var0 == null) {
            return "";
        } else if (var0.trim().toUpperCase().equals("Y")) {
            return "예";
        } else {
            return var0.trim().toUpperCase().equals("N") ? "아니오" : "";
        }
    }

    public static String insert(String var0, int var1, String var2) {
        String var3 = null;
        int var4    = var1;
        StringBuilder var5 = new StringBuilder();
        int var6 = var0.length();

        if (var1 >= 0) {
            if (var6 < var1) {
                var4 = var6;
            }
            var5.append(var0.substring(0, var4));
            var5.append(var2);
            var5.append(var0.substring(var4));
        } else {
            if (var6 < Math.abs(var1)) {
                var4 = var6 * -1;
            }
            var5.append(var0.substring(0, var6 -1 + var4));
            var5.append(var2);
            var5.append(var0.substring(var6 -1 + var4));
        }
        var3 = var5.toString();
        return var3;
    }

    public static String insertAndOverwrite(String var0, int var1, String var2) {
        int var3 = var1;
        String var4 = null;
        StringBuilder var5 = new StringBuilder();
        int var6 = var0.length();

        if (var1 >= 0) {
            if (var6 < var1) {
                var3 = var6;
            }
            var5.append(var0.substring(0, var3));
            var5.append(var2);
            var5.append(var0.substring(var3 + var2.length()));
        } else {
            if (var6 < Math.abs(var1)) {
                var3 = var6 * -1;
            }
            var5.append(var0.substring(0, var6 - 1 + var3));
            var5.append(var2);
            var5.append(var0.substring(var6 - 1 + var3 + var2.length()));
        }
        var4 = var5.toString();
        return var4;
    }

    public static String delete (String var0, String var1) {
        return replace(var0, var1, "");
    }

    public static String replace(String var0, String var1, String var2) {
        StringBuilder var3 = new StringBuilder();
        String var4 = "";
        String var5 = var0;
        String var6 = var0;

        while(var6.indexOf(var1) >= 0) {
            var4 = var6.substring(0, var6.indexOf(var1));
            var5 = var6.substring(var6.indexOf(var1) + var1.length(), var6.length());
            var6 = var5;
            var3.append(var4).append(var2);
        }
        var3.append(var5);
        return var3.toString();
    }

    public static String[] split(String var0, String var1) {
        if (var0 == null) {
            return new String[0];
        } else if (var1 != null && var1.length() != 0) {
            String[] var2 = null;
            int var3 = 1;
            int var4 = var0.indexOf(var1);

            int var5;
            for(var5 = 0; var4 >= 0; var4 = var0.indexOf(var1, var4 + 1)) {
                ++var3;
            }
            var2 = new String[var3];
            var3 = 0;

            for(var4 = var0.indexOf(var1); var5 >= 0; ++var3) {
                var2[var3] = var0.substring(var5, var4);
                var5 = var4 + 1;
                var4 = var0.indexOf(var1, var4 + 1);
            }
            var2[var3] = var0.substring(var5);
            return var2;
        } else {
            return new String[]{var0};
        }
    }

    public static String[] split(String var0, String var1, boolean var2) {
        ArrayList var3 = new ArrayList();
        Pattern var4 = Pattern.compile(var1);
        Matcher var5 = var4.matcher(var0);

        int var6;
        for(var6 = 0; var5.find(); var6 = var5.end()) {
            String var7 = var0.subSequence(var6, var5.start()).toString();
            var3.add(var7);
        }
        if (var6 == 0) {
           return new String[] {var0};
        } else {
            var3.add(var0.subSequence(var6, var0.length()).toString());
            int var9 = var3.size();

            if (!var2) {
                for(int var8 = 0; var8 < var3.size(); ++var8) {
                    if (((String)var3.get(var8)).equals("")) {
                        --var9;
                    }
                }
            }
            String[] var10 = new String[var9];
            return (String[])var3.subList(0, var9).toArray(var10);
        }
    }

    public static String[] split(String var0, String var1, int var2) throws NullPointerException {
        String[] var3 = new String[var2];
        int var4 = 0;
        int var5 = 0;

        for(int var6 = var0.indexOf(var1); var6 >= 0 && var4 < var2 - 1; ++var4) {
            var3[var4] = var0.substring(var5, var6);
            var5 = var6 + 1;
            var6 = var0.indexOf(var1, var6 + 1);
        }
        var3[var4] = var0.substring(var5);
        if (var4 < var2 - 1) {
            for(int var7 = var4 + 1; var7 < var2; ++var7) {
                var3[var7] = "";
            }
        }
        return var3;
    }

    public static String[] splitByBytes(String var0, int var1, String var2) throws UnsupportedEncodingException {
        if (var0 == null) {
            return null;
        } else {
            String[] var3 = null;
            byte[] var4 = var0.getBytes(var2);
            int var5 = var4.length;
            int var6 = var2.equalsIgnoreCase("UTF-8") ? 3 : 2;
            int var7 = 0;
            boolean var8 = false;
            boolean var9 = false;

            if (var5 > var1) {
                int var10 = var5 / var1 + (var5 % var1 == 0 ? 0 : 1);
                var3 = new String[var10];

                for(int var11 = 0; var11 < var10; ++var11) {
                    int var13 = 0;
                    int var14 = var1;

                    if (var7 + var1 > var4.length) {
                        var14 = var4.length - var7;
                    }

                    for(int var12 = 0; var12 < var14; ++var12) {
                        if ((var4[var7 + var12] & 128) != 0) {
                            ++var13;
                        }
                    }
                    if (var13 % var6 != 0) {
                        var14 -= var13 % var6;
                    }
                    var3[var11] = new String(var4, var7, var14, var2);
                    var7 += var14;
                }
            } else {
                var3 = new String[]{var0};
            }
            return var3;
        }
    }

    public static int search(String var0, String var1) {
        int var2 = 0;
        String var3 = var0;

        for(int var4 = 0; var4 < var0.length(); var3 = var3.substring(var4)) {
            int var5 = var3.indexOf(var1);
            if (var5 == -1) {
                break;
            }
            ++var2;
            var4 = var5 + var1.length();
        }
        return var2;
    }

    public static String replaceEscapingDollarSign(String var0) {
        return replace(var0, "$", "\\$");
    }

    public static String token(String var0, String var1, int var2) {
        if (var0 == null) {
            return null;
        } else {
            StringTokenizer var3 = new StringTokenizer(var0, var1);
            int var4 = 0;

            while(var3.hasMoreTokens()) {
                if(var4++ == var2) {
                    return var3.nextToken();
                }
                var3.nextToken();
            }
            return null;
        }
    }

    public static String[] divide(String var0, String var1) {
        if (var0 == null) {
            return new String[] {""};
        } else if (var1 != null && var1.length() != 0) {
            int var2 = var0.indexOf(var1);
            return var2 < 0 ? new String[] {var0, ""} : new String[]{var0.substring(0, var2), var0.substring(var2 + var1.length())};
        } else {
            return new String[]{var0, ""};
        }
    }

    public static String toLowerCaseFirstLetter(String var0) {
        return var0 != null && var0.length() >= 1 ? var0.substring(0, 1).toLowerCase() + var0.substring(1) : var0;
    }

    public static String encodeBase64(Object var0) throws IOException {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        ObjectOutputStream var2 = new ObjectOutputStream(var1);
        var2.writeObject(var0);
        return (new Base64()).encodeToString(var1.toByteArray());
    }

    public static Object decodeBase64(String var0) throws IOException, ClassNotFoundException {
        ByteArrayInputStream var1 = new ByteArrayInputStream((new Base64()).decode(var0));
        ObjectInputStream var2 = new ObjectInputStream(var1);
        return var2.readObject();
    }

    public static String leftPad(String var0, byte var1, int var2) {
        String var3 = var0;
        if (var0 == null) {
            var3 = "";
        }
        byte[] var4;
        try {
            var4 = var3.getBytes("ksc5601");
        } catch (Exception var9) {
            return var3;
        }

        if (var2 <= var4.length) {
            return var3;
        } else {
            byte[] var5 = new byte[var2];
            int var6 = var2 - 1;

            for(int var7 = var4.length - 1; var7 >= 0; --var7) {
                var5[var6--] = var4[var7];
            }
            while(var6 >= 0) {
                var5[var6] = var1;
                --var6;
            }

            try {
                return new String(var5, "ksc5601");
            } catch (Exception var8) {
                return var3;
            }
        }
    }

    public static String rightPad(String var0, byte var1, int var2) {
        String var3 = var0;
        if (var0 == null) {
            var3 = "";
        }
        byte[] var4;
        try {
            var4 = var3.getBytes("ksc5601");
        } catch (Exception var9) {
            return var3;
        }

        if (var2 <= var4.length) {
            return var3;
        } else {
            byte[] var5 = new byte[var2];
            int var6 = 0;

            for(int var7 = 0; var7 < var4.length; ++var7) {
                var5[var6++] = var4[var7];
            }

            while(var6 < var2) {
                var5[var6] = var1;
                ++var6;
            }

            try {
                return new String(var5, "ksc5601");
            } catch (Exception var8) {
                return var3;
            }
        }
    }

    public static String strip(String var0, String var1) {
        if (var0 != null && var0.length() != 0 && var1 != null) {
            StringBuilder var2 = new StringBuilder();
            StringTokenizer var3 = new StringTokenizer(var0, var1);

            while(var3.hasMoreTokens()) {
                var2.append(var3.nextToken());
            }
            return var2.toString();
        } else {
            return var0;
        }
    }

    public static String stripHyphen(String var0) {
        String var1 = var0;
        if (var0 == null) {
            return null;
        } else {
            while(true) {
                int var2 = var1.indexOf("-");
                if (var2 < 0) {
                    return var1;
                }
                var1 = var1.substring(0, var2) + var1.substring(var2 + 1);
            }
        }
    }

    public static String toUpperCaseFirstLetter(String var0) {
        return var0 != null && var0.length() >= 1 ? var0.substring(0, 1).toUpperCase() + var0.substring(1) : var0;
    }

    public static String arrayToString(String[] var0, String var1) {
        StringBuilder var2 = new StringBuilder();
        if (var0 != null && var0.length >= 1) {
            var2.append(var0[0]);

            for(int var3 = 1; var3 < var0.length; ++var3) {
                var2.append(var1).append(var0[var3]);
            }
            return var2.toString();
        } else {
            return "";
        }
    }

    public static String java2mysql(String var0) {
        if (var0 == null) {
            return null;
        } else {
            StringBuilder var1 = new StringBuilder();
            char[] var2 = var0.toCharArray();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == '\n') {
                    var1.append("\\n");
                } else if (var2[var4] == '\t') {
                    var1.append("\\t");
                } else if (var2[var4] == '\r') {
                    var1.append("\\r");
                } else if (var2[var4] == '\'') {
                    var1.append("\'");
                } else if (var2[var4] == '"') {
                    var1.append("\\\"");
                } else if (var2[var4] == '%') {
                    var1.append("\\%");
                } else {
                    var1.append(var2[var4]);
                }
            }
            return var1.toString();
        }
    }

    public static String java2msg(String var0) {
        if (var0 == null) {
            return null;
        } else {
            StringBuilder var1 = new StringBuilder();
            char[] var2 = var0.toCharArray();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == '\n') {
                    var1.append("\\n");
                } else if (var2[var4] == '\t') {
                    var1.append("\\t");
                } else {
                    var1.append(var2[var4]);
                }
            }
            return var1.toString();
        }
    }

    public static String java2html(String var0) {
        if (var0 == null) {
            return null;
        } else {
            StringBuilder var1 = new StringBuilder();
            char[] var2 = var0.toCharArray();
            int var3 = var2.length;

            for(int var4 = 0; var4 < var3; ++var4) {
                if (var2[var4] == '&') {
                    var1.append("&amp;");
                } else if (var2[var4] == '<') {
                    var1.append("&lt;");
                } else if (var2[var4] == '>') {
                    var1.append("&gt;");
                } else if (var2[var4] == '"') {
                    var1.append("&quot;");
                } else if (var2[var4] == '\'') {
                    var1.append("&#039;");
                } else {
                    var1.append(var2[var4]);
                }
            }
            return var1.toString();
        }
    }

    public static String toOneLine(String var0) {
        return var0 == null ? null : var0.replace('\n', ' ');
    }

    public static String print(String var0, String var1) {
        if (var0 == null) {
            return "";
        } else if (var1 == null) {
            return var0;
        } else {
            int var2 = 0;
            StringBuilder var3 = new StringBuilder();

            for(int var4 = 0; var4 < var1.length(); ++var4) {
                if (var1.charAt(var4) == '#') {
                    if (var2 >= var0.length()) {
                        return var3.toString();
                    }
                    var3.append(var0.charAt(var2++));
                } else {
                    var3.append(var1.charAt(var4));
                }
            }
            return var3.toString();
        }
    }

    public static String print(Date var0, String var1, Locale var2) {
        if (var0 == null) {
            return "";
        } else {
            return var1 != null && var2 != null ? (new SimpleDateFormat(var1, var2)).format(var0) : var0.toString();
        }
    }

    public static String print(Number var0, String var1) {
        if (var0 == null) {
            return "";
        } else {
            return var1 == null ? var0.toString() : (new DecimalFormat(var1)).format(var0);
        }
    }

    public static String getCalcStr(String var0, int var1, int var2) {
        String var3 = "";

        try {
            var3 = new String(var0.getBytes(), var1, var2 - var1);
            return var3;
        } catch (Exception var5) {
            return var0;
        }
    }

    public static String makeRepeatString(String var0, int var1) {
        StringBuilder var2 = new StringBuilder();

        for(int var3 = 0; var3 < var1; ++var3) {
            var2.append(var0);
        }
        return var2.toString();
    }

    public static String escapeBackslashAndLollarSign(String var0) {
        if (var0.indexOf(92) == -1 && var0.indexOf(36) == -1) {
            return var0;
        } else {
            StringBuilder var1 = new StringBuilder();

            for(int var2 = 0; var2 < var0.length(); ++var2) {
                char var3 = var0.charAt(var2);

                if(var3 == '\\') {
                    var1.append('\\').append('\\');
                } else if (var3 == '$') {
                    var1.append('\\').append('$');
                } else {
                    var1.append(var3);
                }
            }
            return var1.toString();
        }
    }

    public static String escapeBackslash(String var0) {
        return escapeCharacter(var0, '\\');
    }

    public static String escapeDollarSign(String var0) {
        return escapeCharacter(var0, '$');
    }

    public static String escapeCharacter(String var0, char var1) {
        if (var0.indexOf(var1) == -1) {
            return var0;
        } else {
            StringBuilder var2 = new StringBuilder();

            for(int var3 = 0; var3 < var0.length(); ++var3) {
                char var4 = var0.charAt(var3);

                if(var4 == var1) {
                    var2.append('\\').append(var1);
                } else {
                    var2.append(var4);
                }
            }
            return var2.toString();
        }
    }

    public static String insertDelimToString(String var0, char var1) {
        StringBuilder var2 = new StringBuilder();
        char[] var3 = var0.toCharArray();

        for(int var4 = 0; var4 < var3.length; ++var4) {
            if (var4 == 0) {
                if (var3[var4] == var1) {
                    var2.append(var1).append(var3[var4]);
                } else {
                    var2.append(var3[var4]);
                }
            } else if (var4 == var3.length - 1) {
                if (var3[var4 - 1] == var1) {
                    var2.append(var1).append(var3[var4]);
                } else {
                    var2.append(var3[var4]);
                }
            } else if (var3[var4] == var1 && var3[var4 - 1] != var1) {
                var2.append(var1).append(var3[var4]);
            } else {
                var2.append(var3[var4]);
            }
        }
        return var2.toString();
    }

    public static String getStackTrace(Throwable var0) {
        ByteArrayOutputStream var1 = new ByteArrayOutputStream();
        PrintStream var2 = new PrintStream(var1);
        var0.printStackTrace(var2);
        return var1.toString();
    }

    public static String toLowerCase(String var0) {
        return var0 == null ? null : var0.toLowerCase();
    }

    public static String toUpperCase(String var0) {
        return var0 == null ? null : var0.toUpperCase();
    }

    public static String trim(String var0) {
        return var0 == null ? null : var0.trim();
    }

    public static int compareTo(String var0, String var1) {
        return var0 != null && var1 != null ? var0.compareTo(var1) : -1;
    }

    public static int compreToIgnoreCase(String var0, String var1) {
        return var0 != null && var1 != null ? var0.compareToIgnoreCase(var1) : -1;
    }

    public static String objectToString(Object var0) {
        String var1 = "";
        if(var0 != null) {
            var1 = var0.toString().trim();
        }
        return var1;
    }

    public static String remove(String var0, char var1) {
        if (!NullUtils.isNone(var0) && var0.indexOf(var1) != -1) {
            char[] var2 = var0.toCharArray();
            int var3 = 0;

            for(int var4 = 0; var4 < var2.length; ++var4) {
                if (var2[var4] != var1) {
                    var2[var3++] = var2[var4];
                }
            }
            return new String(var2, 0, var3);
        } else {
            return var0;
        }
    }

    public static String removeCommaChar(String var0) {
        return remove(var0, ',');
    }

    public static String removeMinusChar(String var0) {
        return remove(var0, '-');
    }

    public static String removeWhitespace(String var0) {
        if (NullUtils.isNone(var0)) {
            return var0;
        } else {
            int var1 = var0.length();
            char[] var2 = new char[var1];
            int var3 = 0;

            for(int var4 = 0; var4 < var1; ++var4) {
                if (!Character.isWhitespace(var0.charAt(var4))) {
                    var2[var3++] = var0.charAt(var4);
                }
            }
            if (var3 == var1) {
                return var0;
            } else {
                return new String(var2, 0, var3);
            }
        }
    }

    public static String substringThenAddString(String var0, int var1, String var2) {
        String var3 = null;

        if (var0 != null) {
            if (var0.length() > var1) {
                var3 = var0.substring(0, var1) + var2;
            } else {
                var3 = var0;
            }
        }
        return var3;
    }

    public static String substringByBytes(String var0, int var1) {
        String var2 = var0;

        if (var0 == null) {
            return var0;
        } else {
            int var3 = var0.length();
            int var4 = 0;
            int var5 = 0;

            while(var5 < var3 && var4 < var1) {
                if (var2.charAt(var5++) < 256) {
                    ++var4;
                } else {
                    var4 += 2;
                }
            }
            if (var5 < var3) {
                var2 = var2.substring(0, var5);
            }
            return var2;
        }
    }

    public static String substring(String var0, int var1) {
        return substringThenAddString(var0, var1, "");
    }

    public static String format(String var0, String var1, boolean var2) {
        if (!var2) {
            return a(var0, var1);
        } else {
            StringBuilder var3 = new StringBuilder();
            int var4 = 0;

            for(int var5 = 0; var5 < var0.length(); ++var5) {
                if (var0.charAt(var5) == '#') {
                    if (var4 < var1.length()) {
                        var3.append(var1.charAt(var4++));
                    }
                } else if (var0.charAt(var5) == '\\') {
                    if (var5 + 1 < var0.length() && var0.charAt(var5 + 1) == '#') {
                        var3.append("#");
                        ++var5;
                    } else if (var5 + 1 < var0.length() && var0.charAt(var5 + 1) == '\\') {
                        var3.append("\\");
                        ++var5;
                    } else {
                        var3.append(var0.charAt(var5));
                    }
                } else {
                    var3.append(var0.charAt(var5));
                }
            }
            return var3.toString();
        }
    }

    private static String a(String var0, String var1) {
        StringBuilder var2 = new StringBuilder();
        int var3 = var1.length() - 1;

        for(int var4 = var0.length() - 1; var4 >= 0; --var4) {
            if (var0.charAt(var4) == '#') {
                if (var4 - 2 >= 0 && var0.charAt(var4 - 1) == '\\' && var0.charAt(var4 - 2) != '\\') {
                    var2.insert(0, "#");
                    --var4;
                } else if (var3 >= 0) {
                    var2.insert(0, var1.charAt(var3--));
                }
            } else if (var0.charAt(var4) == '\\') {
                if (var4 - 1 >= 0 && var0.charAt(var4 - 1) == '\\') {
                    var2.insert(0, "\\");
                    --var4;
                } else {
                    var2.insert(0, var0.charAt(var4));
                }
            } else {
                var2.insert(0, var0.charAt(var4));
            }
        }
        return var2.toString();
    }

    public static String maskValue(String var0, String var1) {
        char[] var2 = new char[var0.length()];
        int var3 = var1.length();

        for(int var4 = 0; var4 < var0.length(); ++var4) {
            var2[var4] = var4 < var3 && var1.charAt(var4) == '*' ? 42 : var0.charAt(var4);
        }
        var0 = new String(var2);
        return var0;
    }

    public static String coverStringMessageBox(String var0, String var1, String var2) {
        if (var0 == null) {
            return null;
        } else {
            StringBuilder var3 = new StringBuilder();
            String[] var4 = var0.split("\n");
            int var5 = 0;

            for(int var6 = 0; var6 < var4.length; ++var6) {
                if (var6 == 0) {
                    var5 = var4[var6].length();
                } else if (var4[var6].length() > var5) {
                    var5 = var4[var6].length();
                }
            }
            byte var9 = 2;
            int var7 = var5 + (var9 + 1) * 2;
            var3.append("\n");
            int var8;
            if (var2 == null) {
                var3.append("\t" + makeRepeatString(var1, var7) + "\n");
            } else {
                var8 = (var7 - var2.length()) / 2;
                var3.append("\t" + makeRepeatString(var1, var8) + var2 + makeRepeatString(var1, var7 - var2.length() - var8) + "\n");
            }
            var3.append("\t" + var1 + makeRepeatString(" ", var7 - 2) + var1 + "\n");

            for(var8 = 0; var8 < var4.length; ++var8) {
                var3.append("\t" + var1 + makeRepeatString(" ", var9) + var4[var8] + makeRepeatString(" ", var9 + var5 - var4[var8].length()) + var1);
                var3.append("\n");
            }
            var3.append("\t" + var1 + makeRepeatString(" ", var7 - 2) + var1 + "\n");
            var3.append("\t" + makeRepeatString(var1, var7) + "\n");
            return var3.toString();
        }
    }

    public static boolean isEmpty(CharSequence var0) {
        return StringUtils.isEmpty(var0);
    }

    public static boolean isNotEmpty(CharSequence var0) {
        return StringUtil.isNotEmpty(var0);
    }

    public static boolean isAnyEmpty(CharSequence var0) {
        return StringUtil.isEAnyEmpty(var0);
    }

    public static boolean isEmpty(CharSequence var0) {
        return StringUtil.isEmpty(var0);
    }

    public static boolean isEmpty(CharSequence var0) {
        return StringUtil.isEmpty(var0);
    }

    public static boolean isEmpty(CharSequence var0) {
        return StringUtil.isEmpty(var0);
    }
    public static boolean isEmpty(CharSequence var0) {
        return StringUtil.isEmpty(var0);
    }

    public static boolean isEmpty(CharSequence var0) {
        return StringUtil.isEmpty(var0);
    }

}
