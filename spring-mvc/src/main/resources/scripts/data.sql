delete from verificationtoken; 
delete from author;
delete from category;
delete from difficulty_level; 
delete from question;
delete from role_privlege; 
delete from passwordresettoken;
delete from privlege; 
delete from USERS_ROLE;
delete from role; 
delete from users;
delete from persistent_logins;
--
--create table  persistent_logins ( 
--  username varchar2(100) not null, 
--  series varchar2(64) primary key, 
--  token varchar2(64) not null, 
--  last_used timestamp not null
--);

insert into privlege values( 1, 'CREATE_USER') ;
insert into privlege values( 2, 'DELETE_USER') ;
insert into privlege values( 3, 'EDIT_USER') ;
insert into privlege values( 4, 'READ_USER') ;
insert into privlege values( 5, 'CHANGE_PASSWORD_PRIVILEGE') ;
insert into privlege values( 6, 'CREATE_CATEGORY') ;

insert into role values( 1, 'ROLE_USER'); 
insert into role values( 2, 'ROLE_ADMIN');
insert into role values( 3, 'ROLE_REGISTSERED_USER'); 

insert into role_privlege values( 1, 4);
insert into role_privlege values( 2, 1);
insert into role_privlege values( 2, 2);
insert into role_privlege values( 2, 3);
insert into role_privlege values( 2, 5);
insert into role_privlege values( 2, 6);
insert into role_privlege values( 3, 4);
--insert into users table
insert into users(id, email,enabled, password,username)values(1,'aatika08@gmail.com',1,'aatika08','aatika');
insert into users(id, email,enabled, password,username)values(2,'hamza.hamziya@gmail.com',1,'hamza123','hamza123');
insert into users(id, email,enabled, password,username)values(3,'aatika08@yahoo.com',1,'fatima08','fatima');

insert into users_role(user_id, roles_id) values( 1, 1); 
insert into users_role(user_id, roles_id) values( 2, 2);
insert into users_role(user_id, roles_id) values( 3, 3);
insert into verificationtoken(tokenid,expirydate,token,user_id ) values(1, sysdate+1, 'a0accbd7-f90a-418d-b044-499a8d2fd8db', 1);--active token
insert into verificationtoken(tokenid, expirydate, token, user_id) values(2, sysdate-2,'expiredd-f90a-418d-b044-499a8d2fd8db',2);--expired token


insert into DIFFICULTY_LEVEL(DIFFICULTY_ID,DIFFICULTY_NAME) values( 1, 'EASY'); 
insert into DIFFICULTY_LEVEL(DIFFICULTY_ID,DIFFICULTY_NAME) values(2, 'MEDIUM');
insert into DIFFICULTY_LEVEL(DIFFICULTY_ID,DIFFICULTY_NAME) values(3, 'HIGH');
 
insert into category(category_id, category_name) values( 1, 'JAVA'); 
insert into category(category_id, category_name) values(2, 'C++'); 
insert into category(category_id, category_name) values(3, 'PHP');
 
insert into author(author_id, enabled) values(1, 1); 
insert into author(author_id, enabled) values(2, 0);
 

commit;
commit;
--select distinct roles_id from role_privlege
--where privleges_id in ( select id
--from privlege where name in ('CREATE_USER','DELETE_USER','EDIT_USER'))

--delete from user;
--select * from user;
--delete from authorities;
--delete from permissions;
--delete from users;
--
--drop table authorities; 
--drop table permissions;
--drop table users;
--
--
--create table users (
--username varchar(50) not null primary key, 
--password varchar(60) not null, 
--enabled boolean not null);
--
--create table authorities(
--username varchar(50) not null, 
--authority varchar(50) not null, 
--constraint fk_authorities_user foreign key(username) references users(username));
--
--create unique index ix_auth_username on authorities(username, authority);
--
--insert into users(username, password, enabled) values( 'aatika', '$2a$10$y5zE8YrQVhfVe0HppVi5q.XvPcowqDPtNRKv0Xnky1zTfyIc3DSvG', true);
--insert into users(username, password, enabled) values( 'fatima', '$2a$10$y5zE8YrQVhfVe0HppVi5q.XvPcowqDPtNRKv0Xnky1zTfyIc3DSvG', false);
--
--insert into authorities(username, authority) values('aatika','ROLE_USER');
--insert into authorities(username, authority) values('aatika','ROLE_ADMIN');
--insert into authorities(username, authority) values('fatima','ROLE_USER');
--
--create table permissions( 
--username varchar(50) not null, 
--target varchar(50) not null, 
--permission varchar(50) not null, 
--constraint fk_permissions_users foreign key(username) references users(username));
--
--create unique index ix_perm_username on permissions(username, target, permission);
--
--insert into permissions (username, target, permission) values('aatika', 'java.lang.String','createUser');
--
--select * from users;
--
--commit;