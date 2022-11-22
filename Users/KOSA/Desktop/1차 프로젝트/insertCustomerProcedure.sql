create table t1 (
id varchar(20),
birth date
);

create or replace procedure t1pro (
    t_id in t1.id%type,
    t_birth in t1.birth%type
)
as
begin
    insert into t1(id, birth)
    values (t_id, t_birth);
    commit;
end;
/

