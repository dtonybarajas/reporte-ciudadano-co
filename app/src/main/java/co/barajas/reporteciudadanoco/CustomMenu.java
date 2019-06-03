package co.barajas.reporteciudadanoco;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.view.animation.ScaleAnimation;
import android.widget.TextView;

import co.barajas.reporteciudadanoco.view.Login;
import co.barajas.reporteciudadanoco.view.MainActivity;
import co.barajas.reporteciudadanoco.view.Report;


public class CustomMenu implements View.OnClickListener {

    TextView tvSeeReport;
    TextView tvReport;
    TextView tvLogout;

    Activity activity;
    DrawerLayout menu;
    View lyMenu;
    View lyGeneral;
    int selectedMenuItem;
    float offsetAnterior = 0f;

    public CustomMenu(Activity activity, DrawerLayout menu,
                      View lyMenu, View lyGeneral, int selectedMenuItem) {
        this.activity = activity;
        this.menu = menu;
        this.lyMenu = lyMenu;
        this.lyGeneral = lyGeneral;
        this.selectedMenuItem = selectedMenuItem;
        init();
    }

    private void init() {
        tvSeeReport = (TextView) lyMenu.findViewById(R.id.tvSeeReport);
        tvReport = (TextView) lyMenu.findViewById(R.id.tvReport);
        tvLogout = (TextView) lyMenu.findViewById(R.id.tvLogout);

        ActionBarDrawerToggle mDrawerToggle = new ActionBarDrawerToggle(activity, menu, null, R.string.app_name, R.string.app_name) {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                super.onDrawerSlide(drawerView, slideOffset);
                ScaleAnimation fadeIn = new ScaleAnimation(1f, 1.9f, 1f, 1f);
                fadeIn.setFillAfter(true);
                lyGeneral.setTranslationX(slideOffset * drawerView.getWidth());
                lyGeneral.setTranslationY(slideOffset * 100);
                menu.bringChildToFront(drawerView);
                menu.requestLayout();
                offsetAnterior = slideOffset;
            }
        };
        menu.addDrawerListener(mDrawerToggle);

        setListeners();
    }

    private void setListeners() {
        tvSeeReport.setOnClickListener(this);
        tvReport.setOnClickListener(this);
        tvLogout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent intent;
        switch (v.getId()) {
            case R.id.tvSeeReport:
                intent = new Intent(activity, MainActivity.class);
                activity.startActivity(intent);
                activity.finish();
                break;
            case R.id.tvReport:
                intent = new Intent(activity, Report.class);
                activity.startActivity(intent);
                activity.finish();
                break;
            case R.id.tvLogout:
                intent = new Intent(activity, Login.class);
                activity.startActivity(intent);
                activity.finish();
                break;
        }
    }
}
