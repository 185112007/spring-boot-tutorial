package com.gafur.events.service;

import com.gafur.events.api.BookingApi;
import com.gafur.events.event.ReservationCreatedEvent;
import com.gafur.events.model.HotelBookRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class ReservationService {

    @Autowired
    private ApplicationEventPublisher applicationEventPublisher;

    @Async
    public void publishReservation(HotelBookRequest hotelBookRequest){
        applicationEventPublisher.publishEvent(new ReservationCreatedEvent(hotelBookRequest));
    }
}
