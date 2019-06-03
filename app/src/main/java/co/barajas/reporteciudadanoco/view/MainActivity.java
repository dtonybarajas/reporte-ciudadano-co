package co.barajas.reporteciudadanoco.view;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;


import co.barajas.reporteciudadanoco.CustomMenu;
import co.barajas.reporteciudadanoco.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    DrawerLayout drawerMain;
    Toolbar toolbar;
    LinearLayout lateralMenu;

    ImageView ivMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ivMenu = (ImageView) findViewById(R.id.ivMenu);
        ivMenu.setOnClickListener(this);
        drawerMain = (DrawerLayout) findViewById(R.id.drawerMain);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        lateralMenu = (LinearLayout) findViewById(R.id.lateralMenu);

        CustomMenu customMenu = new CustomMenu(this, drawerMain, lateralMenu, toolbar, 1);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ivMenu:
                drawerMain.openDrawer(lateralMenu);
                break;
        }
    }
}
