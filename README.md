# java-chicken-2019

## 기능 요구사항

- 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다. 
  - 주문등록, 결제하기, 프로그램 종료 기능을 가진다.
- 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가진다.
- 테이블 기본 정보가 주어지며 테이블 번호를 가진다.
- 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개이다.
- 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시한다
- 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 달라진다.
  - 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
    - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
  - 현금 결제는 5%가 할인되며 할인된 금액에서 한 번 더 할인이 가능하다.
- 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.
- 최종 결제 금액을 보여준다.

## 기능 추가

1. [X] 메인 화면 프린트
2. [  ] 기능 선택

   1. [  ] 1, 2, 3 중 기능 선택하는 함수

   2. [X] 주문한 테이블은 원화표기

   3. [  ] 기능 선택에 따른 다른 프린트 화면

      1. [  ] 1번 기능

         1. [X] 등록할 메뉴, 수량 선택
         2. [X] 메뉴 등록

      2. [  ] 2번 기능

         1. [X] 주문한 음식 프린트
3. [  ] 입력 예외 처리
   1. [X] 기능 입력 예외 처리
   2. [X] 테이블 존재 여부 예외처리
   3. [X] 메뉴 존재 여부 예외 처리
   4. [X] 최대 수량 예외처리
