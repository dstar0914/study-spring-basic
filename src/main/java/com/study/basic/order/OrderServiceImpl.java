package com.study.basic.order;

import com.study.basic.discount.DiscountPolicy;
import com.study.basic.member.Member;
import com.study.basic.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceImpl implements OrderService {

//    @Autowired
    private final MemberRepository memberRepository; // interface 에만 의존하도록 수정하였음

//    @Autowired
    private final DiscountPolicy discountPolicy; // interface 에만 의존하도록 수정하였음

//    @Autowired
//    public void setMemberRepository(MemberRepository memberRepository) {
//        this.memberRepository = memberRepository;
//    }
//
//    @Autowired
//    public void setDiscountPolicy(DiscountPolicy discountPolicy) {
//        this.discountPolicy = discountPolicy;
//    }

//    @Autowired // 생성자가 하나인 경우엔 없어도 자동으로 인식함. 생성자가 여러개인 경우에는 넣어줘야 함
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
