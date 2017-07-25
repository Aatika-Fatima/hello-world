drop table group_authorities if exists;
drop table group_members if exists; 
drop table groups if exists;
drop table authorities if exists;
drop table users if exists;

create table users(username varchar(50) primary key, 
					password varchar(50) not null,
					enabled boolean not null);
					
--Create table to store authrities
create table authorities( 
username varchar(50) not null,
authority varchar(50)not null,
constraint authorities_users_username_fk foreign key(username) references users(username));

create table groups(
group_id number not null primary key,
group_name varchar not null);

create table group_members(
group_id number not null, 
username varchar(50) not null, 
constraint groupmembers_groups_group_id_fk foreign key(group_id) references groups(group_id),
constraint group_members_users_username_fk foreign key(username) references users(username)

);

create table group_authorities(
group_id number not null, 
authority varchar(50) not null,
constraint group_authorities_groups_group_id_fk foreign key(group_id) references groups(group_id)
 );
