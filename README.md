# Java_PlayGround
자바 플레이그라운드 with TDD, 클린코드

## 진행 방식
1. 요구사항을 보고 자신의 방식으로 구현합니다.
2. 코드리뷰를 서로 진행합니다.
3. 코드리뷰를 바탕으로 리펙터링을 진행합니다.
3. 해설 강의를 듣습니다.
4. 다시 요구사항을 보고 자신의 방식으로 구현합니다.
5. 각자 구현하면서 느낀 점 공유

## Branch 및 commit 관리
1. 프로젝트를 자신의 계정으로 fork함
2. fork한 저장소를 자신의 컴퓨터로 clone한 후 해당 폴더로 이동
3. 중앙 저장소를 upstream으로 추가함
4. 미션 진행을 위해 자신의 아이디로 브랜치 생성함
5. 기능 구현을 함
6. 기능 구현 후 add, commit을 함, commit 메시지는 작업한 내용에 대해서 적음(미션 참조)
7. 그 다음 본인 원격 저장소에 push를 함
8. 그리고 main 브랜치로 Pull Request를 요청, 이 때 Reviewer를 설정하여 코드 리뷰를 서로 진행함
9. 코드 리뷰가 완료된 후 main 브랜치로 merge를 함
10. 피드백을 듣고 피드백 반영 후, 다시 위와 같은 방식을 거쳐서 다시 진행을 함

## 깃 commit 메시지 컨벤션
AngularJS의 commit 메시지 컨벤션을 사용하며 종류는 아래와 같이 구분합니다.
```
feat (feature)
fix (bug fix)
docs (documentation)
style (formatting, missing semi colons, …)
refactor
test (when adding missing tests)
chore (maintain)
```
