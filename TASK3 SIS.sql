/*JINISHA KATARIA 
TASK2
STUDENT INFORMATION SYSTEM*/
use Systemm;
/*1*/
select s.student_id,s.first_name,sum(p.amount)as total_payment from Students s join Payments p on s.student_id=p.student_id where s.student_id='1003' group by s.student_id;
/*2*/
select c.course_id,c.course_name,count(*) as number_of_students from Courses c join Enrollments e on c.course_id=e.course_id group by c.course_id,c.course_name; 
/*3*/
select s.student_id,s.first_name,count(*) from Students s join Enrollments e on s.student_id=e.student_id where e.course_id is null group by  s.student_id,s.first_name  ;
/*4*/
select s.first_name,s.last_name,c.course_name from Students s join Enrollments e on s.student_id=e.student_id join Courses c on e.course_id=c.course_id;
/*5*/
select t.teacher_id,t.first_name,t.last_name,c.course_name from Teacher t join Courses c on t.teacher_id=c.teacher_id;
/*6*/
select s.student_id,s.first_name,s.last_name,e.enrollment_date,c.course_name from Students s join Enrollments e on s.student_id=e.student_id join Courses c on e.course_id=c.course_id where course_name='Mathematics'order by s.student_id asc;
/*7*/
select s.first_name,s.last_name from Payments p  left join   Students s on s.student_id= p.student_id where p.amount is null;
/*8*/
select c.course_id,course_name from Courses c left join Enrollments e on c.course_id=e.course_id where e.course_id is null;
/*9*/
select e1.student_id,count(*) as course_count from Enrollments e1 join Enrollments e2 on e1.student_id=e2.student_id and e1.course_id != e2.course_id group by e1.student_id having count(*)>1;
/*10*/
select t.teacher_id,t.first_name,c.course_name from Teacher t left join Courses c on t.teacher_id=c.teacher_id where c.course_name is null;
