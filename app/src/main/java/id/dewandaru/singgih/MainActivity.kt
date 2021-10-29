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
        
        val biaya: LinearLayout = findViewById(R.id.layanan)
        val bungapinjam: LinearLayout = findViewById(R.id.bunga)
        val totalcair: LinearLayout = findViewById(R.id.pencairan)
        val totaluang: LinearLayout = findViewById(R.id.total)

        val inputpinjaman: TextInputEditText = findViewById(R.id.pinjamedit)
        val month: TextInputEditText = findViewById(R.id.monthedit)
        var pinjaman = inputpinjaman.text.toString().toDoubleOrNull()
        var monthvalue = month.text.toString().toDoubleOrNull()

        var layanan = pinjaman?.times(0.05)
        var bunga = pinjaman?.times(0.0375)
        var pencairan= pinjaman?.minus(layanan!!)
        var total = monthvalue?.let { bunga?.times(it)?.let { pinjaman?.plus(it) } }

        val biaya_res: TextView = findViewById(R.id.biayalayan1)
        val bunga_res: TextView = findViewById(R.id.bunga2)
        val totalcair_res: TextView = findViewById(R.id.totalcair2)
        val total_res: TextView = findViewById(R.id.total2)

        biaya_res.text = currencyConvert(layanan!!)
        bunga_res.text = currencyConvert(bunga!!)
        totalcair_res.text = currencyConvert(pencairan!!)
        total_res.text = currencyConvert(total!!)

        biaya.visibility = View.VISIBLE
        bungapinjam.visibility = View.VISIBLE
        totalcair.visibility = View.VISIBLE
        totaluang.visibility = View.VISIBLE
    }
}