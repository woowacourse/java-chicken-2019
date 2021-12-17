# 🚀 미션 - 치킨집 POS

치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다. 
주문 등록, 결제하기, 프로그램 종료 기능을 가진다.

# 📈 기능 목록

## 구현 기능 목록

### ✅ 입력

- [x] 메인화면 원하는 기능을 입력(1 - 주문등록 2 - 결제하기 3 - 프로그램 종료)
- [x] 테이블 입력
- [x] 주문할 메뉴 입력
- [x] 메뉴의 수량 입력
- [x] 결제 방식 입력(신용 카드는 1번, 현금은 2번)

### ✅ 주문등록 기능

- [x] 테이블 선택
    - [x] [예외] 테이블 레포 안 숫자에 해당하지 않는 경우
    - [x] 주문메뉴 받기
        - [x] [예외] 메뉴 레포 숫자 중에 없는 경우
    - [x] 메뉴 수량 받기
        - [x] [예외] 0 이하 숫자인 경우
        - [x] [예외] 100 이상 숫자인 경우
    - [x] 선택된 테이블이 비었을 경우 : 유저 생성, 메뉴 정보 넣기
    - [x] 선택된 테이블이 비지 않았을 경우 : 해당유저 메뉴 정보 추가

### ✅ 결제하기 기능

- [x] 테이블 선택
    - [x] [예외] 선택된 테이블이 차있지 않은 경우
    - [x] 금액계산
        - [x] 메뉴마다 수량 10개 단위마다 만원 할인
    - [x] 결제방식 저장
        - [x] [예외] 해당 숫자중에 없는 경우
        - [x] 현금결제 5% 할인
- [x] 최종 결제금액 출력
- [x] 해당 테이블 유저 제거

### ✅ 출력

- [x] 메인화면 출력
- [x] 테이블목록 출력
- [x] 메뉴 출력
- [x] 결제방식 출력

### ✅ 과정

- [x] 반복
    - [x] 메인화면 입력 받기
        - [x] [예외] 해당 숫자 중에 없는 경우
        - [x] 프로그램 종료 입력 시 종료
        - [x] 이외 : 주문등록/결제하기 수행

---

## 🔍구현 로직

- ### Main diagram


- ### Util diagram


- ### View diagram

---