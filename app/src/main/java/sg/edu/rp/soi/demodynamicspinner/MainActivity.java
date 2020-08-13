package sg.edu.rp.soi.demodynamicspinner;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.Arrays;
public class MainActivity extends AppCompatActivity {
    Spinner spn1, spn2;
    Button btnUpdate;
    ArrayList<String> alNumbers;
    ArrayAdapter<String> aaNumbers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        spn1 = findViewById(R.id.spinner1);
        spn2 = findViewById(R.id.spinner2);
        btnUpdate = findViewById(R.id.buttonUpdate);
        alNumbers = new ArrayList<>();
        aaNumbers = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, alNumbers);
        spn2.setAdapter(aaNumbers);
        String[] strNumbers = getResources().getStringArray(R.array.even_number);
        alNumbers.add("2");
        alNumbers.add("4");
        alNumbers.add("6");
        alNumbers.addAll(Arrays.asList(strNumbers));
        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = spn1.getSelectedItemPosition();
                alNumbers.clear();
                if (spn1.getSelectedItem().equals("even")) {
                    String[] strNumbers = getResources().getStringArray(R.array.even_number);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                } else {
                    String[] strNumbers = getResources().getStringArray(R.array.odd_numbers);
                    alNumbers.addAll(Arrays.asList(strNumbers));
                }
            }
        });
        spn1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                alNumbers.clear();
                switch (position) {
                    case 0:
                        String[] strEvenNumbers = getResources().getStringArray(R.array.even_number);
                        alNumbers.addAll(Arrays.asList(strEvenNumbers));
                        aaNumbers.notifyDataSetChanged();
                        break;
                    case 1:
                        String[] strOddNumber = getResources().getStringArray(R.array.odd_numbers);
                        alNumbers.addAll(Arrays.asList(strOddNumber));
                        aaNumbers.notifyDataSetChanged();
                        break;
                }
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
            }
        });
    }
}
