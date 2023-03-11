package com.example.android_logintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import com.example.android_logintutorial.databinding.ActivityMainBinding
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var retrofit = Retrofit.Builder()
            .baseUrl("http://100.64.1.35:8000")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var loginService = retrofit.create(LoginService::class.java)

        binding.loginButton.setOnClickListener {
            var id = binding.tvId.text.toString()
            var password = binding.tvPassword.text.toString()

            loginService.requestLogin(id, password).enqueue(object: Callback<Login>{
                override fun onResponse(call: Call<Login>, response: Response<Login>) {
                    var login = response.body()
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    if (login == null) {
                        dialog.setTitle("실패")
                        dialog.setMessage("아이디 또는 비밀번호를 확인해주세요.")
                        dialog.show()
                    } else {
                        dialog.setTitle("알림")
                        dialog.setMessage("${login}, token = ${login?.token}")
                        dialog.show()
                    }
                }

                override fun onFailure(call: Call<Login>, t: Throwable) {
                    var dialog = AlertDialog.Builder(this@MainActivity)
                    dialog.setTitle("실패")
                    dialog.setMessage("로그인에 실패했습니다")
                    dialog.show()
                }
            })
        }
    }
}