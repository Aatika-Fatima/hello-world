package com.example.repository;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.example.persistence.model.Author;
import com.example.persistence.model.Category;
import com.example.persistence.model.DifficultyLevel;
import com.example.persistence.model.Question;
import com.example.persistence.repository.IAuthorRepository;
import com.example.persistence.repository.ICategoryRepository;
import com.example.persistence.repository.IDifficultyLevelRepository;
import com.example.persistence.repository.IQuestionRepository;
import com.example.persistence.repository.IUserRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@TransactionalDevTest
public class QuestionRespositoryTest {
	@Autowired
	IQuestionRepository iQuestionRepository;

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
	public void a_testAddQuestion() {
		Author author = iAuthorRepository.get(1);
		Category category = iCategoryRepository.get(1);
		long expected = iQuestionRepository.count();
		DifficultyLevel difficultyLevel = idifficultyLevelRepository.get(1);

		Question question = new Question("What is Java", "PL", "Apple", "Boy", "Cat", "A", author, category,
				difficultyLevel);
		iQuestionRepository.create(question);
		long actual = iQuestionRepository.count();
		Assert.assertEquals(expected + 1, actual);
	}

	@Test
	public void b_testDeleteQuestion() {
		Question question = iQuestionRepository.get(1);
		long expected = iQuestionRepository.count();

		iQuestionRepository.delete(question);
		long actual = iQuestionRepository.count();
		Assert.assertEquals(expected - 1, actual);
	}

	@Test
	public void c_testUpdateQuestion() {
		Question question = iQuestionRepository.get(1);
		question.setOptionA("Programing Language");
		Question expected = iQuestionRepository.get(1);
		iQuestionRepository.get(1);
		Assert.assertEquals(expected.getOptionA(), "Programing Language");
	}

	@Test
	public void d_testfindQuestion() {
		
		Question question = iQuestionRepository.get(1);
		Assert.assertNotNull(question);
	}
 
}
