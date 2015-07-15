USE users_management;

CREATE TABLE CUSTOMER_COURSE
(
  Id INT AUTO_INCREMENT primary key,
  CustomerId VARCHAR(50) NOT NULL,
  CourseId INT NOT NULL,
  FOREIGN KEY (CustomerId) REFERENCES CUSTOMER(Id),
  FOREIGN KEY (CourseId) REFERENCES COURSE(Id)
);