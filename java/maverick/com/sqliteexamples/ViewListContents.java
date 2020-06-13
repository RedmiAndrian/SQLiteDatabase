package maverick.com.sqliteexamples;

import android.database.Cursor;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ViewListContents extends AppCompatActivity {

    DatabaseHelper myDB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.viewcontents_layout);

        ListView myList = findViewById(R.id.myList);
        myDB = new DatabaseHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = myDB.getListContents();

        if(data.getCount() == 0){

            Toast.makeText(ViewListContents.this, "The database is empty...", Toast.LENGTH_SHORT).show();

        } else {

            while(data.moveToNext()) {

                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,theList);
                myList.setAdapter(listAdapter);

            }

        }

    }
}
