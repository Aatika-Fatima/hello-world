package com.example.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.persistence.model.Category;
import com.example.persistence.repository.ICategoryRepository;

@TransactionalDevTest
@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class CategoryRepositoryTest {
	@Autowired
	ICategoryRepository iCategoryRepository;

	
	
/*	@Test
	@Commit
 	public void a_testAddCategory_Positive() {
		Category c1 = new Category();
		c1.setCategoryName("C");
		iCategoryRepository.create(c1);
		
		Category c2 = new Category(); 
		c2.setCategoryName("C++");
		
		Category c3 = new Category(); 
		c3.setCategoryName("Java");
		
		iCategoryRepository.create(c1);
		iCategoryRepository.create(c2);
		iCategoryRepository.create(c3);
		
		List<Category> categoryList = iCategoryRepository.findAll();
		Assert.assertEquals(3, categoryList.size());
	}*/
	@Test
	public void b_testFindCategory_Postive() {
		Category c1 = iCategoryRepository.get(2);
		System.out.println(c1.getCategoryId() + " " + c1.getCategoryName());
		Assert.assertNotNull(c1);
	}

	@Test
	public void c_testUpdateCategory_Positive() {
		Category c1 = iCategoryRepository.get(1);
		c1.setCategoryName("C#");
		iCategoryRepository.update(c1);
		Category c2 = iCategoryRepository.get(1);
		Assert.assertEquals("ASP", c2.getCategoryName());
	}

	public void d_testDeleteCategory_Positive() {
		 
		int size = iCategoryRepository.findAll().size();
		Category c2 = iCategoryRepository.get(1);
		iCategoryRepository.delete(c2);
		List<Category> categoryList = iCategoryRepository.findAll();
		Assert.assertEquals(size-1, categoryList.size());
		
	}

	@Test
	public void e_testFindAllCategories(){
		List<Category> categoryList = iCategoryRepository.findAll();
		Assert.assertEquals(3, categoryList.size());
	}
}
