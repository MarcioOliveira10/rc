package com.repconnect.rc.repositories;

import com.repconnect.rc.domain.InvoiceData;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface InvoiceDataRepository extends JpaRepository<InvoiceData, Integer> {
}
