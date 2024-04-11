package com.ifs21010.delcomtodo.room

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.ifs21010.delcomtodo.entity.DelcomTodoEntity

@Dao
interface IDelcomTodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(delcomTodo: DelcomTodoEntity)

    @Delete
    fun delete(delcomTodo: DelcomTodoEntity)

    @Query("SELECT * FROM delcom_todos WHERE id = :id LIMIT 1")
    fun get(id: Int): LiveData<DelcomTodoEntity?>

    @Query("SELECT * FROM delcom_todos ORDER BY created_at DESC")
    fun getAllTodos(): LiveData<List<DelcomTodoEntity>?>
}