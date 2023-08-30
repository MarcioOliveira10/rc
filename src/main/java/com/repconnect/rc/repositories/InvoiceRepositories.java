package com.repconnect.rc.repositories;

import com.repconnect.rc.models.InvoicesModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface InvoiceRepositories extends JpaRepository<InvoicesModel, UUID> {
}
