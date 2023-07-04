package com.example.bm.services;

import com.example.bm.models.AgriculturalCrop;
import com.example.bm.repositories.AgriculturalCropRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgriculturalCropService {
    @Autowired
    AgriculturalCropRepository agriculturalCropRepository;

    public AgriculturalCrop createNewCrop(AgriculturalCrop agriculturalCrop) {
        return agriculturalCropRepository.save(agriculturalCrop);
    }
}
