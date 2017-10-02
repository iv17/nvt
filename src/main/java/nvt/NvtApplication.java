package nvt;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import nvt.beans.AdvertisementType;
import nvt.beans.Agent;
import nvt.beans.Company;
import nvt.beans.HeatingType;
import nvt.beans.Image;
import nvt.beans.IndoorFeature;
import nvt.beans.Location;
import nvt.beans.OutdoorFeature;
import nvt.beans.RealEstate;
import nvt.beans.RealEstateComment;
import nvt.beans.RealEstateIndoors;
import nvt.beans.RealEstateOutdoors;
import nvt.beans.RealEstateRating;
import nvt.beans.RealEstateType;
import nvt.beans.User;
import nvt.beans.WorkingTime;
import nvt.repository.AdvertisementTypeRepository;
import nvt.repository.AgentRatingRepository;
import nvt.repository.AgentRepository;
import nvt.repository.CompanyRepository;
import nvt.repository.HeatingTypeRepository;
import nvt.repository.ImageRepository;
import nvt.repository.IndoorFeatureRepository;
import nvt.repository.LocationRepository;
import nvt.repository.OutdoorFeatureRepository;
import nvt.repository.RealEstateCommentRepository;
import nvt.repository.RealEstateIndoorsRepository;
import nvt.repository.RealEstateOutdoorsRepository;
import nvt.repository.RealEstateRatingRepository;
import nvt.repository.RealEstateReportRepository;
import nvt.repository.RealEstateRepository;
import nvt.repository.RealEstateTypeRepository;
import nvt.repository.UserRepository;
import nvt.repository.WorkingTimeRepository;

@SpringBootApplication
public class NvtApplication implements CommandLineRunner {

	@Autowired
	UserRepository userRepository;
	
	@Autowired
	LocationRepository locationRepository;
	
	@Autowired
	WorkingTimeRepository workingTimeRepository;
	
	@Autowired
	CompanyRepository companyRepository;
	
	@Autowired
	AgentRepository agentRepository;
	
	@Autowired
	IndoorFeatureRepository indoorFeatureRepository;
	
	@Autowired
	OutdoorFeatureRepository outdoorFeatureRepository;
	
	@Autowired
	HeatingTypeRepository heatingTypeRepository;
	
	@Autowired
	RealEstateTypeRepository realEstateTypeRepository;
	
	@Autowired
	RealEstateRepository realEstateRepository;
	
	@Autowired 
	AdvertisementTypeRepository advertisementTypeRepository;
	
	@Autowired
	RealEstateCommentRepository realEstateCommentRepository;
	
	@Autowired
	RealEstateRatingRepository realEstateRatingRepository;
	
	@Autowired 
	RealEstateReportRepository realEstateReportRepository;
	
	@Autowired
	AgentRatingRepository agentRatingRepository;
	
	@Autowired
	RealEstateIndoorsRepository realEstateIndoorsRepository;
	
	@Autowired 
	RealEstateOutdoorsRepository realEstateOutdoorsRepository;
	
	@Autowired
	ImageRepository imageRepository;
	
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(NvtApplication.class);
		
