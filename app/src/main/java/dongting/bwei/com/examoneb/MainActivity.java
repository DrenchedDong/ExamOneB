package dongting.bwei.com.examoneb;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {
    int rn=0;

    Handler handler =new Handler(){
    @Override
    public void handleMessage(Message msg) {
        super.handleMessage(msg);
        if (msg.what==1){
            if (rn>=300){

                handler.removeMessages(1);
                return;

            }
            rn+=3;

            myView.setRn(rn);
            myView.setTitle(rn/3+".0%");
            System.out.println(rn+"");
            handler.sendEmptyMessageDelayed(1,50);
            myView.invalidate();

        }
    }
};
    private MyView myView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myView = (MyView) findViewById(R.id.view);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "点击开始", Toast.LENGTH_SHORT).show();
                rn=0;
                handler.sendEmptyMessageDelayed(1,50);
//                myView.getParent()
            }
        });
    }
}
