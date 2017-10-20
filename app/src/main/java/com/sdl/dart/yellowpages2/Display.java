package com.sdl.dart.yellowpages2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ArrowKeyMovementMethod;
import android.widget.TextView;

import java.util.List;

public class Display extends AppCompatActivity {
    TextView tvBookInfo;
    DatabaseHandler db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        db = new DatabaseHandler(this);
        tvBookInfo=(TextView)findViewById(R.id.tvStdList);

        tvBookInfo.setMovementMethod(ArrowKeyMovementMethod.getInstance());

        tvBookInfo.setText("");	//	clear text area at each button press
        //tvStdInfo.setTextColor(Color.MAGENTA);
        tvBookInfo.setPadding(5, 2, 5, 2);

        List<Booking> bookingsList = db.getAllBookingsList();	//	fetch List of BlockedNumbers form DB  method - 'getAllBlockedNumbers'

        for (Booking book : bookingsList) {

            String stdDetail = "\n\nUsername:" + book.getU_name() + "\n\tWorker booked:" + book.getW_id()+"\n\tDate stamp : "+book.getDate_st()+"\n\tTime stamp : "+book.getTime_st();
            tvBookInfo.append("\n" + stdDetail);

            // Log.i("TAG", log);
        }
    }
}
