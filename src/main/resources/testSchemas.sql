-- 유저 등록 --
delete from user;
alter table user auto_increment = 1;
insert into user(email,password,name,nickname)
values("mingi@ssafy.com","qwer1234","손민기","밍키"),
("yeon@ssafy.com","qwer1234","최연준","연주니");
select * from user;

-- 그룹 등록 --
delete from `group`;
alter table `group` auto_increment = 1;
insert into `group`(group_name,type)
values ("민기의 러닝모임","러닝"),
("연준이의 등산모임","등산");
select * from `group`;

-- 그룹에 게시글 --
delete from board;
alter table board auto_increment = 1;
insert into board(group_id, content, writer)
values(1,"1번 그룹 1번 보드", 1),
(1,"1번 그룹 2번 보드", 1),
(1,"1번 그룹 3번 보드", 1),
(2,"2번 그룹 1번 보드", 2),
(2,"2번 그룹 2번 보드", 2),
(2,"2번 그룹 3번 보드", 2)
;
select * from board;

-- 게시글에 댓글 --
delete from comment_board;
alter table comment_board auto_increment = 1;
INSERT INTO comment_board (board_idx,content,writer)
        VALUES (1, '1번 보드 댓글1', 1),
        (1, '1번 보드 댓글2', 1),
        (1, '1번 보드 댓글3', 1),
        (2, '2번 보드 댓글1', 2),
        (2, '2번 보드 댓글2', 2),
        (3, '3번 보드 댓글1', 2),
        (3, '3번 보드 댓글2', 2);
select * from comment_board;      

-- 그룹에 공지사항 --
delete from notice;
alter table notice auto_increment = 1;
insert into notice (group_id, title, content, writer)
values(1, "제목1", "1번 그룹 1번 공지", 1),
(1, "제목2", "1번 그룹 2번 공지", 1),
(1, "제목3", "1번 그룹 3번 공지", 1),
(2, "제목1", "2번 그룹 1번 공지", 2),
(2, "제목2", "2번 그룹 2번 공지", 2),
(2, "제목3", "2번 그룹 3번 공지", 2);
select * from notice;

-- 공지사항 댓글 --
delete from comment_notice;
alter table comment_notice auto_increment = 1;
INSERT INTO comment_notice (notice_idx,content,writer)
        VALUES (1, '1번 공지 댓글1', 1),
        (1, '1번 공지 댓글2', 1),
        (1, '1번 공지 댓글3', 1),
        (2, '2번 공지 댓글1', 2),
        (2, '2번 공지 댓글2', 2),
        (3, '3번 공지 댓글1', 2),
        (3, '3번 공지 댓글2', 2);
select * from comment_notice;     
