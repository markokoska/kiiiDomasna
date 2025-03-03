package mk.ukim.finki.emt.drivermanagement.domain.valueobjects;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class Car {
    private String Name;
    private String model;
    private int productionYear;

    public Car(String name, String model, int productionYear) {
        Name = name;
        this.model = model;
        this.productionYear = productionYear;
    }
}
