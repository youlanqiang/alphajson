package top.youlanqiang.alphajson.utils;

import java.util.Stack;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public  class StringUtil {

    public static boolean isNullOrEmpty(String context){
       return context == null || context.trim().equals("");
    }


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


    private static String substringByTag(String json, int start, char closeTag) {
        int end = json.lastIndexOf(closeTag);
        return json.substring(start,end+1);
    }



    public static boolean matcherNumber(char temp) {
        return String.valueOf(temp).matches("[0-9]");
    }


    public static boolean isJSONObjectString(String context){
        if(context.length() < 2){
            return false;
        }
        return context.charAt(0) == '{' && context.charAt(context.length() - 1) == '}';
    }


    public static boolean isJSONArrayString(String context){
        if(context.length() < 2){
            return false;
        }
        return context.charAt(0) == '[' && context.charAt(context.length() - 1) == ']';
    }

    public static int findArrayLimit(int start, final String context){
        Stack<Character> stack = new Stack<>();
        for(int index = start; index < context.length(); index++){
            Character token = context.charAt(index);
            if(token == '['){
                stack.push(token);
            }
            if(token == ']'){
                stack.pop();
                if(stack.isEmpty()){
                    return index + 1;
                }
            }
        }
        return -1;
    }


    public static int findObjLimit(int start, final String context){
        Stack<Character> stack = new Stack<>();
        for(int index = start; index < context.length(); index++){
            Character token = context.charAt(index);
            if(token == '{'){
                stack.push(token);
            }
            if(token == '}'){
                stack.pop();
                if(stack.isEmpty()){
                    return index + 1;
                }
            }
        }
        return -1;
    }

}
