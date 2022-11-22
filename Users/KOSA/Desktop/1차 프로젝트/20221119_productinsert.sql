CREATE TABLE T2 
( ID VARCHAR(10) PRIMARY KEY,
  PWD VARCHAR(20)
);

CREATE OR REPLACE PROCEDURE T2INSERT 
(
    I_ID IN T2.ID%TYPE,
    I_PWD IN T2.PWD%TYPE
)    
IS
BEGIN
    INSERT INTO T2(ID, PWD)
    VALUES (I_ID, I_PWD);
    COMMIT;
END;
/
DROP TABLE PRODUCT_T PURGE;
SELECT * FROM T1;

CREATE OR REPLACE PROCEDURE T1INSERT 
(
    T_ID IN T1.ID%TYPE,
    T_BIRTH IN T1.BIRTH%TYPE
)
IS
BEGIN
    INSERT INTO T1 (ID, BIRTH)
    VALUES (T_ID, T_BIRTH);
    COMMIT;
END;
/
select * from t1;

drop table customer_t;
create table customer_t
( 
    customerId varchar(50)  primary key,
    pwd varchar(50),
    name varchar(50),
    birth date,
    address varchar(50),
    telNo varchar(50),
    joinDate date
);

select * from customer_t;
delete customer_t
where address is null;
drop procedure customerInsert;
create or replace procedure customerInsert
(
    c_id in customer_t.customerId%type,
    c_pwd in customer_t.pwd%type,
    c_name in customer_t.name%type,
    c_birth in customer_t.birth%type,
    c_address in customer_t.address%type,
    
    c_telNo in customer_t.telNo%type,
    c_joinDate in customer_t.joinDate%type
)
is
begin
    insert into customer_t
    values(c_id, c_pwd, c_name, c_birth, c_address, c_telNo, c_joinDate);
    commit;
end;
/




drop table product_t purge;

create table product_t
(
    productId varchar(50) primary key,
    categoryId varchar(20),
    price number
);

create or replace procedure productProcedure
(
    p_productId in product_t.productId%type,
    p_categoryId in product_t.categoryId%type,
    p_price in product_t.price%type
)
is
begin
    insert into product_t
    values (p_productId, p_categoryId, p_price);
    commit;
end;
/


    



