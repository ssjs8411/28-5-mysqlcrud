-- --------------------------------------------------------
-- 호스트:                          127.0.0.1
-- 서버 버전:                        5.5.32 - MySQL Community Server (GPL)
-- 서버 OS:                        Win32
-- HeidiSQL 버전:                  8.0.0.4396
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 5mysqlcrud 의 데이터베이스 구조 덤핑
CREATE DATABASE IF NOT EXISTS `5mysqlcrud` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `5mysqlcrud`;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. employed
CREATE TABLE IF NOT EXISTS `employed` (
  `employed_no` int(10) NOT NULL AUTO_INCREMENT,
  `employed_name` varchar(50) NOT NULL DEFAULT '0',
  `employed_age` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`employed_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.employed: ~5 rows (대략적)
/*!40000 ALTER TABLE `employed` DISABLE KEYS */;
INSERT INTO `employed` (`employed_no`, `employed_name`, `employed_age`) VALUES
	(1, '삼삼이', 33),
	(2, '김이번', 22),
	(3, '김삼번', 33),
	(4, '김사번', 44),
	(5, '김오번', 55);
/*!40000 ALTER TABLE `employed` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. employed_addr
CREATE TABLE IF NOT EXISTS `employed_addr` (
  `employed_addr_no` int(10) NOT NULL AUTO_INCREMENT,
  `employed_no` int(10) NOT NULL,
  `employed_addr_content` varchar(50) NOT NULL,
  PRIMARY KEY (`employed_addr_no`),
  KEY `employed_no` (`employed_no`),
  CONSTRAINT `employed_no` FOREIGN KEY (`employed_no`) REFERENCES `employed` (`employed_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.employed_addr: ~5 rows (대략적)
/*!40000 ALTER TABLE `employed_addr` DISABLE KEYS */;
INSERT INTO `employed_addr` (`employed_addr_no`, `employed_no`, `employed_addr_content`) VALUES
	(1, 1, '군산'),
	(2, 2, '전주'),
	(3, 3, '완산'),
	(4, 4, '익산'),
	(5, 5, '김제');
/*!40000 ALTER TABLE `employed_addr` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. employed_score
CREATE TABLE IF NOT EXISTS `employed_score` (
  `employed_score_no` int(10) NOT NULL AUTO_INCREMENT,
  `employed_no` int(10) NOT NULL DEFAULT '0',
  `employed_score` int(10) NOT NULL DEFAULT '0',
  PRIMARY KEY (`employed_score_no`),
  KEY `FK__employed` (`employed_no`),
  CONSTRAINT `FK__employed` FOREIGN KEY (`employed_no`) REFERENCES `employed` (`employed_no`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.employed_score: ~5 rows (대략적)
/*!40000 ALTER TABLE `employed_score` DISABLE KEYS */;
INSERT INTO `employed_score` (`employed_score_no`, `employed_no`, `employed_score`) VALUES
	(1, 1, 70),
	(2, 2, 65),
	(3, 3, 80),
	(4, 4, 90),
	(5, 5, 95);
/*!40000 ALTER TABLE `employed_score` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. member
CREATE TABLE IF NOT EXISTS `member` (
  `member_no` int(10) NOT NULL AUTO_INCREMENT,
  `member_name` varchar(50) NOT NULL DEFAULT '0',
  `member_age` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`member_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.member: ~6 rows (대략적)
/*!40000 ALTER TABLE `member` DISABLE KEYS */;
INSERT INTO `member` (`member_no`, `member_name`, `member_age`) VALUES
	(1, '일멤버', 21),
	(2, '이멤버', 22),
	(3, '삼멤버', 23),
	(4, '사멤버', 24),
	(5, '오멤버', 25),
	(6, '육멤버', 26);
/*!40000 ALTER TABLE `member` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. member_addr
CREATE TABLE IF NOT EXISTS `member_addr` (
  `member_addr_no` int(10) NOT NULL AUTO_INCREMENT,
  `member_no` int(10) NOT NULL,
  `member_addr_content` varchar(50) NOT NULL,
  PRIMARY KEY (`member_addr_no`),
  KEY `FK__member` (`member_no`),
  CONSTRAINT `FK__member` FOREIGN KEY (`member_no`) REFERENCES `member` (`member_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.member_addr: ~0 rows (대략적)
/*!40000 ALTER TABLE `member_addr` DISABLE KEYS */;
INSERT INTO `member_addr` (`member_addr_no`, `member_no`, `member_addr_content`) VALUES
	(1, 1, '군산'),
	(2, 2, '전주'),
	(3, 3, '완산'),
	(4, 4, '서울'),
	(5, 5, '부산'),
	(6, 6, '광주');
/*!40000 ALTER TABLE `member_addr` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. member_score
CREATE TABLE IF NOT EXISTS `member_score` (
  `member_score_no` int(10) NOT NULL AUTO_INCREMENT,
  `member_no` int(10) NOT NULL,
  `score` int(10) NOT NULL,
  PRIMARY KEY (`member_score_no`),
  KEY `FK_member_score_member` (`member_no`),
  CONSTRAINT `FK_member_score_member` FOREIGN KEY (`member_no`) REFERENCES `member` (`member_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.member_score: ~6 rows (대략적)
/*!40000 ALTER TABLE `member_score` DISABLE KEYS */;
INSERT INTO `member_score` (`member_score_no`, `member_no`, `score`) VALUES
	(1, 1, 70),
	(2, 2, 80),
	(3, 3, 90),
	(4, 4, 100),
	(5, 5, 30),
	(6, 6, 50);
/*!40000 ALTER TABLE `member_score` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. student
CREATE TABLE IF NOT EXISTS `student` (
  `student_no` int(10) NOT NULL AUTO_INCREMENT,
  `student_name` varchar(50) NOT NULL DEFAULT '0',
  `student_age` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.student: ~6 rows (대략적)
/*!40000 ALTER TABLE `student` DISABLE KEYS */;
INSERT INTO `student` (`student_no`, `student_name`, `student_age`) VALUES
	(1, '최지수', 25),
	(2, '홍길동', 22),
	(3, '김삼번', 23),
	(4, '김사번', 32),
	(5, '김오번', 25),
	(7, '김육번', 26);
/*!40000 ALTER TABLE `student` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. student_addr
CREATE TABLE IF NOT EXISTS `student_addr` (
  `student_addr_no` int(10) NOT NULL AUTO_INCREMENT,
  `student_no` int(10) NOT NULL DEFAULT '0',
  `student_addr_content` varchar(50) NOT NULL DEFAULT '0',
  PRIMARY KEY (`student_addr_no`),
  KEY `student_no` (`student_no`),
  CONSTRAINT `student_no` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.student_addr: ~6 rows (대략적)
/*!40000 ALTER TABLE `student_addr` DISABLE KEYS */;
INSERT INTO `student_addr` (`student_addr_no`, `student_no`, `student_addr_content`) VALUES
	(1, 1, '전주'),
	(2, 2, '군산'),
	(3, 3, '익산'),
	(5, 4, '전주'),
	(6, 5, '전주'),
	(9, 7, '익산');
/*!40000 ALTER TABLE `student_addr` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. student_score
CREATE TABLE IF NOT EXISTS `student_score` (
  `student_score_no` int(10) NOT NULL AUTO_INCREMENT,
  `student_no` int(10) DEFAULT NULL,
  `score` int(10) DEFAULT NULL,
  PRIMARY KEY (`student_score_no`),
  KEY `FK__student` (`student_no`),
  CONSTRAINT `FK__student` FOREIGN KEY (`student_no`) REFERENCES `student` (`student_no`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.student_score: ~6 rows (대략적)
/*!40000 ALTER TABLE `student_score` DISABLE KEYS */;
INSERT INTO `student_score` (`student_score_no`, `student_no`, `score`) VALUES
	(1, 1, 100),
	(2, 2, 60),
	(3, 3, 55),
	(4, 4, 70),
	(5, 5, 85),
	(7, 7, 60);
/*!40000 ALTER TABLE `student_score` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. teacher
CREATE TABLE IF NOT EXISTS `teacher` (
  `teacher_no` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_name` varchar(50) NOT NULL,
  `teacher_age` int(10) NOT NULL,
  PRIMARY KEY (`teacher_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.teacher: ~0 rows (대략적)
/*!40000 ALTER TABLE `teacher` DISABLE KEYS */;
INSERT INTO `teacher` (`teacher_no`, `teacher_name`, `teacher_age`) VALUES
	(1, '일티쳐', 21),
	(2, '이티쳐', 22),
	(3, '삼티쳐', 23),
	(4, '사티쳐', 24),
	(5, '오티쳐', 25),
	(6, '육티쳐', 26);
/*!40000 ALTER TABLE `teacher` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. teacher_addr
CREATE TABLE IF NOT EXISTS `teacher_addr` (
  `Teacher_addr_no` int(10) NOT NULL AUTO_INCREMENT,
  `Teacher_no` int(10) NOT NULL,
  `Teacher_addr_content` varchar(50) NOT NULL,
  PRIMARY KEY (`Teacher_addr_no`),
  KEY `FK__teacher` (`Teacher_no`),
  CONSTRAINT `FK__teacher` FOREIGN KEY (`Teacher_no`) REFERENCES `teacher` (`teacher_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.teacher_addr: ~0 rows (대략적)
/*!40000 ALTER TABLE `teacher_addr` DISABLE KEYS */;
INSERT INTO `teacher_addr` (`Teacher_addr_no`, `Teacher_no`, `Teacher_addr_content`) VALUES
	(1, 1, '군산'),
	(2, 2, '전주'),
	(3, 3, '익산'),
	(4, 4, '부산'),
	(5, 5, '전주'),
	(6, 6, '완산');
/*!40000 ALTER TABLE `teacher_addr` ENABLE KEYS */;


-- 테이블 5mysqlcrud의 구조를 덤프합니다. teacher_score
CREATE TABLE IF NOT EXISTS `teacher_score` (
  `teacher_score_no` int(10) NOT NULL AUTO_INCREMENT,
  `teacher_no` int(10) NOT NULL,
  `score` int(10) NOT NULL,
  PRIMARY KEY (`teacher_score_no`),
  KEY `FK_teacher_score_teacher` (`teacher_no`),
  CONSTRAINT `FK_teacher_score_teacher` FOREIGN KEY (`teacher_no`) REFERENCES `teacher` (`teacher_no`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=euckr;

-- Dumping data for table 5mysqlcrud.teacher_score: ~0 rows (대략적)
/*!40000 ALTER TABLE `teacher_score` DISABLE KEYS */;
INSERT INTO `teacher_score` (`teacher_score_no`, `teacher_no`, `score`) VALUES
	(1, 1, 80),
	(2, 2, 80),
	(3, 3, 100),
	(4, 4, 95),
	(5, 5, 90),
	(6, 6, 100);
/*!40000 ALTER TABLE `teacher_score` ENABLE KEYS */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
