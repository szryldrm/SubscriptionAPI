package com.kalia.network.subscriptionapi.service;

import com.kalia.network.subscriptionapi.core.dtos.CreateUpdateSubscriberDto;
import com.kalia.network.subscriptionapi.core.dtos.GetSubscriberDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ISubscriberService {

  List<GetSubscriberDto> GetAll();

  GetSubscriberDto GetById(int Id);

  GetSubscriberDto Save(CreateUpdateSubscriberDto createUpdateSubscriberDto);

  boolean Delete(int Id);
}
