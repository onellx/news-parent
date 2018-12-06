package com.news.service.impl;

import com.news.mapper.ImageMapper;
import com.news.po.NewsResult;
import com.news.pojo.Image;
import com.news.pojo.ImageExample;
import com.news.service.PictureService;
import com.news.utils.StateListUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @ClassName PictureServiceImpl
 * @Author One_llx
 * @Date 2018/12/1 0001 下午 4:28
 * @Version 1.0
 */
@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private ImageMapper imageMapper;

    @Override
    public NewsResult findPictureList() {
        ImageExample imageExample=new ImageExample();
        ImageExample.Criteria criteria = imageExample.createCriteria();
        criteria.andImageStateIn(StateListUtils.getStateList());
        List<Image> images = imageMapper.selectByExample(imageExample);
        return NewsResult.ok(images);
    }

    @Override
    public NewsResult updatePicture(Image image) {
        image.setImageDate(new Date());
        imageMapper.updateByPrimaryKeySelective(image);
        return NewsResult.ok();
    }

    @Override
    public NewsResult findPictureById(Integer id) {
        Image image = imageMapper.selectByPrimaryKey(id);
        return NewsResult.ok(image);
    }

    @Override
    public NewsResult savePicture(Image image) {
        image.setImageDate(new Date());
        image.setImageState("1");
        imageMapper.insertSelective(image);
        return null;
    }
}
