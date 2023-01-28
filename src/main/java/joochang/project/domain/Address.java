package joochang.project.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private int postcode;
    private String address1;
    private String address2;

    public void updateAddressInfo(int postcode, String address1, String address2) {
        this.postcode = postcode;
        this.address1 = address1;
        this.address2 = address2;
    }
}
