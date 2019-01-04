package entity;

import java.util.List;

/**
 * @author youlanqiang
 * @version 1.0
 * @date 2019/1/4
 * @since 1.8
 */
public class Into<T> {

    private IntoBase intoBase;

    private List<List<T>> ininList;

    public IntoBase getIntoBase() {
        return intoBase;
    }

    public void setIntoBase(IntoBase intoBase) {
        this.intoBase = intoBase;
    }

    public List<List<T>> getIninList() {
        return ininList;
    }

    public void setIninList(List<List<T>> ininList) {
        this.ininList = ininList;
    }

    public class IntoBase{
        String name;
        T in;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getIn() {
            return in;
        }

        public void setIn(T in) {
            this.in = in;
        }
    }

}