		System.out.println("\n\n\n\n\t\t\t\tIVANA");
	}

	
	
	@Override
	public void run(String... arg0) throws Exception {
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();


		Location location1 = new Location(44.8023505, 20.4719586, "Beograd", "Vračar", "Krunska", "11000");
		locationRepository.save(location1);
		Location location2 = new Location(44.8192953, 20.4486969, "Beograd", "Beton hala", "Karađorđeva 2-4", "11000");
		locationRepository.save(location2);
		Location location3 = new Location(44.8213953, 20.4665717, "Beograd", "Dorćol", "Žorža Klemansoa 10", "11000");
		locationRepository.save(location3);
		Location location4 = new Location(44.7970585, 20.4664927, "Beograd", "Vračar", "Bore Stankovića 17", "11000");
		locationRepository.save(location4);
		Location location5 = new Location(44.7888501, 20.4368326, "Beograd", "Senjak", "Andre Nikolića 1", "11000");
		locationRepository.save(location5);
		Location location6  = new Location(44.7664883, 20.4086425, "Beograd", "Julino brdo", "Katarine Bogdanović", "11000");
		locationRepository.save(location6);
		Location location7  = new Location(44.773251, 20.4550609, "Beograd", "Dedinje", "Vladimira Gaćinovića 15", "11000");
		locationRepository.save(location7);
		Location location8  = new Location(44.7780874, 20.4693926, "Beograd", "Voždovac", "Koste Jovanovića 87", "11000");
		locationRepository.save(location8);
		Location location9  = new Location(44.8150947, 20.5048786, "Beograd", "Karaburma", "Patrisa Lumumbe 4", "11000");
		locationRepository.save(location9);
		Location location10  = new Location(44.7823568, 20.4166448, "Beograd", "Banovo Brdo", "Požeška 40", "11000");
		locationRepository.save(location10);
		
		
		Location location11  = new Location(44.7972173, 20.4015128, "Beograd", "Neimar", "Patrijarha Varnave 20", "11000");
		locationRepository.save(location11);
		Location location12  = new Location(44.7992456, 20.4023128, "Beograd", "Vračar", "Makenzijeva 67", "11000");
		locationRepository.save(location12);
		Location location13  = new Location(44.7810466, 20.3820132, "Beograd", "Senjak", "Avgusta Cesarca", "11000");
		locationRepository.save(location13);
		Location location14  = new Location(44.79562, 20.4396247, "Beograd", "Vračar", "Beogradska 71", "11000");
		locationRepository.save(location14);
		Location location15  = new Location(44.7809182, 20.3820123, "Beograd", "Crveni krst", "Metohijska 11", "11000");
		locationRepository.save(location15);
		
		
		WorkingTime workingTime1 = new WorkingTime("09.00", "18.0", "Zatvoreno", "Zatvoreno");
		workingTimeRepository.save(workingTime1);
		
		Company company1 = new Company("bestrealesate@gmail.com", "BEST REAL ESTATE", encoder.encode("123"), "063-282-558", "0001", "www.bestrealestate.rs", location11, workingTime1);
		companyRepository.save(company1);
		Company company2 = new Company("mentor@gmail.com", "MENTOR REAL ESTATE BELGRADE", encoder.encode("123"), "063-282-558", "0002", "www.bestrealestate.rs", location12, workingTime1);
		companyRepository.save(company2);
		Company company3 = new Company("real.consulting@gmail.com",  "R.E.A.L. Consulting Nekretnine",  encoder.encode("123"), "063-282-558", "0003", "www.bestrealestate.rs", location13, workingTime1);
		companyRepository.save(company3);
		Company company4 = new Company("kvadrat.nekretnine@gmail.com", "Kvadrat nekretnine", encoder.encode("123"), "063-282-558", "0004", "www.bestrealestate.rs", location14, workingTime1);
		companyRepository.save(company4);
		Company company5 = new Company("fox@gmail.com", "FOX nekretnine", encoder.encode("123"), "063-282-558", "0005",  "foxnekretnine.com", location15, workingTime1);
		companyRepository.save(company5);


		Image image20 = new Image("r1.jpg", "app/images/companies/r1.jpg".getBytes(), "image/jpeg");
		image20.setCompany(company1);
		imageRepository.save(image20);
		Image image21 = new Image("r2.jpg", "app/images/companies/r2.jpg".getBytes(), "image/jpeg");
		image21.setCompany(company2);
		imageRepository.save(image21);
		Image image22 = new Image("r4.jpg", "app/images/companies/r4.jpg".getBytes(), "image/jpeg");
		image22.setCompany(company3);
		imageRepository.save(image22);
		Image image23 = new Image("r6.jpg", "app/images/companies/r6.jpg".getBytes(), "image/jpeg");
		image23.setCompany(company4);
		imageRepository.save(image23);
		Image image24 = new Image("r1.jpg", "app/images/companies/r1.jpg".getBytes(), "image/jpeg");
		image24.setCompany(company5);
		imageRepository.save(image24);
		
		
	
		
		User user11 = new User("ivana.unitedforce@gmail.com", "iv", encoder.encode("123"), "Lars", "Urlich", "061-123-456");
		userRepository.save(user11);
		User user12 = new User("james.hatfield@gmail.com", "james", encoder.encode("123"), "James", "Hatfield", "061-456-789");
		userRepository.save(user12);
		User user13 = new User("til.linderman@gmail.com", "til", encoder.encode("123"), "Til", "Linderman", "061-789-123");
		userRepository.save(user13);
		User user14 = new User("lily.aldridge@gmail.com", "lily", encoder.encode("123"), "Lily", "Aldridge", "060-123-456");
		userRepository.save(user14);
		User user15 = new User("alessandra.ambrosio@gmail.com", "alessandra", encoder.encode("123"), "Alessandra", "Ambrosio", "060-456-789");
		userRepository.save(user15);
			
		Image image01 = new Image("woman-1.jpg", "app/images/users/woman-1.jpg".getBytes(), "image/jpeg");
		image01.setUser(user11);
		imageRepository.save(image01);
		Image image02 = new Image("guy-1.jpg", "app/images/users/guy-1.jpg".getBytes(), "image/jpeg");
		image02.setUser(user12);
		imageRepository.save(image02);
		Image image03 = new Image("guy-2.jpg", "app/images/users/guy-2.jpg".getBytes(), "image/jpeg");
		image03.setUser(user13);
		imageRepository.save(image03);
		Image image04 = new Image("woman-2.jpg", "app/images/users/woman-2.jpg".getBytes(), "image/jpeg");
		image04.setUser(user14);
		imageRepository.save(image04);
		Image image05 = new Image("woman-3.jpg", "app/images/users/woman-3.jpg".getBytes(), "image/jpeg");
		image05.setUser(user15);
		imageRepository.save(image05);
		
		User user21 = new User("iva17.igodina@gmail.com", "matthew", encoder.encode("123"), "Matthew", "McConaughey", "065-456-789");
		User user22 = new User("iva17.iigodina@gmail.com", "bradley", encoder.encode("123"), "Bradley", "Cooper", "065-789-123");
		User user23 = new User("iva17.iiigodina@gmail.com", "leonardo", encoder.encode("123"), "Leonardo", "DiCaprio", "063-123-456");
		User user24 = new User("blake.lively@gmail.com", "blake", encoder.encode("123"), "Blake", "Lively", "063-456-789");

		
		Agent agent1 = new Agent(user21, company1);
		agentRepository.save(agent1);
		Agent agent2 = new Agent(user22, company1);
		agentRepository.save(agent2);
		Agent agent3 = new Agent(user23, company2);
		agentRepository.save(agent3);
		Agent agent4 = new Agent(user24, company3);
		agentRepository.save(agent4);
		
		Image image06 = new Image("guy-3.jpg", "app/images/users/guy-3.jpg".getBytes(), "image/jpeg");
		image06.setUser(agent1);
		imageRepository.save(image06);
		Image image07 = new Image("guy-4.jpg", "app/images/users/guy-4.jpg".getBytes(), "image/jpeg");
		image07.setUser(agent2);
		imageRepository.save(image07);
		Image image08 = new Image("woman-3.jpg", "app/images/users/woman-3.jpg".getBytes(), "image/jpeg");
		image08.setUser(agent3);
		imageRepository.save(image08);
		Image image09 = new Image("woman-4.jpg", "app/images/users/woman-4.jpg".getBytes(), "image/jpeg");
		image09.setUser(agent4);
		imageRepository.save(image09);
		
	
		
		HeatingType heatingType1 = new HeatingType("Forced Air");
		heatingTypeRepository.save(heatingType1);
		HeatingType heatingType2 = new HeatingType("Hydronic");
		heatingTypeRepository.save(heatingType2);
		HeatingType heatingType3 = new HeatingType("Geothermal");
		heatingTypeRepository.save(heatingType3);
		HeatingType heatingType4 = new HeatingType("Radiant Heat ");
		heatingTypeRepository.save(heatingType4);
		HeatingType heatingType5 = new HeatingType("Steam Radiant");
		heatingTypeRepository.save(heatingType5);

		
		RealEstateType realEstateType1 = new RealEstateType("APARTMENT");
		realEstateTypeRepository.save(realEstateType1);
		RealEstateType realEstateType2 = new RealEstateType("FLAT");
		realEstateTypeRepository.save(realEstateType2);
		RealEstateType realEstateType3 = new RealEstateType("HOUSE");
		realEstateTypeRepository.save(realEstateType3);
		RealEstateType realEstateType4 = new RealEstateType("PENTHOUSE");
		realEstateTypeRepository.save(realEstateType4);

		AdvertisementType advertisementType1 = new AdvertisementType("SALE");
		advertisementTypeRepository.save(advertisementType1);
		AdvertisementType advertisementType2 = new AdvertisementType("RENT");
		advertisementTypeRepository.save(advertisementType2);
		
		RealEstate realEstate1 = new RealEstate("Trosoban stan", "Trosoban, luksuzno opremljen stan, kod \"Dvanaeste gimnazije\" u ulici "
				+ "Vojvode Stepa.\n" + 
				"Stan se sastoji od predsoblja, dve spavaće sobe, dnevne sobe, kuhinje, kupatila, toaleta i poseduje garažno mesto"
				+ " čija je cena 12000 eura.\n" + 
				"U blizini se nalazi nekoliko fakulteta (Saobraćajni, FON, i FPN), Visoka škola elektrotenike i računarstva,"
				+ " osnovna škola \"Filip Filipović\", studentski dom \"4. APRIL\".",
				257000.0, 100.0, 2, 4, 2, 2015, true, true, location1, realEstateType2, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType1);	
		realEstateRepository.save(realEstate1);
		RealEstate realEstate2 = new RealEstate("Dvosoban stan", "Luksuzno opremljen stan na Vračaru u novogradnji sa velikom garažom.\n" + 
				"\n" + 
				"Stan se sastoji iz predsoblja, dnevne sobe sa velikom kuhinjom i šank trpezarijom, sa izlazom na dve terase,"
				+ " spavaće sobe koja takođe ima izlaz na jednu od terasa, kupatila i garderobera.", 
				190000.0, 75.0, 2, 5, 2, 2015, true, true, location2, realEstateType3, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType1);
		realEstateRepository.save(realEstate2);
		RealEstate realEstate3 = new RealEstate("Troiposoban stan","Moderan i svetao stan u novijoj zgradi na prelepoj lokaciji pogodnoj "
				+ "za aktivan život ali i za odmor. U neposrdenoj okolini parkova, vrtica, osnovnih skola, gimnazija,svih stanica gradskog"
				+ " prevoza, pijaca, biblioteka i pozorista. \nSa slobodnom parking zonom u ulici, u blizini samog centra grada,"
				+ " dobro povezan za uključenjem na auto put. \nU zgradi sa malim brojem stanova. Unutar zgarde nalazi se bašta sa fontanom,"
				+ " zelenom površinom i opremom za odmor i opuštanje.", 
				850.0, 120.0, 3, 3, 2, 2015, true, true, location3, realEstateType4, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);
		realEstateRepository.save(realEstate3);
		RealEstate realEstate4 = new RealEstate("Duplex stan + kabinet", "Penthaus duplex kompletno opremljen modernim nameštajem i najnovijom "
				+ "belom tehnikom. Elegantan dizajn pruža osećaj udobnosti i komfora. Prostire se na dva nivoa.\n" + 
				"Na prvom nivou se nalazi  veliki dnevni boravak, u produžetku se nastavlja trpezarijski deo i kuhinja, "
				+ "sa druge strane je prostrana zastakljena terasa sa garniturom za sedenje.\n" + 
				"Duž cele terase nalaze se klizni prozori, tako da se njihovim pomeranjem dobija otvoren prostor. ",
				1500.0, 150.0, 2, 1, 1, 2015, true, true, location1, realEstateType2, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);	
		realEstateRepository.save(realEstate4);
		RealEstate realEstate5 = new RealEstate("Salonac", "Petosoban salonski stan u zgradi sa najlepšom fasadom u ulici Kralja Petra.\n" + 
				"Zgrada je locirana između ulica Kneza Mihaila i Gospodar Jevremove.\n" + 
				"Stan se nalazi na četvrtom spratu u zgradi od šest spratova, opremljen je, funkcionalan, može da se koristi za stanovanje i za poslovni prostor.",
				1500.0, 150.0, 2, 5, 2, 2015, true, true, location2, realEstateType3, heatingType1, new Date(), new Date(), 48, false, false, agent1, advertisementType2);
		realEstateRepository.save(realEstate5);

		Image image1 = new Image("11.jpg", "app/images/properties/11.jpg".getBytes(), "image/jpeg");
		image1.setRealEstate(realEstate1);
		imageRepository.save(image1);
		Image image2 = new Image("12.jpg", "app/images/properties/12.jpg".getBytes(), "image/jpeg");
		image2.setRealEstate(realEstate1);
		imageRepository.save(image2);
		Image image3 = new Image("13.jpg", "app/images/properties/13.jpg".getBytes(), "image/jpeg");
		image3.setRealEstate(realEstate1);
		imageRepository.save(image3);
		
		Image image5 = new Image("21.jpg", "app/images/properties/21.jpg".getBytes(), "image/jpeg");
		image5.setRealEstate(realEstate2);
		imageRepository.save(image5);
		Image image6 = new Image("22.jpg", "app/images/properties/22.jpg".getBytes(), "image/jpeg");
		image6.setRealEstate(realEstate2);
		imageRepository.save(image6);
		Image image7 = new Image("23.jpg", "app/images/properties/23.jpg".getBytes(), "image/jpeg");
		image7.setRealEstate(realEstate2);
		imageRepository.save(image7);
		
		Image image8 = new Image("31.jpg", "app/images/properties/31.jpg".getBytes(), "image/jpeg");
		image8.setRealEstate(realEstate3);
		imageRepository.save(image8);
		Image image9 = new Image("32.jpg", "app/images/properties/32.jpg".getBytes(), "image/jpeg");
		image9.setRealEstate(realEstate3);
		imageRepository.save(image9);
		Image image10 = new Image("33.jpg", "app/images/properties/33.jpg".getBytes(), "image/jpeg");
		image10.setRealEstate(realEstate3);
		imageRepository.save(image10);
			
		Image image12 = new Image("41.jpg", "app/images/properties/41.jpg".getBytes(), "image/jpeg");
		image12.setRealEstate(realEstate4);
		imageRepository.save(image12);
		Image image13 = new Image("42.jpg", "app/images/properties/42.jpg".getBytes(), "image/jpeg");
		image13.setRealEstate(realEstate4);
		imageRepository.save(image13);
		Image image14 = new Image("43.jpg", "app/images/properties/43.jpg".getBytes(), "image/jpeg");
		image14.setRealEstate(realEstate4);
		imageRepository.save(image14);
			
		Image image16 = new Image("51.jpg", "app/images/properties/51.jpg".getBytes(), "image/jpeg");
		image16.setRealEstate(realEstate5);
		imageRepository.save(image16);
		Image image17 = new Image("52.jpg", "app/images/properties/52.jpg".getBytes(), "image/jpeg");
		image17.setRealEstate(realEstate5);
		imageRepository.save(image17);
		Image image18 = new Image("53.jpg", "app/images/properties/53.jpg".getBytes(), "image/jpeg");
		image18.setRealEstate(realEstate5);
		imageRepository.save(image18);
		
	
		
		IndoorFeature indoorFeature1 = new IndoorFeature("Floorboards");
		indoorFeatureRepository.save(indoorFeature1);
		IndoorFeature indoorFeature2 = new IndoorFeature("Built-in Wardrobes");
		indoorFeatureRepository.save(indoorFeature2);
		IndoorFeature indoorFeature3 = new IndoorFeature("Dishwasher");
		indoorFeatureRepository.save(indoorFeature3);
		IndoorFeature indoorFeature4 = new IndoorFeature("Air Conditioning");
		indoorFeatureRepository.save(indoorFeature4);
		IndoorFeature indoorFeature6 = new IndoorFeature("Indoor Spa");
		indoorFeatureRepository.save(indoorFeature6);
		IndoorFeature indoorFeature7 = new IndoorFeature("Broadband Internet Available");
		indoorFeatureRepository.save(indoorFeature7);
		IndoorFeature indoorFeature8 = new IndoorFeature("Ducted Heating");
		indoorFeatureRepository.save(indoorFeature8);
		IndoorFeature indoorFeature9 = new IndoorFeature("Ducted Cooling");
		indoorFeatureRepository.save(indoorFeature9);
		IndoorFeature indoorFeature10 = new IndoorFeature("Rumpus Room");
		indoorFeatureRepository.save(indoorFeature10);
		IndoorFeature indoorFeature11 = new IndoorFeature("Alarm System");
		indoorFeatureRepository.save(indoorFeature11);
		IndoorFeature indoorFeature13 = new IndoorFeature("Dusted vacum system");
		indoorFeatureRepository.save(indoorFeature13);
		IndoorFeature indoorFeature14 = new IndoorFeature("Open fireplace");
		indoorFeatureRepository.save(indoorFeature14);
		

		RealEstateIndoors realEstateIndoors1 = new RealEstateIndoors(realEstate1, indoorFeature3);
		realEstateIndoorsRepository.save(realEstateIndoors1);
		RealEstateIndoors realEstateIndoors2 = new RealEstateIndoors(realEstate1, indoorFeature2);
		realEstateIndoorsRepository.save(realEstateIndoors2);
		RealEstateIndoors realEstateIndoors3 = new RealEstateIndoors(realEstate1, indoorFeature11);
		realEstateIndoorsRepository.save(realEstateIndoors3);
		RealEstateIndoors realEstateIndoors4 = new RealEstateIndoors(realEstate2, indoorFeature4);
		realEstateIndoorsRepository.save(realEstateIndoors4);
		RealEstateIndoors realEstateIndoors5 = new RealEstateIndoors(realEstate2, indoorFeature1);
		realEstateIndoorsRepository.save(realEstateIndoors5);
		RealEstateIndoors realEstateIndoors6 = new RealEstateIndoors(realEstate2, indoorFeature3);
		realEstateIndoorsRepository.save(realEstateIndoors6);
		RealEstateIndoors realEstateIndoors7 = new RealEstateIndoors(realEstate3, indoorFeature4);
		realEstateIndoorsRepository.save(realEstateIndoors7);
		RealEstateIndoors realEstateIndoors8 = new RealEstateIndoors(realEstate3, indoorFeature2);
		realEstateIndoorsRepository.save(realEstateIndoors8);
		RealEstateIndoors realEstateIndoors9 = new RealEstateIndoors(realEstate4, indoorFeature11);
		realEstateIndoorsRepository.save(realEstateIndoors9);
		RealEstateIndoors realEstateIndoors10 = new RealEstateIndoors(realEstate5, indoorFeature14);
		realEstateIndoorsRepository.save(realEstateIndoors10);
		
		OutdoorFeature outdoorFeature1 = new OutdoorFeature("Secure Parking");
		outdoorFeatureRepository.save(outdoorFeature1);
		OutdoorFeature outdoorFeature2 = new OutdoorFeature("Courtyard");
		outdoorFeatureRepository.save(outdoorFeature2);
		OutdoorFeature outdoorFeature3 = new OutdoorFeature("Shed");
		outdoorFeatureRepository.save(outdoorFeature3);
		OutdoorFeature outdoorFeature4 = new OutdoorFeature("Deck");
		outdoorFeatureRepository.save(outdoorFeature4);
		OutdoorFeature outdoorFeature5 = new OutdoorFeature("Balcony");
		outdoorFeatureRepository.save(outdoorFeature5);
		OutdoorFeature outdoorFeature6 = new OutdoorFeature("Swimming Pool");
		outdoorFeatureRepository.save(outdoorFeature6);
		OutdoorFeature outdoorFeature7 = new OutdoorFeature("Carpot");
		outdoorFeatureRepository.save(outdoorFeature7);
		OutdoorFeature outdoorFeature8 = new OutdoorFeature("Garage");
		outdoorFeatureRepository.save(outdoorFeature8);
		OutdoorFeature outdoorFeature9 = new OutdoorFeature("Tenis court");
		outdoorFeatureRepository.save(outdoorFeature9);
		OutdoorFeature outdoorFeature10 = new OutdoorFeature("Outside spa");
		outdoorFeatureRepository.save(outdoorFeature10);

		RealEstateOutdoors realEstateOutdoors1 = new RealEstateOutdoors(realEstate1, outdoorFeature1);
		realEstateOutdoorsRepository.save(realEstateOutdoors1);
		RealEstateOutdoors realEstateOutdoors2 = new RealEstateOutdoors(realEstate1, outdoorFeature8);
		realEstateOutdoorsRepository.save(realEstateOutdoors2);
		RealEstateOutdoors realEstateOutdoors3 = new RealEstateOutdoors(realEstate2, outdoorFeature5);
		realEstateOutdoorsRepository.save(realEstateOutdoors3);
		RealEstateOutdoors realEstateOutdoors4 = new RealEstateOutdoors(realEstate2, outdoorFeature1);
		realEstateOutdoorsRepository.save(realEstateOutdoors4);
		RealEstateOutdoors realEstateOutdoors5 = new RealEstateOutdoors(realEstate3, outdoorFeature8);
		realEstateOutdoorsRepository.save(realEstateOutdoors5);
		RealEstateOutdoors realEstateOutdoors6 = new RealEstateOutdoors(realEstate3, outdoorFeature10);
		realEstateOutdoorsRepository.save(realEstateOutdoors6);
		

		RealEstateComment realEstateComment1 = new RealEstateComment("Lep stan!", new Date(), realEstate1, user15);
		realEstateCommentRepository.save(realEstateComment1);
		RealEstateComment realEstateComment2 = new RealEstateComment("Veoma lepo!", new Date(), realEstate1, user12);
		realEstateCommentRepository.save(realEstateComment2);
		RealEstateComment realEstateComment3 = new RealEstateComment("Skupo!", new Date(), realEstate1, user13);
		realEstateCommentRepository.save(realEstateComment3);
		RealEstateComment realEstateComment4 = new RealEstateComment("Lepo namesteno.", new Date(), realEstate2, user14);
		realEstateCommentRepository.save(realEstateComment4);
		RealEstateComment realEstateComment5 = new RealEstateComment("Preskupo!", new Date(), realEstate2, user15);
		realEstateCommentRepository.save(realEstateComment5);
	

		RealEstateRating realEstateRating1 = new RealEstateRating(5, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating1);
		RealEstateRating realEstateRating2 = new RealEstateRating(3, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating2);
		RealEstateRating realEstateRating3 = new RealEstateRating(4, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating3);
		RealEstateRating realEstateRating4 = new RealEstateRating(2, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating4);
		RealEstateRating realEstateRating5 = new RealEstateRating(1, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating5);
		RealEstateRating realEstateRating6 = new RealEstateRating(2, new Date(), realEstate1, user15);
		realEstateRatingRepository.save(realEstateRating6);
		
		
	}
	
}
