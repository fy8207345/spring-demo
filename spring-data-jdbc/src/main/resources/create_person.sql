CREATE TABLE `t_person` (
                            `id` BIGINT(20) NULL DEFAULT NULL,
                            `name` VARCHAR(32) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
                            `birthday` DATETIME NULL DEFAULT NULL,
                            `version` BIGINT(20) NULL DEFAULT NULL
)
    COLLATE='utf8mb4_bin'
    ENGINE=InnoDB
;
CREATE TABLE `t_address` (
                             `detail` VARCHAR(50) NULL DEFAULT NULL COLLATE 'utf8mb4_bin',
                             `person_id` BIGINT(20) NULL DEFAULT NULL
)
    COLLATE='utf8mb4_bin'
    ENGINE=InnoDB
;
