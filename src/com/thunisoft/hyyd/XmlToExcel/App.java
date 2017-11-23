package com.thunisoft.hyyd.XmlToExcel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.apache.commons.io.IOUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

/**
 * Hello world!
 *
 */
public class App 
{
    
    private static JSONObject advsJo = new JSONObject();
    
    public static void main( String[] args )
    {
        //1509191998963
        Calendar c  = Calendar.getInstance();
        c.set(Calendar.YEAR, 2017);
        c.set(Calendar.MONTH, 9);
        c.set(Calendar.DAY_OF_MONTH, 28);
        c.set(Calendar.HOUR_OF_DAY, 19);
        c.set(Calendar.MINUTE, 59);
        c.set(Calendar.SECOND, 58);
        DateFormat df  = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(df.format(new Date(1509191998963L)));
        System.out.println(c.getTimeInMillis());
        
//        System.out.println( "Hello World!" );
//        initFile("C:/Users/man/Desktop/result.txt");
    }
    
    
    
    
    
    private static void initFile(String file) {
        InputStream is = null;
        try {
            is = new  FileInputStream(file);
            String s = IOUtils.toString(is, "utf-8");
            advsJo = JSONObject.parseObject(s,Feature.OrderedField);
            
            JSONArray ja  = advsJo.getJSONObject("aggregations").getJSONObject("AggTime").getJSONArray("buckets");
            export(ja);
            System.out.println(ja);
        } catch (Exception e) {
        } finally {
            IOUtils.closeQuietly(is);
        }
    }
    
    
    private static void export(JSONArray jo){
        int index = 1;
        String fileName  = "9.19-9.25";
        String pathName ="d://"+fileName+".xls"; 
       OutputStream out = null;
    try {
        out = new FileOutputStream(pathName);
    } catch (FileNotFoundException e1) {
        e1.printStackTrace();
    }
       try{
         
           HSSFWorkbook wb = new HSSFWorkbook();
           HSSFSheet sheet = wb.createSheet(fileName);  
           HSSFRow row = sheet.createRow(0); 
           row.createCell(0).setCellValue("id");  
           row.createCell(1).setCellValue("times");  
           row.createCell(2).setCellValue("date");  
           
           if(jo!=null&&jo.size()>0){
               for (int i = 0; i < jo.size(); i++) {
                 JSONObject j =  jo.getJSONObject(i);
                 String date = j.getString("key_as_string");
                 JSONArray array  =  j.getJSONObject("AggUser").getJSONArray("buckets");
                 for (int k = 0; k < array.size(); k++) {
                     String key  = array.getJSONObject(k).getString("key");
                     String doc_count  = array.getJSONObject(k).getString("doc_count");
                     
                     row = sheet.createRow(index++);  
                     row.createCell(0).setCellValue(key);  
                     row.createCell(1).setCellValue(doc_count);  
                     row.createCell(2).setCellValue(date);  
                }
                 index++;
               }
           }
           wb.write(out);
           out.flush();
           wb.close();
       }catch (Exception e) {
       }finally{
           try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
       }
       
       
    }
}
