[Newspic SDK](../README.md)

# Web

## 설치

웹페이지 상단 `<head>` 태그 안에 아래의 코드를 추가합니다.
```html
<script src="https://m.newspic.kr/apis/sdk.min.js"></script>
```
스크립트를 비동기로 호출하고 싶으신 경우 아래와 같이 추가합니다.
```html
<script src="https://m.newspic.kr/apis/sdk.min.js" async></script>
```

## 사용

아래의 타입 별 샘플 코드는 SDK 사용을 위한 기본적인 태그만 기재되어있습니다.<br>
사용하시는 환경에 맞게 태그를 수정하시고 사용하시길 바랍니다.

### 한줄뉴스형

> **Note**
> 한줄뉴스형의 영역은 반드시 32px 높이를 가져야 합니다.<br>
> `<div>` 태그의 id 속성과 스크립트의 elementId 속성은 동일한 값을 가져야 합니다.<br>
> 스크립트 내 `unitId`값은 전달받은 UNIT ID로 교체해주시길 바랍니다.

```html
<html lang="kr">
<head>
    <title>Newspic SDK - Javascript</title>
    <script src="https://m.newspic.kr/apis/sdk.min.js" async></script>
</head>
<body>
<!-- //Newspic SDK Tag -->
<div id="newspic-sdk-single-line" style="width: 100%;height:32px;">
    <script>
        (_newspicsdk = window._newspicsdk || []).push({
            elementId: 'newspic-sdk-single-line',
            type:'SINGLE_LINE',
            unitId:'demo',
        })
    </script>
</div>
<!-- //Newspic SDK Tag -->
</body>
```

### 리스트형

> **Note**
> 리스트형 영역의 너비(width)와 높이(height)는 페이지에 맞추어 변경하시면됩니다.<br>
> `<div>` 태그의 id 속성과 스크립트의 elementId 속성은 동일한 값을 가져야 합니다.<br>
> 스크립트 내 `unitId`값은 전달받은 UNIT ID로 교체해주시길 바랍니다.

```html
<html lang="kr">
<head>
    <title>Newspic SDK - Javascript</title>
    <script src="https://m.newspic.kr/apis/sdk.min.js" async></script>
</head>
<body>
<!-- //Newspic SDK Tag -->
<div id="newspic-sdk-list" style="width: 100%;height:100%;">
    <script>
        (_newspicsdk = window._newspicsdk || []).push({
            elementId: 'newspic-sdk-list',
            type:'LIST',
            unitId:'demo',
        })
    </script>
</div>
<!-- //Newspic SDK Tag -->
</body>
```

## WebView 대응

스크립트를 호출하여 추가된 영역에서 콘텐츠를 클릭하는 경우 아래의 Javascript 코드가 실행됩니다.
```javascript
var link = '{{뉴스픽 콘텐츠 URL}}';
try{
    window.NewspicSDKBridge.postMessage(link);
}
catch (e) {
    try{
        window.webkit.messageHandlers.NewspicSDKBridge.postMessage(link);
    }
    catch (e) {
        top.location = link;
    }
}
```

위 코드에서 사용하는 WebView Javascript Interface는 아래와 같이 구현합니다.<br>
Javascript Interface 구현에 앞서 각 플랫폼 별 SDK 설치 가이드를 참고하여 라이브러리를 추가합니다.
- [Android](./ANDROID_JAVA.md)
- [iOS/Framework](./IOS_SWIFT_FRAMEWORK.md)

### Android
```kotlin
//Javascript Interface 구현
class NewspicSDKBridge(private val context: Context) {
    @JavascriptInterface
    fun postMessage(url: String) {
        NewspicSDK.openNewspicActivity(context,url)
    }
}

//WebView에 Javascript Interface 추가
webView.addJavascriptInterface(NewspicSDKBridge(this), "NewspicSDKBridge")
```

### iOS
```swift
//Javascript Interface 구현
extension WebViewController: WKScriptMessageHandler {
    func userContentController(
        _ userContentController: WKUserContentController,
        didReceive message: WKScriptMessage
    ) {
        if message.name == "NewspicSDKBridge" {
            NewspicDetailViewController.launch(message.body as? String, self)
        }
    }
}

//WebView에 Javascript Interface 추가
let userContentController = WKUserContentController()
userContentController.add(self, name: "NewspicSDKBridge")
let config = WKWebViewConfiguration()
config.userContentController = userContentController
webView = WKWebView(frame: CGRect.zero, configuration: config)
```
