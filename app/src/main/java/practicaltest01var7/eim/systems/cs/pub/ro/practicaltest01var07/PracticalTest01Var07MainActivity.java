package practicaltest01var7.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class PracticalTest01Var07MainActivity extends AppCompatActivity {

    EditText tv1;
    EditText tv2 ;
    EditText tv3 ;
    EditText tv4 ;
    int servicestatus = 0;
    private IntentFilter intentFilter = new IntentFilter();
    public static final String BROADCAST_ACTION = "practicaltest01var7.eim.systems.cs.pub.ro.practicaltest01var07";

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {


            if(servicestatus == 0){
            Intent example = new Intent(getApplicationContext(),PracticalTest01Var07Service.class);
                registerReceiver(messageBroadcastReceiver, intentFilter);

                getApplicationContext().startService(example);
            servicestatus = 1;
            }


            switch (view.getId()) {

//                case R.id.set:
////                    String t1, t2,t3,t4;
////                    t1 = tv1.getText().toString();
////                    t2 = tv2.getText().toString();
////                    t3 = tv3.getText().toString();
////                    t4 = tv4.getText().toString();
////
////                    if (android.text.TextUtils.isDigitsOnly(t1) && android.text.TextUtils.isDigitsOnly(t2)
////                            && android.text.TextUtils.isDigitsOnly(t3) && android.text.TextUtils.isDigitsOnly(t4)){
////
////                        Intent intent = new Intent(getApplicationContext(), PracticalTest01Var07SecondaryActivity.class);
////                        intent.putExtra("nr1", t1);
////                        intent.putExtra("nr2", t2);
////                        intent.putExtra("nr3", t3);
////                        intent.putExtra("nr4", t4);
////                        startActivity(intent);
////                    }
////                    break;



                default:
                    break;
            }

        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_practical_test01_var07_main);

         tv1 = (EditText) findViewById(R.id.edit1);
         tv2 = (EditText) findViewById(R.id.edit2);
         tv3 = (EditText) findViewById(R.id.edit3);
         tv4 = (EditText) findViewById(R.id.edit4);

        Button press = (Button)findViewById(R.id.set);
        press.setOnClickListener(buttonClickListener);

        intentFilter.addAction(BROADCAST_ACTION);


    }

    @Override
    protected void onSaveInstanceState(Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        String t1,t2,t3,t4;
        t1 = tv1.getText().toString();
        t2 = tv2.getText().toString();
        t3 = tv3.getText().toString();
        t4 = tv4.getText().toString();

        savedInstanceState.putString("tv1", t1);
        savedInstanceState.putString("tv2", t2);
        savedInstanceState.putString("tv3", t3);
        savedInstanceState.putString("tv4", t4);

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        tv1 = (EditText) findViewById(R.id.edit1);
        tv2 = (EditText) findViewById(R.id.edit2);
        tv3 = (EditText) findViewById(R.id.edit3);
        tv4 = (EditText) findViewById(R.id.edit4);

        if(savedInstanceState.containsKey("tv1"))
            tv1.setText(savedInstanceState.get("tv1").toString());
        if(savedInstanceState.containsKey("tv2"))
            tv2.setText(savedInstanceState.get("tv2").toString());
        if(savedInstanceState.containsKey("tv3"))
            tv3.setText(savedInstanceState.get("tv3").toString());
        if(savedInstanceState.containsKey("tv4"))
            tv4.setText(savedInstanceState.get("tv4").toString());
    }

    /* distruge serviciul */
    @Override
    protected void onDestroy() {
        Intent intent = new Intent(this, PracticalTest01Var07Service.class);
        stopService(intent);
        super.onDestroy();
    }

    /* Receiver serviciu. restu pt receiver */
    private MessageBroadcastReceiver messageBroadcastReceiver = new MessageBroadcastReceiver();
    private class MessageBroadcastReceiver extends BroadcastReceiver {

        String t1,t2,t3,t4;

        @Override
        public void onReceive(Context context, Intent intent) {

            Log.d("[Broadcastreceiver]", "Receiveed!");

            t1 = intent.getStringExtra("nr1");
            t2 = intent.getStringExtra("nr2");
            t3 = intent.getStringExtra("nr3");
            t4 = intent.getStringExtra("nr4");

            tv1.setText(t1);
            tv2.setText(t2);
            tv3.setText(t3);
            tv4.setText(t4);

        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(messageBroadcastReceiver, intentFilter);
    }

    @Override
    protected void onPause() {
        unregisterReceiver(messageBroadcastReceiver);
        super.onPause();
    }


}
