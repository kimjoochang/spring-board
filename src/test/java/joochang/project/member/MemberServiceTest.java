package joochang.project.member;

import joochang.project.domain.Member;
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
    void join() {

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
    void joinException() {
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
    void findMembers() {
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
    void findOne() {
        //given
        Member m1 = new Member();
        m1.updateMemberNameInfo("test");

        //when
        Long id = memberService.join(m1);

        //then
        Assertions.assertEquals(m1,memberService.findOne(id));
    }
}