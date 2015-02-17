package pandroidsoft.com.mysecondproject;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by pumba30 on 17.02.2015.
 */
public class AssetsTest extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        TextView textView = new TextView(this);
        setContentView(textView);

        AssetManager assetManager = getAssets();
        InputStream inputStream = null;
        try {
            inputStream = assetManager.open("texts/myawesometext.txt");
            String text = loadTextFile(inputStream);
            textView.setText(text);
        } catch (IOException e) {
            textView.setText("Не могу загрузить файл");
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    textView.setText("Не могу закрыть файл");
                }
            }
        }


    }

    //Мы можем легко изменить метод loadTextFile(), чтобы он загружал не текстовые,
    //а двоичные данные. Для этого необходимо лишь возвращать вместо строки
    //массив байтов.

    public String loadTextFile(InputStream inputStream) throws IOException {
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[4096];
        int len = 0;
        while ((len = inputStream.read(bytes)) > 0) {
            byteStream.write(bytes, 0, len);
        }
        return new String((byteStream.toByteArray()), "UTF8");
    }


}
