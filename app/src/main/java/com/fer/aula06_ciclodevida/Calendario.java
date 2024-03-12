package com.fer.aula06_ciclodevida;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CalendarView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class Calendario extends AppCompatActivity {

   CalendarView calendarView;
   @Override
   protected void onCreate(@Nullable Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_calendar);

      calendarView = findViewById(R.id.calendario);

      //Tela de Calendário com o Listener para mudança de Data
      calendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
         @Override
         public void onSelectedDayChange(@NonNull CalendarView calendarView, int ano, int mes, int dia) {
            String data = dia+"/"+(mes+1)+"/"+ano;
            Intent i = new Intent(Calendario.this, SecondActivity.class);
            i.putExtra("data", data);
            startActivity(i);
            finish();
         }
      });

   }
}
