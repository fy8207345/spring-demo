CREATE TABLE `T_COMPOSITE_ID` (
    `ID` INT NOT NULL ,
    PRIMARY KEY (`ID`)
);
CREATE TABLE `T_COMPOSITE` (
   `ID` INT NOT NULL ,
   `DETAIL` VARCHAR(32) NOT NULL ,
   PRIMARY KEY (`ID`, `ID`)
);
