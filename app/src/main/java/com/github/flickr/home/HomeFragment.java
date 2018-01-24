package com.github.flickr.home;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import com.github.flickr.BaseAppComponent;
import com.github.flickr.R;
import com.github.flickr.base.BaseFragment;
import com.github.flickr.home.adapter.PhotoFeedAdapter;
import com.github.flickr.home.data.PhotoFeedDomain;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class HomeFragment extends BaseFragment implements HomeFragmentContract.View {

    @NonNull
    Injector INJECTOR = new Injector();

    @BindView(R.id.photos)
    RecyclerView photos;
    @BindView(R.id.progress)
    ProgressBar progress;
    @Inject
    PhotoFeedAdapter adapter;

    @Inject
    HomeFragmentContract.Presenter presenter;


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        ButterKnife.bind(this, view);

        INJECTOR.createHomeComponent(getBaseComponent(), this)
                .inject(this);

        photos.setAdapter(adapter);
        photos.addItemDecoration(createElevatedItemDecoration());

        presenter.init();

        return view;

    }

    @Override
    public void bindData(List<PhotoFeedDomain.EntryDomain> entries) {
        adapter.bindData(entries);
    }

    @Override
    public void showProgress(boolean show) {
        progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    private RecyclerView.ItemDecoration createElevatedItemDecoration() {
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getContext(),
                DividerItemDecoration.VERTICAL);
        itemDecoration.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.elevated_list_divider));
        return itemDecoration;
    }

    private static class Injector {
        private HomeFragmentComponent createHomeComponent(
                @NonNull BaseAppComponent baseComponent,
                @NonNull HomeFragmentContract.View view) {
            return DaggerHomeFragmentComponent
                    .builder()
                    .baseAppComponent(baseComponent)
                    .homeFragmentModule(new HomeFragmentModule(view))
                    .build();
        }
    }
}
