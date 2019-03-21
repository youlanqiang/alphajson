package entity;

import java.util.Date;
import java.util.HashSet;

/**
 * @author youlanqiang
 * @version 1.0
 * @since 1.8
 */
public class TimeCarryer {


    private Date time;

    private String name;

    private HashSet<Integer> ins;

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public HashSet<Integer> getIns() {
        return ins;
    }

    public void setIns(HashSet<Integer> ins) {
        this.ins = ins;
    }


}
