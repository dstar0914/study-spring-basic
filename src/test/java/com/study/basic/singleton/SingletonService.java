package com.study.basic.singleton;

public class SingletonService {

    private static final SingletonService instance = new SingletonService(); // java 기본 static 싱글톤

    // 이 메소드를 통해서만 항상 같은 인스턴스를 반환한다
    public static SingletonService getInstance() {
        return instance;
    }

    // 외부에서 막 생성하는 것을 막을 수 있음 (딱 1개의 객체 인스턴스만 존재할 수 있또록)
    // 제일 좋은 오류는 컴파일 오류이다.
    private SingletonService() {

    }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }

}
