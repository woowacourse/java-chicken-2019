/*
 * PayList
 *
 * ver 1.0
 *
 * 2019.12.21
 *
 * CopyRight
 *
 */
package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PayList {
    private static final List<Pay> tables = new ArrayList<>();
    /*
     * PayList 클래스 입니다.
     * Pay클래스의 초기값을 설정합니다.
     */
    static {
        tables.add(new Pay(1));
        tables.add(new Pay(2));
        tables.add(new Pay(3));
        tables.add(new Pay(5));
        tables.add(new Pay(6));
        tables.add(new Pay(8));
    }

    public static List<Pay> List() {
        return Collections.unmodifiableList(tables);
    }
}
