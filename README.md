# java-chicken-2019

기능 요구 사항
메뉴
-메뉴 번호
-종류
-이름
-가격
테이블
-테이블 번호
-최대 메뉴 개수 99 개
주문 -> 테이블 목록 - > 결제

계산
유형 마다 할인율 달라짐 (치킨 10개 마다 만원할인
현금 10% 할인 (주문이나 결제 불가능 메세지)


기능 목록 (Functions class )
1. 기능 선택
2. 기능 목록 출력

*없는 번호 선택 불가

--------------
-주문 등록  (OrderForm class)
 1. 테이블 선택
    *없는 테이블 선택 불가 (checkTable method)
 2. 메뉴 선택
    *없는 메뉴 선택 불가 (checkMenu method)
 3. 메뉴 수량 선택
    * 메뉴 99개 이하 선택 불가 (OrderList 클래스에서 테이블 별 개수 검색)
 4. 주문 정보 저장 후 (Order class -> 목록 저장 (OrderList class))
    *제대론 된 입력이 됐는 지 확인하는 기능
-주문 정보 (Order class)
 1. 테이블, 메뉴 일치 여부 확인 메소드 (검색기능)


**Order form 분리 -> 성공 시 Order에 등록되고 order list에 추가

 OrderList
  1. search 기능
   *테이블 별 search 기능
  2. order 추가 기능


-결제하기
 1. 주문 성공
    * 정보 검사
 2. 주문 실패
    1. 메세지 출력
-프로그램 종료