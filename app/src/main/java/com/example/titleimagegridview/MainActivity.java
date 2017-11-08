
        package com.example.titleimagegridview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

        public class MainActivity extends AppCompatActivity {

    GridView gridview;
            //datasource
            String[] title={"GingerBread",
                             "IceCream",
                             "Lollipop",
                             "HoneyComb",
                             "JellyBean",
                             "KitKat"
            };

            int[] images = {R.drawable.gingerbread,
                            R.drawable.icecream,
                            R.drawable.lollipop,
                            R.drawable.honeycomb,
                            R.drawable.jellybean,
                            R.drawable.kitkat};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create adapter object
        CustomAdapter adapter = new CustomAdapter(MainActivity.this,title,images);
        gridview = (GridView) findViewById(R.id.gridView);
        // Attach the adapter to a GridView
        gridview.setAdapter(adapter);

        //create item click listener which displays index position of selected item
        gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View v,
                                    int position, long id) {
                Toast.makeText(MainActivity.this, "" + position,
                        Toast.LENGTH_SHORT).show();

            }
        });

    }
 //create custom adapter, the source for all items to be displayed in the grid

            public static class CustomAdapter extends BaseAdapter {

                private Context context;
                private final String[] title;
                private final int[] images;

                //constructor

                public CustomAdapter(Context context,String[] title,int[] images){

                    this.context=context;
                    this.title=title;
                    this.images=images;
                }


                @Override
                public int getCount() {
                    return title.length;
                }
                //TODO Auto generated method

                @Override
                public Object getItem(int position) {
                    return null;
                }
                //TODO Auto generated method
                @Override
                public long getItemId(int position) {
                    return 0;
                }
                //TODO Auto generated method

                // creating a new ImageView for each item referenced by the Adapter
                @Override
                public View getView(int position, View convertview, ViewGroup parent) {
                    //TODO Auto generated method
                    View grid;
                    //retrieve a standard LayoutInflater instance
                    LayoutInflater inflater = (LayoutInflater) context.getSystemService(LAYOUT_INFLATER_SERVICE);

                    if (convertview==null) {

                        grid = new View(context);
                        grid = inflater.inflate(R.layout.single_item, null);

                        // Lookup view for data population
                        TextView tv = (TextView) grid.findViewById(R.id.textView);
                        ImageView img = (ImageView) grid.findViewById(R.id.imageView);

                        // Populate the data into the template view using the data object
                        tv.setText(title[position]);
                        img.setImageResource(images[position]);
                    }else{
                        grid =(View) convertview;

                    }
                    // Return the completed view to render on screen
                    return grid;
                }
            }
        }
