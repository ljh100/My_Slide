package com.example.my_slide;

import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.my_slide.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener {
    //implements ItemFragment.OnListFragmentInteractionListener  상속된 이부분은
    //프래그먼트가 mainaAC 에 생성될때 자동으로 onAttach 때문인데
    //첨 프래그먼트 만들때 선택,비선택 부분 즉 include interface call,include Frag Factory Method 자동 생성
    //기능을 선택 하여주지 않았으므로 에러 발생 되므로
    //여기서 강제로 onAttach 메서드 를 만들어 주어햐 하므로 ....
    //이 부분을 잘 기억해야 한다다
   @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ViewPater 연결--아답터 이요
        //Fragment manager 필요
        ViewPager viewPager = findViewById(R.id.pager);
        MyPagerAdapter adapter = new MyPagerAdapter(getSupportFragmentManager());
        //pager에 아닶터를 연결한다
        viewPager.setAdapter(adapter);
        //탭에대한 정보 가져오기
       TabLayout tabLayout = findViewById(R.id.tab);
       tabLayout.setupWithViewPager(viewPager);//가져온 탬에 viewpager 를 넣어준다
    }
    //탭은 보이나 제목이 보이질 않는다
    //탭의 제목은 MyAdapter 에서 정의 해 주어야 한다
    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Toast.makeText(this,item.toString(),Toast.LENGTH_SHORT).show();
    }
}
