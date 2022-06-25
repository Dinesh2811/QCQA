package com.dinesh.qcqa.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.dinesh.qcqa.MainActivity;
import com.dinesh.qcqa.R;
import com.dinesh.qcqa.z.RecyclerAdapter;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;


public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "log_test";

    public DrawerLayout drawerLayout;
    public ActionBarDrawerToggle actionBarDrawerToggle;
    public Toolbar toolbar;
    NavigationView navigationView;
    FirebaseAuth mAuth;

//    private static final String TAG = "GoogleActivity"; //GOOGLEAUTH
//    private static final int RC_SIGN_IN = 9001; //1
//    private GoogleSignInClient mGoogleSignInClient;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nav_drawer);

        mAuth = FirebaseAuth.getInstance();

        drawerLayout = findViewById(R.id.drawerLayout);
        toolbar = findViewById(R.id.toolbar);
        navigationView = findViewById(R.id.navigationView);

        actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
                R.string.navigation_drawer_open,
                R.string.navigation_drawer_close);

        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        toolbar.setTitle("Ecommerce Store");
        navigationView.setNavigationItemSelectedListener(this);

        toolbar.inflateMenu(R.menu.option_menu);




        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {

                switch (item.getItemId()){
                    case R.id.menu1:
                        Intent intent = new Intent(getApplicationContext(), PaymentActivity.class);
                        startActivity(intent);
                        Toast.makeText(NavigationDrawer.this, "Cart", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.action_search:
//                        toolbar.getMenu().findItem(R.id.menu1).setVisible(false);
                        Toast.makeText(NavigationDrawer.this, "Search", Toast.LENGTH_SHORT).show();


//                        Intent intent = new Intent(getApplicationContext(), com.dinesh.qcqa.z.MainActivity.class);
//                        startActivity(intent);
                        SearchView searchView = (SearchView) item.getActionView();
                        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                            @Override
                            public boolean onQueryTextSubmit(String query) {
                                return false;
                            }

                            @Override
                            public boolean onQueryTextChange(String newText) {

//                                Toast.makeText(NavigationDrawer.this, "searching 123...", Toast.LENGTH_SHORT).show();
                                return false;
                            }
                        });



                        break;
                }
                return false;
            }
        });
    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.option_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu1:
//                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.nav1:
                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav2:
                Toast.makeText(this, "Wish List", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav3:
                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
                break;
            case R.id.nav4:
                Toast.makeText(this, "Orders", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navLogOut:
                mAuth.signOut();
                GoogleSignIn.getClient(
                        getApplicationContext(),
                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
                ).signOut();
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
                finish();
                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}




















//
//public class NavigationDrawer extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
//    private static final String TAG = "log_test";
//
//    FirebaseAuth mAuth;
//
////    private static final String TAG = "GoogleActivity"; //GOOGLEAUTH
////    private static final int RC_SIGN_IN = 9001; //1
////    private GoogleSignInClient mGoogleSignInClient;
//
//    DrawerLayout drawerLayout;
//    Toolbar toolbar;
//    NavigationView navigationView;
//    ImageView imgCart;
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.nav_drawer);
//
//        mAuth = FirebaseAuth.getInstance();
//
//        drawerLayout = findViewById(R.id.drawerLayout);
//        toolbar = findViewById(R.id.toolbar);
//        navigationView = findViewById(R.id.navigationView);
//        imgCart = findViewById(R.id.imgCart);
//
//        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,
//                R.string.navigation_drawer_open,
//                R.string.navigation_drawer_close);
//
//        drawerLayout.addDrawerListener(actionBarDrawerToggle);
//        actionBarDrawerToggle.syncState();
//
////        toolbar.setTitle("Navigation Drawer");
//        toolbar.setTitle("Ecommerce Store");
//        navigationView.setNavigationItemSelectedListener(this);
//
//        imgCart.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(NavigationDrawer.this, "Cart Test", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        MenuInflater menuInflater = getMenuInflater();
//        menuInflater.inflate(R.menu.option_menu,menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        switch (item.getItemId()){
//            case R.id.menu1:
//                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    @Override
//    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//
//        switch (item.getItemId()){
//            case R.id.nav1:
//                Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.nav2:
//                Toast.makeText(this, "Wish List", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.nav3:
//                Toast.makeText(this, "Cart", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.nav4:
//                Toast.makeText(this, "Orders", Toast.LENGTH_SHORT).show();
//                break;
//            case R.id.navLogOut:
//                mAuth.signOut();
//                GoogleSignIn.getClient(
//                        getApplicationContext(),
//                        new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).build()
//                ).signOut();
//                Intent i = new Intent(getApplicationContext(),MainActivity.class);
//                startActivity(i);
//                finish();
//                Toast.makeText(this, "Log Out", Toast.LENGTH_SHORT).show();
//                break;
//        }
//        drawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//    }
//}
//
//
//




//To get the navigation drawer across all activity
//
//    LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
//    //        @SuppressLint("InflateParams")
//    View contentView = inflater.inflate(R.layout.signin_page, null, false);
//        drawerLayout.addView(contentView, 0);
