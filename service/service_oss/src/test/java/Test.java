import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.Bucket;

/**
 * [一句话描述该类的功能]
 *
 * @author : [zhenghg]
 * @version : [v1.0]
 * @createTime : [2022/5/6 11:09]
 */
public class Test {
    public static void main(String[] args) {
        // yourEndpoint填写Bucket所在地域对应的Endpoint。以华东1（杭州）为例，Endpoint填写为https://oss-cn-hangzhou.aliyuncs.com。
        String endpoint = "oss-cn-shanghai.aliyuncs.com";
// 阿里云账号AccessKey拥有所有API的访问权限，风险很高。强烈建议您创建并使用RAM用户进行API访问或日常运维，请登录RAM控制台创建RAM用户。
        String accessKeyId = "LTAI5tRG9ZrZLWyXpzqBDZfb";
        String accessKeySecret = "WQnTFOKVoh1VomhZNzC5oK0TlUe7Lz";
        String bucKetName ="zhguo-oss";

// 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
//        Bucket bucket = ossClient.createBucket(bucKetName);
//        bucket.
        System.out.println(ossClient.doesBucketExist(bucKetName));
// 关闭OSSClient。
        ossClient.shutdown();
    }
}
