/*JINISHA KATARIA 
TASK1 
STUDENT INFORMATION SYSTEM*/

create table Students(student_id int primary key,first_name varchar(20),last_name varchar(20),date_of_birth date,email varchar(60),phone_number varchar(100));
insert into Students (student_id,first_name,last_name,date_of_birth,email,phone_number)
values
('1001', 'John', 'Doe', '2000-02-15', 'johndoe@example.com', '+1-555-123-4567'),
('1002', 'Emily', 'Smith', '1999-06-21', 'emilysmith@example.com', '+1-555-234-5678'),
('1003', 'Michael', 'Johnson', '2001-11-03', 'michaelj@example.com', '+1-555-345-6789'),
('1004', 'Sarah', 'Williams', '1998-04-12', 'sarahwilliams@example.com', '+1-555-456-7890'),
('1005', 'David', 'Brown', '2002-09-27', 'davidbrown@example.com', '+1-555-567-8901'),
('1006', 'Laura', 'Jones', '2000-12-05', 'laurajones@example.com', '+1-555-678-9012'),
('1007', 'James', 'Garcia', '1999-07-17', 'jamesgarcia@example.com', '+1-555-789-0123'),
('1008', 'Jessica', 'Martinez', '2001-03-30', 'jessicamartinez@example.com', '+1-555-890-1234'),
('1009', 'Robert', 'Lee', '1998-10-10', 'robertlee@example.com', '+1-555-901-2345'),
('1010', 'Olivia', 'Davis', '2002-01-22', 'oliviadavis@example.com', '+1-555-012-3456');
create table Teacher(teacher_id int primary key,first_name varchar(20),last_name varchar(20),email varchar(100));
insert into Teacher (teacher_id,first_name,last_name,email)
values
('2001', 'Alice', 'Johnson', 'alicejohnson@example.com'),
('2002', 'Brian', 'Smith', 'briansmith@example.com'),
('2003', 'Catherine', 'Lee', 'catherinelee@example.com'),
('2004', 'Daniel', 'Garcia', 'danielgarcia@example.com'),
('2005', 'Eva', 'Martinez', 'evamartinez@example.com'),
('2006', 'Frank', 'Williams', 'frankwilliams@example.com'),
('2007', 'Grace', 'Brown', 'gracebrown@example.com'),
('2008', 'Henry', 'Davis', 'henrydavis@example.com'),
('2009', 'Isabella', 'Miller', 'isabellamiller@example.com'),
('2010', 'Jacob', 'Wilson', 'jacobwilson@example.com');
create table Courses(course_id int primary key,course_name varchar(50),credits int,teacher_id int,constraint fk_teacher foreign key(teacher_id)references Teacher(teacher_id));
insert into Courses(course_id,course_name,credits,teacher_id)
values
('3001', 'Mathematics', 4, '2001'),
('3002', 'Physics', 3, '2002'),
('3003', 'Chemistry', 4, '2003'),
('3004', 'Biology', 3, '2004'),
('3005', 'History', 2, '2005'),
('3006', 'Geography', 2, '2006'),
('3007', 'English Literature', 3, '2007'),
('3008', 'Computer Science', 4, '2008'),
('3009', 'Philosophy', 2, '2009'),
('3010', 'Economics', 3, '2010');
create table Enrollments(enrollment_id int primary key,student_id int,course_id int,enrollment_date date,constraint fk_student foreign key(student_id)references Students(student_id),constraint fk_course foreign key(course_id)references Courses(course_id));
insert into Enrollments(enrollment_id,student_id,course_id,enrollment_date)
values
('4001', '1001', '3001', '2024-01-10'),
('4002', '1002', '3002', '2024-01-11'),
('4003', '1003', '3003', '2024-01-12'),
('4004', '1004', '3004', '2024-01-13'),
('4005', '1005', '3005', '2024-01-14'),
('4006', '1006', '3006', '2024-01-15'),
('4007', '1007', '3007', '2024-01-16'),
('4008', '1008', '3008', '2024-01-17'),
('4009', '1009', '3009', '2024-01-18'),
('4010', '1010', '3010', '2024-01-19');
create table Payments(payment_id int primary key,student_id int,amount int,payment_date date,constraint fk_studentt foreign key(student_id)references Students(student_id));
insert into Payments(payment_id,student_id,amount,payment_date)
values
('5001', '1001', 500, '2024-01-15'),
('5002', '1002', 400, '2024-01-16'),
('5003', '1003', 300, '2024-01-17'),
('5004', '1004', 450, '2024-01-18'),
('5005', '1005', 600, '2024-01-19'),
('5006', '1006', 500, '2024-01-20'),
('5007', '1007', 700, '2024-01-21'),
('5008', '1008', 350, '2024-01-22'),
('5009', '1009', 550, '2024-01-23'),
('5010', '1010', 400, '2024-01-24');
show tables;
/*1*/
select*from Students;
insert into Students(student_id,first_name,last_name,date_of_birth,email,phone_number)
values('1011','John','Doe','1995-08-15','john.doe@example.com','1234567890');
/*2*/
insert into Enrollments(enrollment_id,student_id,course_id,enrollment_date)
values('4011','1002','3005','2024-10-19');
select*from Enrollments;
/*3*/
update Teacher set email='alice.johnson12@example.com' where teacher_id='2001';
select*from Teacher;
/*4*/
delete from Enrollments where student_id=1003 and course_id='3009';
select* from Enrollments;
/*5*/
update Courses set teacher_id=2004 where course_id=3003;
select*from Courses;
/*6*/
delete from Students where student_id=1005;/* will not delete because student_id is used in other tables as foreign key*/
delete from Enrollments where student_id=1005;
delete from Payments where student_id=1005;
delete from Students where student_id=1005;
select*from Students;
/*7*/
update Payments set amount=650 where payment_id=5009;
select*from Payments;


