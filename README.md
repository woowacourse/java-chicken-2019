# java-chicken-2019

## 기능목록
1. **메인화면 출력** 
    - (1) 주문등록
    - (2) 결제하기
    - (3) 프로그램 종료  
    
2. **원하는 기능을 유저입력으로 선택**
    - [예외 처리] 1~3이외의 수가 입력될 경우
    - [예외 처리] 문자가 입력될 경우  
    
3. **[주문등록] 테이블 목록을 출력**  

4. **[주문등록] 테이블을 선택하는 기능**  

5. **[주문등록] 메뉴 리스트를 출력**  

6. **[주문등록] 등록할 메뉴를 선택**  

7. **[주문등록] 수량을 입력**  
    - [예외 처리] 한 메뉴당 최대 99개까지 가능
    - [예외 처리] 문자가 입력 될 경우
    - [예외 처리] 0이하의 수량이 입력될 경우 
    
8. **수량 입력완료 시 Order인스턴스 생성 후 Basket에 저장"
    - 이미 저장되어 있는 메뉴인 경우 수량만 증가

9. **[주문등록] (1)~(7)까지가 주문 한 사이클 결제가 되기 전까지 계속 반복**  

10. **[주문등록] 주문이 등록된 테이블은 별도로 ₩표시**  

11. **[결제하기] 테이블 목록을 출력**  

12. **[결제하기] 테이블 선택**
    - [예외처리] 주문등록 표시가 된 테이블만 선택 가능
    - 결제는 한 테이블 단위로 가능 테이블에 등록된 모든 메뉴 한꺼번에 계산  
    
13. **[결제하기] 주문내역 출력**
    - "#번 테이블의 결제를 진행합니다." 메시지 출력
    - Basket 안에있는 orderList 출력
    
14. **[결제하기] 결제 수단 입력**
    - (1) 신용카드
    - (2) 현금  
    
15. **[결제하기] 최종 결제 금액 출력**
    - 현금 결제시 5%할인된 금액 출력
    - 치킨 종류 수량의 합이 10개가 넘는 경우 10,000씩 할인  
    
16. **[주문/결제] 실패시 [프로그램 종료]가 눌리기 전까지 반복**
