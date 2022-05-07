package vip.zhguo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import vip.zhguo.commonutils.R;
import vip.zhguo.service.OssService;

import java.io.File;

/**
 * [Oss]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/6 15:27]
 */
@RestController
@RequestMapping("/oss")
public class OssController {
    @Autowired
    OssService ossService;

    @PostMapping
    public R upload(MultipartFile file) {
        String uploadPath = ossService.upload(file);
        return R.ok().data(uploadPath);
    }
}
