package com.crledu.auto.excel.utils;

import com.crledu.auto.excel.annotation.ColumnLabel;
import com.crledu.auto.excel.annotation.ExcelHeader;
import com.crledu.auto.excel.dto.ColumnSettings;
import com.crledu.auto.excel.dto.ExcelSettings;
import com.crledu.auto.util.ObjectUtils;
import com.crledu.auto.util.date.DateUtils;
import com.crledu.auto.util.string.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.hibernate.validator.internal.util.StringHelper;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.attribute.AclFileAttributeView;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

/**
 ************************************************************
 * @Description: excel文件相关工具方法
 * @Version: v1.1.1
 ************************************************************
 * @CopyrightBy: 创享源信息技术有限公司
 * @author: wenyi
 * @Date: 2021/4/12 16:08
 ************************************************************
 * @ModifiedBy: [name] on [time]
 ************************************************************
**/
public class ExcelFileUtils {

    private static ArrayList<String> PoiDateList = new ArrayList<String>() {
        {
            add("年");
            add("月");
            add("日");
        }
    };

    public static Workbook exportFile(List list){
        Workbook workbook = buildWorkbook();
        if(ObjectUtils.isNull(list)||list.size() == 0){
            return workbook;
        }else{
            //数组中有数据。检查数据内容是否为自动表格注解类型
            ExcelSettings settings = parseModel(list.get(0));
            //生成表头
            Integer columnSize = settings.getColumnSettings().size();
            Sheet sheet = workbook.createSheet();
            CellRangeAddress rangeAddress = new CellRangeAddress(0,0,0,columnSize-1);
            sheet.addMergedRegion(rangeAddress);
            Row nameRow = sheet.createRow(0);
            Cell titleCell = nameRow.createCell(0);
            titleCell.setCellValue(settings.getName());
            //生成表头内容
            Row titleRow = sheet.createRow(settings.getBeginData()-1);
            for(int labelNum = 0;labelNum<settings.getColumnSettings().size();labelNum++){
                Cell cell = titleRow.createCell(labelNum);
                cell.setCellValue(settings.getColumnSettings().get(labelNum).getName());
            }

            //生成数据内容
            for(int rowNum=0;rowNum<list.size();rowNum++){
                Row dataRow = sheet.createRow(rowNum+settings.getBeginData());
                for(int i = 0;i<settings.getColumnSettings().size();i++){
                    ColumnSettings column = settings.getColumnSettings().get(i);
                    Cell cell = dataRow.createCell(i);
                    try {
                        Object value = column.getGetMethod().invoke(list.get(rowNum));
                        if(value instanceof Date){
                            Date date = (Date) value;
                            cell.setCellValue(date);
                        }else if(ObjectUtils.isNotNull(value)){
                            cell.setCellValue(value.toString());
                        }
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    }

                }
            }
        }
        return workbook;
    }

    public static <T> List<T> parseExcel(String filePath,Class<T> clazz){
        Workbook workbook = buildWorkbook(filePath);
        return parseExcel(workbook,clazz);
    }

    public static <T> List<T> parseExcel(File file,Class<T> clazz){
        Workbook workbook = buildWorkbook(file);
        return parseExcel(workbook,clazz);
    }

