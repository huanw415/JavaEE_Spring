CREATE DATABASE users_management;
USE users_management;

CREATE TABLE USER
(
  Id INT AUTO_INCREMENT primary key,
  Name VARCHAR(50) NOT NULL,
  Gender VARCHAR(10) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  Age INT
);

INSERT INTO USER (Name, Gender, Email, Age) VALUES ('赵明', '男', 'zhaoming@outlook.com', 20);
INSERT INTO USER (Name, Gender, Email, Age) VALUES ('小黄', '女', 'xiaohuang@outlook.com', 18);
INSERT INTO USER (Name, Gender, Email, Age) VALUES ('王丽', '女', 'wangli@outlook.com', 20);

grant all privileges on *.* to user@'localhost' identified by "root" with grant option;
flush privileges;