import com.spaceinvaders.RecordsManager;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.Map;

public class RecordsManagerTest {
    private RecordsManager file1;
    private RecordsManager file2;
    private RecordsManager file3;
    private RecordsManager file4;
    private List<Map.Entry<String, Integer>> data;


    @BeforeEach
    public void setup(){
        file1 = new RecordsManager("testing1.txt","test");
        file2 = new RecordsManager("testing2.txt","test");
        file3 = new RecordsManager("testing3.txt","test");
        file4 = new RecordsManager("testing4.txt","test");
    }
    @Test
    public void getFilenameTest(){
        Assertions.assertEquals(file1.getFileName(), "testing1.txt");
        Assertions.assertEquals(file2.getFileName(), "testing2.txt");
        Assertions.assertEquals(file3.getFileName(), "testing3.txt");
        Assertions.assertEquals(file4.getFileName(), "testing4.txt");
    }

    @Test
    public void getFilepathTest(){
        Assertions.assertEquals(file1.getFilePath(), "src/test/resources/" + file1.getFileName());
        Assertions.assertEquals(file2.getFilePath(), "src/test/resources/" + file2.getFileName());
        Assertions.assertEquals(file3.getFilePath(), "src/test/resources/" + file3.getFileName());
        Assertions.assertEquals(file4.getFilePath(), "src/test/resources/" + file4.getFileName());
    }

    @Test
    public void read() throws FileNotFoundException {
        data = file2.read();
        Assertions.assertEquals(data.get(0).getKey(),"Another Name");
        Assertions.assertEquals(data.get(0).getValue(),32);
        Assertions.assertEquals(data.get(1).getKey(),"Some Name");
        Assertions.assertEquals(data.get(1).getValue(),45);
    }
}
