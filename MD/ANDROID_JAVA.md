[Newspic SDK](../README.md)

# Android

## 요구사항

뉴스픽 SDK를 사용하기 위해서는 아래의 요구사항을 충족해야 합니다.

### Android

* minSdk 24 이상
* targetSdk 33 이상
* compileSdk 33 이상
* Gradle 7.0.2 이상
* Java 11 이상

## 설치

### Android

#### 1. 뉴스픽 SDK Repository를 추가해주세요.
```groovy
repositories {
    maven {
        url "https://notiplus-prd-sdk-bucket.s3.ap-northeast-2.amazonaws.com/newspic-sdk-android"
    }
}
```
예시) [settings.gradle](../NewspicSDKExampleAndroidJava/settings.gradle#L16-L18)

#### 2. 뉴스픽 SDK Dependency를 추가해주세요.
```groovy
dependencies {
    implementation "kr.newspic.android:sdk:1.0.2"
}
```

예시) [build.gradle](../NewspicSDKExampleAndroidJava/app/build.gradle#L57)

#### 3. 구글 광고식별자 Dependency를 추가해주세요.

```groovy
dependencies {
    implementation 'com.google.android.gms:play-services-ads-identifier:17.1.0'
}
```

예시) [build.gradle](../NewspicSDKExampleAndroidJava/app/build.gradle#L58)

> **Note**
> 광고 식별자 관련 의존성을 추가하지 않아도 SDK의 기본적인 동장에는 영향을 주지 않습니다.

## 초기화

뉴스픽 SDK에서 제공하는 View를 사용하기 위해서는 먼저 뉴스픽 SDK를 초기화해야 합니다.<br>
앱이 초기화되는 시점에 아래와 같이 뉴스픽 SDK를 초기화해주세요.

```java
public class SampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //뉴스픽SDK 옵션을 생성합니다.
        NewspicSDKOption option = new NewspicSDKOption(this);
        //앱의 메인 컬러에 맞추어 View를 보여주기 위하여 아래와 같이 primaryColor를 설정해주세요.
        option.setPrimaryColor = "#FF0000";
        //마케팅 정보 수집 동의를 받지 않는 경우 아래와 같이 설정해주세요.
        option.setGaidPolicyAgreed = false;
        //뉴스픽SDK를 초기화합니다.
        NewspicSDK.initialize(option);
    }
}
```

예시) [SDKSampleApplication.java](../NewspicSDKExampleAndroidJava/app/src/main/java/kr/newspic/sdksample/SDKSampleApplication.java#L12-L19)

## View 유형 별 가이드

### [한줄뉴스형](ANDROID_JAVA_SINGLE_LINE.md)

### [리스트](ANDROID_JAVA_LIST.md)


## Fragment 지원

위의 View 유형 별 가이드는 Activity에 추가된 View를 기준으로 설명합니다.<br>
Fragment에 추가된 View의 경우 Fragment가 생성된 후 초기화를 해주시면 됩니다.
```java
public class ListFragment extends Fragment {
    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        //-- 뉴스픽SDKView를 초기화합니다.
        final NewspicSDKView newspicSDKView = view.findViewById(R.id.newspic_sdk_list_fragment);
        newspicSDKView.load();
        //--
    }
}
```


## View 수동 추가
코드를 사용하여 화면을 직접 구성하는 경우 아래와 같이 뉴스픽 SDK View를 생성하고 초기화 하여 사용할 수 있습니다.
아직 공식적으로 지원하지 않는 ReactNative, Flutter 등의 환경에서 뉴스픽SDK를 사용하는 경우 아래의 예제를 참고하시어 직접 View를 구성하실 수 있습니다.

```java
public class CodeAppendActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //-- 뉴스픽SDKView를 생성합니다.
        NewspicSDKView newspicSDKView = new NewspicSDKView(this);
        //-- 뉴스픽SDKView의 UnitId를 설정합니다.
        newspicSDKView.setUnitId("{{unitId}}");
        //-- 뉴스픽SDKView의 ViewType을 설정합니다.
        newspicSDKView.setViewType(NewspicSDKViewType.SIGLE_LINE);
        //-- 뉴스픽SDK를 부모 View에 추가합니다.
        LinearLayout layout = findViewById(R.id.parent_view);
        layout.addView(newspicSDKView);
        //-- 뉴스픽SDKView를 초기화합니다.
        newspicSDKView.load();
        //--
    }
}
```
