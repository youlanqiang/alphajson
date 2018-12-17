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

	public static String arrayToString(final char[] str, int begin, int end) {
		StringBuilder sb = new StringBuilder();
		for(;begin<end;begin++) {
			sb.append(str[begin]);
		}
		return sb.toString();
	}
	
	public static Map<String,Object> arrayToString(final char[] str, int begin, char... conditions) {
		Map<String,Object> map = new HashMap<>();
		StringBuilder sb = new StringBuilder();
		for(;begin<str.length-1;begin++) {
			sb.append(str[begin]);
			for(char condition:conditions) {
				if(str[begin]==condition) {
					//当前位为标识符位,回退
					sb.deleteCharAt(sb.length()-1);
					map.put(END_INDEX, begin);
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
