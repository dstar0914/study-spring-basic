package com.study.basic.member;

public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository; // interface 에만 의존하도록 수정하였음

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
