ALTER PROFILE DEFAULT LIMIT PASSWORD_VERIFY_FUNCTION NULL;
ALTER PROFILE DEFAULT LIMIT PASSWORD_VERIFY_FUNCTION verify_function_11G;

create user seeun98 identified by "dltpdms56A@";
drop user seeun98;

create user joilwoo identified by "CHOwhdlfdn1!";
drop user joilwoo;

create user seohyun identified by "Hyundai6!!";
drop user seohyun;

create user fpqthel235 identified by "Qkrhyundai235!";
drop user fpqthel235;

--권한 주기
grant create table to seeun98;
grant select any table to seeun98;
grant create session to seeun98;
grant create procedure to seeun98;
grant connect, resource to seeun98;
grant insert any table to seeun98;
grant update any table to seeun98;
grant all privileges to seeun98;
ALTER USER seeun98 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;


grant create table to joilwoo;
grant select any table to joilwoo;
grant create session to joilwoo;
grant create procedure to joilwoo;
grant connect, resource to joilwoo;
grant insert any table to joilwoo;
grant update any table to joilwoo;
ALTER USER joilwoo DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

grant create table to seohyun;
grant select any table to seohyun;
grant create session to seohyun;
grant create procedure to seohyun;
grant connect, resource to seohyun;
grant insert any table to seohyun;
grant update any table to seohyun;
ALTER USER seohyun DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;


grant create table to fpqthel235;
grant select any table to fpqthel235;
grant create session to fpqthel235;
grant create procedure to fpqthel235;
grant connect, resource to fpqthel235;
grant insert any table to fpqthel235;
grant update any table to fpqthel235;
ALTER USER fpqthel235 DEFAULT TABLESPACE USERS QUOTA UNLIMITED ON USERS;

