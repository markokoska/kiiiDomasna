package finki.ukim.mk.airbnb.events;

import finki.ukim.mk.airbnb.model.Accommodation;
import org.springframework.context.ApplicationEvent;

public class NoRoomsAvailableEvent extends ApplicationEvent {
    public NoRoomsAvailableEvent(Accommodation source) {
        super(source);
    }
}
