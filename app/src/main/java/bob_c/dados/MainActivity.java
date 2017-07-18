package bob_c.dados;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // Field to hold the roll result text
    TextView rollResult;

    // Field to hold the roll button
    Button rollBotton;

    // Field to hold the score
    int score;
    // Create a variable for Random Class
    Random rand;

    // Fields to hold the dice Values
    int die1;
    int die2;
    int die3;
    // Field to hold the scoreText
    TextView scoreText;

    // ArrayList to hold the three dice values
    ArrayList<Integer> dice;

    // ArrayList to hold all the three dice images
    ArrayList<ImageView> diceImageViews;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        // Set inital score
        score = 0;
        // always need to cast the input
        // link instances to widget in the activity view
        // Set the rollResult to the widget (Access)
        rollResult = (TextView) findViewById(R.id.rollResult);
        // Set the Button
        rollBotton = (Button) findViewById(R.id.rollButton);
        scoreText = (TextView) findViewById(R.id.scoreText);

        // Initialize the random number generator
        rand = new Random();
        // Initialize the ArrayList container for the dice vales
        dice = new ArrayList<Integer>();
        // Access to the Images
        ImageView die1Image = (ImageView) findViewById(R.id.die1Image);
        ImageView die2Image = (ImageView) findViewById(R.id.die2Image);
        ImageView die3Image = (ImageView) findViewById(R.id.die3Image);

        diceImageViews = new ArrayList<ImageView>();
        diceImageViews.add(die1Image);
        diceImageViews.add(die2Image);
        diceImageViews.add(die3Image);

        // Create greeting
        // Toast is a brief message
        Toast.makeText(getApplicationContext(),"Welcome to DiceOut",Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),"I hope this work",Toast.LENGTH_LONG).show();

    }

    // Create a method for rollButton
    public  void rollDice(View v){
        // Modified the rollResult text
        rollResult.setText("Clicked!!");

        // Roll dice
        die1 = rand.nextInt(6)+1;
        die2 = rand.nextInt(6)+1;
        die3 = rand.nextInt(6)+1;

        // Set dice values into an ArrayList
        dice.clear();
        dice.add(die1);
        dice.add(die2);
        dice.add(die3);

        for (int dieOfSet = 0; dieOfSet <3; dieOfSet++){

            String imageName = "die_" + dice.get(dieOfSet) +".png";
            try{
                InputStream stream =getAssets().open(imageName);
                // New temporary drawable object (Image for android)
                Drawable d = Drawable.createFromStream(stream,null);
                diceImageViews.get(dieOfSet).setImageDrawable(d);
            } catch(IOException e) {
                e.printStackTrace();
            }

        }


        // Build message with the result
        String msg = "You rolled a " + die1 + ", a " + die2 + ", and a " + die3;
        // Update the app to display the result message
        rollResult.setText(msg);


        /*// Field to hold an int 0-5 + 1
        int num = rand.nextInt(6)+1;
        // String to hold the number generated
        String randomValue = "Number generated: "+num;
        // Toast is a brief message showing the randomValue
        Toast.makeText(getApplicationContext(),randomValue,Toast.LENGTH_LONG).show();

        // rollBotton.setText("ups");*/
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
