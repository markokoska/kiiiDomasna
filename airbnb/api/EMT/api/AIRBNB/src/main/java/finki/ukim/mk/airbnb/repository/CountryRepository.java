package finki.ukim.mk.airbnb.repository;

import finki.ukim.mk.airbnb.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country,Long   > {
}
