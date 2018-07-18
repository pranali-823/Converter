package firstmvcproject.com.converter;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.*;

public class Conv extends AppCompatActivity {
    Button btn;
    TextView tv;
    EditText edt;
    Spinner sp1;
    String choice;
    String[] items = new String[3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conv);
        btn = (Button) findViewById(R.id.button1);
        tv = (TextView) findViewById(R.id.textView);
        edt = (EditText) findViewById(R.id.editText);
        sp1 = (Spinner) findViewById(R.id.spinner);
        LinearLayout l1 = (LinearLayout) findViewById(R.id.linLayout);
        Button[] btns = new Button[10];
        for (int i = 0; i < 10; i++){
            final Button b1 = new Button(this);
            b1.setText("Dynamic Button "+i);
            b1.setWidth(l1.getWidth());
            b1.setHeight(30);
            l1.addView(b1);
            b1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    edt.setText(b1.getText());
                }
            });
            btns[i] = b1;
        }

        btns[2].setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"This is third Button",Toast.LENGTH_LONG).show();
            }
        });

        //Creating Array Adaptor with items from String-Array resource
        ArrayAdapter adt = ArrayAdapter.createFromResource(this, R.array.options, android.R.layout.simple_spinner_item);

        //Creating Dynamic Array
        items[0] = "KB to MB";
        items[1] = "KB to B";
        items[2] = "KB to GB";
        ArrayAdapter adt2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, items);

        sp1.setAdapter(adt2);

        sp1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                //For Spinner Elements from Resources
                //Log.d("Selected Position", String.valueOf(getResources().getStringArray(R.array.options)[position]));
                //choice = String.valueOf(getResources().getStringArray(R.array.options)[position]);

                //For Spinner Elements from Array
                choice = items[position];
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double kb;
                kb=Double.parseDouble(edt.getText().toString());
                double d = Num.convert(kb, choice);
                tv.setText(""+d);
            }
        });
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
