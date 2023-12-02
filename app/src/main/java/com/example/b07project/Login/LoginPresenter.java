package com.example.b07project.Login;

import android.content.Intent;

import com.example.b07project.SignUpPage;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import androidx.annotation.NonNull;

import com.example.b07project.R;
import com.example.b07project.SignUpPage;
import com.example.b07project.adminPages.adminHomePage;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import com.example.b07project.studentPages.studentHomePage;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginPresenter implements Contract.Presenter{
    // creating object of View Interface
    private Contract.View mainView;

    // creating object of Model Interface
    private Contract.Model model;

    // instantiating the objects of View and Model Interface
    public LoginPresenter(Contract.View mainView) {
        this.mainView = mainView;
        this.model = new LoginModel(mainView);
    }
    @Override
    public void onSignUpClick() {
        if (mainView != null){
            mainView.switchToSignup();
        }
    }
    @Override
    public void onLoginClick(){
        //mAuth = FirebaseAuth.getInstance();
        String email = mainView.findEmailEditText();
        String password = mainView.findPasswordEditText();
        if (TextUtils.isEmpty(email)){
            mainView.showErrorText("Email");
            return;
        }
        if (TextUtils.isEmpty(password)){
            mainView.showErrorText("Password");
            return;
        }
        if (model!=null){
            model.checkLogin(email, password);
        }

    }


}