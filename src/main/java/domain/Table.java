package domain;

import javax.naming.SizeLimitExceededException;
import java.util.ArrayList;
import java.util.List;

public class Table {
    private final int number;
    private List<Menu> menuList = new ArrayList<>();
    private PoS posForThisTable = new PoS();

    public Table(final int number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return Integer.toString(number);
    }

    public void addOrder(Menu newMenu) throws SizeLimitExceededException {
        if (checkSize())
            throw new SizeLimitExceededException("입력 가능한 메뉴의 최대 개수를 초과했습니다.");

        menuList.add(newMenu);
    }

    private boolean checkSize() {
        final int menuSizeLimit = 99;
        return menuList.size() >= menuSizeLimit;
    }

    //결제 성공 메시지 반환 받으면
    //이 친구 정보를 다 초기화?


}
