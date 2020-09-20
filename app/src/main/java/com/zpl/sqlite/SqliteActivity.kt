package com.zpl.sqlite

import android.content.ContentValues
import android.database.Cursor
import android.os.Bundle
import android.provider.BaseColumns
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.zpl.R
import kotlinx.android.synthetic.main.activity_sqlite.*


class SqliteActivity : AppCompatActivity() {

    private lateinit var dbHelper: FeedReaderDbHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sqlite)
        dbHelper = FeedReaderDbHelper(this)
        insert()
    }

    fun insert() {
        // Gets the data repository in write mode
        val db = dbHelper.writableDatabase
        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )
        with(cursor) {
            while (moveToNext()) {
                return
            }
        }

        var arr =
            arrayOf( 70, 49, 80, 59, 52, 88, 17, 30, 6, 39, 26, 61, 10, 47, 36, 40, 92, 71, 85, 41, 93, 83, 23, 38, 57, 68, 9, 19, 66, 53, 12, 32, 78, 11, 20, 81, 95, 35, 79, 29, 14, 37, 87, 51, 7, 33, 50, 64, 45, 67, 74, 5, 13, 98, 24, 3, 76, 62, 16, 25, 73, 28, 4, 31, 1, 90, 46, 8, 89, 55, 84, 94, 34, 18, 72, 22, 91, 21, 75, 82, 48, 54, 42, 69, 77, 44, 96, 56, 58, 100, 60, 99, 86, 2, 63, 27, 15, 97, 43)
        for (i in arr.indices) {
            val values = ContentValues().apply {
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_ID, arr[i])
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title $i")
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "subTitle $i")
            }
            // Insert the new row, returning the primary key value of the new row
            val newRowId = db?.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
            if (newRowId?.equals(-1)!!) {

            }
        }
        // Create a new map of values, where column names are the keys
    }

    /**
     * 查询
     */
    fun query(view: View) {
        val db = dbHelper.writableDatabase
        // Define a projection that specifies which columns from the database
        // you will actually use after this query.
        val projection = arrayOf(
            BaseColumns._ID,
            FeedReaderContract.FeedEntry.COLUMN_NAME_ID,
            FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE,
            FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE
        )
        // Filter results WHERE "title" = 'My Title'
        val selection = "${FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE} = ?"
        val selectionArgs = arrayOf("My Title")

        // How you want the results sorted in the resulting Cursor
        val sortOrder = "${FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE} DESC"

        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            null               // The sort order
        )

        val itemIds = mutableListOf<String>()
        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val id =
                    getInt(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_ID))
                val title =
                    getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE))
                val subTitle =
                    getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE))
                itemIds.add("$id")
            }
        }
        mTv.text = itemIds.toString()
    }

    var pageIndex: Int = 0
    fun paggingQuery(view: View) {
        val db = dbHelper.writableDatabase
        val limit: String = (pageIndex * 10).toString() + ",10"
        val cursor = db.query(
            FeedReaderContract.FeedEntry.TABLE_NAME,   // The table to query
            null,             // The array of columns to return (pass null to get all)
            null,              // The columns for the WHERE clause
            null,          // The values for the WHERE clause
            null,                   // don't group the rows
            null,                   // don't filter by row groups
            FeedReaderContract.FeedEntry.COLUMN_NAME_ID + " desc",               // The sort order
            limit
        )
        val itemIds = mutableListOf<String>()
        var string: StringBuilder = StringBuilder()
        with(cursor) {
            while (moveToNext()) {
                val itemId = getLong(getColumnIndexOrThrow(BaseColumns._ID))
                val id =
                    getInt(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_ID))
                val title =
                    getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE))
                val subTitle =
                    getString(getColumnIndexOrThrow(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE))
//                itemIds.add("$itemId $id $title $subTitle")
                itemIds.add("$id")
            }
        }
        db.close()
        mTv.text = itemIds.toString()
        pageIndex++
    }

    override fun onDestroy() {
        dbHelper.close()
        super.onDestroy()
    }

    /**
     * 插入十条
     */
    fun insert(view: View) {
        // Gets the data repository in write mode
        val allCaseNum = allCaseNum()
        val db = dbHelper.writableDatabase
        for (i in allCaseNum until allCaseNum + 10) {
            val values = ContentValues().apply {
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_TITLE, "title $i")
                put(FeedReaderContract.FeedEntry.COLUMN_NAME_SUBTITLE, "subTitle $i")
            }
            // Insert the new row, returning the primary key value of the new row
            db?.insert(FeedReaderContract.FeedEntry.TABLE_NAME, null, values)
        }
    }

    /**
     * 获取数据库的总条数
     */
    fun allCaseNum(): Long {
        val db = dbHelper.writableDatabase
        val sql = "select count(*) from " + FeedReaderContract.FeedEntry.TABLE_NAME
        val cursor: Cursor = db.rawQuery(sql, null)
        cursor.moveToFirst()
        val count: Long = cursor.getLong(0)
        cursor.close()
        return count
    }

    fun delete(view: View) {
        val db = dbHelper.writableDatabase
        val sql = "delete from " + FeedReaderContract.FeedEntry.TABLE_NAME +
                " where " + BaseColumns._ID + " in(" +
                "select " + BaseColumns._ID + " from " + FeedReaderContract.FeedEntry.TABLE_NAME +
                " order by " + BaseColumns._ID +
                " limit " + 10 + ")"
        db.execSQL(sql)
    }


}