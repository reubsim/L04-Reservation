package sg.edu.rp.c346.id21019352.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    EditText etName;
    EditText etPhone;
    EditText etPax;
    DatePicker dp;
    TimePicker tp;
    ToggleButton tbOption;
    Button btnConfirm;
    TextView tvName;
    TextView tvPhone;
    TextView tvPax;
    TextView tvOption;
    TextView tvDate;
    TextView tvTime;
    Button btnSubmit;
    Button btnReset;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etPhone = findViewById(R.id.editTextPhone);
        etPax= findViewById(R.id.editTextPax);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tbOption = findViewById(R.id.toggleButtonSmoking);
        btnConfirm = findViewById(R.id.buttonConfirm);
        btnSubmit = findViewById(R.id.buttonSubmit);
        btnReset = findViewById(R.id.buttonReset);
        tvName = findViewById(R.id.textViewName);
        tvPhone = findViewById(R.id.textViewPhone);
        tvPax = findViewById(R.id.textViewPax);
        tvOption = findViewById(R.id.textViewSmoking);
        tvDate = findViewById(R.id.textViewDate);
        tvTime = findViewById(R.id.textViewTime);

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {



                String name = etName.getText().toString();
                String phone = etPhone.getText().toString();
                String pax = etPax.getText().toString();

                int dateDay = dp.getDayOfMonth();
                int dateMonth = dp.getMonth() + 1;
                int dateYear = dp.getYear();
                String dateString = dateMonth + "/" + dateDay + "/" + dateYear;

                int timeHour = tp.getCurrentHour();
                int timeMinute = tp.getCurrentMinute();
                String minuteString = "";
                String hourString = "";
                String timeString = "";

                String option = "Non-Smoking";

                if (timeMinute < 10) {
                    minuteString = "0" + timeMinute;
                } else {
                    minuteString = "" + timeMinute;
                }
                if (timeHour < 10) {
                    hourString = "0" + timeHour;
                } else {
                    hourString = "" + timeHour;
                }

                if (tbOption.isChecked() == true) {
                    option = "Smoking";
                }

                timeString = hourString + ":" + minuteString;


                tvName.setText("Name: " + name);
                tvPhone.setText("Phone Number: " + phone);
                tvPax.setText("Size of Group: " + pax);
                tvOption.setText(option);
                tvDate.setText("Date: " + dateString);
                tvTime.setText("Time: " + timeString);

            }
        });

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast toastMessage = Toast.makeText(MainActivity.this, "Form Submitted", Toast.LENGTH_LONG);
                toastMessage.show();
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v==btnReset) {
                    startActivity(new Intent(MainActivity.this, MainActivity.class));
                }
            }
        });

    }
}