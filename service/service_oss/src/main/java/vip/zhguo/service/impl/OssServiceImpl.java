package vip.zhguo.service.impl;

import com.aliyun.oss.ClientException;
import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.OSSException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import vip.zhguo.config.ConstantProperties;
import vip.zhguo.service.OssService;

import java.io.*;
import java.util.UUID;

/**
 * [一句话描述该类的功能]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/6 15:21]
 */
@Service
public class OssServiceImpl implements OssService {
    @Autowired
    ConstantProperties constantProperties;
    String ossFilePath ="";
    String uploadFileName="";
    @Override
    public String upload(MultipartFile file) {

        OSS ossClient = new OSSClientBuilder().build(constantProperties.getEndpoint(),
                constantProperties.getAccessKeyID(), constantProperties.getAccessKeySecret());

        try {
            String originalFilename = file.getOriginalFilename();
//            获取后缀
            String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
            InputStream inputStream = file.getInputStream();
             uploadFileName = constantProperties.getFolderName()+UUID.randomUUID() + suffixName;
            // 创建PutObject请求。
            ossClient.putObject(constantProperties.getBucKetName(),uploadFileName , inputStream);
        } catch (OSSException oe) {
            System.out.println("Caught an OSSException, which means your request made it to OSS, "
                    + "but was rejected with an error response for some reason.");
            System.out.println("Error Message:" + oe.getErrorMessage());
            System.out.println("Error Code:" + oe.getErrorCode());
            System.out.println("Request ID:" + oe.getRequestId());
            System.out.println("Host ID:" + oe.getHostId());
        } catch (ClientException ce) {
            System.out.println("Caught an ClientException, which means the client encountered "
                    + "a serious internal problem while trying to communicate with OSS, "
                    + "such as not being able to access the network.");
            System.out.println("Error Message:" + ce.getMessage());
        } catch (IOException de) {
            de.printStackTrace();
        } finally {
            ossFilePath = "https://"+constantProperties.getBucKetName()+"."+constantProperties.getEndpoint()+"/"+uploadFileName;
            if (ossClient != null) {
                ossClient.shutdown();
            }
            return ossFilePath;
        }
    }
}
