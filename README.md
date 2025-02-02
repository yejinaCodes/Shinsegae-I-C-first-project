# 👑 Gold WMS Project 👑
## 📦 WMS (Warehouse Management System)
-  전체 공급망 관리(SCM)에서 **창고 관련 모든 작업들을 관리하는 창고 통합 관리** 소프트웨어
## 🗓️ 개발 기간
2024.08.13(화) ~ 2024.08.20(화)
<br><br>

## 👨‍👩‍👦‍👦 팀원 구성
|                                                                                   **김예진**                                                                                   |                    **이지은**                     |                **남윤호**                 |                      **손민규**                       |
|:--------------------------------------------------------------------------------------------------------------------------------------------------------------------------------:|:----------------------------------------------:|:--------------------------------------:|:--------------------------------------------------:|
| <a href="https://github.com/yejinaCodes"><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/hongyeollee"/></a> | <a href="https://github.com/Geun9"><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/hongyeollee"/></a> | <a href="https://github.com/nam3280"><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/hongyeollee"/></a> | <a href="https://github.com/BossMG-github"><img src="https://img.shields.io/badge/GitHub-181717?style=flat-square&logo=GitHub&logoColor=white&link=https://github.com/hongyeollee"/></a> |
<br>

## 📑 프로젝트 문서화
- [ERD Cloud](https://www.erdcloud.com/d/yHySrp5ZDa9SosWxr)
- [Notion](https://cooing-patella-cde.notion.site/1-ebdb5b149aec41f88ace75d866a63b36?pvs=4)
## 🔧 기술 스택

### 개발 언어
<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white">

### 개발 환경
<img src="https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white"><img src="https://img.shields.io/badge/Intellij-40AEF0?style=for-the-badge&logo=IntelliJ IDEA&logoColor=white">

### 이슈 관리
<img src="https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white"><img src="https://img.shields.io/badge/git-F05032?style=for-the-badge&logo=git&logoColor=white">
### 협업
<img src="https://img.shields.io/badge/notion-000000?style=for-the-badge&logo=notion&logoColor=white"><img src="https://img.shields.io/badge/discord-80247B?style=for-the-badge&logo=discord&logoColor=white"><img src="https://img.shields.io/badge/slack-4A154B?style=for-the-badge&logo=slack&logoColor=white"><img src="https://img.shields.io/badge/Google Drive-1DBF73?style=for-the-badge&logo=Google Drive&logoColor=white">
### 다이어그램
<img src="https://img.shields.io/badge/draw.io-F08705?style=for-the-badge&logo=diagrams.net&logoColor=white"><img src="https://img.shields.io/badge/ERDCloud-000000?style=for-the-badge&logo=icloud&logoColor=white">

## 📂 패키지 구조
```
└── src
     ├── common
     ├── config
     ├── controller
     ├── dao
     │     └── daoImpl
     ├── dto
     │     ├── request
     │     └── response
     ├── exception
     ├── handler
     ├── library
     ├── security
     ├── service
     │     └── serviceImpl
     └── MainApplication.java
```

## 💻 구현 기능
### 회원 관리
- 회원 가입 시 유효성 검사 및 ID, 이메일 중복 체크
- 쇼핑몰 회원 가입 시, 가입 승인 내역 테이블에 데이터 추가 트리거 생성
- 비밀번호를 SHA-256 알고리즘으로 암호화
- 회원 정보의 생성, 조회, 수정, 삭제(CRUD) 기능
- 어드민 권한에 따른 메뉴 접근 제어 설정
### 로그인 관리
- 아이디 찾기 기능
- 비밀번호 재설정 기능
### 창고 관리
- 창고 정보 조회
### 입고 관리
- 쇼핑몰 유저의 주문 요청서 작성 기능
- 공급체 유저의 입고 요청, 수정, 취소 기능
- 창고 관리자의 입고 승인, 반려 기능
- 입고 승인 후 재고 및 창고 정보 업데이트 트리거, 입고 지시서 생성 트리거
- 유저 및 관리자에 따른 입고 조건별 조회 기능
### 출고 관리
- 유저 출고 요청 기능
- 관리자 출고 관리, 배차 관리, 운송장 관리 기능
- 유저 및 관리자 출고 요청서 조회 기능
- 관리자 출고 승인 후, 배송 가능 기사 인원 확인 및 배차 등록, 배차 인원 정보 업데이트, 운송장 등록
- 배차 등록 후 출고 지시서 생성 트리거
### 재고 관리
- 창고 전체 재고 및 카테고리별 재고 조회 기능
- 창고 구역별 사용량 조회 기능
- 유저의 총 재고 수량 조회 기능
### 고객 선터
- 공지사항 생성, 조회, 수정, 삭제(CRUD) 기능
- 문의 게시글 생성, 조회, 수정, 삭제(CRUD) 기능

## 🗣️ 배운점 및 아쉬운 점
#### 민규 🔴
프로젝트에서는 MySQL과 Java를 활용하여 재고 관리의 자동화를 목표로 하였습니다. 주요 구현 기능으로는 카테고리별 재고 조회, 사용자 재고 조회, 실사 조회, 그리고 삭제 기능이 포함되었습니다. 프로젝트를 통해 데이터베이스 설계의 중요성을 다시 한 번 깨닫게 되었습니다. 이러한 경험은 향후 프로젝트의 설계와 관리에 큰 도움이 될 것입니다.
#### 윤호 🟡
프로젝트를 통해 코딩 기술뿐만 아니라 정확한 소통을 통한 협업의 중요성을 깊게 느꼈습니다. 개발 과정에서 명확한 의사소통은 팀의 효율성과 프로젝트의 성공을 좌우하는 중요한 요소라는 것을 알게 되었습니다. 앞으로도 소통의 중요성을 잊지 않고 협업에 임하겠습니다.
#### 예진 🟢
WMS(창고 관리 시스템)와 물류 시스템에 대한 기본적인 프로세스를 직접 구현할 수 있어 매우 흥미로웠습니다. 프로젝트를 통해 구체적인 설계서를 작성하고, 다양한 설계 방법을 사용하여 시스템의 기본 틀을 명확히 할 수 있었습니다. 또한, 협업 과정에서 컨벤션의 중요성을 배워, 팀워크의 효율성을 높이는 데 기여할 수 있었습니다.
#### 지은 🟣
프로젝트를 통해 팀 전체의 조율과 관리, 그리고 프로젝트의 전반적인 방향 설정을 맡게 되었습니다. 팀원들이 각자의 역할을 잘 수행할 수 있도록 지원하고, 프로젝트 일정과 목표를 효과적으로 관리하는 것이 주요 임무였습니다. 이 과정에서 팀원 간의 원활한 커뮤니케이션과 협업의 중요성을 다시 한 번 느꼈습니다. 또한, 프로젝트 관리 및 리더십 기술을 더욱 향상시킬 수 있는 기회가 되었습니다. 앞으로도 이러한 경험을 바탕으로 더 나은 팀워크와 프로젝트 관리를 위해 노력하겠습니다.
