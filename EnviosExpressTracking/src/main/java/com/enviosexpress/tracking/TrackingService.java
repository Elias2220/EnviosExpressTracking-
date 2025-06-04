package com.enviosexpress.tracking;

import jakarta.jws.WebMethod;
import jakarta.jws.WebService;

@WebService
public interface TrackingService {

    @WebMethod
    GetTrackingStatusResponse getTrackingStatus(GetTrackingStatusRequest request);

}
