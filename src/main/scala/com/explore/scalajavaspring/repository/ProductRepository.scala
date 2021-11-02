package com.explore.scalajavaspring.repository

import org.springframework.data.domain.{Page, Pageable}
import org.springframework.stereotype.Repository
import com.explore.scalajavaspring.entity.Product

@Repository
trait ProductRepository {

  def add(product: Product): Product
  def update(product: Product): Product
  def list(pageable: Pageable): Page[Product]

}
