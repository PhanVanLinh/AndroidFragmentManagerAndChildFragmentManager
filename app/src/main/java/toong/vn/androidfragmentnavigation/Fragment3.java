package toong.vn.androidfragmentnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment3 extends android.support.v4.app.Fragment {
    private static final String TAG = "TAG_FRAGMENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_3, null, false);

        rootView.findViewById(R.id.button_pop_without_animation)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getFragmentManager().popBackStack();
                    }
                });

        rootView.findViewById(R.id.button_go_to_fragment_4)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO: 29/11/2017 can use goToFragment3UsingGetFragmentManager or goToFragment3UsingGetChildFragmentManager
                        goToFragment4UsingGetChildFragmentManager();
                    }
                });

        rootView.findViewById(R.id.button_fragment3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Click at button at fragment 333", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void goToFragment4UsingGetFragmentManager() {
        getFragmentManager().beginTransaction()
                .replace(R.id.frame, new Fragment3())
                .addToBackStack("")
                .commit();
    }

    private void goToFragment4UsingGetChildFragmentManager() {
        getParentFragment().getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_fragment_2, new Fragment4())
                .addToBackStack("")
                .commit();
    }
}