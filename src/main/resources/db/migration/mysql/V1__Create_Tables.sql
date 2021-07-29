create table
captcha_codes
(id integer not null, code varchar(255) not null, secret_code varchar(255) not null, time datetime(6) not null, primary key (id))
engine=InnoDB;
create table
global_settings
(id integer not null, code varchar(255) not null, name varchar(255) not null, value varchar(255) not null, primary key (id))
engine=InnoDB;
create table
hibernate_sequence
(next_val bigint)
engine=InnoDB;
create table
post_comments
(id integer not null, parent_id integer, text varchar(255) not null, time datetime(6) not null, post_id integer not null, user_id integer not null, primary key (id))
engine=InnoDB;
create table
post_votes
(id integer not null, time datetime(6) not null, value bit not null, post_id integer not null, user_id integer not null, primary key (id))
engine=InnoDB;
create table
posts
(id integer not null, is_active bit not null, moderation_status varchar(255) not null, moderator_id integer, text varchar(255) not null, time datetime(6) not null, title varchar(255) not null, view_count integer not null, user_id integer not null, primary key (id))
engine=InnoDB;
create table
tag2post
(id integer not null, post_id integer not null, tag_id integer not null, primary key (id))
engine=InnoDB;
create table
tags
(id integer not null, name varchar(255) not null, primary key (id))
engine=InnoDB;
create table
users
(id integer not null, code varchar(255), email varchar(255) not null, is_moderator bit not null, name varchar(255) not null, password varchar(255) not null, photo varchar(255), reg_time datetime(6) not null, primary key (id))
engine=InnoDB