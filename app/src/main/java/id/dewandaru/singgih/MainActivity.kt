package id.dewandaru.singgih

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.textfield.TextInputEditText
import java.text.NumberFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn: Button = findViewById(R.id.submit)
        btn.setOnClickListener{simulasi()}
    }

    private fun currencyConvert(num: Double): String {
        return NumberFormat.getCurrencyInstance().format(num)
    }

    private fun simulasi(){
        
                val moneny: LinearLayout = findViewById(R.id.layanan)
                val tenor: LinearLayout = findViewById(R.id.bunga)
                val pencairan1: LinearLayout = findViewById(R.id.pencairan)
                val total1: LinearLayout = findViewById(R.id.total)

        val inputpin: TextInputEditText = findViewById(R.id.pinjamedit)
        val bulan: TextInputEditText = findViewById(R.id.monthedit)
        var pinjaman = inputpin.text.toString().toDoubleOrNull()
        var monthvalue = bulan.text.toString().toDoubleOrNull()

                var endos = pinjaman?.times(0.05)
                var bunga2 = pinjaman?.times(0.0375)
                var pencairan2= pinjaman?.minus(endos!!)
                var total = monthvalue?.let { bunga2?.times(it)?.let { pinjaman?.plus(it) } }

        val biaya: TextView = findViewById(R.id.biayalayan1)
        val bunga3: TextView = findViewById(R.id.bunga2)
        val total2: TextView = findViewById(R.id.totalcair2)
        val total3: TextView = findViewById(R.id.total2)

                biaya.text = currencyConvert(endos!!)
                bunga3.text = currencyConvert(bunga2!!)
                total2.text = currencyConvert(pencairan2!!)
                total3.text = currencyConvert(total!!)

        moneny.visibility = View.VISIBLE
        tenor.visibility = View.VISIBLE
        pencairan1.visibility = View.VISIBLE
        total1.visibility = View.VISIBLE
    }
}