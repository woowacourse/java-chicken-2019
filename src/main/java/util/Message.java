/*
 * Copyright (c) 2019 by SorinJin
 * All rights reserved.
 *
 * Message.java
 * 입출력 메세지들을 담고 있는 enum
 *
 * @author      Sorin Jin
 * @version     1.0
 * @date        21 Dec 2019
 *
 */

package util;

public enum Message {
    ACTION_NUMBER_MESSAGE("## 원하는 기능을 선택하세요."),
    TABLE_NUMBER_MESSAGE("## 주문할 테이블을 선택하세요."),
    MENU_NUMBER_MESSAGE("## 등록할 메뉴를 선택하세요."),
    MENU_COUNT_MESSAGE("## 메뉴의 수량을 입력하세요."),
    ACTION_NUMBER_FORMAT_ERROR("문자를 입력하셨습니다. 숫자로 입력해주세요."),
    ACTION_NUMBER_RANGE_ERROR("1,2,3 중 하나를 입력하세요."),
    TABLE_NUMBER_RANGE_ERROR("위에 보이는 테이블 번호 중 하나를 입력하세요."),
    MENU_NUMBER_RANGE_ERROR("위에 보이는 메뉴 번호 중 하나를 입력하세요."),
    MENU_COUNT_RANGE_ERROR("주문 수량은 최소 1개부터 최대 99개까지 가능합니다.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
