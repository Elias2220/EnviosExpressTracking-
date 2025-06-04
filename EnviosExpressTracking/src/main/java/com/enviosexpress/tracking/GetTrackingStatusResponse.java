package com.enviosexpress.tracking;

import java.util.List;
import jakarta.xml.bind.annotation.XmlType;

@XmlType(name = "GetTrackingStatusResponseCustom", namespace = "http://tracking.enviosexpress.com/")

public class GetTrackingStatusResponse {
    private String status;
    private String currentLocation;
    private String estimatedDeliveryDate;
    private List<TrackingEvent> history;

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public String getCurrentLocation() {
        return currentLocation;
    }
    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }
    public String getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }
    public void setEstimatedDeliveryDate(String estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }
    public List<TrackingEvent> getHistory() {
        return history;
    }
    public void setHistory(List<TrackingEvent> history) {
        this.history = history;
    }
}
