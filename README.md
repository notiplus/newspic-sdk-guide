# Newspic SDK

## 개요

뉴스픽 SDK를 사용하는 방법에 대한 가이드와 샘플 프로젝트를 제공합니다.

## 지원 현황 & 가이드

| Platform |    Language     |  Supported  |                 Guide Link                 |
|:--------:|:---------------:|:-----------:|:------------------------------------------:|
| Android  |   Java/Kotlin   |      O      |       [Android](MD/ANDROID_JAVA.md)        |
|   iOS    | Swift/Framework |      O      | [iOS/Framework](MD/IOS_SWIFT_FRAMEWORK.md) |
|   Web    |   Javascript    |      O      |              [Web](MD/WEB.md)              |


## 디자인 가이드

뉴스픽 SDK를 적용하실 떄 아래의 디자인가이드를 참고하여 사용해부시길 부탁드립니다.

### [디자인 가이드](MD/Newspic_SDK_Design_Guide.pdf)

## 사전 준비

### UNIT ID 발급 (필수)

뉴스픽 SDK를 사용하기 위해서는 UNIT ID가 필요합니다.<br>
UNIT ID는 뉴스픽 제휴를 통해 발급받을 수 있습니다.<br>
아래의 플랫폼&언어 별 가이드에는 테스트용 UNIT ID가 포함되어 있으므로 실제 개발시에 전달받으신 UNIT ID로 교체해주시길 바랍니다.

### 마케팅 정보 수집 동의 및 라이브러리 추가 (선택)

뉴스픽 SDK에서는 최적화된 광고를 제공하기 위하여 사용자의 마케팅 정보를 수집합니다.<br>
마케팅 정보 수집 및 제공에 대한 내용을 앱 사용자에게 미리 고지하고 동의를 받아야 합니다.<br>
마케팅 정보 수집을 위한 **개발 가이드는 각 플랫폼 별 연동 가이드를 참고**해주시길 부탁드립니다.

참고하실 수 있는 마케팅 정보 수집 및 제공에 서비스 이용 약관 샘플은 아래와 같습니다.

[마케팅 정보 수집 동의 약관 예시](MD/AGREEMENT.md)

## 릴리즈 노트

| Version |    Platform    | Release Date | Changes                                   |
|:-------:|:--------------:|:------------:|:------------------------------------------|
|  1.0.4  |    Android     |  2023-12-18  | onDetachedFromWindow 관련 오류 수정             |
|  1.0.3  | Android<br>iOS |  2023-11-09  | iOS 지원<br>뉴스픽Activity/ViewController열기 지원 |
|  1.0.2  |    Android     |  2023-11-09  | 일부 클래스 난독화 제외                             |
|  1.0.1  |    Android     |  2023-11-02  | Proguard rule 충돌 현상 수정                    |
|  1.0.0  |    Android     |  2023-10-26  | 최초 릴리즈                                    |

> **Note**
> Javascript SDK는 항상 최신버전을 사용하므로 별도의 릴리즈노트를 제공하지 않습니다. 
