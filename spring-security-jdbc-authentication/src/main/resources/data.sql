
insert into groups(group_id , group_name)values(1,'ADMINISTRATOR');
insert into group_authorities(group_id, authority)values(1, 'ROLE_ADMIN');

 
insert into groups(group_id , group_name)values(2,'USERS');
insert into group_authorities(group_id, authority)values(2, 'ROLE_USER');
 
insert into groups(group_id , group_name)values(3,'GUEST');
insert into group_authorities(group_id, authority)values(1, 'ROLE_GUEST');

 
insert into users(username, password, enabled) values('aatika','fatima',true);
insert into users(username, password, enabled) values('aaliya', 'fatima',true);
insert into users(username, password, enabled) values('huma','fatima',false);

insert into authorities(username, authority)values('aatika','ROLE_ADMIN'); 
insert into authorities(username, authority)values('aaliya','ROLE_USER');
insert into authorities(username, authority)values('huma','ROLE_GUEST');

--insert into group_members(1, 'aatika');
--insert into group_members(2,'aaliya');
--insert into group_members(3, 'huma');
