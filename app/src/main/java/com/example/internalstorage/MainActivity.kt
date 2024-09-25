package com.example.internalstorage

import android.content.Context
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {
    private var filename = "appfiles"
    private var filecontent = "this is internal storage"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var openfileoupput = this.openFileOutput(filename, Context.MODE_PRIVATE)
        openfileoupput.use(::myfun)

    filestream()
    }

    fun myfun(file: FileOutputStream) {
        var content = file.write(filecontent.toByteArray())

    }

    fun filestream() {

        var filestream = openFileInput("appfiles")
        var buffer = filestream.bufferedReader()
        var sb = StringBuilder()
        buffer.forEachLine {
            sb.append(it)

            var txt01 = findViewById<TextView>(R.id.txt01)
                txt01.text = sb

        }
    }
}