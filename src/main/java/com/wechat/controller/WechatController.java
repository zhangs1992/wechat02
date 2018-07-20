package com.wechat.controller;



import com.wechat.bean.Mem;
import com.wechat.controller.UploadService;
import com.wechat.dao.MemRepository;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.tomcat.util.http.fileupload.FileUploadException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.concurrent.TimeUnit;


/**
 * @Author: Youchang Xu
 * @Description:
 * @Date: created in 18:04 2018/4/30
 * @Modified By:
 */
@Controller
public class WechatController {
    @Autowired
    private MemRepository memRepository;


    /**
     * 首页
     * @return
     */
    @RequestMapping(value = "/index")
    public ModelAndView index(){
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
        List<String> roomlist=memRepository.findDistinctChatroomOderbyIdDesc();
        mv.addObject("roomlist",roomlist);
        return mv;
    }

    /**
     * 上传文件控制类
     * @param chatName
     * @param file
     * @param request
     * @return
     * @throws FileUploadException
     * @throws IOException
     */
    @RequestMapping(value = "upload",method = RequestMethod.POST)
    public ModelAndView upload(@RequestParam(value = "chatName")String chatName,
                               @RequestParam(value = "userFile")MultipartFile file,
                               HttpServletRequest request) throws FileUploadException, IOException, InterruptedException {
        UploadService uploadService=new UploadService();
        String contentType = file.getContentType();
        Long size=file.getSize();
        System.out.println("文件大小"+size);
        String fileName = file.getOriginalFilename();

        String filePath = request.getSession().getServletContext().getRealPath("/usr/local/");
        try {
            uploadService.uploadFile(file.getBytes(), filePath, fileName);
        } catch (Exception e) {
            // TODO: handle exception
        }
        filePath=filePath+fileName;
        String python="python /wechat.py "+filePath+" "+chatName;
//        String python="python /Users/xuyouchang/IdeaProjects/wechat02/src/main/java/com/wechat/python/wechat.py "+filePath+" "+chatName;
        String[] command={"/bin/sh","-c",python};
        System.out.println(command);
//        String command="python /weChat.py "+filePath+" "+chatName;
        Runtime.getRuntime().exec(command);
        TimeUnit.SECONDS.sleep(3);
        List<Mem> memList=memRepository.findAllByIsInGroup("0");
        List<String> roomlist=memRepository.findDistinctChatroomOderbyIdDesc();
        ModelAndView mv =new ModelAndView();
        mv.setViewName("index");
        mv.addObject("memList",memList);
        mv.addObject("roomlist",roomlist);
        //返回json
        return mv;




    }

    /**
     * 下载群到excel
     * @param response
     */
    @RequestMapping(value = "/download",method = RequestMethod.GET)
    public void download(HttpServletResponse response,@RequestParam(value = "room")String room){
        String filepath="/Users/xuyouchang/Downloads/tes03.xls";
        List<Mem> memList=memRepository.findAllByChatroom(room);

        DownloadExcel downloadExcel=new DownloadExcel();
        downloadExcel.writeEmployeeListToExcel(memList,"user.xls",response);

    }

    /**
     * 获得最新的人员上传列表
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getLatestMem")
    public List<Mem> getMemList(){
        List<String> chatroomlist=memRepository.findDistinctChatroomOderbyIdDesc();
        List<Mem> memList=memRepository.findAllByChatroom(chatroomlist.get(0));
        return memList;
    }

    /**
     * 获得最新的群聊名称
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "getLatestChatroom")
    public String getLatestChatroom(){
        List<String> chatroomlist=memRepository.findDistinctChatroomOderbyIdDesc();
        return chatroomlist.get(0);
    }



}

