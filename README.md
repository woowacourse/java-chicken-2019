<img src="https://woowacourse.github.io/images/logo/logo_full_white.png"/>
<h1>우아한 테크코스 프리코스</h1>
<h2>오프라인 코딩 테스트 - java-chicken-2019</h2>
<h2>제작 : 황보경(https://github.com/hwangbo)</h2>

<h3>실행 방법</h3>
<span>Application.java에서 컴파일.</span>

<h3>기능 요구사항</h3>
<ul>
    <li>치킨집 사장님이 사용하는 간단한 포스(POS) 프로그램을 구현한다.
        <br>
        주문등록, 결제하기, 프로그램 종료 기능을 가진다.
    </li>
    <li>메뉴 기본 정보가 주어지며 메뉴 번호, 종류, 이름, 가격을 가진다.</li>
    <li>테이블 기본 정보가 주어지며 테이블 번호를 가진다.</li>
    <li>한 테이블에서 주문할 수 있는 한 메뉴의 최대 수량은 99개이다.</li>
    <li>주문이 등록된 테이블은 결제가 이루어지기 전까지 테이블 목록에 별도로 표시한다.</li>
    <li>주문 내역에 대한 계산을 할 때는 결제 유형에 따라 할인율이 달라진다.</li>
    <li>치킨 종류 메뉴의 수량 합이 10개가 넘는 경우 10,000원씩 할인된다.</li>
    <li>e.g. 10개는 10,000원 할인, 20개는 20,000원 할인</li>
    <li>현금 결제는 5%가 할인되며 할인된 금액에서 한 번 더 할인이 가능하다.</li>
    <li>주문 혹은 결제가 불가능한 경우 그 이유를 보여 주고, 다시 주문 혹은 결제가 가능하도록 해야 한다.</li>
    <li>최종 결제 금액을 보여준다.</li>
    <h3>기능 구현 목록</h3>
    <ol>
        <li>
            Application.java
            <ul>
                <li>메인 함수를 갖는 클래스.</li>
                <li>메뉴를 고르는 mainMenuSelecter()</li>
                <li>메뉴에 따른 함수 연결을 해주는 checkMenuSelect()</li>
                <li>메뉴가 1번일 때 주문 과정을 담은 orderNow()</li>
                <li>메뉴가 2번일 때 결제 과정을 담은 payNow()</li>
            </ul>
        </li>
        <li>
            view package
            <ul>
                <li>
                    CheckValidity.java
                    <ol>
                        <li>각 입력을 조건에 맞게 반환하는 클래스</li>
                    </ol>
                </li>
                <li>
                    InputView.java
                    <ol>
                        <li>모든 입력에 관한 함수를 갖는 클래스</li>
                        <li>입력을 받아 그에 맞게 CheckValidity에서 함수를 실행</li>
                    </ol>
                </li>
                <li>
                    OutputView.java
                    <ol>
                        <li>입력을 받은 후 수행되는 결과를 출력하는 함수를 갖는 클래스</li>
                    </ol>
                </li>
            </ul>
        </li>
        <li>
            domain package
            <ul>
                <li>
                    Table.java
                    <ol>
                        <li>테이블에 대한 클래스</li>
                        <li>인스턴스로 테이블 명인 number, 주문한 내용을 담는 bills, 주문 후 결제가 되었는지 확인하는 isOrdered를 갖는다</li>
                        <li>주문할 때 합해서 주문량이 99개가 넘는지 확인하는 setAddMenu()</li>
                        <li>현재 총 주문 개수를 반환하는 checkTotal()</li>
                        <li>setAddMenu에서 99개가 넘지 않는다면 주문을 등록하는 addMenu()</li>
                        <li>결제 진행 전 몇번 테이블인지 알리는 printTableNumber()</li>
                        <li>영수증을 출력해주는 printBill()</li>
                        <li>총 금액을 반환하는 totalPay()</li>
                    </ol>
                </li>
                <li>
                    TableRepository.java
                    <ol>
                        <li>테이블에 대한 데이터를 조회하는 클래스</li>
                    </ol>
                </li>
                <li>
                    Menu.java
                    <ol>
                        <li>메뉴에 대한 클래스</li>
                        <li>어떤 메뉴를 몇개 시켰을 때 가격을 반환하는 totalPay()</li>
                        <li>영수증에서 메뉴가 치킨인지 확인하는 isChicken()</li>
                        <li>영수증에서 각 메뉴에 대한 정보를 반환하는 printMenu()</li>
                    </ol>
                </li>
                <li>
                    MenuRepository.java
                    <ol>
                        <li>메뉴에 대한 데이터를 조회하는 클래스</li>
                        <li>번호에 맞게 메뉴를 반환하는 selectMenu()</li>
                    </ol>
                </li>
                <li>
                    Category.java
                    <ol>
                        <li>메뉴에 대한 카테고리 정보를 담는 클래스</li>
                    </ol>
                </li>
            </ul>
        </li>
    </ol>
</ul>
<h3>초기 기능구현 준비</h3>
<img src="./ready structure.jpg"/>