package com.repconnect.invoiceData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceDataRepository extends JpaRepository<InvoiceData, Integer> {
}
