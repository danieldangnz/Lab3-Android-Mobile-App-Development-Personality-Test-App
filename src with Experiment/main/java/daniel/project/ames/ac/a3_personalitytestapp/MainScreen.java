package daniel.project.ames.ac.a3_personalitytestapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainScreen extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////
    private Button imageTest1, imageTest2, test_MBTI;

    ////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_screen);

        //
        imageTest1 = (Button) findViewById(R.id.test1_Image);
        imageTest1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, MainActivity.class);
                startActivity(intent);
            }
        });

        //
        imageTest2 = (Button) findViewById(R.id.test2_Image);
        imageTest2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, CarryBagTest.class);
                startActivity(intent);
            }
        });

        //
        test_MBTI = (Button) findViewById(R.id.test_MBTI);
        test_MBTI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainScreen.this, MBTI_Test.class);
                startActivity(intent);
            }
        });
    }
}
