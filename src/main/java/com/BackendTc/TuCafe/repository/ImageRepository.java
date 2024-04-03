package com.BackendTc.TuCafe.repository;

import com.BackendTc.TuCafe.model.Business;
import com.BackendTc.TuCafe.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImageRepository  extends JpaRepository<Image, Long> {

    List<Image> findByBusiness(Business business);
}
