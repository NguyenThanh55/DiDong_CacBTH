package com.example.farmmarket.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.farmmarket.Domain.FoodDomain;
import com.example.farmmarket.Helper.ManagerCart;
import com.example.farmmarket.R;

public class DetailActivity extends AppCompatActivity {
    private TextView addToCartBtn, txtTitle, txtFee, txtDescription, txtNumberOrder;
    private ImageView btnPlus, btnMinus, picFood;
    private FoodDomain object;
    int numberOrder = 1;
    private ManagerCart managerCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        managerCart=new ManagerCart(this);
        initView();
        getBundle();
    }

    private void getBundle() {
        object=(FoodDomain) getIntent().getSerializableExtra("object");

        int drawableResource=this.getResources().getIdentifier(object.getPic(), "drawable", this.getPackageName());
        Glide.with(this)
                .load(drawableResource)
                .into(picFood);

        txtTitle.setText(object.getTitle());
        txtFee.setText("$" + object.getFee());
        txtDescription.setText(object.getDescription());
        txtNumberOrder.setText(String.valueOf(numberOrder));

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder+=1;
                txtNumberOrder.setText(String.valueOf(numberOrder));
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (numberOrder>1)
                    numberOrder-=1;
                txtNumberOrder.setText(String.valueOf(numberOrder));
            }
        });

        addToCartBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                object.setNumberInCart(numberOrder);
                managerCart.insertFood(object);
            }
        });
    }

    private void initView() {
        addToCartBtn=findViewById(R.id.addToCartBtn);
        txtTitle=findViewById(R.id.txtTitle);
        txtFee=findViewById(R.id.txtPrice);
        txtDescription=findViewById(R.id.txtDescription);
        txtNumberOrder=findViewById(R.id.txtNumberOrder);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        picFood=findViewById(R.id.pic);
    }
}