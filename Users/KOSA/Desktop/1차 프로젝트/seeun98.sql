drop table customer_t;
create table customer_t
(
    customerId varchar2(20) primary key,
    pwd varchar2(20) not null,
    name varchar(20) not null,
    birth Date not null,
    address varchar2(50) not null,
    telNo varchar2(20) not null,
    joinDate Date not null
);

drop procedure insertCustomer;
create or replace procedure insertCustomer
(
    c_customerId in customer_t.customerId%type,
    c_customerPwd in customer_t.pwd%type,
    c_name in customer_t.name%type,
    c_birth in customer_t.birth%type,
    c_address in customer_t.address%type,
    c_telNo in customer_t.telNo%type,
    c_joinDate in customer_t.joinDate%type
)
is
begin
  
    insert into customer_t
    values(c_customerId, c_customerPwd, c_name, c_birth, c_address, c_telNo, c_joinDate);
    commit;
end;
/

drop procedure selectCustomer;
create or replace procedure selectCustomer
(
    
)


    