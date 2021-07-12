SELECT name from (
SELECT id, name, COUNT(subject_id)
FROM student s inner join backlog b on s.id = b.student_id
GROUP BY id, name
) as t1
