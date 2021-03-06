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
    private RecordsManager file5;
    private List<Map.Entry<String, Integer>> data;


    @BeforeEach
    public void setup(){
        file1 = new RecordsManager("testing1.txt","test");
        file2 = new RecordsManager("testing2.txt","test");
        file3 = new RecordsManager("testing3.txt","test");
        file4 = new RecordsManager("testing4.txt","test");
        file5 = new RecordsManager("testing5.txt","test");
    }
    @Test
    public void getFilenameTest(){
        Assertions.assertEquals(file1.getFileName(), "testing1.txt");
        Assertions.assertEquals(file2.getFileName(), "testing2.txt");
        Assertions.assertEquals(file3.getFileName(), "testing3.txt");
        Assertions.assertEquals(file4.getFileName(), "testing4.txt");
        Assertions.assertEquals(file5.getFileName(), "testing5.txt");
    }

    @Test
    public void getFilepathTest(){
        Assertions.assertEquals(file1.getFilePath(), "src/test/resources/" + file1.getFileName());
        Assertions.assertEquals(file2.getFilePath(), "src/test/resources/" + file2.getFileName());
        Assertions.assertEquals(file3.getFilePath(), "src/test/resources/" + file3.getFileName());
        Assertions.assertEquals(file4.getFilePath(), "src/test/resources/" + file4.getFileName());
        Assertions.assertEquals(file5.getFilePath(), "src/test/resources/" + file5.getFileName());
    }

    @Test
    public void read() throws FileNotFoundException {
        data = file2.read(10);
        Assertions.assertEquals(data.get(0).getKey(),"Another Name");
        Assertions.assertEquals(data.get(0).getValue(),32);
        Assertions.assertEquals(data.get(1).getKey(),"Some Name");
        Assertions.assertEquals(data.get(1).getValue(),45);
    }

    @Test
    public void write() throws FileNotFoundException {
        file3.write("Creative Name",99);
        data = file3.read(10);
        Assertions.assertEquals(data.get(0).getKey(),"Creative Name");
        Assertions.assertEquals(data.get(0).getValue(),99);
    }

    @Test
    public void sort() throws FileNotFoundException {
        file1.write("Long Name",99);
        file1.write("Cool Name",3);
        data = file1.read(10);
        Assertions.assertEquals(data.get(0).getKey(),"Cool Name");
        Assertions.assertEquals(data.get(0).getValue(),3);
        Assertions.assertEquals(data.get(1).getKey(),"Long Name");
        Assertions.assertEquals(data.get(1).getValue(),99);
    }

    @Test
    public void updateTime() throws FileNotFoundException {
        file4.write("Boring Name",5);
        file4.write("Boring Name",6);
        file4.write("Boring Name",4);
        file4.write("Boring Name",7);
        data = file4.read(10);
        Assertions.assertEquals(data.get(0).getKey(),"Boring Name");
        Assertions.assertEquals(data.get(0).getValue(),4);
    }

    @Test
    public void numberofLinesTest() throws FileNotFoundException {
        file5.write("Boring Name",5);
        file5.write("Strong Name",6);
        file5.write("Weak Name",4);
        file5.write("Smith Name",7);
        data = file5.read(2);
        Assertions.assertEquals(data.get(0).getKey(),"Weak Name");
        Assertions.assertEquals(data.get(0).getValue(),4);
        Assertions.assertEquals(data.size(),2);
    }
}
