package com.example.admin.zooroo;

import android.R.anim;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity {


    private EditText editText;
    FirebaseApp firebaseApp;
    ViewFlipper vflipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int images[] = {R.drawable.s1 , R.drawable.s2 , R.drawable.s3};

        vflipper = findViewById(R.id.vflipper);

        editText = findViewById(R.id.editTextPhone);

        for(int image: images)
        {
            flipperImages(image);
        }

        findViewById(R.id.buttonContinue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String code = "91";

                String number = editText.getText().toString().trim();

                if (number.isEmpty() || number.length() < 10) {
                    editText.setError("Valid number is required");
                    editText.requestFocus();
                    return;
                }

                String phoneNumber = "+" + code + number;

                Intent intent = new Intent(MainActivity.this, VerifyPhoneActivity.class);
                intent.putExtra("phonenumber", phoneNumber);
                startActivity(intent);

            }
        });
    }


    @Override
    protected void onStart() {
        super.onStart();

        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Intent intent = new Intent(this, ProfileActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

            startActivity(intent);
        }
    }


    public  void flipperImages(int image)
    {
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);
        vflipper.addView(imageView);
        vflipper.setFlipInterval(4000);
        vflipper.setAutoStart(true);

        vflipper.setInAnimation(this, anim.slide_in_left);
        vflipper.setOutAnimation(this, anim.slide_out_right);
    }
}
