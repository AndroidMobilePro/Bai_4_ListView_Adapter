package proteam.com.bai_4_listview_adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import proteam.com.bai_4_listview_adapter.listview_coban.ListNormalActivity;
import proteam.com.bai_4_listview_adapter.listview_custom_array.ArrayAdapterActivity;
import proteam.com.bai_4_listview_adapter.listview_custom_base.BaseAdapterActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnListNormal;
    private Button btnListBase;
    private Button btnListArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnListNormal = (Button) findViewById(R.id.btnListNormal);
        btnListBase = (Button) findViewById(R.id.btnBaseAdapter);
        btnListArray = (Button) findViewById(R.id.btnArrayAdapter);

        btnListNormal.setOnClickListener(this);
        btnListBase.setOnClickListener(this);
        btnListArray.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnListNormal:
                Intent intent = new Intent(MainActivity.this, ListNormalActivity.class);
                startActivity(intent);
                break;
            case R.id.btnBaseAdapter:
                Intent intentBase = new Intent(MainActivity.this, BaseAdapterActivity.class);
                startActivity(intentBase);
                break;
            case R.id.btnArrayAdapter:
                Intent intentArray = new Intent(MainActivity.this, ArrayAdapterActivity.class);
                startActivity(intentArray);
                break;
        }
    }
}
