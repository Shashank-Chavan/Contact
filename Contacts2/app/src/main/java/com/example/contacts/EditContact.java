package com.example.contacts;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link EditContact#newInstance} factory method to
 * create an instance of this fragment.
 */
public class EditContact extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    private static final String ARG_PARAM3 = "param3";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private String mParam3;

    public EditContact() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EditContact.
     */
    // TODO: Rename and change types and number of parameters
    public static EditContact newInstance(String param1, String param2,String param3) {
        EditContact fragment = new EditContact();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        args.putString(ARG_PARAM3, param3);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
            mParam3 = getArguments().getString(ARG_PARAM3);
        }
    }
    EditText Ename,Enumber,Eemail;
    Button Save;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_edit_contact, container, false);
        //name,number and email data recieved from contact_detail fragment will be used here to prefill the data
        Ename = view.findViewById(R.id.editName);
        Ename.setText(mParam1);
        Enumber = view.findViewById(R.id.editNumber);
        Enumber.setText(mParam2);
        Eemail = view.findViewById(R.id.editEmail);
        Eemail.setText(mParam3);
        Save = view.findViewById(R.id.editSave);

        //Now after making changes in the data , the new data will be saved in the sqlite database
        Save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                MyDB db = new MyDB(getContext());
                db.Update_Contact(Ename.getText().toString(),Enumber.getText().toString(),Eemail.getText().toString(),mParam2);
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.Container,new Contact_Page()).commit();
                Toast.makeText(getContext(),"new Data Saved",Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }
}