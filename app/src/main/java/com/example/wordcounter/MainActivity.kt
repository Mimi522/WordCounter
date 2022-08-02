package com.example.wordcounter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.lifecycleScope
import com.github.kittinunf.fuel.Fuel
import com.github.kittinunf.fuel.coroutines.awaitStringResponseResult
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val countButton: Button = findViewById(R.id.button)
        countButton.setOnClickListener {
            countWords()
        }
    }

    private fun countWords() {
        val textCamp: EditText = findViewById(R.id.TextCamp)
        val countResultView: TextView = findViewById(R.id.CountResult)

        startCoroutine(textCamp, countResultView)
    }

    private fun startCoroutine(textCamp: EditText, countResultView: TextView) {
        lifecycleScope.launch {
            val ( _, _, result) = Fuel
                .post("https://gg62qp53ga.execute-api.us-east-1.amazonaws.com/test/helloworld")
                .body(textCamp.text.toString())
                .awaitStringResponseResult()

            result.fold(
                { data -> countResultView.text = data /* "{"origin":"127.0.0.1"}" */},
                { error ->
                    run {
                        println(
                            "An error of type ${error.exception} happened: ${error.message}\nCode(${error.response.statusCode}) Message: ${
                                String(
                                    error.response.data
                                )
                            }"
                        )
                        countResultView.text = String(error.response.data)
                    }
                }
            )
        }
    }
}