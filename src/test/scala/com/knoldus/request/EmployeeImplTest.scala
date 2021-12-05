package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Mohit:Employee = new Employee("Mohit","Kumar",22,15000,"Intern","Knoldus","mohit.kumar@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Mohit)) thenReturn(true)
    val result = userImpl.createEmployee(Mohit)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Mohit)) thenReturn(false)
    val result = userImpl.createEmployee(Mohit)
    assert(result.isEmpty)
  }
}