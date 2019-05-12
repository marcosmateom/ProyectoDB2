/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gio.co.seguros.Auth;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import org.json.JSONArray;
import org.json.JSONObject;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 *
 * @author migue
 */
public class excelAuth {
    private static String[] columns = {"idAuth","hospital", "servicio", "dpi", "fecha", "monto", "porcentaje", "idCita"};
    private static List<excelStruct> data = new ArrayList<excelStruct>();
    
    public static void fillColumns() throws FileNotFoundException, IOException{
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Autorizaciones");
        Row headerRow = sheet.createRow(0);
        for (int i = 0; i < columns.length; i++) {
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(columns[i]);
        }
        // Create Other rows and cells with contacts data
        int rowNum = 1;

        for (excelStruct datos : data) {
          Row row = sheet.createRow(rowNum++);
          row.createCell(0).setCellValue(datos.hospital);
          row.createCell(1).setCellValue(datos.servicio);
          row.createCell(2).setCellValue(datos.dpi);
          row.createCell(3).setCellValue(datos.fecha);
          row.createCell(4).setCellValue(datos.monto);
          row.createCell(5).setCellValue(datos.porcentaje);
          row.createCell(6).setCellValue(datos.idCita);
          row.createCell(7).setCellValue(datos.idAuth);
        }

        // Resize all columns to fit the content size
        for (int i = 0; i < columns.length; i++) {
          sheet.autoSizeColumn(i);
        }

        // Write the output to a file
        FileOutputStream fileOut = new FileOutputStream("auths.xlsx");
        workbook.write(fileOut);
        fileOut.close();
      }
    public static void llenarLista(String fechaD) throws MalformedURLException{
            try{
                URL url = new URL("http://localhost:8080/proyectoDB2-seguro/GetAuth?fecha="+fechaD);
                HttpURLConnection conn = (HttpURLConnection) url.openConnection();
                conn.setDoOutput(true);
                OutputStreamWriter wr = new OutputStreamWriter(conn.getOutputStream());
                wr.flush();
                // Get the response
                BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                StringBuffer response2 = new StringBuffer();
                while ((line = rd.readLine()) != null) {
                    response2.append(line);
                }
                JSONArray obj2 = new JSONArray(response2.toString());
                for(int i = 0; i<obj2.length();i++){
                    JSONObject obj = obj2.getJSONObject(i);
                    int hospital = obj.getInt("hospital");
                    String servicio = obj.getString("servicio");
                    String dpi = obj.getString("dpi");
                    String fecha = obj.getString("fecha");
                    int monto = obj.getInt("monto");
                    double porcentaje = obj.getDouble("porcentaje");
                    int idCita = obj.getInt("idCita");
                    int idAuth = obj.getInt("_id");
                    excelStruct datos = new excelStruct(hospital,servicio,dpi,fecha,monto,porcentaje,idCita,idAuth);
                    data.add(datos);
                }
                wr.close();
                rd.close();
                fillColumns();
            } catch (Exception e) {
                System.err.println(e);
            }
    }
    
   
    
}
