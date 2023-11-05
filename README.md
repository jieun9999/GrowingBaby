# GrowingBaby

## 작품소개
당신에게 아이가 생겼습니다. 👶🏻  
슈퍼베이비, 스마트베이비, 관종베이비, 싸이코패스베이비 중 랜덤으로 낳게 됩니다.  
돈을 벌고, 필수템을 구매하고, 아이를 돌보세요.  
아이의 애정, 건강, 지식 포인트를 충족하여 LV 0 ~LV 3까지 달성하면 게임은 종료됩니다.  

## 기획/설계
![스크린샷_2023-10-01_오후_1 15 31](https://github.com/jieun9999/GrowingBaby/assets/112951633/f1822a0b-26a8-4274-ba58-fa2b86ee5452)


## 주요기능  

### 1. 성장

https://tv.kakao.com/v/441401728

- 성장맵에 들어오면, 배경음악이 재생됩니다 (스레드)
- 필수템을 보유하면, 돌봄 메소드를 사용할수 있습니다
- 돌봄 메소드를 사용하여 아이의  애정, 건강, 지식 포인트를 획득합니다

![스크린샷_2023-09-01_오후_4 30 39](https://github.com/jieun9999/GrowingBaby/assets/112951633/eb648444-2d16-4937-b77f-0ec2d7d539ac)

- 다음과 같은 상속구조를 따르면서 각 베이비는 공통적이면서도 개별적인 돌봄메소드를 모두 소유하고 있습니다
- 보상 포인트가 높은 돌봄메소드의 경우에는 상점에서 비싼 아이템을 구매해야 합니다 (난이도 조절)
- 레벨별로 주어진 조건(애정, 건강, 지식)을 충족해야 다음 레벨로 올라갑니다

### 2. 돈벌기

- 돈을 버는 방법에는 1. 기본 돈벌기 2. 코딩하기 3.투자하기 4.도박하기 5. 일꾼 고용하기 총 5가지가 있습니다
- 기본 돈벌기 : 가만히 있어도 1초에 100원씩 번다 (스레드 사용)
- 일꾼 고용하기: 1초에 200원씩 1시간동안 번다, 단, 먼저 -5만원 지불 (스레드 사용)
- 코딩하기: 1클릭시, 1000원씩 번다
- 투자하기: 가진돈의 (30% or 60% or 100%)를 투자할 수 있고, 1클릭에 승률 50% 로 수익률 +- 30%
- 도박하기: 가진돈의 (30% or 60% or 100%)를 도박할 수 있고, 1클릭에 승률 30% 로 수익률 +- 50%

### 3. 상점

- 상점에서는 메소드를 실행하는데 필요한 아이템을 구매할 수 있습니다
- 가격이 비쌀수록 높은 포인트를 주는 메소드를 사용할 수 있습니다

  
### 4. 약국

- 아이의 애정, 건강, 지식 중 한 영역을 급격하게 높이고 싶을때, 물약을 먹입니다
- 애정폭탄 물약, 건강폭탄 물약 , 지식폭탄 물약을 구매할 수 있습니다
- 물약을 구매하면, 바로 마십니다

​
### 5. 인벤토리

- 아이가 가지고 있는 아이템을 확인할 수 있습니다
- 메소드를 사용하면 1개씩 아이템이 소진됩니다


### 6. 아기 놀아주기

- 각각 3,5초 간격으로 아이가 울거나 오줌을 쌉니다 (스레드)
- 이때 아이에게 '울음뚝', '바지 갈아입히기'를 입력하면 멈춥니다
- 아이 울음소리가 배경음악으로 재생됩니다 (스레드)


### ​7. 아웃트로
- 게임종료 시 3초간 효과음이 재생됩니다 (스레드)


## 소감

처음에 상속개념을 잘못 이해하여, 프로젝트를 뒤집고 새로 시작했습니다.
제 문제점은 코드를 마음대로 확장한다는 것이었습니다. 생각없이 개발만 해나가는 것이 아니라 각 기능을 검증하면서 차례대로 확장해야 겠다는 것을 깨달았습니다. 
앞으로도 특정 기술을 그냥 쓰는 것이 아니라, 프로젝트 기획에 적합한지 or 이 기술을 쓰면 무엇이 더 좋아지는 지 고민하면서 만들겠습니다.
팀장님이 하신 말씀이 정말 도움이 많이 되었습니다. 처음에는 직설적인 피드백에 마음이 조금 아프기도 했지만(ㅠ) 다 잘되라고 해주시는 말씀이니 잘 수용하고 고치도록 하겠습니다.
 감사합니다 🥳
