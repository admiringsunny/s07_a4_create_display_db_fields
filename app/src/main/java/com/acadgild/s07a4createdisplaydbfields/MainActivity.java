package com.acadgild.s07a4createdisplaydbfields;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<StudentDetails> studentDetailsList;
    List<String> displayableDetailsList;
    DB db = new DB(this);
    ListView displayFieldsListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db.onUpgrade(db.getWritableDatabase(), 1, 2);
        db.addAStudentDetails(new StudentDetails("A", "SINGH"));
        db.addAStudentDetails(new StudentDetails("B", "SINGH"));
        db.addAStudentDetails(new StudentDetails("C", "SINGH"));
        db.addAStudentDetails(new StudentDetails("D", "SINGH"));
        db.addAStudentDetails(new StudentDetails("E", "SINGH"));
        db.addAStudentDetails(new StudentDetails("F", "SINGH"));
        db.addAStudentDetails(new StudentDetails("G", "SINGH"));
        db.addAStudentDetails(new StudentDetails("H", "SINGH"));
        db.addAStudentDetails(new StudentDetails("I", "SINGH"));
        db.addAStudentDetails(new StudentDetails("J", "SINGH"));

        studentDetailsList = db.getAllStudentsDetail();
        displayableDetailsList = new ArrayList<>();
        for (StudentDetails details: studentDetailsList) {
            displayableDetailsList.add(
                    "Id: " + details.getId() +", " +
                    "First Name: " + details.getFName() + ", " +
                    "Last Name: " + details.getLName());
        }

        displayFieldsListView = (ListView) findViewById(R.id.display_fields_list);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, displayableDetailsList);
        displayFieldsListView.setAdapter(adapter);
    }
}
