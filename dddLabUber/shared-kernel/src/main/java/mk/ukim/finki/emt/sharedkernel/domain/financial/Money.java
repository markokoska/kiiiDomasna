package mk.ukim.finki.emt.sharedkernel.domain.financial;

import jakarta.persistence.Embeddable;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
@Embeddable
public class Money implements ValueObject {
    private String currency;
    private double amount;
}
