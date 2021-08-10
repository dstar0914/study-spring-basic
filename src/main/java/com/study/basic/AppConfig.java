package com.study.basic;

import com.study.basic.discount.DiscountPolicy;
import com.study.basic.discount.RateDiscountPolicy;
import com.study.basic.member.MemberService;
import com.study.basic.member.MemberServiceImpl;
import com.study.basic.member.MemoryMemberRepository;
import com.study.basic.order.OrderService;
import com.study.basic.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    // @Bean memberService -> new MemoryMemberRepository()
    // @Bean orderService -> new MemoryMemberRepository() --> 이렇게 되면 싱글톤이 깨지는게 아닌 지? -> 스프링 컨테이너는 이걸 어떻게 처리할까?

    // 예상
    // Call AppConfig.memberService
    // Call AppConfig.memberRepository
    // Call AppConfig.memberRepository
    // Call AppConfig.orderService
    // Call AppConfig.memberRepository

    // 실제 -> 스프링이 싱글톤을 유지해줬음 -> 바이트 코드 조작의 마법 (@Configuration 에 답이 있다)
    // Call AppConfig.memberService
    // Call AppConfig.memberRepository
    // Call AppConfig.orderService

    @Bean
    public MemberService memberService() {
        System.out.println("Call AppConfig.memberService");

        return new MemberServiceImpl(memberRepository()); // 생성자 주입
    }

    @Bean
    public MemoryMemberRepository memberRepository() {
        System.out.println("Call AppConfig.memberRepository");

        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("Call AppConfig.orderService");

        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }

}
