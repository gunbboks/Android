package com.example.listview3;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends Activity implements OnItemClickListener {
	
	ListView lv;
	//define data source
	ArrayList<Student> list=new ArrayList<Student> ();
	MyAdapter adapter;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //
        lv=(ListView) this.findViewById(R.id.listView1);
        //put static data to the data source
        list.add(new Student(R.drawable.img1,"Alpha, Bravo","BSIT"));
        list.add(new Student(R.drawable.img2,"Charlie, Hotel","BSOA"));
        list.add(new Student(R.drawable.img3,"Mike, India","BSCREAM"));
        list.add(new Student(R.drawable.img4,"November, Kilo","BSHRM"));
        list.add(new Student(R.drawable.img5,"Oscar, Quebec","BSE"));
        list.add(new Student(R.drawable.img6,"Zulu, Uniform","AB"));
        list.add(new Student(R.drawable.img7,"Delta, Tango","BSA"));
        list.add(new Student(R.drawable.img8,"Juliet, Sierra","BSBA"));
        //instance of adapter
        adapter=new MyAdapter(this,list);
        //associate the adapter to the listview
        this.lv.setAdapter(adapter);
        
        
        //add listner to listview to display individual info
        this.lv.setOnItemClickListener(this);
    }
   
        


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		
		 
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
		builder.setTitle(list.get(arg2).getStudentName());
		
		ImageView myiv=new ImageView(this);
			myiv.setImageResource(list.get(arg2).getImage());
		TextView myname=new TextView(this);
			myname.setText(list.get(arg2).getStudentName());
		TextView mycourse=new TextView(this);
			mycourse.setText(list.get(arg2).getCourse());
		
		LinearLayout mainLayout=new LinearLayout(this);	
				mainLayout.setOrientation(LinearLayout.HORIZONTAL);
				mainLayout.addView(myiv);
				
		LinearLayout subLayout=new LinearLayout(this);
			subLayout.setOrientation(LinearLayout.VERTICAL);
			subLayout.addView(myname);
			subLayout.addView(mycourse);
			
			mainLayout.addView(subLayout);
			
			builder.setView(mainLayout);
			builder.setNeutralButton("Okey", null);
			
	AlertDialog dialog=builder.create();
		dialog.show();
	
			
}
		     
      
    
}
