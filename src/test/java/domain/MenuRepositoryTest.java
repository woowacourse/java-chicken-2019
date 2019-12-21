package domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import annotation.TestDescription;
import org.junit.jupiter.api.Test;

class MenuRepositoryTest {

    @Test
    @TestDescription("생성된 메뉴를 확인하고, 사이즈를 확인하기 위한 메서드입니다.")
    public void createTest() {
        List<Menu> menus = MenuRepository.menus();
        assertThat(menus).hasSize(8);
        for (Menu menu : menus) {
            System.out.println(menu.toString());
        }
    }

}