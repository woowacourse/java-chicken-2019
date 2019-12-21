package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ActionRepository {
    private static final List<Action> actions = new ArrayList<>();
    private static final List<Integer> nums = new ArrayList<>();

    static {
        actions.add(new Action(1, "주문등록"));
        actions.add(new Action(2, "결제하기"));
        actions.add(new Action(3, "프로그램 종료"));
    }

    static {
        nums.add(1);
        nums.add(2);
        nums.add(3);
    }

    public static List<Action> actions() {
        return Collections.unmodifiableList(actions);
    }

    public static boolean isInAction(int num) {
        return nums.contains(num);
    }
}
