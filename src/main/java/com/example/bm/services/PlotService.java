package com.example.bm.services;

import com.example.bm.models.Plot;
import com.example.bm.repositories.PlotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlotService {
    @Autowired
    PlotRepository plotRepository;

    public Plot createNewPlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public List<Plot> showAllPlots() {
        return plotRepository.findAll();
    }

    public Plot editPlot(Plot plot) {
        return plotRepository.save(plot);
    }

    public Plot configurePlot(Plot plot) {
        return null;
    }
}
