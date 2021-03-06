package kr.co.teada.ex17searchview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //onCreate()메소드 후에 자동실행 메소드
    //액션바에 메뉴를 달고 싶다면 무조건 이 메소드 오버라이드 해야 함
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

//        MenuInflater inflater=getMenuInflater();
//        inflater.inflate(R.menu.actionbar,menu);

        getMenuInflater().inflate(R.menu.actionbar,menu);

        //menu 객체로 부터 searchView를 갖고 있는 MenuItem 객체 얻어오기
        MenuItem item=menu.findItem(R.id.menu_search);
        //MenuItem으로 부터 actionViewClass로 지정된
        //SearchView 얻어오기
        searchView=(SearchView)item.getActionView();

        //힌트 적용
        searchView.setQueryHint("input word");

        //서치뷰에 작성한 글씨 얻어오기
        //서치뷰에 글씨를 변경할 때 마다 자동으로 호출되는 리스너
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            //서치뷰에 글씨 작성할 때 사용하는 소프트 키패드에 돋보기 모양의
            //'완료'버튼이 있음. 이것을 누르면 발동하는 메소드
            @Override
            public boolean onQueryTextSubmit(String s) {
                Toast.makeText(MainActivity.this, s+"를 검색합니다.",Toast.LENGTH_SHORT).show();

                //서치뷰 글씨 지우기
//                searchView.setQuery("",true);
//                searchView.setIconified(true);//돋보기 모양으로 돌아가기
                return false;
            }

            //글씨가 바뀔 때 마다 실행되는 메소드
            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return super.onCreateOptionsMenu(menu);
    }
}
