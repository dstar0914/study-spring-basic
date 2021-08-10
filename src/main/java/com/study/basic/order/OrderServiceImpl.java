package com.study.basic.order;

import com.study.basic.discount.DiscountPolicy;
import com.study.basic.member.Member;
import com.study.basic.member.MemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository; // interface 에만 의존하도록 수정하였음
    private final DiscountPolicy discountPolicy; // interface 에만 의존하도록 수정하였음

    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }

}
