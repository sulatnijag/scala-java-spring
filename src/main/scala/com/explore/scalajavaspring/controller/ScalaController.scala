package com.explore.scalajavaspring.controller

import org.springframework.web.bind.annotation.{CrossOrigin, GetMapping, PostMapping, RequestBody, RequestParam, RestController}

import javax.servlet.http.HttpServletResponse
import com.explore.scalajavaspring.entity.Product
import com.explore.scalajavaspring.service.ScalaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, Pageable}
import org.springframework.http.HttpStatus
import org.springframework.web.util.UriComponentsBuilder

@RestController
class ScalaController {

  @Autowired
  val productService: ScalaService = null


  @GetMapping(path = Array("/scala-controller"))
  def hello(): String = {
    "Hello from Scala Controller"
  }

  @PostMapping(path=Array("products"))
  def createProudct(@RequestBody product: Product, response: HttpServletResponse): Unit ={
    println("createProduct() : " + product.name)
    productService.createProduct(product)

    response.setStatus(HttpStatus.OK.value())
    response.getWriter.println("Product created successfully")
    response.getWriter.flush()
    response.getWriter.close()
  }

  @CrossOrigin
  @GetMapping(path=Array("products"), params=Array("page", "size"))
  def listProducts(pageable: Pageable): Page[Product] = {
    productService.listProducts(pageable)
  }


}
