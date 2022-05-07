package vip.zhguo.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * [oss接口]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/6 15:21]
 */
public interface OssService {
    String upload(MultipartFile file);
}
