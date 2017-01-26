package com.example.mysearchtext;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements OnItemClickListener {
	
	EditText txtSearch;
	ListView lv;
	ArrayList<Student> list=new ArrayList<Student>();
	ArrayList<Student> source=new ArrayList<Student>();
	//adapter
	MyAdapter adapter;

	
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtSearch=(EditText) this.findViewById(R.id.editText1);
        
      
   
        
        ///add listener for listview item
        this.lv.setOnItemClickListener(this);
        
        
        
        
        ///populate my data reference
        this.source.add("a");
        this.source.add("b");
        this.source.add("c");
        this.source.add("d");
        this.source.add("apple");
        this.source.add("boy");
        this.source.add("cat");
        this.source.add("dog");
        this.source.add("duck");
        this.source.add("axe");
        this.source.add("bus");
        this.source.add("color");
        this.source.add("dragon");
        this.source.add("all");
        this.source1.add(new Student(R.drawable.img1,"Alpha,Bravo","BSIT"));
        this.source1.add(new Student(R.drawable.img2,"Charlie,Hotel","BSOA"));
        this.source1.add(new Student(R.drawable.img3,"Mike,India","BSCREAM"));
       this.source1.add(new Student(R.drawable.img4,"November,Kilo","BSHRM"));
       this.source1.add(new Student(R.drawable.img5,"Oscar,Quebec","BSE"));
       this.source1.add(new Student(R.drawable.img6,"Zulu,Uniform","AB"));
       this.source1.add(new Student(R.drawable.img7,"Delta,Tango","BSA"));
       this.source1.add(new Student(R.drawable.img8,"Juliet,Sierra","BSBA"));
        
        adapter=new MyAdapter(this,source1);
        
        
        this.lv.setAdapter(adapter1);
        
        
      
        
        
        this.txtSearch.addTextChangedListener(new TextWatcher(){

		
    }
        


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
	     String s=this.lv.getItemAtPosition(arg2).toString();
	     Toast.makeText(this,s, Toast.LENGTH_SHORT).show();
	}
	public void onItemClick1(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		AlertDialog.Builder builder=new AlertDialog.Builder(this);
			builder.setTite(list.get(arg2).getStudentName());
			
			ImageView myiv=new ImageView(this);
				myiv.setImageResource(list.get(arg2).getimage());
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
