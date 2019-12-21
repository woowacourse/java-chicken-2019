package domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author : Kim SeYun
 * @ClassName : TableRepository
 * @ClassExplanation : 이용가능한 테이블 목록
 * @Date : 2019. 12. 21
 * @Copyright (c) 2019 SeYun Kim
 */
public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }
}