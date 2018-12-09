package entity;

import top.youlanqiang.alphajson.annotation.JSONEnable;
import top.youlanqiang.alphajson.annotation.JSONEnableType;

import java.math.BigDecimal;
import java.util.Queue;
import java.util.Stack;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2018/11/30
 * @since 1.8
 */
public class BankMan {

    @JSONEnable(JSONEnableType.Serialize)
    private BigDecimal money;

    private String name;

    private Stack<String> stack;

    private Queue<Integer> queue;

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

    public Stack<String> getStack() {
        return stack;
    }

    public void setStack(Stack<String> stack) {
        this.stack = stack;
    }

    public Queue<Integer> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Integer> queue) {
        this.queue = queue;
    }
}
