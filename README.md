# 치킨집 미션

- 우아한 테크 코스 2차 코딩 테스트를 진행하기 위한 저장소

## 준비물

- JDK(>=8)
- gradle or IntelliJ
- AssertJ 3.14.0

## 주의사항

- 3항 연산자 사용하지 않기
- indent depth 최대 2까지만 허용
- 자바 코드 컨벤션을 지키면서 프로그래밍 하기
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현하기
- else 예약어를 사용하지 않기
- 함수(또는 메서드)의 인자 수를 3개까지만 허용

## 기능 구현 목록

- POS 프로그램 구현
	- 주문등록, 결제하기, 프로그램 종료 기능
- 메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가짐
- 테이블 기본 정보가 주어지며 테이블 번호를 가짐
- 한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개
- 주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시
- 주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 다름
	- 치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인
	- 현금 결제는 5%가 할인, 할인된 금액에 대해서 한 번 더 할인 가능
- 주문 혹은 결제가 불가능할 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능해야 함
- 최종 결제 금액을 보여주어야 함


1. OutputView
	
	- 프로그램 메뉴를 보여주는 기능
	- 주문한 테이블에 ₩ 표시 기능
	
2. InputView
	
	- 프로그램 메뉴를 선택하는 기능
	- 등록할 메뉴를 선택하는 기능
	- 메뉴의 수량을 설정하는 기능
	- [예외처리] 입력된 값이 양의 숫자인지
	- [예외처리] 입력된 값이 null
	- [예외처리] 입력된 값이 0보다 큰지
