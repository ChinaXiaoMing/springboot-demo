package threadPool;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.*;

public class Test {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        Long start = System.currentTimeMillis();
        File file = new File("E:\\QQFile\\test.txt");
        if (!file.exists()) {
            file.createNewFile();
        }
        InputStreamReader inputStreamReader = new InputStreamReader(new FileInputStream(file), "gbk");
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String content = null;
        Set<String> set = new HashSet<String>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        StringBuffer stringBuffer = new StringBuffer();
        while ((content = bufferedReader.readLine()) != null) {
            if (content.split("\t").length > 1) {
                String finalContent = content.split("\t")[1].replace("\"", "、");
                stringBuffer.append(finalContent);
            } else {
                System.out.println("解析不合格！");
            }
        }
        set.addAll(Arrays.asList(stringBuffer.toString().split("、")));
        set.stream().forEach(x -> System.out.print(x + "、"));
        Long spend = System.currentTimeMillis() - start;
        System.out.println("耗时：" + spend + "ms");
        executorService.shutdown();


    }

}
