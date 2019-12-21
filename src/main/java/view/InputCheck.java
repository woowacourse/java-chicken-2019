package view;

import domain.*;

public class InputCheck {

    public boolean numberCheck(String number) {
        try {
            Integer.parseInt(number);
        } catch (Exception e) {
            System.out.println("숫자를 입력해주세요.");
            return true;
        }

        return false;
    }

    public boolean mainInputCheck(String number) {
        if (this.numberCheck(number)) {
            return true;
        }

        int checkNumber = Integer.parseInt(number);

        for (Main main : MainRepository.mains()) {
            if (main.mainInputCheck(checkNumber)) {
                return false;
            }
        }
        System.out.println("1, 2, 3 중에 입력해주세요.");
        return true;
    }

    public boolean tableInputCheck(String number) {
        if (numberCheck(number)) {
            return true;
        }

        int checkNumber = Integer.parseInt(number);

        for (Table table : TableRepository.tables()) {
            if (table.TableInputCheck(checkNumber)) {
                return false;
            }
        }

        System.out.println("테이블 번호를 입력해주세요.");
        return true;
    }

    public boolean menuInputCheck(String number) {
        if (numberCheck(number)) {
            return true;
        }

        int checkNumber = Integer.parseInt(number);

        for (Menu menu : MenuRepository.menus()) {
            if (menu.menuInputCheck(checkNumber)) {
                return false;
            }
        }

        System.out.println("메뉴를 다시 확인해주세요.");
        return true;
    }

}

