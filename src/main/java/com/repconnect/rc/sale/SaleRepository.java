package com.repconnect.rc.sale;

import com.repconnect.rc.sale.Sales;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleRepository extends JpaRepository<Sales, Integer> {
}
