package br.edu.ifsuldeminas.mch.retromaster.config;

import java.util.Calendar;
import java.util.GregorianCalendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import br.edu.ifsuldeminas.mch.retromaster.model.entity.Address;
import br.edu.ifsuldeminas.mch.retromaster.model.entity.Backhoe;
import br.edu.ifsuldeminas.mch.retromaster.model.entity.Manufacturer;
import br.edu.ifsuldeminas.mch.retromaster.model.entity.User;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.AddressRepository;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.BackhoeRepository;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.ManufacturerRepository;
import br.edu.ifsuldeminas.mch.retromaster.model.repository.UserRepository;
import jakarta.transaction.Transactional;

@Component
@Transactional
public class AtSystemStartup implements CommandLineRunner {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private BackhoeRepository backhoeRepository;
	
	@Autowired
	private ManufacturerRepository manufacturerRepository;
	
	@Override
	public void run(String... args) throws Exception {
		Address aEmerson = new Address();
		aEmerson.setNumber(123);
		aEmerson.setPlace("Rua A");
		aEmerson.setZipCode("136000");
		addressRepository.save(aEmerson);
		
		Address aNoe = new Address();
		aNoe.setNumber(100);
		aNoe.setPlace("Rua B");
		aNoe.setZipCode("136888");
		addressRepository.save(aNoe);
		
		Address aLu = new Address();
		aLu.setNumber(101);
		aLu.setPlace("Rua L");
		aLu.setZipCode("000888");
		addressRepository.save(aLu);
		
		addressRepository.flush();
		
		User emerson = new User();
		emerson.setName("Emerson A. Carvalho");
		emerson.setGender(User.Gender.M);
		emerson.setEmail("emerson@mail.com");
		emerson.setAddress(aEmerson);
		
		User luiza = new User();
		luiza.setName("Luiza O. Carvalho");
		luiza.setGender(User.Gender.F);
		luiza.setEmail("lu@mail.com");
		luiza.setAddress(aLu);
		
		User noe = new User();
		noe.setName("Noe L. Carvalho");
		noe.setGender(User.Gender.M);
		noe.setEmail("noe@mail.com");
		noe.setAddress(aNoe);
		
		userRepository.save(emerson);
		userRepository.save(luiza);
		userRepository.save(noe);
		
	}
}
