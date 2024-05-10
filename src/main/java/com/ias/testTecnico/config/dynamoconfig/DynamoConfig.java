package com.ias.testTecnico.config.dynamoconfig;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DynamoConfig {

    @Bean
    public DynamoDBMapper dynamoDBMapperConfig() {

        return new DynamoDBMapper(AmazonDynamoDBClientBuilder.standard().withEndpointConfiguration(
                new AwsClientBuilder.EndpointConfiguration(//"dynamodb.us-east-2.amazonaws.com", "us-east-2"))
                        "http://localhost:8000/", "us-east-2"))
                .withCredentials(new AWSStaticCredentialsProvider(new BasicAWSCredentials("myg2kn","j64om1"))).build());
    }

}
