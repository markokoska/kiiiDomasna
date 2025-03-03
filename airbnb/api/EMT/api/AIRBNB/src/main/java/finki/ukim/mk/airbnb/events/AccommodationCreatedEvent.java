package finki.ukim.mk.airbnb.events;

import finki.ukim.mk.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationCreatedEvent extends ApplicationEvent {
    public AccommodationCreatedEvent(Accommodation source) {
        super(source);
    }
}
