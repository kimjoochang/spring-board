package joochang.project.domain;


import joochang.project.web.MemberForm;
import lombok.Getter;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
public class Member {

    @Id
    @GeneratedValue
    @Column(name = "member_no")
    private Long memberNo;

    private String id;

    private String password;

    private String name;

    private String email;

    private String phoneNumber;

    @Embedded
    private Address address = new Address();

    @OneToMany
    private List<Board> boards;

    private Date creationDate;

    private Date updateDate;

    // changeMemberInfo 메서드
    public void updateMemberNameInfo(String name) {
        this.memberNo = memberNo;
        this.name = name;
    }

    public void insertMemberInfo(MemberForm memberForm) {
        this.id = memberForm.getId();

        this.password = memberForm.getPassword();

        this.name = memberForm.getName();

        this.email = memberForm.getEmail();

        this.phoneNumber = memberForm.getPhoneNumber();

        this.address.updateAddressInfo(address);
    }

}
