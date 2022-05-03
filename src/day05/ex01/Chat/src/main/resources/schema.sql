create schema if not exists chat;

create table chat.user
(
    id BIGSERIAL primary key,
    login VARCHAR(50) not null,
    password VARCHAR(50) not null,
    rooms_id int[],
    chatroom_id int[]
);

create table chat.chatroom
(
    id BIGSERIAL primary key,
    name VARCHAR(50) not null,
    owner_id int not null references chat.user(id),
    list_messages int[]
);

create table chat.message
(
    id BIGSERIAL primary key,
    author int references chat.user(id),
    room int not null references chat.chatroom(id),
    mText VARCHAR(50) not null,
    mDate timestamp
);

-- drop table chat.user;
-- drop table chat.chatroom;
-- drop table chat.message;
drop table chat.user CASCADE;
drop table chat.chatroom CASCADE;
drop table chat.message CASCADE;