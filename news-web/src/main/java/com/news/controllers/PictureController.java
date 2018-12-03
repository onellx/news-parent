package com.news.controllers;

import com.news.annotation.SystemControllerLog;
import com.news.po.NewsResult;
import com.news.pojo.Catalog;
import com.news.pojo.Image;
import com.news.service.PictureService;
import com.news.utils.FastDFSClient;
import com.news.utils.JsonUtils;
import com.news.utils.LinkedNewsPictureMap;
import com.news.utils.NewsPictureMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import java.io.File;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName PictureController
 * @Author One_llx
 * @Date 2018/11/21 0021 下午 4:13
 * @Version 1.0
 */
@Controller
public class PictureController {

    @Autowired
    private PictureService pictureService;


    @Value("${NEWS_IMAGE_SERVER_URL}")
    private String IMAGE_SERVER_URL;

    @RequestMapping(value = "picture-list",method = RequestMethod.GET)
    @SystemControllerLog(description = "获取图片列表")
    public String pictureList(Model model){
        List<Image> images= (List<Image>) pictureService.findPictureList().getData();
        model.addAttribute("images",images);
        return "picture-list";
    }


    @RequestMapping(value="picture/upatestate",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String changestate( String id,String state){
        Image image=new Image();
        image.setImageId(JsonUtils.jsonToPojo(id,Integer.class));
        image.setImageState(state);
        NewsResult newsResult = pictureService.updatePicture(image);
        if (newsResult.getStatus()!=200){
            return "false";
        }
        return "true";
    }

    @RequestMapping(value = "picture-edit/{id}",method = RequestMethod.GET)
    @SystemControllerLog(description = "修改图片信息页面")
    public String editImage(Model model, @PathVariable Integer id){
        Image image= (Image) pictureService.findPictureById(id).getData();
        model.addAttribute("image",image);
        return "picture-edit";
    }

    @RequestMapping(value="picture/update",method = RequestMethod.POST,produces="application/json;charset=UTF-8")
    @ResponseBody
    public String picture_update(Image image){


        NewsResult newsResult = pictureService.updatePicture(image);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "picture/save",method = RequestMethod.POST)
    @ResponseBody
    public String picture_save(Image image){


        NewsResult newsResult = pictureService.savePicture(image);
        if (newsResult.getStatus()==200){
            return "true";
        }
        return "false";
    }

    @RequestMapping(value = "picture-add",method = RequestMethod.GET)
    @SystemControllerLog(description = "添加栏目信息页面")
    public String pictureToAdd(){

        return "picture-add";
    }



    @RequestMapping(value = "pic/upload",method = RequestMethod.POST)
    @ResponseBody
    public String picUpload(/*MultipartFile uploadFile*/MultipartHttpServletRequest request) {
        System.out.println("start");
        MultiValueMap<String,MultipartFile> map = request.getMultiFileMap();
        System.out.println(map.size());
        List<MultipartFile> files = map.get("file");
        //响应上传图片的url
        NewsPictureMap result = new LinkedNewsPictureMap();
        try {
            for (MultipartFile uploadFile:files) {
                //接收上传的文件
                //取扩展名
                String originalFilename = uploadFile.getOriginalFilename();
                String extName = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
                //上传到图片服务器
                FastDFSClient fastDFSClient = new FastDFSClient("classpath:resources/fastdfs.conf");
                String url = fastDFSClient.uploadFile(uploadFile.getBytes(), extName);
                url = IMAGE_SERVER_URL + url;
                result.add("error", 0);
                result.add("url", url);
            }
            return JsonUtils.objectToJson(result);
        } catch (Exception e) {
            e.printStackTrace();
            //Map result = new HashMap<>();
            result.put("error", 1);
            result.put("message", "图片上传失败");
            return JsonUtils.objectToJson(result);
        }
    }

}
