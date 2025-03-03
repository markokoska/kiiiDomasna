package finki.ukim.mk.airbnb.service.impl;

import finki.ukim.mk.airbnb.model.Accommodation;
import finki.ukim.mk.airbnb.model.Category;
import finki.ukim.mk.airbnb.model.exceptions.AccommodationNotFoundException;
import finki.ukim.mk.airbnb.model.exceptions.HostNotFoundException;
import finki.ukim.mk.airbnb.model.exceptions.NoAvailableNightsException;
import finki.ukim.mk.airbnb.repository.AccommodationRepository;
import finki.ukim.mk.airbnb.service.AccommodationService;
import finki.ukim.mk.airbnb.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    private final AccommodationRepository accommodationRepository;
    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }
    @Override
    public List<Accommodation> listAll() {
        return accommodationRepository.findAll().stream().filter(Accommodation::getIsAvailable).toList();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return Optional.of(accommodationRepository.findById(id).orElseThrow(AccommodationNotFoundException::new));
    }

    @Override
    public Optional<Accommodation> create(String name, Category category, Long hostId, Integer availableNights) {
        return Optional.of(accommodationRepository.save(new Accommodation(
                name,
                availableNights,
                category,
                hostService.findById(hostId).orElseThrow(HostNotFoundException::new))));
    }

    @Override
    public Optional<Accommodation> update(Long id, String name, Category category, Long hostId, Integer availableNights) {
        Accommodation accommodation = findById(id).orElseThrow(AccommodationNotFoundException::new);
        accommodation.setName(name);
        accommodation.setCategory(category);
        accommodation.setHost(hostService.findById(id).orElseThrow(HostNotFoundException::new));
        accommodation.setNumRooms(availableNights);
        return Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public Optional<Accommodation> delete(Long id) {
        Accommodation accommodation = findById(id).orElseThrow(AccommodationNotFoundException::new);
        accommodationRepository.delete(accommodation);
        return Optional.of(accommodation);
    }

    @Override
    public Optional<Accommodation> lowerAvailableNights(Long id) throws NoAvailableNightsException {
        Accommodation accommodation = findById(id).orElseThrow(AccommodationNotFoundException::new);
        if (accommodation.getNumRooms() == 0 || !accommodation.getIsAvailable()){
            throw new NoAvailableNightsException();
        }
        accommodation.setIsAvailable(false);
        accommodation.setNumRooms(accommodation.getNumRooms() - 1);
        return  Optional.of(accommodationRepository.save(accommodation));
    }

    @Override
    public List<Accommodation> filter(String category) {
        return listAll().stream().filter(x->x.getCategory().name().equals(category)).toList();
    }
}
