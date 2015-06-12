SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE SCHEMA IF NOT EXISTS `basecamp` DEFAULT CHARACTER SET latin1 COLLATE latin1_general_cs; 
USE `basecamp` ;

-- -----------------------------------------------------
-- Table `basecamp`.`hotel_resort`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basecamp`.`hotel/resort` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`payment_type`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basecamp`.`payment type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`reservation_route`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basecamp`.`reservation type` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `type` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`user`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basecamp`.`user` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `username` VARCHAR(255) NOT NULL DEFAULT '' ,
  `password` VARCHAR(255) NOT NULL DEFAULT '' ,
  `access level` INT(1) NOT NULL DEFAULT '' ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


CREATE TABLE IF NOT EXISTS `basecamp`.`city` (
  `id` INT(11) NOT NULL auto_increment,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;

-- -----------------------------------------------------
-- Table `basecamp`.`car`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`car` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;

-- -----------------------------------------------------
-- Table `basecamp`.`flight`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`flight` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;

-- -----------------------------------------------------
-- Table `basecamp`.`airline`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`airline` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL DEFAULT '',
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`hotel_reservation`
-- -----------------------------------------------------
CREATE  TABLE IF NOT EXISTS `basecamp`.`hotel reservation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT ,
  `created by` VARCHAR(255) NOT NULL DEFAULT '' ,
  `created at` VARCHAR(255) NOT NULL DEFAULT '' ,
  `check in` VARCHAR(10) NOT NULL DEFAULT '' ,
  `check out` VARCHAR(10) NOT NULL DEFAULT '' ,
  `hotel/resort` VARCHAR(255) NOT NULL DEFAULT  '',
  `guest name` VARCHAR(255) NOT NULL DEFAULT '' ,
  `number of adult` INT(11) NOT NULL DEFAULT '' ,
  `number of child` INT(11) NOT NULL DEFAULT '' ,
  `room type` VARCHAR(255) NOT NULL DEFAULT '' ,
  `number of rooms` INT(11) NOT NULL DEFAULT '' ,
  `number of nights` INT(11) NOT NULL DEFAULT '' ,
  `breakfast` VARCHAR(12) NOT NULL DEFAULT '',
  `confirmation number` VARCHAR(255) NOT NULL DEFAULT '',
  `company` VARCHAR(255) NOT NULL DEFAULT '' ,
  `status` VARCHAR(255) NOT NULL DEFAULT '' ,
  `reservation type` VARCHAR(255) NOT NULL DEFAULT '' , 
  `reservation date` VARCHAR(10) NOT NULL DEFAULT '' ,
  `option to pay` VARCHAR(10) NOT NULL DEFAULT '' ,
  `amount to pay` DOUBLE NOT NULL DEFAULT '' ,
  `option to final` VARCHAR(10) NOT NULL DEFAULT '' ,
  `total payment` DOUBLE NOT NULL DEFAULT '' ,
  `total payment type` VARCHAR(10) NOT NULL DEFAULT '' ,
  `payment type` VARCHAR(255) NOT  NULL DEFAULT '' ,
  `receipt number` VARCHAR(255) NOT NULL DEFAULT '' ,
  `pay in - PHP` DOUBLE NOT NULL DEFAULT '' ,
  `pay in - KRW` DOUBLE NOT NULL DEFAULT '' ,
  `pay in - date` VARCHAR(10) NOT NULL DEFAULT '' ,
  `pay out - PHP` DOUBLE NOT NULL DEFAULT '' ,
  `pay out - KRW` DOUBLE NOT NULL DEFAULT '' ,
  `pay out - date` VARCHAR(10) NOT NULL DEFAULT '' ,
  `income - PHP` DOUBLE NOT NULL DEFAULT '' ,
  `income - KRW` DOUBLE NOT NULL DEFAULT '' ,
  `note` VARCHAR(255) NULL DEFAULT '' ,
  `remark` VARCHAR(255) NOT NULL DEFAULT '' ,
  `isMark` BOOLEAN DEFAULT false ,
  PRIMARY KEY (`id`) )
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;



