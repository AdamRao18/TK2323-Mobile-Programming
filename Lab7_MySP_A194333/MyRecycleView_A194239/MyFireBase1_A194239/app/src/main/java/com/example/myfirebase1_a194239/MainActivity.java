package com.example.myfirebase1_a194239;

import static com.example.myfirebase1_a194239.R.id.main_btn_register_member;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    Button btnRegisterClub, btnRegisterMember;

    //reference for the Firebase Authentication
    private FirebaseAuth mFirebaseAuth;
    //reference for the User in firebase
    private FirebaseUser mFirebaseUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the view
        btnRegisterClub=findViewById(R.id.main_btn_register_club);
        btnRegisterMember=findViewById(main_btn_register_member);


        btnRegisterClub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to the register club activity


            }
        });

        btnRegisterMember.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //go to the register member activity


            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;


    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        mFirebaseAuth=FirebaseAuth.getInstance();
        mFirebaseUser=mFirebaseAuth.getCurrentUser();

        if(mFirebaseUser==null)
        {

            //go to login page
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);
        }


    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id==R.id.action_logout)
        {
            mFirebaseAuth.signOut();
            Intent intent = new Intent(MainActivity.this, LoginActivity.class);
            startActivity(intent);



        }


        return super.onOptionsItemSelected(item);
    }
}