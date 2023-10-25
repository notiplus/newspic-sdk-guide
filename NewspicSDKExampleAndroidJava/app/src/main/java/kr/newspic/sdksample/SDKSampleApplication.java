package kr.newspic.sdksample;

import android.app.Application;
import kr.newspic.android.sdk.NewspicSDK;
import kr.newspic.android.sdk.NewspicSDKOption;

public class SDKSampleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        //뉴스픽SDK 옵션을 생성합니다.
        NewspicSDKOption option = new NewspicSDKOption(this);
        //앱의 메인 컬러에 맞추어 View를 보여주기 위하여 아래와 같이 primaryColor를 설정해주세요.
        option.setPrimaryColor("#FF0000");
        //마케팅 정보 수집 동의를 받지 않는 경우 아래와 같이 설정해주세요.
        option.setGaidPolicyAgreed(false);
        //뉴스픽SDK를 초기화합니다.
        NewspicSDK.initialize(option);
    }
}
