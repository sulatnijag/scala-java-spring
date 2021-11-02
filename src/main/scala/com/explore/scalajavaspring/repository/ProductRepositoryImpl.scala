package com.explore.scalajavaspring.repository

import org.springframework.data.domain.{Page, Pageable}
import org.springframework.data.repository.PagingAndSortingRepository
import com.explore.scalajavaspring.entity.Product

import java.util.UUID

trait ProductRepositoryImpl extends ProductRepository with PagingAndSortingRepository[Product, UUID]{

  override def add(product: Product): Product = save(product)

  override def update(product: Product): Product = save(product)

  override def list(pageable: Pageable): Page[Product] = findAll(pageable)

}
