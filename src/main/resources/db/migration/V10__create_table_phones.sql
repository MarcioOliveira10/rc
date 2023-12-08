CREATE TABLE `phones` (
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `number` VARCHAR(20),
    `name` VARCHAR(50),
    `represented_id` INT UNIQUE,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`),
    CONSTRAINT `fk_phones_represented` FOREIGN KEY(represented_id) REFERENCES `represented`(`id`)
);