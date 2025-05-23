package com.mary.product_microservice_sharik.consumer;

import com.mary.product_microservice_sharik.service.RequestProcessingService;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class KafkaConsumerService {

    private final RequestProcessingService requestProcessingService;

    @SneakyThrows
    @KafkaListener(
            topics = "#{T(com.mary.product_microservice_sharik.model.enumClass.KafkaTopic)." +
                    "PRODUCT_BY_FILTER_TOPIC.name()}",
            groupId = "product_group")
    public void productsByFilter(ConsumerRecord<String, String> message){
        requestProcessingService.sendProductsByFilter(message);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "#{T(com.mary.product_microservice_sharik.model.enumClass.KafkaTopic)." +
                    "PRODUCT_BY_ID_TOPIC.name()}",
            groupId = "product_group")
    public void productById(ConsumerRecord<String,String> message){
        requestProcessingService.sendProductById(message);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "#{T(com.mary.product_microservice_sharik.model.enumClass.KafkaTopic)." +
                    "PRODUCT_LIST_BY_IDS_TOPIC.name()}",
            groupId = "product_group")
    public void listOfProductsByIds(ConsumerRecord<String,String> message){


        requestProcessingService.sendProductsByIds(message);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "#{T(com.mary.product_microservice_sharik.model.enumClass.KafkaTopic)." +
                    "PRODUCT_SET_STATUS_TOPIC.name()}",
            groupId = "product_group")
    public void setProductStatus(ConsumerRecord<String,String> message){
        requestProcessingService.setProductStatus(message);
    }

    @SneakyThrows
    @KafkaListener(
            topics = "#{T(com.mary.product_microservice_sharik.model.enumClass.KafkaTopic)." +
                    "PRODUCT_CREATE_TOPIC.name()}",
            groupId = "product_group")
    public void createProduct(ConsumerRecord<String,String> message){
        requestProcessingService.createProduct(message);
    }
}