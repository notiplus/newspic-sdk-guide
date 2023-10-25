package kr.newspic.sdksample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import kr.newspic.android.sdk.NewspicSDKView;
import kr.newspic.sdksample.activity.ListActivity;
import kr.newspic.sdksample.activity.ListViewPagerActivity;
import kr.newspic.sdksample.activity.SingleLineActivity;
import kr.newspic.sdksample.databinding.ActivityMainBinding;

import java.util.function.Consumer;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        onClickStartActivity(R.id.btn_single_line, SingleLineActivity.class);

        onClickStartActivity(R.id.btn_list, ListActivity.class);

        onClickStartActivity(R.id.btn_list_viewpager, ListViewPagerActivity.class);

    }

    private void onClickStartActivity(int id, Class<? extends AppCompatActivity> cls){
        View view = findViewById(id);
        view.setOnClickListener(view1 -> startActivity(new Intent(this,cls)));
    }

}
