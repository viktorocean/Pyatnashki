package panoramos.itschool.samsung.com.pyatnashki;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Random;

/**
 * Created by Viktor on 04.04.2018.
 */

public class GameActivity extends MainActivity {

    Button[] btn = new Button[16];
    int[] id = new int[16];
    int[] num = new int[16];
    int[] prov = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
    //int c = 0;
    int tag;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        btn[0] = findViewById(R.id.button);
        btn[1] = findViewById(R.id.button2);
        btn[2] = findViewById(R.id.button3);
        btn[3] = findViewById(R.id.button4);
        btn[4] = findViewById(R.id.button5);
        btn[5] = findViewById(R.id.button6);
        btn[6] = findViewById(R.id.button7);
        btn[7] = findViewById(R.id.button8);
        btn[8] = findViewById(R.id.button9);
        btn[9] = findViewById(R.id.button10);
        btn[10] = findViewById(R.id.button11);
        btn[11] = findViewById(R.id.button12);
        btn[12] = findViewById(R.id.button13);
        btn[13] = findViewById(R.id.button14);
        btn[14] = findViewById(R.id.button15);
        btn[15] = findViewById(R.id.button16);
        Random newRandom = new Random();

        for (int i = 0; i < 16; ) {
            int j;
            int randomNumber = newRandom.nextInt(16);
            for (j = 0; j < i; j++) {
                if (num[j] == randomNumber) {
                    break;
                }
            }
            if (j == i) {
                num[i] = randomNumber;
                System.out.print(num[i] + " ");
                i++;
            }
        }
        for (int i = 0; i < 16; i++) {

            btn[i].setText(Integer.toString(num[i]));
            if (num[i] == 0)
                btn[i].setVisibility(View.INVISIBLE);
        }
    }



            public void Swap(Button B1, Button B2) {
                if (B2.getVisibility() == View.INVISIBLE) {
                    B2.setVisibility(View.VISIBLE);
                    B1.setVisibility(View.INVISIBLE);
                    String Tmp = B1.getText().toString();
                    B1.setText(B2.getText());
                    B2.setText(Tmp);
                }
            }

    public void buttonOnClick(View view) {

        //Получаем текущую кнопку по которой кликнули
        Button button = (Button) view;
        //Получаем номер кнопки из тега кторый задали в XML файле в текстовом режиме редактирования
        //преобразуем тег из строки в целое число
        int n = Integer.parseInt(button.getTag().toString()) - 1;
        //рассчитываем номер строки путем целочисленного деления
        int y = n / 4;
        //вычисляем столбец
        int x = n;
        if (n >= 12) x = n - 12;
        else if (n >= 8) x = n - 8;
        else if (n >= 4) x = n - 4;
        //Рассчитываем номер кнопки сверху снизу слева справа и записываем в переменные
        //NT NL NR NB NC (Top Left Right Bottom Current)
        int nc = y * 4 + x;
        int nt = (y - 1) * 4 + x;
        int nb = (y + 1) * 4 + x;
        int nl = y * 4 + x - 1;
        int nr = y * 4 + x + 1;
        //Проверяем существование кнопки слева справа снизу сверху
        //Если существует то пытаемся поменять кнопки местами
        if (y - 1 >= 0)
            Swap(btn[nc], btn[nt]);
        if (y + 1 < 4)
            Swap(btn[nc], btn[nb]);
        if (x - 1 >= 0)
            Swap(btn[nc], btn[nl]);
        if (x + 1 < 4)
            Swap(btn[nc], btn[nr]);
        int c=0;
            for (int i = 0; i < 15; i++) {
                if (Integer.parseInt(btn[i].getText().toString()) == prov[i])
                    c++;
            }

        if (c == 15) {
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
    }
    }


}
