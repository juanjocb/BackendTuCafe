package com.BackendTc.TuCafe.repository;

import com.BackendTc.TuCafe.model.Business;
import com.BackendTc.TuCafe.model.Client;
import com.BackendTc.TuCafe.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    List<Reservation> findAllByClientId(Client clientId);

    List<Reservation> findAllByBusinessId(Business businessId);
}
