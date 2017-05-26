package wil.rutascbba.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

import wil.rutascbba.R;
import wil.rutascbba.fragment.FragmentDesIda;
import wil.rutascbba.fragment.FragmentDesVuelta;

public class DescripcionActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;
    Bundle bundle;
    String titulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_descripcion);
        toolbar = (Toolbar) findViewById(R.id.toolbar_des);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewPager = (ViewPager) findViewById(R.id.view_pager_des);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs_des);
        tabLayout.setupWithViewPager(viewPager);

        bundle = getIntent().getExtras();
        titulo = bundle.getString("titulo");
        setTitle(titulo);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragment(new FragmentDesIda(),   "IDA");
        viewPagerAdapter.addFragment(new FragmentDesVuelta(),"RETORNO");
        viewPager.setAdapter(viewPagerAdapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter{
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();
        public ViewPagerAdapter(FragmentManager manager){
            super(manager);
        }
        public  Fragment getItem(int position){
            return  mFragmentList.get(position);
        }
        public  int getCount(){
            return mFragmentList.size();
        }
        public  void addFragment(Fragment fragment, String titulo){
            mFragmentList.add(fragment);
            mFragmentTitleList.add(titulo);
        }
        public CharSequence getPageTitle(int position){
            return mFragmentTitleList.get(position);
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        switch (item.getItemId()) {
            case android.R.id.home:
                /**Intent intent = new Intent(this, MapsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.putExtra("titulo", titulo);
                startActivity(intent);*/
                finish();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
