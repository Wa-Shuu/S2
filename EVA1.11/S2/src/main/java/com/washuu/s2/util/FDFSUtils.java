package com.washuu.s2.util;

import com.washuu.s2.pojo.FastDFSFile;
import com.washuu.s2.properties.FDFSContent;
import lombok.extern.slf4j.Slf4j;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.csource.fastdfs.pool.Connection;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

@Slf4j
public class FDFSUtils {
    /***
     * 初始化加载FastDFS的TrackerServer配置
     */
    static {
        try {
            String filePath = new ClassPathResource("fdfs_client.conf").getFile().getAbsolutePath();
            ClientGlobal.init(filePath);
        } catch (Exception e) {
            log.error("FastDFS Client Init Fail!",e);
        }
    }

    private static TrackerServer trackerServer = null;
    private static StorageServer storageServer = null;


//     ClientGlobal.init("fdfs_client.conf");
//    TrackerClient trackerClient = new TrackerClient();
//    trackerServer = trackerClient.getTrackerServer();
////            connection = trackerClient.getConnection(trackerServer);
//    storageServer = trackerClient.getStoreStorage(trackerServer);
//    storageClient = new StorageClient(trackerServer, storageServer);
    /***
     * 获取Storage客户端
     */

    private static StorageClient getStorageClient() {
        TrackerClient trackerClient = new TrackerClient();
        StorageClient storageClient = null;
        try {
           TrackerServer trackerServer = trackerClient.getTrackerServer();
           StorageServer storageServer = trackerClient.getStoreStorage(trackerServer);
           storageClient = new StorageClient(trackerServer, storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return storageClient;
    }

//    private StorageClient getStorageClient() {
//        TrackerClient trackerClient = new TrackerClient();
//        StorageClient storageClient = null;
//        storageClient = trackerClient.getStoreStorage(getTrackerServer())
//
//    }
    /***
     * 文件上传
     * @param file
     */
    public static Map<String, String> fileUpload(FastDFSFile file) {
        //获取文件的作者
        NameValuePair[] meta_list = new NameValuePair[1];
        meta_list[0] = new NameValuePair("author", file.getAuthor());
        //接收返回数据
        String[] results = null;
        StorageClient storageClient = getStorageClient();
        /***
         * 文件上传
         * 1)文件字节数组
         * 2)文件扩展名
         * 3)文件作者
         */
        try {
            results = storageClient.upload_file(file.getContent(), file.getExt(), meta_list);
        } catch (Exception e) {
            log.error("Exception when uploadind the file:" + file.getFileName(), e);
        } finally {
            try {
                storageClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (results == null && storageClient!=null) {
            log.error("upload file fail, error code:" + storageClient.getErrorCode());
        }
        Map<String,String> uploadResults = new HashMap<>();
        uploadResults.put(FDFSContent.FILE_GROUP, results[0]);
        uploadResults.put(FDFSContent.FILE_URI, results[1]);
        return uploadResults;
    }


    public static void fileUpload() {
        TrackerServer trackerServer = null;
        StorageServer storageServer = null;
        StorageClient storageClient = null;
        Connection connection = null;
        try {
            ClientGlobal.init("fdfs_client.conf");
            TrackerClient trackerClient = new TrackerClient();
            trackerServer = trackerClient.getTrackerServer();
//            connection = trackerClient.getConnection(trackerServer);
            storageServer = trackerClient.getStoreStorage(trackerServer);
            storageClient = new StorageClient(trackerServer, storageServer);
            String[] uploadArray = storageClient.upload_file("E:\\EdgeDownloads\\fastdfs-client-java-master\\fastdfs-client-java-master\\src\\main\\resources\\fdfs_client.conf", "txt", null);
            for (String str : uploadArray) {
                System.out.println(str);
            }
        }
//        } catch (Exception e) {

//            e.printStackTrace();
//        }
        catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        } finally {
            if(storageClient != null) {
                try {
                    storageClient.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /***
     * 获取文件信息
     * @param groupName:组名
     * @param uri：文件存储完整名
     * @return
     */
    public static FileInfo getFileInfo(String groupName, String uri) {
        try {
            StorageClient storageClient = getStorageClient();
            return storageClient.get_file_info(groupName, uri);
        } catch (Exception e) {
            log.error("Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /***
     * 文件下载(二进制流)
     * @param groupName
     * @param uri
     *
     */
    public static InputStream downloadFile(String groupName, String uri) {
        try {
            //创建StorageClient
            StorageClient storageClient = getStorageClient();
            //下载文件
            byte[] fileByte = storageClient.download_file(groupName, uri);
            InputStream ins = new ByteArrayInputStream(fileByte);
            return ins;
        } catch (Exception e) {
            log.error("Exception: Get File from Fast DFS failed", e);
        }
        return null;
    }

    /***
     * 文件删除
     * @param groupName
     * @param uri
     * @throws Exception
     */
    public static void deleteFile(String groupName, String uri) {
        //创建StorageClient
        StorageClient storageClient = getStorageClient();
        //删除文件
        try {
            int i = storageClient.delete_file(groupName, uri);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /***
     * 获取StorageServer数组
     * @param groupName
     * @return
     * @throws IOException
     */
    public static StorageServer[] getStoreStorages(String groupName)
            throws IOException {
        //创建TrackerClient
        TrackerClient trackerClient = new TrackerClient();
        //获取TrackerServer
        TrackerServer trackerServer = trackerClient.getTrackerServer();
        //获取Storage组
        StorageServer[] storageServers = null;
        try {
            storageServers = trackerClient.getStoreStorages(trackerServer, groupName);
        } catch (MyException e) {
            e.printStackTrace();
        }
        return storageServers;
    }

    /***
     * 获取Storage信息,IP和端口
     * @param groupName
     * @param uri
     * @return
     * @throws IOException
     */
    public static ServerInfo[] getFetchStorages(String groupName, String uri){
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = null;
        ServerInfo[] serverInfos = null;
        try {
            trackerServer = trackerClient.getTrackerServer();
            serverInfos = trackerClient.getFetchStorages(trackerServer, groupName, uri);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return serverInfos;
    }

    /***
     * 获取Tracker服务地址
     * @return
     * @throws IOException
     */
    public static String getTrackerUrl() throws IOException {
        String hostAddr = new TrackerClient().getTrackerServer().getInetSocketAddress().getHostString();
        int port = ClientGlobal.getG_tracker_http_port();
        return String.format("http://%s:%d", hostAddr, port);
    }



}
