package co.paulfran.paulfranco.fragmentdemo4;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private FragmentManager manager;
    private EditText etFirstNumber, etSecondNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager = getFragmentManager();
        etFirstNumber = (EditText) findViewById(R.id.etFirstNumber);
        etSecondNumber = (EditText) findViewById(R.id.etSecondNumber);
    }


    public void sendDataToFragment(View view) {

        // Extract Data passed by the user in the etFirstNumber and etSecondNumber EditTexts and convert to an integer
        int firstNumber = Integer.valueOf(etFirstNumber.getText().toString());
        int secondNumber = Integer.valueOf(etSecondNumber.getText().toString());

        // Add FragmentA into the inside the container layout containerFragmentA
        FragmentA fragmentA = new FragmentA();

        // Instead of using setArguments() we will use our own custom method
        fragmentA.setData(firstNumber, secondNumber); // Passing the primitive Data Type

        fragmentA.setEmployeeObj(new Employee()); // Passing Non-Prinitive Data Type

        FragmentTransaction transaction = manager.beginTransaction();
        transaction.add(R.id.containerFragmentA, fragmentA, "fragA");
        transaction.commit();

    }

    public class Employee {
        String name;
        int profId;
    }
}
