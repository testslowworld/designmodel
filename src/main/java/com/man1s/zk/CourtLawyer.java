package com.man1s.zk;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.util.IOUtils;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Title:Test
 * Description:
 * Company:北京华宇元典信息服务有限公司
 *
 * @author:wangjiyu
 * @version:1.0
 * @date:2018/11/22 16:28
 */
public class CourtLawyer {

    private static final String XS_AY_XML = "config/template/court.xml";
    private static final String card = "config/template/cardData.txt";
    private static final String test = "C:\\Users\\man\\Desktop\\test.xls";
    //父级法院 2 子集法院s
    private static final Map<String, List<String>> p2c = new HashMap<>();
    //子集法院 2 父级法院
    private static final Map<String, String> c2p = new HashMap<>();
    // 去掉省份的同名法院  2 原名
    private static final Map<String, List> sameName = new HashMap<>();

    private static final ClassLoader ccl = CourtLawyer.class.getClassLoader();
    private static final JSONObject base = new JSONObject();

    //    @Autowired
    //    IJudgeService judgeService;


    public static void main(String[] args) {
        init();
        //        dealOrganize();
        System.out.println();
        //        readLine3();
    }

    public void readLine3() {
        {
            String file = test;
            short coloum = 2;
            try {
                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
                        file));
                HSSFSheet sheet = workbook.getSheetAt(1);

                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                    HSSFRow row = sheet.getRow((short) i);
                    if (null == row) {
                        continue;
                    } else {
                        HSSFCell cell = row.getCell(coloum);
                        if (null == cell) {
                            continue;
                        } else {
                            String courtName = cell.getStringCellValue().trim();
                            HSSFCell cell1 = row.getCell(1);
                            String jungleName = cell1.getStringCellValue().trim();
                            //                            String exist  = judgeService.getCourtJungle(courtName,jungleName);
                            //                            if(StringUtils.isNotEmpty(exist)){
                            //                                row.createCell(3).setCellValue(exist);
                            //                            }
                        }
                    }
                }
                writeOut(file, workbook);
                System.out.println("任务--------------------结束");
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

    //    public    void   read3(){
    //        {
    //            String file = test;
    //            short coloum = 2;
    //            try {
    //                HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
    //                        file));
    //                HSSFSheet sheet = workbook.getSheetAt(1);
    //
    //                for (int i = 0; i <= sheet.getLastRowNum(); i++) {
    //                    HSSFRow row = sheet.getRow((short) i);
    //                    if (null == row) {
    //                        continue;
    //                    } else {
    //                        HSSFCell cell = row.getCell(coloum);
    //                        if (null == cell) {
    //                            continue;
    //                        } else {
    //                            String courtName = cell.getStringCellValue().trim();
    //                            int  num  = courtName.indexOf("法院");
    //                            if(num!=-1){
    //                                courtName  = courtName.substring(0,num+2);
    //                                HSSFCell cell1 = row.getCell(1);
    //                                String  jungleName =  cell1.getStringCellValue().trim();
    //                                jungleName  = jungleName.split("（")[0];
    //                                String exist  = judgeService.getCourtJungle(courtName,jungleName);
    //                                if(StringUtils.isNotEmpty(exist)){
    //                                    row.createCell(3).setCellValue(exist);
    //                                }
    //                            }
    //                        }
    //                    }
    //                }
    //                writeOut(file, workbook);
    //                System.out.println("任务--------------------结束");
    //            } catch (FileNotFoundException e) {
    //                e.printStackTrace();
    //            } catch (IOException e) {
    //                e.printStackTrace();
    //            }
    //
    //        }
    //    }


    private static void dealOrganize() {
        addField("C:\\Users\\man\\Desktop\\test.xls");
        modify(test);
    }


    private static void initBase() {
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream(card);
        InputStreamReader read = new InputStreamReader(in);
        BufferedReader buffer = new BufferedReader(read);
        String str;
        try {
            while (StringUtils.isNotBlank(str = buffer.readLine())) {
                String[] sp = str.split("###");
                Card card = JSON.parseObject(sp[1], Card.class);
                String name = sp[0].split("ZK:LsLs:card:")[1];
                base.put(name, card);
            }
        } catch (IOException e) {
        }

    }


