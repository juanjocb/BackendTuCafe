package com.BackendTc.TuCafe.repository;

import com.BackendTc.TuCafe.model.View;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ViewRepository extends JpaRepository<View, Long> {


}
