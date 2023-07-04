package com.example.bm.repositories;

import com.example.bm.models.Plot;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlotRepository extends CrudRepository<Plot, Integer> {
    List<Plot> findAll();

    List<Plot> findAllByIsIrrigated(Boolean isIrrigated);
}
