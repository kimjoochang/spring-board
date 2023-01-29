package joochang.project.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
public class Address {
    private int postcode;
    private String address1;
    private String address2;

    public void updateAddressInfo(Address address) {
        this.postcode = postcode;
        this.address1 = address1;
        this.address2 = address2;
    }
}
