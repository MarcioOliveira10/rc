package com.repconnect.rc.repositories;

import com.repconnect.rc.domain.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Integer> {
}
