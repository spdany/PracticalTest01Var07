package practicaltest01var7.eim.systems.cs.pub.ro.practicaltest01var07;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PracticalTest01Var07SecondaryActivity extends AppCompatActivity {

    EditText tv1 ;
    EditText tv2 ;
    EditText tv3 ;
    EditText tv4 ;

    private ButtonClickListener buttonClickListener = new ButtonClickListener();

    private class ButtonClickListener implements Button.OnClickListener {

        @Override
        public void onClick(View view) {

            String t1, t2, t3, t4;
            t1 = tv1.getText().toString();
            t2 = tv2.getText().toString();
            t3 = tv3.getText().toString();
            t4 = tv4.getText().toString();
            int sum, product;
            switch (view.getId()) {

                case R.id.sum:
                    sum = Integer.parseInt(t1) + Integer.parseInt(t2) +Integer.parseInt(t3) +Integer.parseInt(t4);
                    Toast.makeText(getApplicationContext(), "Sum  " + String.valueOf(sum), Toast.LENGTH_LONG).show();

                    break;

                case R.id.product:
                    product = Integer.parseInt(t1) * Integer.parseInt(t2) * Integer.parseInt(t3) * Integer.parseInt(t4);
                    Toast.makeText(getApplicationContext(), "Product  " + String.valueOf(product), Toast.LENGTH_LONG).show();

                    break;
                default:
                    break;
            }

        }
    }

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_practical_test01_var07_second);

            Button sum = (Button)findViewById(R.id.sum);
            sum.setOnClickListener(buttonClickListener);
            Button product = (Button)findViewById(R.id.product);
            product.setOnClickListener(buttonClickListener);

             tv1 = (EditText) findViewById(R.id.edit1);
             tv2 = (EditText) findViewById(R.id.edit2);
             tv3 = (EditText) findViewById(R.id.edit3);
             tv4 = (EditText) findViewById(R.id.edit4);

            Intent intent = getIntent();
            if(intent!=null && intent.getExtras().containsKey("nr1")){
                String t1,t2,t3,t4;
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

}
