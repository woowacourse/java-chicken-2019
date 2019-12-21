# java-chicken-2019
### POS
#### 메인 화면
* 주문 등록, 결제하기, 프로그램 종료 기능

#### 메뉴
* 메뉴 번호, 종류, 이름, 가격 정보를 가진다 

#### 테이블
* 테이블 번호를 가진다
* 테이블당 최대 주문 수량은 99개이다
* 주문 등록이 되었다면, 결제 전까지 테이블 목록에 별도로 표시한다

#### 결제
* 치킨 메뉴의 갯수의 합이 10개 마다 10000원씩 할인
* 현금 결제와 카드 결제 선택이 가능하다
* 현금 결제의 경우 5% 할인, 타 할인과 중복할인이 가능하다
* 최종 결제 금액을 보여준다

#### 주의
* 주문, 결제가 불가능한 경우 그 이유를 보여주고 재시도가 가능하게끔 해야한다
* 할인 제도, 이벤트 등의 변화에 유연할 수 있게 하드코딩 요소에 대하여 더욱 유의하자