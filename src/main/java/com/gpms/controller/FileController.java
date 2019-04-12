package com.gpms.controller;

import com.gpms.dao.domain.entity.FileInfo;
import com.gpms.exception.FileException;
import com.gpms.service.FileService;
import com.gpms.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.List;

@Controller
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    FileService fileService;

    @PostMapping("/upload")
    @ResponseBody
    public Response handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        Integer userId = Integer.valueOf(request.getParameter("id"));
        try {
            int lines = fileService.batch(files, userId);
            return lines <= 0 ? Response.errorMsg("上传失败！") : Response.ok();
        } catch (FileException e) {
            return Response.errorMsg(e.getMsg());
        }
    }

    @GetMapping("/download/{id}")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("id") Integer id) throws Exception{
        FileInfo fileInfo = fileService.getFileInfoById(id);
        if (fileInfo == null) return new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
        HttpHeaders headers=new HttpHeaders();
        String filename = fileInfo.getName() + '.' + fileInfo.getExtension();
        filename= URLEncoder.encode(filename, "utf-8");
        headers.add("Content-Disposition", "attachment;filename="+filename);
        return new ResponseEntity<byte[]>(fileService.read(fileInfo), headers, HttpStatus.OK);
    }
}
