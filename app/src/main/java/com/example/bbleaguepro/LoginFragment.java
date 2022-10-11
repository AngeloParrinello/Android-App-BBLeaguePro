package com.example.bbleaguepro;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;

import DataBase.AppDAO;
import DataBase.AppDataBase;
import DataBase.AppRepository;
import DataBase.Coach;

public class LoginFragment extends Fragment {

    Button loginButton;
    EditText username;
    EditText password;
    LiveData<Coach> coach;
    View viewone;
    AppRepository repository;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        viewone = inflater.inflate(R.layout.login_general, container, false);
        return viewone;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        this.repository = new AppRepository(getActivity().getApplication());

        this.loginButton = viewone.findViewById(R.id.button_login);
        this.username = viewone.findViewById(R.id.edit_text_username);
        this.password = viewone.findViewById(R.id.edit_text_password);

        this.loginButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                coach = repository.getCoach(username.getText().toString());
                coach.observe(getActivity(), new Observer<Coach>() {
                    @Override
                    public void onChanged(Coach coach) {
                        if(coach != null && coach.getPassword().equals(password.getText().toString())) {
                            startNextActivity(coach.getUserName());
                        } else {
                            Toast.makeText(getContext(), "Username o Password errati", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

            }
        });

        Button registrationButton = view.findViewById(R.id.button_register);
        registrationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nameCoach = username.getText().toString();
                String passwordCoach = password.getText().toString();

                Coach coach = new Coach(nameCoach, passwordCoach);
                repository.coachInsert(coach);
                Toast.makeText(getContext(), "Utente inserito corretamente", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void startNextActivity(String name){
        Intent intent = new Intent(getActivity(), SettingsActivity.class);
        intent.putExtra("coachName", name);
        startActivity(intent);
    }
}
