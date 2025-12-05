package com.example.firstappcompose.navigation

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

data class User(
    val id: Int,
    val name: String,
    val password: String
)

class DBHelper(context: Context, factory: SQLiteDatabase.CursorFactory?) :
    SQLiteOpenHelper(context, DATABASE_NAME, factory, DATABASE_VERSION) {

    // Se llama cuando la BBDD se crea
    override fun onCreate(db: SQLiteDatabase?) {
        val createTableQuery = """
            CREATE TABLE $TABLE_NAME (
                $ID_COL INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,
                $NAME_COL TEXT,
                $PASSWORD_COL TEXT
            )
            """.trimIndent()
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(
        db: SQLiteDatabase?,
        oldVersion: Int,
        newVersion: Int
    ) {
        db?.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    // Agregamos a la BBDD
    fun addUser(name: String, password: String) {
        val values = ContentValues().apply {
            put(NAME_COL, name)
            put(PASSWORD_COL, password)
        }

        writableDatabase.use { db ->
            db.insert(TABLE_NAME, null, values)
        }
    }

    fun isThereAnyone(name: String, password: String): Boolean {
        val cursor = readableDatabase.rawQuery("SELECT * FROM $TABLE_NAME WHERE $NAME_COL = '$name' AND $PASSWORD_COL = '$password'", null)
        val count = cursor.count
        cursor.close()
        return count != 0
    }

    fun getAllUsers(): ArrayList<User> {
        val lista = ArrayList<User>()
        val db = readableDatabase

        val cursor = db.rawQuery("SELECT * FROM $TABLE_NAME", null)

        if (cursor.moveToFirst()) {
            do {
                val id = cursor.getInt(cursor.getColumnIndexOrThrow("id"))
                val name = cursor.getString(cursor.getColumnIndexOrThrow("name"))
                val password = cursor.getString(cursor.getColumnIndexOrThrow("password"))

                lista.add(User(id, name, password))

            } while (cursor.moveToNext())
        }

        cursor.close()
        return lista
    }

    companion object {
        private const val DATABASE_NAME = "MisUsuariosPruebas"
        private const val DATABASE_VERSION = 1
        const val TABLE_NAME = "Usuarios"
        const val ID_COL = "id"
        const val NAME_COL = "name"
        const val PASSWORD_COL = "password"
    }
}