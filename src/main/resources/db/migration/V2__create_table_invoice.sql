
CREATE TABLE `invoices` (
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `invoice_date` DATE,
    `code` varchar(100) UNIQUE,
    `value` DECIMAL,
    `observation` TEXT,
    `due_date` DATE,
    `invoice_data_ID` INTEGER,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`invoice_data_ID`) REFERENCES `invoice_data`(`id`)
);



