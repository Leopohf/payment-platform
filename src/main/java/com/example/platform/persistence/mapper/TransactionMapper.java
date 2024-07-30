package com.example.platform.persistence.mapper;

import com.example.platform.domain.TransactionRequest;
import com.example.platform.persistence.entity.Transaction;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface TransactionMapper {

    @Mappings({
            @Mapping(source = "amount", target = "amount"),
            @Mapping(source = "merchantId", target = "merchant"),
            @Mapping(source = "category", target = "category"),
            @Mapping(source = "description", target = "description"),
            @Mapping(source = "cardNumber", target = "cardNumber"),
            @Mapping(source = "cardType", target = "cardType"),
            @Mapping(target = "idTransaction", ignore = true),
            @Mapping(target = "transactionDate", ignore = true),
            @Mapping(target = "card", ignore = true),
    })
    Transaction toTransaction(TransactionRequest transactionRequest);

}
