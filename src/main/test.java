package main;

import java.io.*;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        File file = new File("/Users/sunyifu/Desktop/222.txt");

        InputStreamReader isr = new InputStreamReader(new FileInputStream(file), "utf-8");
        BufferedReader br = new BufferedReader(isr);
        //跳过第一个字符
//        br.skip(1);

        ArrayList<Demo> list = new ArrayList<>();
        String lineTxt = null;
        String[] lines;
        while ((lineTxt = br.readLine()) != null) {
            lines = lineTxt.split(",");

            String id = lines[0];
            String name = lines[1];

            String[] datas;

            datas = name.split("，");
            if (datas.length == 0)
                list.add(new Demo(id, name));
            if (name.equals(""))
                continue;
            for (String str : datas) {
                if (str != null && !str.equals(""))
                    list.add(new Demo(lines[0], str));
            }
        }


        try{
//            String data = " This content will append to the end of the file";

            File wfile =new File("/Users/sunyifu/Desktop/222.sql");
            FileOutputStream fop = null;
            fop = new FileOutputStream(wfile);

            // if file doesnt exists, then create it
            if (!file.exists()) {
                file.createNewFile();
            }




            for (Demo demo: list) {
                fop.write(demo.toString().getBytes());
            }

            fop.flush();
            fop.close();


        }catch(IOException e){
            e.printStackTrace();
        }

    }
}

class Demo {
    String id;
    String name;

    public Demo(String id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "insert into `demo`.`symptom` ( `name`, `count`, `season`) values ( '"+name+"', '0', '"+id+"');\n";
    }
}