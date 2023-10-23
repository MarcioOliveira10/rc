
CREATE TABLE `sales` (
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `value` DECIMAL NOT NULL,
    `sale_date` DATE,
    `observation` TEXT,
    `customer_id` INT UNIQUE,
    `represented_id` INT UNIQUE,
    `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    `updated_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`)
);
ALTER TABLE `sales` ADD CONSTRAINT `represented_id_fk` FOREIGN KEY (`sale_id`) REFERENCES `sales`(`id`);