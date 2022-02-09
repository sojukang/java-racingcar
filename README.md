# java-racingcar

자동차 경주 미션 저장소

## 우아한테크코스 코드리뷰

- [온라인 코드 리뷰 과정](https://github.com/woowacourse/woowacourse-docs/blob/master/maincourse/README.md)

# 기능 요구사항
## Model
- 자동차
  - entity로 활용
  - 이름, 진행 정도 필드 가짐
- 랜덤 수 
  - 0~9 까지의 random int 

## Controller
- 자동차 controller
  - 자동차 객체 Collection 관리
  - 자동차 이름 검증 기능(5자 이하) 
  - 게임 진행 기능
    - 랜덤 수 4 이상 전진, 3 이하 무시
  - 우승자 반환 기능

## View 
- 사용자 입력
  - 자동차 이름 쉼표 기준 입력
  - 시도할 회수 입력
- 출력 
  - 각 게임마다 실행결과 출력 
  - 마지막 게임 이후 우승자 출력 
