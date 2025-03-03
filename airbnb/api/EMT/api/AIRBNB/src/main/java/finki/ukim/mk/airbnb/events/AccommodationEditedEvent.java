package finki.ukim.mk.airbnb.events;

import finki.ukim.mk.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class AccommodationEditedEvent extends ApplicationEvent {
    public AccommodationEditedEvent(Accommodation source) {
        super(source);
    }
}
