package edu.fvtc.checkboxdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {
    public static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CheckBox chkInfo = findViewById(R.id.chkInfo);
        chkInfo.setOnCheckedChangeListener(this);

        initToggleButton();
        this.setTitle("Check Box Demo");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    private void initToggleButton() {
        Button btnToggle = findViewById(R.id.btnToggle);

        btnToggle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckBox chkInfo = findViewById(R.id.chkInfo);

                // Method 1
                //boolean isChecked = chkInfo.isChecked();
                //chkInfo.setChecked(!isChecked);

                // Method 2
                chkInfo.toggle();
            }
        });
    }

    @Override
    public void onCheckedChanged(CompoundButton checkBox, boolean isChecked) {
        Log.d(TAG, "onCheckedChanged: ");

        TextView tvInfo = findViewById(R.id.tvInfo);
        if(isChecked)
        {
            checkBox.setText("Checked");
        }
        else {
            checkBox.setText("Unchecked");
        }
        tvInfo.setText(checkBox.getText());
    }
}