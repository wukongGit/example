package com.example.suncheng.androiddeveloputils;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.bean.AppInfo;
import com.example.utils.PackageUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by suncheng on 2016/4/17.
 */
public class PackageScanActivity extends AppCompatActivity {
    private List<PackageInfo> mSystemPackageInfoList = new ArrayList<PackageInfo>();
    private List<PackageInfo> mCustomPackageInfoList = new ArrayList<PackageInfo>();
    private List<AppInfo> mSystemList = new ArrayList<AppInfo>();
    private List<AppInfo> mCustomList = new ArrayList<AppInfo>();

    private SectionsPagerAdapter mSectionsPagerAdapter;
    private ViewPager mViewPager;
    private TabLayout mTabLayout;
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_package_scan);
        mViewPager = (ViewPager) findViewById(R.id.container);
        mTabLayout = (TabLayout) findViewById(R.id.tabs);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        setTitle(getString(R.string.action_settings));
        initPackageInfo();

        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mSectionsPagerAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
    }

    private void initPackageInfo() {
        PackageManager packageManager = this.getPackageManager();
        PackageUtils.getAllApps(this, mSystemPackageInfoList, mCustomPackageInfoList);
        if(mCustomPackageInfoList != null) {
            for (int i = 0; i < mCustomPackageInfoList.size(); i++) {
                PackageInfo pinfo = mCustomPackageInfoList.get(i);
                AppInfo item = new AppInfo();
                item.setIcon(packageManager.getApplicationIcon(pinfo.applicationInfo));
                item.setAppName(packageManager.getApplicationLabel(pinfo.applicationInfo).toString());
                item.setPackageName(pinfo.applicationInfo.packageName);
                mCustomList.add(item);
            }
        }
        if(mSystemPackageInfoList != null) {
            for (int i = 0; i < mSystemPackageInfoList.size(); i++) {
                PackageInfo pinfo = mSystemPackageInfoList.get(i);
                AppInfo item = new AppInfo();
                item.setIcon(packageManager.getApplicationIcon(pinfo.applicationInfo));
                item.setAppName(packageManager.getApplicationLabel(pinfo.applicationInfo).toString());
                item.setPackageName(pinfo.applicationInfo.packageName);
                mSystemList.add(item);
            }
        }
    }

    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0: {
                    PackageScanFragment fragment = new PackageScanFragment();
                    fragment.setData(mCustomList);
                    return fragment;
                }
                case 1: {
                    PackageScanFragment fragment = new PackageScanFragment();
                    fragment.setData(mSystemList);
                    return fragment;
                }
            }
            return null;
        }

        @Override
        public int getCount() {
            return 2;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return getString(R.string.custom_installed);
                case 1:
                    return getString(R.string.system_installed);
            }
            return null;
        }
    }

}
