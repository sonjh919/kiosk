# 키오스크 만들기

![](https://img.shields.io/badge/내일배움캠프-Java개인과제-white.svg)
  
---  
+ 키오스크 프로그램 개발
---  

# 📈 다이어그램

![kiosk](https://github.com/sonjh919/kiosk/assets/109019081/794733f9-1be7-4795-9eb2-728cf1ae75c3)

# 📚 기능 목록

## 메인 메뉴판
- [x] 키오스크 시작 시 메인 메뉴판이 출력되며 메뉴판에는 상품 메뉴가 출력 된다.
- [x] 상품 메뉴는 간단한 설명과 함께 출력 되며 최소 3개 이상 출력 된다.
- [x] 상품 메뉴(`1~3`) 입력시 [상품 메뉴판](#상품-메뉴판)으로 이어진다.
- [x] `4` 입력 시 [주문 화면](#주문-화면)으로 이어진다.
- [x] `5` 입력 시 [주문 취소 화면](#주문-취소-화면)으로 이어진다.
- [x] 숨겨진 기능으로 `0` 입력 시 [총 판매금액 조회](#총-판매금액-조회) 및 [총 판매상품 목록 조회](#총-판매상품-목록-조회) 화면으로 이어진다.
- [x] 숨겨진 기능으로 `6` 입력 시 키오스크 프로그램이 종료된다.

### 🔥 출력 요구 사항
- [x] 메뉴판 출력
```text  
"JH CAFE에 오신걸 환영합니다."
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

[ JH CAFE 메뉴 ]
1. 커피   | 커피냠냠
2. 디저트   | 디저트냠냠
3. 마실거   | 마실거냠냠
4. 주문   | 장바구니 확인 후 주문!
5. 취소   | 진행중인 주문 취소!
```  
  
---  

## 상품 메뉴판
- [x] 선택한 상품 메뉴의 해당 카테고리의 메뉴판이 출력된다.
- [x] 메뉴판에는 각 메뉴의 이름과 가격과 간단한 설명이 표시된다.

### 🔥 입력 요구 사항
- [x] 메뉴판에서 메뉴를 입력받는다.

```java 
0
1
2
3
4
5
6
```  

### 🔥 출력 요구 사항
- [x] 메뉴 선택 시 상품 메뉴판 출력

```java  
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

1. 아메리카노   | W 3,500 | 아메리카노 냠냠
2. 에스프레소   | W 3,000 | 에스프레소 냠냠
3. 카페라떼   | W 4,500 | 카페라떼 냠냠
```  

## 장바구니 추가하기
- [x] 상품 선택 시 해당 상품을 장바구니에 추가할지 확인하는 문구가 출력 된다.
- [x] `1` 입력 시 장바구니에 추가되었다는 안내 문구와 함께 [메인 메뉴판](#메인-메뉴판)으로 다시 출력된다.
- [x] `2` 입력 시 [메인 메뉴판](#메인-메뉴판)으로 다시 출력된다.

### 🔥 입력 요구 사항
- [x] 현재 선택되어있는 메뉴를 장바구니에 추가할 것인지에 대한 입력을 받는다.
```java  
1
2
```  

### 🔥 출력 요구 사항
- [x] 장바구니 추가 선택 화면 출력
```java  
"아메리카노     | W 3,500 | 아메리카노 냠냠"  
위 메뉴를 장바구니에 추가하시겠습니까?  
1. 확인        2. 취소  
```  

---  

## 주문 화면
- [x] 장바구니 목록을 출력한다.
- [x] 장바구니에서는 추가된 메뉴들과 개수, 총 가격의 합을 출력해준다.
- [x] `1` 입력 시 [주문 완료](#주문-완료) 화면으로 넘어간다.
- [x] `2` 입력 시 다시 [메인 메뉴판](#메인-메뉴판)으로 돌아온다.

### 🔥 입력 요구 사항
- [x] 주문 또는 메뉴판 입력
```java  
1
2
```  

### 🔥 출력 요구 사항
- [x] 주문 확인서 출력
```java  
아래와 같이 주문 하시겠습니까?

[ Orders ]
아메리카노   | W 3,500 | 1개 | 아메리카노 냠냠

[ TOTAL ]
W 3,500
        
1. 주문        2. 메뉴판
```  


---  

## 주문완료 화면
- [x] 대기번호를 발급해준다.
- [x] 장바구니는 초기화된다.
- [x] 3초 후에 [메인 메뉴판](#메인-메뉴판)으로 돌아간다.

### 🔥 출력 요구 사항
- [x] 주문 완료 문구 출력
```java  
주문이 완료되었습니다!  
  
대기번호는 [ 1 ] 번 입니다.  
(3초후 메뉴판으로 돌아갑니다.)  
```  
  
---  

## 주문 취소 화면
- [x] 주문을 취소할지 확인을 요청하는 문구가 출력된다.
- [x] `1` 을 입력하면 장바구니는 초기화되고, 취소 완료 문구와 함께 [메인 메뉴판](#메인-메뉴판)으로 돌아간다.
- [x] `2`를 입력하면 다시 [메인 메뉴판](#메인-메뉴판)으로 돌아간다.
### 🔥 입력 요구 사항
- [x] 주문 취소 선택
```java  
1
2
```  

### 🔥 출력 요구 사항
- [x] 주문 취소 선택 문구 출력
```text  
진행하던 주문을 취소하시겠습니까?  
1. 확인        2. 취소  
```  
- [x] 주문 취소 확인 및 메뉴판 출력
```text  
진행하던 주문이 취소되었습니다.  
  
"JH CAFE에 오신걸 환영합니다."
아래 메뉴판을 보시고 메뉴를 골라 입력해주세요.

[ JH CAFE 메뉴 ]
1. 커피   | 커피냠냠
2. 디저트   | 디저트냠냠
3. 마실거   | 마실거냠냠
4. 주문   | 장바구니 확인 후 주문!
5. 취소   | 진행중인 주문 취소!
```  

  
---  


## 총 판매금액 조회
- [x] 구매가 완료될 때마다 총 판매 금액을 누적한다.
- [x] 숨겨진 기능으로 0번 입력 시 총 판매금액을 출력한다.
### 🔥 입력 요구 사항
```java
1.돌아가기
```
### 🔥 출력 요구 사항
- [x] 총 판매금액 출력
```java  
[ 총 판매금액 현황 ]현재까지 총 판매된 금액은 [ W 14,500 ] 입니다.
  
1. 돌아가기  
```  

## 총 판매상품 목록 조회
- [x] 구매가 완료될 때마다 판매 상품 목록을 저장한다.
- [x] 숨겨진 기능으로 0번 입력 시 총 판매 상품 목록을 출력한다.

### 🔥 입력 요구 사항
```java
1
```
### 🔥 출력 요구 사항
- [x] 총 판매상품 목록 출력
```java  
[ 총 판매상품 목록 현황 ] 현재까지 총 판매된 상품 목록은 아래와 같습니다.
- 아메리카노   | W 3,500
- 스프라이트   | W 3,000
- 에스프레소   | W 3,000
- 파이   | W 5,000
1. 돌아가기
```  

---

# 📚 예외 처리 사항
- [x] `[ERROR]`로 시작하는 에러 메시지를 출력한다.
- [x] 에러 메시지를 출력 후, 그 부분부터 입력을 다시 받는다.
- [x] 메뉴 범위의 정수가 아닌 경우
- [x] 장바구니에 아무것도 없는데 주문하려는 경우
### 🔥 예외 처리 시 출력
- [x] 숫자를 제외한 형식을 입력한 경우
```java
[ERROR] 잘못된 형식입니다. 숫자만 입력해 주세요.
```
- [x] 범위에 맞지 않는 숫자를 입력한 경우
```java
[ERROR] 범위에 맞는 숫자를 입력해 주세요.
```

- [x] 장바구니가 비어있을 경우
```java
[ERROR] 장바구니가 비어있습니다. 메뉴를 담은 후 주문을 진행해주세요.
```