

CREATE TABLE `invoice_data` (
    `id` INTEGER NOT NULL AUTO_INCREMENT UNIQUE,
    `pdf_link` varchar(255),
    `excel_link` varchar(255),
    `date` DATE,
    PRIMARY KEY (`id`)
);