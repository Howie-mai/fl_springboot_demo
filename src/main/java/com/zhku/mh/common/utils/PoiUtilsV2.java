package com.zhku.mh.common.utils;

import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.*;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class PoiUtilsV2 {

    public static void exportEmpExcel(List<EmployeeDTO> dataList, OutputStream out) throws IOException {
       HSSFWorkbook workbook = PoiUtilsV2.getWorkbook(dataList);
        try {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
        }
    }

    public static Map<String, Object> importEmpList(MultipartFile file, Map<String, Object> basicMap) {
        Map<String, Object> map = new HashMap<>();
        List<String> msgList = new ArrayList<>();
        List<EmployeeDTO> empList = new ArrayList<>();
        List<Nation> nations = (List<Nation>) basicMap.get("nations");
        List<Politicsstatus> politics = (List<Politicsstatus>) basicMap.get("politics");
        List<Department> deps = (List<Department>) basicMap.get("deps");
        List<Position> positions = (List<Position>) basicMap.get("positions");
        List<JobLevel> joblevels = (List<JobLevel>) basicMap.get("joblevels");
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new POIFSFileSystem(file.getInputStream()));
            int numberOfSheets = workbook.getNumberOfSheets();
            for (int i = 0; i < numberOfSheets; i++) {
                HSSFSheet sheet = workbook.getSheetAt(i);
                int physicalNumberOfRows = sheet.getPhysicalNumberOfRows();
                for (int j = 0; j < physicalNumberOfRows; j++) {
                    if (j == 0) {
                        continue; // 标题行
                    }
                    HSSFRow row = sheet.getRow(j);
                    if (row == null) {
                        continue;
                    }
                    int physicalNumberOfCells = row.getPhysicalNumberOfCells();
                    EmployeeDTO employeeDTO = new EmployeeDTO();
                    for (int k = 0; k < physicalNumberOfCells; k++) {
                        HSSFCell cell = row.getCell(k);
                        switch (cell.getCellTypeEnum()) {
                            case STRING: {
                                String cellValue = cell.getStringCellValue();
                                if (cellValue == null) {
                                    map.put("result", -1);
                                    int cellLine = k + 1;
                                    msgList.add("（第 " + j + "行，第" + cellLine + " 列）" + "数据不能为空");
                                }
                                switch (k) {
                                    case 1:
                                        employeeDTO.setName(cellValue);
                                        break;
                                    case 2:
                                        employeeDTO.setWorkid(cellValue);
                                        break;
                                    case 3:
                                        employeeDTO.setGender(cellValue);
                                        break;
                                    case 5:
                                        employeeDTO.setIdcard(cellValue);
                                        break;
                                    case 6:
                                        employeeDTO.setWedlock(cellValue);
                                        break;
                                    case 7:
                                        int nationIndex = nations.indexOf(new Nation(cellValue));
                                        employeeDTO.setNationid(nations.get(nationIndex).getId());
                                        break;
                                    case 8:
                                        employeeDTO.setNativeplace(cellValue);
                                        break;
                                    case 9:
                                        int psIndex = politics.indexOf(new Politicsstatus(cellValue));
                                        employeeDTO.setPoliticid(politics.get(psIndex).getId());
                                        break;
                                    case 10:
                                        employeeDTO.setPhone(cellValue);
                                        break;
                                    case 11:
                                        employeeDTO.setAddress(cellValue);
                                        break;
                                    case 12:
                                        int depIndex = deps.indexOf(new Department(cellValue));
                                        employeeDTO.setDepartmentid(deps.get(depIndex).getId());
                                        break;
                                    case 13:
                                        int jlIndex = joblevels.indexOf(new JobLevel(cellValue));
                                        employeeDTO.setJoblevelid(joblevels.get(jlIndex).getId());
                                        break;
                                    case 14:
                                        int posIndex = positions.indexOf(new Position(cellValue));
                                        employeeDTO.setPosid(positions.get(posIndex).getId());
                                        break;
                                    case 15:
                                        employeeDTO.setEngageform(cellValue);
                                        break;
                                    case 16:
                                        employeeDTO.setTiptopdegree(cellValue);
                                        break;
                                    case 17:
                                        employeeDTO.setSpecialty(cellValue);
                                        break;
                                    case 18:
                                        employeeDTO.setSchool(cellValue);
                                        break;
                                    case 20:
                                        employeeDTO.setWorkstate(cellValue);
                                        break;
                                    case 21:
                                        employeeDTO.setEmail(cellValue);
                                        break;
                                    /*
                                     * 日期格式错误
                                     */
                                    case 4:
                                    case 19:
                                    case 23:
                                    case 24:
                                        map.put("result", -1);
                                        int cellLine = k+1;
                                        msgList.add("（第 " + j + "行，第" + cellLine + " 列）" + "日期格式错误");
                                        break;
                                }
                            }
                            break; //case.String
                            /*
                             *  数字和日期
                             */
                            case NUMERIC: {
                                Double cellValue = cell.getNumericCellValue();
                                if (cellValue == null) {
                                    map.put("result", -1);
                                    int cellLine = k + 1;
                                    msgList.add("（第 " + j + "行，第" + cellLine + " 列）" + "数据不能为空");
                                }
                                switch (k) {
                                    case 22:
                                        employeeDTO.setContractterm(cellValue);
                                        break;
                                }
                            }
                            default: {
                                Date cellValue = cell.getDateCellValue();
                                if (cellValue == null) {
                                    map.put("result", -1);
                                    int cellLine = k + 1;
                                    msgList.add("（第 " + j + "行，第" + cellLine + " 列）" + "数据不能为空");
                                }
                                switch (k) {
                                    case 4:
                                        employeeDTO.setBirthday(cell.getDateCellValue());
                                        break;
                                    case 19:
                                        employeeDTO.setBegindate(cell.getDateCellValue());
                                        break;
                                    case 23:
                                        employeeDTO.setBegincontract(cell.getDateCellValue());
                                        break;
                                    case 24:
                                        employeeDTO.setEndcontract(cell.getDateCellValue());
                                        break;
                                }
                            }
                            break; //default
                        }
                    }
                    empList.add(employeeDTO);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        map.put("msgList", msgList);
        map.put("dto", empList);
        return map;
    }

    public static HSSFWorkbook getWorkbook(List<EmployeeDTO> dataList){
        HSSFWorkbook workbook = new HSSFWorkbook();
        //创建文档摘要
        workbook.createInformationProperties();
        //获取文档信息，并配置
        DocumentSummaryInformation dsi = workbook.getDocumentSummaryInformation();
        //文档类别
        dsi.setCategory("员工信息");
        //文档管理员
        dsi.setManager("mh");
        //组织机构偶
        dsi.setCompany("vHr");
        //获取摘要信息并配置
        SummaryInformation si = workbook.getSummaryInformation();
        //文档主题
        si.setSubject("员工信息表");
        //文档标题
        si.setTitle("员工信息");
        //文档作者
        si.setAuthor("zhku.mh");
        //文档备注
        si.setComments("无备注信息");
        //创建execl表单
        HSSFSheet sheet = workbook.createSheet("vHr员工信息表");
        //创建日期显示格式
        HSSFCellStyle dateCellStyle = workbook.createCellStyle();
        dateCellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy"));
        //创建标题的显示形式
        HSSFCellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillForegroundColor(IndexedColors.YELLOW.index);
        headerStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        //定义列的宽度
        sheet.setColumnWidth(0, 5 * 256);
        sheet.setColumnWidth(1, 12 * 256);
        sheet.setColumnWidth(2, 10 * 256);
        sheet.setColumnWidth(3, 5 * 256);
        sheet.setColumnWidth(4, 12 * 256);
        sheet.setColumnWidth(5, 20 * 256);
        sheet.setColumnWidth(6, 10 * 256);
        sheet.setColumnWidth(7, 10 * 256);
        sheet.setColumnWidth(8, 16 * 256);
        sheet.setColumnWidth(9, 12 * 256);
        sheet.setColumnWidth(10, 15 * 256);
        sheet.setColumnWidth(11, 20 * 256);
        sheet.setColumnWidth(12, 16 * 256);
        sheet.setColumnWidth(13, 14 * 256);
        sheet.setColumnWidth(14, 14 * 256);
        sheet.setColumnWidth(15, 12 * 256);
        sheet.setColumnWidth(16, 8 * 256);
        sheet.setColumnWidth(17, 16 * 256);
        sheet.setColumnWidth(18, 20 * 256);
        sheet.setColumnWidth(19, 12 * 256);
        sheet.setColumnWidth(20, 8 * 256);
        sheet.setColumnWidth(21, 25 * 256);
        sheet.setColumnWidth(22, 14 * 256);
        sheet.setColumnWidth(23, 12 * 256);
        sheet.setColumnWidth(24, 12 * 256);
        sheet.setColumnWidth(25, 12 * 256);
        //5.设置表头
        HSSFRow headerRow = sheet.createRow(0);
        HSSFCell cell0 = headerRow.createCell(0);
        cell0.setCellValue("编号");
        cell0.setCellStyle(headerStyle);
        HSSFCell cell1 = headerRow.createCell(1);
        cell1.setCellValue("姓名");
        cell1.setCellStyle(headerStyle);
        HSSFCell cell2 = headerRow.createCell(2);
        cell2.setCellValue("工号");
        cell2.setCellStyle(headerStyle);
        HSSFCell cell3 = headerRow.createCell(3);
        cell3.setCellValue("性别");
        cell3.setCellStyle(headerStyle);
        HSSFCell cell4 = headerRow.createCell(4);
        cell4.setCellValue("出生日期");
        cell4.setCellStyle(headerStyle);
        HSSFCell cell5 = headerRow.createCell(5);
        cell5.setCellValue("身份证号码");
        cell5.setCellStyle(headerStyle);
        HSSFCell cell6 = headerRow.createCell(6);
        cell6.setCellValue("婚姻状况");
        cell6.setCellStyle(headerStyle);
        HSSFCell cell7 = headerRow.createCell(7);
        cell7.setCellValue("民族");
        cell7.setCellStyle(headerStyle);
        HSSFCell cell8 = headerRow.createCell(8);
        cell8.setCellValue("籍贯");
        cell8.setCellStyle(headerStyle);
        HSSFCell cell9 = headerRow.createCell(9);
        cell9.setCellValue("政治面貌");
        cell9.setCellStyle(headerStyle);
        HSSFCell cell10 = headerRow.createCell(10);
        cell10.setCellValue("电话号码");
        cell10.setCellStyle(headerStyle);
        HSSFCell cell11 = headerRow.createCell(11);
        cell11.setCellValue("联系地址");
        cell11.setCellStyle(headerStyle);
        HSSFCell cell12 = headerRow.createCell(12);
        cell12.setCellValue("所属部门");
        cell12.setCellStyle(headerStyle);
        HSSFCell cell13 = headerRow.createCell(13);
        cell13.setCellValue("职称");
        cell13.setCellStyle(headerStyle);
        HSSFCell cell14 = headerRow.createCell(14);
        cell14.setCellValue("职位");
        cell14.setCellStyle(headerStyle);
        HSSFCell cell15 = headerRow.createCell(15);
        cell15.setCellValue("聘用形式");
        cell15.setCellStyle(headerStyle);
        HSSFCell cell16 = headerRow.createCell(16);
        cell16.setCellValue("最高学历");
        cell16.setCellStyle(headerStyle);
        HSSFCell cell17 = headerRow.createCell(17);
        cell17.setCellValue("专业");
        cell17.setCellStyle(headerStyle);
        HSSFCell cell18 = headerRow.createCell(18);
        cell18.setCellValue("毕业院校");
        cell18.setCellStyle(headerStyle);
        HSSFCell cell19 = headerRow.createCell(19);
        cell19.setCellValue("入职日期");
        cell19.setCellStyle(headerStyle);
        HSSFCell cell20 = headerRow.createCell(20);
        cell20.setCellValue("在职状态");
        cell20.setCellStyle(headerStyle);
        HSSFCell cell21 = headerRow.createCell(21);
        cell21.setCellValue("邮箱");
        cell21.setCellStyle(headerStyle);
        HSSFCell cell22 = headerRow.createCell(22);
        cell22.setCellValue("合同期限(年)");
        cell22.setCellStyle(headerStyle);
        HSSFCell cell23 = headerRow.createCell(23);
        cell23.setCellValue("合同起始日期");
        cell23.setCellStyle(headerStyle);
        HSSFCell cell24 = headerRow.createCell(24);
        cell24.setCellValue("合同终止日期");
        cell24.setCellStyle(headerStyle);
        HSSFCell cell25 = headerRow.createCell(25);
        cell25.setCellValue("转正日期");
        cell25.setCellStyle(headerStyle);
        //装数据
        for (int i = 0; i < dataList.size(); i++) {
            HSSFRow row = sheet.createRow(i + 1);
            EmployeeDTO emp = dataList.get(i);
            row.createCell(0).setCellValue(emp.getId());
            row.createCell(1).setCellValue(emp.getName());
            row.createCell(2).setCellValue(emp.getWorkid());
            row.createCell(3).setCellValue(emp.getGender());
            HSSFCell birthdayCell = row.createCell(4);
            birthdayCell.setCellValue(emp.getBirthday());
            birthdayCell.setCellStyle(dateCellStyle);
            row.createCell(5).setCellValue(emp.getIdcard());
            row.createCell(6).setCellValue(emp.getWedlock());
            row.createCell(7).setCellValue(emp.getNationName());
            row.createCell(8).setCellValue(emp.getNativeplace());
            row.createCell(9).setCellValue(emp.getPoliticsStatusName());
            row.createCell(10).setCellValue(emp.getPhone());
            row.createCell(11).setCellValue(emp.getAddress());
            row.createCell(12).setCellValue(emp.getDepartmentName());
            row.createCell(13).setCellValue(emp.getJobLevelName());
            row.createCell(14).setCellValue(emp.getPositionName());
            row.createCell(15).setCellValue(emp.getEngageform());
            row.createCell(16).setCellValue(emp.getTiptopdegree());
            row.createCell(17).setCellValue(emp.getSpecialty());
            row.createCell(18).setCellValue(emp.getSchool());
            HSSFCell beginDateCell = row.createCell(19);
            beginDateCell.setCellValue(emp.getBegindate());
            beginDateCell.setCellStyle(dateCellStyle);
            row.createCell(20).setCellValue(emp.getWorkstate());
            row.createCell(21).setCellValue(emp.getEmail());
            row.createCell(22).setCellValue(emp.getContractterm());
            HSSFCell beginContractCell = row.createCell(23);
            beginContractCell.setCellValue(emp.getBegincontract());
            beginContractCell.setCellStyle(dateCellStyle);
            HSSFCell endContractCell = row.createCell(24);
            endContractCell.setCellValue(emp.getEndcontract());
            endContractCell.setCellStyle(dateCellStyle);
            HSSFCell conversiontimeCell = row.createCell(25);
            conversiontimeCell.setCellValue(emp.getConversiontime());
            conversiontimeCell.setCellStyle(dateCellStyle);
        }
        return workbook;
    }
}
