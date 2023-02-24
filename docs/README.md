# 🎮 사다리 생성 게임

```
- 사다리 게임에 참여하는 사람에 이름을 최대5글자까지 부여할 수 있다. 사다리를 출력할 때 사람 이름도 같이 출력한다.
- 사람 이름은 쉼표(,)를 기준으로 구분한다.
- 사람 이름을 5자 기준으로 출력하기 때문에 사다리 폭도 넓어져야 한다.
- 사다리 타기가 정상적으로 동작하려면 라인이 겹치지 않도록 해야 한다.
    - |-----|-----| 모양과 같이 가로 라인이 겹치는 경우 어느 방향으로 이동할지 결정할 수 없다.
- 사다리 실행 결과를 출력해야 한다.
- 개인별 이름을 입력하면 개인별 결과를 출력하고, "all"을 입력하면 전체 참여자의 실행 결과를 출력한다.
```
---
## 기능 목록

- [x] 사다리 게임 참여자 이름을 입력받는다.
  - [x] 참여자의 수는 최대 10000명이다.
  - [x] 참여자 이름은 쉼표로 구분한다.
    - [x] 쉼표로 구분되지 않으면 예외 처리한다.
    - [x] 구분한 참여자 이름은 1자이상 5자이하여야한다.
    - [x] 구분한 참여자 이름은 공백일 수 없다.

- [x] 실행 결과를 입력받는다.
  - [x] 결과는 쉼표로 구분한다.
    - [x] 쉼표로 구분되지 않으면 예외 처리한다.
  - [x] "꽝" 이외의 실행 결과는 정수여야한다.
    - [x] 정수인 실행 결과는 1 이상 10000이하여야한다.
  - [x] 실행 결과의 수는 참여자의 수와 같아야한다.

- [x] 사다리의 최대 높이를 입력받는다.
  - [x] 사다리의 높이는 정수여야한다. (음수는 도메인에서 검증한다.)

- [x] 이름과 시작 위치로 참여자를 생성한다.
- [x] 실행 결과로 사다리 결과를 생성한다.

- [x] 라인을 생성한다.
  - [x] 사다리 라인이 겹치지 않아야 한다.
    - [x] 라인에 연속되는 선이 있는지 검증한다.
    - [x] true/false 랜덤 값으로 선을 생성할지 결정한다. 

- [x] 라인의 시작 위치를 받아서 선 연결 유무를 판단하여 도착 위치를 반환한다.

- [x] 생성된 라인들로 사다리를 생성한다.
  - [x] 사다리의 높이는 1 이상 1000 이하여야한다.
- [x] 사다리 시작 위치를 받아서 끝까지 이동 후 최종 위치를 반환한다.

- [x] 각 참여자별 결과를 저장 후 반환한다.
  - [x] 사다리를 이동하여 상품 인덱스를 받는다.
  - [x] 보상 인덱스로 실행 결과를 찾는다.

- [x] 사다리 결과를 출력한다.
  - [x] 사다리를 출력 시 사람 이름도 함께 출력 한다.
  - [x] 사다리 폭은 5자이다.
  - [x] 실행 결과를 출력한다.

- [x] 결과를 보고 싶은 사람을 입력받는다.
  - [x] 결과를 보고 싶은 사람이 참여자가 아니면 예외 처리한다.

- [x] 결과를 보고 싶은 사람의 실행 결과를 반환한다.
  - [x] 결과를 보고 싶은 사람이 "all"이면 모든 참여자의 실행 결과를 반환한다.  

- [x] 결과를 보고 싶은 사람의 실행 결과를 출력한다.
  - [x] 결과를 보고 싶은 사람이 "all"이면 모든 참여자의 실행 결과를 출력한다.

## 추후 고민 목록
- [ ] 참여자 이름은 중복될 수 있는가?
- [ ] 참여자의 수는 1명일 수 있는가?