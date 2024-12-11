package org.sid.customerservice.entities;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "fullcustomer", types = Customer.class) //useful when you don't need to return the entire entity but just a subset of its properties.
public interface CustomerProjection {
    public Long getId();
    public String getName();
}
