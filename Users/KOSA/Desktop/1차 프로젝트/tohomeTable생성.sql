drop table customer_t purge;
drop table product_t purge;
drop table order_t purge;
drop table cart_t purge;
drop table category_t purge;
drop table review_t purge;
drop table description_t purge;


--1. �� ���̺� ����
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

--2. ��ǰ ���̺� ����
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

--3. �ֹ� ���̺� ����
create table order_t (
    orderId varchar2(20) PRIMARY KEY,
    customerId varchar2(20) REFERENCES customer_t (id),
    productId varchar2(20) REFERENCES product_t (productId),
    orderDate Date not null,
    recipient varchar2(10), --default ���̸�
    reciAddress varchar2(300) not null,
    reciPhone varchar2(20) not null,
    totalPrice number not null,
    quantitiy int not null   
);

--4. ��ٱ��� ���̺� ����
create table cart_t (
    cartId varchar(10) PRIMARY KEY,
    id varchar2(20) REFERENCES customer_t (id),
    productId varchar(20) REFERENCES product_t (productId),
    cartstatus char(1) default 'N'
);

--5. ī�װ� ���̺� ����
create table category_t (
    categoryId varchar(20) PRIMARY KEY,
    categoryName varchar(20) not null,
    categoryInner varchar(10) not null
);

--6. ��ǰ�� ���̺� ����
create table review_t (
    reviewId varchar(10) PRIMARY KEY,
    id varchar(20) REFERENCES customer_t (id),
    orderId varchar(20) REFERENCES order_t (orderId),
    review long not null,
    reviewStar int not null
);

--7. �󼼼��� ���̺� ����
create table description_t (
    productId varchar(10) REFERENCES product (productId), --���ڵ� ����
    productPeriod varchar(10), --�Ƚɻ�����
    productSize integer default (''), -- ũ��
    productFrom long default('��ǰ�� Ȥ�� �̹�������'), --������, ����ǰ�� ��� �����ڸ� �Բ� ǥ��
    productStorage varchar(10), --������� �Ǵ� ��޹��
    productName varchar(10) --ǰ�� �Ǵ� ��Ī  
);


    
    