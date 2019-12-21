# 우아한 테크코스 오프라인 테스트 치킨집


## TODO

### InputView

- [x] 메인화면 에서 주문,결제,종료 입력 받기
- [x] 메인화면에서 입력시 유효한 입력인지 확인하는 기능
- [x] 주문 탭 에서 테이블 번호 입력받기
- [x] 테이블 번호 입력시 유효한 테이블 번호인지 확인 하는 기능
- [x] 주문 탭 에서 메뉴 선택 입력 받기
- [x] 메뉴 입력시 유효한 메뉴 번호인지 확인하는 기능
- [x] 주문 탭 에서 메뉴 수량 입력 받기
- [x] 메뉴 수량입력시 한메뉴의 (0 < 기존수량 + 입력수량 < 100) 확인하는 기능
- [x] 결제 탭 에서 결제방법 입력 받기

### OutputView

- [x] 메인화면 출력하기
- [x] 주문할 테이블 선택, 결제할 테이블 선택으로 출력 나눔
- [x] 주문내역(장바구니) 출력하기
- [x] 중간 결제 금액 출력하기
- [x] 최종 결제 금액 출력하기
- [x] 주문하였고 결제하지않은 테이블은 테이블목록 출력시 표시하는기능

### Calculator 

- 가격 정산 클래스 

- [x] 가격과 결제 방법을 받아오면 할인 해주는 기능
- [ ] 결제가 불가능할경우를 처리해주는 기능

### Ordered

- 장바구니 클래스 Table 에 종속

- [x] 받아온 메뉴를 추가하는 기능
- [x] 현재 담고있는 메뉴들의 최종가격 반환하는 기능
- [ ] 주문이 불가능한이유를 확인해주는 기능
- [x] 담을 려는 메뉴가 최대수량을 넘는지 여부 확인해주는 기능
- [x] 특정 메뉴의 현재 담긴 수량 반환하는 기능
- [x] 장바구니에 담긴 menu 들을 메뉴별로 수량 집계해주는 기능
- [x] 치킨 류 수량에 따라 할인 적용해주는 기능
- [x] 장바구니가 비었는지여부 확인해주는 기능

### Tables

- 테이블 정보 저장하는 클래스
- [x] 테이블 번호 받을시 존재하는 테이블 번호인지 확인해주는 기능
- [x] 메뉴를 Ordered 에 추가하는 기능
- [x] 테이블 번호 받을시 그 테이블 찾아주는 기능
- [x] 이 테이블이 주문 했는지 여부 확인해주는 기능

### Table

- [x] table 번호 비교하여 맞는지 확인해주는 기능
- [x] table 내 Ordered 로 부터 최종 가격 반환하는 기능

### Menus

- [x] Menu 번호 받을시 존재하는 메뉴번호인지 확인해주는 기능
- [x] Menu 번호 받을시 그 메뉴 찾아주는 기능

## Menu

- [x] Menu 번호 비교하여 맞는지 확인해주는 기능
- [x] Menu equals() hashCode()