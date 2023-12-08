package com.repconnect.represented;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentedRepository extends JpaRepository<Represented, Integer> {
}
