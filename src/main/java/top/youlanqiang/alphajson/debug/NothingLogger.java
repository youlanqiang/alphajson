package top.youlanqiang.alphajson.debug;


/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * 当关闭debug时,什么也不做
 */
public class NothingLogger implements Debug {

    /**
     * 默认什么也不做
     * @param text 提示文本
     */
    @Override
    public void info(String text) {

    }
}
