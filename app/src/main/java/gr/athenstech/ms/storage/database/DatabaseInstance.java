package gr.athenstech.ms.storage.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserEntity.class}, version = 1)
public abstract class DatabaseInstance extends RoomDatabase {

    abstract UserDAO userDAO();
}
