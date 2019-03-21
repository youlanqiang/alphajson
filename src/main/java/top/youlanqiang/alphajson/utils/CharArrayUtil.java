package top.youlanqiang.alphajson.utils;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author youlanqiang
 */
public final class CharArrayUtil {

    private static final String VALUE = "type";

    private static final String END_INDEX = "end";

    public static String arrayToString(final char[] str, int begin, int end) {
        StringBuilder sb = new StringBuilder();
        for (int index = begin; index < end; index++) {
            sb.append(str[index]);
        }
        return sb.toString();
    }

    public static Map<String, Object> arrayToString(final char[] str, int begin, char... conditions) {
        Map<String, Object> map = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (int index = begin; index < str.length - 1; index++) {
            sb.append(str[index]);
            for (char condition : conditions) {
                if (str[index] == condition) {
                    sb.deleteCharAt(sb.length() - 1);
                    map.put(END_INDEX, index);
                    map.put(VALUE, sb.toString());
                    return map;
                }
            }
        }
        map.put(END_INDEX, begin);
        map.put(VALUE, sb.toString());
        return map;
    }
}
