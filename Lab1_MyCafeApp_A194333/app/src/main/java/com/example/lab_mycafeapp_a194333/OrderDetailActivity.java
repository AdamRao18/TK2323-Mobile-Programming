package com.example.lab_mycafeapp_a194333;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class OrderDetailActivity extends AppCompatActivity implements View.OnClickListener {

    ImageButton imgBtnCall, imgBtnWeb, imgBtnEmail, imgBtnShare;
    TextView tvName, tvQuantity;
    String name;
    int quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        imgBtnCall = findViewById(R. id. img_btn_call_order_act);
        imgBtnWeb = findViewById(R. id. img_btn_web_order_act);
        imgBtnEmail = findViewById(R. id. img_btn_email_order_act);
        imgBtnShare = findViewById(R. id. img_btn_share_order_act);

        tvName = findViewById(R. id. tv_name_order_act);
        tvQuantity = findViewById(R. id. tv_quantity_order_act);

        Intent intent = getIntent();
        quantity = intent.getIntExtra("quantity",0);
        name = intent.getStringExtra("name");

        tvName.setText(name);
        tvQuantity.setText("" + quantity);

        imgBtnCall.setOnClickListener(this);
        imgBtnWeb.setOnClickListener(this);
        imgBtnEmail.setOnClickListener(this);
        imgBtnShare.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        int id = view.getId();

        if (id == R. id. img_btn_call_order_act){
            Intent callIntent = new Intent(Intent.ACTION_DIAL);
            callIntent.setData(Uri.parse("tel: 012345678"));

            if(callIntent.resolveActivity(getPackageManager()) != null){
                startActivity(callIntent);
            }else{
                Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
            }

        }else if (id == R. id. img_btn_web_order_act){
            Uri webpage = Uri.parse("http://www.google.com");
            Intent webIntent = new Intent(Intent.ACTION_VIEW, webpage);

            if(webIntent.resolveActivity(getPackageManager()) != null){
                startActivity(webIntent);
            }else{
                Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
            }

        }else if (id == R. id. img_btn_email_order_act){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("text/plain");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "YOUR ORDER FROM MYCAFEAPP");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message: Information about order");
            emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"mycafeapp@company.com"});

            if(emailIntent.resolveActivity(getPackageManager()) != null){
                startActivity(emailIntent);
            }else{
                Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
            }

        }else if (id == R. id. img_btn_share_order_act){
            Uri share = Uri.parse("https://wa.me/qr/K25VFQOPNI34C1");
            Intent shareIntent = new Intent(Intent.ACTION_VIEW, share);

            if(shareIntent.resolveActivity(getPackageManager()) != null){
                startActivity(shareIntent);
            }else{
                Toast.makeText(OrderDetailActivity.this, "Sorry, no app can handle this action and data", Toast.LENGTH_SHORT).show();
            }
        }
    }
}