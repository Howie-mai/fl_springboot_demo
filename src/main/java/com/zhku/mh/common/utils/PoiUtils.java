package com.zhku.mh.common.utils;

import com.zhku.mh.entities.DTO.EmployeeDTO;
import com.zhku.mh.entities.Employee;
import org.apache.poi.hpsf.DocumentSummaryInformation;
import org.apache.poi.hpsf.SummaryInformation;
import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

public class PoiUtils {

    public static ResponseEntity<byte[]> exportEmpExcel(List<EmployeeDTO> dataList){
        HttpHeaders headers = null;
        ByteArrayOutputStream  baos = null;
        try {
            HSSFWorkbook workbook = PoiUtilsV2.getWorkbook(dataList);
            headers = new HttpHeaders();
            headers.setContentDispositionFormData("attachment",
                        new String("vHr员工表.xls".getBytes("UTF-8"), "ISO8859-1"));
            headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
            baos = new ByteArrayOutputStream();
            workbook.write(baos);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<byte[]>(baos.toByteArray(), headers, HttpStatus.CREATED);
    }
}
