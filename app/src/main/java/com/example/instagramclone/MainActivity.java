package com.example.instagramclone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.SaveCallback;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private Button btnSave;
    private EditText editName,editPunchSpeed,editPunchPower,editKickPower;
    private Button btnTransition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSave=findViewById(R.id.button);
        btnSave.setOnClickListener(MainActivity.this);
        editName=findViewById(R.id.editName);
        editPunchSpeed=findViewById(R.id.editPunchSpeed);
        editPunchPower=findViewById(R.id.editPunchPower);
        editKickPower=findViewById(R.id.editKickPower);
        btnTransition=findViewById(R.id.btnNextActivity);

        btnTransition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,SignUpAndLogInActivity.class);
                startActivity(intent);


            }
        });
    }

    @Override
    public void onClick(View view) {
        try {
            final ParseObject kickBoxer = new ParseObject("KickBoxer");
            kickBoxer.put("name", editName.getText().toString());
            kickBoxer.put("punch_speed", Integer.parseInt(editPunchSpeed.getText().toString()));
            kickBoxer.put("punch_power", Integer.parseInt(editPunchPower.getText().toString()));
            kickBoxer.put("kick_power", editKickPower.getText().toString());
            kickBoxer.saveInBackground(new SaveCallback() {
                @Override
                public void done(ParseException e) {
                    if (e == null) {
                        Toast.makeText(MainActivity.this, kickBoxer.get("name") + " is saved", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                }
            });
        }catch (Exception e){
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }
//    public void helloWorldTapped(View view){
////        ParseObject boxer =new ParseObject("Boxer");
////        boxer.put("punch_speed",200);
////        boxer.saveInBackground(new SaveCallback() {
////            @Override
////            public void done(ParseException e) {
////                if (e==null){
////                    Toast.makeText(MainActivity.this,"boxer is saved successfl", Toast.LENGTH_LONG).show();
////                }
////            }
////        });
//        final ParseObject kickBoxer=new ParseObject("KickBoxer");
//        kickBoxer.put("name", "Sid");
//        kickBoxer.put("punch_speed", 1000);
//        kickBoxer.put("punch_power", 2000);
//        kickBoxer.saveInBackground(new SaveCallback() {
//            @Override
//            public void done(ParseException e) {
//                Toast.makeText(MainActivity.this,kickBoxer.get("name")+" is saved",Toast.LENGTH_SHORT).show();
//            }
//        });
//    }
}
