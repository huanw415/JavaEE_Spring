USE users_management;

CREATE TABLE EMPLOYEE
(
  Id INT AUTO_INCREMENT primary key,
  Name VARCHAR(50) NOT NULL,
  Role VARCHAR(10) NOT NULL,
  UserId INTO NOT NULL,
  FOREIGN KEY (UserId) REFERENCES USER(Id),
  PRIMARY KEY (Id)
);