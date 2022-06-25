package com.dinesh.qcqa.activity.signin;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dinesh.qcqa.Home;
import com.dinesh.qcqa.R;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.annotations.NotNull;

public class SignUpHome extends NavigationDrawer {

    private static final String TAG = "log_test";
    FirebaseAuth mAuth;
    Dialog dialog;
    EditText signUpName,signUpEmail,signUpPassword,signUpConfirmPassword;
    Button btnSignUp;
    TextView tvSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.signup_page);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.signup_page, null, false);
        drawerLayout.addView(contentView, 0);

        mAuth = FirebaseAuth.getInstance();

        signUpName = findViewById(R.id.signUpName);
        signUpEmail = findViewById(R.id.signUpEmail);
        signUpPassword = findViewById(R.id.signUpPassword);
        signUpConfirmPassword = findViewById(R.id.signUpConfirmPassword);
        btnSignUp = findViewById(R.id.btnSignUp);
        tvSignIn = findViewById(R.id.tvSignIn);

        tvSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignInHome.class);
                startActivity(intent);
            }
        });



        btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Toast.makeText(SignUpHome.this, "Home Page", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(getApplicationContext(),Home.class);
//                startActivity(intent);
                signUp();
            }
        });


    }

    private void signUp() {
        String Name = signUpName.getText().toString();
        String Email = signUpEmail.getText().toString();
        String Password = signUpPassword.getText().toString();
        String ConfirmPassword = signUpConfirmPassword.getText().toString();
        Log.i(TAG, "signUp: ");

        if (!Name.isEmpty()){

        if (Patterns.EMAIL_ADDRESS.matcher(Email).matches() && !Name.isEmpty()){
            Log.i(TAG, "signUp: 1st if stmt");
            if (Password.matches(ConfirmPassword) && Password.length() >= 8){
                Log.i(TAG, "signUp: 2nd if stmt");

                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),0);
                dialog = new Dialog(this);
                dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
                dialog.setContentView(R.layout.dialog_wait1);
                dialog.setCanceledOnTouchOutside(false);
                dialog.show();
                mAuth.createUserWithEmailAndPassword(Email,Password)
                        .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull @NotNull Task<AuthResult> task) {

                                if (task.isSuccessful()){

                                    Toast.makeText(SignUpHome.this,"Successfuly created",Toast.LENGTH_SHORT).show();
                                    FirebaseUser user = mAuth.getCurrentUser();
                                    if (user != null)
                                    {

                                        dialog.dismiss();
                                        Intent i = new Intent(getApplicationContext(), Home.class);
                                        startActivity(i);
                                        finish();

                                    }

                                }else {


                                    dialog.dismiss();
                                    Toast.makeText(SignUpHome.this,"Authentication Failed",Toast.LENGTH_SHORT).show();


                                }

                            }
                        });

            }else if (Password.length() < 8){

                signUpPassword.setError("Password must be atleast 8 character long");
                signUpPassword.requestFocus();


            }else {

                signUpConfirmPassword.setError("Password doesn't match");
                signUpConfirmPassword.requestFocus();
            }
        }else {
            signUpEmail.setError("Its not a valid email");
            signUpEmail.requestFocus();
        }
        }else {
            signUpName.setError("Enter the Name");
            signUpName.requestFocus();
        }
    }
}