-- -----------------------------------------------------
-- Table `basecamp`.`hr history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`hr history` (
  `id` INT(11) AUTO_INCREMENT,
  `hr id` INT(11) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `isCheckInEdited` BOOLEAN, 
  `isCheckOutEdited` BOOLEAN, 
  `isHotel/ResortEdited` BOOLEAN, 
  `isGuestNameEdited` BOOLEAN, 
  `isNumberOfAdultEdited` BOOLEAN, 
  `isNumberOfChildEdited` BOOLEAN, 
  `isRoomTypeEdited` BOOLEAN, 
  `isNumberOfRoomsEdited` BOOLEAN,
  `isNumberOfNightsEdited` BOOLEAN, 
  `isBreakfastEdited` BOOLEAN, 
  `isConfirmationNumberEdited` BOOLEAN, 
  `isCompanyEdited` BOOLEAN, 
  `isStatusEdited` BOOLEAN, 
  `isReservationTypeEdited` BOOLEAN,  
  `isReservationDateEdited` BOOLEAN, 
  `isOptionToPayEdited` BOOLEAN, 
  `isAmountToPayEdited` BOOLEAN,
  `isOptionToFinalEdited` BOOLEAN, 
  `isTotalPaymentEdited` BOOLEAN,
  `isTotalPaymentTypeEdited` BOOLEAN,
  `isPaymentTypeEdited` BOOLEAN, 
  `isReceiptNumberEdited` BOOLEAN, 
  `isPayInPHPEdited` BOOLEAN, 
  `isPayInKRWEdited` BOOLEAN, 
  `isPayInDateEdited` BOOLEAN, 
  `isPayOutPHPEdited` BOOLEAN, 
  `isPayOutKRWEdited` BOOLEAN, 
  `isPayOutDateEdited` BOOLEAN, 
  `isIncomePHPEdited` BOOLEAN, 
  `isIncomeKRWEdited` BOOLEAN, 
  `isNoteEdited` BOOLEAN, 
  `isRemarkEdited` BOOLEAN,
  `isMarkEdited` BOOLEAN,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;

-- -----------------------------------------------------
-- Table `basecamp`.`flight_reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`flight reservation` (
  `id` INT(11) AUTO_INCREMENT,
  `created by` VARCHAR(255) NULL DEFAULT NULL ,
  `created at` VARCHAR(255) NULL DEFAULT NULL ,
  `airline` VARCHAR(255) NULL DEFAULT NULL,
  `flight number` VARCHAR(255) NULL DEFAULT NULL,
  `departure date` VARCHAR(10) NULL DEFAULT NULL,
  `departure time` VARCHAR(10) NULL DEFAULT NULL,
  `arrival time` VARCHAR(5) NULL DEFAULT NULL,
  `origin` VARCHAR(255) NULL DEFAULT NULL,
  `destination` VARCHAR(255) NULL DEFAULT NULL,
  `record locator` VARCHAR(255) NULL DEFAULT NULL,
  `reservation type` VARCHAR(255) NULL DEFAULT NULL,
  `reservation date` VARCHAR(10) NULL DEFAULT NULL,
  `option to pay` VARCHAR(255) NULL DEFAULT NULL,
  `amount to pay` VARCHAR(255) NULL DEFAULT NULL,
  `option to final` VARCHAR(10) NULL DEFAULT NULL ,
  `total payment` DOUBLE NULL DEFAULT NULL ,
  `total payment type` VARCHAR(10) NULL DEFAULT NULL ,
  `guest name` VARCHAR(255) NULL DEFAULT NULL,
  `gender` VARCHAR(255) NULL DEFAULT NULL,
  `number of adult` INT(11) NULL DEFAULT NULL,
  `number of child` INT(11) NULL DEFAULT NULL,
  `payment type` VARCHAR(255) NULL DEFAULT NULL,
  `receipt number` VARCHAR(255) NULL DEFAULT NULL,
  `pay in - PHP` DOUBLE NULL DEFAULT NULL,
  `pay in - KRW` DOUBLE NULL DEFAULT NULL,
  `pay in - date` VARCHAR(10) NULL DEFAULT NULL,
  `pay out - PHP` DOUBLE NULL DEFAULT NULL,
  `pay out - KRW` DOUBLE NULL DEFAULT NULL,
  `pay out - date` VARCHAR(10) NULL DEFAULT NULL,
  `income - PHP` DOUBLE NULL DEFAULT NULL,
  `income - KRW` DOUBLE NULL DEFAULT NULL,
  `status` VARCHAR(255) DEFAULT '',
  `note` VARCHAR(255) NULL DEFAULT NULL,
  `remark` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`fr history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`fr history` (
  `id` INT(11) AUTO_INCREMENT,
  `fr id` INT(11) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `isAirlineEdited` BOOLEAN,
  `isFlightNumberEdited` BOOLEAN,
  `isDepartureDateEdited` BOOLEAN, 
  `isDepartureTimeEdited` BOOLEAN,
  `isArrivalTimeEdited` BOOLEAN, 
  `isOriginEdited` BOOLEAN, 
  `isDestinationEdited` BOOLEAN,
  `isRecordLocatorEdited` BOOLEAN, 
  `isReservationTypeEdited` BOOLEAN,
  `isReservationDateEdited` BOOLEAN,
  `isOptionToPayEdited` BOOLEAN,
  `isAmountToPayEdited` BOOLEAN,
  `isOptionToFinalEdited` BOOLEAN,
  `isTotalPaymentEdited` BOOLEAN,
  `isTotalPaymentTypeEdited` BOOLEAN,
  `isGuestNameEdited` BOOLEAN, 
  `isGenderEdited` BOOLEAN, 
  `isNumberOfAdultEdited` BOOLEAN, 
  `isNumberOfChildEdited` BOOLEAN, 
  `isPaymentTypeEdited` BOOLEAN,
  `isReceiptNumberEdited` BOOLEAN,
  `isPayInPHPEdited` BOOLEAN, 
  `isPayInKRWEdited` BOOLEAN, 
  `isPayInDateEdited` BOOLEAN, 
  `isPayOutPHPEdited` BOOLEAN, 
  `isPayOutKRWEdited` BOOLEAN, 
  `isPayOutDateEdited` BOOLEAN, 
  `isIncomePHPEdited` BOOLEAN, 
  `isIncomeKRWEdited` BOOLEAN, 
  `isStatusEdited` BOOLEAN DEFAULT FALSE,
  `isNoteEdited` BOOLEAN, 
  `isRemarkEdited` BOOLEAN, 
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;

-- -----------------------------------------------------
-- Table `basecamp`.`package reservation`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`package reservation` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `created by` VARCHAR(255) NULL DEFAULT NULL ,
  `created at` VARCHAR(255) NULL DEFAULT NULL ,
  `date` VARCHAR(10) NULL DEFAULT NULL,
  `time` VARCHAR(5) NULL DEFAULT NULL,
  `type` VARCHAR(255) NULL DEFAULT NULL,
  `car` VARCHAR(255) NULL DEFAULT NULL,
  `reservation type` VARCHAR(255) NULL DEFAULT NULL,
  `reservation date` VARCHAR(10) NULL DEFAULT NULL,
  `option to pay` VARCHAR(10) NULL DEFAULT NULL,
  `amount to pay` DOUBLE NULL DEFAULT NULL,
  `option to final` VARCHAR(10) NULL DEFAULT NULL ,
  `total payment` DOUBLE NULL DEFAULT NULL ,
  `total payment type` VARCHAR(10) NULL DEFAULT NULL ,
  `status` VARCHAR(255) DEFAULT '',
  `guest name` VARCHAR(255) NULL DEFAULT NULL,
  `number of adult` INT(11) NULL DEFAULT NULL,
  `number of child` INT(11) NULL DEFAULT NULL,
  `payment type` VARCHAR(255) NULL DEFAULT NULL,
  `receipt number` VARCHAR(255) DEFAULT '',
  `pay in - PHP` DOUBLE NULL DEFAULT NULL,
  `pay in - KRW` DOUBLE NULL DEFAULT NULL,
  `pay in - date` VARCHAR(10) NULL DEFAULT NULL,
  `pay out - PHP` DOUBLE NULL DEFAULT NULL,
  `pay out - KRW` DOUBLE NULL DEFAULT NULL,
  `pay out - date` VARCHAR(10) NULL DEFAULT NULL,
  `income - PHP` DOUBLE NULL DEFAULT NULL,
  `income - KRW` DOUBLE NULL DEFAULT NULL,
  `note` VARCHAR(255) NULL DEFAULT NULL,
  `remark` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


-- -----------------------------------------------------
-- Table `basecamp`.`pr history`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `basecamp`.`pr history` (
  `id` INT(11) AUTO_INCREMENT,
  `pr id` INT(11) NULL DEFAULT NULL ,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  `date` VARCHAR(255) NULL DEFAULT NULL,
  `isDateEdited` BOOLEAN, 
  `isTimeEdited` BOOLEAN, 
  `isTypeEdited` BOOLEAN, 
  `isCarEdited` BOOLEAN,
  `isReservationTypeEdited` BOOLEAN,
  `isReservationDateEdited` BOOLEAN,
  `isOptionToPayEdited` BOOLEAN,
  `isAmountToPayEdited` BOOLEAN,
  `isGuestNameEdited` BOOLEAN, 
  `isOptionToFinalEdited` BOOLEAN,
  `isTotalPaymentEdited` BOOLEAN,
  `isTotalPaymentTypeEdited` BOOLEAN,
  `isStatusEdited` BOOLEAN,
  `isNumberOfAdultEdited` BOOLEAN, 
  `isNumberOfChildEdited` BOOLEAN, 
  `isPaymentTypeEdited` BOOLEAN,
  `isReceiptNumberEdited` BOOLEAN,
  `isPayInPHPEdited` BOOLEAN, 
  `isPayInKRWEdited` BOOLEAN, 
  `isPayInDateEdited` BOOLEAN, 
  `isPayOutPHPEdited` BOOLEAN, 
  `isPayOutKRWEdited` BOOLEAN, 
  `isPayOutDateEdited` BOOLEAN, 
  `isIncomePHPEdited` BOOLEAN, 
  `isIncomeKRWEdited` BOOLEAN,
  `isNoteEdited` BOOLEAN, 
  `isRemarkEdited` BOOLEAN, 
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = latin1 COLLATE latin1_general_cs;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

INSERT INTO `basecamp`.`user` (username, password, `access level`) VALUES ('test', '1234', 1);

INSERT INTO `basecamp`.`payment type` (`type`) VALUES ('Cash');
INSERT INTO `basecamp`.`payment type` (`type`) VALUES ('KEB 1');
INSERT INTO `basecamp`.`payment type` (`type`) VALUES ('KEB 2');
INSERT INTO `basecamp`.`payment type` (`type`) VALUES ('BDO');
INSERT INTO `basecamp`.`payment type` (`type`) VALUES ('BPI');

INSERT INTO `basecamp`.`reservation type` (`type`) VALUES ('Blog');
INSERT INTO `basecamp`.`reservation type` (`type`) VALUES ('Web');
INSERT INTO `basecamp`.`reservation type` (`type`) VALUES ('Local');
INSERT INTO `basecamp`.`reservation type` (`type`) VALUES ('T.A.');

INSERT INTO `basecamp`.`car` (`name`) VALUES ('N/A');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Sedan');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Starex');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Grand Starex');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Grandia');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Mini Bus');
INSERT INTO `basecamp`.`car` (`name`) VALUES ('Bus');

INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z2884');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z284');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z2885');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z285');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('7C2306');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('7C2305');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('KE624');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('KE622');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('KE621');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('KE623');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR466');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR468');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR469');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR467');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR416');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR419');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR487');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR486');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR483');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('PR482');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('5J188');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('5J189');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z239');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z238');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z259');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('Z258');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('5J79');
INSERT INTO `basecamp`.`flight` (`name`) VALUES ('5J78');

INSERT INTO `basecamp`.`city` (`name`) VALUES ('INC');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('PUS');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('MNL');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('CEB');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('MPH');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('KLO');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('PPS');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('ILO');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('TAG');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('DVO');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('HKG');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('SYD');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('MEL');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('SIN');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('TPA');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('BKK');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('BJE');
INSERT INTO `basecamp`.`city` (`name`) VALUES ('TYO');

INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BAYVIEW PARK HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOFITEL LUXURY HOTELS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ALOHA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DIAMOND HOTEL PHILIPPINES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL H2O');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HYATT CITY OF DREAMS MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWN TOWERS CITY OF DREAMS MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RAMADA MANILA CENTRAL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITYSTATE TOWER HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MIDAS HOTEL AND CASINO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('REMINGTON HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOLAIRE RESORT & CASINO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PAN PACIFIC MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('1775 ADRIATICO SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CENTURY PARK HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FERNANDINA 88 SUITES HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANILA AIRPORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NEW WORLD MANILA BAY HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ARMADA HOTEL MANILAMANILA PAVILION');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE MANILA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BRENTWOOD SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANILA MANOR HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOLESTE SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROSSWINDS OCEAN HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL JEN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('VIEVE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ATRIUM HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('COPACABANA APARTMENT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANILA CROWN PALACE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE HERITAGE HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MPT SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE EXECUTIVE PLAZA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AMELIE HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BEST WESTERN HOTEL LA CORONA MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TUNE HOTEL ERMITA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANILA GRAND OPERA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE OASIS PACO PARK HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NICHOLS AIRPORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE PEARL MANILA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOSTEL 1632');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CASA BOCOBO HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PALM PLAZA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE BAYLEAF INTRAMUROS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ORION HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LAS PALMAS HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MICROTEL (MALL OF ASIA)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL BENILDE MAISON DE LA SALLE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ORCHID GARDEN SUITES MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PEARL LANE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE GARDEN PLAZA HOTEL & SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL KIMBERLY MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EUROTEL ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('V HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ROTHMAN HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE MABUHAY MANOR');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITY GARDEN SUITES MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SEQUOIA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LOTUS GARDEN HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AURUMONE MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MAKATI SHANGRI-LA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NEW WORLD MAKATI HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('Y2 RESIDENCE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BERJAYA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITY GARDEN HOTEL MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE PENINSULA MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('INTERCONTINENTAL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ONE GREENBELT BY ASTORIA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOLIDAY INN & SUITES MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ST. GILES MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ONE PACIFIC PLACE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITADEL INN MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BEST WESTERN PLUS ANTEL HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FAIRMONT MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DUSIT THANI MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BEST WESTERN OXFORD SUITES MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL CELESTE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MAKATI PALACE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWN REGENCY HOTEL MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL RICO SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SAINT ILLIANS INN MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MILLENNIUM MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE COPA BUSINESSMANS HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('24H APARTMENT-HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PICASSO BOUTIQUE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FRASER PLACE MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASCOTT MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOMERSET MILLENNIUM MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOMERSET OLYMPIA MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITADINES SALCEDO MAKATI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASCOTT BONIFACIO GLOBAL CITY MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITY GARDEN GRAND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL CIELITO HOTELS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MAKATI DIAMOND RESIDENCES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ALEJANDRA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PRINCE PLAZA II (ST. FRANCIS SUITES)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASIAN MANSION II (ST.FRANCIS SUITES)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BSA MANSION (ST. FRANCIS SUITES)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE BELLEVUE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CRIMSON HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ACACIA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EDSA SHANGRI-LA ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RICHMONDE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EASTWOOD RICHMONDE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE MALAYAN PLAZA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ACE HOTEL & SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE SULO RIVIERA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('VIVERE HOTEL & RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOLIDAY INN MANILA GALLERIA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DISCOVERY SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('F1 HOTEL MANILA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('F1 SUITES AT FORT PALM SPRING');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('IMPERIAL PALACE SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWNE PLAZA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MARCO POLO ORTIGAS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MILLENIA SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL 878');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GREENHILLS ELAN HOTEL MODERN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LANCASTER HOTEL ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASTORIA PLAZA SERVICED RESIDENTIAL SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LUXENT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PRIVATO HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SEDA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL REMBRANDT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE EXCHANGE REGENCY RESIDENCE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SEA WIND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HENANN GARDEN RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HENANN LAGOON RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY REGENCY BEACH RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DISCOVERY SHORES ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GRAND VISTA RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE TIDES HOTEL BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FAIRWAYS & BLUEWATER');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE LIND BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NAMI');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RED COCONUT BEACH HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('WILLYS BEACH HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AMBASSADOR IN PARADISE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LE SOLEIL DE BORACAY HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PATIO PACIFIC BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GRAND BORACAY RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NANDANA BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANGO-RAY RESORT & RESTAURANT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ALTA VISTA DE BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TWO SEASONS BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY MANDARIN ISLAND HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('REAL MARIS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GIULIUS BORACAY ITALIAN RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('7STONE BORACAY SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('WHITE HOUSE BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SHANGRI-LAS BORACAY RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAYS ARWANA HOTEL & RESTAURANT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY SANDS HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BEST WESTERN BORACAY TROPICS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MICROTEL (BORACAY)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MONACO SUITES DE BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWN REGENCY HOTEL & RESORTS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY HOLIDAY RESORT ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL SOFFIA BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY OCEAN CLUB BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LA CARMELA DE BORACAY RESORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE DISTRICT BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY HAVEN RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY UPTOWN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY TERRACES RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PARADISE GARDEN RESORT HOTEL & CONVENTION CENTER');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ESTACIO UNO BORACAY LIFESTYLE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RB LODGE KALIBO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUE LOTUS HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LAS BRISAS DE BORACAY RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUE MARINA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TRUE HOME HOTEL-BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUELILLY VILLA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HEY! JUDE RESORT HOTEL BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MANDALA SPA & VILLAS BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TANAWIN RESORT AND LUXURY APARTMENTS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GOLDEN PHOENIX HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOL MARINA RESORT BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE CLUB TEN BEACH RESORT BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE PREMIERE BUSINESS HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ONE AZUL BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORA SKY HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY WATER WORLD RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PEARL OF THE PACIFIC BORACAY RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY BEACH CLUB');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ALICE BORACAY RESORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ONE CRESCENT PLACE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BORACAY TRAVELODGE BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MARZON BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FRIDAYS BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('VILLA CAEMILLA BEACH BOUTIQUE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DICOVER BORCAY HOTEL AND RESTAURANT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('JONYS BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('NIGI-NIGI ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AGOS BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BAMBOO BEACH RESORT BAR AND RESTAURANT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE ORIENT BEACH BORACAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PINJALO RESORT VILLAS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('UNDER THE STARS ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CORDOVA REEF ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('COSTA BELLA ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RADISSON BLU ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MARCO POLO CEBU');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWN REGENCY ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CRIMSON ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('QUEST CEBU ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('WATER FRONT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUEWATER ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MOVENPICK ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DAYS HOTEL ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE BELLEVUE ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BADIAN ISLAND RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ALONA TROPICAL BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE METRO CENTRE HOTEL AND COVENTION CENTER');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PANGLAO ISLAN NATURE RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AMARELA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FLUSHING MEADOWS RESORT & PLAYGROUND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AMORITA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUEWATER SUMILON');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PANGLAO REGENTS PARK');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BOHOL DIVERS RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ESKAYA BEACH RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DUMALUAN BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HENANN RESORT ALONA BEACH');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BOHOL BEACH CLUB');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SOUTH PALMS RESORT PANGLAO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('YSABELLE MANSION');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CORON GATEWAY HOTEL & SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CLUB PARADISE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASIA GRAND VIEW HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOLIDAY SUITES HOTEL AND RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MICROTEL (PUERTO PRINCESA)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL FLEURIS PALAWAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('D LUCY GARDEN INN AND SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITYSTATE ASTURIAS HOTEL PALAWAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE LEGEND PALAWAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AMANPULO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HILLSIDE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TWO SEASONS ISLAND RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('IPIL SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EMPIRE SUITES HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SUNZ EN CORON RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MISIBIS BAY RESORT & CASINO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL NIDO GARDEN BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BLUE LAGOON INN & SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SHERIDAN BEACH RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CORTO DEL MAR HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SANGAT ISLAND DIVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BUSUANGA BAY LODGE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DOLCE VITA HOTEL & RESTAURANT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AZIZA PARADISE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL CENTRO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ASTORIA PALAWAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HUMA ISLAND RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CORON WESTOWN RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE LEGEND PALAWAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DOS PALMAS ISLAND RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL NIDO RESORT PANGULASIAN ISLAND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL NIDO RESORT MINILOC ISLAND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL NIDO RESORT LAGEN ISLAND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL NIDO APULIT ISLAND');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CRYSTAL PARADISE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BALAYONG PENSION');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BUSUANGA ISLAND PARADISE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LA BELLE PENSION');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SUNLIGHT GUEST HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TAAL VISTA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PICO SANDS HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ACUAVERDE BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CLUB PUNTA FUEGO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ESTANCIA RESORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ACUATICO BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ESTRELLAS DE MENDOZA PLAYA RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE LAKE HOTEL TAGAYTAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CITY OF SPRINGS RESORT & HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SPLASH MOUNTAIN RESORT & HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SPLASH OASIS RESORT & HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PUERTO AZUL GOLF & COUNTRY CLUB');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('VILLA ESCUDERO PLANTATIONS & RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DAYS HOTEL TAGAYTAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('DAYS HOTEL BATANGAS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MATABUNGKAY BEACH HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HIDDEN VALLEY SPRINGS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE FARM AT SAN BENITO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SEAS SPRING RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ANILAO OUTRIGGER RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CALIRAYA RESORT CLUB INC.');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MUNTING BUHANGIN BEACH CAMO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ONE TAGAYTAY PLACE HOTEL SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('ISLAND COVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL CIELITO HOTELS STA. ROSA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TAGAYTAY INTERNATIONAL CONVENTION COMPLEX');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BP INTERNATIONAL-MAKILING');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PALM BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TECHNOPARK HOTEL ');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AIYANAR BEACH DIVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL LUNA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LE MONET HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CLUB BALAI ISABEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CANDON HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CASA NICAROSA HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LIMA PARK HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SEAS SPRING RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL KIMBERLY TAGAYTAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PRYCE PLAZA CAGAYAN DE ORO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MICROTEL (EAGLE RIDGE)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MICROTEL (STO. TOMAS BATANGAS)');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL VENEZIA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FORT ILOCANDIA RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE TORRE VENEZIA SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SKYLIGHT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('THE MANOR CAMP JOHN HAY');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('IMPERIAL PALACE SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CENTRAL PARK HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EL CIELITO INN-BAGUIO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SUGARLAND HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LE MONET HOTEL BAGUIO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AZALEA HOTELS & RESIDENCES BAGUIO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('EGI ALBERGO INC.');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LUXUR PLACE');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BAGUIO BURNHAM SUITES');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CHALET BAGUIO');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PUERTO DEL SOL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CANDON HOTEL ILOCOS SUR');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('VITALIS ILOCUS SUR');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('HOTEL LUNA ILOCOS SUR');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('FINAL OPTION BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GRAND OCTAGON RESORT & HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('JAVA HOTEL LAOAG');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PUERTO NIRVANA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MARCO VINCENT DIVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CROWN ROYALE HOTEL BATAAN');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('COCO BEACH ISLAND RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('RED SUN DIVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('AZIZA PARADISE HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('PLAYA TROPICAL RESORT HOTEL');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('CLUB MABUHAY LA LAGUNA RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TANAWIN BAY BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BURI BEACH RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('LOST HORIZON BEACH DIVE RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('MOUNT SEA RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('SUBIC HOLIDAY VILLAS');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('GRANDE ISLAND RESORT');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BAHURA RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('BURI RESORT & SPA');
INSERT INTO `basecamp`.`hotel/resort` (`name`) VALUES ('TUGATAWE COVE RESORT');
