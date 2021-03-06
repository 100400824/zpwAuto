package source.utls;

import java.io.*;

public class OperationFile {

    public static void main(String[] args) throws IOException {
        String path = System.getProperty("user.dir") + "\\APITest\\test-output";
        System.out.println(path);
        write(path + "/1.txt", "dddd"); //运行主方法
    }

    public static void write(String path, String value) throws IOException {
        //将写入转化为流的形式
        FileWriter fw = new FileWriter(path, true);
        fw.write(value);//windows中的换行为\r\n    unix下为\r。   
        fw.close();
    }

    public static String getFileValue(String fileName) throws Exception {
        File file = new File(fileName);
        BufferedReader reader = null;
        StringBuffer sbf = new StringBuffer();
        try {
            reader = new BufferedReader(new FileReader(file));
            String tempStr;
            while ((tempStr = reader.readLine()) != null) {
                sbf.append(tempStr);
            }
            reader.close();
            return sbf.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
        return sbf.toString();
    }

    public static void clearFile(String path) throws Exception {
        File log = new File(path);
        FileWriter fileWriter =new FileWriter(log);
        fileWriter.write("");
        fileWriter.flush();
        fileWriter.close();
    }

}
