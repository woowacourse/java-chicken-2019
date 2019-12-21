package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainRepository {

    private static final List<Main> mains = new ArrayList<>();

    static {
        mains.add(new Main(1, "주문등록"));
        mains.add(new Main(2, "결제하기"));
        mains.add(new Main(3, "프로그램 종료"));
    }

    public static List<Main> mains() {
        return Collections.unmodifiableList(mains);
    }
}
