update `memo`
set `title` = '제목', `content` = '내용'
where `id` = 1;

DELETE FROM `memo`
WHERE `id` = 1;
desc memo;
select * from memo;