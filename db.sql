CREATE DATABASE `grad_management` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
use grad_management;

-- Create table 
CREATE TABLE `grad_details` (
  `emp_code` varchar(11) DEFAULT NULL,
  `name` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `college` varchar(50) NOT NULL,
  `location_preference` varchar(50) NOT NULL,
  `date_of_joining` date DEFAULT NULL,
  `batch` varchar(45) DEFAULT NULL,
  `doj_reconfirmation` varchar(10) NOT NULL DEFAULT 'N',
  `remarks` tinytext,
  `course` varchar(50) NOT NULL,
  `branch` varchar(50) NOT NULL,
  `current_cgpa` float NOT NULL,
  `personal_contact_number` varchar(10) NOT NULL,
  `personal_email_id` varchar(50) NOT NULL,
  `date_of_birth` date NOT NULL,
  `native_place` varchar(45) DEFAULT NULL,
  `current_place` varchar(45) NOT NULL,
  `parent_contact_number` varchar(10) DEFAULT NULL,
  `parent_postal_address` text,
  `link_to_cv` varchar(45) NOT NULL,
  `id` int(11) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`),
  UNIQUE KEY `Email_UNIQUE` (`email`),
  UNIQUE KEY `PersonalContactNumber_UNIQUE` (`personal_contact_number`),
  UNIQUE KEY `PersonalEmailID_UNIQUE` (`personal_email_id`),
  UNIQUE KEY `EmpID_UNIQUE` (`emp_code`),
  CONSTRAINT `grad_details_chk_1` CHECK ((`doj_reconfirmation` in (_utf8mb4'Y',_utf8mb4'N')))
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- Insert dummy entries
INSERT INTO `` (`emp_code`,`name`,`email`,`college`,`location_preference`,`date_of_joining`,`batch`,`doj_reconfirmation`,`remarks`,`course`,`branch`,`current_cgpa`,`personal_contact_number`,`personal_email_id`,`date_of_birth`,`native_place`,`current_place`,`parent_contact_number`,`parent_postal_address`,`link_to_cv`,`id`) VALUES ('4206','OM','om.vjti@gmail.com','VJTI','Mumbai','2019-05-10','AU-2019','Y',NULL,'B.Tech','IT',9,'6745612345','modi.om@gmail.com','1997-12-24',NULL,'Mumbai',NULL,'INDIA','google.com',19);
INSERT INTO `` (`emp_code`,`name`,`email`,`college`,`location_preference`,`date_of_joining`,`batch`,`doj_reconfirmation`,`remarks`,`course`,`branch`,`current_cgpa`,`personal_contact_number`,`personal_email_id`,`date_of_birth`,`native_place`,`current_place`,`parent_contact_number`,`parent_postal_address`,`link_to_cv`,`id`) VALUES ('4207','Pranav','p.patil@gmail.com','VJTI','Chennai','2019-03-12','AU-spring','N',NULL,'B. Tech','Electrical',9.5,'284748','ppatil@gmail.com','1997-01-24',NULL,'Mumbai',NULL,'India','google.com',21);
INSERT INTO `` (`emp_code`,`name`,`email`,`college`,`location_preference`,`date_of_joining`,`batch`,`doj_reconfirmation`,`remarks`,`course`,`branch`,`current_cgpa`,`personal_contact_number`,`personal_email_id`,`date_of_birth`,`native_place`,`current_place`,`parent_contact_number`,`parent_postal_address`,`link_to_cv`,`id`) VALUES ('43534','Amir Khan','a.k@gmail.com','IIT-Bombay','Mumbai','2018-04-15','AU - 2018','Y',NULL,'B.Tech','Computer',9.5,'567687','akhan@gmail.com','1996-04-23',NULL,'Mumbai',NULL,'Mumbai,India','google.com',22);
INSERT INTO `` (`emp_code`,`name`,`email`,`college`,`location_preference`,`date_of_joining`,`batch`,`doj_reconfirmation`,`remarks`,`course`,`branch`,`current_cgpa`,`personal_contact_number`,`personal_email_id`,`date_of_birth`,`native_place`,`current_place`,`parent_contact_number`,`parent_postal_address`,`link_to_cv`,`id`) VALUES ('3423','Prafull','p.p@gmail.com','VJTI','Mumbai','2019-06-10','AU-2019','Y',NULL,'B.Tech','Computer',9,'678346','pp@gmail.com','1997-10-30',NULL,'Mumbai',NULL,'INdia','google.com',24);
INSERT INTO `` (`emp_code`,`name`,`email`,`college`,`location_preference`,`date_of_joining`,`batch`,`doj_reconfirmation`,`remarks`,`course`,`branch`,`current_cgpa`,`personal_contact_number`,`personal_email_id`,`date_of_birth`,`native_place`,`current_place`,`parent_contact_number`,`parent_postal_address`,`link_to_cv`,`id`) VALUES ('5646','Royston','r.d@gmail.com','SPIT','Mumbai','2019-06-10','AU-2019','N',NULL,'B. Tech','Computer',9.5,'789456','r.dmello@gmail.com','1997-02-23',NULL,'Mumbai',NULL,'India','google.com',25);
