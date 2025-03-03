package mk.ukim.finki.emt.drivermanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import mk.ukim.finki.emt.drivermanagement.domain.valueobjects.Car;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name="driver")
@Getter
public class Driver extends AbstractEntity<DriverId> {
    boolean status;
    Car car;
    String name;

    private Driver() {
        super(DriverId.randomId(DriverId.class));
    }

}