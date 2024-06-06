package com.example.todoapp.model

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface TodoDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(vararg todo: Todo)

    @Query("Select * from todo WHERE is_done = 0 ORDER BY priority DESC ")
    fun selectAllTodo(): List<Todo>

    @Query("Select * from todo WHERE uuid= :id")
    fun selectTodo(id:Int): Todo

    @Delete
    fun deleteTodo(todo:Todo)

    @Query("Update todo SET title=:title, notes =:notes, priority=:priority WHERE uuid=:id")
    fun update(title:String, notes:String, priority:Int, id:Int)

    @Query("UPDATE todo SET is_done=:is_done WHERE uuid =:uuid")
    fun isDone(is_done:Int, uuid:Int)
}