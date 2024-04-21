insert into mis_admin values('Admin1','A0001','jsd1707');
insert into mis_admin values('Admin2','A0002','jsd1707');
insert into mis_admin values('Admin3','A0003','jsd1707');

insert into mis_teacher values(mis_teacher_teaId.nextval,'T2014999','张万礼','18888888888');
insert into mis_teacher values(mis_teacher_teaId.nextval,'T2014998','卢彪','13188888888');
insert into mis_teacher values(mis_teacher_teaId.nextval,'T2014997','谈成访','17788888888');

insert into mis_student values(mis_student_stuid.nextval,'S20140001','张绍鑫','112303','计科1班','男','18895707271','2018-05-01','贵州省 六盘水市','宏智科技');
insert into mis_student values(mis_student_stuid.nextval,'S20140002','陈丽','jsd1707','网工1班','女','18812345678','2018-05-01','北京市 海淀区','未来教育');
insert into mis_student values(mis_student_stuid.nextval,'S20140003','王杰','jsd1707','网工1班','女','18895709999','2018-05-02','安徽省 亳州市','666哦');
insert into mis_student values(mis_student_stuid.nextval,'S20140004','刘辉','jsd1707','计科1班','女','18212846967','2018-05-03','江苏省 常州市','常州');
insert into mis_student values(mis_student_stuid.nextval,'S20140005','张兵','jsd1707','计科1班','男','18895707271','2018-05-03','苏州市 姑苏区','实习中');
insert into mis_student values(mis_student_stuid.nextval,'S20140006','王孟玉','jsd1707','计科1班','男','18895000271','2018-05-04','安徽省 宿州市','在校生');
insert into mis_student values(mis_student_stuid.nextval,'S20140007','石文','jsd1707','软工1班','男','15115707271','2018-05-04','安徽省 蚌埠市','公务员');
insert into mis_student values(mis_student_stuid.nextval,'S20140008','杨凯','jsd1707','网工1班','男','18895701234','2018-05-05','北京市 昌平区','在首都');
insert into mis_student values(mis_student_stuid.nextval,'S20140009','舒沙沙','jsd1707','网工1班','女','17795707271','2018-05-05','青海省 西宁市','公务员');
insert into mis_student values(mis_student_stuid.nextval,'S20140010','王其华','jsd1707','计科2班','男','13195707271','2018-05-05','安徽省 亳州市','公务员');
insert into mis_student values(mis_student_stuid.nextval,'S20140011','吴跃进','jsd1707','计科1班','男','15895707271','2018-05-06','上海市 徐汇区','公务员');

insert into mis_courses values(mis_courses_couId.nextval,'COU999','JavaEE','60','谈成访');
insert into mis_courses values(mis_courses_couId.nextval,'COU998','Oracle','28','张万礼');
insert into mis_courses values(mis_courses_couId.nextval,'COU997','C#','34','谈成访');
insert into mis_courses values(mis_courses_couId.nextval,'COU996','.NET','60','张万礼');
insert into mis_courses values(mis_courses_couId.nextval,'COU995','C++','40','卢彪');

insert into mis_score values(mis_score_scId.nextval,'S20140002','JavaEE','100');
insert into mis_score values(mis_score_scId.nextval,'S20140002','Oracle','80');
insert into mis_score values(mis_score_scId.nextval,'S20140004','JavaEE','0');
insert into mis_score values(mis_score_scId.nextval,'S20140004','C#','60');
insert into mis_score values(mis_score_scId.nextval,'S20140006','JavaEE','100');
insert into mis_score values(mis_score_scId.nextval,'S20140002','C++','98');

insert into mis_class values(mis_class_clsId.nextval,'CLS999','计科1班','卢彪','计算机科学与技术');
insert into mis_class values(mis_class_clsId.nextval,'CLS998','网工1班','张万礼','网络工程');
insert into mis_class values(mis_class_clsId.nextval,'CLS997','计科2班','谈成访','计算机科学与技术');
insert into mis_class values(mis_class_clsId.nextval,'CLS996','软工1班','卢彪','软件工程');
