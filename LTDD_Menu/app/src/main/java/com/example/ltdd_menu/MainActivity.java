package com.example.ltdd_menu;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    int loaiP=0;
    int priceP, priceTS;
    int countP, countTS;
    double dc;
    Button btn_CongP, btn_TruP, btn_CongTS, btn_TruTS, btnDatHang, btnLamLai;
    CheckBox cb_ThemNam, cb_ThemPM, cb_themXiuMai, cb_ThemTC, cb_ThemThach, cb_ThemPudding;
    RadioButton rd_BBQ, rd_Hawaii, rd_MD, rd_Lon, rd_Vua, rd_Nho;
    EditText edt_MaGG;
    TextView tv_SoTienGiam, tv_TongTien, tv_SLP, tv_SLTS;
    RadioGroup rg_loai, rg_kichco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        CheckedChange();
        SoLuongP();
        SoLuongTS();
        LamLai();

        btnDatHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price();
                Toast.makeText(MainActivity.this,"Đặt hàng thành công!", Toast.LENGTH_LONG)
                        .show();            }
        });
    }

    private void LamLai() {
        btnLamLai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Price();
                cb_ThemTC.setChecked(false);
                cb_ThemNam.setChecked(false);
                cb_ThemPudding.setChecked(false);
                cb_ThemThach.setChecked(false);
                cb_ThemPM.setChecked(false);
                cb_themXiuMai.setChecked(false);

                rd_Lon.setChecked(false);
                rd_Vua.setChecked(false);
                rd_Nho.setChecked(false);
                rd_BBQ.setChecked(false);
                rd_Hawaii.setChecked(false);
                rd_MD.setChecked(false);

                tv_SLP.setText("0");
                tv_SLTS.setText("0");
                tv_TongTien.setText("0");
                tv_SoTienGiam.setText("0");
            }
        });
    }

    private void SoLuongTS() {
        btn_CongTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTS = Integer.parseInt(tv_SLTS.getText().toString());
                countTS++;
                tv_SLTS.setText(String.valueOf(countTS));
                Price();
            }
        });
        btn_TruTS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countTS = Integer.parseInt(tv_SLTS.getText().toString());
                if (countTS>0)
                    countTS--;
                tv_SLTS.setText(String.valueOf(countTS));
                Price();
            }
        });
    }

    private void SoLuongP() {
        btn_CongP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countP = Integer.parseInt(tv_SLP.getText().toString());
                countP++;
                tv_SLP.setText(String.valueOf(countP));
                Price();
            }
        });
        btn_TruP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                countP = Integer.parseInt(tv_SLP.getText().toString());
                if (countP>0)
                    countP--;
                tv_SLP.setText(String.valueOf(countP));
                Price();
            }
        });
    }


    private void CheckedChange() {
        cb_ThemThach.setOnCheckedChangeListener(this);
        cb_ThemPudding.setOnCheckedChangeListener(this);
        cb_ThemTC.setOnCheckedChangeListener(this);
        cb_ThemPM.setOnCheckedChangeListener(this);
        cb_ThemNam.setOnCheckedChangeListener(this);
        cb_themXiuMai.setOnCheckedChangeListener(this);

        rd_Lon.setOnCheckedChangeListener(this);
        rd_Vua.setOnCheckedChangeListener(this);
        rd_Nho.setOnCheckedChangeListener(this);
        rd_BBQ.setOnCheckedChangeListener(this);
        rd_Hawaii.setOnCheckedChangeListener(this);
        rd_MD.setOnCheckedChangeListener(this);
    }


    private void Price() {
        double price = 0;
        int totalPriceP = 0, totalPriceTS = 0;
        int price1 = 150, price2 = 45;

        GiamGia();
        if (countP>0)
            totalPriceP = (price1 + priceP + loaiP) * countP;
        if (countTS>0)
            totalPriceTS = (price2 + priceTS) * countTS;

        price = (totalPriceP + totalPriceTS);
        tv_SoTienGiam.setText("Số tiền giảm là: " + (String.valueOf(Math.round(price*dc))));
        tv_TongTien.setText("Số tiền phải trả là: " + (String.valueOf(Math.round(price*(1-dc)))));
    }

    private void GiamGia() {
        String dis = edt_MaGG.getText().toString().toLowerCase();
        if (dis.equals("TienDepTrai")) {
            dc = 0.2;
        }
        else if (dis.equals("HieuDepTrai"))
            dc = 0.5;
        else
            dc = 0;
    }

    private void AnhXa() {
        btn_TruP=findViewById(R.id.btn_TruSLPizza);
        btn_CongP=findViewById(R.id.btn_CongSLPizza);

        btn_TruTS=findViewById(R.id.btn_TruSLTS);
        btn_CongTS=findViewById(R.id.btn_CongSLTS);

        btnDatHang=findViewById(R.id.btn_DatHang);
        btnLamLai=findViewById(R.id.btn_LamLai);

        cb_ThemTC=findViewById(R.id.cb_ThemTC);
        cb_ThemPM=findViewById(R.id.cb_themPM);
        cb_ThemNam=findViewById(R.id.cb_themNam);
        cb_ThemPudding=findViewById(R.id.cb_ThemPudding);
        cb_ThemThach=findViewById(R.id.cb_ThemThach);
        cb_themXiuMai=findViewById(R.id.cb_themXiuMai);

        rg_kichco=findViewById(R.id.rg_KichThuoc);
        rg_loai=findViewById(R.id.rg_Loai);

        edt_MaGG=findViewById(R.id.edt_MaGG);
        tv_SoTienGiam=findViewById(R.id.tv_SoTienGG);
        tv_TongTien=findViewById(R.id.tv_SoTongTien);
        tv_SLP=findViewById(R.id.tvSLPizza);
        tv_SLTS=findViewById(R.id.tv_SLTS);

        rd_BBQ=findViewById(R.id.rb_PzGaBBQ);
        rd_Hawaii=findViewById(R.id.rb_PzGaHawaii);
        rd_MD=findViewById(R.id.rb_PzMD);
        rd_Lon=findViewById(R.id.rd_Lon);
        rd_Vua=findViewById(R.id.rb_Vua);
        rd_Nho=findViewById(R.id.rb_Nho);
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        int id = buttonView.getId();

        if (isChecked) {
            if (id == R.id.cb_ThemTC)  {
                priceTS +=10;
                Price();
            }
            if (id == R.id.cb_themNam)  {
                priceP+=15;
                Price();
            }
            if (id == R.id.cb_themPM)  {
                priceP +=20;
                Price();
            }
            if (id == R.id.cb_ThemThach)  {
                priceTS +=18;
                Price();
            }
            if (id == R.id.cb_ThemPudding)  {
                priceTS +=24;
                Price();
            }
            if (id == R.id.cb_themXiuMai)  {
                priceP +=30;
                Price();
            }

        }
        else {
            if (id == R.id.cb_ThemTC)  {
                priceTS -=10;
                Price();
            }
            if (id == R.id.cb_themNam)  {
                priceP -=15;
                Price();
            }
            if (id == R.id.cb_themPM)  {
                priceP -=20;
                Price();
            }
            if (id == R.id.cb_ThemThach)  {
                priceTS -=18;
                Price();
            }
            if (id == R.id.cb_ThemPudding)  {
                priceTS -=24;
                Price();
            }
            if (id == R.id.cb_themXiuMai)  {
                priceP -=30;
                Price();
            }
        }
    }
}