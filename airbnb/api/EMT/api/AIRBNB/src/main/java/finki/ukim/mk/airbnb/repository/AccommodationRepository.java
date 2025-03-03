package finki.ukim.mk.airbnb.repository;

import finki.ukim.mk.airbnb.model.Accommodation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccommodationRepository extends JpaRepository<Accommodation,Long> {
}
