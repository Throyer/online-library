package bibliotech.controllers;

import bibliotech.models.Loan;
import bibliotech.models.Member;
import bibliotech.services.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/members")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @PutMapping("/{id}")
    public Member updateMember(@PathVariable Long id, @RequestBody Member memberDetails) {
        return memberService.updateMember(id, memberDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteMember(@PathVariable Long id) {
        memberService.deleteMember(id);
    }

    @GetMapping
    public List<Member> getAllMembers() {
        return memberService.getAllMembers();
    }

    @GetMapping("/{id}")
    public Member getMemberById(@PathVariable Long id) {
        return memberService.getMemberById(id);
    }
    @GetMapping("/{id}/loans")
    public List<Loan> getMemberLoanHistory(@PathVariable Long id) {
        Member member = memberService.getMemberById(id);
        return member.getLoanHistory();
        //para ver os emprestimos, opção bonus
    }
}
