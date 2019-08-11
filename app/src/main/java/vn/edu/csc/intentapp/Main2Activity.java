package vn.edu.csc.intentapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    Button btnBack;
    TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnBack = findViewById(R.id.btnBack);
        txtResult = findViewById(R.id.txtResult);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Intent intent = getIntent();
        int result = intent.getIntExtra("so_thu_nhat", -1);
        int result1 = intent.getIntExtra("so_thu_hai", -1);
        int resultSigma = result + result1;
        congHaiSo(result, result1);


        txtResult.setText(result + " " + "+" + result1);
    }

    public void congHaiSo(int result, int result1){
        int resultSigma = result + result1;
        Intent data = new Intent(Main2Activity.this, MainActivity.class);
        data.putExtra("resultSigma", resultSigma);
        setResult(RESULT_OK, data);

    }
}
