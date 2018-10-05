package top.youlanqiang.alphajson.debug;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/10/5
 * @since 1.8
 * Debug工厂类
 */
public class DebugFactory {

    /**
     * 是否读取配置文件
     */
    private static boolean isRead = false;

    /**
     * debug状态
     */
    private static boolean status = false;


    private DebugFactory(){}

    public static top.youlanqiang.alphajson.debug.Debug getDebug(){
        if(!isRead) {
            synchronized (DebugFactory.class) {
                if(!isRead) {
                    try {
                        InputStream in = DebugFactory.class.getClassLoader().getResourceAsStream("setting.xml");
                        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
                        DocumentBuilder builder = factory.newDocumentBuilder();
                        Document doc = builder.parse(in);
                        NodeList list = doc.getElementsByTagName("debug");
                        Node node = list.item(0);
                        isRead = true;
                        status = Boolean.valueOf(node.getTextContent());
                    }catch(Exception e){
                        //当程序发生异常时,依然返回一个debug
                        e.printStackTrace();
                        return debug();
                    }
                }
            }
        }
        return debug();
    }


    private static top.youlanqiang.alphajson.debug.Debug debug(){
        if(status){
            return Debug.debug;
        }
        return Nothing.debug;
    }

    static class Nothing{
        static top.youlanqiang.alphajson.debug.Debug debug = new NothingLogger();
    }

    static class Debug{
        static top.youlanqiang.alphajson.debug.Debug debug = new DebugLogger();
    }


}
