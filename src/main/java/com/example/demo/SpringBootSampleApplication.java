package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Spring Boot 메인 애플리케이션 클래스
 * 
 * @SpringBootApplication 어노테이션은 다음을 포함합니다:
 * - @Configuration: 스프링 설정 클래스임을 나타냄
 * - @EnableAutoConfiguration: 자동 설정 활성화
 * - @ComponentScan: 컴포넌트 스캔 활성화
 * 
 * 이 클래스는 스프링 부트 애플리케이션의 진입점입니다.
 */
@SpringBootApplication
public class SpringBootSampleApplication {

  /**
   * 메인 메서드 - 애플리케이션 시작점
   * 
   * @param args 명령줄 인수
   */
  public static void main(String[] args) {
    // SpringApplication.run()을 통해 내장 톰캣 서버를 시작하고
    // 애플리케이션 컨텍스트를 생성합니다.
    SpringApplication.run(SpringBootSampleApplication.class, args);
    
    System.out.println("========================================");
    System.out.println("스프링 부트 애플리케이션이 시작되었습니다!");
    System.out.println("http://localhost:8080 에서 접속 가능합니다.");
    System.out.println("========================================");
  }
}

