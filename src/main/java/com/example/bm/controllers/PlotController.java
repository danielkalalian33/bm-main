package com.example.bm.controllers;

import com.example.bm.models.Plot;
import com.example.bm.services.PlotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/plot")
public class PlotController {
    @Autowired
    PlotService plotService;

    @PostMapping("/createNewPlot")
    public Plot createNewPlot(@RequestBody Plot plot) {
        return plotService.createNewPlot(plot);
    }

    @PostMapping("/configurePlot")
    public Plot configurePlot(@RequestBody Plot plot) {
        return plotService.configurePlot(plot);
    }

    @PutMapping("/editPlot/{id}")
    public Plot editPlot(@PathVariable Integer id, @RequestBody Plot plot) {
        if(id != null)
            return plotService.editPlot(plot);
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "ID Not Found");
    }

    @GetMapping("/showAllPlots")
    public List<Plot> showAllPlots() {
        return plotService.showAllPlots();
    }
}
