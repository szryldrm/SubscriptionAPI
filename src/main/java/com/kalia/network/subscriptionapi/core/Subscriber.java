package com.kalia.network.subscriptionapi.core;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Subscriber {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int Id;

  private String IpAddress;

  private String Email;

  private boolean IsActive;

  private boolean IsDelete;

  @Column(nullable = false, updatable = false)
  @CreatedDate
  private Date CreatedDate;

  @LastModifiedDate private Date UpdatedDate;

  private Date DeletedDate;
}
