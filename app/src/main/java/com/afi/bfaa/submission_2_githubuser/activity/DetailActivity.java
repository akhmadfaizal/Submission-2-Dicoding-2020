package com.afi.bfaa.submission_2_githubuser.activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.afi.bfaa.submission_2_githubuser.R;
import com.afi.bfaa.submission_2_githubuser.adapter.SectionsPagerAdapter;
import com.afi.bfaa.submission_2_githubuser.model.User;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.google.android.material.tabs.TabLayout;

import de.hdodenhof.circleimageview.CircleImageView;

public class DetailActivity extends AppCompatActivity {
    public static final String EXTRA_USER = "extra_user";
    Toolbar toolbar;
    TextView tvDetUsername, tvDetName;
    CircleImageView cvDetImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Detail Github User");
        toolbar.setElevation(0);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_black_24dp);
        }

        cvDetImage = findViewById(R.id.cv_det_user);
        tvDetUsername = findViewById(R.id.tv_det_username_user);
        tvDetName = findViewById(R.id.tv_det_name_user);

        User user = getIntent().getParcelableExtra(EXTRA_USER);

        Glide.with(this)
                .load(user.getAvatarUrl())
                .apply(new RequestOptions().override(150,150))
                .into(cvDetImage);

        String usernameDet = user.getLogin();
        String nameDet = user.getName();

        tvDetUsername.setText(usernameDet);
        tvDetName.setText(nameDet);

        SectionsPagerAdapter sectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());
        // ambil data username
        sectionsPagerAdapter.setUsername(usernameDet);
        ViewPager viewPager = findViewById(R.id.view_pager);
        viewPager.setAdapter(sectionsPagerAdapter);
        TabLayout tabs = findViewById(R.id.tabs);
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        if (item.getItemId() == android.R.id.home){
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        return true;
    }
}
