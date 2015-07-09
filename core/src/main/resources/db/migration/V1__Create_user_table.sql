USE users_management;

CREATE TABLE USER
(
  Id INT AUTO_INCREMENT primary key,
  Name VARCHAR(50) NOT NULL,
  Gender VARCHAR(10) NOT NULL,
  Email VARCHAR(100) NOT NULL,
  Age INT
);

grant all privileges on *.* to 'root'@'%' with grant option;
flush privileges;