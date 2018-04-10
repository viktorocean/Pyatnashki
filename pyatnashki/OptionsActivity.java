package panoramos.itschool.samsung.com.pyatnashki;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Viktor on 04.04.2018.
 */

public class OptionsActivity extends  MainActivity {
        private TextView text2;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_opions);
            text2 = findViewById(R.id.text2);
            text2.setText(getString(R.string.opions));
        }

        public void Opions(View view) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);

        }
    }


