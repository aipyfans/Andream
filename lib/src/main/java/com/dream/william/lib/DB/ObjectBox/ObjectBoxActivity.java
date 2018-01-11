package com.dream.william.lib.DB.ObjectBox;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.dream.william.lib.DB.ObjectBox.model.Person;
import com.dream.william.lib.DB.ObjectBox.ob.ObManager;
import com.dream.william.lib.R;
import com.dream.william.lib.app.BaseActivity;

import java.util.List;

import io.objectbox.Box;
import io.objectbox.BoxStore;
import io.objectbox.query.QueryBuilder;

/**
 * https://github.com/objectbox/objectbox-java
 * <p>
 * http://blog.csdn.net/Vxiaocai/article/details/78616526
 */
public class ObjectBoxActivity extends BaseActivity {

    private BoxStore boxStore;
    private Box<Person> box;

    private TextView tvShow;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_box);
        tvShow = findViewById(R.id.tv_show);

        boxStore = ObManager.getInstance().getBoxStore();
        box = boxStore.boxFor(Person.class);
    }


    public void onClick(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.btn_put:
                boxPut();
                break;

            case R.id.btn_get:
                boxGet();
                break;

            case R.id.btn_remove:
                boxRemove();
                break;

            case R.id.btn_query:
                boxQuery();
                break;

            case R.id.btn_count:
                boxCount();
                break;
        }
    }


    private void boxPut() {
        Person person = new Person("William", 25);
        box.put(person);
    }


    private void boxGet() {
        // getAll
        List<Person> persons = box.getAll();
        if (persons.size() > 0)
            tvShow.setText(persons.get(0).toString());
        else
            Toast.makeText(this, "No data !", Toast.LENGTH_SHORT).show();
    }


    private void boxRemove() {
        // removeAll
        box.removeAll();
    }


    private void boxQuery() {
        // query
        QueryBuilder qb = box.query();

    }


    private void boxCount() {
        long count = box.count();
        tvShow.setText("Person表有" + count + "条数据");
    }

}
