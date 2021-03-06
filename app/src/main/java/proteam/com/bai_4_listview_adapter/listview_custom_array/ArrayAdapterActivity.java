package proteam.com.bai_4_listview_adapter.listview_custom_array;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import proteam.com.bai_4_listview_adapter.R;
import proteam.com.bai_4_listview_adapter.User;

public class ArrayAdapterActivity extends AppCompatActivity {
    private CustomArrayAdapter mCustomArrayAdapter;
    private List<User> mUsers;
    private EditText mEdTitle;
    private EditText mEdContent;
    private ListView mLvMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listview_custom);

        mLvMain= (ListView) findViewById(R.id.lvArray);
        mEdContent = (EditText) findViewById(R.id.edtContent);
        mEdTitle = (EditText) findViewById(R.id.edtTitle);

        mUsers = new ArrayList<>();

        mUsers.add(new User("SamSung", "aaaaaaaaaaa"));
        mUsers.add(new User("SamSung1", "aaaaaaaaaaa1"));
        mUsers.add(new User("SamSung2", "aaaaaaaaaaa2"));
        mUsers.add(new User("SamSung3", "aaaaaaaaaaa3"));
        mUsers.add(new User("SamSung4", "aaaaaaaaaaa4"));
        mUsers.add(new User("SamSung5", "aaaaaaaaaaa5"));
        mUsers.add(new User("SamSung6", "aaaaaaaaaaa6"));
        mUsers.add(new User("SamSung7", "aaaaaaaaaaa7"));
        mUsers.add(new User("SamSung8", "aaaaaaaaaaa8"));
        mUsers.add(new User("SamSung9", "aaaaaaaaaaa9"));
        mUsers.add(new User("SamSung10", "aaaaaaaaaaa10"));
        mUsers.add(new User("SamSung11", "aaaaaaaaaaa11"));
        mUsers.add(new User("SamSung12", "aaaaaaaaaaa12"));
        mUsers.add(new User("SamSung13", "aaaaaaaaaaa13"));

        // android.R.layout.simple_list_item_1: Là một hằng số Layout định nghĩa sẵn của Android
        // ý nghĩa của nó là ListView với ListItem đơn giản (Duy nhất một TextView).

        mCustomArrayAdapter = new CustomArrayAdapter(this, mUsers);
        mLvMain.setAdapter(mCustomArrayAdapter);

        //click item listview
        mLvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                User user = (User) parent.getItemAtPosition(position);
                Toast.makeText(ArrayAdapterActivity.this, user.getTitle() + "--" + user.getContent(), Toast.LENGTH_LONG).show();
            }
        });

        mLvMain.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                showAlertDialog(position);
                return false;
            }
        });
        mLvMain.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                Toast.makeText(ArrayAdapterActivity.this, "Scroll", Toast.LENGTH_LONG).show();
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
        //click add
        ((Button) findViewById(R.id.btnAdd)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(mEdTitle.getText().toString().equals("")||mEdContent.getText().toString().equals("")){
                    Toast.makeText(ArrayAdapterActivity.this, "Please input valid data!!", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    mUsers.add(new User(mEdTitle.getText().toString().trim(), mEdContent.getText().toString().trim()));
                    mCustomArrayAdapter.notifyDataSetChanged();
                }
            }
        });

    }

    private void showAlertDialog(final int position) {
        AlertDialog.Builder builder1 = new AlertDialog.Builder(ArrayAdapterActivity.this);
        builder1.setTitle("Confirm Delete");
        builder1.setMessage("Do you want delete item!!");
        builder1.setCancelable(true);

        builder1.setPositiveButton(
                "Yes",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        mUsers.remove(position);
                        mCustomArrayAdapter.notifyDataSetChanged();
                        dialog.cancel();
                    }
                });

        builder1.setNegativeButton(
                "No",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });

        AlertDialog alert11 = builder1.create();
        alert11.show();
    }
}
