# hello_sqs_sns

Upload to S3
```
$ sh create-s3-bucket.sh
$ sh upload-s3.sh
```

```
$ aws cloudformation create-stack --stack-name qilin-ss-stack --template-body file://cf.yml

$ aws cloudformation update-stack --stack-name qilin-ss-stack --template-body file://cf.yml
```