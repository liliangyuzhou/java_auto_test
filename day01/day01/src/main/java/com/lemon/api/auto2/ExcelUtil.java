package com.lemon.api.auto2;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import static org.apache.poi.ss.usermodel.CellType.STRING;

public class ExcelUtil {
    public static void main(String[] args){
        Object[][] datas=datas("/Users/liliang/IdeaProjects/day01/src/main/resources/testcase_V1.xlsx",2,7,6,7);
        for (Object[] data: datas) {
            for (Object object:data) {
                System.out.print(object);
            }
            System.out.println();

        }




    }

    /**
     * @param excelpath execl文件的路径
     * @param startrow 开始的行数
     * @param endrow 结束的行数
     * @param startcell 开始的列数
     * @param endcell 结束的列数
     * @return
     */
    public static Object [][] datas(String excelpath,int startrow,int endrow,int startcell,int endcell){
        /*
        这里的startrow,endrow,startcell,endcell都是指的行号和列号，而不是索引
         */
        Object [][] datas=null;
        try {
        //1.获取workbook对象
            Workbook workbook=WorkbookFactory.create(new File(excelpath));
        //2.获取sheet对象
            Sheet sheet=workbook.getSheet("register");

            datas=new Object[endrow-startrow+1][endcell-startcell+1];

            for (int i = startrow; i <=endrow ; i++) {
                //3.获取行
                Row row=sheet.getRow(i-1);
                for (int j = startcell; j <=endcell; j++) {
                    //4.获取列
                    Cell cell=row.getCell(j-1);
                    //这里设置单元格的值的类型为string，方便后面处理数据
                    cell.setCellType(CellType.STRING);
                    String value=cell.getStringCellValue();
//                    System.out.println(value);
                    datas[i-startrow][j-startcell]=value;


                }
        //4.获取列
//            Iterator<Cell> cells=row.cellIterator();
//            for (Iterator<Cell> it = cells; it.hasNext(); ) {
//                Cell cell = it.next();
//                System.out.println(cell);
//            }



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return datas;
    }


    /**可以在数组中输入不连续的行和列
     * @param excelpath excel的路径
     * @param rows 行数的数组
     * @param cells 列数的数组
     * @return
     */
    public static Object [][] datas(String excelpath,int[] rows,int[] cells){
        /*
        这里的startrow,endrow,startcell,endcell都是指的行号和列号，而不是索引
         */
        Object [][] datas=null;
        try {
            //1.获取workbook对象
            Workbook workbook=WorkbookFactory.create(new File(excelpath));
            //2.获取sheet对象
            Sheet sheet=workbook.getSheet("register");

            datas=new Object[rows.length][cells.length];

            for (int i = 0; i <rows.length ; i++) {
                //3.根据索引获取行
                Row row=sheet.getRow(rows[i]-1);
                for (int j = 0; j <cells.length; j++) {
                    //4.根据索引获取列
                    Cell cell=row.getCell(cells[j]-1);
                    //这里设置单元格的值的类型为string，方便后面处理数据
                    cell.setCellType(CellType.STRING);
                    String value=cell.getStringCellValue();
//                    System.out.println(value);
                    //根据索引获取行跟列
                    datas[i][j]=value;


                }
                //4.获取列
//            Iterator<Cell> cells=row.cellIterator();
//            for (Iterator<Cell> it = cells; it.hasNext(); ) {
//                Cell cell = it.next();
//                System.out.println(cell);
//            }



            }
        } catch (Exception e) {
            e.printStackTrace();
        }


        return datas;
    }




}