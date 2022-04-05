package com.kalia.network.subscriptionapi.mappers;

import com.kalia.network.subscriptionapi.core.Subscriber;
import com.kalia.network.subscriptionapi.core.dtos.CreateUpdateSubscriberDto;
import com.kalia.network.subscriptionapi.core.dtos.GetSubscriberDto;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SubscriberMapper {
  Subscriber toSubscriber(GetSubscriberDto getSubscriberDto);

  List<Subscriber> toSubscriberList(List<GetSubscriberDto> getSubscriberDto);

  GetSubscriberDto toGetSubscriberDto(Subscriber subscriber);

  List<GetSubscriberDto> toGetSubscriberDtoList(List<Subscriber> subscriberList);

  Subscriber toSubscriber(CreateUpdateSubscriberDto createSubscriberDto);

  CreateUpdateSubscriberDto toCreateUpdateSubscriberDto(Subscriber subscriber);
}
