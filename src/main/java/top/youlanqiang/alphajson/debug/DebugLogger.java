package top.youlanqiang.alphajson.debug;


import java.util.logging.Logger;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * debug默认记录系统
 */
public class DebugLogger implements  Debug{

    private Logger logger = Logger.getLogger(DebugLogger.class.getName());

    @Override
    public void info(String text) {
        logger.info(text);
    }

}
