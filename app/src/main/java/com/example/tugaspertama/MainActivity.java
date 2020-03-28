package com.example.tugaspertama;


import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.basgeekball.awesomevalidation.AwesomeValidation;
import com.basgeekball.awesomevalidation.ValidationStyle;
import com.basgeekball.awesomevalidation.utility.RegexTemplate;


public class MainActivity extends AppCompatActivity {
    EditText namaDepan, namaBelakang, tempatLahir, tanggalLahir, alamat, telepon, email, password, repassword;
    RadioGroup jenisKelamin, agama;
    Button Daftar, Kembali;
    AwesomeValidation awesomeValidation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        namaDepan = findViewById(R.id.namadpn);
        namaBelakang = findViewById(R.id.namablkg);
        tempatLahir = findViewById(R.id.tmptlhr);
        tanggalLahir = findViewById(R.id.tgllhr);
        alamat = findViewById(R.id.alamat);
        telepon = findViewById(R.id.telepon);
        email = findViewById(R.id.email);
        password = findViewById(R.id.pass);
        repassword = findViewById(R.id.repass);
        Daftar = findViewById(R.id.btnDaftar);
        Kembali = findViewById(R.id.btnKembali);
        jenisKelamin = findViewById(R.id.jk);
        agama = findViewById(R.id.ag);

        awesomeValidation = new AwesomeValidation(ValidationStyle.BASIC);

        awesomeValidation.addValidation(this, R.id.namadpn,
                RegexTemplate.NOT_EMPTY, R.string.v1);
        awesomeValidation.addValidation(this, R.id.namablkg,
                RegexTemplate.NOT_EMPTY, R.string.v2);
        awesomeValidation.addValidation(this, R.id.tmptlhr,
                RegexTemplate.NOT_EMPTY, R.string.v3);
        awesomeValidation.addValidation(this, R.id.tgllhr,
                RegexTemplate.NOT_EMPTY, R.string.v4);
        awesomeValidation.addValidation(this, R.id.alamat,
                RegexTemplate.NOT_EMPTY, R.string.v5);
        awesomeValidation.addValidation(this, R.id.telepon,
                "[0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9][0-9]$",
                R.string.v6);
        awesomeValidation.addValidation(this, R.id.email,
                Patterns.EMAIL_ADDRESS, R.string.v7);
        awesomeValidation.addValidation(this, R.id.pass,
                ".{6,}", R.string.v8);
        awesomeValidation.addValidation(this, R.id.repass,
                R.id.pass, R.string.v9);
        


        Daftar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (awesomeValidation.validate()) {
                    Toast.makeText(getApplicationContext(),
                            "Form Validate Successfully...", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "Validation Falid.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Button Kembali = (Button)findViewById(R.id.btnKembali);
        Kembali.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });


        };

}
