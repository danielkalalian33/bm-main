package com.example.bm.repositories;

import com.example.bm.models.Irrigation;
import com.example.bm.models.Plot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.Optional;

@Repository
public interface IrrigationRepository extends CrudRepository<Irrigation, Integer> {
    Optional<Irrigation> findAllByPlotAndTimeSlotEnd(Plot plot, LocalDateTime localDateTime);
}
