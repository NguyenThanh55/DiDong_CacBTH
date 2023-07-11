package com.example.farmmarket;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.farmmarket.Adaptor.SlideAdaptor;
import com.example.farmmarket.Domain.SlideItem;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link MenuIndexFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class MenuIndexFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    ViewPager2 viewPager2;
    private Handler slideHandler = new Handler();

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public MenuIndexFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment MenuIndexFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static MenuIndexFragment newInstance(String param1, String param2) {
        MenuIndexFragment fragment = new MenuIndexFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_menu_index, container, false);
//        viewPager2=view.findViewById(R.id.fragment_slide_menu_index);
//        List<SlideItem> sliderItem = new ArrayList<>();
//        sliderItem.add(new SlideItem(R.drawable.banner1));
//        sliderItem.add(new SlideItem(R.drawable.banner2));
//
//        viewPager2.setAdapter(new SlideAdaptor(sliderItem, viewPager2));
//
//        viewPager2.setClipToPadding(false);
//        viewPager2.setClipChildren(false);
//        viewPager2.setOffscreenPageLimit(2); // Quanlity banner
//        viewPager2.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);
//
//
//        // Distance between 2 banner
//        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
//        compositePageTransformer.addTransformer(new MarginPageTransformer(10));
//        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
//            // Effect tranform
//            @Override
//            public void transformPage(@NonNull View page, float position) {
////                float r = 1 - Math.abs(position);
////                page.setScaleY(0.4f + r + 0.1f);
//            }
//        });
//
//        viewPager2.setPageTransformer(compositePageTransformer);
//        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
//            @Override
//            public void onPageSelected(int position) {
//                super.onPageSelected(position);
//                slideHandler.removeCallbacks(sliderRunnable);
//                slideHandler.postDelayed(sliderRunnable, 3000);
//            }
//        });
        return view;
    }

    private Runnable sliderRunnable = new Runnable() {
        @Override
        public void run() {
            viewPager2.setCurrentItem(viewPager2.getCurrentItem() + 1);
        }
    };

    @Override
    public void onPause() {
        super.onPause();
        slideHandler.removeCallbacks(sliderRunnable);
    }

    @Override
    public void onResume() {
        super.onResume();
        slideHandler.postDelayed(sliderRunnable, 3000);
    }
}