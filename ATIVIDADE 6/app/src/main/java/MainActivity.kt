package com.example.atividade6

import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val data1 = findViewById<DatePicker>(R.id.data1)
        val data2 = findViewById<DatePicker>(R.id.data2)
        val data3 = findViewById<DatePicker>(R.id.data3)
        val buttonEnviar = findViewById<Button>(R.id.buttonEnviar)

        buttonEnviar.setOnClickListener {
            val date1 = getDateFromDatePicker(data1)
            val date2 = getDateFromDatePicker(data2)
            val date3 = getDateFromDatePicker(data3)

            val dates = listOf(date1, date2, date3).sortedDescending()

            val dateFormat = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())

            val data1Formatted = dateFormat.format(dates[0])
            val data2Formatted = dateFormat.format(dates[1])
            val data3Formatted = dateFormat.format(dates[2])

            val diff1 = (dates[1].time - dates[2].time) / (1000 * 60 * 60 * 24) // Diferença em dias
            val diff2 = (dates[0].time - dates[1].time) / (1000 * 60 * 60 * 24) // Diferença em dias

            // Exibindo as informações em um Toast
            val result = """
                Datas ordenadas decrescentes:
                1. $data1Formatted
                2. $data2Formatted
                3. $data3Formatted
                
                Diferença entre as datas:
                1ª menor para a 2ª menor: $diff1 dias
                2ª menor para a maior: $diff2 dias
            """.trimIndent()

            Toast.makeText(this, result, Toast.LENGTH_LONG).show()
        }
    }

    private fun getDateFromDatePicker(datePicker: DatePicker): Date {
        val day = datePicker.dayOfMonth
        val month = datePicker.month
        val year = datePicker.year

        val calendar = Calendar.getInstance()
        calendar.set(year, month, day)

        return calendar.time
    }
}
