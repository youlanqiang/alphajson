package entity;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/17
 * @since 1.8
 */
public class Admin {

    private String adminName;

    private String value;

    public Admin() {
    }

    public Admin(String adminName, String value) {
        this.adminName = adminName;
        this.value = value;
    }

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }


    @Override
    public String toString() {
        return "Admin{" +
                "adminName='" + adminName + '\'' +
                ", value='" + value + '\'' +
                '}';
    }
}
