package com.explore.scalajavaspring.service

import com.explore.scalajavaspring.entity.Product
import com.explore.scalajavaspring.repository.ProductRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, PageRequest, Pageable}
import org.springframework.stereotype.Service

@Service
class ScalaService {

  @Autowired
  val productRepository: ProductRepository = null

  def createProduct(product: Product): Product = {
    productRepository.add(product)
  }

  def listProducts(pageable: Pageable): Page[Product] = {
    productRepository.list(pageable)

  }

}
