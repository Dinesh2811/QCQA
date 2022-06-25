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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.dinesh.qcqa.Home;
import com.dinesh.qcqa.activity.NavigationDrawer;
import com.dinesh.qcqa.R;
import com.dinesh.qcqa.api.ApiMain;
import com.dinesh.qcqa.rv.RvMain;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.GoogleAuthProvider;

//public class SignInHome extends AppCompatActivity implements ToolbarInterface {
public class SignInHome extends NavigationDrawer {


    private static final String TAG = "log_SignInHome"; //GOOGLEAUTH
    private static final int RC_SIGN_IN = 9001; //1
    private FirebaseAuth mAuth;
    private GoogleSignInClient mGoogleSignInClient;
    FirebaseUser user;
    Dialog dialog;

    EditText signInID, signInPassword;
    Button btnSignin, btnSigninWithGoogle,btnSigninWithPhone;
    TextView tvSignup, tvSkipSignIn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate: SignInHome 3");
//        setContentView(R.layout.signin_page);
        LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View contentView = inflater.inflate(R.layout.signin_page, null, false);
        drawerLayout.addView(contentView, 0);

        signInID = findViewById(R.id.signInID);
        signInPassword = findViewById(R.id.signInPassword);
        btnSignin = findViewById(R.id.btnSignin);
        tvSignup = findViewById(R.id.tvSignup);
        tvSkipSignIn = findViewById(R.id.tvSkipSignIn);
        btnSigninWithGoogle = findViewById(R.id.btnSigninWithGoogle);
        btnSigninWithPhone = findViewById(R.id.btnSigninWithPhone);



        btnSigninWithPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithPhone();
            }
        });

        
        btnSigninWithGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signInWithGoogle();
            }
        });


        btnSignin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signInMethod();
            }
        });


        tvSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), SignUpHome.class);
                startActivity(intent);
            }
        });


        tvSkipSignIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(getApplicationContext(), Home.class);
                Intent intent = new Intent(getApplicationContext(), ApiMain.class);
                startActivity(intent);
            }
        });


    }

    private void signInWithPhone() {
        Intent intent = new Intent(getApplicationContext(), SignInPhone.class);
        startActivity(intent);
    }
//
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.option_menu,menu);
//        return true;
//    }

    private void signInMethod() {
//        Intent intent = new Intent(getApplicationContext(),NavigationDrawer.class);

//        Intent intent = new Intent(getApplicationContext(), Home.class);
//        startActivity(intent);

        String ID = signInID.getText().toString();
        String Password = signInPassword.getText().toString();

        if (!ID.isEmpty() && !Password.isEmpty()) {
            if (Patterns.EMAIL_ADDRESS.matcher(ID).matches()) {
                if (Password.length() >= 8) {
//                    signInPassword.setError("Enter a valid password");
//                    signInPassword.requestFocus();
                    Log.i(TAG, "Create signInMethod with email");
                    Toast.makeText(this, "Create signInMethod with email", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ApiMain.class);
                    startActivity(intent);
                }
            } else {
                if (Password.length() >= 8) {
//                    signInPassword.setError("Enter a valid password");
//                    signInPassword.requestFocus();
                    Log.i(TAG, "Create signInMethod with username");
                    Toast.makeText(this, "Create signInMethod with username", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(getApplicationContext(), ApiMain.class);
                    startActivity(intent);
                }
            }
        }
        if (ID.isEmpty()) {
            signInID.setError("Can't be empty");
            signInID.requestFocus();
            return;
        } else if (Password.isEmpty() || Password.length() < 8) {
            signInPassword.setError("Enter a valid password");
            signInPassword.requestFocus();
            return;
        }


    }

    private void signInWithGoogle() {
        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleSignInClient = GoogleSignIn.getClient(this, gso);
        mAuth = FirebaseAuth.getInstance();


//        dialog = new Dialog(getApplicationContext());
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_wait1);
        dialog.setCanceledOnTouchOutside(false);
        signIn();

//        btnSigninWithGoogle = findViewById(R.id.btnSigninWithGoogle);
//        btnSigninWithGoogle.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                signIn();
//
//            }
//        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Result returned from launching the Intent from GoogleSignInApi.getSignInIntent(...);
        if (requestCode == RC_SIGN_IN) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            try {
                // Google Sign In was successful, authenticate with Firebase
                GoogleSignInAccount account = task.getResult(ApiException.class);
                Log.d(TAG, "firebaseAuthWithGoogle:" + account.getId());
                firebaseAuthWithGoogle(account.getIdToken());
            } catch (ApiException e) {
                // Google Sign In failed, update UI appropriately
                Log.w(TAG, "Google sign in failed", e);
            }
        }
    }
    // [END onactivityresult]

    // [START auth_with_google]
    private void firebaseAuthWithGoogle(String idToken) {
        AuthCredential credential = GoogleAuthProvider.getCredential(idToken, null);
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithCredential:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            updateUI(user);

                            Intent intent = new Intent(getApplicationContext(), RvMain.class);
                            startActivity(intent);
                            finish();
                            dialog.dismiss();
                        } else {
                            // If sign in fails, display a message to the user.
                            dialog.dismiss();
                            Log.w(TAG, "signInWithCredential:failure", task.getException());
                            Toast.makeText(SignInHome.this, "signInWithCredential:failure", Toast.LENGTH_SHORT).show();
//                            updateUI(null);
                        }
                    }
                });
    }

    private void signIn() {
        Intent signInIntent = mGoogleSignInClient.getSignInIntent();
        startActivityForResult(signInIntent, RC_SIGN_IN);
    }

    private void updateUI(FirebaseUser user) {

    }

}
