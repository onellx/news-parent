package com.news.service;

import com.news.po.NewsResult;
import com.news.pojo.Image;

/**
 * @ClassName PictureService
 * @Author One_llx
 * @Date 2018/12/1 0001 下午 4:27
 * @Version 1.0
 */
public interface PictureService {


    NewsResult findPictureList();

    NewsResult updatePicture(Image image);

    NewsResult findPictureById(Integer id);

    NewsResult savePicture(Image image);
}
