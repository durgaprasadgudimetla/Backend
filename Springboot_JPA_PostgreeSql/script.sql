CREATE TABLE REGION(
    REGIONID INT 				PRIMARY KEY      NOT NULL,
    REGIONNAME          		    CHAR(50) NOT NULL,
);

CREATE TABLE COUNTRY(
   COUNTRYID INT PRIMARY KEY      NOT NULL,
   COUNTRYNAME           CHAR(50) NOT NULL,
   REGIONID         INT     references  REGION(REGIONID)
);

CREATE TABLE LOCATION(
    LOCATIONID INT PRIMARY KEY      NOT NULL,
    LOCATIONNAME          		    CHAR(50) NOT NULL,
	STREETADDRESS                   CHAR(50) NOT NULL,
	CITY           			        CHAR(50) NOT NULL,
	STATEPROVIDENCE                 INT NOT NULL,
	COUNTRY           		        CHAR(50) NOT NULL,
    COUNTRYID                       INT     references COUNTRY(COUNTRYID)
);


insert into region values(1,'Asia');

CREATE TABLE DEPARTMENT(
    DEPTID INT PRIMARY KEY      NOT NULL,
    DEPTNAME          		    CHAR(50) NOT NULL,
	LOCATIONID                   INT     references LOCATION(LOCATIONID)
);



CREATE TABLE MANAGER(
    MANGERID INT PRIMARY KEY      NOT NULL,
    MANAGERNAME          		   CHAR(50) NOT NULL,
	DEPTID                   INT     references DEPARTMENT(DEPTID)
);

CREATE TABLE JOB(
    JOBID INT PRIMARY KEY      NOT NULL,
    JOBTITLE          		   CHAR(50) NOT NULL,
	MINSALARY                   INT  ,
	MAXSALARY					INT
);

CREATE TABLE EMPLOYEE(
    EMPLOYEEID INT PRIMARY KEY      NOT NULL,
    EMPLOYEENAME          		    CHAR(50) NOT NULL,
	MANAGERID                   INT     references MANAGER(MANGERID),
	DEPTID                   INT     references DEPARTMENT(DEPTID),
	JOBID                   INT     references JOB(JOBID)
);

CREATE TABLE EMPLOYEEDETAILS(
    DID INT 				PRIMARY KEY      NOT NULL,
    FNAME          		    CHAR(50) NOT NULL,
	LNAME          		    CHAR(50) NOT NULL,
	EMAIL          		    CHAR(50) NOT NULL,
	ADDRESS1          	    CHAR(100) NOT NULL,
	ADDRESS2          		CHAR(100) NOT NULL,
	PHONENUMBER             BIGINT NOT NULL,
	EMPLOYEEID              INT     references EMPLOYEE(EMPLOYEEID)
);


insert into region values(1,'Asia');
insert into region values(2,'africa');

insert into country values(91,'India',1);

insert into location values(2,'kondapur','whitefield','Hyderabad',500000,'India',91);
insert into location values(1,'Tust','whitefield','Banglore',600000,'India',91);

insert into department values(101,'IT',1);
insert into department values(102,'HR',1);
insert into department values(103,'Travel',1);
insert into department values(104,'Insurance',1);

insert into job values(11,'Java fullstack',15000, 80000);
insert into job values(12,'HR',15000, 50000);
insert into job values(13,'Front End',18000, 90000);


insert into employee values(123,'Durga prasad',1, 101,11);
insert into employee values(124,'Rambabu',1, 102,12);
insert into employee values(125,'Durga prasad',1, 101,13);

ALTER TABLE EMPLOYEE ALTER COLUMN EMPLOYEENAME TYPE VARCHAR(50);

