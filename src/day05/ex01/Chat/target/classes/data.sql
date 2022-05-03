INSERT INTO chat.user (login, password, rooms_id, chatroom_id) VALUES ('user', '19991', '{1}', '{1, 2, 5}');
INSERT INTO chat.user (login, password, rooms_id, chatroom_id) VALUES ('spider', 'qwerty', '{1, 2}', '{1, 3, 2}');
INSERT INTO chat.user (login, password, rooms_id, chatroom_id) VALUES ('pig', 'asdfg', '{3}', '{1, 3, 4}');
INSERT INTO chat.user (login, password, rooms_id, chatroom_id) VALUES ('tiger', 'zxcvb', '{}', '{1, 2}');
INSERT INTO chat.user (login, password, rooms_id, chatroom_id) VALUES ('scorpion', '123456', '{4, 5}', '{1, 2}');

INSERT INTO chat.chatroom (name, owner_id, list_messages) VALUES ('Smoking', 1, '{1, 2, 6}');
INSERT INTO chat.chatroom (name, owner_id, list_messages) VALUES ('Lab', 2, '{3, 4}');
INSERT INTO chat.chatroom (name, owner_id, list_messages) VALUES ('SQL', 3, '{5, 1, 3}');
INSERT INTO chat.chatroom (name, owner_id, list_messages) VALUES ('Music', 4, '{2, 3, 4}');
INSERT INTO chat.chatroom (name, owner_id, list_messages) VALUES ('school42', 5, '{1, 2, 3, 4}');

INSERT INTO chat.message (author, room, mtext, mdate) VALUES (1, 1, 'How are you?', '2022-04-24 19:15:01');
INSERT INTO chat.message (author, room, mtext, mdate) VALUES (2, 2, 'TC-TC-TC', '2022-04-22 11:42:32');
INSERT INTO chat.message (author, room, mtext, mdate) VALUES (3, 3, 'SQL is easy', '2022-03-21 21:17:15');
INSERT INTO chat.message (author, room, mtext, mdate) VALUES (4, 4, 'tij, NOOOOOOOOO!!!', '2022-02-25 20:20:20');
INSERT INTO chat.message (author, room, mtext, mdate) VALUES (5, 5, 'Hi', '2022-02-21 09:11:43');
INSERT INTO chat.message (author, room, mtext, mdate) VALUES (1, 2, 'Hello', '2022-04-21 15:45:00');