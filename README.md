# android-mail-10 (한창희)

### 메일 앱 프로젝트
- 카테고리 별 메일 조회 및 사용자 정보 조회 기능
---
<br>

### 화면 구성

<img src="https://user-images.githubusercontent.com/69443895/177837353-0c3a0da8-5f6b-41fb-9146-23d1404980a4.jpg" width="500" height="600"/>

- Login (InformationActivity)
- Home (MainActivity)
  - Mail (MailFragment)
    - Primary (PrimaryFragment)
    - Social (SocialFragment)
    - Promotions (PromotionsFragment)
  - Setting (SettingFragment)

---
<br>

### 주요 사항

- Material Design
  - Bottom navigiaon, Navigation rail, Navigation drawer 를 사용해 화면 구성
<br>

- 태블릿 화면 대응
  - 태블릿 가로/세로 방향에 따른 화면 구성의 차이가 있어 land, port 두 레이아웃 디렉토리로 구성
  
<img width="185" alt="스크린샷 2022-07-08 오후 8 43 56" src="https://user-images.githubusercontent.com/69443895/177985891-49f23742-841d-49af-9f30-af3fb43a6a17.png">

<br>

- 프래그먼트 이동 및 뒤로가기 버튼 처리(navigation 사용 x)
  - 프래그먼트 이동 시 백스택에 추가
  - 뒤로가기 버튼 누를 시 프래그먼트 백스택의 개수를 통해 앱이 종료되지 않고 시작 프래그먼트로 돌아올 수 있게 구현
 
프래그먼트안에 프래그먼트가 들어가는 경우 뒤로가기 처리가 까다로웠는데, 더 학습을 해야할 것 같다

<br>

- 화면 회전 시 Bottiom navigation, Navigation Rail에서 현재 선택되어 있는 프래그먼트 그대로 보여주기
  - 현재 프래그먼트가 어떤 프래그먼트인지 판단할 수 있게 enum class 선언
  - 뷰모델에 현재 프래먼트 타입을 저장해두고 화면 회전 시 해당 프래그먼트가 그대로 보이도록 구현
  
  
---
<br>

### 구현 화면

<img width="313" alt="스크린샷 2022-07-08 오후 9 02 42" src="https://user-images.githubusercontent.com/69443895/177988937-2afa2b7f-a3ff-484f-9bcc-7d6a18dc7d81.png"> <img width="313" alt="스크린샷 2022-07-08 오후 9 03 29" src="https://user-images.githubusercontent.com/69443895/177989013-36fe9adb-6ad4-473c-864a-c449efbce3ea.png">

<img width="313" alt="스크린샷 2022-07-08 오후 9 03 47" src="https://user-images.githubusercontent.com/69443895/177989056-baa9ae77-c885-4757-b67f-e125a8f9182e.png"> <img width="313" alt="스크린샷 2022-07-08 오후 9 03 56" src="https://user-images.githubusercontent.com/69443895/177989080-12a0c38f-2a26-4a27-8515-d3e09de3a99d.png">

<img width="313" alt="스크린샷 2022-07-08 오후 9 04 05" src="https://user-images.githubusercontent.com/69443895/177989192-16042154-4d30-412c-a0fb-7ce0c0bf92f5.png">

#### 태블릿 화면 

<img width="710" alt="스크린샷 2022-07-08 오후 9 04 59" src="https://user-images.githubusercontent.com/69443895/177989224-a08d732d-6d99-4e07-83cb-c4842e16bb4b.png">

<img width="710" alt="스크린샷 2022-07-08 오후 9 05 14" src="https://user-images.githubusercontent.com/69443895/177989251-e01ebbac-3826-4360-af55-cb92f4cc143c.png">

<img width="442" alt="스크린샷 2022-07-08 오후 9 05 36" src="https://user-images.githubusercontent.com/69443895/177989276-73d7c074-dcea-4f44-8534-ffbd98d1e293.png">

---
<br>

### 문서
- https://github.com/woowa-techcamp-2022/android-mail-10/wiki
