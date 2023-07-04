package com.example.bm.services;

import com.example.bm.enums.Status;
import com.example.bm.interfaces.Sensor;
import com.example.bm.models.Irrigation;
import com.example.bm.models.Plot;
import com.example.bm.repositories.IrrigationRepository;
import com.example.bm.repositories.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class IrrigationService implements Sensor {
    @Autowired
    IrrigationRepository irrigationRepository;
    @Autowired
    PlotRepository plotRepository;

    public void needsIrrigation(Integer plotId) {
        Plot plot = plotRepository.findById(plotId).get();
        plot.setIsIrrigated(false);
        plotRepository.save(plot);
    }

    public void stopIrrigation(Integer plotId) {
        Plot plot = plotRepository.findById(plotId).get();
        plot.setIsIrrigated(true);
        plotRepository.save(plot);

        Optional<Irrigation> irrigation = irrigationRepository.findAllByPlotAndTimeSlotEnd(plot, null);
        irrigation.ifPresent(value -> value.setTimeSlotEnd(LocalDateTime.now()));
        irrigationRepository.save(irrigation.get());
    }

    public void irrigatePlots(List<Plot> plots) {
        plots.forEach(plot -> {
            Irrigation irrigation = new Irrigation();
            irrigation.setPlot(plot);
            irrigation.setWaterAmount(plot.getCultivatedArea() * plot.getCrop().getWaterAmount());
            irrigation.setTimeSlotStart(LocalDateTime.now());
            irrigationRepository.save(irrigation);
        });
    }

    public void irrigatePlot(Plot plot) {
        Irrigation irrigation = new Irrigation();
        irrigation.setPlot(plot);
        irrigation.setWaterAmount(plot.getCultivatedArea() * plot.getCrop().getWaterAmount());
        irrigation.setTimeSlotStart(LocalDateTime.now());
        irrigationRepository.save(irrigation);
    }

    public void retryIrrigation(Plot plot) {
        if (plot.getRetryCount() < 4) {
            if (checkSensorStatus(plot) == Status.Offline) {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                } finally {
                    plot.setRetryCount(plot.getRetryCount() + 1);
                    retryIrrigation(plot);
                }
            } else {
                if (!plot.getIsIrrigated())
                    irrigatePlot(plot);
            }
        } else {
            plot.setSensorStatus(Status.Offline);
            plotRepository.save(plot);
            System.out.println("Alert Sensor Offline!");
        }
    }

    @Override
    public Status checkSensorStatus(Plot plot) {
        //Pre-configured function to get the status of the sensor using the plot id
        return Status.Online;
    }
}
