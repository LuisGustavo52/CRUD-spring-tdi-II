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

		Manufacturer cat = new Manufacturer();
		cat.setName("Caterpillar Inc.");
		cat.setCnpj("11.111.111/0001-11");
		cat.setFoundationDate(new GregorianCalendar(1925, Calendar.APRIL, 15).getTime());
		cat.setManufacturesInBrazil(true);
		manufacturerRepository.save(cat);

		Manufacturer jcb = new Manufacturer();
		jcb.setName("JCB");
		jcb.setCnpj("22.222.222/0001-22");
		jcb.setFoundationDate(new GregorianCalendar(1945, Calendar.OCTOBER, 23).getTime());
		jcb.setManufacturesInBrazil(true);
		manufacturerRepository.save(jcb);
		
		manufacturerRepository.flush();
		
		Backhoe b1 = new Backhoe();
		b1.setModel("416");
		b1.setFabricationYear(new GregorianCalendar(2023, Calendar.JANUARY, 1).getTime());
		b1.setManufacturer(cat);
		b1.setStatus(true);
		backhoeRepository.save(b1);

		Backhoe b2 = new Backhoe();
		b2.setModel("3CX");
		b2.setFabricationYear(new GregorianCalendar(2022, Calendar.MARCH, 15).getTime());
		b2.setManufacturer(jcb);
		b2.setStatus(false);
		backhoeRepository.save(b2);

		backhoeRepository.flush();
	}
}