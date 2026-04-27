package gr.athenstech.ms.storage.database;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import gr.athenstech.ms.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;

//    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseInstance databaseInstance =
                Room.databaseBuilder(this, DatabaseInstance.class, "user_entity")
                        .allowMainThreadQueries()
                        .build();

        binding.databaseBtnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = getUserEntity(databaseInstance);

                int counter = userEntity.getCounter() + 1;

                userEntity.setCounter(counter);

                binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));
                databaseInstance.userDAO().save(userEntity);
            }
        });

        binding.databaseBtnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = getUserEntity(databaseInstance);

                int counter = userEntity.getCounter() - 1;
                userEntity.setCounter(counter);

                binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));
                databaseInstance.userDAO().save(userEntity);
            }
        });

        UserEntity userEntity = getUserEntity(databaseInstance);
        binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));
    }

    private UserEntity getUserEntity(DatabaseInstance databaseInstance ) {
        UserEntity userEntity = null;
        try {
            userEntity = databaseInstance.userDAO().getById(1);
        } catch (Exception e) {
        }

        if (userEntity == null) {
            userEntity = new UserEntity();
        }

        return userEntity;
    }
}