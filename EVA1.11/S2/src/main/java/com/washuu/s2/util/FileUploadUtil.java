package com.washuu.s2.util;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.model.ObjectMetadata;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.StorageClass;
import com.qcloud.cos.model.UploadResult;
import com.qcloud.cos.transfer.TransferManager;
import com.qcloud.cos.transfer.Upload;
import com.washuu.s2.TencentCOS.Common.Common;
import com.washuu.s2.domain.User;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class FileUploadUtil {

    public static Map<String, Object> fileUpload(
            @RequestParam MultipartFile img, HttpSession session
            )
    {
        String date = DateUtil.getDate();
        User user = (User)session.getAttribute("user");
        //这个就相当于是webapp文件夹的位置，括号里面的参数是需要拼接的字符串，相当于是在webapp中新建的文件夹
        //而且这个新建文件夹的名字就是这个参数
        String realPath = session.getServletContext().getRealPath("/upload");//找到参数在项目文件中的绝对路径，其中，根路径是项目文件
        realPath += File.separator + date + File.separator + user.getUserName();
        File file = new File(realPath);
        if(!file.exists()) {
            file.mkdirs();
        }
        String fileName = img.getOriginalFilename();
        //这个fileName在拼接的时候，会不会覆盖掉文件后缀啊？
        fileName = System.currentTimeMillis() + fileName;
        Map<String, Object> map = new HashMap<>();
        String url = "http://localhost/MyS2/upload/" + date + File.separator +
                user.getUserName() + File.separator + fileName;
        try {
            //新建的文件夹位置需要和url对应
            //transferTo()这个函数有两个功能：一个是创建文件，还有一个是刷新数据流————即写入磁盘
            //需要注意，transferTo()创建的是文件，而不是文件夹
            img.transferTo(new File(realPath + File.separator + fileName));
            map.put("success", 1);
            map.put("url", url);
            System.out.println("url = " + url);
            System.out.println("realPath + File.separator + fileName : " + realPath + File.separator + fileName);
        } catch(IOException e) {
            e.printStackTrace();
    }
        return map;
    }

    public static Map<String, Object> uploadCOS( @RequestParam MultipartFile img, HttpSession session) {
        String date = DateUtil.getDate();
        User user = (User)session.getAttribute("user");
        //这个就相当于是webapp文件夹的位置，括号里面的参数是需要拼接的字符串，相当于是在webapp中新建的文件夹
        //而且这个新建文件夹的名字就是这个参数
//        String realPath = session.getServletContext().getRealPath("/upload");//找到参数在项目文件中的绝对路径，其中，根路径是项目文件
        String realPath = user.getUserName() + "/" + date;
//        realPath += File.separator + date + File.separator + user.getUserName();

        String fileName = img.getOriginalFilename();
        //这个fileName在拼接的时候，会不会覆盖掉文件后缀啊？
        fileName = System.currentTimeMillis() + fileName;
        Map<String, Object> map = new HashMap<>();
        String key = realPath + "/" +fileName;
        TransferManager transferManager = Common.createTransferManager();
        ObjectMetadata objectMetadata = new ObjectMetadata();
        try {
            PutObjectRequest putObjectRequest = new PutObjectRequest("mys2-1312072534",
                    key, img.getInputStream(), objectMetadata);
            putObjectRequest.setStorageClass(StorageClass.Standard_IA);
            Upload upload = transferManager.upload(putObjectRequest);
            UploadResult uploadResult = upload.waitForUploadResult();
            COSClient cosClient = Common.getCOSClient();
            String url = cosClient.getObjectUrl("mys2-1312072534", key).toString();
            map.put("success", 1);
            map.put("url", url);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            Common.shutdownTransferManager(transferManager);
        }
        return map;
    }

}
