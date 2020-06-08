SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `hr_degrees`
-- ----------------------------
DROP TABLE IF EXISTS `hr_degrees`;
CREATE TABLE `hr_degrees` (
  `degree_type_id` int(11) NOT NULL AUTO_INCREMENT,
  `degree_type_name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`degree_type_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_degrees
-- ----------------------------

-- ----------------------------
-- Table structure for `hr_departments`
-- ----------------------------
DROP TABLE IF EXISTS `hr_departments`;
CREATE TABLE `hr_departments` (
  `dep_id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_name` varchar(255) NOT NULL,
  PRIMARY KEY (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_departments
-- ----------------------------
INSERT INTO `hr_departments` VALUES ('1', 'IT');
INSERT INTO `hr_departments` VALUES ('2', 'Sales');
INSERT INTO `hr_departments` VALUES ('3', 'HR');
INSERT INTO `hr_departments` VALUES ('4', 'Marketing');

-- ----------------------------
-- Table structure for `hr_employees`
-- ----------------------------
DROP TABLE IF EXISTS `hr_employees`;
CREATE TABLE `hr_employees` (
  `emp_id` int(11) NOT NULL AUTO_INCREMENT,
  `dep_id` int(11) DEFAULT NULL,
  `emp_name` varchar(255) DEFAULT NULL,
  `emp_salary` double DEFAULT NULL,
  `emp_picture` longblob,
  PRIMARY KEY (`emp_id`),
  KEY `dep_id` (`dep_id`),
  CONSTRAINT `hr_employees_ibfk_1` FOREIGN KEY (`dep_id`) REFERENCES `hr_departments` (`dep_id`)
) ENGINE=InnoDB AUTO_INCREMENT=8523 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_employees
-- ----------------------------

-- ----------------------------
-- Table structure for `hr_employee_degrees`
-- ----------------------------
DROP TABLE IF EXISTS `hr_employee_degrees`;
CREATE TABLE `hr_employee_degrees` (
  `emp_degree_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `degree_id` int(11) NOT NULL,
  PRIMARY KEY (`emp_degree_id`),
  KEY `emp_id` (`emp_id`),
  KEY `degree_id` (`degree_id`),
  CONSTRAINT `hr_employee_degrees_ibfk_2` FOREIGN KEY (`degree_id`) REFERENCES `hr_degrees` (`degree_type_id`),
  CONSTRAINT `hr_employee_degrees_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `hr_employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_employee_degrees
-- ----------------------------

-- ----------------------------
-- Table structure for `hr_employee_family`
-- ----------------------------
DROP TABLE IF EXISTS `hr_employee_family`;
CREATE TABLE `hr_employee_family` (
  `member_id` int(11) NOT NULL AUTO_INCREMENT,
  `employee_id` int(11) DEFAULT NULL,
  `relation_id` int(11) DEFAULT NULL,
  `member_name` varchar(255) NOT NULL,
  `age` int(11) DEFAULT NULL,
  PRIMARY KEY (`member_id`),
  KEY `relation_id` (`relation_id`),
  KEY `employee_id` (`employee_id`),
  CONSTRAINT `hr_employee_family_ibfk_3` FOREIGN KEY (`employee_id`) REFERENCES `hr_employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `hr_employee_family_ibfk_2` FOREIGN KEY (`relation_id`) REFERENCES `hr_family_relations` (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_employee_family
-- ----------------------------

-- ----------------------------
-- Table structure for `hr_employee_personal_info`
-- ----------------------------
DROP TABLE IF EXISTS `hr_employee_personal_info`;
CREATE TABLE `hr_employee_personal_info` (
  `emp_pers_id` int(11) NOT NULL AUTO_INCREMENT,
  `emp_id` int(11) NOT NULL,
  `address` varchar(255) DEFAULT NULL,
  `phone` varchar(255) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`emp_pers_id`),
  KEY `emp_id` (`emp_id`),
  CONSTRAINT `hr_employee_personal_info_ibfk_1` FOREIGN KEY (`emp_id`) REFERENCES `hr_employees` (`emp_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_employee_personal_info
-- ----------------------------

-- ----------------------------
-- Table structure for `hr_family_relations`
-- ----------------------------
DROP TABLE IF EXISTS `hr_family_relations`;
CREATE TABLE `hr_family_relations` (
  `relation_id` int(11) NOT NULL AUTO_INCREMENT,
  `relation_name` varchar(255) NOT NULL,
  PRIMARY KEY (`relation_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hr_family_relations
-- ----------------------------
