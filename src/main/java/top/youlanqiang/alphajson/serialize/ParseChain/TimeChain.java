package top.youlanqiang.alphajson.serialize.ParseChain;

import top.youlanqiang.alphajson.utils.RailUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/24
 * @since 1.8
 * 处理时间类型
 * TODO 未完成
 */
public class TimeChain extends ObjectToStringChain{

    public TimeChain(ObjectToStringChain chain){
        this.next = chain;
    }

    private static final String PARSE_STR = "yyyy-MM-dd HH:mm:ss";

    private static final SimpleDateFormat format = new SimpleDateFormat(PARSE_STR);



    @Override
    public String execute(Object object) {
        if(object instanceof LocalDateTime){
            return RailUtil.string(((LocalDateTime) object).format(DateTimeFormatter.ofPattern(PARSE_STR)));
        }
        if(object instanceof LocalDate){
            return RailUtil.string(((LocalDate) object).format(DateTimeFormatter.ofPattern(PARSE_STR)));
        }
        if(object instanceof LocalTime){
            return RailUtil.string(((LocalTime) object).format(DateTimeFormatter.ofPattern(PARSE_STR)));
        }
        if(object instanceof Date){
            return RailUtil.string(format.format((Date)object));
        }
        if(object instanceof Calendar){
            return RailUtil.string(format.format(((Calendar)object).getTime()));
        }
        return next.execute(object);
    }

    @Override
    public void setNext(ObjectToStringChain chain) {
        this.next = chain;
    }
}
