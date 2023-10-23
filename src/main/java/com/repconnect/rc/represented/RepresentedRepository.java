package com.repconnect.rc.represented;

import com.repconnect.rc.represented.Represented;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepresentedRepository extends JpaRepository<Represented, Integer> {
}
