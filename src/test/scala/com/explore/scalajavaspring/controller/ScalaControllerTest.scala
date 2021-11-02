package com.explore.scalajavaspring.controller

import com.explore.scalajavaspring.entity.Product
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultHandlers.{log, print}
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status
import org.hamcrest.Matchers.containsString
import com.fasterxml.jackson.databind.ObjectMapper
import lombok.extern.slf4j.Slf4j
import org.mockito.ArgumentCaptor
import org.mockito.Mockito.verify
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.domain.{Page, PageRequest, Pageable}
import org.springframework.test.web.servlet.MvcResult

import javax.servlet.ServletContext
import scala.util.chaining.scalaUtilChainingOps
import lombok.extern.java.Log


@SpringBootTest
@AutoConfigureMockMvc
@Slf4j
@Log
class ScalaControllerTest {

  import org.springframework.beans.factory.annotation.Autowired
  import org.springframework.test.web.servlet.MockMvc

  @Autowired
  val mockMvc: MockMvc = null


  @Autowired
  val objectMapper: ObjectMapper = null

  @Autowired
  var scalaController: ScalaController = null

  @Test
  def testInit(): Unit = {
    assertThat(scalaController).isNotNull

  }

  import org.junit.jupiter.api.Test

  @Test
  @throws[Exception]
  def shouldReturnDefaultMessage(): Unit = {
    this.mockMvc
      .perform(get("/"))
      .andDo(print)
      .andExpect(status.isOk)
      .andExpect(content.string(containsString("Greetings from Spring Boot!")))
  }

/*
  @Test
  def testPageableRequest(): Unit = {
    var result = mockMvc.perform(get("/products")
      .param("page", "0")
      .param("size", "1")) // <-- no space after comma!
      .andExpect(status().isOk())
      //.andReturn()
      .andDo(print()).andReturn()
    ;

    val objectResponse = objectMapper.readValue(result.getResponse.getContentAsString,classOf[Page[Product]])
    objectResponse.getContent().stream()
      .map(e => {
        log().inf
      })
  }
*/
}