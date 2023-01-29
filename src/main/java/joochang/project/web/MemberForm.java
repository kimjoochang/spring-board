package joochang.project.web;

import joochang.project.domain.Address;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embedded;

@Getter @Setter
public class MemberForm {

    private String id;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    private Address address = new Address();

}
