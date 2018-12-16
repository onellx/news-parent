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

    /**
     *查找图片列表
     * @return
     */
    NewsResult findPictureList();

    /**
     *更新图片信息
     * @param image 图片信息
     * @return
     */
    NewsResult updatePicture(Image image);

    /**
     *根据图片ID查找图片信息
     * @param id 图片id
     * @return
     */
    NewsResult findPictureById(Integer id);

    /**
     *添加图片
     * @param image 图片信息
     * @return
     */
    NewsResult savePicture(Image image);
}
