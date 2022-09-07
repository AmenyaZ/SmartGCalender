//package com.amenyaz.smartgcalender
//
//import android.os.Bundle
//import android.util.Log
//import android.view.View
//import android.widget.TextView
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.FragmentManager
//import androidx.fragment.app.FragmentStatePagerAdapter
//import androidx.viewpager.widget.ViewPager
//import androidx.viewpager.widget.ViewPager.OnPageChangeListener
//import com.amenyaz.gcalender.YearFragment
//import com.amenyaz.gcalender.event.EventInfo
//import com.amenyaz.gcalender.month.MonthFragment
//import com.amenyaz.gcalender.month.MonthModel
//import org.joda.time.LocalDate
//
//class MainActivity : AppCompatActivity() {
//    private val monthviewpager: ViewPager? = null
//    private val monthModels: ArrayList<MonthModel>? = null
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        yearInit()
//        val i = 4
//        val monthname = findViewById<TextView>(R.id.yeartext)
////        if (monthviewpager!!.visibility == View.GONE) return
//        Log.e("selected", i.toString() + "")
//        val localDate = LocalDate()
//        val monthPageAdapter = monthviewpager?.adapter as MonthPageAdapter
//        val monthModel = monthPageAdapter.getMonthModels()[i]
//        val year =
//            if (monthModel.year === localDate.year) "" else monthModel.year.toString() + ""
//        monthname.setText(monthModel.monthnamestr.toString() + " " + year)
//
//
//    }
//    private fun yearInit() {
//        val viewPager = findViewById<ViewPager>(R.id.yearpager)
//        val yeartextView = findViewById<TextView>(R.id.yeartext)
//        viewPager.addOnPageChangeListener(object : OnPageChangeListener {
//            override fun onPageScrolled(
//                position: Int,
//                positionOffset: Float,
//                positionOffsetPixels: Int
//            ) {
//                Log.d("", "")
//            }
//
//            override fun onPageSelected(position: Int) {
//                yeartextView.text = String.format("%d", 2022 + position)
//            }
//
//            override fun onPageScrollStateChanged(state: Int) {}
//        })
//        viewPager.adapter = YearPageAdapter(supportFragmentManager)
//    }
//    inner class mlastdate(){
//        fun getlastdate(): LocalDate? {
//            return LocalDate.now()
//        }
//    }
//    internal class YearPageAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
//        override fun getItem(position: Int): Fragment {
//            return YearFragment.newInstance(2022 + position)
//        }
//
//        override fun getCount(): Int {
//            return 30
//        }
//    }
//    internal class MonthPageAdapter(
//        fragmentManager: FragmentManager?,
//        monthModels: ArrayList<MonthModel>,
//        singleitemheight: Int
//    ) : FragmentStatePagerAdapter(fragmentManager!!) {
//        private val monthModels: ArrayList<MonthModel>
//        private val singleitemheight: Int
//        private val alleventlist: HashMap<LocalDate, EventInfo>? = null
//        private val montheventlist: HashMap<LocalDate, EventInfo>? = null
//
//        //        public ArrayList<MonthFragment> getFirstFragments() {
//        //            return firstFragments;
//        //        }
//        fun getMonthModels(): ArrayList<MonthModel> {
//            return monthModels
//        }
//
//        // Returns total number of pages
//        override fun getCount(): Int {
//            return monthModels.size
//        }
//
//        // Returns the fragment to display for that page
//        override fun getItem(position: Int): Fragment {
//           return MonthFragment.newInstance(
//                monthModels[position].month,
//                monthModels[position].year,
//                monthModels[position].firstday,
//                monthModels[position].dayModelArrayList,
//                alleventlist,
//                singleitemheight,
//                montheventlist
//            )
//        }
//
//        // private ArrayList<MonthFragment> firstFragments=new ArrayList<>();
//        init {
//            this.monthModels = monthModels
//            this.singleitemheight = singleitemheight
//
////            for (int position=0;position<monthModels.size();position++){
////                firstFragments.add(MonthFragment.newInstance(monthModels.get(position).getMonth(), monthModels.get(position).getYear(), monthModels.get(position).getFirstday(), monthModels.get(position).getDayModelArrayList(), alleventlist, singleitemheight));
////            }
//        }
//    }
//
//}