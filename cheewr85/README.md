- 숫자 입력 로직
    - 3자리 수를 입력하는 부분
- 숫자 출력 로직
    - 입력한 숫자를 바탕으로 스트라이크, 볼, 결과를 출력하는 부분
- 임의의 랜덤 수 선택하는 로직
    - 숫자 야구를 위해 임의의 랜덤 수를 선택하여 진행하는 로직
    - 첫 번째 자리의 0이 들어오는 경우 체크하는 로직
    - 중복된 숫자가 들어가 있는지 체크하는 로직
- 숫자야구 로직
    - 입력 로직에서 받은 값, 임의의 랜덤수를 선택한 값을 비교해서 몇 볼 몇 스트라이크인지 확인하는 부분

------

### 피드백 반영
- 숫자 입력 로직
    - 사용자에게 3개의 숫자를 입력받음
        - 해당 숫자 유효값 검증
        - 1 ~ 9의 숫자인지, 중복값이 있는지, 3자리인지
- 숫자 야구 로직
    - 위치와 숫자가 같은 경우는 스트라이크
    - 위치는 다른데 숫자 값이 같은 경우는 볼
    - 숫자 값이 다른 경우 낫싱
    - 임의로 숫자가 만들어진 상태에서 사용자가 숫자를 입력했을 때 해당 경우의 수를 판단하는지
- 숫자 출력 로직
    - 숫자 야구 로직에서 볼, 스트라이크, 낫싱 판단 이후 어떤 상황인지 확인한 뒤 판단, 그리고 출력함
- 임의의 랜덤수 선택하는 로직
    - 숫자 야구의 조건대로 랜덤수가 생성되는지 확인 및 검증
- 숫자 야구 테스트
    - 만든 클래스 바탕으로 실제 숫자 야구 진행