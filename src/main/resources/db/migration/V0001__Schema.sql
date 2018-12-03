CREATE TABLE student(
  id int AUTO_INCREMENT PRIMARY KEY,
  email varchar(2000) not null UNIQUE,
  name varchar(200) not null,
  enabled boolean not null
);

INSERT INTO student (email, name, enabled) VALUES ('aaa@aaa.com', 'aaa', true);
INSERT INTO student (email, name, enabled) VALUES ('bbb@bbb.com', 'bbb', true);
INSERT INTO student (email, name, enabled) VALUES ('ccc@ccc.com', 'ccc', true);
INSERT INTO student (email, name, enabled) VALUES ('ddd@ddd.com', 'ddd', true);
INSERT INTO student (email, name, enabled) VALUES ('eee@eee.com', 'eee', true);
INSERT INTO student (email, name, enabled) VALUES ('fff@fff.com', 'fff', true);
INSERT INTO student (email, name, enabled) VALUES ('ggg@ggg.com', 'ggg', true);
INSERT INTO student (email, name, enabled) VALUES ('hhh@hhh.com', 'hhh', true);
INSERT INTO student (email, name, enabled) VALUES ('iii@iii.com', 'iii', true);
INSERT INTO student (email, name, enabled) VALUES ('jjj@jjj.com', 'jjj', true);
INSERT INTO student (email, name, enabled) VALUES ('kkk@kkk.com', 'kkk', true);
INSERT INTO student (email, name, enabled) VALUES ('lll@lll.com', 'lll', true);
INSERT INTO student (email, name, enabled) VALUES ('mmm@mmm.com', 'mmm', true);
INSERT INTO student (email, name, enabled) VALUES ('nnn@nnn.com', 'nnn', true);
INSERT INTO student (email, name, enabled) VALUES ('ooo@ooo.com', 'ooo', true);
INSERT INTO student (email, name, enabled) VALUES ('ppp@ppp.com', 'ppp', true);
INSERT INTO student (email, name, enabled) VALUES ('qqq@qqq.com', 'qqq', true);
INSERT INTO student (email, name, enabled) VALUES ('rrr@rrr.com', 'rrr', true);
INSERT INTO student (email, name, enabled) VALUES ('sss@sss.com', 'sss', true);
INSERT INTO student (email, name, enabled) VALUES ('ttt@ttt.com', 'ttt', true);
INSERT INTO student (email, name, enabled) VALUES ('uuu@uuu.com', 'uuu', true);
INSERT INTO student (email, name, enabled) VALUES ('vvv@vvv.com', 'vvv', true);
INSERT INTO student (email, name, enabled) VALUES ('www@www.com', 'www', true);
INSERT INTO student (email, name, enabled) VALUES ('xxx@xxx.com', 'xxx', false);
INSERT INTO student (email, name, enabled) VALUES ('yyy@yyy.com', 'yyy', false);
INSERT INTO student (email, name, enabled) VALUES ('zzz@zzz.com', 'zzz', false);
