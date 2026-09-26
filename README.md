# 파쿠파쿠: 도심지 녹지 산책 유도 앱 (백엔드)

2024 동아 해커톤에서 만든 도심 녹지 산책 유도 앱의 백엔드입니다. 동아 해커톤 최우수상.

## 기능
- 회원 가입, 로그인
- 공원 정보 조회
- 공원 리뷰, 좋아요 (서비스 계층)
- 회원별 공원 방문 기록 (엔티티 관계 설계)

## 도메인
`Member`, `Park`, `MemberParkVisit`, `Review`

## 기술
Java 23 · Spring Boot 3.3 · Spring Data JPA · MySQL

## 실행
```bash
./gradlew bootRun
```

## 역할
백엔드 1인 개발 (나지성)
