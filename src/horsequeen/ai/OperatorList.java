package horsequeen.ai;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class OperatorList {
    private List<Operator> operators;

    public OperatorList() {
        this.operators = new ArrayList<>();
    }

    public boolean isEmpty() {
        return operators.isEmpty();
    }

    public boolean add(Operator e) {
        return operators.add(e);
    }

    public boolean addAll(Collection<? extends Operator> c) {
        return operators.addAll(c);
    }

    public Operator get(int index) {
        return operators.get(index);
    }
}
