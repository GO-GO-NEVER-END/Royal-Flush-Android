# build-logic Module
## 구성

### Gradle Files
- settings.gradle.kts
    - 모듈 세팅, 버전 카탈로그 사용 설정

- build.gradle.kts
    - build-logic 모듈이 사용할 자바 버전 설정
    - 사용할 플러그인 설정
    - 새로 만들 플러그인 이름 설정

### Custom Plugin Files
- Android**Application**ConventionPlugin
  - Application Module 설정을 작성하는 Plugin
  - Default Configuration 설정
  - Build, Debug, Release 타입 별 내용 설정
- Android**Library**ConventionPlugin
  - 모든 Android Module에 사용할 설정을 작성하는 Plugin
  - Basic Android, Kotlin Library 설정
- Android**Hilt**ConventionPlugin
  - Hilt Library 사용을 위한 Plugin
- Android**Feature**ConventionPlugin
  - Feature Module에서 사용할 설정을 작성하는 Plugin
- Android**Data**ConventionPlugin
  - Data Module에서 사용할 설정을 작성하는 Plugin
- Kotlin**Domain**ConventionPlugin
  - Domain Module에서 사용할 설정을 작성하는 Plugin

### Utility Files
- DependencyHandlerExt.kt
  - Dependency 설정 시 원래 gradle에서 사용하던 형태로 변환하는 DependencyHandler 클래스 확장함수
- KotlinAndroid.kt
  - Kotlin Configure 설정도 다른 설정과 형태를 동일하게 만들어주는 확장함수
  - Kotlin Options 설정도 다른 설정과 형태를 동일하게 만들어주는 확장함수
- ProjectConfigurations.kt
  - Project에서 사용할 Configuration을 선언한 파일
- ProjectExt.kt
  - VersionCatalog 사용을 위한 확장함수

## 라이브러리 추가하는 방법
1. toml 파일에 라이브러리를 먼저 추가한다.
2. 수정이 필요한 Plugin 파일 내부에 있는 dependencies 블럭을 찾는다.
3. gradle에서 추가하던 것처럼 추가하면 된다.
   - test와 androidTest는 모듈별로 각자 추가하도록 한다. 
   - (굳이 빌드 시점에 사용할 이유가 없다.)