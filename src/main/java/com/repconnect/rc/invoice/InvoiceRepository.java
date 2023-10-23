package com.repconnect.rc.invoice;

import com.repconnect.rc.invoice.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {


   // Optional<Invoice> findBYCode(String code);
}
