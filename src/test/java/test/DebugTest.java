package test;

import top.youlanqiang.alphajson.debug.Debug;
import top.youlanqiang.alphajson.debug.DebugFactory;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * Debug模块测试类
 */
public class DebugTest {


    public static void main(String[] args){
        Debug debug = DebugFactory.getDebug();
        debug.info("test debug module");
    }

}