    private static void init() {
        initBase();
        try (InputStream is = ccl.getResourceAsStream(XS_AY_XML)) {
            SAXReader reader = new SAXReader();
            Document doc = reader.read(is);
            List<Element> list = doc.getRootElement().elements("court");
            for (Element el : list) {
                String name = el.attributeValue("name");
                String parent = el.attributeValue("parent");
                String yx = el.attributeValue("yx");
                if (name.indexOf("市") == 2) {
                    String same = name.substring(3);
                    List<String> names = sameName.get(same);
                    if (CollectionUtils.isEmpty(names)) {
                        names = new ArrayList<>();
                        sameName.put(same, names);
                    }
                    names.add(name);
                }
                c2p.put(name, parent);
                if ("0".equals(yx)) {
                    continue;
                }
                List<String> relation = p2c.get(parent);
                if (relation == null) {
                    relation = new ArrayList<>();
                    p2c.put(parent, relation);
                }
                relation.add(name);
            }
        } catch (Exception e) {
        }

    }


    public static void addField(String file) {
        int coloum = 0;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
                    file));
            HSSFSheet sheet = workbook.getSheetAt(1);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow((short) i);
                if (null == row) {
                    continue;
                } else {
                    HSSFCell cell = row.getCell((short) coloum);
                    if (null == cell) {
                        continue;
                    } else {
                        String layerName = cell.getStringCellValue().trim();
                        Integer num = 1;
                        Card card = base.getObject(layerName, Card.class);
                        if (card == null) {
                            continue;
                        }
                        row.createCell(++num).setCellValue(card.getAddress());
                        row.createCell(++num).setCellValue(card.getClnx());
                        row.createCell(++num).setCellValue(card.getFzr());
                        row.createCell(++num).setCellValue(card.getLsrs());
                        row.createCell(++num).setCellValue(card.getPhoneNum());
                        row.createCell(++num).setCellValue(card.getZyzh());
                    }
                }
            }
            writeOut(file, workbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void modify(String file) {
        int coloum = 0;
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
                    file));
            HSSFSheet sheet = workbook.getSheetAt(0);

            for (int i = 0; i <= sheet.getLastRowNum(); i++) {
                HSSFRow row = sheet.getRow((short) i);
                if (null == row) {
                    continue;
                } else {
                    HSSFCell cell = row.getCell((short) coloum);
                    if (null == cell) {
                        continue;
                    } else {
                        int cellSize = 1;
                        String courtName = cell.getStringCellValue().trim();
                        List<String> name = sameName.get(courtName);
                        if (name != null && name.size() > 13) {
                            sameName.remove(courtName);
                            name = null;
                        }
                        if (CollectionUtils.isNotEmpty(name)) {
                            for (String temp : name) {
                                deal(cellSize, temp, row);
                                cellSize++;
                                cellSize++;

                            }
                        } else {
                            deal(cellSize, courtName, row);
                        }
                    }
                }
            }
            writeOut(file, workbook);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static void writeOut(String file, HSSFWorkbook workbook) {
        FileOutputStream out = null;
        try {
            out = new FileOutputStream(file);
            workbook.write(out);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(out);
        }
    }


    private static void deal(int i, String courtName, HSSFRow row) {
        HSSFCell cell1 = row.createCell(i);
        String parent = c2p.get(courtName);
        if (StringUtils.isEmpty(parent)) {
            return;
        }
        cell1.setCellValue(parent);
        List<String> bro = p2c.get(parent);
        StringBuilder brother = new StringBuilder();
        for (String temp : bro) {
            brother.append(temp).append(" ");
        }
        HSSFCell cell2 = row.createCell(i + 1);
        cell2.setCellValue(brother.toString());
    }


}

class Card {
    String address;
    String zyzh;
    String fzr;
    String phoneNum;
    String clnx;
    String lsrs;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getZyzh() {
        return zyzh;
    }

    public void setZyzh(String zyzh) {
        this.zyzh = zyzh;
    }

    public String getFzr() {
        return fzr;
    }

    public void setFzr(String fzr) {
        this.fzr = fzr;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getClnx() {
        return clnx;
    }

    public void setClnx(String clnx) {
        this.clnx = clnx;
    }

    public String getLsrs() {
        return lsrs;
    }

    public void setLsrs(String lsrs) {
        this.lsrs = lsrs;
    }
}


