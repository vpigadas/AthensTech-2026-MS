package gr.athenstech.ms.storage.database;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.room.Room;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import gr.athenstech.ms.databinding.ActivityDatabaseBinding;

public class DatabaseActivity extends AppCompatActivity {

    private ActivityDatabaseBinding binding;

    private Executor executor = Executors.newSingleThreadExecutor();
    private MutableLiveData<UserEntity> userLiveData = new MutableLiveData<>();

//    interface GetCallback {
//        void onResult(UserEntity userEntity);
//    }

//    AsyncTask<Void, Void, UserEntity> asyncTask = new AsyncTask<Void, Void, UserEntity>() {
//
//        private GetCallback callback;
//
//        public GetCallback getCallback() {
//            return callback;
//        }
//
//        public void setCallback(GetCallback callback) {
//            this.callback = callback;
//        }
//
//        @Override
//        protected UserEntity doInBackground(Void... voids) {
//            DatabaseInstance databaseInstance =
//                    Room.databaseBuilder(DatabaseActivity.this, DatabaseInstance.class, "user_entity")
//                            .build();
//
//            return getUserEntity(databaseInstance);
//        }
//
//        @Override
//        protected void onPostExecute(UserEntity userEntity) {
//            super.onPostExecute(userEntity);
//            callback.onResult(userEntity);
//
//        }
//    };

//    private int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDatabaseBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        DatabaseInstance databaseInstance =
                Room.databaseBuilder(this, DatabaseInstance.class, "user_entity")
//                        .allowMainThreadQueries()
                        .build();

        executor.execute(new Runnable() {
            @Override
            public void run() {
                UserEntity userEntity = null;
                try {
                    userEntity = databaseInstance.userDAO().getById(1);
                    userLiveData.postValue(userEntity);
                } catch (Exception e) {}

            }
        });

        binding.databaseBtnIncrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                asyncTask.setCallback(new GetCallback() {
//
//                    @Override
//                    public void onResult(UserEntity userEntity) {
//
//                    }
//                });
//                asyncTask.execute();


                UserEntity userEntity = getUserEntity(databaseInstance);

                int counter = userEntity.getCounter() + 1;

                userEntity.setCounter(counter);

                //binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));

                executor.execute(new Runnable() {
                                     @Override
                                     public void run() {
                                         databaseInstance.userDAO().save(userEntity);
                                         userLiveData.postValue(userEntity);
                                     }
                                 }
                );
            }
        });

        binding.databaseBtnDecrease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserEntity userEntity = getUserEntity(databaseInstance);

                int counter = userEntity.getCounter() - 1;
                userEntity.setCounter(counter);

                //binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));

                executor.execute(new Runnable() {
                                     @Override
                                     public void run() {
                                         databaseInstance.userDAO().save(userEntity);
                                         userLiveData.postValue(userEntity);
                                     }
                                 }
                );
            }
        });

        UserEntity userEntity = getUserEntity(databaseInstance);
        binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));


        userLiveData.observe(this, new Observer<UserEntity>() {
            @Override
            public void onChanged(UserEntity userEntity) {
                binding.databaseTxtNumber.setText(String.valueOf(userEntity.getCounter()));
            }
        });
    }

    private UserEntity getUserEntity(DatabaseInstance databaseInstance) {
        UserEntity userEntity = null;
        try {
            userEntity = userLiveData.getValue();
        } catch (Exception e) {
            Log.d("DatabaseActivity", "Error getting user entity: " + e.getMessage());
        }

        if (userEntity == null) {
            userEntity = new UserEntity();
        }

        return userEntity;
    }
}