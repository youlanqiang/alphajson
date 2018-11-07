package top.youlanqiang.alphajson.deserialize.object;

import top.youlanqiang.alphajson.debug.Debug;
import top.youlanqiang.alphajson.debug.DebugFactory;
import top.youlanqiang.alphajson.exception.JSONParseException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/21
 * @since 1.8
 * 键值对解析器
 */
public class KeyParser {

    private static final Debug debug = DebugFactory.getDebug();

    /**
     * 执行解析操作
     * @param array
     */
    public static  List<KeyValue>  execute(final char[] array){

        List<KeyValue> list = new ArrayList<>(20);
        char token;
        int length = array.length;
        KeyValue keyValue;
        for(int index = 0; index < length; index++){
            token = array[index];

            if(token == '"'){
                keyValue = new KeyValue();
               int endKeyIndex = parseKeyValue(index, array);
               keyValue.setKeyName(new String(array).substring(index + 1, endKeyIndex));

               int endValueIndex = parseValue(endKeyIndex, array);
               keyValue.setValue(new String(array).substring(endKeyIndex + 2, endValueIndex));

               debug.info("解析点:" + keyValue);
               list.add(keyValue);
               index = endValueIndex;
            }
        }

        return list;
    }

    private static int parseKeyValue(int index, final char[] array){
        char token;
        int length = array.length-1 ;
        for(++index; index < length; index++){
            token = array[index];
            /**
             * 判断是否为键的结尾下标
             */
            if(token == '"' && index+1 < length && array[index+1] == ':'){
                return index;
            }
        }
        throw new JSONParseException(index, array);
    }


    /**
     * 解析出value值的结束下标
     * 在返回下标时要对下标前一位判断
     * value类型为字符串类型会多出一个 ” 符号
     * @param index 开始下标
     * @param array 解析的字符串
     * @return value值结束的下标
     */
    private static int parseValue(int index, final char[] array){
        char token;
        int length = array.length ;
        Stack<Character> stack = new Stack<>();
        for(++index; index < length; index++){
            token = array[index];
            /**
             * 解析过程中遇到 值为数组或者对象的数据
             * 需要使用Stack来判断值的结尾
             */
            if(token == '[' || token == '{'){
                stack.push(token);
            }else if(token == ']'){
                if(stack.peek() == '['){
                    stack.pop();
                    continue;
                }
                throw new JSONParseException(index, array);
            }else if(token == '}'){
                if(stack.isEmpty()){

                    if(array[index - 1] == '"'){
                        return index-1;
                    }
                    return index;
                }
                if(stack.peek() == '{'){
                    stack.pop();
                    continue;
                }
                throw new JSONParseException(index, array);
            }else if(token == ','){

                if(array[index - 1] == '"'){
                    return index-1;
                }
                return index;
            }
        }
        throw new JSONParseException(index, array);
    }


}
