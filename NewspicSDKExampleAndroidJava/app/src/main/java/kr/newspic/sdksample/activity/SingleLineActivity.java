package kr.newspic.sdksample.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import kr.newspic.android.sdk.NewspicSDKView;
import kr.newspic.sdksample.R;

public class SingleLineActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_line);

        //-- 뉴스픽SDKView를 초기화합니다.
        final NewspicSDKView newspicSDKView = findViewById(R.id.newspic_sdk_single_line);
        newspicSDKView.load();
        //--
    }
}
