package com.ruthvik.app_testing_5.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ruthvik.app_testing_5.Fragments.CallsFragment;
import com.ruthvik.app_testing_5.Fragments.ChatsFragment;
import com.ruthvik.app_testing_5.Fragments.StatusFragment;
import com.ruthvik.app_testing_5.Fragments.profileFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return new ChatsFragment();
            case 1:
                return new StatusFragment();
            case 2:
                return new CallsFragment();
            case 3:
                return new profileFragment();
            default:
                return new ChatsFragment();
        }
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        if(position == 0) {
            title = "CHATS";
        }
        if(position == 1) {
            title = "MY FEED";
        }
        if(position == 2) {
            title = "CAMERA";
        }
        if(position == 3) {
            title = "PROFILE";
        }

        return title;
    }
}
