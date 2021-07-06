package sg.edu.rp.c346.id20022735.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etname;
    EditText etgpa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etname = findViewById(R.id.editTextTextPersonName);
        etgpa= findViewById(R.id.editTextTextPersonName2);

    }

    @Override
    protected void onPause() {
        super.onPause();
        String strNa = etname.getText().toString();
        float gpa = Float.parseFloat(etgpa.getText().toString());
        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefEdit = prefs.edit();
        prefEdit.putString("name",strNa);
        prefEdit.putFloat("gpa", gpa);
        prefEdit.commit();
    }
    protected void onResume(){
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String na = prefs.getString("name", "No name");
        float gpa = prefs.getFloat("gpa",4.0f);
        etname.setText(na);
        etgpa.setText(gpa+"");

    }
}