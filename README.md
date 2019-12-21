# java-chicken-2019

## 미션 개요

치킨집의 Pos시스템이다. 고객이 Pos시스템을 시작하면, 메인화면을 통해 메인화면을 볼 수 있다. 메인 화면은 다음과 같이 구성된다.

1. 주문등록: 테이블을 선택 후, 메뉴를 선택하여 주문할 수 있다.
2. 결제하기: 테이블을 선택 후, 해당 테이블에 주문된 메뉴들을 결제할 수 있다.
3. 프로그래밍 종료: 프로그램을 종료할 수 있다.

## 구현 상세

1. 다음과 같은 정보를 활용해 구현한다.

- Menu: 메뉴번호, 종류(Category), 이름, 가격 정보를 가진다.
- MenuRepository: 메뉴 정보를 가진다.
- Table: 테이블 번호 정보를 가진다.
- TableRepository: 테이블 정보를 가진다.

2. 한 테이블에서 주문할 수 있는 최대 수량은 99개 이다.

3. 주문 등록된 테이블은 결제 전까지 테이블 목록에 별도 표시해야한다.
4. 할인정책:

- 10개마다 10,000씩 할인한다.
- 현금결제는 5%할인한다. 할인된 금액에서 한번 더 할인 가능하다.

5. 주문, 결제가 불가능한 경우 이유를 보여준다. 다시 주문, 결제 가능하다.
6. 최종 결제 금액을 보여준다.

## 기능 목록

1. 테이블의 상태(대기, 등록 등)를 변화시킨다.
2. 메뉴를 고르고 주문을 하면, 테이블에 메뉴를 추가한다. 
3. 결제 시도 시, 주문 내역을 보여준다.
4. 결제 진행 시, 결제 수단을 선택한다.
5. 결제 수단 선택 후, 최종 결제할 금액을 보여준다.
6. 프로그램 종료를 원하면, 프로그램을 종료한다.