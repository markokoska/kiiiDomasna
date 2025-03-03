package finki.ukim.mk.airbnb.listeners;

import finki.ukim.mk.airbnb.events.*;
import finki.ukim.mk.airbnb.model.Accommodation;
import finki.ukim.mk.airbnb.service.AccommodationService;
import org.springframework.context.event.EventListener;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Component
public class AccommodationListener {
    private final AccommodationService accommodationService;

    public AccommodationListener(AccommodationService accommodationService) {
        this.accommodationService = accommodationService;
    }

    @EventListener
    public ResponseEntity<List<Accommodation>> handleNoAccommodationsFound(NoEntitiesOfCategoryEvent event) {
        String category = event.getCategory();
        System.out.printf("No accommodations found for category: %s%n", category);
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Collections.emptyList());
    }
}
