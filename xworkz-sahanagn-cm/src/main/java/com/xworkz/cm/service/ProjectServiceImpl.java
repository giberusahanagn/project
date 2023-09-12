package com.xworkz.cm.service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import java.util.TreeMap;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.persistence.EntityManager;
import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.passay.CharacterRule;
import org.passay.EnglishCharacterData;
import org.passay.PasswordGenerator;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.xworkz.cm.dto.SignUpDto;
import com.xworkz.cm.entity.SignUpEntity;
import com.xworkz.cm.repository.ProjectRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	private ProjectRepository repository;
	@Autowired
	private PasswordEncoder encoder;

	public ProjectServiceImpl() {
		log.info("create " + this.getClass().getSimpleName());
	}

	@Override
	public Set<ConstraintViolation<SignUpDto>> validateAndSave(SignUpDto dto) {
		log.info("running validateAndSave method....");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<SignUpDto>> constraintViolations = validator.validate(dto);
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			System.err.println("constraintViolations exists,return constraints");
			return constraintViolations;
		} else {
			log.info("constraintViolations does not exist,data is good");
			SignUpEntity entity = new SignUpEntity();
			BeanUtils.copyProperties(dto, entity);
			entity.setCreatedBy(dto.getUserId());
			entity.setPassword(encoder.encode(dto.getPassword()));

			log.info("password" + dto);
			boolean saved = this.repository.save(entity);
			if (saved) {
				// sendMail(dto.getEmail());
				boolean sent = sendMail(entity.getEmail(), "Registraion success ");
				System.out.println("mail  sent" + sent);
			}
			System.out.println(saved);

			System.out.println("Dto" + dto);
			log.info("ENTITY" + entity);
			return Collections.emptySet();
		}
	}

	@Override
	public Integer checkDuplicates(String userId, String email, long mobile) {
		log.info("running checkDuplicates method...");
		Integer count = this.repository.checkDuplicates(userId, email, mobile);
		SignUpEntity entity = new SignUpEntity();
		SignUpDto dto = new SignUpDto();
		dto.setUserId(entity.getUserId());
		dto.setEmail(entity.getEmail());
		dto.setMobile(entity.getMobile());
		return count;
	}

	// check making method as Async
	@Override
	public boolean sendMail(String email, String input_msg) {
		log.info("running on send mail");
		String portNumber = "587";// 485,587,25
		String hostName = "smtp.office365.com";
		String fromEmail = "swatik2806@outlook.com";
		String password = "Swati2806";
		String to = email;
		// 1)configure the SMTP server details using the java Properties Object
		Properties prop = new Properties();
		prop.put("mail.smtp.host", hostName);
		prop.put("mail.smtp.port", portNumber);
		prop.put("mail.smtp.starttls.enable", true);
		prop.put("mail.debug", true);
		prop.put("mail.smtp.auth", true);
		prop.put("mail.transport.protocol", "smtp");
		/**
		 * 2)Create Session vth getInstance()&pass properties &Authenticator & Override
		 * getPasswordAuthentication() method Authenticator is a Abstract class
		 */
		Session session = Session.getInstance(prop, new Authenticator() {

			@Override
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(fromEmail, password);
			}
		});
		// 3)message class to create message .*file,*text
		MimeMessage message = new MimeMessage(session);
		// 4)set the to,from,subject,message ->set email important this
		try {
			message.setFrom(new InternetAddress(fromEmail));
			message.setSubject("Registration  completed");
			message.setText(input_msg);
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			// 5)use transport class to send the mail
			Transport.send(message);
			log.info("mail sent successfully");
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		return false;

	}

	@Override
	public Map<String, SignUpDto> signIn(String userId, String password) {
		Map<String, SignUpDto> signUpmap = new TreeMap();
		log.info("running signIn method...");
		List<SignUpEntity> entities = this.repository.signIn(userId);
		List<SignUpDto> listOfDto = new ArrayList<SignUpDto>();

		for (SignUpEntity entity : entities) {
			log.info("matching--" + encoder.matches(password, entity.getPassword()));
			log.info("Now Present Time--" + LocalTime.now());
			log.info("PasswordChangedTime--" + entity.getOtpRequestedTime());

			SignUpDto dto = new SignUpDto();
		//	BeanUtils.copyProperties(entity, dto);
			if (entity.getLoginCount() >= 3 && !entity.isResetPwd()) {
				 signUpmap.put("locked", dto);
				return  signUpmap;
				
			}
			if (encoder.matches(password, entity.getPassword())) {
					BeanUtils.copyProperties(entity, dto);
				listOfDto.add(dto);
				log.info("matched :" + password);
				this.repository.updateWrongLoginAttempts(userId, 0);
				if (entity.isResetPwd()) {
					if (LocalDateTime.now().isAfter(entity.getOtpRequestedTime())) {
						 signUpmap.put("opt_resettime_exp", dto);
						return signUpmap;
					}
					signUpmap.put("reset_pwd", dto);
					return signUpmap;
				}
				signUpmap.put("login_success", dto);

				return signUpmap;
			} else {
				this.repository.updateWrongLoginAttempts(userId, entity.getLoginCount() + 1);
				log.info("Wrong login attempts " + (entity.getLoginCount() + 1));
			}

		}
		signUpmap.put("login_fail", null);
		return signUpmap;
	}

	@Override
	public String resetPwd(String email) {
		log.info("running resetPwd is service..");
		List<SignUpEntity> entities = this.repository.findByEmail(email);
		if (entities.isEmpty()) {
			return "email not found";
		}
		for (SignUpEntity entity : entities) {
			String randomPassword = generateRandomPassword();
			if (!email.isEmpty()) {
				entity.setOtpRequestedTime(LocalDateTime.now().plusSeconds(120));
				boolean sent = this.sendMail(email,
						"new password = " + randomPassword + "   this password is valid for 2 min  ");

				sendMail(entity.getEmail(), "Your  reseted password is-> " + randomPassword
						+ "Plz log in again with in 2 min with this password ");

				log.info("Random password generated :" + randomPassword);
				log.info("email send sucessfuly to " + email);
			}
			this.repository.updateResetPwd(email, true, encoder.encode(randomPassword));
		}
		return "email has been sent with new password,please";
	}

	public static String generateRandomPassword() {
		PasswordGenerator gen = new PasswordGenerator();
		CharacterRule LC = new CharacterRule(EnglishCharacterData.LowerCase);
		LC.setNumberOfCharacters(2);

		CharacterRule UC = new CharacterRule(EnglishCharacterData.UpperCase);
		UC.setNumberOfCharacters(2);

		CharacterRule digit = new CharacterRule(EnglishCharacterData.Digit);
		digit.setNumberOfCharacters(2);

		String password = gen.generatePassword(10, LC, digit, UC);
		return password;
	}

	@Override
	public String updatePwd(String userId, String password, boolean resetPwd) {
		log.info("running updatePwd method....");
		this.repository.updateConfirmPwd(userId, false, encoder.encode(password));
		return "Update New Password";
	}

	@Override
	public SignUpDto findByuserId(String userId) {
		if (userId != null) {
			SignUpEntity entity = this.repository.findByuserId(userId);
			if (entity != null) {
				SignUpDto dto = new SignUpDto();
				BeanUtils.copyProperties(entity, dto);
				return dto;
			}
		}
		return null;
	}
	
	@Override
	public SignUpDto findByEmail(String email) {
		log.info("findByEmail"+email);
		SignUpEntity entity = this.repository.entityByEmail(email);
		if(entity!=null) {
			SignUpDto dto = new SignUpDto();
			BeanUtils.copyProperties(entity, dto);
			return dto;
		}
		return ProjectService.super.findByEmail(email);
	}

	@Override
	public Set<ConstraintViolation<SignUpDto>> validateAndUpdateProfile(SignUpDto dto) {
		log.info("running validateAndUpdateProfile method....");
		ValidatorFactory validatorFactory = Validation.buildDefaultValidatorFactory();
		Validator validator = validatorFactory.getValidator();
		Set<ConstraintViolation<SignUpDto>> constraintViolations = validator.validate(dto);
		if (constraintViolations != null && !constraintViolations.isEmpty()) {
			System.err.println("constraintViolations exists,return constraints");
			constraintViolations.forEach(e->log.info(""+e));
			return constraintViolations;
		} else {
			log.info("constraintViolations does not exist,data is good");
			SignUpEntity entity = this.repository.entityByEmail(dto.getEmail());
			BeanUtils.copyProperties(dto, entity);
			entity.setCreatedBy(dto.getUserId());
			entity.setPassword(dto.getPassword());

			log.info("password" + dto);
			boolean update = this.repository.updateProfile(entity);
			if (update) {
				// sendMail(dto.getEmail());
				boolean sent = sendMail(entity.getEmail(), "Registraion success ");
				System.out.println("mail  sent" + sent);
			}
			log.info("Entity data is update :" + update);
			return Collections.emptySet();
		}
	}

}
