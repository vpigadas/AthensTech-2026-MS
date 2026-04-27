package gr.athenstech.ms.storage.database;

import android.database.SQLException;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;
import androidx.room.Upsert;

import java.util.List;

@Dao
public interface UserDAO {

    @Insert
    void insert(UserEntity userEntity) throws Exception;

    @Update
    void update(UserEntity userEntity) throws Exception;

    @Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    void save(UserEntity userEntity);

    @Delete
    void delete(UserEntity userEntity);

    @Query("SELECT * FROM UserEntity WHERE id = :id")
    @Nullable
    UserEntity getById(int id) throws Exception;

    @Query("SELECT * FROM UserEntity WHERE name = :username")
    @Nullable
    UserEntity getByUsername(String username) throws Exception;

    @Query("SELECT * FROM UserEntity")
    @NonNull
    List<UserEntity> getAll();
}
