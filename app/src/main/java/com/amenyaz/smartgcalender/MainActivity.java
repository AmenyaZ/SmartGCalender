package com.amenyaz.smartgcalender;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.amenyaz.gcalender.YearFragment;
import com.amenyaz.gcalender.event.EventInfo;
import com.amenyaz.gcalender.month.MonthFragment;
import com.amenyaz.gcalender.month.MonthModel;

import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private ViewPager monthviewpager;
    private TextView monthname;
    public static LocalDate lastdate = LocalDate.now();
    private HashMap<LocalDate, EventInfo> alleventlist;
    private HashMap<LocalDate, EventInfo> montheventlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        monthname = findViewById(R.id.yeartext);
        monthviewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {
            }


            @Override
            public void onPageSelected(int i) {

                if (monthviewpager.getVisibility() == View.GONE) return;

                    Log.e("selected", i + "");
                    LocalDate localDate = new LocalDate();
                    MonthPageAdapter monthPageAdapter = (MonthPageAdapter) monthviewpager.getAdapter();
                    MonthModel monthModel = monthPageAdapter.getMonthModels().get(i);
                    String year = monthModel.getYear() == localDate.getYear() ? "" : monthModel.getYear() + "";
                    monthname.setText(monthModel.getMonthnamestr() + " " + year);
                    MainActivity.lastdate = new LocalDate(monthModel.getYear(), monthModel.getMonth(), 1);
                    // EventBus.getDefault().post(new MessageEvent(new LocalDate(monthModel.getYear(),monthModel.getMonth(),1)));
                    // if (monthChangeListner!=null)monthChangeListner.onmonthChange(myPagerAdapter.monthModels.get(position));

            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

    }

    class MonthPageAdapter extends FragmentStatePagerAdapter {
        private ArrayList<MonthModel> monthModels;
        private int singleitemheight;

        // private ArrayList<MonthFragment> firstFragments=new ArrayList<>();

        public MonthPageAdapter(FragmentManager fragmentManager, ArrayList<MonthModel> monthModels, int singleitemheight) {

            super(fragmentManager);
            this.monthModels = monthModels;
            this.singleitemheight = singleitemheight;

//            for (int position=0;position<monthModels.size();position++){
//                firstFragments.add(MonthFragment.newInstance(monthModels.get(position).getMonth(), monthModels.get(position).getYear(), monthModels.get(position).getFirstday(), monthModels.get(position).getDayModelArrayList(), alleventlist, singleitemheight));
//            }
        }

//        public ArrayList<MonthFragment> getFirstFragments() {
//            return firstFragments;
//        }

        public ArrayList<MonthModel> getMonthModels() {
            return monthModels;
        }

        // Returns total number of pages
        @Override
        public int getCount() {
            return monthModels.size();
        }


        // Returns the fragment to display for that page
        @Override
        public Fragment getItem(int position) {
            try {
                return MonthFragment.newInstance(monthModels.get(position).getMonth(), monthModels.get(position).getYear(), monthModels.get(position).getFirstday(), monthModels.get(position).getDayModelArrayList(), alleventlist, singleitemheight, montheventlist);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
                return null;

            }
        }


    }

    class YearPageAdapter extends FragmentStatePagerAdapter {
        public YearPageAdapter(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            return YearFragment.newInstance(2000 + position);
        }

        @Override
        public int getCount() {
            return 30;
        }
    }

}
