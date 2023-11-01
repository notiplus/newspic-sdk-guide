package kr.newspic.sdksample.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import kr.newspic.android.sdk.NewspicSDK;
import kr.newspic.android.sdk.NewspicSDKView;
import kr.newspic.sdksample.R;

public class OpenNewspicActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_newspic);

        Button btnOpenNewspic = findViewById(R.id.btn_open_newspic);
        btnOpenNewspic.setOnClickListener(view -> {
            TextView txtUrl = findViewById(R.id.txt_url);
            String url = txtUrl.getText().toString();
            NewspicSDK.openNewspicActivity(this, url);
        });
    }
}
