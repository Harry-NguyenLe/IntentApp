package vn.edu.csc.intentapp;

import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnCamera, btnDial, btnYoutube, btnMove;
    TextView txtKetqua;
    String phoneNumber = "tel:0923150638";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnCamera = findViewById(R.id.btnCamera);
        btnDial = findViewById(R.id.btnDial);
        btnYoutube = findViewById(R.id.btnYoutube);
        btnMove = findViewById(R.id.btnMove);
        txtKetqua = findViewById(R.id.txtKetqua);


        btnDial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse(phoneNumber));
                startActivity(intent);

            }
        });

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivity(takePicture);
            }
        });

        btnYoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.youtube.com/watch?v=cxLG2wtE7TM"));
                startActivity(intent);
            }
        });

        btnMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int so_thu_nhat = 10;
                int so_thu_hai = 20;
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("so_thu_nhat", so_thu_nhat);
                intent.putExtra("so_thu_hai", so_thu_hai);
                startActivityForResult(intent, 113);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if ((requestCode == 113) && (resultCode == RESULT_OK))
        {
            int kq = data.getExtras().getInt("resultSigma", 0);
            txtKetqua.setText(kq + "");
        }
    }
}
