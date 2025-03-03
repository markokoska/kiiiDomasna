package finki.ukim.mk.airbnb.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    Integer numRooms;
    @Enumerated(EnumType.STRING)
    Category category;
    @ManyToOne
    Host host;
    Boolean isAvailable;

    public Accommodation(String name, Integer numRooms, Category category, Host host) {
        this.name = name;
        this.numRooms = numRooms;
        this.category = category;
        this.host = host;
        this.isAvailable = true;
    }

    public Accommodation() {
    }
}
