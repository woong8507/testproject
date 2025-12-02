# Spring Boot 샘플 프로젝트

간단한 REST API를 제공하는 스프링 부트 샘플 애플리케이션입니다.

## 프로젝트 위치

이 프로젝트는 `C:\project\testproject`에 위치합니다.

## 프로젝트 구조

```
testproject/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/demo/
│   │   │       ├── SpringBootSampleApplication.java  # 메인 애플리케이션 클래스
│   │   │       └── controller/
│   │   │           └── HelloController.java          # REST API 컨트롤러
│   │   └── resources/
│   │       └── application.properties                # 설정 파일
│   └── test/
│       └── java/
│           └── com/example/demo/
└── pom.xml                                           # Maven 설정 파일
```

## 요구사항

- Java 17 이상
- Maven 3.6 이상

## 실행 방법

### 1. 프로젝트 디렉토리로 이동

```powershell
cd C:\project\testproject
```

### 2. Maven을 사용한 실행

```powershell
mvn spring-boot:run
```

### 3. JAR 파일로 실행

```powershell
# JAR 파일 빌드
mvn clean package

# JAR 파일 실행
java -jar target/spring-boot-sample-1.0.0.jar
```

## API 엔드포인트

애플리케이션이 시작되면 다음 엔드포인트를 사용할 수 있습니다:

### 1. 기본 인사말
```
GET http://localhost:8080/api/hello
```

**응답 예시:**
```json
{
  "message": "안녕하세요! 스프링 부트에 오신 것을 환영합니다!",
  "status": "success"
}
```

### 2. 이름을 포함한 인사말
```
GET http://localhost:8080/api/hello/{name}
```

**예시:**
```
GET http://localhost:8080/api/hello/홍길동
```

**응답 예시:**
```json
{
  "message": "안녕하세요, 홍길동님!",
  "status": "success"
}
```

### 3. 쿼리 파라미터를 사용한 인사말
```
GET http://localhost:8080/api/greet?name=홍길동&age=25
```

**응답 예시:**
```json
{
  "message": "안녕하세요, 홍길동님!",
  "age": 25,
  "info": "홍길동님은 25세입니다.",
  "status": "success"
}
```

### 4. 애플리케이션 정보
```
GET http://localhost:8080/api/info
```

**응답 예시:**
```json
{
  "application": "Spring Boot Sample Application",
  "version": "1.0.0",
  "description": "간단한 스프링 부트 샘플 프로젝트",
  "endpoints": [
    "/api/hello",
    "/api/hello/{name}",
    "/api/greet?name={name}&age={age}",
    "/api/info"
  ]
}
```

## 테스트 방법

### 브라우저에서 테스트
브라우저 주소창에 다음 URL을 입력:
- http://localhost:8080/api/hello
- http://localhost:8080/api/hello/홍길동
- http://localhost:8080/api/info

### PowerShell에서 테스트
```powershell
# 기본 인사말
Invoke-WebRequest -Uri http://localhost:8080/api/hello

# 이름 포함 인사말
Invoke-WebRequest -Uri http://localhost:8080/api/hello/홍길동

# 쿼리 파라미터 사용
Invoke-WebRequest -Uri "http://localhost:8080/api/greet?name=홍길동&age=25"

# 애플리케이션 정보
Invoke-WebRequest -Uri http://localhost:8080/api/info
```

## 주요 기능

1. **RESTful API**: REST API 엔드포인트 제공
2. **자동 설정**: Spring Boot의 자동 설정 기능 활용
3. **내장 서버**: 내장 톰캣 서버로 별도 서버 설치 불필요
4. **JSON 응답**: 자동으로 JSON 형식으로 응답

## 기술 스택

- Spring Boot 3.2.0
- Java 17
- Maven
- Spring Web (REST API)

## 다음 단계

이 샘플 프로젝트를 기반으로 다음과 같은 기능을 추가할 수 있습니다:

- 데이터베이스 연동 (JPA, H2, MySQL 등)
- 보안 설정 (Spring Security)
- 예외 처리 (Global Exception Handler)
- 로깅 설정
- 테스트 코드 작성
- Docker 컨테이너화

