package com.github.flickr.base;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;

import com.github.flickr.App;
import com.github.flickr.BaseAppComponent;

public class BaseFragment extends Fragment {

    public @NonNull
    BaseAppComponent getBaseComponent() {
        //noinspection ConstantConditions
        return ((App) getActivity().getApplication()).getBaseComponent();
    }
}
