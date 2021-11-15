package com.project.listviewarrayadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Button button;
    Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setTitle("ListViewArrayAdapter");

        listView = (ListView)findViewById(R.id.listView);
        listView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);

        ArrayList<String> smartPhone = new ArrayList<String>();
        smartPhone.add("Android");
        smartPhone.add("iOS");
        smartPhone.add("Windows Phone");

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_checked,smartPhone);

        listView.setAdapter(adapter);

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(btnClick);
    }

    Button.OnClickListener btnClick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(toast != null){
                toast.cancel();
            }
            Toast.makeText(MainActivity.this,"選取：" + (listView.getCheckedItemPosition() + 1),Toast.LENGTH_SHORT).show();
        }
    };
}
