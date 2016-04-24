package com.okhi.hotpoint;

import android.media.Image;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button progressBtn, progressBtn2;
    private AutoCompleteTextView autoCompleteTextView, autoCompleteTextView2;
    private String customerNameStr,phoneNumberStr,selectedNeighborhood,buildingnameStr
            ,unitnumberStr, selectedRoad,otherdetailsStr;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customername);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        //cl = (CoordinatorLayout)findViewById(R.id.mainlayout);
/*
        for(int i = 0;i<cl.getChildCount(); i++){

            Log.v("mainactivity1", "oncreate, "+cl.getChildAt(i).getId());

            Log.v("mainactivity2", "oncreate, "+i);

            Log.v("mainactivity3", "oncreate, "+cl.getChildAt(i).toString());
        }

        rl = (RelativeLayout)findViewById(cl.getChildAt(0).getId());
        viewGroupLayoutParams = rl.getLayoutParams();

        */
        progressBtn = (Button)findViewById(R.id.button) ;
        progressBtn.setOnClickListener(buttonhandler);
        //rl = (RelativeLayout) findViewById(R.id.customernamelayout);


        //cl.removeViewAt(0);
        //cl.addView(rl, 0);



        //progress = (Button) findViewById();

/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        */
    }

    private void customername(){

        EditText editext = (EditText)findViewById(R.id.editText);
        customerNameStr = editext.getText().toString().trim();

        if(customerNameStr.length()<1){
            Toast.makeText(this,getString(R.string.errcustomername),Toast.LENGTH_LONG).show();
        }
        else{

            setContentView(R.layout.phonenumber);
            progressBtn = (Button)findViewById(R.id.button2);
            progressBtn.setOnClickListener(buttonhandler);

        }
    }

    private void phonenumber(){

        EditText editext = (EditText)findViewById(R.id.editText);
        phoneNumberStr = editext.getText().toString().trim();

        if(phoneNumberStr.length()<1){
            Toast.makeText(this,getString(R.string.errphonenumber),Toast.LENGTH_LONG).show();
        }
        else{

            setContentView(R.layout.neighbourhood);
            progressBtn = (Button)findViewById(R.id.button3);
            progressBtn.setOnClickListener(buttonhandler);
            autoCompleteTextView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);

            String[] neighborhoods = {"Amboseli","Lavington","Kileleshwa","Kilimani","Riverside"};


            adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    R.layout.autocompletelist, neighborhoods);


            autoCompleteTextView.setThreshold(1);
            autoCompleteTextView.setAdapter(adapter);


            autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    selectedNeighborhood = parent.getItemAtPosition(position).toString();

                    Toast.makeText(getApplicationContext(),selectedNeighborhood,Toast.LENGTH_LONG).show();

                }

            });

        }

    }

    private void neighbourhood(){

        //EditText editext = (EditText)findViewById(R.id.editText);
        //customerNameStr = editext.getText().toString().trim();

        if(selectedNeighborhood.length()<1){
            Toast.makeText(this,getString(R.string.errneighborhood),Toast.LENGTH_LONG).show();
        }
        else{
            setContentView(R.layout.buildingname);
            progressBtn = (Button)findViewById(R.id.button4);
            progressBtn.setOnClickListener(buttonhandler);

        }

    }
    private void buildingname(){

        EditText editext = (EditText)findViewById(R.id.editText);
        buildingnameStr = editext.getText().toString().trim();

        if(buildingnameStr.length()<1){
            Toast.makeText(this,getString(R.string.errbuildingname),Toast.LENGTH_LONG).show();
        }
        else{
            setContentView(R.layout.unitnamenumber);
            progressBtn = (Button)findViewById(R.id.button5);
            progressBtn.setOnClickListener(buttonhandler);

        }

    }

    private void unitnumber(){

        EditText editext = (EditText)findViewById(R.id.editText);
        unitnumberStr = editext.getText().toString().trim();

        if(unitnumberStr.length()<1){
            Toast.makeText(this,getString(R.string.errunitnumber),Toast.LENGTH_LONG).show();
        }
        else{
            setContentView(R.layout.roadname);
            progressBtn = (Button)findViewById(R.id.button6);
            progressBtn.setOnClickListener(buttonhandler);

            autoCompleteTextView2 = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView2);

            String[] roadnames = {"Thigiri Ridge Road","Thigiri Avenue","Thigiri Other Road"};


            adapter = new ArrayAdapter<String>(
                    getApplicationContext(),
                    R.layout.autocompletelist, roadnames);


            autoCompleteTextView2.setThreshold(1);
            autoCompleteTextView2.setAdapter(adapter);


            autoCompleteTextView2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    selectedRoad = parent.getItemAtPosition(position).toString();

                    Toast.makeText(getApplicationContext(),selectedRoad,Toast.LENGTH_LONG).show();

                }

            });

        }

    }

    private void otherdetails(){

        //EditText editext = (EditText)findViewById(R.id.editText2);
        //otherdetailsStr = editext.getText().toString().trim();

        if(selectedRoad.length()<1){
            Toast.makeText(this,getString(R.string.errroad),Toast.LENGTH_LONG).show();
        }
        else{
            setContentView(R.layout.otherdetails);
            progressBtn = (Button)findViewById(R.id.button7);
            progressBtn.setOnClickListener(buttonhandler);

        }

    }

    private void confirmation(){
        EditText editext = (EditText)findViewById(R.id.editText2);
        otherdetailsStr = editext.getText().toString().trim();

        if(otherdetailsStr.length()<1){
            Toast.makeText(this,getString(R.string.errotherdetails),Toast.LENGTH_LONG).show();
        }
        else{
            setContentView(R.layout.confirmation);
            TextView textView2 = (TextView) findViewById(R.id.textView2);
            textView2.setText(customerNameStr);
            TextView textView3 = (TextView) findViewById(R.id.textView3);
            textView3.setText(phoneNumberStr);
            TextView textView4 = (TextView) findViewById(R.id.textView4);
            textView4.setText(unitnumberStr+" "+buildingnameStr);
            TextView textView5 = (TextView) findViewById(R.id.textView5);
            textView5.setText(selectedRoad);
            ImageView imageView = (ImageView) findViewById(R.id.imageView);
            imageView.setImageDrawable(getResources().getDrawable(R.drawable.ramogi));
            progressBtn = (Button)findViewById(R.id.button8);
            progressBtn.setOnClickListener(buttonhandler);

        }

    }

    private void save(){
        setContentView(R.layout.save);
        progressBtn = (Button)findViewById(R.id.button9);
        progressBtn.setOnClickListener(buttonhandler);
        progressBtn2 = (Button)findViewById(R.id.button10);
        progressBtn2.setOnClickListener(buttonhandler);

    }

    private void thanks(){
        setContentView(R.layout.thanks);

    }


    View.OnClickListener buttonhandler = new View.OnClickListener() {
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button:
                    customername();
                    break;
                case R.id.button2:
                    phonenumber();
                    break;
                case R.id.button3:
                    neighbourhood();
                    break;
                case R.id.button4:
                    buildingname();
                    break;
                case R.id.button5:
                    unitnumber();
                    break;
                case R.id.button6:
                    otherdetails();
                    break;
                case R.id.button7:
                    confirmation();
                    break;
                case R.id.button8:
                    save();
                    break;
                case R.id.button9:
                    thanks();
                    break;
                case R.id.button10:
                    thanks();
                    break;
                default:
                    Log.v("buttonhandler", " gosh, no matches");

            }

        }
    };

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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
