package com.example.awesomefat.csc548_spring2018_armsim;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class RegisterActivity extends AppCompatActivity {

    EditText XET[] = new EditText[CORE.numberOfRegisters];

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        XET[0] = findViewById(R.id.X0ET);
        XET[1] = findViewById(R.id.X1ET);
        XET[2] = findViewById(R.id.X2ET);
        XET[3] = findViewById(R.id.X3ET);
        XET[4] = findViewById(R.id.X4ET);
        XET[5] = findViewById(R.id.X5ET);
        XET[6] = findViewById(R.id.X6ET);
        XET[7] = findViewById(R.id.X7ET);

        for(int i=0; i<CORE.numberOfRegisters;i++)
        {
            XET[i].setText(CORE.registers[i]);
        }

    }

    public void onSaveButtonClicked(View v)
    {
        for(int i=0; i<CORE.numberOfRegisters; i++)
        {
            CORE.registers[i] = XET[i].getText().toString();
        }
    }
}
