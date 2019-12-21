# java-chicken-2019

## 프로그램 설명

- 치킨집 사장님이 사용하는 간단한 POS 기계를 개발한다.
- 주문등록, 결제하기, 프로그램 종료 기능을 갖는다.

## 프로그램 실행

    - Git clone
    - build gradle
    - src-main-java-Application 의 메인메서드를 실행하시면 됩니다. 

## 기능 구현

1. [x] 메인화면을 보여준다.

2. [x] 원하는 기능을 입력받는다.

    - [x] 메인화면에 있는 번호 즉 1~3번만이 가능하다.
    - [x] 이외의 수는 예외처리 해야하며
    - [x] Format이 맞지 않은 경우도 예외처리 해야 한다.
    
3. [x] 기능을 입력받고, 테이블을 출력한다.

4. [x] 출력한 테이블에서 선택하고자 하는 번호를 입력받는다.

    - [x] 메인화면에 있는 번호만이 가능하다.(1,2,3,5,6,8)
    - [x] 이외의 수는 예외처리 해야하며
    - [x] Format이 맞지 않은 경우도 예외처리 해야 한다.
    
5. [x] 등록 할 메뉴를 선택한다.(입력 받는다.)

    - [x] 메인화면에 있는 번호만이 가능하다.(1,2,3,4,5,6 : 치킨 / 21,22 음료)
    - [x] 이외의 수는 예외처리 해야하며
    - [x] Format이 맞지 않은 경우도 예외처리 해야 한다.
    
6. [x] 메뉴의 수량을 입력받는다.

    - [x] 문구 : 메뉴의 수량을 입력하세요.
    - [x] 예외처리
        - [x] Format Error
        - [x] 0개 이상, 99개 이하
    - [x] 메뉴를 테이블에 추가한다.
 
7. 입력이 완료되면, 해당 테이블에 $를 표기한다.

8. [x] 이후 다시 메인화면을 보여주며 1번과 같이 반복한다.

9. [x] 결제하기를 선택하는 경우
    
    -  테이블 목록을 보여준다($가 표기 된)
    - [x] 주문 내역을 보여준다(메뉴,수량,금액)

10. [x] 결제를 진행한다.
    
    - [x] 치킨 종류의 메뉴의 합이 10개 이상인 경우, 10개 단위로 만원씩 할인 된다.
    - [x] 신용카드와 현금은 할인율이 다른데, 현금은 5프로 할인
    - [x] 결제가 불가능한 경우,
    
11. [x] 최종 결제금액을 계산하여 보여준 후 프로그램은 1번으로 돌아간다.

    - [x] 최종 금액 : (구매총액 - 치킨할인) * 현금할인
    
    
## 추가적으로 구현 할 것
 
1. 예외처리

    - 주문이 들어가 있는, 테이블은 별도의 표기하기
    - [x] 한번에 100마리는 못시키지만, 나눠서 시키면 되는 버그 잡기
    - [x] 수량 0 을 입력하지 못하게 하기
   
3. 테스트 코드 작성
    
    - 테스트코드 작성
    
4. 추가적인 작업
    
    - 사용 설명서 및 스크린샷파일 첨부


## 프로그램 실행 스크린샷 
<div>
<img width="637" alt="ken" src="https://user-images.githubusercontent.com/49060374/71305297-f5ccb180-2414-11ea-857d-dec87c11a1e3.png">
<img width="673" alt="chi" src="https://user-images.githubusercontent.com/49060374/71305296-f5ccb180-2414-11ea-8ecc-044ac1468f04.png">
</div>    