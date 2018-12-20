package top.youlanqiang.alphajson.serialize;


import java.io.*;
import java.util.Properties;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/12/19
 * @since 1.8
 * 序列化默认配置
 */
public class DefaultParseConfig implements ParseConfig {

    /**
     * 时间序列化
     */
    private String dateFormat;

    /**
     * 十进制序列化
     */
    private String decimalFormat;


    public DefaultParseConfig(){
        defaultInit();
    }

    /**
     * 读取配置文件
     * @param file 配置文件
     */
    public DefaultParseConfig(File file) throws FileNotFoundException {
        if(file == null || file.exists() || !file.canRead()){
            defaultInit();
        }else {
            String ext = file.getName().substring(file.getName().lastIndexOf('.') + 1,
                    file.getName().length() - 1);
            switch (ext) {
                case "properties":
                    initByProperties(new FileInputStream(file));
                    break;
                case "yml":
                    //todo 解析YML
                    initByYaml(new FileInputStream(file));
                default:
                    defaultInit();
            }
        }
    }

    void initByProperties(InputStream in) {
        try {
            Properties pro = new Properties();
            pro.load(in);
            loadProperties(pro);
        }catch(IOException e){
            defaultInit();
        }
    }

    void initByYaml(InputStream in){

    }

    private void defaultInit(){
        this.dateFormat = "yyyy-MM-dd HH:mm:ss";
        this.decimalFormat = "#.#####";
    }


    private void loadProperties(final Properties properties){
        this.dateFormat = properties.getProperty("date-format", "yyyy-MM-dd HH:mm:ss");
        this.decimalFormat = properties.getProperty("decimal-format", "#.#####");
    }



    public String getDateFormat() {
        return dateFormat;
    }

    public void setDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public String getDecimalFormat() {
        return decimalFormat;
    }

    public void setDecimalFormat(String decimalFormat) {
        this.decimalFormat = decimalFormat;
    }
}
