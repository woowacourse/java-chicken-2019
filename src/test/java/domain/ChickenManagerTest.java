package domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.InstanceOfAssertFactories.OPTIONAL;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class ChickenManagerTest {

    @Test
    @TestDescription("이 메서드가 가져오는 테이블이 제대로 테이블을 가져오는지 테스트합니다.")
    public void getTableByIdTest() {
        List<Table> tables = TableRepository.tables();
        List<Menu> menus = MenuRepository.menus();
        ChickenManager chickenManager = new ChickenManager(menus, tables);

        assertThat(chickenManager.getTableByTableNumber(1)).isEqualTo(tables.get(0));
        assertThat(chickenManager.getTableByTableNumber(2)).isNotNull();
        assertThat(chickenManager.getTableByTableNumber(3)).isNotNull();
    }

}