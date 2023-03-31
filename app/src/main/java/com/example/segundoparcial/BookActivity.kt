package com.example.segundoparcial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class BookActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_book)

        var bookTitle : EditText = findViewById(R.id.input_book_name)
        var bookDescription : EditText = findViewById(R.id.input_book_description)
        var submit : Button = findViewById(R.id.submit_button)

        submit.setOnClickListener{
            GlobalScope.launch{
                val bookDao = AppRoomDatabase.getDatabase(applicationContext).bookDato()
                val repository = BookRepository(bookDao)
                repository.insert(Book(bookTitle.text.toString(), bookDescription.text.toString()))
                val list = repository.getListBooks()

                list.forEach{
                    Log.d("DBTEST", "Id = ${it.id}, Title : ${it.title}, Body = ${it.body}")
                }
            }
        }
    }
}