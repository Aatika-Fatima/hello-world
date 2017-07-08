package com.example.repository;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
 import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
 
import com.example.persistence.model.DifficultyLevel;
import com.example.persistence.repository.IDifficultyLevelRepository;
/*
@ContextConfiguration(locations = "classpath:config/repository/repository-beans.xml")
@Transactional*/
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionalDevTest
public class DifficutyRepositoryTest {
	@Autowired
	IDifficultyLevelRepository difficultyLevelRepository;

	@Test
	@Commit
	public void testAddDifficultyLevel() {
		DifficultyLevel df1 = new DifficultyLevel();
		df1.setDifficultyName("EASY");
		difficultyLevelRepository.create(df1);

		DifficultyLevel df2 = new DifficultyLevel();
		df2.setDifficultyName("MEDIUM");
		difficultyLevelRepository.create(df2);

		List<DifficultyLevel> difficultyList = difficultyLevelRepository.findAll();
		Assert.assertEquals(2, difficultyList.size());
	}

	@Test
	@Rollback(true)
	public void testSelectDifficultyLevel() {
		DifficultyLevel df = difficultyLevelRepository.get(1);
		Assert.assertEquals("EASY", df.getDifficultyName());
		difficultyLevelRepository.delete(df);
		List<DifficultyLevel> difficultyList = difficultyLevelRepository.findAll();
		int size = difficultyList.size();
		Assert.assertEquals(1, size);
	}

	// @Test
	// @Rollback(true)
	public void testDeleteDifficultyLevel() {
		DifficultyLevel df = difficultyLevelRepository.get(1);
		System.out.println(df.getDifficultyId() + " " + df.getDifficultyName());
		difficultyLevelRepository.delete(df);
		List<DifficultyLevel> difficultyList = difficultyLevelRepository.findAll();
		int size = difficultyList.size();
		Assert.assertEquals(1, size);
	}

	@Test
	@Rollback(true)
	public void testUpdateDifficultyLevel() {
		DifficultyLevel df = new DifficultyLevel(1, "MED");
		difficultyLevelRepository.update(df);
		DifficultyLevel df1 = difficultyLevelRepository.get(1);
		Assert.assertEquals(df1.getDifficultyName(), df.getDifficultyName());
	}

	
}
