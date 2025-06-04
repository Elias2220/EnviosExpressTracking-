package com.enviosexpress.tracking;

import jakarta.jws.WebService;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebService(endpointInterface = "com.enviosexpress.tracking.TrackingService")
public class TrackingServiceImpl implements TrackingService {

    @Override
    public GetTrackingStatusResponse getTrackingStatus(GetTrackingStatusRequest request) {
        GetTrackingStatusResponse response = new GetTrackingStatusResponse();

        if (request.getTrackingNumber() == null || request.getTrackingNumber().isEmpty()) {
            response.setStatus("Error: Número de tracking vacío");
            response.setHistory(new ArrayList<>());
            return response;
        }

        try (Connection conn = DatabaseUtil.getConnection()) {
            // Consultar paquete
            PreparedStatement ps = conn.prepareStatement(
                    "SELECT status, current_location, estimated_delivery_date FROM package WHERE tracking_number = ?");
            ps.setString(1, request.getTrackingNumber());
            ResultSet rs = ps.executeQuery();

            if (!rs.next()) {
                response.setStatus("Tracking no encontrado");
                response.setHistory(new ArrayList<>());
                return response;
            }

            response.setStatus(rs.getString("status"));
            response.setCurrentLocation(rs.getString("current_location"));
            response.setEstimatedDeliveryDate(rs.getDate("estimated_delivery_date").toString());

            // Consultar eventos
            PreparedStatement psEvents = conn.prepareStatement(
                    "SELECT event_date, description, location FROM tracking_event WHERE tracking_number = ? ORDER BY event_date");
            psEvents.setString(1, request.getTrackingNumber());
            ResultSet rsEvents = psEvents.executeQuery();

            List<TrackingEvent> events = new ArrayList<>();
            while (rsEvents.next()) {
                TrackingEvent event = new TrackingEvent();
                event.setDate(rsEvents.getDate("event_date").toString());
                event.setDescription(rsEvents.getString("description"));
                event.setLocation(rsEvents.getString("location"));
                events.add(event);
            }
            response.setHistory(events);

        } catch (SQLException e) {
            response.setStatus("Error de base de datos: " + e.getMessage());
            response.setHistory(new ArrayList<>());
        }

        return response;
    }
}
