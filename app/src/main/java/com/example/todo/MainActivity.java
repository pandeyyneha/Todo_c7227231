package com.example.todo;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.todo.database.Todo;

import com.example.todo.todo.TodoFragment;
import com.example.todo.todo.UpdateFragment;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, TodoFragment.newInstance())
                    .commitNow();
        }
    }
    public void moveToUpdate(Todo todo) {
        Bundle bundle=new Bundle();
        bundle.putSerializable("todo",todo);
        Fragment fragment= new UpdateFragment().newInstance();
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.container,fragment)
                .addToBackStack(null)
                .commit();
    }

}
