package com.explore.scalajavaspring.entity

import com.fasterxml.jackson.annotation.JsonProperty
import org.hibernate.annotations.Type

import java.util.UUID
import javax.persistence.{Column, GeneratedValue, Id, MappedSuperclass}

@MappedSuperclass
abstract class BaseEntity extends Serializable{

  @Id
  @GeneratedValue
  @Column(name="id", length=36)
  @Type(`type`="uuid-char")
  @JsonProperty("id")
  var id: UUID = _

}
