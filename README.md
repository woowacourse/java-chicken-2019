# 우아한테크코스 오프라인 테스트
## java-chicken-2019
## 치킨집

-----
## 기능 요구 사항
- 치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.   
- 주문등록, 결제하기, 프로그램 종료 기능을 가진다.
- 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가진다.
- 테이블 기본 정보가 주어지며 테이블 번호를 가진다.
- 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 __99__ 개이다.
- 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시한다.

- 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 달라진다.
  - 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.
    - e.g. 10개는 10,000원 할인, 20개는 20,000원 할인
  - 현금 결제는 5%가 할인되며 할인된 금액에서 __한 번 더__ 할인이 가능하다.

- 주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 
  다시 주문 혹은 결제가 가능하도록 해야 한다. 
- 최종 결제 금액을 보여준다.

## 프로그래밍 요구사항
- 주어진 클래스 이용
- indent depth < 3
- 인자수 < 4

## 주요 기능
- 출력
  - 메인 화면 출력
  - 기능 선택 문구 출력
  - 테이블 목록 출력
  - 메뉴 출력
  - 각종 안내 문구 출력
  
- 입력
  - 사용자 입력
  
- 계산
  - 요금 계산
  - 할인 계산
 
## 클래스
- OutputView
  - 출력 담당
  
- InputView
  - 입력 담당
  
- Calculator
  - 계산 담당
  
- Check
  - 예외 체크 담당
  
## 예외
- 원하는 기능 입력시
  - [v] 숫자가 아닌 문자 입력
  - [v] 1,2,3 이외의 입력

- 테이블 입력시
  - [v] 숫자가 아닌 문자 입력
  - [v] 목록에 없는 테이블 선택
  
- 등록할 메뉴 입력시
  - [v] 숫자가 아닌 문자 입력
  - [v] 없는 메뉴 번호 입력
  
