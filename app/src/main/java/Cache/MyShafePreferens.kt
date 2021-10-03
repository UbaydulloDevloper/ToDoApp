package Cache

import android.content.Context
import android.content.SharedPreferences
import classs.date
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

object MyShafePreferens {
    private const val NAME = "CacheCoding"
    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferens: SharedPreferences

    fun init(context: Context) {
        preferens = context.getSharedPreferences(NAME, MODE)
    }

    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }

    var objectsString: ArrayList<date>
        get() = gsonStringToArray(preferens.getString("key0", "[]")!!)
        set(value) = preferens.edit() {
            it.putString("key0", arrayTogsonString(value))
        }

    private fun arrayTogsonString(value: ArrayList<date>): String? {
        return Gson().toJson(value)
    }

    private fun gsonStringToArray(string: String?):ArrayList<date> {
        val typetoken = object : TypeToken<ArrayList<date>>() {}.type
        return Gson().fromJson(string, typetoken)
    }


}