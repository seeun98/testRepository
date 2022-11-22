drop table customer_t purge;
drop table product_t purge;
drop table order_t purge;
drop table cart_t purge;
drop table category_t purge;
drop table review_t purge;
drop table description_t purge;


--1. 고객 테이블 생성
create table customer_t (
    id varchar(20) PRIMARY KEY,
    pwd varchar(20) not null,
    name varchar(10) not null,
    address varchar(20) not null,
    phone varchar(20) not null,
    birth Date not null,
    gender char(1),
    joinDate Date
);

--2. 상품 테이블 생성
create table product_t (
    productId varchar2(20) PRIMARY KEY,
    productName varchar2(20) not null,
    price number not null,
    takeType varchar2(10),
    categoryId varchar2(20),
    productDescription long,
    salePercent number,
    mdPick char(1) default 'N',
    insertDate date not null,
    expireDate date,
    brandDirect char(1) default'N'
);

--3. 주문 테이블 생성
create table order_t (
    orderId varchar2(20) PRIMARY KEY,
    customerId varchar2(20) REFERENCES customer_t (id),
    productId varchar2(20) REFERENCES product_t (productId),
    orderDate Date not null,
    recipient varchar2(10), --default 고객이름
    reciAddress varchar2(300) not null,
    reciPhone varchar2(20) not null,
    totalPrice number not null,
    quantitiy int not null   
);

--4. 장바구니 테이블 생성
create table cart_t (
    cartId varchar(10) PRIMARY KEY,
    id varchar2(20) REFERENCES customer_t (id),
    productId varchar(20) REFERENCES product_t (productId),
    cartstatus char(1) default 'N'
);

--5. 카테고리 테이블 생성
create table category_t (
    categoryId varchar(20) PRIMARY KEY,
    categoryName varchar(20) not null,
    categoryInner varchar(10) not null
);

--6. 상품평 테이블 생성
create table review_t (
    reviewId varchar(10) PRIMARY KEY,
    id varchar(20) REFERENCES customer_t (id),
    orderId varchar(20) REFERENCES order_t (orderId),
    review long not null,
    reviewStar int not null
);

--7. 상세설명 테이블 생성
create table description_t (
    productId varchar(10) REFERENCES product (productId), --바코드 정보
    productPeriod varchar(10), --안심사용기한
    productSize integer default (''), -- 크기
    productFrom long default('상품상세 혹은 이미지참조'), --생산자, 수입품의 경우 수입자를 함께 표기
    productStorage varchar(10), --보관방법 또는 취급방법
    productName varchar(10) --품목 또는 명칭  
);


    
    