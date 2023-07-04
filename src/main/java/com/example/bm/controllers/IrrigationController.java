package com.example.bm.controllers;

import com.example.bm.services.IrrigationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/irrigation")
public class IrrigationController {
    @Autowired
    IrrigationService irrigationService;

    @PutMapping("/needsIrrigation/{plotId}")
    public void needsIrrigation(@PathVariable Integer plotId) {
        irrigationService.needsIrrigation(plotId);
    }

    @PutMapping("/stopIrrigation/{plotId}")
    public void stopIrrigation(@PathVariable Integer plotId) {
        irrigationService.stopIrrigation(plotId);
    }
}
