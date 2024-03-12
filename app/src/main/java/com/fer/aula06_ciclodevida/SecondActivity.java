package com.fer.aula06_ciclodevida;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Calendar;

public class SecondActivity extends AppCompatActivity {

   Button btn03, btnCalendar;
   TextView data, txCalendar;
   DatePickerDialog.OnDateSetListener datePicker;

   String dataIntent = "";

   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_secondy);
      btn03 = findViewById(R.id.btn03);
      data = findViewById(R.id.data);
      btnCalendar = findViewById(R.id.btnCalendar);
      txCalendar = findViewById(R.id.txCalendar);

      //recebendo informações da tela de Calendario
      Intent recebendoDataIntent = getIntent();
      dataIntent = recebendoDataIntent.getStringExtra("data");
      recebendoDataIntent.getIntExtra("valor",0);
      txCalendar.setText(dataIntent);

      //botão Voltar
      btn03.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent i = new Intent(SecondActivity.this, MainActivity.class);
            startActivity(i);
            finish();
         }
      });

      //Trabalhando com o DatePicker
      data.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Calendar calendar = Calendar.getInstance();
            int dia = calendar.get(Calendar.DAY_OF_MONTH);
            int mes = calendar.get(Calendar.MONTH);
            int ano = calendar.get(Calendar.YEAR);
            DatePickerDialog dialog = new DatePickerDialog(SecondActivity.this,
                    android.R.style.Theme_Holo_Light_Dialog_MinWidth,
                    datePicker,ano, mes, dia);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();
         }
      });
      //Atualizando o DatePicker (recebendo a data escolhida)
      datePicker = new DatePickerDialog.OnDateSetListener() {
         @Override
         public void onDateSet(DatePicker datePicker, int ano, int mes, int dia) {
            mes +=1;
            String texto = dia + "/" +mes+ "/"+ano;
            data.setText(texto);
            data.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

         }
      };
      
      //Botão para a tela de Calendário
      btnCalendar.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
            Intent i = new Intent(SecondActivity.this, Calendario.class);
            startActivity(i);
         }
      });

   }
}
