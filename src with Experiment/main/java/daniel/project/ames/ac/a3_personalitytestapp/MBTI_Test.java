package daniel.project.ames.ac.a3_personalitytestapp;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

public class MBTI_Test extends AppCompatActivity {
    ////////////////////////////////////////////////////////////////////////////////////////////////
    //Step 1: Declare variables
    private RadioButton answerE, answerI;//Answers for question1: Extroversion - Introversion
    private RadioButton answerS, answerN;//Answers for question2: Sensing - Intuition
    private RadioButton answerT, answerF;//Answers for question3: Thinking - Feeling
    private RadioButton answerJ, answerP;//Answers for question4: Judging - Perception
    //View result - 1: Declare viewResultBtn
    private Button viewResultBtn;

    ////////////////////////////////////////////////////////////////////////////////////////////////
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mbti_test);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Step 2: Find references and do casting for the UI Widgets
        answerE = (RadioButton) findViewById(R.id.answerE);
        answerI = (RadioButton) findViewById(R.id.answerI);
        answerS = (RadioButton) findViewById(R.id.answerS);
        answerN = (RadioButton) findViewById(R.id.answerN);
        answerT = (RadioButton) findViewById(R.id.answerT);
        answerF = (RadioButton) findViewById(R.id.answerF);
        answerJ = (RadioButton) findViewById(R.id.answerJ);
        answerP = (RadioButton) findViewById(R.id.answerP);
        viewResultBtn = (Button) findViewById(R.id.viewResult);

        ////////////////////////////////////////////////////////////////////////////////////////////
        //Step 3: Set click listener for "viewResultBtn" Button and inside check which answer option
        // has been selected, then use Dialog API to pop up a window to display the relevant personality:
        viewResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ////////////////////////////////////////////////////////////////////////////////////
                //Step 4: Check and get answers to form the final result
                String answer_combination = "";
                //-------------------------------------------------
                //Get selected answer (radio button) from question1
                if (answerE.isChecked()) {
                    answer_combination = answer_combination + "e";
                } else if (answerI.isChecked()) {
                    answer_combination = answer_combination + "i";
                } else {
                    //If no answer has been selected
                    Toast.makeText(getApplicationContext(), "Please answer Question 1", Toast.LENGTH_SHORT).show();
                    return;
                }
                //-------------------------------------------------
                //Get selected answer (radio button) from question2
                if (answerS.isChecked()) {
                    answer_combination = answer_combination + "s";
                } else if (answerN.isChecked()) {
                    answer_combination = answer_combination + "n";
                } else {
                    //If no answer has been selected
                    Toast.makeText(getApplicationContext(), "Please answer Question 2", Toast.LENGTH_SHORT).show();
                    return;
                }
                //-------------------------------------------------
                //Get selected answer (radio button) from question3
                if (answerT.isChecked()) {
                    answer_combination = answer_combination + "t";
                } else if (answerF.isChecked()) {
                    answer_combination = answer_combination + "f";
                } else {
                    //If no answer has been selected
                    Toast.makeText(getApplicationContext(), "Please answer Question 3", Toast.LENGTH_SHORT).show();
                    return;
                }
                //-------------------------------------------------
                //Get selected answer (radio button) from question4
                if (answerJ.isChecked()) {
                    answer_combination = answer_combination + "j";
                } else if (answerP.isChecked()) {
                    answer_combination = answer_combination + "p";
                } else {
                    //If no answer has been selected
                    Toast.makeText(getApplicationContext(), "Please answer Question 4", Toast.LENGTH_SHORT).show();
                    return;
                }

                ////////////////////////////////////////////////////////////////////////////////////
                //Step 5: use Dialog API to pop up a window to display the relevant personality
                //1: Retrieve the according personality string in Strings.xml file
                String personality = "";
                switch (answer_combination) {
                    case "estj":
                        personality = getResources().getString(R.string.estj);
                        break;
                    case "entj":
                        personality = getResources().getString(R.string.entj);
                        break;
                    case "esfj":
                        personality = getResources().getString(R.string.esfj);
                        break;
                    case "estp":
                        personality = getResources().getString(R.string.estp);
                        break;
                    case "enfj":
                        personality = getResources().getString(R.string.enfj);
                        break;
                    case "entp":
                        personality = getResources().getString(R.string.entp);
                        break;
                    case "esfp":
                        personality = getResources().getString(R.string.esfp);
                        break;
                    case "enfp":
                        personality = getResources().getString(R.string.enfp);
                        break;
                    case "infp":
                        personality = getResources().getString(R.string.infp);
                        break;
                    case "isfp":
                        personality = getResources().getString(R.string.isfp);
                        break;
                    case "intp":
                        personality = getResources().getString(R.string.intp);
                        break;
                    case "infj":
                        personality = getResources().getString(R.string.infj);
                        break;
                    case "intj":
                        personality = getResources().getString(R.string.intj);
                        break;
                    case "isfj":
                        personality = getResources().getString(R.string.isfj);
                        break;
                    case "istp":
                        personality = getResources().getString(R.string.istp);
                        break;
                    case "istj":
                        personality = getResources().getString(R.string.istj);
                        break;

                    default:
                        personality = "Some thing wrong with app";
                        break;
                }

                //2: Create a "dialogBuilder" by using AlertDialog.Builder() method
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MBTI_Test.this);
                //3: Assign the "girl_profile" variable to "dialogBuilder"
                dialogBuilder.setMessage(personality);
                //4: Create a "dialog" object from "DialogBuilder"
                AlertDialog dialog = dialogBuilder.create();
                //5: Display "dialog" on screen
                dialog.show();
            }
        });
    }
}
