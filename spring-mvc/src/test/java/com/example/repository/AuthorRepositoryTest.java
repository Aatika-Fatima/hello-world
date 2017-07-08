package com.example.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.persistence.model.Author;
import com.example.persistence.model.User;
import com.example.persistence.repository.IAuthorRepository;
import com.example.persistence.repository.ICategoryRepository;
import com.example.persistence.repository.IDifficultyLevelRepository;
import com.example.persistence.repository.IUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionalDevTest
public class AuthorRepositoryTest {

	@Autowired
	IAuthorRepository iAuthorRepository;
	@Autowired
	IUserRepository iUserRepository;
	@Autowired
	ICategoryRepository iCategoryRepository;
	@Autowired
	IDifficultyLevelRepository idifficultyLevelRepository;

	@Test
	@Commit
	public void a_testAddAuthor() {
		User u = iUserRepository.get(1);
		Author author = new Author();
		author.setUser(u);
		author.setEnabled(true);
		iAuthorRepository.create(author);
		Author a = iAuthorRepository.get(1);
		Assert.assertNotNull(a);
		
		User u2 = iUserRepository.get(2);
		Author author2 = new Author();
		author2.setUser(u2);
		author2.setEnabled(true);
		iAuthorRepository.create(author2);
		Author a2 = iAuthorRepository.get(2);
		Assert.assertNotNull(a2);

	}

	@Test
	public void b_testDeleteAuthor() {
		long count = iAuthorRepository.count();
		Author author = iAuthorRepository.get(1);
		iAuthorRepository.delete(author);
		Assert.assertEquals(count-1, iAuthorRepository.count());
	}

	@Test
	public void c_testUpdateAuthor() {
		Author author = iAuthorRepository.get(1);
		boolean expected = author.isEnabled();
		author.setEnabled(false);
		iAuthorRepository.update(author);
		boolean actual = iAuthorRepository.get(1).isEnabled();
		Assert.assertNotEquals(expected, actual);
	}

	@Test
	public void d_testsfindAuthor() {
		Author author = iAuthorRepository.get(1);
		Assert.assertNotNull(author);
	}

	@Test
	public void e_testfindAllAuthor() {
		List<Author> authorList = iAuthorRepository.findAll();
		Assert.assertNotNull(authorList);
	}

}
