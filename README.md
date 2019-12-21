# java-chicken-2019

## 나의 커밋메세지 규칙
[ feat ] : 000 기능구현

[ doc ] : readme에 내용 추가

[ refactor ] : 000 기능 수정 및 추가

## 구현할 기능 목록

#### 메인 화면 구현 전

- [x] 메뉴 기본정보를 등록하는 기능 : 메뉴는 메뉴 번호, 종류, 이름, 가격을 가진다. (사전 구현)

- [x] 테이블 기본정보를 등록하는 기능 테이블 번호를 가진다. (사전 구현)


#### 메인 화면 구현

- [x] 어떤 기능을 진행할 것인지 선택한다

#### 주문 등록 구현 [1]

- [ ] 테이블 목록을 보여준다. (사전 구현) -> 리팩토링 : 주문이 진행되지 않은 테이블의 여부를 확인한다.

- [x] 메뉴를 보여준다. (사전 구현)

- [x] 등록할 메뉴 / 수량을 결정한다 - > 장바구니 기능이라 명명

- [x] 장바구니 기능을 구현 할 시 : 메뉴를 N개를 주문한다 (N<100) : 에러 처리 프린트

- [x] 같은 메뉴로 이미 등록된 장바구니가 있다면 수량만 추가한다.

- [ ] 잘못된 값을 입력했을 경우 재 출력한다.

#### 결제 구현 [2]

- [x] 결제전 정산 기능1 - 결제 유형에 따른 할인율을 적용한다. with 개수당 할인

- [x] 결제전 정산 기능2 - 결제 유형에 따른 할인율을 적용한다. with 현금결제 할인

- [x] 잘못된 값을 입력했을 경우 재 출력한다.

- [x] 최종 결제 금액을 보여주는 기능

#### 프로그램 종료 구현 [3]

## 코드 컨벤션

1. 자바 코드 컨벤션
2. Indent 2
3. 3항연산자 사용하지 않기
4. 함수가 한가지 일만 하기
5. 함수 길이가 15넘지 않게 하기
6. Else 쓰기 않기
7. 메소드 인자수를 3개까지만 허용하기
8. 접근제어자 적절하게 구현하기

#### 하고 싶은 것
- [] Runner 선택지 Enum으로 재 구현
- [x] Card 현금 선택지 Enum으로 재 구현

