package com.repconnect.rc.repositories;

import com.repconnect.rc.domain.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Integer> {


   // Optional<Invoice> findBYCode(String code);
}
