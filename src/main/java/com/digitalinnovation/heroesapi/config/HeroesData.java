package com.digitalinnovation.heroesapi.config;

import com.amazonaws.client.builder.AwsClientBuilder;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClientBuilder;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import static com.digitalinnovation.heroesapi.constants.HeroesConstants.ENDPOINT_DYNAMO;
import static com.digitalinnovation.heroesapi.constants.HeroesConstants.REGION_DYNAMO;

public class HeroesData {
    public static void main(String[] args) throws Exception {

        AmazonDynamoDB client = AmazonDynamoDBClientBuilder.standard()
                .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(ENDPOINT_DYNAMO, REGION_DYNAMO))
                .build();
        DynamoDB dynamoDB = new DynamoDB(client);

        Table table = dynamoDB.getTable("Heroes_Table");

        Item hero = new Item()
                .withPrimaryKey("id", "1")
                .withString("name", "Black Widow")
                .withString("universe", "Marvel")
                .withNumber("films", 1);

        Item hero2 = new Item()
                .withPrimaryKey("id", "2")
                .withString("name", "Iron Man")
                .withString("universe", "marvel")
                .withNumber("films", 3);

        Item hero3 = new Item()
                .withPrimaryKey("id", "3")
                .withString("name", "Spider-man")
                .withString("universe", "marvel")
                .withNumber("films", 9);

        PutItemOutcome outcome1 = table.putItem(hero);
        PutItemOutcome outcome2 = table.putItem(hero2);
        PutItemOutcome outcome3 = table.putItem(hero3);

    }

}