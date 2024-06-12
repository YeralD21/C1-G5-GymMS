package com.example.mspagomembresia.controller;

import com.example.mspagomembresia.entity.Pagomembresia;
import com.example.mspagomembresia.service.PagoMembresiaService;
import com.example.mspagomembresia.util.PdfUtils;
import com.example.mspagomembresia.util.UserExcelExporter;
import com.itextpdf.text.DocumentException;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
@RestController
@RequestMapping("/pagomembresia")
public class PagomembresiaController {
    @Autowired
    private PagoMembresiaService pagoMembresiaService;

    @GetMapping
    public ResponseEntity<List<Pagomembresia>> listar(){
        return ResponseEntity.ok(pagoMembresiaService.listar());
    }

    @PostMapping
    public ResponseEntity<Pagomembresia> guardar(@RequestBody Pagomembresia pagomembresia){

        return  ResponseEntity.ok(pagoMembresiaService.guardar(pagomembresia));

    }
    @GetMapping("/{id}")
    public ResponseEntity<Pagomembresia> buscarPorId(@PathVariable(required = true) Integer id){
        return  ResponseEntity.ok(pagoMembresiaService.buscarPorId(id));

    }

    @PutMapping("/{id}")
    public ResponseEntity<Pagomembresia> editar(@PathVariable(required = true)Integer id, @RequestBody Pagomembresia pagomembresia){
        return ResponseEntity.ok(pagoMembresiaService.editar(pagomembresia));
    }

    @DeleteMapping("/{id}")
    public String eliminar(@PathVariable(required = true) Integer id){
        pagoMembresiaService.eliminar(id);
        return "Eliminacion Correcta";

    }
    @GetMapping("/pdf")
    public ResponseEntity<byte[]> exportPdf() throws IOException, DocumentException {
        // List<Map<String, Object>> queryResults = myService.executeQuery(request);
        ByteArrayOutputStream pdfStream = PdfUtils.generatePdfStream(pagoMembresiaService.listar()
        );
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=query_results.pdf");
        headers.setContentLength(pdfStream.size());
        return new ResponseEntity<>(pdfStream.toByteArray(), headers, HttpStatus.OK);
    }
    @GetMapping("/excel")
    public void exportToExcel(HttpServletResponse response) throws IOException {
        response.setContentType("application/octet-stream");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".xlsx";
        response.setHeader(headerKey, headerValue);

        List<Pagomembresia> pagomembresias = pagoMembresiaService.listar();

        UserExcelExporter excelExporter = new UserExcelExporter(pagomembresias);

        excelExporter.export(response);
    }
}

