package joochang.project.web;

import joochang.project.domain.Member;
import joochang.project.member.MemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

    private final MemberService memberService;

    @GetMapping("members/new")
    public String signUpForm(Model model) {
        MemberForm memberForm = new MemberForm();
        model.addAttribute("memberForm", memberForm);
        return "members/signUp";
    }


    @PostMapping("members/new")
    public String signUp(MemberForm memberFrom, Model model) throws Exception{
        Member member = new Member();

        member.insertMemberInfo(memberFrom);

        try {
            memberService.join(member);
        } catch (Exception e) {
            model.addAttribute("msg",e.getMessage());
            return "errPage";
        }


        return "redirect:../";
    }


}
