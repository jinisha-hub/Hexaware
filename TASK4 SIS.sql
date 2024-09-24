/*1*/
use systemm;
select c.course_name,count(c.course_id) as numofstudents from Students s join Enrollments e on s.student_id=e.student_id join Courses c  using (course_id) group by c.course_name;
select* from Enrollments;
/*2*/
select s.first_name,s.last_name,p.amount from Students s join Payments p on s.student_id=p.student_id where p.amount= (select max(amount)from Payments);
/*3*/
select course_name, totalstudents
from (
    select c.course_id, c.course_name, count(*) as totalstudents
    from Courses c
    join enrollments e using(course_id)
    group by c.course_id, c.course_name
) as course_totals
where totalstudents = (
    select max(totalstudents)
    from (
        select count(*) as totalstudents
        from Courses c
        join enrollments e using(course_id)
        group by c.course_id
    ) as max_counts
);
/*4*/
select t.teacher_id, t.first_name, c.course_name, sum(p.amount) from Teacher t
join Courses c on t.teacher_id=c.teacher_id
join Enrollments e on c.course_id=e.course_id
join Payments p on e.student_id=p.student_id
group by t.teacher_id,t.first_name,c.course_name;
/*5*/
select count(*) from Courses;
select student_id, count(course_id) as enrolled_courses from Enrollments group by student_id;

select student_id 
from (select student_id, count(course_id) as enrolled_courses from Enrollments group by student_id) as student_enrollments
where enrolled_courses=(select count(*) from courses);
/*6*/
select teacher_id,first_name,last_name from Teacher
where teacher_id not in (select distinct teacher_id fromCcourses);
-/*7*/
select floor(datediff(current_date(), date_of_birth)/365.25) as age from Students;
select avg(age) from (select floor(datediff(current_date(), date_of_birth)/365.25) as age from Students) as student_age;
/*8*/
select c.course_name, c.course_id from Courses c
left join Enrollments e on c.course_id=e.course_id
where e.course_id is null;
/*9*/
select s.student_id, s.first_name, s.last_name ,c.course_name, sum(p.amount) as total_amount from Students s
join Enrollments e on e.student_id=s.student_id
join Courses c on c.course_id=e.course_id
join Payments p on s.student_id=p.student_id
group by s.student_id,s.first_name,s.last_name,c.course_name;
/*10*/
select student_id, first_name, last_name, payment_count 
from(select s.student_id,s.first_name,s.last_name,count(p.payment_id) as payment_count from Students s 
join Payments p on p.payment_id=s.student_id 
group by s.student_id,s.first_name,s.last_name) as payment_counter
where payment_count>1;
/*11*/
select s.student_id, s.first_name, s.last_name, sum(p.amount) as total_payment from Students s 
join Payments p on p.student_id=s.student_id
group by s.student_id, s.first_name,s.last_name;
/*12*/
select c.course_name, c.course_id , count(e.student_id) as student_count from Courses c
join Enrollments e on e.course_id=c.course_id
group by c.course_name, c.course_id;
/*13*/
select s.student_id, s.first_name,s.last_name, avg(p.amount) as average_payment from Students s
join Payments p on p.student_id=s.student_id
group by s.student_id,s.first_name,s.last_name;
