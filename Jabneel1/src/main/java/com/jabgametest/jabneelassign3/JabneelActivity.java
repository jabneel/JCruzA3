package com.jabgametest.jabneelassign3;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class JabneelActivity extends AppCompatActivity {
    int drawables[] = {
            R.drawable.ic_action_name,
            R.drawable.ic_action_dl
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jabneel);
        //getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE, R.layout.fragment_add_info);

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(new SampleFragmentPagerAdapter(getSupportFragmentManager(),
                JabneelActivity.this));

        // Give the TabLayout the ViewPager
        TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(drawables[0]);
        tabLayout.getTabAt(1).setIcon(drawables[1]);

    }

    public class SampleFragmentPagerAdapter extends FragmentPagerAdapter {
        final int PAGE_COUNT = 2;
        private Context context;
        private String tabTitles[] = new String[] { "Jabneel","Cruz"};
        Drawable myDrawable;
        String title;

        public SampleFragmentPagerAdapter(FragmentManager fm, Context context) {
            super(fm);
            this.context = context;
        }

        @Override
        public int getCount() {

            return PAGE_COUNT;
        }

        @Override
        public CharSequence getPageTitle(int position)
        {
            switch (position) {
                case 0:
                    return tabTitles[0];
                //return tabTitles[0];
                case 1:
                    return tabTitles[1];
                //return tabTitles[1];
            }
            return "";
        }
        @Override
        public Fragment getItem(int position) {

            return PageFragment.create(position + 1);
        }
    }

    @Override
    public void onBackPressed(){
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Close App")
                .setMessage("You want to exit the app?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener(){

                    @Override
                    public void onClick(DialogInterface dialog, int which){
                        finish();

                    }
                })
                .setNegativeButton("No",null)
                .show();
    }
}
