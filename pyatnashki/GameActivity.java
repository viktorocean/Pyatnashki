package panoramos.itschool.samsung.com.pyatnashki;

import android.content.DialogInterface;
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
    int c = 0;
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
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                switch (view.getId())
                {
                    case R.id.button:
                        tag=1;
                        break; // вызывается для выхода из блока switch (при вызове дальнейший код не исполняется)
                    case R.id.button2:
                        tag=2;
                        break;
                    case R.id.button3:
                        tag=3;
                        break;
                    case R.id.button4:
                        tag=4;
                        break;
                    case R.id.button5:
                        tag=5;
                        break; // вызывается для выхода из блока switch (при вызове дальнейший код не исполняется)
                    case R.id.button6:
                        tag=6;
                        break;
                    case R.id.button7:
                        tag=7;
                        break;
                    case R.id.button8:
                        tag=8;
                        break;
                    case R.id.button9:
                        tag=9;
                        break; // вызывается для выхода из блока switch (при вызове дальнейший код не исполняется)
                    case R.id.button10:
                        tag=10;
                        break;
                    case R.id.button11:
                        tag=11;
                        break;
                    case R.id.button12:
                        tag=12;
                        break;
                    case R.id.button13:
                        tag=13;
                        break; // вызывается для выхода из блока switch (при вызове дальнейший код не исполняется)
                    case R.id.button14:
                        tag=14;
                        break;
                    case R.id.button15:
                        tag=15;
                        break;
                    case R.id.button16:
                        tag=16;
                        break;
                }
            }
        };
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
                while (c != 15) {

                    for (int i = 0; i < 16; i++) {
                        if (num[i] != 0)
                            btn[i].setText(Integer.toString(num[i]));
                        else
                            btn[i].setVisibility(View.INVISIBLE);
                    }
// Пробный вариант
for(int i=0; i<16;i++)
{
    btn[i].setOnClickListener(listener);
}
                    int n = tag - 1;
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

                    for (int i = 0; i < 15; i++) {
                        if (Integer.parseInt(btn[i].getText().toString()) == prov[i])
                            c++;
                    }
                }
        Intent intent = new Intent(this, FinishActivity.class);
        startActivity(intent);
//

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

           /* public void buttonOnClick(View V) {
                //Получаем текущую кнопку по которой кликнули
                Button current = (Button) V;
                //Получаем номер кнопки из тега кторый задали в XML файле в текстовом режиме редактирования
                String N = current.getTag().toString();
                //преобразуем тег из строки в целое число
                int n = Integer.parseInt(N) - 1;
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
            }*/
        }


