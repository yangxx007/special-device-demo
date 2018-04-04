package com.example.demo;



import com.example.demo.dao.map.DistrictDao;
import com.example.demo.service.MapService;
import org.apache.poi.xwpf.usermodel.*;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
    @Test
    public void word2pdf() throws Exception {
//		OutputStream os = null;
//		try {
//			WordprocessingMLPackage mlPackage = WordprocessingMLPackage.load(new File
//					("/Users/yang/yang-workspace/form2.docx"));
//			//Mapper fontMapper = new BestMatchingMapper();
//			org.docx4j.fonts.Mapper fontMapper = new IdentityPlusMapper();
//			fontMapper.put("华文行楷", PhysicalFonts.get("STXingkai"));
//			fontMapper.put("华文仿宋", PhysicalFonts.get("STFangsong"));
//			fontMapper.put("隶书", PhysicalFonts.get("LiSu"));
//			mlPackage.setFontMapper(fontMapper);
//
//			os = new java.io.FileOutputStream("/Users/yang/yang-workspace/write2.pdf");
//
//			FOSettings foSettings = Docx4J.createFOSettings();
//			foSettings.setWmlPackage(mlPackage);
//			Docx4J.toFO(foSettings, os, Docx4J.FLAG_EXPORT_PREFER_XSL);
//
//		}catch(Exception ex){
//			ex.printStackTrace();
//		}finally {
//			IOUtil.closeQuietly(os);
//		}
//        File inputFile = new File("/home/ctt/Downloads/formForTest.docx");
//        File outputFile = new File("/home/ctt/Downloads/form1test.pdf");
//
//// connect to an OpenOffice.org instance running on port 8100
//
//        OpenOfficeConnection connection = new SocketOpenOfficeConnection(32774);
//       try {
//           connection.connect();
//       }catch (Exception e){
//           e.printStackTrace();
//       }
//
//// convert
//
//        final DocumentFormat docx = new DocumentFormat("Microsoft Word 2007 XML", DocumentFamily.TEXT, "application/vnd.openxmlformats-officedocument.wordprocessingml.document", "docx");
//        DocumentConverter converter = new StreamOpenOfficeDocumentConverter(connection);
//
//        converter.convert(inputFile,docx,outputFile,null);
//
//// close the connection
//
//        connection.disconnect();
//        DefaultOfficeManagerConfiguration config=new DefaultOfficeManagerConfiguration();
//        String officeHome =getOfficeHome();
//        config.setOfficeHome(officeHome);
//
//        OfficeManager officeManager = config.buildOfficeManager();
//        officeManager.start();
//
//        OfficeDocumentConverter converter = new OfficeDocumentConverter(officeManager);
//        String inputFilePath="/home/ctt/Downloads/formForTest.docx";
//        String outputFilePath = "/home/ctt/Downloads/formForTest.pdf";
//        File inputFile = new File(inputFilePath);
//        if (inputFile.exists()) {// 找不到源文件, 则返回
//            File outputFile = new File(outputFilePath);
//            if (!outputFile.getParentFile().exists()) { // 假如目标路径不存在, 则新建该路径
//                outputFile.getParentFile().mkdirs();
//            }
//            converter.convert(inputFile, outputFile);
//        }
//
//        officeManager.stop();
    }

    public static String getOutputFilePath(String inputFilePath) {
        String outputFilePath = inputFilePath.replaceAll(".doc", ".pdf");
        return outputFilePath;
    }

    public static String getOfficeHome()throws Exception {
        String osName = System.getProperty("os.name");
        if (Pattern.matches("Linux.*", osName)) {
            return "/usr/lib/libreoffice";
        }
//        else if (Pattern.matches("Windows.*", osName)) {
//            return "D:/Program Files/OpenOffice.org 3";
//        } else if (Pattern.matches("Mac.*", osName)) {
//            return "/Application/OpenOffice.org.app/Contents";
//        }
        else{
            throw new Exception();
        }
    }
    //	@Test
