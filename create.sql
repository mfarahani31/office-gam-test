create sequence hibernate_sequence start with 1 increment by 1
create table office (id bigint not null, office_code varchar(255), in_active boolean, office_name varchar(29) not null, provider varchar(255) not null, primary key (id))
alter table office add constraint UK_awe1v1y6jxu7vcqmbc8xtvxyk unique (office_code)
alter table office add constraint UK_nv399tmveiw6ubmsgtigdme9x unique (office_name)
