package pandroidsoft.com.mysecondproject;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by pumba30 on 08.02.2015.
 */


//интерфейс доступа к файловой системе
public interface FileIO {

    public InputStream readAsset(String fileName) throws IOException;

    public InputStream readFile(String fileName) throws IOException;

    public OutputStream writeFile(String fileName) throws IOException;


}
