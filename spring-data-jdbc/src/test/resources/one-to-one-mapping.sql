CREATE TABLE `USER_CREDENTIALS_ONE_TO_ONE` (
    `CREDS_ID` INT NOT NULL AUTO_INCREMENT,
    `USER_NAME` VARCHAR(20) NOT NULL,
    `PASSWORD` VARCHAR(45) NOT NULL,
    UNIQUE KEY `USERNAME_UNIQUE` (`USER_NAME`),
    PRIMARY KEY (`CREDS_ID`)
);
CREATE TABLE `USER_ONE_TO_ONE` (
    `ID` int(11) NOT NULL AUTO_INCREMENT,
    `CREATED_TIME` datetime NOT NULL,
    `UPDATED_TIME` datetime DEFAULT NULL,
    `USER_TYPE` varchar(45) NOT NULL,
    `DOB` date NOT NULL,
    `CREDS_ID` INT NULL,
    PRIMARY KEY (`ID`),
    CONSTRAINT `CREDS_ID_FK`
        FOREIGN KEY (`CREDS_ID`) REFERENCES `USER_CREDENTIALS_ONE_TO_ONE` (`CREDS_ID`)
);
