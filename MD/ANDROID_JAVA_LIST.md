[Newspic SDK](../README.md) > [Android Java](ANDROID_JAVA.md)

# 리스트

콘텐츠를 리스트형으로 보여주는 뉴스픽 SDK View입니다.
뉴스픽SDK View는 레이아웃에 View를 추가하는 방식과 코드로 View를 추가하는 방식의 두가지를 모두 지원합니다.

## 1. Layout.xml에 View를 추가

리스트 형태의 View를 레이아웃 XML 파일을 사용하여 추가하는 경우 아래와 같이 레이아웃 파일에 내용을 추가하여 사용할 수 있습니다.

```xml
<kr.newspic.android.sdk.NewspicSDKView
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/sample_newspic_sdk_view"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:newspicSDKUnitId="{{unitId}}"
        app:newspicSDKViewType="LIST"
>
</kr.newspic.android.sdk.NewspicSDKView>
```
예시) [Layout.xml](../NewspicSDKExampleAndroidJava/app/src/main/res/layout/activity_list.xml#L9-L15)

`{{unitId}}`는 뉴스픽 SDK를 사용하기 위해 발급받은 UNIT ID를 입력해주시면 됩니다.

## 2. 뉴스픽 SDK View 초기화

레이아웃에서 View를 추가한 후 Activity를 초기화하는 시점에 아래와 같이 뉴스픽 SDK를 로드해주세요.

```java
public class ListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //-- 뉴스픽SDKView를 초기화합니다.
        NewspicSDKView newspicSDKView = findViewById(R.id.newspic_sdk_view);
        newspicSDKView.load();
        //--
    }
}
```

예시) [ListActivity.java](../NewspicSDKExampleAndroidJava/app/src/main/java/kr/newspic/sdksample/activity/ListActivity.java#L15-L16)
