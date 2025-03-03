package finki.ukim.mk.airbnb.model.dto;

import finki.ukim.mk.airbnb.model.Category;
import lombok.Data;

@Data
public class AccommodationDTO {
    String name;
    Integer numRooms;
    Category category;
    Long hostId;
}
