# 배달 시스템 요구사항
### 사용자
- 회원가입
  - 동일한 아이디가 존재한다면 회원가입할 수 없음
  - 아이디와 비밀번호는 주어진 형식이 있음
    - 아이디의 경우 영문,숫자 포함 6~20 글자 사이
    - 비밀번호의 경우 영문,숫자,특수기호 포함 6~20글자 사이
### 주문
- 주문 실패 case -> **pessimistic lock**으로 처리 ([관련 코드 링크](https://github.com/shinyubin989/ddd-practice/blob/main/src/main/java/com/example/demo/order/application/OrderService.java))
  - 가게가 현재 열려 있지 않은 경우
  - 특정 메뉴 주문시 해당 메뉴가 품절인 경우
  - 고객의 잔금이 부족한 경우
