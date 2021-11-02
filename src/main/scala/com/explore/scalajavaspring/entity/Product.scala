package com.explore.scalajavaspring.entity

import com.fasterxml.jackson.annotation.JsonProperty

import javax.persistence.{Column, Entity, Table}


@Entity
@Table(name="PRODUCTS")
class Product extends BaseEntity {
  @Column(name="name", nullable=false)
  @JsonProperty("name")
  var name: String = _

  @Column(name="description", nullable=true)
  @JsonProperty("description")
  var description: String = _
}


object Product {
  def apply(name: String, description: Option[String]): Product = {
    val product = new Product
    product.name = name
    product.description = description.orNull
    product
  }
}


