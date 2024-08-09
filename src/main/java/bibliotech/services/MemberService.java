package bibliotech.services;


import bibliotech.models.Member;
import bibliotech.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    @Autowired
    private MemberRepository memberRepository;

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public Member updateMember(Long id, Member memberDetails) {
        Member member = memberRepository.findById(id).orElseThrow();
        member.setName(memberDetails.getName());
        member.setEmail(memberDetails.getEmail());
        member.setPhone(memberDetails.getPhone());
        member.setAddress(memberDetails.getAddress());
        return memberRepository.save(member);
    }

    public void deleteMember(Long id) {
        memberRepository.deleteById(id);
    }

    public List<Member> getAllMembers() {
        return memberRepository.findAll();
    }

    public Member getMemberById(Long id) {
        return memberRepository.findById(id).orElseThrow();
    }
}
