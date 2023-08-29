package com.zhangda.crm.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.Font;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.zhangda.crm.model.po.ContractData;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.*;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * @author zhangda
 * @date: 2023/5/30
 **/
@RestController
@RequestMapping("/contract")
public class ContractController {

    @PostMapping("/export-pdf")
    public void exportPdf(@RequestBody List<ContractData> contractDataList, HttpServletResponse response) {
        // 本地获取
        InputStream inputStream = ContractController.class.getResourceAsStream("/templates/contract.xlsx");

        try {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            // 填充Excel数据
            for (int i = 0; i < contractDataList.size(); i++) {
                ContractData contractData = contractDataList.get(i);
                XSSFRow row = sheet.createRow(i + 1);
                row.createCell(0).setCellValue(contractData.getTitle());
                row.createCell(1).setCellValue(contractData.getName());
                row.createCell(2).setCellValue(contractData.getProduct());
                row.createCell(3).setCellValue(contractData.getQuantity());
                row.createCell(4).setCellValue(contractData.getPrice());

            }

            // 盖章

            // 将 Excel 转换为 PDF
            convertExcelToPdf(workbook, response);

            // 将 Excel 返回给客户端浏览器
//            response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
//            response.setHeader("Content-disposition", "inline; filename=contract.xlsx");
//            workbook.write(response.getOutputStream());

            // 关闭流
            workbook.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        }

    }

    public static void convertExcelToPdf(Workbook workbook, HttpServletResponse response) throws Exception {
        // 创建 PDF 文档对象
        Document document = new Document(PageSize.A4);

        // 使用 iText API 创建 PDF 输出流
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PdfWriter writer = PdfWriter.getInstance(document, outputStream);

        // 使用 DataFormatter 对单元格格式进行转换
        DataFormatter formatter = new DataFormatter();

        // 将 Excel 数据写入 PDF 文档
        document.open();
        // 指定中文字体
        String fontPath = "C:/Windows/Fonts/simsun.ttc";
        BaseFont chineseFont  = BaseFont.createFont(fontPath + ",0", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);

        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            XSSFSheet sheet = (XSSFSheet) workbook.getSheetAt(i);
            PdfPTable table = new PdfPTable(sheet.getRow(0).getLastCellNum()); // 创建表格对象，并指定列数
            table.setWidthPercentage(100f); // 设置表格宽度为 100%
            table.getDefaultCell().setBorder(Rectangle.BOX); // 设置单元格边框类型
            table.getDefaultCell().setBorderColor(BaseColor.BLACK); // 设置单元格边框颜色

            System.out.println("循环行数："+sheet.getLastRowNum());
            for (int j = 0; j <= sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);

                for (Cell cell : row) {

                    String content = formatter.formatCellValue(cell);  // 将单元格值进行格式转换

                    Font fonts = new Font(chineseFont, 12, Font.NORMAL);
                    if (j == 0) {
                        fonts = new Font(chineseFont, 14, Font.BOLD);
                    }

                    PdfPCell pdfCell = new PdfPCell(new Phrase(content, fonts));
                    pdfCell.setUseAscender(true);
                    pdfCell.setVerticalAlignment(Element.ALIGN_MIDDLE);
                    table.addCell(pdfCell);
                }

            }
            document.add(table);
        }

        document.close();
        writer.close();

        // 将 PDF 数据输出给客户端浏览器
        InputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
        response.reset();
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "inline;filename=contract.pdf");
        response.setContentLength(inputStream.available());
        OutputStream out = response.getOutputStream();

        int bytesRead = -1;
        byte[] buffer = new byte[4096];
        while ((bytesRead = inputStream.read(buffer)) != -1) {
            out.write(buffer, 0, bytesRead);
        }

        out.flush();
        out.close();
        inputStream.close();
        outputStream.close();
    }


}
