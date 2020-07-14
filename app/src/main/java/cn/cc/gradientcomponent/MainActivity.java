package cn.cc.gradientcomponent;

import android.graphics.Color;
import android.os.Bundle;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import cn.cc.gradientlibrary.DrawableUtils;

public class MainActivity extends AppCompatActivity {
    private ViewGroup contentView;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private ImageView gift;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contentView = findViewById(R.id.content_layout);

        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        gift = findViewById(R.id.gift);

        button1.setBackground(DrawableUtils.getGradientButtonDrawable(this, new int[]{Color.GREEN, Color.YELLOW}));
        button2.setBackground(DrawableUtils.getGradientButtonDrawable(this, new int[]{Color.GREEN, Color.YELLOW}));
        button3.setBackground(DrawableUtils.getGradientButtonDrawable(this, new int[]{Color.GREEN, Color.YELLOW}));
        button4.setBackground(DrawableUtils.getGradientButtonDrawable(this, new int[]{Color.GREEN, Color.YELLOW}));

        gift.setImageDrawable(DrawableUtils.getBitmapDrawable(this, R.drawable.gift, new int[]{Color.BLUE, Color.RED}));


    }


}
