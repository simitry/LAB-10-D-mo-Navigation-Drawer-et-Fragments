package com.example.navigationdrawerlab10; // This line tells Android the package where this class belongs.

import android.os.Bundle; // This import gives access to the Bundle object used by onCreate().
import android.view.MenuItem; // This import gives access to the menu item clicked by the user.

import androidx.annotation.NonNull; // This import marks parameters that should not be null.
import androidx.appcompat.app.ActionBarDrawerToggle; // This import connects the toolbar button to the drawer.
import androidx.appcompat.app.AppCompatActivity; // This import lets MainActivity use AppCompat features.
import androidx.appcompat.widget.Toolbar; // This import gives access to the toolbar from the layout.
import androidx.core.view.GravityCompat; // This import helps close the drawer from the left side.
import androidx.drawerlayout.widget.DrawerLayout; // This import gives access to the drawer layout.
import androidx.fragment.app.Fragment; // This import lets us store any fragment in one variable.

import com.google.android.material.navigation.NavigationView; // This import gives access to the navigation drawer menu view.

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener { // This class is the main screen and listens for drawer menu clicks.

    private DrawerLayout drawerLayout; // This variable stores the drawer so we can open and close it.

    @Override
    protected void onCreate(Bundle savedInstanceState) { // This method runs when the activity is created.
        super.onCreate(savedInstanceState); // This line lets Android do its normal activity setup first.
        setContentView(R.layout.activity_main); // This line loads the main layout that contains the drawer.

        Toolbar toolbar = findViewById(R.id.toolbar); // This line finds the toolbar from the generated layout.
        setSupportActionBar(toolbar); // This line makes the toolbar work as the app action bar.

        drawerLayout = findViewById(R.id.drawer_layout); // This line finds the DrawerLayout from the generated layout.
        NavigationView navigationView = findViewById(R.id.nav_view); // This line finds the NavigationView that shows the menu items.
        navigationView.setNavigationItemSelectedListener(this); // This line tells the menu to send click events to this activity.

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle( // This object creates the drawer button in the toolbar.
                this, // This line passes the current activity to the drawer toggle.
                drawerLayout, // This line passes the drawer that should open and close.
                toolbar, // This line passes the toolbar that will show the drawer button.
                R.string.app_name, // This line provides simple accessibility text for opening the drawer.
                R.string.app_name // This line provides simple accessibility text for closing the drawer.
        );
        drawerLayout.addDrawerListener(toggle); // This line connects the toggle to the drawer.
        toggle.syncState(); // This line updates the toolbar button so it matches the drawer state.

        if (savedInstanceState == null) { // This check makes sure the default fragment is added only the first time.
            replaceFragment(new BlankFragment()); // This line shows Fragment 1 by default.
            navigationView.setCheckedItem(R.id.nav_fragment1); // This line marks "Fragment 1" as selected in the drawer.
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) { // This method runs when the user clicks a drawer item.
        int id = item.getItemId(); // This line stores the id of the clicked menu item.

        if (id == R.id.nav_fragment1) { // This condition checks if the user clicked "Fragment 1".
            replaceFragment(new BlankFragment()); // This line displays Fragment 1 inside the container.
        } else if (id == R.id.nav_fragment2) { // This condition checks if the user clicked "Fragment 2".
            replaceFragment(new BlankFragment2()); // This line displays Fragment 2 inside the container.
        } else if (id == R.id.nav_list) { // This condition checks if the user clicked "Fragment List".
            replaceFragment(new FragmentList()); // This line displays the ListFragment inside the container.
        }

        drawerLayout.closeDrawer(GravityCompat.START); // This line closes the drawer after a menu item is clicked.
        return true; // This line tells Android that the click was handled.
    }

    private void replaceFragment(Fragment fragment) { // This helper method replaces the current fragment with a new one.
        getSupportFragmentManager() // This line gets the fragment manager that controls fragments in this activity.
                .beginTransaction() // This line starts a fragment change.
                .replace(R.id.contenu, fragment) // This line puts the selected fragment inside the FrameLayout container.
                .commit(); // This line applies the fragment change.
    }

    @Override
    public void onBackPressed() { // This method runs when the user presses the Back button.
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) { // This condition checks if the drawer is currently open.
            drawerLayout.closeDrawer(GravityCompat.START); // This line closes the drawer instead of leaving the screen.
        } else { // This block runs when the drawer is already closed.
            super.onBackPressed(); // This line keeps the normal Back button behavior.
        }
    }
}
