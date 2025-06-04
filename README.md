# pt-batch

Spring Batch와 Spring Boot를 사용하여 PT(개인 트레이닝) 이용권을 관리하기 위한 예제 프로젝트입니다. 
이 문서는 프로젝트의 빌드, 실행 및 기본 설정 방법에 대해 설명합니다.

## 주요 기술

- **Java 17**
- **Spring Boot 2.7.3**
- **Spring Batch**
- **Spring Data JPA**
- **Lombok**
- **H2 Database** (기본)
- **MySQL** (선택)

## 프로젝트 구조

```
pt-service/
├── build.gradle
├── settings.gradle
├── gradle/
├── src
│   ├── main
│   │   ├── java
│   │   │   └── com/example/ptbatch
│   │   │       └── PtBatchApplication.java
│   │   └── resources
│   │       └── application.properties
│   └── test
│       └── java/com/example/ptbatch
│           └── PtBatchApplicationTests.java
```

- `PtBatchApplication.java` : 스프링 부트를 구동하는 메인 클래스
- `application.properties` : 애플리케이션 설정 파일(현재 비어 있음)

## 요구 사항

- JDK 17 이상
- Gradle (리포지토리에 포함된 `gradlew` 스크립트 사용 권장)
- (선택) MySQL 데이터베이스

## 빌드 및 실행

```bash
git clone <repository-url>
cd pt-service
./gradlew build
./gradlew bootRun
```

애플리케이션이 실행되면 기본적으로 `localhost:8080` 포트에서 동작합니다.

## 데이터베이스 설정

기본값으로 내장 H2 데이터베이스를 사용합니다. MySQL 등 외부 데이터베이스를 사용하려면
`src/main/resources/application.properties` 파일에 다음과 같이 설정을 추가하십시오.

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/ptbatch
spring.datasource.username=<사용자명>
spring.datasource.password=<비밀번호>
spring.jpa.hibernate.ddl-auto=update
```

## 테스트

```bash
./gradlew test
```

기본 테스트는 애플리케이션 컨텍스트가 정상적으로 로드되는지 확인합니다.

