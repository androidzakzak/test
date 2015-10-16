package taaaac.dino.com.popygau;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {
    EditText editText;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       editText = (EditText)findViewById(R.id.editText);
        button = (Button)findViewById(R.id.konvert);
        editText.setOnClickListener(this);
        button.setOnClickListener(this);
    }

private float convertMeter(float popygau){
    return (float)(popygau/7.6);
}
    private float convertPopygau(float metr){
        return (float) (metr * 7.6);
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

    @Override
    public void onClick(View v) {
switch (v.getId()){
    case R.id.konvert:
        RadioButton radioButtonMetrs = (RadioButton)findViewById(R.id.radioButton);
        if(editText.getText().length()==0){
            Toast toast = Toast.makeText(this,"Введите длину кота",Toast.LENGTH_SHORT);
            toast.show();
            return;

        }

        float input = Float.parseFloat(editText.getText().toString());
        if(radioButtonMetrs.isChecked()){
            editText.setText(String.valueOf(convertMeter(input)));
        }
        else {
            editText.setText(String.valueOf(convertPopygau(input)));
        }
        break;
}
    }
}
