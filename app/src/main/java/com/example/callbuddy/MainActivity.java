package com.example.callbuddy;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button smser2;
    Button camerer;
    Button mailer;
    String num="0525237375";
    String text="Mammy i pooped m'pants";
    FragmentManager fragmentManager;

    public void setNum(String num) {
        this.num = num;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.main_main,menu);

        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case  R.id.item1:
                Toast.makeText(MainActivity.this,"Boxing selcted",Toast.LENGTH_LONG).show();
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, change_call_number.class, null).
                        setReorderingAllowed(true).addToBackStack(null).commit();
                break;
            case R.id.subItem1:
                Toast.makeText(MainActivity.this,"Beer1 selcted",Toast.LENGTH_LONG).show();
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.fragmentContainerView2, BlankFragment.class, null).setReorderingAllowed(true).addToBackStack(null).commit();
                break;
            case R.id.subItem2:
                Toast.makeText(MainActivity.this,"Beer2 selcted",Toast.LENGTH_LONG).show();
                Intent intent=new Intent(getApplicationContext(),MainActivity2.class);
                        startActivity(intent);
                break;
            case R.id.subItem3:

                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    Button caller=findViewById(R.id.button2);
    Button smser=findViewById(R.id.button);
    smser2=findViewById(R.id.button3);
    ActivityCompat.requestPermissions(MainActivity.this,new String[]{Manifest.permission.CALL_PHONE,Manifest.permission.SEND_SMS,Manifest.permission.READ_SMS,Manifest.permission.CAMERA}, PackageManager.PERMISSION_GRANTED);
        caller.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            call();
        }
    });
    smser.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            sms();
        }
    });
    smser2.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
           sms2();
        }
    });
        camerer=findViewById(R.id.camerer);
        camerer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                camera();
            }
        });
        mailer=findViewById(R.id.mailrer);
        mailer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mail();
            }
        });
    }

    private void sms2() {

        SmsManager smsManager=SmsManager.getDefault();
        smsManager.sendTextMessage(num,null,text,null,null);
        Toast.makeText(MainActivity.this,"Message Send",Toast.LENGTH_LONG).show();
        smser2.setClickable(false);
        smser2.setTextColor(Color.rgb(154,75,17));
        smser2.setBackgroundColor(Color.rgb(222,0,0));
    }

    private void mail() {
        String recipient = "esterika@gmail.com";
        String subject = "open gmail, walla sucks";
        String message = "once upon a time i had a walla account and after not using it for 3 years it got deleted and now all i had connected to this account got fucked!";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL,recipient);
        intent.putExtra(Intent.EXTRA_SUBJECT,subject);
        intent.putExtra(Intent.EXTRA_TEXT,message);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose a client"));
    }

    private void camera() {
        Intent camera=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivity(camera);
    }


    private void sms() {
        String phonesms="smsto:0525237375";
        Intent sms=new Intent(Intent.ACTION_SENDTO, Uri.parse(phonesms));
        sms.putExtra("sms_body","stuff and alot more stuff");
        startActivity(sms);

    }

    private void call() {
        String phone="tel:0525237375";
        Intent call=new Intent(Intent.ACTION_CALL);
        call.setData(Uri.parse(phone));
        startActivity(call);
    }
}