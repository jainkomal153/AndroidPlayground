package DataBase

import android.icu.text.CaseMap
import android.view.LayoutInflater
import android.widget.TextView
import com.example.signupapp.R
import kotlinx.coroutines.NonDisposableHandle.parent


class DataSource {

    fun loadDb(): MutableMap<String, String>{
        var map = mutableMapOf(
            "First Name" to "firstName",
            "Last Name" to "lastName",
            "Date Of Birth" to "dob",
            "Phone Number" to "phone",
            "Email Address" to "email"
        )
        return map
    }


//    val layout = LayoutInflater.from(this).inflate(R.layout.list_item, null)
////
//    val title = layout.findViewById(R.id.title)
//
//    val map = mutableMapOf(
//        findViewById(R.id.title) to findViewById(R.id.input_text))

//    fun loadTitle(): List<>{
//        return listOf<Title>(
//
//        )

//    }


}