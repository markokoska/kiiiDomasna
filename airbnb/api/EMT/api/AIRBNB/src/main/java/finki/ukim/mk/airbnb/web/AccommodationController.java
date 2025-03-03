package finki.ukim.mk.airbnb.web;

import finki.ukim.mk.airbnb.events.NoEntitiesOfCategoryEvent;
import finki.ukim.mk.airbnb.listeners.AccommodationListener;
import finki.ukim.mk.airbnb.model.Accommodation;
import finki.ukim.mk.airbnb.model.Category;
import finki.ukim.mk.airbnb.model.dto.AccommodationDTO;
import finki.ukim.mk.airbnb.model.exceptions.NoAvailableNightsException;
import finki.ukim.mk.airbnb.service.AccommodationService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/accommodations")
public class AccommodationController {
    private final AccommodationService accommodationService;
    private final AccommodationListener accommodationListener;

    public AccommodationController(AccommodationService accommodationService, AccommodationListener accommodationListener) {
        this.accommodationService = accommodationService;
        this.accommodationListener = accommodationListener;
    }


    @GetMapping("")
    public List<Accommodation> getAllAccommodations() {
        return accommodationService.listAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Accommodation> getAccommodationById(@PathVariable Long id) {
        return accommodationService.findById(id).map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/categories")
    public List<Category> getAllCategories() {
        return List.of(Category.values());
    }

    @PostMapping("/add")
    public ResponseEntity<Accommodation> addAccommodation(@RequestBody AccommodationDTO accommodationDto) {
        return accommodationService.create(accommodationDto.getName(),
                        accommodationDto.getCategory(),
                        accommodationDto.getHostId(),
                        accommodationDto.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Accommodation> deleteAccommodation(@PathVariable Long id) {
        return accommodationService.delete(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<Accommodation> editAccommodation(@PathVariable Long id, @RequestBody AccommodationDTO accommodationDto) {
        return accommodationService.update(id,
                        accommodationDto.getName(),
                        accommodationDto.getCategory(),
                        accommodationDto.getHostId(),
                        accommodationDto.getNumRooms())
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/lowerAvailableNights/{id}")
    public ResponseEntity<Accommodation> lowerAvailableNights(@PathVariable Long id) throws NoAvailableNightsException {
        return accommodationService.lowerAvailableNights(id)
                .map(accommodation -> ResponseEntity.ok().body(accommodation))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @GetMapping("/filter")
    public ResponseEntity<List<Accommodation>> filterAccommodations(@RequestParam String category) {
        List<Accommodation> filteredAccommodations = accommodationService.filter(category);
        if (filteredAccommodations.isEmpty()) {
            return accommodationListener.handleNoAccommodationsFound(new NoEntitiesOfCategoryEvent(this, category));
        } else {
            return ResponseEntity.ok(filteredAccommodations);
        }
    }

}
