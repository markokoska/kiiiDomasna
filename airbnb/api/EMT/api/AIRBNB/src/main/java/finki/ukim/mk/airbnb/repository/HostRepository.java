package finki.ukim.mk.airbnb.repository;

import finki.ukim.mk.airbnb.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
