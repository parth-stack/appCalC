package com.example.calc;

        import androidx.annotation.RequiresApi;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Build;
        import android.os.Bundle;
        import android.util.Log;
        import android.view.View;
        import android.widget.Button;
        import android.widget.TextView;

        import java.math.BigDecimal;
        import java.math.BigInteger;
        import java.math.RoundingMode;

public class MainActivity extends AppCompatActivity {
    int operation=5;
    String cache="",cache1;
    boolean dotPresent=false;
    TextView display;
    Button dot,zero,one,two,three,four,five,six,seven,eight,nine,del,divide,multiply,minus,plus,equal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /////////////////////////////////////////////
        display=findViewById(R.id.display);
        dot=findViewById(R.id.dot);
        zero=findViewById(R.id.zero);
        one=findViewById(R.id.one);
        two=findViewById(R.id.two);
        three=findViewById(R.id.three);
        four=findViewById(R.id.four);
        five=findViewById(R.id.five);
        six=findViewById(R.id.six);
        seven=findViewById(R.id.seven);
        eight=findViewById(R.id.eight);
        nine=findViewById(R.id.nine);
        del=findViewById(R.id.del);
        divide=findViewById(R.id.divide);
        multiply=findViewById(R.id.multiply);
        minus=findViewById(R.id.minus);
        plus=findViewById(R.id.plus);
        equal=findViewById(R.id.equal);
        ///////////////////////////////////////////////
        dot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!cache.contains(".")){
                    cache+=".";
                    dotPresent=true;
                    refresh();}
            }
        });
        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="0";
                refresh();
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="1";
                refresh();
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="2";
                refresh();
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="3";
                refresh();
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="4";
                refresh();
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="5";
                refresh();
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="6";
                refresh();
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="7";
                refresh();
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="8";
                refresh();
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cache+="9";
                refresh();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (cache == null || cache.length() == 0) {
                    return;
                }
                else{
                    cache=cache.substring(0, cache.length()-1);
                    refresh();
                }
            }
        });
        del.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                cache="";
                refresh();
                return true;
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        divide.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("0","divide");
                operation=0;
                cache1=cache;
                cache="";
                refresh();
            }
        });
        multiply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("1","multiply");
                operation=1;
                cache1=cache;
                cache="";
                refresh();
            }
        });
        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("2","minus");
                operation=2;
                cache1=cache;
                cache="";
                refresh();
            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.v("3","plus");
                operation=3;
                cache1=cache;
                cache="";
                refresh();
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(operation==0){
                    if(dotPresent==false){
                        BigInteger a=new BigInteger(cache1);
                        BigInteger b=new BigInteger(cache);
                        BigInteger result=a.divide(b);
                        cache=result.toString();
                    }
                    else{
                        BigDecimal a=new BigDecimal(cache1);
                        BigDecimal b=new BigDecimal(cache);
                        BigDecimal result=a.divide(b,2, RoundingMode.HALF_UP);
                        cache=result.toString();
                    }
                    refresh();
                }
                if(operation==1){
                    if(dotPresent==false){
                        BigInteger a=new BigInteger(cache1);
                        BigInteger b=new BigInteger(cache);
                        BigInteger result=a.multiply(b);
                        cache=result.toString();
                    }
                    else{
                        BigDecimal a=new BigDecimal(cache1);
                        BigDecimal b=new BigDecimal(cache);
                        BigDecimal result=a.multiply(b);
                        cache=result.toString();
                    }
                    refresh();
                }
                if(operation==2){
                    if(dotPresent==false){
                        BigInteger a=new BigInteger(cache1);
                        BigInteger b=new BigInteger(cache);
                        BigInteger result=a.subtract(b);
                        cache=result.toString();
                    }
                    else{
                        BigDecimal a=new BigDecimal(cache1);
                        BigDecimal b=new BigDecimal(cache);
                        BigDecimal result=a.subtract(b);
                        cache=result.toString();
                    }
                    refresh();
                }
                if(operation==3){
                    if(dotPresent==false){
                        BigInteger a=new BigInteger(cache1);
                        BigInteger b=new BigInteger(cache);
                        BigInteger result=a.add(b);
                        cache=result.toString();
                    }
                    else{
                        BigDecimal a=new BigDecimal(cache1);
                        BigDecimal b=new BigDecimal(cache);
                        BigDecimal result=a.add(b);
                        cache=result.toString();
                    }
                    refresh();
                }
            }
        });
        ////////////////////////////////////////////////////////////////////////////////////////////
    }
    public void refresh(){
        display.setText(cache);
    }
}
