insert into authors values (1,'suzuki');
insert into authors values (2,'tanaka');

insert into books values (1, 1, 'Superman');
insert into books values (2, 1, 'System');
insert into books values (3, 2, 'Trade');
insert into books values (4, 2, 'Tomcat');

insert into users values (1,'suzuki', 'suzuki@example.com');
insert into users values (2,'tanaka', 'tanaka@example.com');

insert into projects values (1,'seede');
insert into projects values (2,'fukaru');

insert into user_to_project values (1, 1);
insert into user_to_project values (2, 2);

insert into tasks values (1, 1, 1,'seede - frontend');
insert into tasks values (2, 1, 1,'seede - backend');
insert into tasks values (3, 2, 1,'fukaru - frontend');
insert into tasks values (4, 2, 1,'fukaru - backend');