    private static <T> List<T> parseExcel(Workbook workbook,Class<T> clazz){
        ExcelSettings excelSettings = readExcelSettings(clazz);
        //为了兼容溢出数据表格，只能使用列名来对应表格数据
        Sheet indexSheet = readSheet(workbook);
        Row titleRow = readTitleRow(excelSettings.getBeginData(),indexSheet);
        //修改表格配置让表格设置中的列号可以正确适配表格数据
        for(int i=0;i<excelSettings.getColumnSettings().size();i++){
            ColumnSettings columnSetting = excelSettings.getColumnSettings().get(i);
            columnSetting.setIndex(null);
            if(columnSetting.getName().trim().isEmpty()){
                //列名没有配置忽略
                continue;
            }
            for(int j = 0;j<=titleRow.getLastCellNum();j++){
                Cell cell = titleRow.getCell(j);
                if(ObjectUtils.isNotNull(cell)){
                    String title = getValueByCellStyle(cell,cell.getCellTypeEnum());
                    if(title.trim().equals(columnSetting.getName().trim())){
                        columnSetting.setIndex(j);
                        break;
                    }
                }
            }
        }
        //读取数据并设置到相应的对象上
        List<T> result = new ArrayList<>();
        for(int a = excelSettings.getBeginData();a<=indexSheet.getLastRowNum();a++){
            try{
                Row itemRow = indexSheet.getRow(a);
                Constructor<T> itemConstructor = clazz.getConstructor();
                T itme = itemConstructor.newInstance();
                for(ColumnSettings columnSetting:excelSettings.getColumnSettings()){
                    if(ObjectUtils.isNull(columnSetting.getIndex())){
                        continue;
                    }else{
                        Cell cell = itemRow.getCell(columnSetting.getIndex());
                        Method setMethod = columnSetting.getSetMethod();
                        readCellValue(cell,setMethod,itme);
                    }
                }
                result.add(itme);
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void readCellValue(Cell cell,Method method,Object item){
        int count = method.getParameterCount();
        if(count == 1){
            Class parameterType = method.getParameterTypes()[0];
            try {
                method.invoke(item, readCellValue(cell, parameterType));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
        }

    }

    public static <T> T readCellValue(Cell cell,Class<T> clazz){
        Object value = getCellValue(cell,cell.getCellTypeEnum());
        if(clazz.isInstance(value)){
            return (T) value;
        }else{
            //为了适配更多的数据类型
            Constructor<T> constructor = null;
            try{
                constructor = clazz.getConstructor(value.getClass());
                return constructor.newInstance(value);
            } catch (NoSuchMethodException e) {
                try {
                    constructor = clazz.getConstructor(String.class);
                    return constructor.newInstance(value.toString());
                } catch (NoSuchMethodException ex) {
                    ex.printStackTrace();
                } catch (IllegalAccessException ex) {
                    ex.printStackTrace();
                } catch (InstantiationException ex) {
                    ex.printStackTrace();
                } catch (InvocationTargetException ex) {
                    ex.printStackTrace();
                }
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }
            return null;
        }

    }

    public static String getValueByCellStyle(Cell rowCell, CellType rowCellType) {
        String value = "";
        switch (rowCellType.name()) {
            case "STRING":
                value = rowCell.getStringCellValue();
                break;
            case "NUMERIC":
                //  获取单元格值的格式化信息
                String dataFormat = rowCell.getCellStyle().getDataFormatString();
                //  判断格式化信息中是否存在：年月日
                AtomicReference<Boolean> isDate = new AtomicReference<>(false);
                if (!StringUtils.IsNullOrWhiteSpace(dataFormat)) {
                    PoiDateList.forEach(x -> isDate.set(isDate.get() || dataFormat.contains(x)));
                }
                if (DateUtil.isCellDateFormatted(rowCell)) {
                    value = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(rowCell.getNumericCellValue()));
                } else if (DateUtil.isCellInternalDateFormatted(rowCell)) {
                    value = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(rowCell.getNumericCellValue()));
                }
                //有些情况，时间搓？数字格式化显示为时间,不属于上面两种时间格式
                else if (isDate.get()) {
                    value = new SimpleDateFormat("yyyy-MM-dd").format(rowCell.getDateCellValue());
                }
                //有些情况，时间搓？数字格式化显示为时间,不属于上面两种时间格式
                else if (dataFormat == null) {
                    value = new SimpleDateFormat("yyyy-MM-dd").format(DateUtil.getJavaDate(rowCell.getNumericCellValue()));
                } else {
                    if (StringUtils.IsNullOrWhiteSpace(dataFormat)) {
                        value = String.valueOf(rowCell.getNumericCellValue());
                    } else {
                        if (rowCell.getCellStyle().getDataFormatString().contains("$")) {
                            value = "$" + rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("￥")) {
                            value = "￥" + rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("¥")) {
                            value = "¥" + rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("€")) {
                            value = "€" + String.valueOf(rowCell.getNumericCellValue());
                        } else {
                            value = String.valueOf(rowCell.getNumericCellValue());
                        }
                    }
                }
                break;
            case "BOOLEAN":
                value = String.valueOf(rowCell.getBooleanCellValue());
                break;
            case "ERROR":
                value = ErrorEval.getText(rowCell.getErrorCellValue());
                break;
            case "FORMULA":
                //  TODO: 是否存在 嵌套 公式类型
                value = getValueByCellStyle(rowCell, rowCell.getCachedFormulaResultTypeEnum());
                break;
            default:
                System.out.println(rowCell);
                break;
        }
        return value;
    }

    public static Object getCellValue(Cell rowCell, CellType rowCellType) {
        switch (rowCellType.name()) {
            case "STRING":
                return rowCell.getStringCellValue();
            case "NUMERIC":
                //  获取单元格值的格式化信息
                String dataFormat = rowCell.getCellStyle().getDataFormatString();
                //  判断格式化信息中是否存在：年月日
                AtomicReference<Boolean> isDate = new AtomicReference<>(false);
                if (!StringUtils.IsNullOrWhiteSpace(dataFormat)) {
                    PoiDateList.forEach(x -> isDate.set(isDate.get() || dataFormat.contains(x)));
                }
                if (DateUtil.isCellDateFormatted(rowCell)) {
                    return DateUtil.getJavaDate(rowCell.getNumericCellValue());
                } else if (DateUtil.isCellInternalDateFormatted(rowCell)) {
                    return DateUtil.getJavaDate(rowCell.getNumericCellValue());
                }
                //有些情况，时间搓？数字格式化显示为时间,不属于上面两种时间格式
                else if (isDate.get()) {
                    return rowCell.getDateCellValue();
                }
                //有些情况，时间搓？数字格式化显示为时间,不属于上面两种时间格式
                else if (dataFormat == null) {
                    return DateUtil.getJavaDate(rowCell.getNumericCellValue());
                } else {
                    if (StringUtils.IsNullOrWhiteSpace(dataFormat)) {
                        return rowCell.getNumericCellValue();
                    } else {
                        if (rowCell.getCellStyle().getDataFormatString().contains("$")) {
                            return rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("￥")) {
                            return rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("¥")) {
                            return rowCell.getNumericCellValue();
                        } else if (rowCell.getCellStyle().getDataFormatString().contains("€")) {
                            return rowCell.getNumericCellValue();
                        } else {
                            return rowCell.getNumericCellValue();
                        }
                    }
                }
            case "BOOLEAN":
                return rowCell.getBooleanCellValue();
            case "ERROR":
                return ErrorEval.getText(rowCell.getErrorCellValue());
            case "FORMULA":
                //  TODO: 是否存在 嵌套 公式类型
                return getValueByCellStyle(rowCell, rowCell.getCachedFormulaResultTypeEnum());
            default:
                System.out.println(rowCell);
                return null;
        }
    }

    public static Workbook buildWorkbook(){
        return new HSSFWorkbook();
    }

    public static Workbook buildWorkbook(File file){
        if(file.exists()){
            try {
                Workbook workbook = WorkbookFactory.create(file);
                return workbook;
            } catch (InvalidFormatException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return buildWorkbook();
    }

    public static Workbook buildWorkbook(String filePath){
        File file = new File(filePath);
        return buildWorkbook(file);
    }

    public static Sheet readSheet(Workbook workbook,Integer index){
        if(ObjectUtils.isNull(index)){
            return readSheet(workbook);
        }else{
            return workbook.getSheetAt(index);
        }
    }

    public static Sheet readSheet(Workbook workbook){
        return workbook.getSheetAt(0);
    }

    public static Row readTitleRow(Sheet sheet){
        return sheet.createRow(ExcelSettings.DEFAULT_BEGIN_ROW-1);
    }

    public static Row readTitleRow(Integer beginRowNum,Sheet sheet){
        if(ObjectUtils.isNull(beginRowNum)){
            return readTitleRow(sheet);
        }else{
            return sheet.getRow(beginRowNum-1);
        }
    }

    private static ExcelSettings readExcelSettings(Class clazz){
        ExcelSettings excelSettings = new ExcelSettings();
        //解析表格的表头。
        boolean isExcelModel = clazz.isAnnotationPresent(ExcelHeader.class);
        if(isExcelModel){
            ExcelHeader header = (ExcelHeader) clazz.getDeclaredAnnotation(ExcelHeader.class);
            excelSettings.setName(header.name());
            excelSettings.setBeginData(header.begin());
            excelSettings.setDate(header.date());
        }else{
            excelSettings.setName("未定义表格");
        }
        //解析列属性
        Field[] fields = clazz.getDeclaredFields();
        List<ColumnSettings> columnSettingsList = new ArrayList<>();
        if(ObjectUtils.isNotNull(fields)&&fields.length > 0){
            for(Field field: fields){
                boolean isExcelColumn = field.isAnnotationPresent(ColumnLabel.class);
                if(isExcelColumn){
                    ColumnLabel columnLabel = field.getAnnotation(ColumnLabel.class);
                    ColumnSettings columnSetting = new ColumnSettings();
                    columnSetting.setName(columnLabel.name());
                    columnSetting.setIndex(columnLabel.index());
                    try{
                        PropertyDescriptor pd = new PropertyDescriptor(field.getName(), clazz);
                        columnSetting.setGetMethod(pd.getReadMethod());
                        columnSetting.setSetMethod(pd.getWriteMethod());
                    } catch (IntrospectionException e) {
                        e.printStackTrace();
                    }
                    columnSettingsList.add(columnSetting);
                }
            }
        }
        columnSettingsList.sort(new Comparator<ColumnSettings>() {
            @Override
            public int compare(ColumnSettings o1, ColumnSettings o2) {
                return Integer.compare(o1.getIndex(),o2.getIndex());
            }
        });
        excelSettings.setColumnSettings(columnSettingsList);
        return excelSettings;
    }

    private static ExcelSettings parseModel(Object o){
        //解析表格模型1、解析表头2、解析列
        Class clazz = o.getClass();
        return readExcelSettings(clazz);
    }
}
