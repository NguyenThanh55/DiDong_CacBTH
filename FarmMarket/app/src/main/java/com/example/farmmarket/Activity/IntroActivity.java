package com.example.farmmarket.Activity;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentContainer;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.ActionProvider;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.farmmarket.Adaptor.ViewPageAdaptor;
import com.example.farmmarket.Adaptor.ViewPageIndexAdaptor;
import com.example.farmmarket.IndexFragment;
import com.example.farmmarket.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class IntroActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner;
    String[] items = {"Quận 7", "Quận 11", "Gò Vấp", "Tân Bình", "Đồng Nai", "Đà Nẵng", "Bình Dương",
                "Phan Thiết", "Vũng Tàu", "Ba Đình", "Cần Thơ", "Nha Trang", "Cầu Giấy", "Vinh"};

    private RecyclerView.Adapter adapter, adapter2;
    private RecyclerView recyclerViewCategoryList, recyclerViewPopularList;
    private ViewPager mViewPager;

    private BottomNavigationView bottomAppBar;
    private FloatingActionButton floatingActionButton;
    @SuppressLint({"MissingInflatedId", "NonConstantResourceId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        createSpinner();
//        recyclerViewCategory();
//        recyclerViewPopular();
        floatingActionButton = findViewById(R.id.floatingActionButton);
        bottomAppBar = findViewById(R.id.bottom_nav);
//        MenuItem menuItem = bottomAppBar.getMenu().getItem(2);
//        menuItem.setEnabled(false);

        mViewPager=findViewById(R.id.view_pager);

        setupWithViewPager();

        bottomAppBar.setOnItemSelectedListener((item) -> {
            if (item.getItemId() == R.id.action_index) {
                mViewPager.setCurrentItem(0);
            } else if (item.getItemId() == R.id.action_category) {
                mViewPager.setCurrentItem(1);
            } else if (item.getItemId() == R.id.action_reciept) {
                startActivity(new Intent(IntroActivity.this, MainActivity.class));
            } else if (item.getItemId() == R.id.action_identity) {
                mViewPager.setCurrentItem(3);
            }
            return true;
        });

    }

    private void setupWithViewPager() {
        ViewPageAdaptor viewPageAdaptor = new ViewPageAdaptor(getSupportFragmentManager(),
                FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewPager.setAdapter(viewPageAdaptor);
    }

    private void createSpinner() {
        spinner = (Spinner) findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_dropdown_item,
                items);

        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        txtMsg.setText(items[position]);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

//    private void recyclerViewCategory() {
//        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//        recyclerViewCategoryList=findViewById(R.id.recycleView);
//        recyclerViewCategoryList.setLayoutManager(linearLayoutManager);
//
//        ArrayList<CategoryDomain> category = new ArrayList<>();
//        category.add(new CategoryDomain("Pizza", "cate_1"));
//        category.add(new CategoryDomain("Burger", "logo"));
//        category.add(new CategoryDomain("Hot dog", "logo"));
//        category.add(new CategoryDomain("Drink", "logo"));
//        category.add(new CategoryDomain("Donut", "logo"));
//        category.add(new CategoryDomain("7up", "logo"));
//        category.add(new CategoryDomain("Donut", "logo"));
//
//        adapter = new CategoryAdaptor(category);
//        recyclerViewCategoryList.setAdapter(adapter);
//    }
//
//    private void recyclerViewPopular() {
//        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
//        recyclerViewPopularList=findViewById(R.id.recycleView2);
//        recyclerViewPopularList.setLayoutManager(linearLayoutManager);
//        recyclerViewPopularList.setHasFixedSize(true);
//        ArrayList<FoodDomain> foodList = new ArrayList<>();
//        foodList.add(new FoodDomain("Pepperoni","cate_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",9.76));
//        foodList.add(new FoodDomain("Cheese Burger","cate_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",9.00));
//        foodList.add(new FoodDomain("Beef Burger","cate_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",8.99));
//        foodList.add(new FoodDomain("Chicken Burger","cate_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",8.55));
//        foodList.add(new FoodDomain("Vegetable Pizza","cate_1","slices pepperoni, mozzerella cheese, fresh oregano, ground black pepper, pizza sauce",9.77));
//
//        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
//        recyclerViewPopularList.setLayoutManager(gridLayoutManager);
//
//        adapter2=new PopularAdaptor(foodList);
//        recyclerViewPopularList.setAdapter(adapter2);
//
//
//    }


}