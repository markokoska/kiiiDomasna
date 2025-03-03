package finki.ukim.mk.airbnb.events;

import finki.ukim.mk.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationDeletedEvent extends ApplicationEvent {
    public AccommodationDeletedEvent(Accommodation source) {
        super(source);
    }
}
