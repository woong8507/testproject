package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * REST API 컨트롤러
 * 
 * @RestController 어노테이션은 @Controller와 @ResponseBody를 결합한 것으로,
 * 모든 메서드의 반환값이 HTTP 응답 본문에 직접 작성됩니다.
 * 
 * @RequestMapping("/api")는 이 컨트롤러의 모든 엔드포인트에
 * /api 접두사를 추가합니다.
 */
@RestController
@RequestMapping("/api")
public class HelloController {

  /**
   * 기본 인사말 API
   * GET /api/hello
   * 
   * @return 인사 메시지
   */
  @GetMapping("/hello")
  public Map<String, String> hello() {
    Map<String, String> response = new HashMap<>();
    response.put("message", "안녕하세요! 스프링 부트에 오신 것을 환영합니다!");
    response.put("status", "success");
    return response;
  }

  /**
   * 이름을 받아서 인사하는 API
   * GET /api/hello/{name}
   * 
   * @param name 경로 변수로 받은 이름
   * @return 개인화된 인사 메시지
   */
  @GetMapping("/hello/{name}/{age}")
  public Map<String, String> helloWithName(@PathVariable String name, @PathVariable int age ) {
    Map<String, String> response = new HashMap<>();
    response.put("message", "안녕하세요, " + name + "님! 당신의 나이는"+age+"세입니다.ㅋㅋㅋㅋㅋ");
    response.put("status", "success");
    return response;
  }

  /**
   * 쿼리 파라미터를 받는 API
   * GET /api/greet?name=홍길동&age=25
   * 
   * @param name 쿼리 파라미터로 받은 이름
   * @param age 쿼리 파라미터로 받은 나이 (선택적)
   * @return 인사 메시지
   */
  @GetMapping("/greet")
  public Map<String, Object> greet(
      @RequestParam String name,
      @RequestParam(required = false, defaultValue = "0") Integer age) {
    
    Map<String, Object> response = new HashMap<>();
    response.put("message", "안녕하세요, " + name + "님!");
    
    if (age > 0) {
      response.put("age", age);
      response.put("info", name + "님은 " + age + "세입니다.");
    }
    
    response.put("status", "success");
    return response;
  }

  /**
   * 애플리케이션 정보 API
   * GET /api/info
   * 
   * @return 애플리케이션 정보
   */
  @GetMapping("/info")
  public Map<String, Object> getInfo() {
    Map<String, Object> info = new HashMap<>();
    info.put("application", "Spring Boot Sample Application");
    info.put("version", "1.0.0");
    info.put("description", "간단한 스프링 부트 샘플 프로젝트");
    info.put("endpoints", new String[]{
        "/api/hello",
        "/api/hello/{name}",
        "/api/greet?name={name}&age={age}",
        "/api/info"
    });
    return info;
  }
}

