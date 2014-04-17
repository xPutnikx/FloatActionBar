package vhudnitsky.floatactionbar.example.app;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import vhudnitsky.floatactionbar.view.FloatActionListViewFrame;


public class MainActivity extends Activity {
    final String[] data = {"One","Two", "Three", "Four","Five"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        FloatActionListViewFrame view = (FloatActionListViewFrame) findViewById(R.id.content);
        view.setCustomFloatView(R.layout.header);
        ListView listView = view.getActualListView();
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,android.R.id.text1,data);
        listView.setAdapter(adapter);
        listView.addHeaderView(getLayoutInflater().inflate(R.layout.header,null));
    }

}
