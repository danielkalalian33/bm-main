package com.example.bm.repositories;

import com.example.bm.models.AgriculturalCrop;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AgriculturalCropRepository extends CrudRepository<AgriculturalCrop, Integer> {
}
