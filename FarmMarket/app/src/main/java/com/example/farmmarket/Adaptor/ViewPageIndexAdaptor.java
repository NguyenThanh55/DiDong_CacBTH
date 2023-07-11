package com.example.farmmarket.Adaptor;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.farmmarket.Helper.CategoryFragment;
import com.example.farmmarket.Helper.IdentityFragment;
import com.example.farmmarket.Helper.RecieptFragment;
import com.example.farmmarket.IndexFragment;
import com.example.farmmarket.MenuHandBookFragment;
import com.example.farmmarket.MenuIndexFragment;
import com.example.farmmarket.MenuPromotionFragment;

public class ViewPageIndexAdaptor extends FragmentStatePagerAdapter {
    public ViewPageIndexAdaptor(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }

    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new MenuIndexFragment();
            case 1:
                return new MenuHandBookFragment();
            case 2:
                return new MenuPromotionFragment();
            case 3:
                return new IdentityFragment();
        }
        return new IndexFragment();
    }

    @Override
    public int getCount() {
        return 4;
    }

}

