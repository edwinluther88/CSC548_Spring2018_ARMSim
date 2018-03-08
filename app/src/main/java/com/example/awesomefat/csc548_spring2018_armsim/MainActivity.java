package com.example.awesomefat.csc548_spring2018_armsim;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText inputET;
    String[] strArray;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputET = (EditText)findViewById(R.id.inputET);
    }

    public void onRegistersButtonClicked(View v)
    {
        Intent i = new Intent(this, RegisterActivity.class);
        this.startActivity(i);
    }

    public void onRamButtonClicked(View v)
    {
        Intent i = new Intent(this, RamActivity.class);
        this.startActivity(i);
    }

    public void onRunButtonClicked(View v)
    {
        //Support 2 instructions: ADD and ADDI
        //ADD assumes 2 registers
        //ADDI assumes 1 registers and one numeric literal

        if (this.inputET.getText().toString().equals(""))
        {
            Toast.makeText(MainActivity.this, "Enter instruction",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String strValue = inputET.getText().toString();

        strArray = strValue.split(" ");

        if(("ADD").equals(strArray[0]) || ("ADDI").equals(strArray[0]))
        {
            int valueOfOperand= getOperandValue(strArray[1]);
            CORE.registers[valueOfOperand] = sumOfRegisters();
        }
        else
        {
            Toast.makeText(MainActivity.this, "Invalid instruction code",
                        Toast.LENGTH_SHORT).show();
            return;
        }
    }

    private String sumOfRegisters()
    {
        Integer result;
        if(strArray[3].charAt(0) == '#'){
            result = Integer.parseInt(CORE.registers[getOperandValue(strArray[2])]) + getOperandValue(strArray[3]);
        }
        else
        {
            result = Integer.parseInt(CORE.registers[getOperandValue(strArray[2])]) + Integer.parseInt(CORE.registers[getOperandValue(strArray[3])]);
        }
        return result.toString();
    }

    private int getOperandValue(String tempStr){
        if(tempStr.charAt(0) == '#')
        {
            return Integer.parseInt(tempStr.substring(1));
        }
        else
        {
            return Integer.parseInt("" + tempStr.charAt(1));
        }
    }
}
