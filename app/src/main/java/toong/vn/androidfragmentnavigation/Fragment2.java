package toong.vn.androidfragmentnavigation;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class Fragment2 extends android.support.v4.app.Fragment {
    private static final String TAG = "TAG_FRAGMENT";

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
            @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_2, null, false);
        Log.i(TAG, "onCreateView");

        rootView.findViewById(R.id.button_pop).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getFragmentManager().popBackStack();
            }
        });

        rootView.findViewById(R.id.button_go_to_fragment_3)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // TODO: 29/11/2017 can use goToFragment3UsingGetFragmentManager or goToFragment3UsingGetChildFragmentManager
//                        goToFragment3UsingGetFragmentManager();
                        goToFragment3UsingGetChildFragmentManager();
                    }
                });

        rootView.findViewById(R.id.button_fragment2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), "Click at button at fragment 222", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    private void goToFragment3UsingGetFragmentManager() {
        getFragmentManager().beginTransaction()
                .replace(R.id.frame, new Fragment3())
                .addToBackStack("")
                .commit();
    }

    private void goToFragment3UsingGetChildFragmentManager() {
        getChildFragmentManager().beginTransaction()
                .replace(R.id.frame_fragment_2, new Fragment3())
                .addToBackStack("")
                .commit();
    }
}