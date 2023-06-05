package io.xiaochangbai.sensitive.core.lab;

import io.xiaochangbai.sensitive.common.utils.FileUtils;
import io.xiaochangbai.sensitive.common.utils.StringUtil;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author xiaochangbai
 * @date 2023-06-04 21:51
 * 数据字典压缩
 */
public class DictCompressLab {


    public static void main(String[] args) throws Exception {
//        URL url = DictCompressLab.class.getResource("/deny.txt");
//        FileUtils.compressFileByZIP(url.getPath());

        long count = 0;
        HashSet<String> set = new HashSet<>(1000000);
        File file = new File("D:\\programs\\workspaces\\IdeaProjects\\sensitive-hunter\\sensitive-hunter-core\\src\\main\\resources\\tmp");
        for (File f:file.listFiles()){
            if(f.isDirectory()){
                continue;
            }
            try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(f), StandardCharsets.UTF_8))) {
                while (bufferedReader.ready()){
                    String line = bufferedReader.readLine();
                    if(StringUtil.isNotBlank(line)){
                        if(line.indexOf(",")==line.length()-1){
                            line= line.substring(0,line.length()-1);
                        }
                        System.out.println(line);
                        count++;
                        set.add(line);
                    }
                }
            }
        }
        System.out.println("总数量："+count);

        //存储
        saveToFile(set,"D:\\programs\\workspaces\\IdeaProjects\\sensitive-hunter\\sensitive-hunter-core\\src\\main\\resources\\dict","d");
    }

    private static void saveToFile(HashSet<String> set, String path,String fileName) throws Exception {
        List<String> collect = set.stream().filter(e -> {
            return StringUtil.isNotBlank(e) && e.length() > 1;
        }).collect(Collectors.toList());
        Collections.sort(collect);
        String pailFile = path+File.separator+fileName+".txt";
        String zipFile = path+File.separator+fileName+".zip";
        BufferedWriter writer = new BufferedWriter(new FileWriter(pailFile,StandardCharsets.UTF_8));
        for(String line:collect){
            writer.write(line);
            writer.write("\r\n");
        }
        writer.flush();
        writer.close();

        FileUtils.compressFileByZIP(pailFile,zipFile);

    }


}
