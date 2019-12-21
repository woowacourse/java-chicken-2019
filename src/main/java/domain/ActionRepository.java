package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActionRepository {
    private static final List<Action> actions = new ArrayList<>();

    static {
        actions.add(new Action(1, "주문등록"));
        actions.add(new Action(2, "결제하기"));
        actions.add(new Action(3, "프로그램 종료"));
    }

    public static List<Action> actions() {
        return Collections.unmodifiableList(actions);
    }
}
