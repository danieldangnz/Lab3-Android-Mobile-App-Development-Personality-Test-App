package daniel.project.ames.ac.a3_personalitytestapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Step 1: Declare variables
    private Button viewImageBtn;//when clicking this button, the imageView will appear in 10 seconds
    private ImageView imageView;//ImageView displays test image
    //Question & answers panel - 1: Declare variables
    private TextView question;//Display question
    private RadioGroup answerGroup;//Group of 2 options
    private RadioButton girlProfileOption;//Option1: girl profile
    private RadioButton manProfileOption;//Option2: man profile
    //View result - 1: Declare viewResultBtn
    private Button viewResultBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Step 2: Find references and do casting for the UI Widgets
        viewImageBtn = (Button) findViewById(R.id.viewImage);
        imageView = (ImageView) findViewById(R.id.testImage);
        //When app launches, set imageView (displaying testImage) INVISIBLE
        imageView.setVisibility(View.INVISIBLE);

        //Step 3: Set click listener for "viewImageBtn" Button: when users click this Button, the app
        //will set imageView VISIBLE for about 10 seconds and then make it INVISIBLE
        viewImageBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //During 10 seconds, set imageView VISIBLE
                imageView.setVisibility(View.VISIBLE);//Set imageView VISIBLE
                //Use “Thread” in Android to set timer (10 seconds) for ImageView visibility;
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        //Delay 10 seconds
                        try {
                            Thread.sleep(10000);//Sleep for 10000ms = 10seconds
                        } catch (InterruptedException e) {
                        }
                        //When 10-second delay is over, set imageView INVISIBLE again
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //Set imageView INVISIBLE
                                imageView.setVisibility(View.INVISIBLE);//Set imageView INVISIBLE
                                //Set "question" and "answer group" VISIBLE
                                question.setVisibility(View.VISIBLE);
                                answerGroup.setVisibility(View.VISIBLE);
                                //Set "viewResultBtn" VISIBLE
                                viewResultBtn.setVisibility(View.VISIBLE);
                            }
                        });
                    }
                };
                //Start the thread
                thread.start(); //start the thread
            }
        });

        //Question & answers panel - 2: Find references and do casting for the UI Widgets
        question = (TextView) findViewById(R.id.question);
        answerGroup = (RadioGroup) findViewById(R.id.answerGroup);
        girlProfileOption = (RadioButton) findViewById(R.id.girl_profile_answer);
        manProfileOption = (RadioButton) findViewById(R.id.man_profile_answer);
        //Set question, answerGroup INVISIBLE when app is launched
        question.setVisibility(View.INVISIBLE);
        answerGroup.setVisibility(View.INVISIBLE);

        //View result - 2: Find references and do casting for "viewResultBtn"
        viewResultBtn = (Button) findViewById(R.id.viewResult);
        //Set "viewResultBtn" INVISIBLE when app is launched
        viewResultBtn.setVisibility(View.INVISIBLE);

        //View result - 3: Set click listener for "viewResultBtn" Button and inside check which answer option
        // has been selected, then use Dialog API to pop up a window to display the relevant personality:
        viewResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get selected radio button from radioGroup
                if (girlProfileOption.isChecked()) {
                    //1: Retrieve girl_profile string in Strings.xml file
                    String girl_profile = getResources().getString(R.string.girl_profile);
                    //2: Create a "dialogBuilder" by using AlertDialog.Builder() method
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    //3: Assign the "girl_profile" variable to "dialogBuilder"
                    dialogBuilder.setMessage(girl_profile);
                    //4: Create a "dialog" object from "DialogBuilder"
                    AlertDialog dialog = dialogBuilder.create();
                    //5: Display "dialog" on screen
                    dialog.show();
                } else if (manProfileOption.isChecked()) {
                    //1: Retrieve girl_profile string in Strings.xml file
                    String man_profile = getResources().getString(R.string.man_profile);
                    //2: Create a "dialogBuilder" by using AlertDialog.Builder() method
                    AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                    //3: Assign the "welcomeMessage" variable to "dialogBuilder"
                    dialogBuilder.setMessage(man_profile);
                    //4: Create a "man_profile" object from "DialogBuilder"
                    AlertDialog dialog = dialogBuilder.create();
                    //5: Display "dialog" on screen
                    dialog.show();
                } else {
                    //If no answer has been selected
                    Toast.makeText(getApplicationContext(), "Please select your answer", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
