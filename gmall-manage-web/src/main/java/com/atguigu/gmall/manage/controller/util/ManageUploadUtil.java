package com.atguigu.gmall.manage.controller.util;

import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public final class ManageUploadUtil {
    public static final String  IMGURL ="http://192.168.152.250:22122/";
    public static String imgUpload(MultipartFile multipartFile) {
        String imgUrl = ManageUploadUtil.IMGURL;

        try {
            ClientGlobal.init("tracker.conf");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();

            StorageClient storageClient = new StorageClient(trackerServer, null);

            String originalFilename = multipartFile.getOriginalFilename();
            int i = originalFilename.lastIndexOf(".")+1;
            String ext_name = originalFilename.substring(i);

            String[] gifs = storageClient.upload_file(multipartFile.getBytes(), "ext_name", null);

            for (String stringfile : gifs) {
                imgUrl += stringfile;
            }
            return imgUrl;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }
}
