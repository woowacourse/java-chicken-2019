# java-chicken-2019

## 구현할 기능 목록
- 메인 화면 OutputView
- 메인 화면 InputView
- 메인 화면 사용자 선택에 따라 분기만 제대로 들어가게
  * [예외] 메인화면에서 invalid한 input이 들어갔을 시
  * 메인화면에서 주문 등록을 눌렀을 시 
  * 메인화면에서 결제하기를 눌렀을 시
  * 메인화면에서 프로그램 종료를 눌렀을 시
- 프로그램 종료 구현
- 주문 등록 구현
  * 주문 등록의 InputView와 OutputView 구현
  * 테이블 별 주문 관리 - 주문 메뉴가 정확한 테이블에 제대로 들어가게
  * 주문이 등록된 테이블 별도 표시
  * [예외] 없는 table 번호 input(invalid input)
  * [예외] 없는 menu 번호 input(invalid input)
  * [예외] 한 테이블에서 주문한 한 메뉴의 최대 수량이 99를 넘어갔을 때
- 결제하기 구현
  * 결제의 InputView와 OutputView 구현
  * 현금 결제할 시 5% 할인
  * 수량에 따른 할인
  * [예외] 없는 table 번호 input(invalid input)
  * [예외] 결제 방법이 1,2가 아닐 경우(invalid input)
- InputMismatchException