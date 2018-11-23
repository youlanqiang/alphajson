package entity;

import java.util.Map;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class Autor implements Comparable{

    private String name;

    private Admin admin;

    private Map<String, Double> point;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public Map<String, Double> getPoint() {
        return point;
    }

    public void setPoint(Map<String, Double> point) {
        this.point = point;
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "name='" + name + '\'' +
                ", admin=" + admin +
                ", point=" + point +
                '}';
    }
}
