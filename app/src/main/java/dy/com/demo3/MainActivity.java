package dy.com.demo3;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button btn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = (Button) findViewById(R.id.button);

        Log.d("TAG", "onCreate: "+getIntent().getStringExtra("ab"));

//        btn.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                create_link();
//            }
//        });

        Intent addIntent=new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        Parcelable icon=Intent.ShortcutIconResource.fromContext(MainActivity.this,R.mipmap.ic_launcher);

        Intent myIntent = new Intent(MainActivity.this,MainActivity.class);

        myIntent.putExtra("ab","1234");

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, getString(R.string.app_name));

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,myIntent);

        sendBroadcast(addIntent);
    }


    /**
     * 创建快捷方式
     */
    private void create_link(){

        Intent addIntent=new Intent("com.android.launcher.action.INSTALL_SHORTCUT");

        Parcelable icon=Intent.ShortcutIconResource.fromContext(MainActivity.this,R.mipmap.ic_launcher);

        Intent myIntent = new Intent(MainActivity.this,MainActivity.class);

        myIntent.putExtra("ab","1234");

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_NAME, "快捷方式");

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, icon);

        addIntent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,myIntent);

        sendBroadcast(addIntent);

    }

}
