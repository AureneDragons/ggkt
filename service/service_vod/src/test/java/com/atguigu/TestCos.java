package com.atguigu;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;

import java.io.File;

public class TestCos {
    public static void main(String[] args) {
        String secretId = "AKIDCHBuV7tgR1QegdcXeeT6dxCrT5d4RfqR";
        String secretKey = "ZyMYZUrY8ayKiwzIRPHF3kFc1HMH2e7Z";
        BasicCOSCredentials credentials = new BasicCOSCredentials(secretId, secretKey);
        //设置bucket的地域
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        clientConfig.setHttpProtocol(HttpProtocol.https);
        //生成cos客户端
        COSClient cosClient = new COSClient(credentials, clientConfig);

        File file = new File("C:\\Users\\LXY\\Pictures\\Saved Pictures\\18_d.jpg");
        String bucketName = "iowa-1311453143";
        String key = "/2023/01/02.jpg";
        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, file);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);
        System.out.println(JSON.toJSONString(putObjectResult));
    }
}
