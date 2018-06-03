package proteam.com.bai_4_listview_adapter.listview_coban;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import proteam.com.bai_4_listview_adapter.R;

public class ListNormalActivity extends AppCompatActivity {
    private ListView mLvList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_normal);
        mLvList = (ListView) findViewById(R.id.lvList);
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            stringList.add(String.format("%s%d", "Phan tu thu:", i));
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, stringList);
        mLvList.setAdapter(arrayAdapter);
    }
}