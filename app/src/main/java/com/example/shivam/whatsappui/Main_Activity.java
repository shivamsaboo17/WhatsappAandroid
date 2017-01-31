package com.example.shivam.whatsappui;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Activity extends AppCompatActivity {

    private TextView name;
    private TextView message;
    private TextView time;

    RecyclerView rv;

    ArrayList<String> nameList = new ArrayList<>();
    ArrayList<String> messageList = new ArrayList<>();
    ArrayList<String> timeList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        name = (TextView)findViewById(R.id.textView);
        message = (TextView)findViewById(R.id.textView2);
        time = (TextView)findViewById(R.id.textView3);

        rv = (RecyclerView)findViewById(R.id.rvPanel);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(Main_Activity.this);
        rv.setLayoutManager(lm);

        nameList.add("a");
        nameList.add("b");
        nameList.add("c");
        nameList.add("d");
        nameList.add("e");
        nameList.add("f");
        nameList.add("g");
        nameList.add("h");
        nameList.add("i");
        nameList.add("j");
        nameList.add("k");

        messageList.add("abc");
        messageList.add("abcd");
        messageList.add("abcde");
        messageList.add("abcdef");
        messageList.add("abcdefg");
        messageList.add("jene nhi dunga");
        messageList.add("paida nhi hone dunga");
        messageList.add("paida hoke dika");
        messageList.add("agle jaman me marunga");
        messageList.add("sun the surya");
        messageList.add("ug gandu");

        timeList.add("12:30");
        timeList.add("13:30");
        timeList.add("14:30");
        timeList.add("15:30");
        timeList.add("16:30");
        timeList.add("17:30");
        timeList.add("18:30");
        timeList.add("19:30");
        timeList.add("20:30");
        timeList.add("21:30");
        timeList.add("22:30");

        PanelAdapter pan = new PanelAdapter(Main_Activity.this,nameList,messageList,timeList);
        rv.setAdapter(pan);







    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
