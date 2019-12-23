/**
 * Copyright (c) 2019 Seungwan Park,
 * All rights reserved.
 */

import controller.PosController;

/**
 * @author Seungwan Park, github.com/toneyparky
 * @version 1.0
 * @apiNote 치킨집 포스기를 시작하는 클래스입니다.
 * @since : 2019.12.23 월요일
 */
public class Application {
    // TODO 구현 진행
    public static void main(String[] args) {
        PosController posController = new PosController();
        posController.posController();
    }
}
