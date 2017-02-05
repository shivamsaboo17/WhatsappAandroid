package com.example.shivam.whatsappui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Base64;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_Activity extends AppCompatActivity {

    //private TextView name;
    //private TextView message;
    //private TextView time;

    RecyclerView rv;
    ProgressBar pg;

    ArrayList<Contents> coList = new ArrayList<>();

    ArrayList<String> nameList ;
    ArrayList<String> messageList ;
    ArrayList<String> timeList ;
    ArrayList<Bitmap> imgList ;
//    Contents co;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);
        nameList=new ArrayList<>();
        pg = (ProgressBar)findViewById(R.id.progressBar2);
        pg.setVisibility(View.VISIBLE);
        messageList=new ArrayList<>();
        timeList=new ArrayList<>();
        imgList=new ArrayList<>();
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //name = (TextView)findViewById(R.id.textView);
        //message = (TextView)findViewById(R.id.textView2);
        //time = (TextView)findViewById(R.id.textView3);

        rv = (RecyclerView) findViewById(R.id.rvPanel);


        RecyclerView.LayoutManager lm = new LinearLayoutManager(Main_Activity.this);
        rv.setLayoutManager(lm);

        String s = new String();
        s = ReadFromfile("content.json", Main_Activity.this);
        convertToJSONData(s);


    }

    public String ReadFromfile(String fileName, Context context) {
        StringBuilder returnString = new StringBuilder();
        InputStream fIn = null;
        InputStreamReader isr = null;
        BufferedReader input = null;
        try {
            fIn = context.getResources().getAssets()
                    .open(fileName, Context.MODE_WORLD_READABLE);
            isr = new InputStreamReader(fIn);
            input = new BufferedReader(isr);
            String line = "";
            while ((line = input.readLine()) != null) {
                returnString.append(line);
            }
        } catch (Exception e) {
            e.getMessage();
        } finally {
            try {
                if (isr != null)
                    isr.close();
                if (fIn != null)
                    fIn.close();
                if (input != null)
                    input.close();
            } catch (Exception e2) {
                e2.getMessage();
            }
        }
        return returnString.toString();
    }

    public void convertToJSONData(String s) {
        try {

            JSONObject mainObject = new JSONObject(s);
            JSONObject contentData = mainObject.getJSONObject("contentData");
            JSONArray androidList = contentData.getJSONArray("androidList");


            for (int i = 0; i < androidList.length(); i++) {

//                co = new Contents();
                JSONObject currentObject = androidList.getJSONObject(i);
                String androidName = currentObject.getString("androidName");
                String message = currentObject.getString("message");
                String time = currentObject.getString("time");
               // String url = currentObject.getString("url");
                nameList.add(androidName);
                messageList.add(message);
                timeList.add(time);
  //              co.setMessage(message);
      //          co.setTime(time);
    //            co.setTitle(androidName);
        //        coList.add(co);

            }
            new JSONTask().execute(androidList.toString());

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public class JSONTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            HttpURLConnection connection = null;
            try {
                JSONArray androidList=new JSONArray(params[0]);
                for (int i=0;i<androidList.length();i++){
                    JSONObject currentObject = androidList.getJSONObject(i);
                    URL url = new URL(currentObject.getString("url"));
                    connection = (HttpURLConnection) url.openConnection();
                    connection.connect();

                    InputStream stream = connection.getInputStream();

                    Bitmap bmp = BitmapFactory.decodeStream(stream);
                    imgList.add(bmp);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
             finally {
                if (connection != null)
                    connection.disconnect();
            }

            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            pg.setVisibility(View.INVISIBLE);

            Log.e("ïmglist",imgList.toString());
            PanelAdapter pa = new PanelAdapter(Main_Activity.this,nameList,messageList,timeList,imgList);
            rv.setAdapter(pa);
  //          co.setD(bitmap);


        }

    }

    public String getStringFromBitmap(Bitmap bmp) {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bmp.compress(Bitmap.CompressFormat.JPEG, 50, baos);
        byte[] imageBytes = baos.toByteArray();
        return Base64.encodeToString(imageBytes, Base64.DEFAULT);
    }

    public Bitmap getBitmapFromString(String str) {
        byte[] encodeByte = Base64.decode(str, Base64.DEFAULT);
        Bitmap bitmap = BitmapFactory.decodeByteArray(encodeByte, 0, encodeByte.length);
        return bitmap;
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