package com.study.basic.member;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // interface 에만 의존하도록 수정하였음

    @Autowired // 자동으로 의존관계 주입, ac.getBean(MemberRepository.class 이런 코드가 자동으로 들어간다고 생각하면 됨
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    // 테스트 코드
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
