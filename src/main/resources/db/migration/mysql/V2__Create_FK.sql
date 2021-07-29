alter table post_comments add constraint postCommentsPostIdFK foreign key (post_id) references posts (id);
alter table post_comments add constraint postCommentsUserIdFK foreign key (user_id) references users (id);
alter table post_votes add constraint postVotesPostIdFK foreign key (post_id) references posts (id);
alter table post_votes add constraint postVotesUserIdFK foreign key (user_id) references users (id);
alter table posts add constraint postsUserIdFK foreign key (user_id) references users (id);
alter table tag2post add constraint tag2postPostIdFK foreign key (post_id) references posts (id);
alter table tag2post add constraint tag2postTagIdFK foreign key (tag_id) references tags (id)