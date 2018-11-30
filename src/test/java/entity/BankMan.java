package entity;

import java.math.BigDecimal;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/30
 * @since 1.8
 */
public class BankMan {

    private BigDecimal money;

    private String name;

    public BigDecimal getMoney() {
        return money;
    }

    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
