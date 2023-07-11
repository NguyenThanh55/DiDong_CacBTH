package com.example.ltdd_bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit_chieucao, edit_cannang;
    RadioButton radNam, radNu;
    Button btnTinh;
    TextView txtChiSo, txtNhanXet;
    double chiso;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edit_chieucao=findViewById(R.id.edit_chieucao);
        edit_cannang=findViewById(R.id.edit_cannang);
        radNam=findViewById(R.id.rad_nam);
        radNu=findViewById(R.id.rad_nu);
        btnTinh=findViewById(R.id.btn_tinh);
        txtChiSo=findViewById(R.id.txt_ketqua);
        txtNhanXet=findViewById(R.id.txt_nhanxet);

        btnTinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double chieucao = Double.parseDouble(edit_chieucao.getText().toString()) / 100;
                double cannang = Double.parseDouble(edit_cannang.getText().toString());
                chiso = Math.round((cannang / Math.pow(chieucao, 2)) * 10.0) / 10.0;
                if (radNam.isChecked()) {
                    if (chiso < 18.5) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    } else if (chiso >= 18.5 && chiso <= 24.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Binh thuong");
                    } else if (chiso >= 25 && chiso <= 29.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Thua can");
                    } else if (chiso >= 30 && chiso <= 34.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Beo phi do I");
                    } else if (chiso >= 35 && chiso <= 39.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Beo phi do II");
                    } else if (chiso >= 40) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Beo phi do III");
                    }
                }
                else if (radNu.isChecked()){
                    if (chiso < 18.5) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Bạn cần bổ sung thêm dinh dưỡng");
                    } else if (chiso >= 18.5 && chiso <= 22.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Binh thuong");
                    } else if (chiso >= 23 && chiso <= 24.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Thua can");
                    } else if (chiso >= 25 && chiso <= 29.9) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Beo phi do I");
                    } else if (chiso >= 30) {
                        txtChiSo.setText(String.valueOf(chiso));
                        txtNhanXet.setText("Beo phi do II");
                    }
                }
                else {
                    Toast.makeText(getApplicationContext(), "Vui long chon gioi tinh!", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}