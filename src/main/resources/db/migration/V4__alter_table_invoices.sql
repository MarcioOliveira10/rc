ALTER TABLE `invoices` ADD CONSTRAINT `invoices_fk` FOREIGN KEY (`sale_ID`) REFERENCES `sales`(`id`);