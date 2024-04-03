package com.BackendTc.TuCafe.repository;

import com.BackendTc.TuCafe.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AdminRepository extends JpaRepository<Admin, Long> {

    Admin findByEmail(String email);
    Admin findById(long id);
    List<Admin> findAll();

}
