package top.youlanqiang.alphajson.exception;


/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/24
 * @since 1.8
 * JSON解析异常
 */
public class JSONParseException extends RuntimeException {

    public JSONParseException(String message){
        super(message);
    }

    public JSONParseException(int index, char[] value){
        StringBuilder message = new StringBuilder("JSON解析异常:");
        char[] json = new char[5];
        for(int v = 0; v < 5; v++ ){
            if(index + v < value.length){
                json[v] = value[index + v];
            }
        }
        message.append(new String(json));
        throw new JSONTypeException(message.toString().trim());
    }


}
