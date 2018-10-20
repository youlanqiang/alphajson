package top.youlanqiang.alphajson.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/17
 * @since 1.8
 * 字符串工具类
 */
public  class StringUtil {

    public static boolean isNullOrEmpty(String context){
        if(context == null || context.trim().equals("")){
            return true;
        }
        return false;
    }

    /**
     * JSON将字符去掉头部特殊字符和尾部特殊字符返回.
     * @param str  返回的JSON字符串
     * @return
     */
    public static String trimJSONString(String str) {
        String dest = "";
        int objTag = str.indexOf('{');
        int arrayTag = str.indexOf('[');

        if(objTag == -1) {
            dest = substringByTag(str, arrayTag, ']');
        }else if(arrayTag == -1) {
            dest = substringByTag(str, objTag, '}');
        }else if(objTag < arrayTag) {
            dest = substringByTag(str, objTag, '}');
        }else {
            dest = substringByTag(str, arrayTag, ']');
        }
        return dest;
    }

    /**
     * 截取json字符串
     * @param json  json原始字符串
     * @param start  截取开始下标
     * @param closeTag 截取结束下标
     * @return
     */
    private static String substringByTag(String json, int start, char closeTag) {
        int end = json.lastIndexOf(closeTag);
        return json.substring(start,end+1);
    }


    /**
     * 去掉字符串中所有的特殊符
     * @param str
     * @return
     */
    public static String replaceBlank(String str){
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s*|\t|\r|\n");
            Matcher m = p.matcher(str);
            dest = m.replaceAll("");
        }
        return dest;
    }

    /**
     * 匹配字符是否为数字
     * @param temp
     * @return
     */
    public static boolean matcherNumber(char temp) {
        return String.valueOf(temp).matches("[0-9]");
    }



}
