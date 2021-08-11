package com.study.basic;

import com.study.basic.member.MemberRepository;
import com.study.basic.member.MemoryMemberRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
//        basePackages = "com.study.basic.member", // member 패키지만 불러오고 싶을 때
//        basePackageClasses = AutoAppConfig.class, // 지정하지 않은 default: AuthAppConfig 위치가 있는 패키지 부터 하위를 모두 뒤짐.
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class) // AppConfig 를 위해 제외하였음
)
public class AutoAppConfig {

//    @Bean(name = "memoryMemberRepository")
//    MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
//    }

}
