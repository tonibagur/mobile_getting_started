package com.example.coneptum.sidemenu;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    private static Toolbar toolbar;
    private DrawerLayout drawer;
    private ListView drawerList;
    private boolean mainShown = true;
    // private ActionBarDrawerToggle toggle;

    public static Toolbar getToolbar() {
        return toolbar;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String[] items = getResources().getStringArray(R.array.menu);

        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        drawerList = (ListView) findViewById(R.id.drawer_list);
        /* Creating an ArrayAdapter to add items to mDrawerList */
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, items);
        /* Setting the adapter to mDrawerList */
        drawerList.setAdapter(adapter);
        // Setting item click listener for the listview mDrawerList
        drawerList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                selectItem(position);
                drawer.closeDrawer(Gravity.RIGHT);

            }
        });

        ImageButton menu = (ImageButton) findViewById(R.id.menuButton);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawer.isDrawerOpen(Gravity.RIGHT)) {
                    drawer.closeDrawer(Gravity.RIGHT);
                    ((ImageButton) v).setImageResource(R.drawable.ic_drawer);
                } else {
                    drawer.openDrawer(Gravity.RIGHT);
                    ((ImageButton) v).setImageResource(R.drawable.ic_back_drawer);
                }
            }
        });
        drawer.setDrawerListener(new DrawerLayout.DrawerListener() {

            ImageButton menu = (ImageButton) findViewById(R.id.menuButton);

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {
                menu.setImageResource(R.drawable.ic_back_drawer);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                menu.setImageResource(R.drawable.ic_drawer);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });


    }

  /*  public void selectItem(int position) {
        Intent intent = null;
        switch (position) {
            case 0:
                intent = new Intent(this, Option1.class);
                break;
            case 1:
                intent = new Intent(this, Option2.class);
                break;
            case 2:
                intent = new Intent(this, Option3.class);
                break;
            default:
                break;
        }

        startActivity(intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION));
    }*/

    public void selectItem(int position) {

        Fragment fragment = null;

        switch (position) {
            case 0:
                fragment = new Home();
                mainShown=true;
                break;
            case 1:
                fragment = new Option1();
                mainShown = false;
                break;
            case 2:
                fragment = new Option2();
                mainShown = false;
                break;
            case 3:
                fragment = new Option3();
                mainShown = false;
                break;
            default:

                break;
        }

        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content, fragment, "NewFragmentTag").addToBackStack(null);
        ft.commit();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(Gravity.RIGHT)) {
            drawer.closeDrawer(Gravity.RIGHT);
        } else {
            if (!mainShown) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.content, new Home(), "NewFragmentTag").addToBackStack(null);
                ft.commit();
                mainShown = true;
            } else {
                super.onBackPressed();
            }
        }
    }

}