//	public void documents4j() throws Exception{
//		File wordFile = new File( "/Users/yang/yang-workspace/form2.docx" ),target = new File
//				("/Users/yang/yang-workspace/form2.pdf" );
//		File base=new File("/Users/yang/yang-workspace/tmp");
//		IConverter converter = LocalConverter.builder()
//				.baseFolder(base)
//				.workerPool(20, 25, 2, TimeUnit.SECONDS)
//				.processTimeout(5, TimeUnit.SECONDS)
//				.build();
//		Future<Boolean> conversion = converter
//				.convert(wordFile).as(DocumentType.MS_WORD)
//				.to(target).as(DocumentType.PDF)
//				.prioritizeWith(1000) // optional
//				.schedule();
//	}
//	@Test
//	public void contextLoads() throws Exception{
//		try {
//
//			InputStream is = new FileInputStream("/Users/yang/yang-workspace/form2.docx");
//			Map<String,Object> replacetor=new HashMap<String,Object>();
//			replacetor.put("first","dianshu");
//			replacetor.put("second","dierg");
//			XWPFDocument doc=new XWPFDocument(is);
//
//			this.replaceInPara(doc,replacetor);
//			this.replaceInTable(doc,replacetor);
//			PdfOptions options = PdfOptions.create();
//
//			OutputStream os = new FileOutputStream("/Users/yang/yang-workspace/write.pdf");
//			PdfConverter.getInstance().convert(doc,os,options);
//			doc.write(os);
//			os.close();
//			is.close();
//		}
//		catch (Exception e){
//			System.out.println(e.getMessage());
//			e.printStackTrace();
//		}
//	}
    @Autowired
    private MapService districtDao;
    @Autowired
    private DistrictDao mapDao;

    public void testEnums() throws Exception {

//		for(int i=1100;i<=7200;i++){
//			List<District> districts=districtDao.findAllArea(i+"00");
//			int j=0;
//		for(District district:districts){
////			System.out.println(district.getCode().substring(2,4));
////			int j=Integer.parseInt(district.getCode().substring(2,4));
//			if(districts.size()>26){
//				district.setCitySeqCode(mapDao.findFirstByCode(i+"00").getCitySeqCode());
//				district.setProvinceCode(mapDao.findFirstByCode(i/100+"0000").getProvinceCode());
//				district.setAreaSeqCode(UtilServiceImpl.CODE[j/26]+UtilServiceImpl.CODE[j%26]);
//			}
//			else {
//				if(mapDao.findFirstByCode(i+"00")!=null){
//					District districtcity=mapDao.findFirstByCode(i+"00");
//					districtcity.setProvinceCode(mapDao.findFirstByCode(i/100+"0000").getProvinceCode());
//					district.setCitySeqCode(districtcity.getCitySeqCode());
//					mapDao.save(districtcity);}
//				district.setProvinceCode(mapDao.findFirstByCode(i/100+"0000").getProvinceCode());
//				district.setAreaSeqCode(UtilServiceImpl.CODE[j]);
//			}
//			j++;
//		}
//		if(!districts.isEmpty())
//			mapDao.save(districts);
//	}
//		char[] chars={'0','0','0','0','1'};
//		System.out.println(String.valueOf(chars));
//		RegistCodeGenerater codeGenerater=new RegistCodeGenerater();
//		System.out.println(codeGenerater.generate(districtDao.findDistrictByCode("110105"),"11021", DeviceTypeEnum.客运索道.getShortName(),0,142888));
        System.out.println(new Date());
    }


    /**
     * 替换段落里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInPara(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFParagraph> iterator = doc.getParagraphsIterator();
        XWPFParagraph para;
        while (iterator.hasNext()) {
            para = iterator.next();
            this.replaceInPara(para, params);
        }
    }

    private void replaceInPara(XWPFParagraph para, Map<String, Object> params) {
        List<XWPFRun> runs;
        Matcher matcher;
        if (this.matcher(para.getParagraphText()).find()) {
            runs = para.getRuns();
            for (int i = 0; i < runs.size(); i++) {
                XWPFRun run = runs.get(i);
                String runText = run.toString();
                matcher = this.matcher(runText);
                if (matcher.find()) {
                    while ((matcher = this.matcher(runText)).find()) {
                        runText = matcher.replaceFirst(String.valueOf(params.get(matcher.group(1))));
                        System.out.println("find:" + matcher.group(1) + "end" + String.valueOf(params.get("second")));
                    }
                    //直接调用XWPFRun的setText()方法设置文本时，在底层会重新创建一个XWPFRun，把文本附加在当前文本后面，
                    //所以我们不能直接设值，需要先删除当前run,然后再自己手动插入一个新的run。
                    para.removeRun(i);
                    para.insertNewRun(i).setText(runText);
                }
            }
        }
    }

    /**
     * 替换表格里面的变量
     *
     * @param doc    要替换的文档
     * @param params 参数
     */
    private void replaceInTable(XWPFDocument doc, Map<String, Object> params) {
        Iterator<XWPFTable> iterator = doc.getTablesIterator();
        XWPFTable table;
        List<XWPFTableRow> rows;
        List<XWPFTableCell> cells;
        List<XWPFParagraph> paras;
        while (iterator.hasNext()) {
            table = iterator.next();
            rows = table.getRows();
            for (XWPFTableRow row : rows) {
                cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    paras = cell.getParagraphs();
                    for (XWPFParagraph para : paras) {
                        this.replaceInPara(para, params);
                    }
                }
            }
        }
    }

    /**
     * 正则匹配字符串
     *
     * @param str
     * @return
     */
    private Matcher matcher(String str) {
        Pattern pattern = Pattern.compile("\\$\\{([^}]*)\\}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }


}


