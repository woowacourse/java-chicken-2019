package view;

import domain.*;

import java.util.List;

/**
 * @author : Kim SeYun
 * @ClassName : InputCheck
 * @ClassExplanation : 정상적인 입력값 확인
 * @Date : 2019. 12. 21
 * @Copyright (c) 2019 SeYun Kim
 */
public class InputCheck {

    private int checkNumber;

    public boolean numberCheck(String number) {
        try {
            checkNumber = Integer.parseInt(number);
            if (checkNumber < 1) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("정수를 입력해주세요.");
            return true;
        }
        return false;
    }

    public boolean mainInputCheck(String number, List<Main> mains) {
        if (this.numberCheck(number)) {
            return true;
        }

        return !mains.stream().anyMatch(main -> main.mainInputCheck(checkNumber));
    }

    public boolean tableInputCheck(String number, List<Table> tables) {
        if (numberCheck(number)) {
            return true;
        }

        return !tables.stream().anyMatch(table -> table.tableInputCheck(checkNumber));
    }

    public boolean menuInputCheck(String number, List<Menu> menus) {
        if (numberCheck(number)) {
            return true;
        }

        return !menus.stream().anyMatch(menu -> menu.menuInputCheck(checkNumber));
    }
}

