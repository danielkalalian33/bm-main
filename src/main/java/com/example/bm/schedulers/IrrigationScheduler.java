package com.example.bm.schedulers;

import com.example.bm.models.Plot;
import com.example.bm.repositories.PlotRepository;
import com.example.bm.services.IrrigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;

@Configuration
@EnableScheduling
public class IrrigationScheduler {
    @Autowired
    PlotRepository plotRepository;
    @Autowired
    IrrigationService irrigationService;

    @Scheduled(fixedRate = 1000)
    public void checkIrrigation() {
        List<Plot> plotsTrue = plotRepository.findAllByIsIrrigated(false);
        irrigationService.irrigatePlots(plotsTrue);
    }
}
