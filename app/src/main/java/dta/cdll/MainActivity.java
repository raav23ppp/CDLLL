package dta.cdll;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentPagerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout=findViewById(R.id.tabs);
        viewPager=findViewById(R.id.viewpager);
        adapter=new FragmentPagerAdapter(getSupportFragmentManager());

        //Añadiendos fragmentos
        adapter.AddFragment(new Fragment_a(),"TOP 10");
        adapter.AddFragment(new Fragment_b(),"B");
        adapter.AddFragment(new Fragment_c(),"C");
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        tabLayout.getTabAt(0).setIcon(R.drawable.ic_star_border_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_search_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_search_black_24dp);

    }
}
