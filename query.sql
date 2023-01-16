-- Get all class with name and subject
select mark.ID, user.firstname, user.lastname, subject.name, mark.homework_mark, mark.midtern_mark, mark.final_mark, mark.year 
from mark INNER JOIN user ON mark.user_id = user.ID
INNER JOIN subject ON mark.subject_id = subject.ID;

-- Get all user
select * from user;

-- Get all subject
select * from subject;

-- Get own mark
select mark.ID, subject.name, mark.homework_mark, mark.midtern_mark, mark.final_mark, mark.year
from mark INNER JOIN subject ON mark.subject_id = subject.ID
where mark.user_id = 1;