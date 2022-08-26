insert into users values (1, null, 'denis@mail.ru', 1, 'Denis', '362rrr', '', '2021-01-01 10:30:30');
insert into users values (2, null, 'oleg@mail.ru', 0, 'Oleg', '555pp', '', '2021-02-03 11:20:50');
insert into users values (3, null, 'katya@mail.ru', 0, 'Katya', '23254h', '', '2021-01-11 11:25:50');
insert into posts values (1, 1, 'ACCEPTED', 1, 'Some text in post with tag Skillbox #1', '2021-06-11 10:30:20', 'Test post #1', 2, 1);
insert into posts values (2, 0, 'NEW', NULL, 'Some text in post with tag Java #3', '2021-02-10 10:30:20', 'Test post #2', 2, 1);
insert into posts values (3, 1, 'NEW', NULL, 'Some text in post with tag Mysql #4', '2021-05-17 10:30:20', 'Test post #3', 2, 2);
insert into posts values (4, 1, 'ACCEPTED', 1, 'Some text in post with tag Skillbox #2', '2021-05-13 10:30:20', 'Test post #4', 2, 2);
insert into posts values (5, 0, 'NEW', NULL, 'Some text in post with tag Java #1', '2021-07-18 10:30:20', 'Test post #5', 2, 3);
insert into posts values (6, 1, 'ACCEPTED', 1, 'Some text in post with tag Mysql #3', '2021-03-10 10:30:20', 'Test post #6', 2, 2);
insert into posts values (7, 1, 'NEW', NULL, 'Some text in post with tag Skillbox #3', '2021-03-17 10:30:20', 'Test post #7', 2, 2);
insert into posts values (8, 1, 'DECLINED', 1, 'Some text in post with tag Java #2', '2021-03-22 10:30:20', 'Test post #8', 2, 1);
insert into posts values (9, 0, 'DECLINED', 1, 'Some text in post with tag Mysql #2', '2021-01-01 10:30:20', 'Test post #9', 2, 2);
insert into posts values (10, 1, 'ACCEPTED', 1, 'Some text in post with tag Mysql #1', '2021-04-13 10:30:20', 'Test post #10', 2, 1);
insert into posts values (11, 1, 'DECLINED', 1, 'Some text in post with tag Mysql #1', '2021-04-17 10:30:20', 'Test post #11', 2, 2);
insert into tags values (1, 'Skillbox');
insert into tags values (2, 'Java');
insert into tags values (3, 'Mysql');
insert into tag2post values (1, 1, 1);
insert into tag2post values (2, 2, 2);
insert into tag2post values (3, 3, 3);
insert into tag2post values (4, 4, 1);
insert into tag2post values (5, 5, 2);
insert into tag2post values (6, 6, 3);
insert into tag2post values (7, 7, 1);
insert into tag2post values (8, 8, 2);
insert into tag2post values (9, 9, 3);
insert into tag2post values (10, 10, 3);
insert into tag2post values (11, 11, 3);
insert into post_comments values (1, NULL, 'Comment #1', '2021-06-15 10:30:21', 1, 1);
insert into post_comments values (2, NULL, 'Comment #2', '2021-03-15 10:30:21', 6, 3);
insert into post_comments values (3, NULL, 'Comment #3', '2021-05-15 10:30:21', 3, 2);
insert into post_comments values (4, 1, 'Comment #5', '2021-05-15 10:30:21', 1, 3);
insert into post_comments values (5, NULL, 'Comment #4', '2021-05-15 10:30:21', 7, 2);
insert into post_comments values (6, 2, 'Comment #6', '2021-05-15 10:30:21', 6, 1);
insert into post_votes values (1, '2021-05-15 10:30:21', 1, 1, 1);
insert into post_votes values (2, '2021-04-11 10:25:21', 0, 2, 1);