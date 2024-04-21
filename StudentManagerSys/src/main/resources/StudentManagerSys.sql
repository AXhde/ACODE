
drop table mis_admin;
create table mis_admin(
	admName varchar2(256) not null,
	admNum varchar2(256) not null,
	admPsw varchar2(256) not null
);

drop table mis_teacher;
create table mis_teacher(
	teaId number(7) primary key,
	teaNum varchar2(256) not null,
	teaName varchar2(256) not null,
	teaPhone varchar2(256) not null
);
drop sequence mis_teacher_teaId;
create sequence mis_teacher_teaId;

drop table mis_student;
create table mis_student(
	stuId number(7) primary key,
	stuNum varchar2(256) not null,
	stuName varchar2(256) not null,
	stuPsw varchar2(256) not null,
	clsName varchar2(256) not null,
	Sex varchar2(256) not null,
	stuPhone varchar2(256) not null,
	createDate varchar2(256) not null,
	stuAddress varchar2(256) not null,
	stuElse varchar2(256)
);
drop sequence mis_student_stuid;
create sequence mis_student_stuid;

drop table mis_courses;
create table mis_courses(
	couId number(7) primary key,
	couNum varchar2(256) not null,
	couName varchar2(256) not null,
	couhour varchar2(256) not null,
	teaName varchar2(256) not null
);
drop sequence mis_courses_couId;
create sequence mis_courses_couId;

drop table mis_score;
create table mis_score(
	scId number(7) primary key,
	stuNum varchar2(256) not null,
	couName varchar2(256) not null,
	scScore varchar2(256) not null
);
drop sequence mis_score_scId;
create sequence mis_score_scId;

drop table mis_class;
create table mis_class(
	clsId number(7) primary key,
	clsNum varchar2(256) not null,
	clsName varchar2(256) not null,
	teaName varchar2(256) not null,
	department varchar2(256) not null
);
drop sequence mis_class_clsId;
create sequence mis_class_clsId;



