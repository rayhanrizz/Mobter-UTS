package com.example.utsmobter

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.common.Priority
import com.androidnetworking.error.ANError
import com.androidnetworking.interfaces.JSONArrayRequestListener
import kotlinx.android.synthetic.main.activity_input_berita.*
import org.json.JSONArray

class input_berita : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_input_berita)

        kembali.setOnClickListener{
            startActivity(Intent(this@input_berita,dashboard::class.java))
            finish()
        }
        insert.setOnClickListener{
            var data_judul :String = data1.text.toString()
            var data_waktu :String = data2.text.toString()
            var data_penulis :String = data3.text.toString()
            var data_isi :String = data4.text.toString()
            postkeserver(data_judul, data_waktu, data_penulis, data_isi)

            startActivity(Intent(this@input_berita,dashboard::class.java))
        }
    }
    fun postkeserver(data1:String,data2:String,data3:String, data4:String){
        AndroidNetworking.post("http://192.168.100.26/utsmobter/inputberita.php")
            .addBodyParameter("judul_berita",data1)
            .addBodyParameter("waktu_berita",data2)
            .addBodyParameter("penulis_berita",data3)
            .addBodyParameter("isi_berita",data4)
            .setPriority(Priority.MEDIUM)
            .build()
            .getAsJSONArray(object : JSONArrayRequestListener {
                override fun onResponse(response: JSONArray) {

                }

                override fun onError(anError: ANError) {

                }
            })
    }
}
