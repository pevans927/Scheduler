package com.example.front_end_current;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link create_class_page#newInstance} factory method to
 * create an instance of this fragment.
 */
public class create_class_page extends Fragment {
    private EditText classNameEditText;
    private EditText professorNameEditText;
    private EditText sectionEditText;
    private EditText locationEditText;
    private EditText roomEditText;
    private Spinner dayOfWeekSpinner;
    private EditText startEditText;
    private EditText endEditText;
    private Button saveClassButton;
    private Button clearClassButton;

    /*
     * Required empty public constructor
     */
    public create_class_page() {}

    /**
     * @return new instance of fragment
     */
    public static create_class_page newInstance() {
        create_class_page fragment = new create_class_page();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_create_class_page, container, false);

        classNameEditText = view.findViewById(R.id.classNameEditText);
        professorNameEditText = view.findViewById(R.id.professorNameEditText);
        sectionEditText = view.findViewById(R.id.sectionEditText);
        locationEditText = view.findViewById(R.id.locationEditText);
        roomEditText = view.findViewById(R.id.roomEditText);
        dayOfWeekSpinner = view.findViewById(R.id.dayOfWeekSpinner);
        startEditText = view.findViewById(R.id.startEditText);
        endEditText = view.findViewById(R.id.endEditText);
        saveClassButton = view.findViewById(R.id.saveClassButton);
        clearClassButton = view.findViewById(R.id.clearClassButton);

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireContext(),
                R.array.weekdays_list, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dayOfWeekSpinner.setAdapter(adapter);

        saveClassButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveClass();
            }
        });

        return view;
    }

    /**
     * Function to load the content from the fragment and save to the database;
     */
    private void saveClass() {
        String className = classNameEditText.getText().toString().trim();
        String professorName = professorNameEditText.getText().toString().trim();
        String section = sectionEditText.getText().toString().trim();
        String location = locationEditText.getText().toString().trim();
        String room = roomEditText.getText().toString().trim();
        String dayOfWeek = dayOfWeekSpinner.getSelectedItem().toString();
        String start = startEditText.getText().toString().trim();
        String end = endEditText.getText().toString().trim();

        if (className.isEmpty() || professorName.isEmpty() || section.isEmpty()
            || location.isEmpty() || room.isEmpty() || dayOfWeek.isEmpty()
            || start.isEmpty() || end.isEmpty() ) {
            Toast.makeText(requireContext(), "Please enter event details", Toast.LENGTH_SHORT).show();
            return;
        }

        //saveClassToDatabase();

        Toast.makeText(requireContext(), "Event saved successfully", Toast.LENGTH_SHORT).show();

        // navigate back to schedule fragment
    }
}