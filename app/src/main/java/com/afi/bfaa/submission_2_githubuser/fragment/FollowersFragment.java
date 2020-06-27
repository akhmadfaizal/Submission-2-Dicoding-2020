package com.afi.bfaa.submission_2_githubuser.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.afi.bfaa.submission_2_githubuser.R;
import com.afi.bfaa.submission_2_githubuser.adapter.FollowersUserAdapter;
import com.afi.bfaa.submission_2_githubuser.model.User;
import com.afi.bfaa.submission_2_githubuser.viewmodel.FollowersViewModel;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class FollowersFragment extends Fragment {
    public static final String EXTRA_USERNAME = "extra_username";
    FollowersUserAdapter adapter;
    FollowersViewModel followersViewModel;

    public static FollowersFragment newInstance(String username) {

        Bundle args = new Bundle();
        args.putString(EXTRA_USERNAME, username);
        FollowersFragment fragment = new FollowersFragment();
        fragment.setArguments(args);
        return fragment;
    }

    // Constructor untuk mengirim data ke fragment
    public FollowersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_followers, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String username = getArguments().getString(EXTRA_USERNAME);
        showRecyclerList(view);

        final ProgressBar progressBar = view.findViewById(R.id.progressBar);

        viewModelProvider(username, progressBar);
        subscribeLiveData(adapter, progressBar);
    }

    public void showRecyclerList(View view){
        RecyclerView recyclerView = view.findViewById(R.id.rv_list_followers);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        adapter = new FollowersUserAdapter();
        adapter.notifyDataSetChanged();
        recyclerView.setAdapter(adapter);
    }

    /**
     * ViewModelProviders
     * Menghubungkan ViewModel dengan activity/fragment
     */
    public void viewModelProvider(String username, final ProgressBar progressBar){
        followersViewModel = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(FollowersViewModel.class);
        followersViewModel.setFollowers(username, progressBar);
    }

    /**
     * Subscribe
     * Cara mendapatkan value dari LiveData yang ada pada kelas ViewModel
     */
    public void subscribeLiveData(final FollowersUserAdapter adapter, final ProgressBar progressBar) {
        followersViewModel.getFollowers().observe(this, new Observer<ArrayList<User>>() {
            @Override
            public void onChanged(ArrayList<User> users) {
                if (users != null) {
                    adapter.setFollowers(users);
                    progressBar.setVisibility(View.GONE);
                }
            }
        });
    }

}
