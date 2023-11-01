[Newspic SDK](../README.md) > [iOS Swift](IOS_SWIFT_FRAMEWORK_SINGLE_LINE.md)

# 리스트

콘텐츠를 리스트로 보여주는 뉴스픽 SDK View입니다.<br>
뉴스픽SDK View는 스토리보드와 코드를 사용하여 추가할 수 있습니다.

## 1. 스토리보드로 추가하기

### 1.1. NewspicSDKView 추가하기

스토리보드에 UIView를 추가합니다

UIView의 CustomClass의 속성을 다음과 같이 설정합니다.
- Class : NewspicSDKView
- Module : NewspicSDK

View의 Width,Height는 추가하고자 하는 화면에 맞추어 적절히 설정합니다.

아래의 코드를 참고하여 ViewController의 viewDidLoad()에서 NewspicSDKView를 초기화합니다.

```swift
import Foundation
import UIKit
import NewspicSDK

class ViewController: UIViewController {
    @IBOutlet weak var newspicView: NewspicSDKView!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        //NewspicSDKView의 타입을 지정합니다.
        newspicView.type = .LIST
        //전달받은 unitId를 설정합니다.
        newspicView.unitId = "demo"
        //NewspicSDKView를 로드합니다.
        newspicView.load()
    }
}
```

## 2. 코드로 추가하기

NewspicSDKView를 코드로 추가하시는 경우 아래의 코드를 참고하여 NewspicSDKView를 초기화합니다.

```swift
import Foundation
import UIKit
import NewspicSDK

class CodeAppendViewController : UIViewController {

    override func viewDidLoad() {
        super.viewDidLoad()
        
        //NewspicSDKView를 생성하고 적절한 크기를 설정합니다.
        let newspicView = NewspicSDKView(frame: CGRect(x: 16, y: 400, width: view.bounds.width-32, height: 32))
        //NewspicSDKView의 타입을 지정합니다.
        newspicView.type = .LIST
        //전달받은 unitId를 설정합니다.
        newspicView.unitId = "demo"
        //NewspicSDKView를 화면에 추가합니다.
        view.addSubview(newspicView)
        //NewspicSDKView를 로드합니다.
        newspicView.load()
    }
}
```
