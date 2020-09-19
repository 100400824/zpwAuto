package source.utls;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class OperationFile {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\APITest\\test-output";
        System.out.println(path);
        write(path + "/1.txt","dddd"); //运行主方法
    }

    public static void write(String path,String value) throws IOException {
        //将写入转化为流的形式
        FileWriter fw=new FileWriter(path,true);
        fw.write(value);//windows中的换行为\r\n    unix下为\r。   
        fw.close();
    }
}
