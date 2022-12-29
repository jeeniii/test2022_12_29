create table member3 (
id varchar(100) not null,
pwd varchar(100) not null,
nick_name varchar(100) not null,
reg_at datetime default current_timestamp,
last_login datetime,
primary key(id));

create table board3(
bno int not null auto_increment,
title varchar(100) not null,
writer varchar(100) not null,
content text,
reg_date datetime default current_timestamp,
primary key(bno));

create table comment2(
cno int not null auto_increment,
bno int default -1,
writer varchar(100) default "unknown",
content varchar(1000) not null,
reg_at datetime default current_timestamp,
primary key(cno));