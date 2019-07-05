-- ************************************************ 
-- Creatting the Employee Table
-- ***********************************************
CREATE DATABASE demand_details;
CREATE TABLE EMPLOYEE(
    EMP_ID INT PRIMARY KEY,
    EMP_NAME VARCHAR(100) NOT NULL,
    ROLE VARCHAR(100)
);

CREATE TABLE LOCATION (
    LOCATION_ID INT AUTO_INCREMENT,
    LOCATION_NAME VARCHAR(100),
    PRIMARY KEY(LOCATION_ID)
);

-- ************************************************ 
-- Creatting the Demand_details Table
-- ***********************************************

CREATE TABLE DEMAND_DETAILS (
    edId INT,
    hmId INT,
    LOCATION_ID INT,
    demandCount NUMERIC(3),
    startTime DATE NOT NULL,
    STATUS VARCHAR(50) NOT NULL,
    COMMENTS VARCHAR(2000),
    PRIMARY KEY(edId, hmId, LOCATION_ID),
    FOREIGN KEY(edId) REFERENCES EMPLOYEE(EMP_ID),
    FOREIGN KEY(hmId) REFERENCES EMPLOYEE(EMP_ID),
    FOREIGN KEY(LOCATION_ID) REFERENCES LOCATION(LOCATION_ID)
);

INSERT INTO LOCATION(LOCATION_NAME) VALUES('Mumbai');
INSERT INTO LOCATION(LOCATION_NAME) VALUES('Bangalore');
INSERT INTO LOCATION(LOCATION_NAME) VALUES('Hyderabad');
INSERT INTO LOCATION(LOCATION_NAME) VALUES('Chennai');

-- ********************************************************
--  Inserting the dummy data into employee table
-- *********************************************************

INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(100, 'Sathish Kamath', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(101, 'Premal Parikh', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(102, 'Mahendra C', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(103, 'Sainath B', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(104, 'Mohith', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(105, 'Shamith Verma', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(106, 'Vikram H', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(107, 'Raman Raman', '');
INSERT INTO EMPLOYEE(EMP_ID, EMP_NAME, ROLE) VALUES(108, 'Saee Sapre', '');


-- ************************************************************
--  Inserting the dummy data into demand details
-- ************************************************************

INSERT INTO DEMAND_DETAILS(edId, hmId, LOCATION_ID, demandCount, startTime,
    STATUS, COMMENTS
) VALUES (
    100, 100, 2, 5, STR_TO_DATE('01/06/19','%d/%m/%y'), 'NOT SATISFIED', ''
);

INSERT INTO DEMAND_DETAILS(edId, hmId, LOCATION_ID, demandCount, startTime,
    STATUS, COMMENTS
) VALUES (
    100, 100, 1, 5, STR_TO_DATE('29/06/19','%d/%m/%y'), 'NOT SATISFIED', ''
 );
INSERT INTO DEMAND_DETAILS(edId, hmId, LOCATION_ID, demandCount, startTime,
    STATUS, COMMENTS
) VALUES (
    100, 100, 4, 5, STR_TO_DATE('29/06/19','%d/%m/%y'), 'NOT SATISFIED', ''
 );

-- ***************************************************************
-- Required Queries in Demand Module
-- ***************************************************************




