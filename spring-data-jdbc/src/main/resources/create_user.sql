CREATE TABLE `contacts` (
                            `ID` INT(11) NOT NULL,
                            `CONTACT_NO` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                            `CONTACT_TYPE` VARCHAR(45) NULL DEFAULT NULL COLLATE 'utf8mb4_bin'
)
    COLLATE='utf8mb4_bin'
    ENGINE=InnoDB
;
CREATE TABLE `contact_address` (
                                   `STREET` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                                   `STATE` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                                   `CITY` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                                   `ZIP_CODE` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                                   `USER_ID` INT(11) NOT NULL,
                                   `ADDR_TYPE` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                                   PRIMARY KEY (`USER_ID`, `ADDR_TYPE`) USING BTREE
)
    COLLATE='utf8mb4_bin'
    ENGINE=InnoDB
;
CREATE TABLE `user` (
                        `ID` INT(11) NOT NULL AUTO_INCREMENT,
                        `USER_NAME` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                        `PASSWORD` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                        `CREATED_TIME` DATETIME NOT NULL,
                        `UPDATED_TIME` DATETIME NULL DEFAULT NULL,
                        `USER_TYPE` VARCHAR(45) NOT NULL COLLATE 'utf8mb4_bin',
                        PRIMARY KEY (`ID`) USING BTREE,
                        UNIQUE INDEX `USER_NAME_UNIQUE` (`USER_NAME`) USING BTREE
)
    COLLATE='utf8mb4_bin'
    ENGINE=InnoDB
    AUTO_INCREMENT=3
;
