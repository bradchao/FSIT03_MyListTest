package tw.brad.app.helloworld.mylisttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private ListView list;
    private List<Map<String,String>> data;
    private String[] from = {"title", "content"};
    private int[] to = {R.id.item_title, R.id.item_content};
    private SimpleAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = (ListView)findViewById(R.id.list);
        initList();
    }

    private void initList(){

        data = new LinkedList<>();
        Map<String,String> d0 = new HashMap<>();
        d0.put(from[0],"Android");
        d0.put(from[1],"Android ......");
        data.add(d0);
        Map<String,String> d1 = new HashMap<>();
        d1.put(from[0],"iOS");
        d1.put(from[1],"iOS ......");
        data.add(d1);

        adapter = new SimpleAdapter(this, data, R.layout.layout_item, from , to);
        list.setAdapter(adapter);
    }

    public void addItem(View view){
        Map<String,String> d1 = new HashMap<>();
        d1.put(from[0],"New Item");
        d1.put(from[1],"Content ......" + (int)(Math.random()*49+1));
        data.add(d1);

        adapter.notifyDataSetChanged();
    }

}
