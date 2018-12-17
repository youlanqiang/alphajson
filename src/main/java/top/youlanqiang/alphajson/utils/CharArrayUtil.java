package top.youlanqiang.alphajson.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * char数组工具类
 * @author youlanqiang
 *
 */
public final class CharArrayUtil {
	
	private static final String VALUE = "value";
	
	private static final String END_INDEX = "end";

	public static String arrayToString(final char[] str, int start, int end) {
		StringBuilder sb = new StringBuilder();
		for(;start<end;start++) {
			sb.append(str[start]);
		}
		return sb.toString();
	}
	
	public static Map<String,Object> arrayToString(final char[] str, int start, char... conditions) {
		Map<String,Object> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(;start<str.length-1;start++) {
			sb.append(str[start]);
			for(char condition:conditions) {
				if(str[start]==condition) {
					//当前位为标识符位,回退
					sb.deleteCharAt(sb.length()-1);
					map.put(END_INDEX, start);
					map.put(VALUE, sb.toString());
					return map;
				}
			}
		}
		map.put(END_INDEX, start);
		map.put(VALUE, sb.toString());
		return map;
	}
}
