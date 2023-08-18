package com.washuu.s2.pojo;

import lombok.Data;

/**
 * 自定义封装, 文件实体类
 * @Author Washuu
 */
@Data
public class FastDFSFile {

    //文件名字
    private String fileName;
    //文件内容
    private byte[] content;
    //文件扩展名
    private String ext;
    //文件MD5摘要值
    private String md5;
    //文件创建作者
    private String author;



}


