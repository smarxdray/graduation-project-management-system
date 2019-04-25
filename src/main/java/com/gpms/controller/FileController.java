package com.gpms.controller;

import com.gpms.dao.domain.entity.FileInfo;
import com.gpms.dao.domain.entity.StudentDetail;
import com.gpms.exception.FileException;
import com.gpms.service.CreateService;
import com.gpms.service.ReadService;
import com.gpms.service.UpdateService;
import com.gpms.utils.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/files")
public class FileController {
    private static final Logger log = LoggerFactory.getLogger(FileController.class);

    @Autowired
    private ReadService readService;
    @Autowired
    private CreateService createService;
    @Autowired
    private UpdateService updateService;

    @ResponseBody
    @GetMapping()
    public Response getFiles(@RequestParam("owner") Integer ownerId) {
        List<FileInfo> fileInfos = readService.getFileInfosByOwner(ownerId);
        return fileInfos == null ? Response.errorMsg("获取文件列表失败！")
                : Response.ok(fileInfos);
    }

    @ResponseBody
    @GetMapping("/{id}")
    public Response getFilesById(@PathVariable("id") Integer id) {
        FileInfo fileInfo = readService.getFileInfoById(id);
        return fileInfo == null ? Response.errorMsg("获取文件列表失败！")
                : Response.ok(fileInfo);
    }

    @GetMapping("/{id}/download")
    public ResponseEntity<byte[]> downloadFile(@PathVariable("id") Integer id) throws Exception{
        FileInfo fileInfo = readService.getFileInfoById(id);
        int lines = updateService.setReviewTimes(fileInfo.getOwner());
        if (lines <= 0) return new ResponseEntity<>(null, null, HttpStatus.BAD_REQUEST);
        HttpHeaders headers=new HttpHeaders();
        String filename = fileInfo.getName() + '.' + fileInfo.getExtension();
        filename= URLEncoder.encode(filename, "utf-8");
        headers.add("Content-Disposition", "attachment;filename="+filename);
        return new ResponseEntity<>(readService.read(fileInfo), headers, HttpStatus.OK);
    }

    @ResponseBody
    @PostMapping("/upload")
    public Response handleFileUpload(HttpServletRequest request) {
        List<MultipartFile> files = ((MultipartHttpServletRequest) request).getFiles("file");
        Integer userId = Integer.valueOf(request.getParameter("id"));
        try {
            int lines = createService.write(files, userId);
            return lines <= 0 ? Response.errorMsg("上传失败！") : Response.ok();
        } catch (FileException e) {
            return Response.errorMsg(e.getMsg());
        }
    }
}
