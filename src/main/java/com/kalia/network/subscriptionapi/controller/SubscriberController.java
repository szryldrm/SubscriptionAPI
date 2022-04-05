package com.kalia.network.subscriptionapi.controller;

import com.kalia.network.subscriptionapi.core.dtos.CreateUpdateSubscriberDto;
import com.kalia.network.subscriptionapi.core.dtos.ResponseDto;
import com.kalia.network.subscriptionapi.service.SubscriberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class SubscriberController {

  private static final String ERROR_MESSAGE = "An Error Occured!";
  private final SubscriberService _subscriberService;
  protected ResponseDto _response;

  @Autowired
  public SubscriberController(SubscriberService subscriberService) {
    _subscriberService = subscriberService;
  }

  @GetMapping("/subscribers")
  public ResponseDto findAll() {
    try {
      _response = new ResponseDto();
      var subscribers = _subscriberService.GetAll();
      _response.setResult(subscribers);
    } catch (Exception ex) {
      _response.setIsSuccess(false);
      _response.setDisplayMessage(ERROR_MESSAGE);
      _response.setErrorMessage(ex.getMessage());
    }
    return _response;
  }

  @GetMapping("/subscribers/{id}")
  public ResponseDto getSubscriber(@PathVariable int id) {
    try {
      _response = new ResponseDto();
      var subscriber = _subscriberService.GetById(id);
      _response.setResult(subscriber);
    } catch (Exception ex) {
      _response.setIsSuccess(false);
      _response.setDisplayMessage(ERROR_MESSAGE);
      _response.setErrorMessage(ex.getMessage());
    }
    return _response;
  }

  @PostMapping("/subscribers")
  public ResponseDto addSubscriber(
      @RequestBody CreateUpdateSubscriberDto createUpdateSubscriberDto) {
    try {
      _response = new ResponseDto();
      createUpdateSubscriberDto.setId(0);
      var result = _subscriberService.Save(createUpdateSubscriberDto);
      _response.setResult(result);
    } catch (Exception ex) {
      _response.setIsSuccess(false);
      _response.setDisplayMessage(ERROR_MESSAGE);
      _response.setErrorMessage(ex.getMessage());
    }
    return _response;
  }

  @PutMapping("/subscribers")
  public ResponseDto updateSubscriber(
      @RequestBody CreateUpdateSubscriberDto createUpdateSubscriberDto) {
    try {
      _response = new ResponseDto();
      var result = _subscriberService.Save(createUpdateSubscriberDto);
      _response.setResult(result);
    } catch (Exception ex) {
      _response.setIsSuccess(false);
      _response.setDisplayMessage(ERROR_MESSAGE);
      _response.setErrorMessage(ex.getMessage());
    }
    return _response;
  }

  @DeleteMapping("/subscribers/{id}")
  public ResponseDto deleteSubscriber(@PathVariable int id) {
    try {
      _response = new ResponseDto();
      var result = _subscriberService.Delete(id);
      if (!result) {
        _response.setIsSuccess(false);
      }
    } catch (Exception ex) {
      _response.setIsSuccess(false);
      _response.setDisplayMessage(ERROR_MESSAGE);
      _response.setErrorMessage(ex.getMessage());
    }
    return _response;
  }
}
