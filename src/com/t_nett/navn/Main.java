package com.t_nett.t2048;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;



public class Main extends Activity {
	int str = 4;
	Button[][] map = new Button[str][str];
	
	int x, y;
	Hoved h;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		

        LinearLayout ll = (LinearLayout) findViewById(R.id.ll);
        LinearLayout[] lla = new LinearLayout[str];
        
         for(int y = 0; y < str; y++){
        	 lla[y] = new LinearLayout(this);
        	 lla[y].setOrientation(1);
        	 ll.addView(lla[y]);
        	 
        	 //Lag ll som du setter det inn i
        	for(int x = 0; x < str; x++){
        		map[y][x] = new Button(this);
        		lla[y].addView(map[y][x]);
        		map[y][x].setWidth(40);
        		map[y][x].setHeight(40);
        		map[y][x].setText("Test");
        	}
        		
		        
        }
        h = new Hoved();
        
        
        ll.setOnTouchListener(new OnSwipeListener(this) {
            public void onSwipeTop() {
            	h.opp();
            	h.random();
            	paint();
            }
            public void onSwipeRight() {
            	h.hoyre();
            	h.random();
            	paint();
            }
            public void onSwipeLeft() {
            	h.venstre();
            	h.random();
            	paint();
            }
            public void onSwipeBottom() {
            	h.ned();
            	h.random();
            	paint();
            }
        });
    }
	
	void paint(){
		for(int n = 0; n < str; n++){
			for(int m = 0; m < str; m++){
				map[n][m].setText(h.knapper[n][m].verdi);
			}
		}
	}
        
}
