[Newspic SDK](../README.md)

# iOS

## 요구사항

뉴스픽 SDK를 사용하기 위해서는 아래의 요구사항을 충족해야 합니다.

* XCode 15 이상
* Swift 5 이상
* Minium Deployments
* * iOS 12.0 이상

## 설치

### 1. 뉴스픽 SDK Framework를 다운받아주세요.
```bash
curl -O https://notiplus-prd-sdk-bucket.s3.ap-northeast-2.amazonaws.com/newspic-sdk-ios/1.0.3/NewspicSDK.xcframework.zip
```

### 2. NewspicSDK.xcframework를 프로젝트에 추가해주세요.

다운로드된 NewspicSDK.xcframework.zip파일의 압축을 해제합니다.<br>
압축해제된 NewspicSDK.xcframework를 프로젝트에 추가합니다.

### 3. 프로젝트에 Framework를 추가합니다.

Project > General > Frameworks, Libraries, and Embedded Content에 NewspicSDK.xcframework를 추가합니다.

## 초기화

뉴스픽SDK를 사용하기 위해서는 `AppDelegate`에서 `NewspicSDK`를 초기화해야 합니다.

```swift
import UIKit
import NewspicSDK

@main
class AppDelegate: UIResponder, UIApplicationDelegate {

    func application(_ application: UIApplication, didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
        
        //퍼블리셔 앱의 메인 컬러를 지정합니다.
        NewspicSDKs.sharedInstance().primaryColor = "FF0000"
        //사용자의 IDFA를 전달합니다.
        NewspicSDKs.sharedInstance().idfa = getIDFA()
        
        return true
    }
}
```

> **Warning**
> 광고 식별자의 획득 및 전달은 직접 구현해주셔야 합니다.<br>
> 뉴스픽은 광고 식별자 획득에 대한 책임을 지지 않습니다. 

IDFA 획득 코드 예제
```swift
func getIDFA() -> String? {
   if ASIdentifierManager.shared().isAdvertisingTrackingEnabled {
       let idfa = ASIdentifierManager.shared().advertisingIdentifier.uuidString
       return idfa
   } else {
       // 사용자가 IDFA 추적을 거부한 경우 또는 제공되지 않는 경우
       return nil
   }
}
```

## View 유형 별 가이드

### [한줄뉴스형](IOS_SWIFT_FRAMEWORK_SINGLE_LINE.md)

### [리스트](IOS_SWIFT_FRAMEWORK_LIST.md)

## 뉴스픽 SDK 화면 열기

뉴스픽 SDK는 뉴스픽 도메인에 대한 내장 ViewController로 열기를 지원합니다.<br>
내장 ViewController는 다음과 같은 상황에서 사용하실 수 있습니다.
- 하이브리드앱에서 뉴스픽API를 사용하여 직접 화면을 구성했을 때 뉴스픽 콘텐츠를 클릭하는 경우
- 푸시 등을 클릭하여 뉴스픽 콘텐츠 상세페이지로 이동하는 경우

뉴스픽 SDK 내장 ViewController는 다음과 같이 사용할 수 있습니다.
```swift
import Foundation
import UIKit
import NewspicSDK

class OpenWebViewViewController : UIViewController {
    
    @IBOutlet weak var textLink: UITextView!
    @IBOutlet weak var btnOpen: UIButton!
    
    @objc func open(_ gesture: UITapGestureRecognizer) {
        let url = textLink.text
        
        //뉴스픽 내장 ViewController를 엽니다.
        NewspicDetailViewController.launch(url, self)
    }
}
```
> **Warning**
> 파라미터로 전달되는 URL이 뉴스픽 도메인이 아닌 경우 아무 동작을 하지 않습니다.
