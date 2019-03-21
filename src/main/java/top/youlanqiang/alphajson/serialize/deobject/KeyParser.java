package top.youlanqiang.alphajson.serialize.deobject;

import top.youlanqiang.alphajson.JSONException;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class KeyParser {


    public static List<KeyValue> execute(final char[] array) {

        List<KeyValue> list = new ArrayList<>(20);
        char token;
        int length = array.length;
        KeyValue keyValue;
        for (int index = 0; index < length; index++) {
            token = array[index];

            if (token == '"') {
                keyValue = new KeyValue();
                int endKeyIndex = parseKeyValue(index, array);
                keyValue.setKeyName(new String(array).substring(index + 1, endKeyIndex));
                int endValueIndex = parseValue(endKeyIndex, array);

                keyValue.setValue(new String(array).substring(endKeyIndex + 2, endValueIndex));
                list.add(keyValue);
                index = endValueIndex;
            }
        }

        return list;
    }

    private static int parseKeyValue(int index, final char[] array) {
        char token;
        int length = array.length - 1;
        for (++index; index < length; index++) {
            token = array[index];

            if (token == '"' && index + 1 < length && array[index + 1] == ':') {
                return index;
            }
        }
        throw new JSONException("JSON parse is error");
    }



    private static int parseValue(int index, final char[] array) {
        char token;
        int length = array.length;
        Stack<Character> stack = new Stack<>();
        for (++index; index < length; index++) {
            token = array[index];

            if (token == '[' || token == '{') {
                stack.push(token);
            } else if (token == ']') {
                if (stack.peek() == '[') {
                    stack.pop();
                    continue;
                }
                throw new JSONException("JSON parse is error");
            } else if (token == '}') {
                if (stack.isEmpty()) {
                    return index;
                }
                if (stack.peek() == '{') {
                    stack.pop();
                    continue;
                }
                throw new JSONException("JSON parse is error");
            } else if (token == ',') {
                if (!stack.isEmpty()) {
                    continue;
                }
                return index;
            }
        }
        throw new JSONException("JSON parse is error");
    }


}
