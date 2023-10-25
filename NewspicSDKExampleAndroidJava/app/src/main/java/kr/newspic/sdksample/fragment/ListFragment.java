package kr.newspic.sdksample.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import kr.newspic.android.sdk.NewspicSDKView;
import kr.newspic.sdksample.R;
import org.jetbrains.annotations.NotNull;

public class ListFragment extends Fragment {
    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sdk_view, container, false);
    }

    @Override
    public void onViewCreated(@NotNull View view, Bundle savedInstanceState) {
        //-- 뉴스픽SDKView를 초기화합니다.
        final NewspicSDKView newspicSDKView = view.findViewById(R.id.newspic_sdk_list_fragment);
        newspicSDKView.load();
        //--
    }
}
