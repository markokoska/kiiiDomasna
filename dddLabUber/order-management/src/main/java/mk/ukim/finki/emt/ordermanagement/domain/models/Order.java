package mk.ukim.finki.emt.ordermanagement.domain.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

@Entity
@Table(name="order")
public class Order extends AbstractEntity<OrderId> {

}
