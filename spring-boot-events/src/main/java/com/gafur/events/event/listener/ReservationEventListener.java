package com.gafur.events.event.listener;

import com.gafur.events.event.ReservationCreatedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class ReservationEventListener {

    @EventListener
    public void reservationEventHandler(ReservationCreatedEvent reservationCreatedEvent) throws InterruptedException {
        TimeUnit.SECONDS.sleep(5);
        System.out.println("ReservationEventListener.reservationEventHandler(" + reservationCreatedEvent.getSource().toString() + ")");
    }
}
