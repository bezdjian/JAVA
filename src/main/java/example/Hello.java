package example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.Bucket;
import com.amazonaws.services.s3.model.ListObjectsRequest;
import com.amazonaws.services.s3.model.ListObjectsV2Request;
import com.amazonaws.services.s3.model.ListObjectsV2Result;
import example.pojos.RequestClass;
import example.pojos.ResponseClass;

import java.util.ArrayList;
import java.util.List;

public class Hello implements RequestHandler<RequestClass, ResponseClass> {

    public ResponseClass handleRequest(RequestClass request, Context context) {
        LambdaLogger logger = context.getLogger();
        final List<String> bucketNames = new ArrayList<>();

        final AmazonS3 s3 = AmazonS3ClientBuilder.defaultClient();
        ListObjectsV2Request listObjectsRequest = new ListObjectsV2Request().withBucketName(request.getBucketName());

        ListObjectsV2Result result = s3.listObjectsV2(listObjectsRequest);
        do{
            result.getObjectSummaries().forEach(o -> bucketNames.add(o.getKey() + " with size " + o.getSize()));
        }while (result.isTruncated());

        //List<Bucket> bucketList = s3.listBuckets();
        //bucketList.forEach(b -> bucketNames.add(b.getName()));

        String message = "user " + request.getFirstName() + " requested listing the bucket " + request.getBucketName();
        logger.log(message);
        return new ResponseClass(message, bucketNames);
    }
}
