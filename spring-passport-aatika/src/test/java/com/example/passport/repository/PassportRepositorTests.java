package com.example.passport.repository;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Calendar;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.passport.model.AddressProofDoc;
import com.example.passport.model.ApplicationStatus;
import com.example.passport.model.Gender;
import com.example.passport.model.Passport;
import com.example.passport.model.PhotoProofDoc;

/* 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"classpath:com/example/passport/repository/applicationTests-context.xml"})*/
@ContextConfiguration(locations={"classpath:com/example/passport/repository/applicationTests-context.xml"})
@RunWith(SpringRunner.class)
@EnableSpringDataWebSupport
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class PassportRepositorTests {
	@Autowired
	private IPassportRepository passportRepository;

	@Test
	@Transactional
	@Commit
	public void a_testCreatePassport() {
		Passport p = new Passport();
		p.setAddress("T.chowki");
		p.setApplicationId(1);
		p.setName("Aatika");
		p.setFatherName("Mohd");
		Calendar calendar = Calendar.getInstance();
		calendar.set(1987, 3, 8);
		p.setDateOfBirth(calendar.getTime());
		p.setGender(Gender.FEMALE);
		p.setAddress("Hyd");
		p.setPhone("1234567890");
		p.setEmail("aatika08@gmail.com");
		p.setApplicationStatus(ApplicationStatus.DRAFT);
		p.setAddressProofDoc(AddressProofDoc.AADHAAR);
		p.setPhotoIdProofDoc(PhotoProofDoc.DRIVING_LICENSE);
		p.setPhotoURL("http://www.example.com/asdf.jpg");

		p.setAddressProofDocNumber("1");
		p.setAddressProofDocFileUrl("http://www.example.com/AddressProof.doc");

		p.setPhotoIdProofDocNumber(1);
		p.setPhotoIdProofDocUrl("http://www.example.com/photoURL.docx");
		p.setLastModified(Calendar.getInstance().getTime());

		passportRepository.create(p);
		Passport p3 = passportRepository.get(1);
		assertNotNull(p3);
	/*	Passport p1 = passportRepository.findDocumentByApplicationId(1);
		System.out.println("Applciation ID ================"+p1.getApplicationId());
		assertEquals(p1.getApplicationId(), 1);
		System.out.println("Address =========== " + p1.getAddress());

		List<Passport> passportList = passportRepository.findAll();
		for (Passport p2 : passportList) {
			System.err.println(p.getId() + " -- " + p2.getApplicationId());
		}
		assertEquals(1, passportList.size());
		assertNotNull(passportList);*/

	}

	public void b_findAll() {
		List<Passport> passportList = passportRepository.findAll();
		for (Passport p : passportList) {
			System.err.println(p.getId() + " -- " + p.getApplicationId());
		}
		assertEquals(1, passportList.size());
		assertNotNull(passportList);
	}

	@Test
	public void c_testFindDocumentByApplicationId() {
		Passport p = passportRepository.findDocumentByApplicationId(1);
		assertEquals(p.getApplicationId(), 1);
	}

	@Test
	@Transactional
	@Commit
	public void d_testUpdatePassport() {

		passportRepository.updatePassport("http://aatika.jpg", "1", "http://addproffURL.docx", 1, "http://photoIdproff",
				1);
		Passport p = passportRepository.findDocumentByApplicationId(1);
		assertNotNull(p);
		assertEquals(p.getPhotoURL().toString(), "http://aatika.jpg");

		// passportJpaRepository.updatePassport(new URL("aatika.jpg"), "1", new
		// URL("addproffURL.docx"), new URL("photoIdproff"), 1);
		// passportJpaRepository.updatePassport("aatika.jpg", "1",
		// "addproffURL.docx", 1, "photoIdproff.html", 1);
	}
}
