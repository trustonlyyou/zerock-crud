insert into tbl_borad(title, content, writer) values ('제목입니다.', '내용입니다.', 'user00');

select * from tbl_borad where bno = 1;

select * from tbl_board where bno > 0 order by desc;

update tbl_board set title='수정된 제목' where bno = 1;

delete from tbl_board where bno = 1;
