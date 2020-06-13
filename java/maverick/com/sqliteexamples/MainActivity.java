package maverick.com.sqliteexamples;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DatabaseHelper myDB;
    Button btnAdd, btnView;
    EditText editText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        btnAdd = findViewById(R.id.addButton);
        btnView = findViewById(R.id.viewButton);
        myDB = new DatabaseHelper(this);

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newEntry = editText.getText().toString();
                if (editText.length() != 0) {

                    AddData(newEntry);
                    editText.setText("");

                } else {

                    Toast.makeText(MainActivity.this, "You must add something BOY!!", Toast.LENGTH_SHORT).show();

                }

            }
        });

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, ViewListContents.class);
                startActivity(intent);

            }
        });

    }

    public void AddData(String newEntry) {

        boolean insertData = myDB.addData(newEntry);

        if (insertData == true) {

            Toast.makeText(MainActivity.this, "Successfully Entered a New Data" , Toast.LENGTH_SHORT).show();

        } else {

            Toast.makeText(MainActivity.this, "Something Went Wrong, MAH BOI!!!", Toast.LENGTH_SHORT).show();

        }

    }

}