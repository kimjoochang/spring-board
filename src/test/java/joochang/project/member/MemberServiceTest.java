package joochang.project.member;

import joochang.project.domain.Address;
import joochang.project.domain.Member;
import joochang.project.web.MemberForm;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired MemberService memberService;
    @Autowired MemberRepository memberRepository;

    @Test
    @Transactional
    void join() throws Exception{

        //given
        Member member = new Member();
        member.updateMemberNameInfo("test3");

        //when
        Long saveId = memberService.join(member);
        //then
        assertEquals(member,memberRepository.findOne(saveId));
        assertEquals(member,memberRepository.findOne(saveId));
    }

    @Test
    @Transactional
    void joinDuplicateException() throws Exception{
        //given
        Member m1 = new Member();
        m1.updateMemberNameInfo("test");

        Member m2 = new Member();
        m2.updateMemberNameInfo("test");

        //when
        memberService.join(m1);
        memberService.join(m2);

        //then
        fail("예외발생");

    }

    @Test
    @Transactional
    void joinEmailValidateException() throws Exception {
        //given
        Member m1 = new Member();
        MemberForm mf = new MemberForm();
        Address address = new Address();



        mf.setId("test");
        mf.setName("test");
        mf.setPassword("test");
        mf.setPhoneNumber("01012341234");
        mf.setEmail("emial");

        address.setPostcode(123);
        address.setAddress1("test");
        address.setAddress2("test");
        //address.updateAddressInfo(address);
        mf.setAddress(address);

        //when
        m1.insertMemberInfo(mf);
        //memberService.join(m1);

        //then
        Assertions.assertThrows(IllegalStateException.class, () -> {
            memberService.join(m1);
        });



    }

    @Test
    @Transactional
    void joinNullCheckValidateException() throws Exception {
        //given
        Member m1 = new Member();
        MemberForm mf = new MemberForm();
        Address address = new Address();


        mf.setId("test");
        mf.setName("test");
        mf.setPassword("test");
        mf.setPhoneNumber("01012341234");
        //mf.setEmail("emial");

        address.setPostcode(123);
        address.setAddress1("test");
        address.setAddress2("test");
        //address.updateAddressInfo(address);
        mf.setAddress(address);

        //when
        m1.insertMemberInfo(mf);
        memberService.join(m1);

        //then
        fail("null 오류");
    }

    @Test
    @Transactional
    void findMembers() throws Exception {
        //given
        Member m1 = new Member();
        m1.updateMemberNameInfo("test1");

        Member m2 = new Member();
        m2.updateMemberNameInfo("test2");

        Member m3 = new Member();
        m3.updateMemberNameInfo("test3");

        //when
        memberService.join(m1);
        memberService.join(m2);
        memberService.join(m3);

        //then
        Assertions.assertEquals(3,memberService.findMembers().size());

    }

    @Test
    void findOne() throws Exception {
        //given
        Member m1 = new Member();
        m1.updateMemberNameInfo("test");

        //when
        Long id = memberService.join(m1);

        //then
        Assertions.assertEquals(m1,memberService.findOne(id));
    }
}