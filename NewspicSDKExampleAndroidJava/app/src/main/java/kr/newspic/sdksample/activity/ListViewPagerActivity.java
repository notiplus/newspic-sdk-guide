package kr.newspic.sdksample.activity;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import kr.newspic.android.sdk.NewspicSDKView;
import kr.newspic.sdksample.R;
import kr.newspic.sdksample.fragment.ListFragment;
import kr.newspic.sdksample.fragment.SimpleFragment;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ListViewPagerActivity extends AppCompatActivity {
    private ViewPager2 viewPager2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_viewpager);

        viewPager2 = findViewById(R.id.view_pager);
        viewPager2.setAdapter(new SimpleFragmentPagerAdapter(this));
//        viewPager2.setOffscreenPageLimit(1);
    }

    @Override
    public void onBackPressed() {
        if(viewPager2 != null && viewPager2.getCurrentItem() != 0){
            viewPager2.setCurrentItem(0,true);
        }
        else {
            super.onBackPressed();
        }
    }

    public static class SimpleFragmentPagerAdapter extends FragmentStateAdapter {
        private final List<Fragment> fragmentList = new ArrayList<Fragment>(){{
            add(new SimpleFragment());
            add(new ListFragment());
            add(new SimpleFragment());
            add(new SimpleFragment());
        }};

        public SimpleFragmentPagerAdapter(@NonNull @NotNull FragmentActivity fragmentActivity) {
            super(fragmentActivity);
        }

        @NonNull
        @NotNull
        @Override
        public Fragment createFragment(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getItemCount() {
            return fragmentList.size();
        }
    }
}
