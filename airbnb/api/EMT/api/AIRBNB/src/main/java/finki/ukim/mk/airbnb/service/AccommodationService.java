package finki.ukim.mk.airbnb.service;

import finki.ukim.mk.airbnb.model.Accommodation;
import finki.ukim.mk.airbnb.model.Category;
import finki.ukim.mk.airbnb.model.exceptions.NoAvailableNightsException;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {
    List<Accommodation> listAll();
    Optional<Accommodation> findById(Long id);
    Optional<Accommodation> create(String name, Category category, Long hostId, Integer availableNights);
    Optional<Accommodation> update(Long id, String name, Category category, Long hostId, Integer availableNights);
    Optional<Accommodation> delete(Long id);
    Optional<Accommodation> lowerAvailableNights(Long id) throws NoAvailableNightsException;
    List<Accommodation> filter(String category);
}
