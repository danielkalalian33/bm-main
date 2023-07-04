package com.example.bm.controllers;

import com.example.bm.models.AgriculturalCrop;
import com.example.bm.services.AgriculturalCropService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/crop")
public class AgriculturalCropController {
    @Autowired
    AgriculturalCropService agriculturalCropService;

    @PostMapping("/createNewCrop")
    public AgriculturalCrop createNewCrop(@RequestBody AgriculturalCrop agriculturalCrop) {
        return agriculturalCropService.createNewCrop(agriculturalCrop);
    }
}
