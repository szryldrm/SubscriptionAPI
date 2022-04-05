package com.kalia.network.subscriptionapi.service;

import com.kalia.network.subscriptionapi.core.dtos.CreateUpdateSubscriberDto;
import com.kalia.network.subscriptionapi.core.dtos.GetSubscriberDto;
import com.kalia.network.subscriptionapi.mappers.SubscriberMapper;
import com.kalia.network.subscriptionapi.repository.SubscriberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class SubscriberService implements ISubscriberService {

  private final SubscriberMapper _subscriberMapper;

  private final SubscriberRepository _subscriberRepository;

  @Autowired
  public SubscriberService(
      SubscriberRepository subscriberRepository, SubscriberMapper _subscriberMapper) {
    _subscriberRepository = subscriberRepository;
    this._subscriberMapper = _subscriberMapper;
  }

  @Override
  public List<GetSubscriberDto> GetAll() {
    var subscriberList = _subscriberRepository.findAll();
    return _subscriberMapper.toGetSubscriberDtoList(subscriberList);
  }

  @Override
  public GetSubscriberDto GetById(int Id) {
    var entity = _subscriberRepository.findById(Id);
    if (entity.isEmpty()) {
      return null;
    }
    return _subscriberMapper.toGetSubscriberDto(entity.get());
  }

  @Override
  public GetSubscriberDto Save(CreateUpdateSubscriberDto createUpdateSubscriberDto) {
    var subscriber = _subscriberMapper.toSubscriber(createUpdateSubscriberDto);
    var subsId = subscriber.getId();
    if (subsId > 0) {
      var entity = _subscriberRepository.findById(subsId);
      if (entity.isEmpty()) {
        return _subscriberMapper.toGetSubscriberDto(subscriber);
      }
      subscriber.setUpdatedDate(new Date());
    } else if (subsId == 0) {
      subscriber.setCreatedDate(new Date());
    }
    _subscriberRepository.save(subscriber);
    return _subscriberMapper.toGetSubscriberDto(subscriber);
  }

  @Override
  public boolean Delete(int Id) {
    try {
      var entity = _subscriberRepository.findById(Id);
      if (entity.isEmpty()) {
        return false;
      }
      var subscriber = entity.get();
      subscriber.setIsDelete(true);
      subscriber.setIsActive(false);
      subscriber.setDeletedDate(new Date());
      _subscriberRepository.save(subscriber);
      return true;
    } catch (Exception ex) {
      return false;
    }
  }
}
