package com.kalia.network.subscriptionapi.core.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class GetSubscriberDto {
  private int Id;
  private String IpAddress;
  private String Email;
}
