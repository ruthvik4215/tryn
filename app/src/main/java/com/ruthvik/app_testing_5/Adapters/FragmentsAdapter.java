package com.ruthvik.app_testing_5.Adapters;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.ruthvik.app_testing_5.Fragments.CameraFragment;
import com.ruthvik.app_testing_5.Fragments.ChatsFragment;
import com.ruthvik.app_testing_5.Fragments.MyFeedFragment;
import com.ruthvik.app_testing_5.Fragments.profileFragment;

public class FragmentsAdapter extends FragmentPagerAdapter {
    public FragmentsAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {

        // Fixing the indexes for tablayout position.

        switch (position) {

            // when index is at position 0 then it returns the chats layout or fragment.
            case 0:
                return new ChatsFragment();

            // when index is at position 1 then it returns the MyFeed layout or fragment.
            case 1:
                return new MyFeedFragment();

            // when index is at position 2 then it returns the camera layout or fragment.
            case 2:
                return new CameraFragment();

            // when index is at position 3 then it returns the profile layout or fragment.
            case 3:
                return new profileFragment();

            /* By default
            * when the authenticated user login to app
            * it will open chats layout or fragment
            * user can change this in settings activity.*/
            default:
                return new ChatsFragment();
        }
    }

    /*
    Returns the total no.of tabs in tablayout.
    Now in the app, we have 4 tabs( chats, myfeed, camera, profile ) at index 0, 1, 2, 3.
    if we change the return value to 3, then the it will display the 3 tabs at index 0, 1, 2.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {

        // By default the title on tab is none.
        String title = null;

        // If the user is at index 0, it displays the title "chats" for that layout in tab.
        if(position == 0) {
            title = "CHATS";
        }

        // If the user is at index 1, it displays the title "myfeed" for that layout in tab.
        if(position == 1) {
            title = "MY FEED";
        }

        // If the user is at index 2, it displays the title "camera" for that layout in tab.
        if(position == 2) {
            title = "CAMERA";
        }

        // If the user is at index 3, it displays the title "profile" for that layout in tab.
        if(position == 3) {
            title = "PROFILE";
        }

        // Returns the title name in tab.

        return title;
    }
}
