package joochang.project.member;

import joochang.project.domain.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
@Slf4j
//@RequiredArgsConstructor
public class MemberService {

    @Autowired
    MemberRepository memberRepository;

    @Transactional
    public Long join(Member member) throws Exception {
        validateDuplicateMember(member);
        validateMemberForm(member);
        memberRepository.save(member);
        return member.getMemberNo();
    }

    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Member findOne(Long memberId) {
        return memberRepository.findOne(memberId);
    }

    private void validateDuplicateMember(Member member) {
        List<Member> findMembers = memberRepository.findByName(member.getName());

        if (!findMembers.isEmpty()) {
            throw new IllegalStateException("이미 존재하는 회원입니다");
        }
    }

    private void validateMemberForm(Member member) throws Exception {
        log.info(member.getId() + " " + " " + member.getEmail());
        try {
            if (member.getId().isEmpty()
                    || member.getPassword().isEmpty()
                    || member.getEmail().isEmpty()
                    || member.getPhoneNumber().isEmpty()
                    || member.getAddress().toString().isEmpty()) {
            }
        } catch (Exception e) {
            throw new IllegalStateException("필수값을 모두 입력해주세요.");

        }
        if(!member.getEmail().contains("@")) {
            throw new IllegalStateException("이메일 형식이 올바르지 않습니다.");
        }
    }


}
