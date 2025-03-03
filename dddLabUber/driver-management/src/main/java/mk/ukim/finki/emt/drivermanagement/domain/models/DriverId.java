package mk.ukim.finki.emt.drivermanagement.domain.models;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class DriverId extends DomainObjectId {

    private DriverId() {
        super(DriverId.randomId(ProductId.class).getId());
    }

    public ProductId(@NonNull String uuid) {
        super(uuid);
    }

    public static ProductId of(String uuid) {
        ProductId p = new ProductId(uuid);
        return p;
    }

}
