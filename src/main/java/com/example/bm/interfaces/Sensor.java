package com.example.bm.interfaces;

import com.example.bm.enums.Status;
import com.example.bm.models.Plot;

public interface Sensor {
    Status checkSensorStatus(Plot plot);
}
