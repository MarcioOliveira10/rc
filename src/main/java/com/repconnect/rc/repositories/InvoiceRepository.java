package com.repconnect.rc.repositories;

import com.repconnect.rc.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {
    @Override
    List<Invoice> findAll();
}
